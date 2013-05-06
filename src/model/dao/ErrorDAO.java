package model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.entity.Error;

/**
 *
 * @author Alexander
 */
public class ErrorDAO implements ICrudDAO<Error, Integer> {

    private EntityManagerFactory entityManagerFactory;

    public ErrorDAO(String PUName) {

        entityManagerFactory = Persistence.createEntityManagerFactory(PUName);

    }

    @Override
    public void create(Error entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Error find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Error entity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Error> getList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
