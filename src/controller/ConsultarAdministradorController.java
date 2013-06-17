package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.entity.Rol;
import model.service.ServiceFactory;
import model.vo.EmpresaVO;
import model.vo.UsuarioVO;
import util.DibujarPanel;
import view.ConsultarAdministrador;
import view.Secundario;

/**
 *
 * @author Felipe
 */
public class ConsultarAdministradorController {

    static Secundario secundario = new Secundario();
    static ConsultarAdministrador consultarAdministrador = new ConsultarAdministrador();
    DefaultTableModel model;

    public void llenarTabla() {
        List<UsuarioVO> usuariosList = new ArrayList<>();
        List<EmpresaVO> empresasList = ServiceFactory.getInstance().getEmpresaService().find(LoginController.usuarioActivo.getEmpresasNIT()).getEmpresaList();
        for (EmpresaVO empresa : empresasList) {
            List<UsuarioVO> primerosAdmins = ServiceFactory.getInstance().getUsuarioService().findByRolAndEnterprise(Rol.PRIMER_ADMINISTRADOR, empresa.getNit());
            for (UsuarioVO admin : primerosAdmins) {
                usuariosList.add(admin);
            }
        }
        model = (DefaultTableModel) consultarAdministrador.getUsuarioT()
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
        secundario.setTitle("Consultar Primer Administrador");
        DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), consultarAdministrador);
        llenarTabla();
    }

    public void cancelar() {
        secundario.setVisible(false);
        secundario = new Secundario();
    }

    public void buscar() {
        model = (DefaultTableModel) consultarAdministrador.getUsuarioT().getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        List<UsuarioVO> usuariosList = new ArrayList<>();
        List<EmpresaVO> empresasList = ServiceFactory.getInstance().getEmpresaService().find(LoginController.usuarioActivo.getEmpresasNIT()).getEmpresaList();
        if (consultarAdministrador.getDniRB().isSelected()) {
            try {
                for (EmpresaVO empresa : empresasList) {
                    List<UsuarioVO> primerosAdmins = ServiceFactory.getInstance().getUsuarioService()
                            .findByDNIAndEnterpriseAndRol(new Long(consultarAdministrador.getBuscarTF().getText()), empresa.getNit(), Rol.PRIMER_ADMINISTRADOR);
                    for (UsuarioVO admin : primerosAdmins) {
                        usuariosList.add(admin);
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(consultarAdministrador, "El campo DNI debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                consultarAdministrador.getBuscarTF().requestFocus();
                return;
            }

        } else {
            for (EmpresaVO empresa : empresasList) {
                List<UsuarioVO> primerosAdmins = ServiceFactory.getInstance().getUsuarioService()
                        .findByNameAndEnterpriseAndRol(consultarAdministrador.getBuscarTF().getText(), empresa.getNit(), Rol.PRIMER_ADMINISTRADOR);
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

    public void mostrarUsuario() {
        if (consultarAdministrador.getUsuarioT().getSelectedRow() != -1) {
            UsuarioVO usuarioVO = ServiceFactory.getInstance().getUsuarioService()
                    .find(Long.valueOf(consultarAdministrador.getUsuarioT()
                    .getValueAt(consultarAdministrador.getUsuarioT().getSelectedRow(), 0)
                    .toString()));
            consultarAdministrador.getDniTF().setText(usuarioVO.getDni().toString());
            consultarAdministrador.getNombreDeUsuarioTF().setText(usuarioVO.getNombreDeUsuario());
            consultarAdministrador.getNombreTF().setText(usuarioVO.getNombre());
            consultarAdministrador.getCorreoTF().setText(usuarioVO.getCorreo());
            consultarAdministrador.getRolTF().setText(usuarioVO.getRol().getLabel());
            DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), consultarAdministrador.getConsultaUsuarioP());
        }
    }
}
