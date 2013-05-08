package controller;

import javax.swing.JPanel;
import javax.swing.JViewport;
import model.entity.Nivel;
import model.entity.Rol;
import view.ConsultarEmpresa;
import view.ConsultarUsuario;
import view.CrearEmpresa;
import view.EliminarEmpresa;
import view.EliminarUsuario;
import view.ModificarEmpresa;
import view.ModificarUsuario;
import view.Principal;
import view.Secundario;

/**
 *
 * @author Alexander
 */
public class ProveedorTIPrincipalController {

    static Principal principal;
    static Secundario secundario;

    public static void cambiarPanel(JViewport contenedor, JPanel panel) {
        contenedor.setVisible(false);
        contenedor.removeAll();
        contenedor.add(panel);
        contenedor.setSize(panel.getPreferredSize());
        contenedor.setVisible(true);
    }

    public void crearEmpresa() {
        secundario = new Secundario();
        secundario.setLocationRelativeTo(principal);
        CrearEmpresa crearEmpresa = new CrearEmpresa(secundario);
        crearEmpresa.getNivelTF().setText(Nivel.DISTRIBUIDORA.getText());
        crearEmpresa.getRolTF().setText(Rol.PRIMER_ADMINISTRADOR.getLabel());
        secundario.setSize(crearEmpresa.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(secundario.getViewport(), crearEmpresa);
    }

    public void consultarEmpresa() {
        secundario = new Secundario();
        secundario.setLocationRelativeTo(principal);
        ConsultarEmpresa consultarEmpresa = new ConsultarEmpresa();
        secundario.setSize(consultarEmpresa.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(secundario.getViewport(), consultarEmpresa);
    }

    public void modificarEmpresa() {
        secundario = new Secundario();
        secundario.setLocationRelativeTo(principal);
        ModificarEmpresa modificarEmpresa = new ModificarEmpresa();
        secundario.setSize(modificarEmpresa.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(secundario.getViewport(), modificarEmpresa);
    }

    public void eliminarEmpresa() {
        secundario = new Secundario();
        secundario.setLocationRelativeTo(principal);
        EliminarEmpresa eliminarEmpresa = new EliminarEmpresa();
        secundario.setSize(eliminarEmpresa.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(secundario.getViewport(), eliminarEmpresa);
    }

    public void consultarAdministrador() {
        secundario = new Secundario();
        secundario.setLocationRelativeTo(principal);
        ConsultarUsuario consultarUsuario = new ConsultarUsuario();
        secundario.setSize(consultarUsuario.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(secundario.getViewport(), consultarUsuario);
    }

    public void modificarAdministrador() {
        secundario = new Secundario();
        secundario.setLocationRelativeTo(principal);
        ModificarUsuario modificarUsuario = new ModificarUsuario();
        secundario.setSize(modificarUsuario.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(secundario.getViewport(), modificarUsuario);
    }

    public void eliminarAdministrador() {
        secundario = new Secundario();
        secundario.setLocationRelativeTo(principal);
        EliminarUsuario eliminarUsuario = new EliminarUsuario();
        secundario.setSize(eliminarUsuario.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(secundario.getViewport(), eliminarUsuario);
    }
}
