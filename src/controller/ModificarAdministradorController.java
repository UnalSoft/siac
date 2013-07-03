/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.exceptions.InsufficientPermissionsException;
import model.dao.exceptions.InvalidAttributeException;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.RequiredAttributeException;
import model.entity.Rol;
import model.service.ServiceFactory;
import model.vo.EmpresaVO;
import model.vo.UsuarioVO;
import util.DibujarPanel;
import view.ModificarAdministrador;
import view.Secundario;

/**
 *
 * @author Felipe
 */
public class ModificarAdministradorController {

    static Secundario secundario = new Secundario();
    static ModificarAdministrador modificarAdministrador = new ModificarAdministrador();
    DefaultTableModel model;
    static UsuarioVO usuarioVO;

    public void llenarTabla() {
        List<UsuarioVO> usuariosList = new ArrayList<>();
        List<EmpresaVO> empresasList = ServiceFactory.getInstance().getEmpresaService().find(LoginController.usuarioActivo.getEmpresasNIT()).getEmpresaList();
        for (EmpresaVO empresa : empresasList) {
            List<UsuarioVO> primerosAdmins = ServiceFactory.getInstance().getUsuarioService().findByRolAndEnterprise(Rol.PRIMER_ADMINISTRADOR, empresa.getNit());
            for (UsuarioVO admin : primerosAdmins) {
                usuariosList.add(admin);
            }
        }
        model = (DefaultTableModel) modificarAdministrador.getUsuarioT()
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
        secundario.setTitle("Modificar Primer Administrador");
        DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), modificarAdministrador);
        llenarTabla();
    }

    public void cancelar() {
        secundario.setVisible(false);
        secundario = new Secundario();
        modificarAdministrador = new ModificarAdministrador();
    }

    public void buscar() {
        model = (DefaultTableModel) modificarAdministrador.getUsuarioT().getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        List<UsuarioVO> usuariosList = new ArrayList<>();
        List<EmpresaVO> empresasList = ServiceFactory.getInstance().getEmpresaService().find(LoginController.usuarioActivo.getEmpresasNIT()).getEmpresaList();
        if (modificarAdministrador.getDniRB().isSelected()) {
            try {
                for (EmpresaVO empresa : empresasList) {
                    List<UsuarioVO> primerosAdmins = ServiceFactory.getInstance().getUsuarioService()
                            .findByDNIAndEnterpriseAndRol(new Long(modificarAdministrador.getBuscarTF().getText()), empresa.getNit(), Rol.PRIMER_ADMINISTRADOR);
                    for (UsuarioVO admin : primerosAdmins) {
                        usuariosList.add(admin);
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(modificarAdministrador, "El campo DNI debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                modificarAdministrador.getBuscarTF().requestFocus();
                return;
            }
        } else {
            for (EmpresaVO empresa : empresasList) {
                List<UsuarioVO> primerosAdmins = ServiceFactory.getInstance().getUsuarioService()
                        .findByNameAndEnterpriseAndRol(modificarAdministrador.getBuscarTF().getText(), empresa.getNit(), Rol.PRIMER_ADMINISTRADOR);
                for (UsuarioVO admin : primerosAdmins) {
                    usuariosList.add(admin);
                }
            }
        }
        for (UsuarioVO usuarioVO : usuariosList) {
            Object[] datos = {usuarioVO.getDni(), usuarioVO.getNombre(),
                usuarioVO.getCorreo(), usuarioVO.getRol(),
                ServiceFactory.getInstance().getEmpresaService().find(usuarioVO.getEmpresasNIT()).getNombre()};
            model.addRow(datos);
        }
    }

    public void mostrarUsuarioEditable() {
        if (modificarAdministrador.getUsuarioT().getSelectedRow() != -1) {
            usuarioVO = ServiceFactory.getInstance().getUsuarioService()
                    .find(Long.valueOf(modificarAdministrador.getUsuarioT()
                    .getValueAt(modificarAdministrador.getUsuarioT().getSelectedRow(), 0)
                    .toString()));
            modificarAdministrador.getDniTF().setText(usuarioVO.getDni().toString());
            modificarAdministrador.getNombreDeUsuarioTF().setText(usuarioVO.getNombreDeUsuario());
            modificarAdministrador.getNombreTF().setText(usuarioVO.getNombre());
            modificarAdministrador.getCorreoTF().setText(usuarioVO.getCorreo());
            modificarAdministrador.getRolCB().setSelectedItem(usuarioVO.getRol().getLabel());
            DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), modificarAdministrador.getModificarUsuarioP());
        }
    }

    public void modificarUsuario() {
        usuarioVO.setCorreo(modificarAdministrador.getCorreoTF().getText());
        try {
            usuarioVO.setDni(new Long(modificarAdministrador.getDniTF().getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(modificarAdministrador, "El campo DNI debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
            modificarAdministrador.getDniTF().requestFocus();
            return;
        }
        usuarioVO.setEmpresasNIT(LoginController.usuarioActivo.getEmpresasNIT());
        usuarioVO.setNombre(modificarAdministrador.getNombreTF().getText());
        usuarioVO.setNombreDeUsuario(modificarAdministrador.getNombreDeUsuarioTF().getText());
        usuarioVO.setRol(Rol.fromLabel(modificarAdministrador.getRolCB().getSelectedItem().toString()));
        try {
            if (ServiceFactory.getInstance().getUsuarioService().validarCamposModificar(usuarioVO)) {
                ServiceFactory.getInstance().getUsuarioService().update(usuarioVO);
            }
        } catch (NonexistentEntityException | RequiredAttributeException | InvalidAttributeException | InsufficientPermissionsException ex) {
            JOptionPane.showMessageDialog(modificarAdministrador, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(modificarAdministrador, "Usuario modificado satisfactoriamente!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
        secundario.setVisible(false);
        secundario = new Secundario();
    }
}
