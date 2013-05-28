/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
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
    
}
