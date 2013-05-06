package model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;

/**
 *
 * @author Alexander
 */
public interface ICrudDAO<E, ID extends Serializable> {
    
    void create(E entity) throws PreexistingEntityException;

    E find(ID id) throws EntityNotFoundException;

    void update(E entity) throws NonexistentEntityException;

    void delete(ID id) throws NonexistentEntityException;

    List<E> getList();
}
