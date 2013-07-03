/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JOptionPane;
import model.dao.exceptions.DataBaseException;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.service.ServiceFactory;
import model.vo.ErrorVO;
import model.vo.UsuarioVO;
import util.DibujarPanel;
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

    public static UsuarioVO getUsuarioLogin() {
        return usuarioActivo;
    }

    public static void setUsuarioLogin(UsuarioVO usuarioLogin) {
        LoginController.usuarioActivo = usuarioLogin;
    }

    public static void mostrarLogin() {
        principal = new Principal();
        principal.setLocationRelativeTo(null);
        login = new Login();
        principal.setVisible(true);
        DibujarPanel.dibujarPanel(principal, principal.getViewport(), login);
    }

    public static void cerrar() {
        System.exit(0);
    }

    public static void mostrarRecuperarContrasena() {
        secundario = new Secundario();
        secundario.setTitle("Recuperación de Contraseña");
        secundario.setLocationRelativeTo(principal);
        RecuperarContrasena recuperarContrasena = new RecuperarContrasena();
        secundario.setVisible(true);
        DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), recuperarContrasena);
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
                    ErrorVO error = new ErrorVO();
                    error.setError(ex.getMessage() + "\n" + ex.getCause().getMessage());
                    error.setInterfaz("Login");
                    error.setUsuariosDNI(usuarioActivo.getDni());
                    try {
                        ServiceFactory.getInstance().getErrorService().create(error);
                    } catch (    PreexistingEntityException | NonexistentEntityException ex1) {
                        JOptionPane.showMessageDialog(login, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    } catch (Exception e){
                        JOptionPane.showMessageDialog(login, e.getMessage() + "\n" + e.getCause().getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
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
                    proveedorTIPrincipal.getNombreUsuarioL().setText(usuarioLogin.getNombre());
                    proveedorTIPrincipal.getNombreEmpresaL().setText(nombreEmpresa);
                    proveedorTIPrincipal.getRolL().setText(usuarioLogin.getRol().getLabel());
                    DibujarPanel.dibujarPanel(principal, principal.getViewport(), proveedorTIPrincipal);
                    break;
                case PRIMER_ADMINISTRADOR:
                    PrimerAdministradorPrincipal primerAdministradorPrincipal = new PrimerAdministradorPrincipal();
                    primerAdministradorPrincipal.getNombreUsuarioL().setText(usuarioLogin.getNombre());
                    primerAdministradorPrincipal.getNombreEmpresaL().setText(nombreEmpresa);
                    primerAdministradorPrincipal.getRolL().setText(usuarioLogin.getRol().getLabel());
                    DibujarPanel.dibujarPanel(principal, principal.getViewport(), primerAdministradorPrincipal);
                    break;
                case ADMINISTRADOR:
                    AdministradorPrincipal administradorPrincipal = new AdministradorPrincipal();
                    administradorPrincipal.getNombreUsuarioL().setText(usuarioLogin.getNombre());
                    administradorPrincipal.getNombreEmpresaL().setText(nombreEmpresa);
                    administradorPrincipal.getRolL().setText(usuarioLogin.getRol().getLabel());
                    DibujarPanel.dibujarPanel(principal, principal.getViewport(), administradorPrincipal);
                    break;
                case CONSULTA:
                    ConsultarPrincipal consultarPrincipal = new ConsultarPrincipal();
                    consultarPrincipal.getNombreUsuarioL().setText(usuarioLogin.getNombre());
                    consultarPrincipal.getNombreEmpresaL().setText(nombreEmpresa);
                    consultarPrincipal.getRolL().setText(usuarioLogin.getRol().getLabel());
                    DibujarPanel.dibujarPanel(principal, principal.getViewport(), consultarPrincipal);
                    break;
                case OTRO:
                    OtroRolPrincipal otroRolPrincipal = new OtroRolPrincipal();
                    otroRolPrincipal.getNombreUsuarioL().setText(usuarioLogin.getNombre());
                    otroRolPrincipal.getNombreEmpresaL().setText(nombreEmpresa);
                    otroRolPrincipal.getRolL().setText(usuarioLogin.getRol().getLabel());
                    DibujarPanel.dibujarPanel(principal, principal.getViewport(), otroRolPrincipal);
                    principal.setTitle("Otro Rol");
                    break;
            }
            usuarioActivo = usuarioLogin;
        } else {
            JOptionPane.showMessageDialog(login, "El usuario o la contraseña son incorrectos", "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }

    public static void cerrarSesion() {
        usuarioActivo = null;
        login = new Login();
        principal.setLocationRelativeTo(null);
        DibujarPanel.dibujarPanel(principal, principal.getViewport(), login);
    }
}
