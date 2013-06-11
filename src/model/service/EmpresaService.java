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
import model.dao.exceptions.InvalidAttributeException;
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
    private final static int MIN_LENGTH_NAME = 3;
    private final static int MAX_LENGTH_NAME = 80;
    

    private EmpresaService() {
    }

    public static synchronized EmpresaService getInstance() {
        if (instance == null) {
            instance = new EmpresaService();
        }
        return instance;

    }

    @Override
    public void create(EmpresaVO vo) throws PreexistingEntityException, NonexistentEntityException, RequiredAttributeException, InsufficientPermissionsException, InvalidAttributeException {
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

    public List<EmpresaVO> findByEnterprise(Integer nit) throws EntityNotFoundException {
        //TODO validar permisos
        List<EmpresaVO> list = new ArrayList<>();
        for (Empresa empresa : DAOFactory.getInstance().getEmpresaDAO().findByEnterprise(nit)) {
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

    public List<EmpresaVO> findByNameAndEnterprise(String name, Integer nit) throws EntityNotFoundException {
        //TODO validar permisos
        List<EmpresaVO> list = new ArrayList<>();
        for (Empresa empresa : DAOFactory.getInstance().getEmpresaDAO().findByNameAndEnterprise(name, nit)) {
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

    public List<EmpresaVO> findByNitAndEnterprise(Integer nit, Integer nitEnt) throws EntityNotFoundException {
        //TODO validar permisos
        List<EmpresaVO> list = new ArrayList<>();
        for (Empresa empresa : DAOFactory.getInstance().getEmpresaDAO().findByNitAndEnterprise(nit, nitEnt)) {
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

    @Override
    public void update(EmpresaVO vo) throws NonexistentEntityException, RequiredAttributeException, InsufficientPermissionsException, InvalidAttributeException {
        if (validarCampos(vo)) {
            if (havePermissions(vo)) {
                Empresa entity = DAOFactory.getInstance().getEmpresaDAO().find(vo.getNit());
                entity.setDireccion(vo.getDireccion());
                entity.setNivel(vo.getNivel());
                entity.setNombre(vo.getNombre());
                entity.setTelefono(vo.getTelefono());
                DAOFactory.getInstance().getEmpresaDAO().update(entity);
            } else {
                throw new InsufficientPermissionsException("El Usuario no posee los permisos suficientes para realizar la operación");
            }
        }

    }

    @Override
    public void delete(Integer id) throws NonexistentEntityException, InsufficientPermissionsException {
        EmpresaVO vo = DAOFactory.getInstance().getEmpresaDAO().find(id).toVO();
        if (havePermissions(vo)) {
            DAOFactory.getInstance().getEmpresaDAO().delete(id);
        } else {
            throw new InsufficientPermissionsException("El Usuario no posee los permisos suficientes para realizar la operación");
        }
    }

    @Override
    public List<EmpresaVO> getList() {
        List<EmpresaVO> list = new ArrayList<>();
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

    public boolean validarCampos(EmpresaVO vo) throws RequiredAttributeException, InvalidAttributeException {
        if (vo.getNit() == null) {
            throw new RequiredAttributeException("El atributo Nit es requerido");
        }
        if (vo.getNombre() == null || vo.getNombre().isEmpty()) {
            throw new RequiredAttributeException("El atributo Nombre es requerido");
        } else if (vo.getNombre().length() < MIN_LENGTH_NAME || vo.getNombre().length() > MAX_LENGTH_NAME) {
            throw new InvalidAttributeException("La longitud del atributo Nombre no está en el rango permitido ("
                    + MIN_LENGTH_NAME + " - " + MAX_LENGTH_NAME + ")");
        } else if (!vo.getNombre().matches("([_A-Za-záéíóúAÉÍÓÚÑñ-]*((\\s)*[_A-Za-záéíóúAÉÍÓÚÑñ-](\\.)*+)*)")) {
            throw new InvalidAttributeException("El atributo Nombre contiene caracteres inválidos");
        }
        if (vo.getNivel() == null) {
            throw new RequiredAttributeException("El atributo Nivel es requerido");
        }
        if (vo.getDireccion() != null && !vo.getDireccion().isEmpty()) {
            if (!vo.getDireccion().matches("[\\w\\s-#]*")) {
                throw new InvalidAttributeException("El atributo Direccion contiene caracteres inválidos");
            }
        }
        if (vo.getTelefono() != null && !vo.getTelefono().isEmpty()) {
            if (!vo.getTelefono().matches("([0-9-\\s])*")) {
                throw new InvalidAttributeException("El atributo Telefono contiene caracteres inválidos");
            }
        }
        return true;
    }

    /**
     * Metodo que revisa que el usuario activo tenga permisos para ejecutar operaciones sobre la discutida empresa
     *
     * @param vo Empresa a la cual se hará la operación
     * @return
     */
    private boolean havePermissions(EmpresaVO vo) {
        UsuarioVO usuarioActivo = LoginController.usuarioActivo;
        Empresa empresaUsuarioActivo = DAOFactory.getInstance().getEmpresaDAO().find(usuarioActivo.getEmpresasNIT());
        return ((usuarioActivo.getRol().equals(Rol.PROVEEDOR_DE_TI))
                ||(usuarioActivo.getRol().equals(Rol.PROVEEDOR_DE_TI) && vo.getNivel().equals(Nivel.DISTRIBUIDORA))
                || (usuarioActivo.getRol().equals(Rol.PRIMER_ADMINISTRADOR)
                && ((empresaUsuarioActivo.getNivel().equals(Nivel.DISTRIBUIDORA) && vo.getNivel().equals(Nivel.SUB_DISTRIBUIDORA))
                || (empresaUsuarioActivo.getNivel().equals(Nivel.SUB_DISTRIBUIDORA) && vo.getNivel().equals(Nivel.CANAL))
                || (empresaUsuarioActivo.getNivel().equals(Nivel.CANAL) && vo.getNivel().equals(Nivel.PUNTO_DE_VENTA)))));
    }

    @Override
    public void removeAll() throws NonexistentEntityException {
        for (Empresa empresa : DAOFactory.getInstance().getEmpresaDAO().getList()){
            DAOFactory.getInstance().getEmpresaDAO().delete(empresa.getNit());
        }
    }
}
