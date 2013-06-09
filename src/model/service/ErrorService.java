package model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import model.dao.DAOFactory;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.entity.Error;
import model.entity.Usuario;
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
        Error entity = new Error();
        entity.setError(vo.getError());
        entity.setId(vo.getId());
        entity.setInterfaz(vo.getInterfaz());

        Usuario usuario = DAOFactory.getInstance().getUsuarioDAO().find(vo.getUsuariosDNI());
        usuario.getErrorCollection().add(entity);
        entity.setUsuariosDNI(usuario);

        DAOFactory.getInstance().getErrorDAO().create(entity);
    }

    @Override
    public ErrorVO find(Integer id) throws EntityNotFoundException {
        Error error = DAOFactory.getInstance().getErrorDAO().find(id);
        if (error != null) {
            return error.toVO();
        } else {
            return null;
        }
    }

    @Override
    public void update(ErrorVO vo) throws NonexistentEntityException {
        Error entity = DAOFactory.getInstance().getErrorDAO().find(vo.getId());
        entity.setError(vo.getError());
        entity.setInterfaz(vo.getInterfaz());
        DAOFactory.getInstance().getErrorDAO().update(entity);
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException {
        DAOFactory.getInstance().getErrorDAO().delete(id);
    }

    @Override
    public List<ErrorVO> getList() {
        List<ErrorVO> list = new ArrayList<ErrorVO>();
        for (Error error : DAOFactory.getInstance().getErrorDAO().getList()) {
            list.add((error).toVO());
        }
        Collections.sort(list, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                ErrorVO p1 = (ErrorVO) o1;
                ErrorVO p2 = (ErrorVO) o2;
                return p1.getId().compareTo(p2.getId());
            }
        });
        return list;
    }

    @Override
    public void removeAll() throws NonexistentEntityException {
        for (Error error : DAOFactory.getInstance().getErrorDAO().getList()){
            DAOFactory.getInstance().getErrorDAO().delete(error.getId());
        }
    }
}
