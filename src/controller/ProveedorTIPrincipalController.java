package controller;

import javax.swing.JPanel;
import view.ConsultarEmpresa;
import view.CrearEmpresa;
import view.EliminarEmpresa;
import view.ModificarEmpresa;
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
    
}
