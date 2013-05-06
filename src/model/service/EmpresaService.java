/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import java.util.*;
import javax.persistence.EntityNotFoundException;
import model.dao.DAOFactory;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.entity.Empresa;
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
        Empresa entity = new Empresa();
        entity.setDireccion(vo.getDireccion());
        entity.setNit(vo.getNit());
        entity.setNivel(vo.getNivel());
        entity.setNombre(vo.getNombre());
        entity.setTelefono(vo.getTelefono());

        Empresa empresa = DAOFactory.getInstance().getEmpresaDAO().find(vo.getEmpresasnit());
        empresa.getEmpresaCollection().add(entity);
        entity.setEmpresasnit(empresa);

        entity.setEmpresaCollection((Collection) vo.getEmpresaList());
        entity.setUsuarioCollection((Collection) vo.getUsuarioList());

        DAOFactory.getInstance().getEmpresaDAO().create(entity);

    }

    @Override
    public EmpresaVO find(Integer id) throws EntityNotFoundException {
        Empresa Empresa = DAOFactory.getInstance().getEmpresaDAO().find(id);
        if (Empresa != null) {
            return Empresa.toVO();
        } else {
            return null;
        }
    }

    @Override
    public void update(EmpresaVO vo) throws NonexistentEntityException {
        Empresa entity = DAOFactory.getInstance().getEmpresaDAO().find(vo.getNit());
        entity.setDireccion(vo.getDireccion());
        entity.setNivel(vo.getNivel());
        entity.setNombre(vo.getNombre());
        entity.setTelefono(vo.getTelefono());
        DAOFactory.getInstance().getEmpresaDAO().update(entity);


    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<EmpresaVO> getList() {
        List<EmpresaVO> list = new ArrayList<EmpresaVO>();
        for (Empresa empresa : DAOFactory.getInstance().getEmpresaDAO().getList()) {
            list.add((empresa).toVO());
        }
        Collections.sort(list, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                EmpresaVO p1 = (EmpresaVO) o1;
                EmpresaVO p2 = (EmpresaVO) o2;
                return p1.getNit().compareTo(p2.getNit());
            }
        });
        return list;
    }
}
