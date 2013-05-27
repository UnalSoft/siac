/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JPanel;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;
import model.service.ServiceFactory;
import model.vo.UsuarioVO;
import view.ConsultarUsuario;
import view.Secundario;

/**
 *
 * @author Felipe
 */
public class ConsultarUsuarioController {

    static Secundario secundario;
    static ConsultarUsuario consultarUsuario = new ConsultarUsuario();
    List<UsuarioVO> usuariosList;
    DefaultTableModel model;

    public void llenarTabla() {
        //TODO Limpiar la tabla al inicio
        usuariosList = ServiceFactory.getInstance()
                .getUsuarioService().findByEnterprise(LoginController.usuarioActivo.getEmpresasNIT());
        model = (DefaultTableModel) consultarUsuario.getUsuarioT()
                .getModel();
        for (UsuarioVO usuarioVO : usuariosList) {
            Object[] datos = {usuarioVO.getDni(), usuarioVO.getNombre(),
                usuarioVO.getCorreo(), usuarioVO.getRol(),
                ServiceFactory.getInstance().getEmpresaService().find(usuarioVO.getEmpresasNIT()).getNombre()};
            model.addRow(datos);
        }
    }

    public static void cambiarPanel(JViewport contenedor, JPanel panel) {
        contenedor.setVisible(false);
        contenedor.removeAll();
        contenedor.add(panel);
        contenedor.setSize(panel.getPreferredSize());
        contenedor.setVisible(true);
    }

    public void consultarUsuario() {
        secundario = new Secundario();
        secundario.setLocationRelativeTo(null);
        secundario.setSize(consultarUsuario.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(secundario.getViewport(), consultarUsuario);
        llenarTabla();
    }

    public void cancelar() {
        secundario.removeAll();
        secundario.setVisible(false);
    }

    public void buscar() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        if (consultarUsuario.getDniRB().isSelected()) {
            //TODO usar metodo findByDNIAndEnterprise del servicio
            for (UsuarioVO usuarioVO : usuariosList) {
                if (usuarioVO.getDni().toString()
                        .equals(consultarUsuario.getBuscarTF().getText())
                        && usuarioVO.getEmpresasNIT().equals(LoginController.usuarioActivo.getEmpresasNIT())) {
                    Object[] datos = {usuarioVO.getDni(), usuarioVO.getNombre(),
                        usuarioVO.getCorreo(), usuarioVO.getRol(),
                        usuarioVO.getEmpresasNIT()};
                    model.addRow(datos);
                }
            }
        } else {
            //TODO usar metodo findByNameAndEnterprise del servicio
            for (UsuarioVO usuarioVO : usuariosList) {
                if (usuarioVO.getNombre().toString()
                        .equals(consultarUsuario.getBuscarTF().getText())
                        && usuarioVO.getEmpresasNIT().equals(LoginController.usuarioActivo.getEmpresasNIT())) {
                    Object[] datos = {usuarioVO.getDni(), usuarioVO.getNombre(),
                        usuarioVO.getCorreo(), usuarioVO.getRol(),
                        usuarioVO.getEmpresasNIT()};
                    model.addRow(datos);
                }
            }
        }
    }

    public void mostrarUsuario() {
        if (consultarUsuario.getUsuarioT().getSelectedRow() != -1) {
            UsuarioVO usuarioVO = ServiceFactory.getInstance().getUsuarioService()
                    .find(Long.valueOf(consultarUsuario.getUsuarioT()
                    .getValueAt(consultarUsuario.getUsuarioT().getSelectedRow(), 0)
                    .toString()));
            consultarUsuario.getConsultaF().setLocationRelativeTo(null);
            consultarUsuario.getConsultaF().setSize(401, 223);
            consultarUsuario.getConsultaF().setVisible(true);
            consultarUsuario.getDniTF().setText(usuarioVO.getDni().toString());
            consultarUsuario.getNombreDeUsuarioTF().setText(usuarioVO.getNombreDeUsuario());
            consultarUsuario.getNombreTF().setText(usuarioVO.getNombre());
            consultarUsuario.getCorreoTF().setText(usuarioVO.getCorreo());
            consultarUsuario.getRolTF().setText(usuarioVO.getRol().getLabel());
        }
    }

    public void ocultarUsuario() {
        consultarUsuario.getConsultaF().setVisible(false);
    }
}
