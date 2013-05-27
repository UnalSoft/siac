package controller;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.service.ServiceFactory;
import model.vo.ErrorVO;

/**
 *
 * @author Alexander
 */
public class ErrorController {

    public static void reportarError(ErrorVO error, JPanel panel) {
        try {
            ServiceFactory.getInstance().getErrorService().create(error);
        } catch (PreexistingEntityException | NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(panel, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //TODO Informar al Proveedor de TI sobre el error producido

    }
}
