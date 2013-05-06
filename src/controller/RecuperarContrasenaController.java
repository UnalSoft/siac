/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Felipe
 */
public class RecuperarContrasenaController {
    
    public static void mostrarLogin(){
        LoginController.secundario.setVisible(false);
        LoginController.principal.setVisible(true);
    }
}
