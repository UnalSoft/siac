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
import model.entity.Nivel;
import model.service.ServiceFactory;
import model.vo.EmpresaVO;
import util.DibujarPanel;
import view.ModificarEmpresa;
import view.Secundario;

/**
 *
 * @author Felipe
 */
public class ModificarEmpresaController {
    
    static Secundario secundario= new Secundario();
    static ModificarEmpresa modificarEmpresa= new ModificarEmpresa();
    DefaultTableModel model;
    static EmpresaVO empresaVO;
    
   
    public void llenarTabla() {
        List<EmpresaVO> empresasList = ServiceFactory.getInstance()
                .getEmpresaService().find(LoginController.usuarioActivo
                .getEmpresasNIT()).getEmpresaList();
        model = (DefaultTableModel) modificarEmpresa.getEmpresaT().getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        for (EmpresaVO empresaVO : empresasList) {
            Object[] datos = {empresaVO.getNit(), empresaVO.getNombre(),
                empresaVO.getNivel().getText(), empresaVO.getDireccion(),
                empresaVO.getDireccion()};
            model.addRow(datos);
        }
    }

    public void listarEmpresa() {
        secundario.setVisible(true);
        secundario.setTitle("Modificar Empresa");
        DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), modificarEmpresa);
        llenarTabla();
    }

    public void cancelar() {
        secundario.setVisible(false);
        secundario = new Secundario();
        modificarEmpresa= new ModificarEmpresa();
    }

    public void buscar() {
        model = (DefaultTableModel) modificarEmpresa.getEmpresaT().getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        List<EmpresaVO> empresas;
        if (modificarEmpresa.getNitRB().isSelected()) {
            try {
                empresas = ServiceFactory.getInstance().getEmpresaService()
                        .findByNitAndEnterprise(new Integer(modificarEmpresa.getBuscarTF().getText()), LoginController.usuarioActivo.getEmpresasNIT());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(modificarEmpresa, "El campo NIT debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                modificarEmpresa.getBuscarTF().requestFocus();
                return;
            }
            for (EmpresaVO empresaVO : empresas) {
                Object[] datos = {empresaVO.getNit(), empresaVO.getNombre(),
                    empresaVO.getNivel().getText(), empresaVO.getDireccion(),
                    empresaVO.getTelefono()};
                model.addRow(datos);
            }
        } else {
            empresas = ServiceFactory.getInstance().getEmpresaService()
                    .findByNameAndEnterprise(modificarEmpresa.getBuscarTF().getText(), LoginController.usuarioActivo.getEmpresasNIT());
            for (EmpresaVO empresaVO : empresas) {
                Object[] datos = {empresaVO.getNit(), empresaVO.getNombre(),
                    empresaVO.getNivel().getText(), empresaVO.getDireccion(),
                    empresaVO.getTelefono()};
                model.addRow(datos);
            }
        }
    }

    public void mostrarEmpresaEditable() {
        if (modificarEmpresa.getEmpresaT().getSelectedRow() != -1) {
            empresaVO = ServiceFactory.getInstance().getEmpresaService()
                    .find(Integer.valueOf(modificarEmpresa.getEmpresaT()
                    .getValueAt(modificarEmpresa.getEmpresaT().getSelectedRow(), 0)
                    .toString()));
            modificarEmpresa.getNitTF().setText(empresaVO.getNit().toString());
            modificarEmpresa.getNombreEmpresaTF().setText(empresaVO.getNombre());
            modificarEmpresa.getNivelTF().setText(empresaVO.getNivel().getText());
            modificarEmpresa.getDireccionTF().setText(empresaVO.getDireccion());
            modificarEmpresa.getTelefonoTF().setText(empresaVO.getTelefono());
            DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), modificarEmpresa.getModificarEmpresaP());
        }
    }

    public void modificarEmpresa() {
        try {
            System.out.println(modificarEmpresa.getNitTF());
            empresaVO.setNit(new Integer(modificarEmpresa.getNitTF().getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(modificarEmpresa, "El campo NIT debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
            modificarEmpresa.getNitTF().requestFocus();
            return;
        }
        empresaVO.setNombre(modificarEmpresa.getNombreEmpresaTF().getText());
        empresaVO.setNivel(Nivel.fromText(modificarEmpresa.getNivelTF().getText()));
        empresaVO.setDireccion(modificarEmpresa.getDireccionTF().getText());
        empresaVO.setTelefono(modificarEmpresa.getTelefonoTF().getText());
        try {
            if (ServiceFactory.getInstance().getEmpresaService().validarCampos(empresaVO)) {
                ServiceFactory.getInstance().getEmpresaService().update(empresaVO);
            }
        } catch (NonexistentEntityException | RequiredAttributeException | InvalidAttributeException | InsufficientPermissionsException ex) {
            JOptionPane.showMessageDialog(modificarEmpresa, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(modificarEmpresa, "Empresa modificada satisfactoriamente!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
        secundario.setVisible(false);
        secundario = new Secundario();
        modificarEmpresa = new ModificarEmpresa();
    }

}
