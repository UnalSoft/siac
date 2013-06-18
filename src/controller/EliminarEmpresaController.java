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
import model.service.ServiceFactory;
import model.vo.EmpresaVO;
import util.DibujarPanel;
import view.EliminarEmpresa;
import view.Secundario;

/**
 *
 * @author Felipe
 */
public class EliminarEmpresaController {
        
    static Secundario secundario= new Secundario();
    static EliminarEmpresa eliminarEmpresa = new EliminarEmpresa();
    DefaultTableModel model;
    static EmpresaVO empresaVO;
    
   
    public void llenarTabla() {
        List<EmpresaVO> empresasList = ServiceFactory.getInstance()
                .getEmpresaService().find(LoginController.usuarioActivo
                .getEmpresasNIT()).getEmpresaList();
        model = (DefaultTableModel) eliminarEmpresa.getEmpresaT().getModel();
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
        secundario.setTitle("Eliminar Empresa");
        DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), eliminarEmpresa);
        llenarTabla();
    }

    public void cancelar() {
        secundario.setVisible(false);
        secundario = new Secundario();
    }

    public void buscar() {
        model = (DefaultTableModel) eliminarEmpresa.getEmpresaT().getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        List<EmpresaVO> empresas;
        if (eliminarEmpresa.getNitRB().isSelected()) {
            try {
                empresas = ServiceFactory.getInstance().getEmpresaService()
                        .findByNitAndEnterprise(new Integer(eliminarEmpresa.getBuscarTF().getText()), LoginController.usuarioActivo.getEmpresasNIT());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(eliminarEmpresa, "El campo NIT debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                eliminarEmpresa.getBuscarTF().requestFocus();
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
                    .findByNameAndEnterprise(eliminarEmpresa.getBuscarTF().getText(), LoginController.usuarioActivo.getEmpresasNIT());
            for (EmpresaVO empresaVO : empresas) {
                Object[] datos = {empresaVO.getNit(), empresaVO.getNombre(),
                    empresaVO.getNivel().getText(), empresaVO.getDireccion(),
                    empresaVO.getTelefono()};
                model.addRow(datos);
            }
        }
    }

    public void eliminarEmpresa() {
        int opcion = JOptionPane.showOptionDialog(eliminarEmpresa, "Realmente desea eliminar la empresa, esto eliminara todas las empresas relacionadas?", "Confirmación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Si", "Cancelar"}, "Cancelar");
            switch (opcion) {
                case JOptionPane.OK_OPTION:
                    try {
                        ServiceFactory.getInstance().getEmpresaService().delete(new Integer(eliminarEmpresa.getEmpresaT().getValueAt(eliminarEmpresa.getEmpresaT().getSelectedRow(), 0).toString()));
                        JOptionPane.showMessageDialog(eliminarEmpresa, "La empresa se ha eliminado satisfactoriamente", "Error", JOptionPane.ERROR_MESSAGE);
                        llenarTabla();
                    } catch (NonexistentEntityException | InsufficientPermissionsException ex) {
                        JOptionPane.showMessageDialog(eliminarEmpresa, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case JOptionPane.CANCEL_OPTION:
                    break;
            }

    }
}
