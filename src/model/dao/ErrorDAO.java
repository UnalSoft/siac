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
import model.entity.Error;
import model.entity.Usuario;

/**
 *
 * @author Alexander
 */
public class ErrorDAO implements ICrudDAO<Error, Integer> {

    private EntityManagerFactory entityManagerFactory;

    public ErrorDAO(String PUName) {

        entityManagerFactory = Persistence.createEntityManagerFactory(PUName);

    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    @Override
    public void create(Error entity) throws PreexistingEntityException, NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Usuario usuariosDNI = entity.getUsuariosDNI();
            if (usuariosDNI != null) {
                Long dni = usuariosDNI.getDni();
                try {
                    usuariosDNI = entityManager.getReference(usuariosDNI.getClass(), usuariosDNI.getDni());
                } catch (EntityNotFoundException e) {
                    throw new NonexistentEntityException("El usuario con dni " + dni + ", asociado al error que intenta crear, no existe.", e);
                }
                entity.setUsuariosDNI(usuariosDNI);
            }
            entityManager.persist(entity);
            if (usuariosDNI != null) {
                usuariosDNI.getErrorCollection().add(entity);
                entityManager.merge(usuariosDNI);
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (find(entity.getId()) != null) {
                throw new PreexistingEntityException("El Error " + entity.getError() + " ya existe.", ex);
            }
            throw ex;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public Error find(Integer id) throws EntityNotFoundException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            return entityManager.find(Error.class, id);
        } catch (EntityNotFoundException ex) {
            throw new EntityNotFoundException("El error con id " + id + " no existe.");
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    @Override
    public void update(Error entity) throws NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Error persistentError = entityManager.find(Error.class, entity.getId());
            Usuario usuariosDNIOld = persistentError.getUsuariosDNI();
            Usuario usuariosDNINew = entity.getUsuariosDNI();
            if (usuariosDNINew != null) {
                usuariosDNINew = entityManager.getReference(usuariosDNINew.getClass(), usuariosDNINew.getDni());
                entity.setUsuariosDNI(usuariosDNINew);
            }
            entity = entityManager.merge(entity);
            if (usuariosDNIOld != null && !usuariosDNIOld.equals(usuariosDNINew)) {
                usuariosDNIOld.getErrorCollection().remove(entity);
                usuariosDNIOld = entityManager.merge(usuariosDNIOld);
            }
            if (usuariosDNINew != null && !usuariosDNINew.equals(usuariosDNIOld)) {
                usuariosDNINew.getErrorCollection().add(entity);
                entityManager.merge(usuariosDNINew);
            }
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager != null && entityManager.getTransaction() != null) {
                entityManager.getTransaction().rollback();
            }
            Integer id = entity.getId();
            if (find(id) == null) {
                throw new NonexistentEntityException("El error con id " + id + " no existe.", ex);
            }
            throw ex;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Error error;
            try {
                error = entityManager.getReference(Error.class, id);
                error.getId();
            } catch (EntityNotFoundException ex) {
                throw new NonexistentEntityException("El error con id " + id + " no existe.", ex);
            }
            Usuario usuariosDNI = error.getUsuariosDNI();
            if (usuariosDNI != null) {
                usuariosDNI.getErrorCollection().remove(error);
                entityManager.merge(usuariosDNI);
            }
            entityManager.remove(error);
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
    public List<Error> getList() {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Error.class));
            Query q = entityManager.createQuery(cq);
            return q.getResultList();
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }
}
