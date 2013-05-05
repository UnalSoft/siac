package model.service;

import java.util.List;
import javax.persistence.EntityManager;
import model.entity.Empresa;
import model.entity.Usuario;
import model.vo.UsuarioVO;

/**
 *
 * @author Zergio
 */
public class UsuarioService implements IService<UsuarioVO> {

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
    public void create(UsuarioVO vo, EntityManager em) {
        Usuario entity = new Usuario();
        entity.setClave(vo.getClave());
        entity.setCorreo(vo.getCorreo());
        entity.setDni(vo.getDni());
        entity.setNombre(vo.getNombre());
        entity.setNombreDeUsuario(vo.getNombreDeUsuario());
        entity.setRol(vo.getRol());

        entity.setErrorList(vo.getErrorList());

        Empresa empresa = DAOFactory.getInstance().getEmpresaDAO().find(vo.getEmpresasNIT(), em);
        empresa.getEmpresaList().add(entity);
        entity.setEmpresasNIT(empresa);

        DAOFactory.getInstance().getUsuarioDAO().persist(entity, em)
        
    }

    @Override
    public UsuarioVO find(Object id, EntityManager em) {
        Usuario usuario = DAOFactory.getInstance().getUsuarioDAO().find(id, em);
        if (usuario != null) {
            return usuario.toVO();

        } else {
            return null;
        }
    }

    @Override
    public void update(UsuarioVO vo, EntityManager em) {
        Usuario entity = DAOFactory.getInstance().getUsuarioDAO().find(vo.getDni(), em);
        entity.setClave(vo.getClave());
        entity.setCorreo(vo.getCorreo());
        entity.setNombre(vo.getNombre());
        entity.setRol(vo.getRol());
        DAOFactory.getInstance().getUsuarioDAO().update(entity, em);
    }

    @Override
    public void delete(Object id, EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<UsuarioVO> getList(EntityManager em) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public UsuarioVO login(UsuarioVO vo, EntityManager em) {
        Usuario entity = new Usuario();
        entity.setNombreDeUsuario(vo.getNombreDeUsuario());
        entity.setClave(vo.getClave());

        Usuario usuario = DAOFactory.getInstance().getUsuarioDAO().login(entity, em);
        return usuario != null ? usuario.toVo() : null;

    }
}
