/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import model.dao.exceptions.NonexistentEntityException;
import model.entity.Version;

/**
 *
 * @author Felipe
 */
public class VersionDAO implements Serializable {


    private EntityManagerFactory entityManagerFactory;

    public VersionDAO(String PUName) {
        
        entityManagerFactory = Persistence.createEntityManagerFactory(PUName);

    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }

    public Version getList() {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            CriteriaQuery cq = entityManager.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Version.class));
            Query q = entityManager.createQuery(cq);
            return (Version)q.getResultList().get(0);
        } finally {
            if (entityManager != null) {
                entityManager.clear();
                entityManager.close();
            }
        }
    }

    public void create(Version entity) {
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            throw ex;
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void removeAll() throws NonexistentEntityException{
        EntityManager entityManager = null;
        try {
            entityManager = getEntityManager();
            entityManager.getTransaction().begin();
            Version version;
            try {
                version = entityManager.getReference(Version.class, getList().getVersion());
            } catch (EntityNotFoundException ex) {
                throw new NonexistentEntityException("La version no existe.", ex);
            }
            entityManager.remove(version);
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
    
}
