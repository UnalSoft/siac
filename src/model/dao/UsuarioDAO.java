package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import model.dao.exceptions.DataBaseException;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.entity.Empresa;
import model.entity.Usuario;

/**
 *
 * @author Alexander
 */
public class UsuarioDAO implements ICrudDAO<Usuario, Long> {

    private EntityManagerFactory entityManagerFactory;

    public UsuarioDAO(String PUName) {

        entityManagerFactory = Persistence.createEntityManagerFactory(PUName);

    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void create(Usuario entity) throws PreexistingEntityException, NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Empresa empresasNIT = entity.getEmpresasNIT();
            if (empresasNIT != null) {
                Integer nitEmpresa = empresasNIT.getNit();
                try {
                    empresasNIT = entityManager.getReference(empresasNIT.getClass(), empresasNIT.getNit());
                } catch (EntityNotFoundException e) {
                    throw new NonexistentEntityException("La Empresa con Nit " + nitEmpresa + ", asociada al usuario que intenta crear, no existe.", e);
                }
                entity.setEmpresasNIT(empresasNIT);
            }

            entityManager.persist(entity);

            if (empresasNIT != null) {
                empresasNIT.getUsuarioCollection().add(entity);
                entityManager.merge(empresasNIT);
            }

            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (find(entity.getDni()) != null) {
                throw new PreexistingEntityException("El Usuario " + entity.getNombre() + " ya existe.", ex);
            }
            throw ex;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public Usuario find(Long id) throws EntityNotFoundException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            return entityManager.find(Usuario.class, id);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("El usuario con id " + id + " no existe.");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    @Override
    public void update(Usuario entity) throws NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();

            Usuario persistentUsuario = entityManager.find(Usuario.class, entity.getDni());
            Empresa empresasNITOld = persistentUsuario.getEmpresasNIT();
            Empresa empresasNITNew = entity.getEmpresasNIT();

            if (empresasNITNew != null) {
                Integer nitEmpresa = empresasNITNew.getNit();
                try {
                    empresasNITNew = entityManager.getReference(empresasNITNew.getClass(), empresasNITNew.getNit());
                } catch (EntityNotFoundException e) {
                    throw new NonexistentEntityException("La Empresa con Nit " + nitEmpresa + " no existe.", e);
                }
                entity.setEmpresasNIT(empresasNITNew);
            }

            entity = entityManager.merge(entity);
            if (empresasNITOld != null && !empresasNITOld.equals(empresasNITNew)) {
                empresasNITOld.getUsuarioCollection().remove(entity);
                entityManager.merge(empresasNITOld);
            }
            if (empresasNITNew != null && !empresasNITNew.equals(empresasNITOld)) {
                empresasNITNew.getUsuarioCollection().add(entity);
                entityManager.merge(empresasNITNew);
            }

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
            Long id = entity.getDni();
            if (find(id) == null) {
                throw new NonexistentEntityException("El usuario con id " + id + " no existe.", e);
            }
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    @Override
    public void delete(Long id) throws NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Usuario usuario = null;
            try {
                usuario = entityManager.getReference(Usuario.class, id);
            } catch (EntityNotFoundException e) {
                throw new NonexistentEntityException("El usuario con id " + id + " no existe.", e);
            }
            Empresa empresasNIT = usuario.getEmpresasNIT();
            if (empresasNIT != null) {
                empresasNIT.getUsuarioCollection().remove(usuario);
                entityManager.merge(empresasNIT);
            }
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    @Override
    public List<Usuario> getList() {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
            Query q = entityManager.createQuery(cq);
            return q.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    public Usuario login(Usuario entity) throws DataBaseException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            Usuario usuario;
            Query q = entityManager.createQuery("SELECT u FROM Usuario u "
                    + "WHERE u.nombreDeUsuario LIKE :username "
                    + "AND u.clave LIKE :password")
                    .setParameter("username", entity.getNombreDeUsuario())
                    .setParameter("password", entity.getClave());
            try {
                usuario = (Usuario) q.getSingleResult();
            } catch (NoResultException e) {
                usuario = null;
            }
            return usuario;
        } catch (Exception e) {
            throw new DataBaseException("Error de Conexion a la Base de Datos", e);
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
}
