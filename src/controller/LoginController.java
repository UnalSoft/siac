/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.Login;
import view.Principal;
import view.RecuperarContrasena;
import view.Secundario;

/**
 *
 * @author Felipe
 */
public class LoginController {
    
    static Login login;
    static Principal principal;
    static Secundario secundario;
    
    public static void mostrarLogin() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                principal = new Principal();
                principal.setVisible(true);
                principal.setSize(380, 390);
                Principal.getLayoutP().setVisible(false);
                Principal.getLayoutP().removeAll();
                Principal.getLayoutP().add(new Login());
                Principal.getLayoutP().setVisible(true);
            }
        });
    }
    
    public static void cerrar(){
        System.exit(0);
    }
    
    public static void mostrarRecuperarContrasena(){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                secundario = new Secundario();
                secundario.setVisible(true);
                secundario.setSize(397, 164);
                principal.setVisible(false);
                Secundario.getLayoutP().setVisible(false);
                Secundario.getLayoutP().removeAll();
                Secundario.getLayoutP().add(new RecuperarContrasena());
                Secundario.getLayoutP().setVisible(true);
            }
        });
    }
}
