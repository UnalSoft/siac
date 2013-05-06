/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.service.ServiceFactory;
import model.vo.UsuarioVO;
import view.AdministradorPrincipal;
import view.ConsultarPrincipal;
import view.Login;
import view.OtroRolPrincipal;
import view.PrimerAdministradorPrincipal;
import view.Principal;
import view.ProveedorTIPrincipal;
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
        principal = new Principal();
//        principal.setLocationRelativeTo(null);
        login = new Login();
        principal.setSize(login.getPreferredSize());
        principal.setVisible(true);
        cambiarPanel(Principal.getLayoutP(), login);
    }

    public static void cerrar() {
        System.exit(0);
    }

    public static void mostrarRecuperarContrasena() {
        secundario = new Secundario();
//        secundario.setLocationRelativeTo(null);
        RecuperarContrasena recuperarContrasena = new RecuperarContrasena();
        secundario.setSize(recuperarContrasena.getPreferredSize());
        secundario.setVisible(true);
        principal.setVisible(false);
        cambiarPanel(Secundario.getLayoutP(), recuperarContrasena);
    }

    public static void cambiarPanel(JPanel contenedor, JPanel panel) {
        contenedor.setVisible(false);
        contenedor.removeAll();
        contenedor.add(panel);
        contenedor.setSize(panel.getPreferredSize());
        contenedor.setVisible(true);
    }

    public static void login() {
        UsuarioVO usuario = new UsuarioVO();
        String nombreUsuario = login.usuarioTF.getText();
        String clave = new String(login.contrasenaPF.getPassword());

        usuario.setNombreDeUsuario(nombreUsuario);
        usuario.setClave(clave);

        UsuarioVO usuarioLogin = ServiceFactory.getInstance().getUsuarioService().login(usuario);

        if (usuarioLogin != null) {
            switch (usuarioLogin.getRol()) {
                case PROVEEDOR_DE_TI:
                    ProveedorTIPrincipal proveedorTIPrincipal = new ProveedorTIPrincipal();
                    principal.setSize(proveedorTIPrincipal.getPreferredSize());
                    cambiarPanel(Principal.getLayoutP(), proveedorTIPrincipal);
                    break;
                case PRIMER_ADMINISTRADOR:
                    PrimerAdministradorPrincipal primerAdministradorPrincipal = new PrimerAdministradorPrincipal();
                    principal.setSize(primerAdministradorPrincipal.getPreferredSize());
                    cambiarPanel(Principal.getLayoutP(), primerAdministradorPrincipal);
                case ADMINISTRADOR:
                    AdministradorPrincipal administradorPrincipal = new AdministradorPrincipal();
                    principal.setSize(administradorPrincipal.getPreferredSize());
                    cambiarPanel(Principal.getLayoutP(), administradorPrincipal);
                case CONSULTA:
                    ConsultarPrincipal consultarPrincipal = new ConsultarPrincipal();
                    principal.setSize(consultarPrincipal.getPreferredSize());
                    cambiarPanel(Principal.getLayoutP(), consultarPrincipal);
                case OTRO:
                    OtroRolPrincipal otroRolPrincipal = new OtroRolPrincipal();
                    principal.setSize(otroRolPrincipal.getPreferredSize());
                    cambiarPanel(Principal.getLayoutP(), otroRolPrincipal);
            }

        } else {
            JOptionPane.showMessageDialog(login, "El usuario o la contraseña son incorrectos", "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }
}
