/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JViewport;
import model.dao.exceptions.DataBaseException;
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
    public static UsuarioVO usuarioActivo;

    public static void mostrarLogin() {
        principal = new Principal();
        principal.setLocationRelativeTo(null);
        login = new Login();
        principal.setVisible(true);
        cambiarPanel(principal.getViewport(), login);
    }

    public static void cerrar() {
        System.exit(0);
    }

    public static void mostrarRecuperarContrasena() {
        secundario = new Secundario();
        secundario.setLocationRelativeTo(principal);
        RecuperarContrasena recuperarContrasena = new RecuperarContrasena();
        secundario.setSize(recuperarContrasena.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(secundario.getViewport(), recuperarContrasena);
    }

    public static void cambiarPanel(JViewport contenedor, JPanel panel) {
        contenedor.setVisible(false);
        contenedor.removeAll();
        contenedor.add(panel);
        contenedor.setSize(panel.getPreferredSize());
        contenedor.setVisible(true);
    }

    public static void login() {
        UsuarioVO usuario = new UsuarioVO();
        String nombreUsuario = login.getUsuarioTF().getText();
        String clave = new String(login.getContrasenaPF().getPassword());

        usuario.setNombreDeUsuario(nombreUsuario);
        usuario.setClave(clave);

        UsuarioVO usuarioLogin;
        try {
            usuarioLogin = ServiceFactory.getInstance().getUsuarioService().login(usuario);
        } catch (DataBaseException ex) {
            int opcion = JOptionPane.showOptionDialog(login, ex.getMessage() + "\n" + ex.getCause().getMessage(), "Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[]{"Reportar Error", "Cancelar"}, "Cancelar");
            switch (opcion) {
                case JOptionPane.OK_OPTION:
                    //TODO Reportar Error
                    break;
                case JOptionPane.CANCEL_OPTION:
                    break;
            }
            return;
        }

        if (usuarioLogin != null) {
            String nombreEmpresa = ServiceFactory.getInstance().getEmpresaService().find(usuarioLogin.getEmpresasNIT()).getNombre();
            switch (usuarioLogin.getRol()) {
                case PROVEEDOR_DE_TI:
                    ProveedorTIPrincipal proveedorTIPrincipal = new ProveedorTIPrincipal();
                    principal.setSize(proveedorTIPrincipal.getPreferredSize());
                    proveedorTIPrincipal.getNombreUsuarioL().setText(usuarioLogin.getNombre());
                    proveedorTIPrincipal.getNombreEmpresaL().setText(nombreEmpresa);
                    proveedorTIPrincipal.getRolL().setText(usuarioLogin.getRol().getLabel());
                    cambiarPanel(principal.getViewport(), proveedorTIPrincipal);
                    break;
                case PRIMER_ADMINISTRADOR:
                    PrimerAdministradorPrincipal primerAdministradorPrincipal = new PrimerAdministradorPrincipal();
                    principal.setSize(primerAdministradorPrincipal.getPreferredSize());
                    primerAdministradorPrincipal.getNombreUsuarioL().setText(usuarioLogin.getNombre());
                    primerAdministradorPrincipal.getNombreEmpresaL().setText(nombreEmpresa);
                    primerAdministradorPrincipal.getRolL().setText(usuarioLogin.getRol().getLabel());
                    cambiarPanel(principal.getViewport(), primerAdministradorPrincipal);
                case ADMINISTRADOR:
                    AdministradorPrincipal administradorPrincipal = new AdministradorPrincipal();
                    principal.setSize(administradorPrincipal.getPreferredSize());
                    administradorPrincipal.getNombreUsuarioL().setText(usuarioLogin.getNombre());
                    administradorPrincipal.getNombreEmpresaL().setText(nombreEmpresa);
                    administradorPrincipal.getRolL().setText(usuarioLogin.getRol().getLabel());
                    cambiarPanel(principal.getViewport(), administradorPrincipal);
                case CONSULTA:
                    ConsultarPrincipal consultarPrincipal = new ConsultarPrincipal();
                    principal.setSize(consultarPrincipal.getPreferredSize());
                    consultarPrincipal.getNombreUsuarioL().setText(usuarioLogin.getNombre());
                    consultarPrincipal.getNombreEmpresaL().setText(nombreEmpresa);
                    consultarPrincipal.getRolL().setText(usuarioLogin.getRol().getLabel());
                    cambiarPanel(principal.getViewport(), consultarPrincipal);
                case OTRO:
                    OtroRolPrincipal otroRolPrincipal = new OtroRolPrincipal();
                    principal.setSize(otroRolPrincipal.getPreferredSize());
                    otroRolPrincipal.getNombreUsuarioL().setText(usuarioLogin.getNombre());
                    otroRolPrincipal.getNombreEmpresaL().setText(nombreEmpresa);
                    otroRolPrincipal.getRolL().setText(usuarioLogin.getRol().getLabel());
                    cambiarPanel(principal.getViewport(), otroRolPrincipal);
            }
            usuarioActivo = usuarioLogin;
        } else {
            JOptionPane.showMessageDialog(login, "El usuario o la contraseña son incorrectos", "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }
}
