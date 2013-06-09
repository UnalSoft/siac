package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.entity.Empresa;

/**
 *
 * @author Alexander
 */
public class EmpresaDAO implements ICrudDAO<Empresa, Integer> {

    private EntityManagerFactory entityManagerFactory;

    public EmpresaDAO(String PUName) {

        entityManagerFactory = Persistence.createEntityManagerFactory(PUName);

    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void create(Empresa entity) throws PreexistingEntityException, NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Empresa empresasnit = entity.getEmpresasnit();
            if (empresasnit != null) {
                Integer nitEmpresa = empresasnit.getNit();
                try {
                    empresasnit = entityManager.getReference(empresasnit.getClass(), empresasnit.getNit());
                } catch (EntityNotFoundException e) {
                    throw new NonexistentEntityException("La Empresa con Nit " + nitEmpresa + ", asociada a la empresa que intenta crear, no existe.", e);
                }
                entity.setEmpresasnit(empresasnit);
            }

            entityManager.persist(entity);

            if (empresasnit != null) {
                empresasnit.getEmpresaCollection().add(entity);
                entityManager.merge(empresasnit);
            }

            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            if (find(entity.getNit()) != null) {
                throw new PreexistingEntityException("La empresa con nit " + entity.getNit() + " ya existe.", ex);
            }
            throw ex;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public Empresa find(Integer id) throws EntityNotFoundException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            return entityManager.find(Empresa.class, id);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("La empresa con nit " + id + " no existe.");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    @Override
    public void update(Empresa entity) throws NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();

            Empresa persistentEmpresa = entityManager.find(Empresa.class, entity.getNit());
            Empresa empresasnitOld = persistentEmpresa.getEmpresasnit();
            Empresa empresasnitNew = entity.getEmpresasnit();

            if (empresasnitNew != null) {
                empresasnitNew = entityManager.getReference(empresasnitNew.getClass(), empresasnitNew.getNit());
                entity.setEmpresasnit(empresasnitNew);
            }

            entity = entityManager.merge(entity);

            if (empresasnitOld != null && !empresasnitOld.equals(empresasnitNew)) {
                empresasnitOld.getEmpresaCollection().remove(entity);
                entityManager.merge(empresasnitOld);
            }
            if (empresasnitNew != null && !empresasnitNew.equals(empresasnitOld)) {
                empresasnitNew.getEmpresaCollection().add(entity);
                entityManager.merge(empresasnitNew);
            }

            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            if (entityManager != null && entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
            Integer id = entity.getNit();
            if (find(id) == null) {
                throw new NonexistentEntityException("La empresa con nit " + id + " no existe.");
            }
            throw ex;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException{
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Empresa empresa;
            try {
                empresa = entityManager.getReference(Empresa.class, id);
                empresa.getNit();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("La empresa con id " + id + " no existe.", enfe);
            }
            Empresa empresasnit = empresa.getEmpresasnit();
            if (empresasnit != null) {
                empresasnit.getEmpresaCollection().remove(empresa);
                entityManager.merge(empresasnit);
            }
            entityManager.remove(empresa);
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
    public List<Empresa> getList() {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empresa.class));
            Query q = entityManager.createQuery(cq);
            return q.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    public List<Empresa> findByEnterprise(Integer nit) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            List<Empresa> empresas;
            Query q = entityManager.createQuery("SELECT e FROM Empresa e "
                    + "WHERE e.empresasnit.nit LIKE :nit ")
                    .setParameter("nit", nit.toString());

            empresas = q.getResultList();

            return empresas;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("No hay empresas asociados a la empresa con nit: " + nit.toString());
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    public List<Empresa> findByNameAndEnterprise(String name, Integer nit) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            List<Empresa> empresas;
            Query q = entityManager.createQuery("SELECT e FROM Empresa e "
                    + "WHERE e.nombre LIKE :name "
                    + "AND e.empresasnit.nit LIKE :nit")
                    .setParameter("name", "%" + name + "%")
                    .setParameter("nit", nit.toString());

            empresas = q.getResultList();

            return empresas;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("No hay empresa con nombre: " + name.toString() 
                    + " asociados a la empresa con nit: " + nit.toString());
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    public List<Empresa> findByNitAndEnterprise(Integer nit, Integer nitEnt) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            List<Empresa> empresas;
            Query q = entityManager.createQuery("SELECT e FROM Empresa e "
                    + "WHERE e.nit LIKE :nit "
                    + "AND e.empresasnit.nit LIKE :nitEnt")
                    .setParameter("nit", "%" + nit.toString() + "%")
                    .setParameter("nitEnt", nitEnt.toString());

            empresas = q.getResultList();

            return empresas;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("No hay empresa con nit: " + nit.toString()
                    + " asociados a la empresa con nit: " + nitEnt.toString());
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
}
