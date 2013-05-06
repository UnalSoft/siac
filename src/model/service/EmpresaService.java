/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.vo.EmpresaVO;

/**
 *
 * @author Zergio
 */
public class EmpresaService implements IService<EmpresaVO, Integer> {

    private static EmpresaService instance;

    private EmpresaService() {
    }

    public static synchronized EmpresaService getInstance() {
        if (instance == null) {
            instance = new EmpresaService();
        }
        return instance;

    }

    @Override
    public void create(EmpresaVO vo) throws PreexistingEntityException, NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public EmpresaVO find(Integer id) throws EntityNotFoundException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(EmpresaVO vo) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<EmpresaVO> getList() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
