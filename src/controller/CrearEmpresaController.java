package controller;

import java.util.Arrays;
import javax.swing.JOptionPane;
import model.dao.exceptions.InsufficientPermissionsException;
import model.dao.exceptions.InvalidAttributeException;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.dao.exceptions.RequiredAttributeException;
import model.entity.Nivel;
import model.entity.Rol;
import model.service.ServiceFactory;
import model.vo.EmpresaVO;
import model.vo.UsuarioVO;
import view.CrearEmpresa;

/**
 *
 * @author Alexander
 */
public class CrearEmpresaController {

    private static CrearEmpresa crearEmpresa;

    public static void crearEmpresa(CrearEmpresa crearEmpresa) {
        CrearEmpresaController.crearEmpresa = crearEmpresa;
        if (clavesIguales()) {
            EmpresaVO empresaVo = new EmpresaVO();
            empresaVo.setDireccion(crearEmpresa.getDireccionTF().getText());
            try {
                empresaVo.setNit(new Integer(crearEmpresa.getNitTF().getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(crearEmpresa, "El campo Nit debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                crearEmpresa.getNitTF().requestFocus();
                return;
            }
            empresaVo.setNivel(Nivel.fromText(crearEmpresa.getNivelTF().getText()));
            empresaVo.setNombre(crearEmpresa.getNombreEmpresaTF().getText());
            empresaVo.setTelefono(crearEmpresa.getTelefonoTF().getText());

            UsuarioVO usuarioVo = new UsuarioVO();
            usuarioVo.setClave(new String(crearEmpresa.getContrasenaPF().getPassword()));
            usuarioVo.setCorreo(crearEmpresa.getCorreoTF().getText());
            try {
                usuarioVo.setDni(new Long(crearEmpresa.getDniTF().getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(crearEmpresa, "El campo DNI debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                crearEmpresa.getDniTF().requestFocus();
                return;
            }
            usuarioVo.setEmpresasNIT(empresaVo.getNit());
            usuarioVo.setNombre(crearEmpresa.getNombreTF().getText());
            usuarioVo.setNombreDeUsuario(crearEmpresa.getNombreDeUsuarioTF().getText());
            usuarioVo.setRol(Rol.fromLabel(crearEmpresa.getRolTF().getText()));
            try {
                if (ServiceFactory.getInstance().getEmpresaService().validarCampos(empresaVo)
                        && ServiceFactory.getInstance().getUsuarioService().validarCampos(usuarioVo)) {
                    ServiceFactory.getInstance().getEmpresaService().create(empresaVo);
                    ServiceFactory.getInstance().getUsuarioService().create(usuarioVo);
                }
            } catch (PreexistingEntityException | NonexistentEntityException | RequiredAttributeException
                    | InvalidAttributeException | InsufficientPermissionsException ex) {
                JOptionPane.showMessageDialog(crearEmpresa, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(crearEmpresa, "Empresa y Primer Administrador creados satisfactoriamente!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
            crearEmpresa.getFrame().dispose();
        } else {
            JOptionPane.showMessageDialog(crearEmpresa, "Las contraseñas no coinciden!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private static boolean clavesIguales() {
        return (Arrays.equals(crearEmpresa.getContrasenaPF().getPassword(), crearEmpresa.getConfirmarContrasenaPF().getPassword()));
    }
}
