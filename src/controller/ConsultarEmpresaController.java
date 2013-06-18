/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.service.ServiceFactory;
import model.vo.EmpresaVO;
import util.DibujarPanel;
import view.ConsultarEmpresa;
import view.Secundario;

/**
 *
 * @author Felipe
 */
public class ConsultarEmpresaController {
    static Secundario secundario= new Secundario();
    static ConsultarEmpresa consultarEmpresa= new ConsultarEmpresa();
    DefaultTableModel model;
    
   
    public void llenarTabla() {
        List<EmpresaVO> empresasList = ServiceFactory.getInstance()
                .getEmpresaService().find(LoginController.usuarioActivo
                .getEmpresasNIT()).getEmpresaList();
        model = (DefaultTableModel) consultarEmpresa.getEmpresaT().getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        for (EmpresaVO empresaVO : empresasList) {
            Object[] datos = {empresaVO.getNit(), empresaVO.getNombre(),
                empresaVO.getNivel().getText(), empresaVO.getDireccion(),
                empresaVO.getDireccion()};
            model.addRow(datos);
        }
    }

    public void consultarEmpresa() {
        secundario.setVisible(true);
        secundario.setTitle("Consultar Empresa");
        DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), consultarEmpresa);
        llenarTabla();
    }

    public void cancelar() {
        secundario.setVisible(false);
        secundario = new Secundario();
    }

    public void buscar() {
        model = (DefaultTableModel) consultarEmpresa.getEmpresaT().getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        List<EmpresaVO> empresas;
        if (consultarEmpresa.getNitRB().isSelected()) {
            try {
                empresas = ServiceFactory.getInstance().getEmpresaService()
                        .findByNitAndEnterprise(new Integer(consultarEmpresa.getBuscarTF().getText()), LoginController.usuarioActivo.getEmpresasNIT());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(consultarEmpresa, "El campo NIT debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                consultarEmpresa.getBuscarTF().requestFocus();
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
                    .findByNameAndEnterprise(consultarEmpresa.getBuscarTF().getText(), LoginController.usuarioActivo.getEmpresasNIT());
            for (EmpresaVO empresaVO : empresas) {
                Object[] datos = {empresaVO.getNit(), empresaVO.getNombre(),
                    empresaVO.getNivel().getText(), empresaVO.getDireccion(),
                    empresaVO.getTelefono()};
                model.addRow(datos);
            }
        }
    }

    public void mostrarEmpresa() {
        if (consultarEmpresa.getEmpresaT().getSelectedRow() != -1) {
            EmpresaVO empresaVO = ServiceFactory.getInstance().getEmpresaService()
                    .find(Integer.valueOf(consultarEmpresa.getEmpresaT()
                    .getValueAt(consultarEmpresa.getEmpresaT().getSelectedRow(), 0)
                    .toString()));
            consultarEmpresa.getNitTF().setText(empresaVO.getNit().toString());
            consultarEmpresa.getNombreEmpresaTF().setText(empresaVO.getNombre());
            consultarEmpresa.getNivelTF().setText(empresaVO.getNivel().getText());
            consultarEmpresa.getDireccionTF().setText(empresaVO.getDireccion());
            consultarEmpresa.getTelefonoTF().setText(empresaVO.getTelefono());
            DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), consultarEmpresa.getConsultarEmpresaP());
        }
    }
}
