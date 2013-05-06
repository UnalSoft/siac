package model.service;

import java.util.*;
import javax.persistence.EntityNotFoundException;
import model.dao.DAOFactory;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.entity.Empresa;
import model.entity.Usuario;
import model.vo.UsuarioVO;

/**
 *
 * @author Zergio
 */
public class UsuarioService implements IService<UsuarioVO, Long> {

    private static UsuarioService instance;

    private UsuarioService() {
    }

    public static synchronized UsuarioService getInstance() {
        if (instance == null) {
            instance = new UsuarioService();
        }
        return instance;
    }

    @Override
    public void create(UsuarioVO vo) throws PreexistingEntityException, NonexistentEntityException{
        Usuario entity = new Usuario();
        entity.setClave(vo.getClave());
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

    }

    @Override
    public UsuarioVO find(Long id) throws EntityNotFoundException {
        Usuario usuario = DAOFactory.getInstance().getUsuarioDAO().find(id);
        if (usuario != null) {
            return usuario.toVO();
        } else {
            return null;
        }
    }

    @Override
    public void update(UsuarioVO vo) throws NonexistentEntityException {
        Usuario entity = DAOFactory.getInstance().getUsuarioDAO().find(vo.getDni());
        entity.setClave(vo.getClave());
        entity.setCorreo(vo.getCorreo());
        entity.setNombre(vo.getNombre());
        entity.setRol(vo.getRol());
        DAOFactory.getInstance().getUsuarioDAO().update(entity);
    }

    @Override
    public void delete(Long id) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<UsuarioVO> getList() {
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

    public UsuarioVO login(UsuarioVO vo) {
        Usuario entity = new Usuario();
        entity.setNombreDeUsuario(vo.getNombreDeUsuario());
        entity.setClave(vo.getClave());

        Usuario usuario = DAOFactory.getInstance().getUsuarioDAO().login(entity);
        return usuario != null ? usuario.toVO() : null;

    }
}
