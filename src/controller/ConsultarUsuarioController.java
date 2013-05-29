/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.service.ServiceFactory;
import model.vo.UsuarioVO;
import util.DibujarPanel;
import view.ConsultarUsuario;
import view.Secundario;

/**
 *
 * @author Felipe
 */
public class ConsultarUsuarioController {

    static Secundario secundario= new Secundario();
    static ConsultarUsuario consultarUsuario= new ConsultarUsuario();
    DefaultTableModel model;
    
   
    public void llenarTabla() {
        List<UsuarioVO> usuariosList = ServiceFactory.getInstance()
                .getUsuarioService().findByEnterprise(LoginController.usuarioActivo.getEmpresasNIT());
        model = (DefaultTableModel) consultarUsuario.getUsuarioT()
                .getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        for (UsuarioVO usuarioVO : usuariosList) {
            Object[] datos = {usuarioVO.getDni(), usuarioVO.getNombre(),
                usuarioVO.getCorreo(), usuarioVO.getRol(),
                ServiceFactory.getInstance().getEmpresaService().find(usuarioVO.getEmpresasNIT()).getNombre()};
            model.addRow(datos);
        }
    }

    public void consultarUsuario() {
        secundario.setVisible(true);
        secundario.setTitle("Consultar Usuario");
        DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), consultarUsuario);
        llenarTabla();
    }

    public void cancelar() {
        secundario.setVisible(false);
        secundario = new Secundario();
    }

    public void buscar() {
        model = (DefaultTableModel) consultarUsuario.getUsuarioT().getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        List<UsuarioVO> usuarios;
        if (consultarUsuario.getDniRB().isSelected()) {
            try {
                usuarios = ServiceFactory.getInstance().getUsuarioService()
                        .findByDNIAndEnterprise(new Long(consultarUsuario.getBuscarTF().getText()), LoginController.usuarioActivo.getEmpresasNIT());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(consultarUsuario, "El campo DNI debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                consultarUsuario.getBuscarTF().requestFocus();
                return;
            }
            for (UsuarioVO usuarioVO : usuarios) {
                Object[] datos = {usuarioVO.getDni(), usuarioVO.getNombre(),
                    usuarioVO.getCorreo(), usuarioVO.getRol(),
                    ServiceFactory.getInstance().getEmpresaService().find(usuarioVO.getEmpresasNIT()).getNombre()};
                model.addRow(datos);
            }
        } else {
            usuarios = ServiceFactory.getInstance().getUsuarioService()
                    .findByNameAndEnterprise(consultarUsuario.getBuscarTF().getText(), LoginController.usuarioActivo.getEmpresasNIT());
            for (UsuarioVO usuarioVO : usuarios) {
                Object[] datos = {usuarioVO.getDni(), usuarioVO.getNombre(),
                    usuarioVO.getCorreo(), usuarioVO.getRol(),
                    ServiceFactory.getInstance().getEmpresaService().find(usuarioVO.getEmpresasNIT()).getNombre()};
                model.addRow(datos);
            }
        }
    }

    public void mostrarUsuario() {
        if (consultarUsuario.getUsuarioT().getSelectedRow() != -1) {
            UsuarioVO usuarioVO = ServiceFactory.getInstance().getUsuarioService()
                    .find(Long.valueOf(consultarUsuario.getUsuarioT()
                    .getValueAt(consultarUsuario.getUsuarioT().getSelectedRow(), 0)
                    .toString()));
            consultarUsuario.getDniTF().setText(usuarioVO.getDni().toString());
            consultarUsuario.getNombreDeUsuarioTF().setText(usuarioVO.getNombreDeUsuario());
            consultarUsuario.getNombreTF().setText(usuarioVO.getNombre());
            consultarUsuario.getCorreoTF().setText(usuarioVO.getCorreo());
            consultarUsuario.getRolTF().setText(usuarioVO.getRol().getLabel());
            DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), consultarUsuario.getConsultaUsuarioP());
        }
    }

}
