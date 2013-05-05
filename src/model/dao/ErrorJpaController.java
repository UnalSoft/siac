/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.entity.Error;
import model.entity.Usuario;

/**
 *
 * @author Felipe
 */
public class ErrorJpaController implements Serializable {

    public ErrorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Error error) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuariosDNI = error.getUsuariosDNI();
            if (usuariosDNI != null) {
                usuariosDNI = em.getReference(usuariosDNI.getClass(), usuariosDNI.getDni());
                error.setUsuariosDNI(usuariosDNI);
            }
            em.persist(error);
            if (usuariosDNI != null) {
                usuariosDNI.getErrorCollection().add(error);
                usuariosDNI = em.merge(usuariosDNI);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findError(error.getId()) != null) {
                throw new PreexistingEntityException("Error " + error + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Error error) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Error persistentError = em.find(Error.class, error.getId());
            Usuario usuariosDNIOld = persistentError.getUsuariosDNI();
            Usuario usuariosDNINew = error.getUsuariosDNI();
            if (usuariosDNINew != null) {
                usuariosDNINew = em.getReference(usuariosDNINew.getClass(), usuariosDNINew.getDni());
                error.setUsuariosDNI(usuariosDNINew);
            }
            error = em.merge(error);
            if (usuariosDNIOld != null && !usuariosDNIOld.equals(usuariosDNINew)) {
                usuariosDNIOld.getErrorCollection().remove(error);
                usuariosDNIOld = em.merge(usuariosDNIOld);
            }
            if (usuariosDNINew != null && !usuariosDNINew.equals(usuariosDNIOld)) {
                usuariosDNINew.getErrorCollection().add(error);
                usuariosDNINew = em.merge(usuariosDNINew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = error.getId();
                if (findError(id) == null) {
                    throw new NonexistentEntityException("The error with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Error error;
            try {
                error = em.getReference(Error.class, id);
                error.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The error with id " + id + " no longer exists.", enfe);
            }
            Usuario usuariosDNI = error.getUsuariosDNI();
            if (usuariosDNI != null) {
                usuariosDNI.getErrorCollection().remove(error);
                usuariosDNI = em.merge(usuariosDNI);
            }
            em.remove(error);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Error> findErrorEntities() {
        return findErrorEntities(true, -1, -1);
    }

    public List<Error> findErrorEntities(int maxResults, int firstResult) {
        return findErrorEntities(false, maxResults, firstResult);
    }

    private List<Error> findErrorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Error.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Error findError(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Error.class, id);
        } finally {
            em.close();
        }
    }

    public int getErrorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Error> rt = cq.from(Error.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
