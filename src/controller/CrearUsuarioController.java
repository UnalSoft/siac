/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.ModificarUsuarioController.secundario;
import java.util.Arrays;
import javax.swing.JOptionPane;
import model.dao.exceptions.InsufficientPermissionsException;
import model.dao.exceptions.InvalidAttributeException;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.dao.exceptions.RequiredAttributeException;
import model.entity.Rol;
import model.service.ServiceFactory;
import model.vo.UsuarioVO;
import util.DibujarPanel;
import view.CrearUsuario;
import view.Secundario;

/**
 *
 * @author Felipe
 */
public class CrearUsuarioController {
    
    
    static Secundario secundario= new Secundario();
    static CrearUsuario crearUsuario= new CrearUsuario();
    
    public void mostrarCrearUsuario(){
        secundario.setVisible(true);
        secundario.setTitle("Crear Usuario");
        DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), crearUsuario);
    }
    
    public static void cancelar() {
        secundario.setVisible(false);
        secundario = new Secundario();
    }
    
    public static void crearUsuario() {
        if (clavesIguales()) {
            UsuarioVO usuarioVo = new UsuarioVO();
            usuarioVo.setClave(new String(crearUsuario.getContrasenaPF().getPassword()));
            usuarioVo.setCorreo(crearUsuario.getCorreoTF().getText());
            try {
                usuarioVo.setDni(new Long(crearUsuario.getDniTF().getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(crearUsuario, "El campo DNI debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                crearUsuario.getDniTF().requestFocus();
                return;
            }
            usuarioVo.setEmpresasNIT(LoginController.usuarioActivo.getEmpresasNIT());
            usuarioVo.setNombre(crearUsuario.getNombreTF().getText());
            usuarioVo.setNombreDeUsuario(crearUsuario.getNombreDeUsuarioTF().getText());
            usuarioVo.setRol(Rol.fromLabel(crearUsuario.getRolCB().getSelectedItem().toString()));
            try {
                if (ServiceFactory.getInstance().getUsuarioService().validarCampos(usuarioVo)) {
                    ServiceFactory.getInstance().getUsuarioService().create(usuarioVo);
                }
            } catch (PreexistingEntityException | NonexistentEntityException | RequiredAttributeException
                    | InvalidAttributeException | InsufficientPermissionsException ex) {
                JOptionPane.showMessageDialog(crearUsuario, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            JOptionPane.showMessageDialog(crearUsuario, "Usuario creado satisfactoriamente!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
            secundario.setVisible(false);
            secundario = new Secundario();
        } else {
            JOptionPane.showMessageDialog(crearUsuario, "Las contraseñas no coinciden!", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private static boolean clavesIguales() {
        return (Arrays.equals(crearUsuario.getContrasenaPF().getPassword(), crearUsuario.getConfirmarContrasenaPF().getPassword()));
    }
}
