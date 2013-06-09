package model.service;

import controller.LoginController;
import java.util.*;
import javax.persistence.EntityNotFoundException;
import model.dao.DAOFactory;
import model.dao.exceptions.DataBaseException;
import model.dao.exceptions.InsufficientPermissionsException;
import model.dao.exceptions.InvalidAttributeException;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.dao.exceptions.RequiredAttributeException;
import model.entity.Empresa;
import model.entity.Nivel;
import model.entity.Rol;
import model.entity.Usuario;
import model.vo.UsuarioVO;
import util.Hash;

/**
 *
 * @author Zergio
 */
public class UsuarioService implements IService<UsuarioVO, Long> {

    private static UsuarioService instance;
    private final static int MIN_LENGTH_NAME = 3;
    private final static int MAX_LENGTH_NAME = 80;
    private final static int MIN_LENGTH_PASSWD = 5;
    private final static int MAX_LENGTH_PASSWD = 20;
    private final static int MAX_LENGTH_USERNAME = 20;
    private final static long MIN_DNI = 100000;
    private final static long MAX_DNI = Long.MAX_VALUE;

    private UsuarioService() {
    }

    public static synchronized UsuarioService getInstance() {
        if (instance == null) {
            instance = new UsuarioService();
        }
        return instance;
    }

    @Override
    public void create(UsuarioVO vo) throws PreexistingEntityException, NonexistentEntityException, RequiredAttributeException, InsufficientPermissionsException, InvalidAttributeException {
        if (validarCampos(vo)) {
            if (havePermissions(vo)) {
                Usuario entity = new Usuario();
                entity.setClave(Hash.hashMD5(vo.getClave()));
                entity.setCorreo(vo.getCorreo());
                entity.setDni(vo.getDni());
                entity.setNombre(vo.getNombre());
                entity.setNombreDeUsuario(vo.getNombreDeUsuario());
                entity.setRol(vo.getRol());

                entity.setErrorCollection((Collection) vo.getErrorList());

                Empresa empresa = DAOFactory.getInstance().getEmpresaDAO().find(vo.getEmpresasNIT());
                empresa.getUsuarioCollection().add(entity);
                entity.setEmpresasNIT(empresa);

                DAOFactory.getInstance().getUsuarioDAO().create(entity);
            } else {
                throw new InsufficientPermissionsException("El Usuario no posee los permisos suficientes para realizar la operación");
            }
        }
    }

    @Override
    public UsuarioVO find(Long id) throws EntityNotFoundException {
        //TODO validar permisos 
        Usuario usuario = DAOFactory.getInstance().getUsuarioDAO().find(id);
        if (usuario != null) {
            return usuario.toVO();
        } else {
            return null;
        }
    }

