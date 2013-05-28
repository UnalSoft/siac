/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.LoginController.login;
import javax.swing.JOptionPane;
import model.service.ServiceFactory;

/**
 *
 * @author Felipe
 */
public class ControlDeVersion {

    private static final String VERSIONACTUAL = "0,9";
    private static String ultimaVersion;

    public static void actualizado() {
        ultimaVersion = ServiceFactory.getInstance().getVersionService()
                .getVersion().getVersion();
        if (!ultimaVersion.equals(VERSIONACTUAL)) {
            int opcion = JOptionPane.showOptionDialog(login, "Existe una nueva versión disponible (" + ultimaVersion + ") debe actualizar el programa para continuar con su ejecución, version actual: " + VERSIONACTUAL, "Error", JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[]{"Actualizar", "Cancelar"}, "Actualizar");
            switch (opcion) {
                case JOptionPane.OK_OPTION:
                    //TODO Actualizar
                    System.exit(0);
                    break;
                case JOptionPane.CANCEL_OPTION:
                    System.exit(0);
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}
