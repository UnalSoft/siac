package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.entity.Empresa;

/**
 *
 * @author Alexander
 */
public class EmpresaDAO implements ICrudDAO<Empresa, Integer> {

    private EntityManager entityManager;
    
    public EmpresaDAO(String PUName) {
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PUName);
        this.entityManager = entityManagerFactory.createEntityManager();
        
    }

    @Override
    public void create(Empresa entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Empresa find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Empresa entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Empresa> getList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
