/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.persistence.EntityNotFoundException;
import javax.swing.JOptionPane;
import model.dao.exceptions.InvalidAttributeException;
import model.service.ServiceFactory;

/**
 *
 * @author Felipe
 */
public class RecuperarContrasenaController {
    
    public static void mostrarLogin(){
        LoginController.secundario.setVisible(false);
        LoginController.principal.setVisible(true);
    }

    public static void restablecerContrasena(String email) {
        try {
            ServiceFactory.getInstance().getUsuarioService().passwordRecovery(email);
            JOptionPane.showMessageDialog(LoginController.secundario, "Contraseña Cambiada con éxito.\n\n"
                    + "Revise su correo electronico para acceder con su nueva contraseña a la aplicación.", "Exito", JOptionPane.ERROR_MESSAGE);
            mostrarLogin();
        } catch (InvalidAttributeException | EntityNotFoundException ex) {
            JOptionPane.showMessageDialog(LoginController.secundario, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(LoginController.secundario, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
