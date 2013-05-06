package controller;

import javax.swing.JPanel;
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

    public static void cambiarPanel(JPanel contenedor, JPanel panel) {
        contenedor.setVisible(false);
        contenedor.removeAll();
        contenedor.add(panel);
        contenedor.setSize(panel.getPreferredSize());
        contenedor.setVisible(true);
    }

    public void crearEmpresa() {
        secundario = new Secundario();
//        secundario.setLocationRelativeTo(null);
        CrearEmpresa crearEmpresa = new CrearEmpresa();
        secundario.setSize(crearEmpresa.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(Secundario.getLayoutP(), crearEmpresa);
    }

    public void consultarEmpresa() {
        secundario = new Secundario();
//        secundario.setLocationRelativeTo(null);
        ConsultarEmpresa consultarEmpresa = new ConsultarEmpresa();
        secundario.setSize(consultarEmpresa.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(Secundario.getLayoutP(), consultarEmpresa);
    }

    public void modificarEmpresa() {
        secundario = new Secundario();
//        secundario.setLocationRelativeTo(null);
        ModificarEmpresa modificarEmpresa = new ModificarEmpresa();
        secundario.setSize(modificarEmpresa.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(Secundario.getLayoutP(), modificarEmpresa);
    }

    public void eliminarEmpresa() {
        secundario = new Secundario();
//        secundario.setLocationRelativeTo(null);
        EliminarEmpresa eliminarEmpresa = new EliminarEmpresa();
        secundario.setSize(eliminarEmpresa.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(Secundario.getLayoutP(), eliminarEmpresa);
    }

    public void consultarAdministrador() {
        secundario = new Secundario();
//        secundario.setLocationRelativeTo(null);
        ConsultarUsuario consultarUsuario = new ConsultarUsuario();
        secundario.setSize(consultarUsuario.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(Secundario.getLayoutP(), consultarUsuario);
    }

    public void modificarAdministrador() {
        secundario = new Secundario();
//        secundario.setLocationRelativeTo(null);
        ModificarUsuario modificarUsuario = new ModificarUsuario();
        secundario.setSize(modificarUsuario.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(Secundario.getLayoutP(), modificarUsuario);
    }

    public void eliminarAdministrador() {
        secundario = new Secundario();
//        secundario.setLocationRelativeTo(null);
        EliminarUsuario eliminarUsuario = new EliminarUsuario();
        secundario.setSize(eliminarUsuario.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(Secundario.getLayoutP(), eliminarUsuario);
    }
}
