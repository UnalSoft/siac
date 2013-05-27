/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model.service;

import controller.LoginController;
import java.util.*;
import javax.persistence.EntityNotFoundException;
import model.dao.DAOFactory;
import model.dao.exceptions.InsufficientPermissionsException;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.dao.exceptions.RequiredAttributeException;
import model.entity.Empresa;
import model.entity.Nivel;
import model.entity.Rol;
import model.vo.EmpresaVO;
import model.vo.UsuarioVO;

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
    public void create(EmpresaVO vo) throws PreexistingEntityException, NonexistentEntityException, RequiredAttributeException, InsufficientPermissionsException {
        if (validarCampos(vo)) {            
            if (havePermissions(vo)) {
                Empresa entity = new Empresa();
                entity.setDireccion(vo.getDireccion());
                entity.setNit(vo.getNit());
                entity.setNivel(vo.getNivel());
                entity.setNombre(vo.getNombre());
                entity.setTelefono(vo.getTelefono());
                
                if (vo.getEmpresasnit() != null) {
                    Empresa empresa = DAOFactory.getInstance().getEmpresaDAO().find(vo.getEmpresasnit());
                    empresa.getEmpresaCollection().add(entity);
                    entity.setEmpresasnit(empresa);
                }
                
                entity.setEmpresaCollection((Collection) vo.getEmpresaList());
                entity.setUsuarioCollection((Collection) vo.getUsuarioList());
                
                DAOFactory.getInstance().getEmpresaDAO().create(entity);
            } else {
                throw new InsufficientPermissionsException("El Usuario no posee los permisos suficientes para realizar la operación");
            }
        }
    }

    @Override
    public EmpresaVO find(Integer id) throws EntityNotFoundException {
        //TODO validar permisos
        Empresa Empresa = DAOFactory.getInstance().getEmpresaDAO().find(id);
        if (Empresa != null) {
            return Empresa.toVO();
        } else {
            return null;
        }
    }
    
    public EmpresaVO findByEnterprise(Integer nit) throws EntityNotFoundException {
        //TODO validar permisos
        Empresa Empresa = DAOFactory.getInstance().getEmpresaDAO().findByEnterprise(nit);
        if (Empresa != null) {
            return Empresa.toVO();
        } else {
            return null;
        }
    }
    
    public EmpresaVO findByNameAndEnterprise(String name, Integer nit) throws EntityNotFoundException {
        //TODO validar permisos
        Empresa Empresa = DAOFactory.getInstance().getEmpresaDAO().findByNameAndEnterprise(name, nit);
        if (Empresa != null) {
            return Empresa.toVO();
        } else {
            return null;
        }
    }
    
    public EmpresaVO findByNitAndEnterprise(Integer nit, Integer nitEnt) throws EntityNotFoundException {
        //TODO validar permisos
        Empresa Empresa = DAOFactory.getInstance().getEmpresaDAO().findByNitAndEnterprise(nit, nitEnt);
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
        DAOFactory.getInstance().getEmpresaDAO().delete(id);
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

    public boolean validarCampos(EmpresaVO vo) throws RequiredAttributeException {
        if (vo.getNit() == null) {
            throw new RequiredAttributeException("El atributo Nit es requerido");
        }
        if (vo.getNombre() == null || vo.getNombre().isEmpty()) {
            throw new RequiredAttributeException("El atributo Nombre es requerido");
        }
        if (vo.getNivel() == null) {
            throw new RequiredAttributeException("El atributo Nivel es requerido");
        }
        return true;
    }
    
    /**
     * Metodo que revisa que el usuario activo tenga permisos para ejecutar operaciones
     * sobre la siscutida empresa
     * 
     * @param vo Empresa a la cual se hará la operación
     * @return 
     */
    private boolean havePermissions(EmpresaVO vo) {
        UsuarioVO usuarioActivo = LoginController.usuarioActivo; 
            Empresa empresaUsuarioActivo = DAOFactory.getInstance().getEmpresaDAO().find(usuarioActivo.getEmpresasNIT());
            return ((usuarioActivo.getRol().equals(Rol.PROVEEDOR_DE_TI) && vo.getNivel().equals(Nivel.DISTRIBUIDORA)) 
                    || (usuarioActivo.getRol().equals(Rol.PRIMER_ADMINISTRADOR) 
                        && ((empresaUsuarioActivo.getNivel().equals(Nivel.DISTRIBUIDORA) && vo.getNivel().equals(Nivel.SUB_DISTRIBUIDORA))
                            || (empresaUsuarioActivo.getNivel().equals(Nivel.SUB_DISTRIBUIDORA) && vo.getNivel().equals(Nivel.CANAL))
                            || (empresaUsuarioActivo.getNivel().equals(Nivel.CANAL) && vo.getNivel().equals(Nivel.PUNTO_DE_VENTA)))));
    }
}
