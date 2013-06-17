/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.exceptions.InsufficientPermissionsException;
import model.dao.exceptions.NonexistentEntityException;
import model.entity.Rol;
import model.service.ServiceFactory;
import model.vo.UsuarioVO;
import util.DibujarPanel;
import view.EliminarUsuario;
import view.Secundario;

/**
 *
 * @author Felipe
 */
public class EliminarUsuarioController {
    
    static Secundario secundario= new Secundario();
    static EliminarUsuario eliminarUsuario= new EliminarUsuario();
    DefaultTableModel model;
    static UsuarioVO usuarioVO;
    
   
    public void llenarTabla() {
        List<UsuarioVO> usuariosList = ServiceFactory.getInstance()
                .getUsuarioService().findByEnterprise(LoginController.usuarioActivo.getEmpresasNIT());
        model = (DefaultTableModel) eliminarUsuario.getUsuarioT()
                .getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        for (UsuarioVO usuarioVO : usuariosList) {
            if(!usuarioVO.getRol().equals(Rol.PRIMER_ADMINISTRADOR)){
                Object[] datos = {usuarioVO.getDni(), usuarioVO.getNombre(),
                    usuarioVO.getCorreo(), usuarioVO.getRol(),
                    ServiceFactory.getInstance().getEmpresaService().find(usuarioVO.getEmpresasNIT()).getNombre()};
                model.addRow(datos);
            }
        }
    }

    public void listarUsuarios() {
        secundario.setVisible(true);
        secundario.setTitle("Eliminar Usuario");
        DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), eliminarUsuario);
        llenarTabla();
    }

    public void cancelar() {
        secundario.setVisible(false);
        secundario = new Secundario();
    }

    public void buscar() {
        model = (DefaultTableModel) eliminarUsuario.getUsuarioT().getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        List<UsuarioVO> usuarios;
        if (eliminarUsuario.getDniRB().isSelected()) {
            try {
                usuarios = ServiceFactory.getInstance().getUsuarioService()
                        .findByDNIAndEnterprise(new Long(eliminarUsuario.getBuscarTF().getText()), LoginController.usuarioActivo.getEmpresasNIT());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(eliminarUsuario, "El campo DNI debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                eliminarUsuario.getBuscarTF().requestFocus();
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
                    .findByNameAndEnterprise(eliminarUsuario.getBuscarTF().getText(), LoginController.usuarioActivo.getEmpresasNIT());
            for (UsuarioVO usuarioVO : usuarios) {
                Object[] datos = {usuarioVO.getDni(), usuarioVO.getNombre(),
                    usuarioVO.getCorreo(), usuarioVO.getRol(),
                    ServiceFactory.getInstance().getEmpresaService().find(usuarioVO.getEmpresasNIT()).getNombre()};
                model.addRow(datos);
            }
        }
    }


    public void eliminarUsuario() {
        int opcion = JOptionPane.showOptionDialog(eliminarUsuario, "Realmente desea eliminar al usuario?", "Confirmación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Si", "Cancelar"}, "Cancelar");
            switch (opcion) {
                case JOptionPane.OK_OPTION:
                    try {
                        ServiceFactory.getInstance().getUsuarioService().delete(new Long(eliminarUsuario.getUsuarioT().getValueAt(eliminarUsuario.getUsuarioT().getSelectedRow(), 0).toString()));
                        JOptionPane.showMessageDialog(eliminarUsuario, "El usuario se ha eliminado satisfactoriamente", "Error", JOptionPane.ERROR_MESSAGE);
                        llenarTabla();
                    } catch (NonexistentEntityException | InsufficientPermissionsException ex) {
                        JOptionPane.showMessageDialog(eliminarUsuario, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case JOptionPane.CANCEL_OPTION:
                    break;
            }

    }
}
