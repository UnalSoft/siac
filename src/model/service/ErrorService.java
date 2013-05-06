
package model.service;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.vo.ErrorVO;

/**
 *
 * @author Zergio
 */
public class ErrorService implements IService<ErrorVO, Integer> {

    private static ErrorService instance;

    private ErrorService() {
    }

    public static synchronized ErrorService getInstance() {
        if (instance == null) {
            instance = new ErrorService();
        }
        return instance;

    }

    @Override
    public void create(ErrorVO vo) throws PreexistingEntityException, NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ErrorVO find(Integer id) throws EntityNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(ErrorVO vo) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ErrorVO> getList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