    public List<UsuarioVO> findByEnterprise(Integer nit) throws EntityNotFoundException {
        //TODO validar permisos
        List<UsuarioVO> list = new ArrayList<>();
        for (Usuario usuario : DAOFactory.getInstance().getUsuarioDAO().findByEnterprise(nit)) {
            list.add((usuario).toVO());
        }
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                UsuarioVO p1 = (UsuarioVO) o1;
                UsuarioVO p2 = (UsuarioVO) o2;
                return p1.getDni().compareTo(p2.getDni());
            }
        });
        return list;
    }

    public List<UsuarioVO> findByNameAndEnterprise(String name, Integer nit) throws EntityNotFoundException {
        //TODO validar permisos
        List<UsuarioVO> list = new ArrayList<>();
        for (Usuario usuario : DAOFactory.getInstance().getUsuarioDAO().findByNameAndEnterprise(name, nit)) {
            list.add((usuario).toVO());
        }
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                UsuarioVO p1 = (UsuarioVO) o1;
                UsuarioVO p2 = (UsuarioVO) o2;
                return p1.getDni().compareTo(p2.getDni());
            }
        });
        return list;
    }

    public List<UsuarioVO> findByDNIAndEnterprise(Long dni, Integer nit) throws EntityNotFoundException {
        //TODO validar permisos
        List<UsuarioVO> list = new ArrayList<>();
        for (Usuario usuario : DAOFactory.getInstance().getUsuarioDAO().findByDNIAndEnterprise(dni, nit)) {
            list.add((usuario).toVO());
        }
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                UsuarioVO p1 = (UsuarioVO) o1;
                UsuarioVO p2 = (UsuarioVO) o2;
                return p1.getDni().compareTo(p2.getDni());
            }
        });
        return list;
    }

    @Override
    public void update(UsuarioVO vo) throws NonexistentEntityException, RequiredAttributeException, InsufficientPermissionsException, InvalidAttributeException {
        if (validarCamposModificar(vo)) {
            if (havePermissions(vo)) {
                Usuario entity = DAOFactory.getInstance().getUsuarioDAO().find(vo.getDni());
                entity.setCorreo(vo.getCorreo());
                entity.setNombre(vo.getNombre());
                entity.setNombreDeUsuario(vo.getNombreDeUsuario());
                entity.setRol(vo.getRol());
                //Esto es solo para la recuperacion de la copia de seguridad
                if (vo.getClave() != null){
                    entity.setClave(vo.getClave());
                }
                DAOFactory.getInstance().getUsuarioDAO().update(entity);
            } else {
                throw new InsufficientPermissionsException("El Usuario no posee los permisos suficientes para realizar la operación");
            }
        }
    }

    @Override
    public void delete(Long id) throws NonexistentEntityException, InsufficientPermissionsException {
        UsuarioVO vo = DAOFactory.getInstance().getUsuarioDAO().find(id).toVO();
        if (havePermissions(vo)) {
            DAOFactory.getInstance().getUsuarioDAO().delete(id);
        } else {
            throw new InsufficientPermissionsException("El Usuario no posee los permisos suficientes para realizar la operación");
        }
    }

    @Override
    public List<UsuarioVO> getList() {
        //TODO validar permisos
        List<UsuarioVO> list = new ArrayList<UsuarioVO>();
        for (Usuario usuario : DAOFactory.getInstance().getUsuarioDAO().getList()) {
            list.add((usuario).toVO());
        }
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                UsuarioVO p1 = (UsuarioVO) o1;
                UsuarioVO p2 = (UsuarioVO) o2;
                return p1.getDni().compareTo(p2.getDni());
            }
        });
        return list;
    }

    public UsuarioVO login(UsuarioVO vo) throws DataBaseException {
        Usuario entity = new Usuario();
        entity.setNombreDeUsuario(vo.getNombreDeUsuario());
        entity.setClave(Hash.hashMD5(vo.getClave()));

        Usuario usuario = DAOFactory.getInstance().getUsuarioDAO().login(entity);
        return usuario != null ? usuario.toVO() : null;

    }

    public boolean validarCampos(UsuarioVO vo) throws RequiredAttributeException, InvalidAttributeException {
        //Validar DNI
        if (vo.getDni() == null) {
            throw new RequiredAttributeException("El atributo DNI es requerido");
        } else if (vo.getDni() < MIN_DNI || vo.getDni() > MAX_DNI) {
            throw new InvalidAttributeException("El atributo DNI no está en el rango permitido");
        }
        //Validar Nombre
        if (vo.getNombre() == null || vo.getNombre().isEmpty()) {
            throw new RequiredAttributeException("El atributo Nombre es requerido");
        } else if (vo.getNombre().length() < MIN_LENGTH_NAME || vo.getNombre().length() > MAX_LENGTH_NAME) {
            throw new InvalidAttributeException("La longitud del atributo Nombre no está en el rango permitido (" 
                    + MIN_LENGTH_NAME + " - " + MAX_LENGTH_NAME + ")");
        } else if (!vo.getNombre().matches("([_A-Za-záéíóúAÉÍÓÚÑñ-]*(\\s[_A-Za-záéíóúAÉÍÓÚÑñ-]+)*)")) {
            throw new InvalidAttributeException("El atributo Nombre contiene caracteres inválidos"); 
        }
        //Validar Nombre de Usuario
        if (vo.getNombreDeUsuario() == null || vo.getNombreDeUsuario().isEmpty()) {
            throw new RequiredAttributeException("El atributo Nombre de Usuario es requerido");
        } else if (vo.getNombreDeUsuario().length() > MAX_LENGTH_USERNAME) {
            throw new InvalidAttributeException("El atributo Nombre de Usuario debe tener una longitud menor a " + MAX_LENGTH_USERNAME);
        } else if (!vo.getNombreDeUsuario().matches("[_A-Za-z0-9-]*")) {
            throw new InvalidAttributeException("El atributo Nombre de Usuario contiene caracteres inválidos"); 
        }
        //Validar Clave
        if (vo.getClave() == null || vo.getClave().isEmpty()) {
            throw new RequiredAttributeException("El atributo Contraseña es requerido");
        } else if (vo.getClave().length() < MIN_LENGTH_PASSWD || vo.getClave().length() > MAX_LENGTH_PASSWD) {
            throw new InvalidAttributeException("La longitud del atributo Contraseña no está en el rango permitido (" 
                    + MIN_LENGTH_PASSWD + " - " + MAX_LENGTH_PASSWD + ")");
        } else if (!vo.getClave().matches("[_A-Za-z0-9-]*")) {
            throw new InvalidAttributeException("El atributo Contraseña contiene caracteres inválidos"); 
        }
        //Validar Correo
        if (vo.getCorreo() == null || vo.getCorreo().isEmpty()) {
            throw new RequiredAttributeException("El atributo Correo es requerido");
        } else if (!isValidEmail(vo.getCorreo())) {
            throw new InvalidAttributeException("El atributo Correo no tiene un formato válido");
        }
        //Validar Rol
        if (vo.getRol() == null) {
            throw new RequiredAttributeException("El atributo Rol es requerido");
        }
        return true;
    }
    
    public boolean validarCamposModificar(UsuarioVO vo) throws RequiredAttributeException, InvalidAttributeException {
        //Validar DNI
        if (vo.getDni() == null) {
            throw new RequiredAttributeException("El atributo DNI es requerido");
        } else if (vo.getDni() < MIN_DNI || vo.getDni() > MAX_DNI) {
            throw new InvalidAttributeException("El atributo DNI no está en el rango permitido");
        }
        //Validar Nombre
        if (vo.getNombre() == null || vo.getNombre().isEmpty()) {
            throw new RequiredAttributeException("El atributo Nombre es requerido");
        } else if (vo.getNombre().length() < MIN_LENGTH_NAME || vo.getNombre().length() > MAX_LENGTH_NAME) {
            throw new InvalidAttributeException("La longitud del atributo Nombre no está en el rango permitido (" 
                    + MIN_LENGTH_NAME + " - " + MAX_LENGTH_NAME + ")");
        } else if (!vo.getNombre().matches("([_A-Za-záéíóúAÉÍÓÚÑñ-]*(\\s[_A-Za-záéíóúAÉÍÓÚÑñ-]+)*)")) {
            throw new InvalidAttributeException("El atributo Nombre contiene caracteres inválidos"); 
        }
        //Validar Nombre de Usuario
        if (vo.getNombreDeUsuario() == null || vo.getNombreDeUsuario().isEmpty()) {
            throw new RequiredAttributeException("El atributo Nombre de Usuario es requerido");
        } else if (vo.getNombreDeUsuario().length() > MAX_LENGTH_USERNAME) {
            throw new InvalidAttributeException("El atributo Nombre de Usuario debe tener una longitud menor a " + MAX_LENGTH_USERNAME);
        } else if (!vo.getNombreDeUsuario().matches("[_A-Za-z0-9-.]*")) {
            throw new InvalidAttributeException("El atributo Nombre de Usuario contiene caracteres inválidos"); 
        }
        //Validar Correo
        if (vo.getCorreo() == null || vo.getCorreo().isEmpty()) {
            throw new RequiredAttributeException("El atributo Correo es requerido");
        } else if (!isValidEmail(vo.getCorreo())) {
            throw new InvalidAttributeException("El atributo Correo no tiene un formato válido");
        }
        //Validar Rol
        if (vo.getRol() == null) {
            throw new RequiredAttributeException("El atributo Rol es requerido");
        }
        return true;
    }
    
    private boolean isValidEmail(String mail) {      
        if (mail.matches("([_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}))")) {
            return true;
        }
        return false;
    }

    private boolean havePermissions(UsuarioVO vo) {
        UsuarioVO usuarioActivo = LoginController.usuarioActivo;
        Empresa empresaUsuarioActivo = DAOFactory.getInstance().getEmpresaDAO().find(LoginController.usuarioActivo.getEmpresasNIT());
        Empresa empresaVo = DAOFactory.getInstance().getEmpresaDAO().find(vo.getEmpresasNIT());
        return ((usuarioActivo.getRol().equals(Rol.PROVEEDOR_DE_TI))
                ||(usuarioActivo.getRol().equals(Rol.PROVEEDOR_DE_TI) && vo.getRol().equals(Rol.PRIMER_ADMINISTRADOR) && empresaVo.getNivel().equals(Nivel.DISTRIBUIDORA))
                || ((usuarioActivo.getRol().equals(Rol.PRIMER_ADMINISTRADOR) && (vo.getRol().equals(Rol.PRIMER_ADMINISTRADOR)))
                && ((empresaUsuarioActivo.getNivel().equals(Nivel.DISTRIBUIDORA) && empresaVo.getNivel().equals(Nivel.SUB_DISTRIBUIDORA))
                || (empresaUsuarioActivo.getNivel().equals(Nivel.SUB_DISTRIBUIDORA) && empresaVo.getNivel().equals(Nivel.CANAL))
                || (empresaUsuarioActivo.getNivel().equals(Nivel.CANAL) && empresaVo.getNivel().equals(Nivel.PUNTO_DE_VENTA))))
                || ((usuarioActivo.getRol().equals(Rol.PRIMER_ADMINISTRADOR) || usuarioActivo.getRol().equals(Rol.ADMINISTRADOR))
                && ((empresaUsuarioActivo.getNivel().equals(Nivel.DISTRIBUIDORA) && empresaVo.getNivel().equals(Nivel.DISTRIBUIDORA))
                || (empresaUsuarioActivo.getNivel().equals(Nivel.SUB_DISTRIBUIDORA) && empresaVo.getNivel().equals(Nivel.SUB_DISTRIBUIDORA))
                || (empresaUsuarioActivo.getNivel().equals(Nivel.CANAL) && empresaVo.getNivel().equals(Nivel.CANAL))
                || (empresaUsuarioActivo.getNivel().equals(Nivel.PUNTO_DE_VENTA) && empresaVo.getNivel().equals(Nivel.PUNTO_DE_VENTA)))));
    }

    @Override
    public void removeAll() throws NonexistentEntityException {
        for (Usuario usuario : DAOFactory.getInstance().getUsuarioDAO().getList()){
            DAOFactory.getInstance().getUsuarioDAO().delete(usuario.getDni());
        }
    }
}
