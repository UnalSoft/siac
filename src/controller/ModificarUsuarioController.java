/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.exceptions.InsufficientPermissionsException;
import model.dao.exceptions.InvalidAttributeException;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.RequiredAttributeException;
import model.entity.Rol;
import model.service.ServiceFactory;
import model.vo.UsuarioVO;
import util.DibujarPanel;
import view.ModificarUsuario;
import view.Secundario;

/**
 *
 * @author Felipe
 */
public class ModificarUsuarioController {

    static Secundario secundario= new Secundario();
    static ModificarUsuario modificarUsuario= new ModificarUsuario();
    DefaultTableModel model;
    static UsuarioVO usuarioVO;
    
   
    public void llenarTabla() {
        List<UsuarioVO> usuariosList = ServiceFactory.getInstance()
                .getUsuarioService().findByEnterprise(LoginController.usuarioActivo.getEmpresasNIT());
        model = (DefaultTableModel) modificarUsuario.getUsuarioT()
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

    public void listarUsuarios() {
        secundario.setVisible(true);
        secundario.setTitle("Modificar Usuario");
        DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), modificarUsuario);
        llenarTabla();
    }

    public void cancelar() {
        secundario.setVisible(false);
        secundario = new Secundario();
    }

    public void buscar() {
        model = (DefaultTableModel) modificarUsuario.getUsuarioT().getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        List<UsuarioVO> usuarios;
        if (modificarUsuario.getDniRB().isSelected()) {
            try {
                usuarios = ServiceFactory.getInstance().getUsuarioService()
                        .findByDNIAndEnterprise(new Long(modificarUsuario.getBuscarTF().getText()), LoginController.usuarioActivo.getEmpresasNIT());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(modificarUsuario, "El campo DNI debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                modificarUsuario.getBuscarTF().requestFocus();
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
                    .findByNameAndEnterprise(modificarUsuario.getBuscarTF().getText(), LoginController.usuarioActivo.getEmpresasNIT());
            for (UsuarioVO usuarioVO : usuarios) {
                Object[] datos = {usuarioVO.getDni(), usuarioVO.getNombre(),
                    usuarioVO.getCorreo(), usuarioVO.getRol(),
                    ServiceFactory.getInstance().getEmpresaService().find(usuarioVO.getEmpresasNIT()).getNombre()};
                model.addRow(datos);
            }
        }
    }

    public void mostrarUsuarioEditable() {
        if (modificarUsuario.getUsuarioT().getSelectedRow() != -1) {
            usuarioVO = ServiceFactory.getInstance().getUsuarioService()
                    .find(Long.valueOf(modificarUsuario.getUsuarioT()
                    .getValueAt(modificarUsuario.getUsuarioT().getSelectedRow(), 0)
                    .toString()));
            modificarUsuario.getDniTF().setText(usuarioVO.getDni().toString());
            modificarUsuario.getNombreDeUsuarioTF().setText(usuarioVO.getNombreDeUsuario());
            modificarUsuario.getNombreTF().setText(usuarioVO.getNombre());
            modificarUsuario.getCorreoTF().setText(usuarioVO.getCorreo());
            modificarUsuario.getRolCB().setSelectedItem(usuarioVO.getRol().getLabel());
            DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), modificarUsuario.getModificarUsuarioP());
        }
    }

    public void modificarUsuario() {
        usuarioVO.setCorreo(modificarUsuario.getCorreoTF().getText());
        try {
            usuarioVO.setDni(new Long(modificarUsuario.getDniTF().getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(modificarUsuario, "El campo DNI debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
            modificarUsuario.getDniTF().requestFocus();
            return;
        }
        usuarioVO.setEmpresasNIT(LoginController.usuarioActivo.getEmpresasNIT());
        usuarioVO.setNombre(modificarUsuario.getNombreTF().getText());
        usuarioVO.setNombreDeUsuario(modificarUsuario.getNombreDeUsuarioTF().getText());
        usuarioVO.setRol(Rol.fromLabel(modificarUsuario.getRolCB().getSelectedItem().toString()));
        try {
            if (ServiceFactory.getInstance().getUsuarioService().validarCamposModificar(usuarioVO)) {
                ServiceFactory.getInstance().getUsuarioService().update(usuarioVO);
            }
        } catch (NonexistentEntityException | RequiredAttributeException | InvalidAttributeException | InsufficientPermissionsException ex) {
            JOptionPane.showMessageDialog(modificarUsuario, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(modificarUsuario, "Usuario modificado satisfactoriamente!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
        secundario.setVisible(false);
        secundario = new Secundario();
    }

}
