package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.exceptions.InsufficientPermissionsException;
import model.dao.exceptions.InvalidAttributeException;
import model.dao.exceptions.NonexistentEntityException;
import model.dao.exceptions.PreexistingEntityException;
import model.dao.exceptions.RequiredAttributeException;
import model.entity.Rol;
import model.service.ServiceFactory;
import model.vo.EmpresaVO;
import model.vo.UsuarioVO;
import util.DibujarPanel;
import view.EliminarAdministrador;
import view.Secundario;

/**
 *
 * @author Felipe
 */
public class EliminarAdministradorController {

    static Secundario secundario = new Secundario();
    static EliminarAdministrador eliminarAdministrador = new EliminarAdministrador();
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
        model = (DefaultTableModel) eliminarAdministrador.getUsuarioT()
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
        secundario.setTitle("Eliminar Primer Administrador");
        DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), eliminarAdministrador);
        llenarTabla();
    }

    public void cancelar() {
        secundario.setVisible(false);
        secundario = new Secundario();
    }

    public void buscar() {
        model = (DefaultTableModel) eliminarAdministrador.getUsuarioT().getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        List<UsuarioVO> usuariosList = new ArrayList<>();
        List<EmpresaVO> empresasList = ServiceFactory.getInstance().getEmpresaService().find(LoginController.usuarioActivo.getEmpresasNIT()).getEmpresaList();
        if (eliminarAdministrador.getDniRB().isSelected()) {
            try {
                for (EmpresaVO empresa : empresasList) {
                    List<UsuarioVO> primerosAdmins = ServiceFactory.getInstance().getUsuarioService()
                            .findByDNIAndEnterpriseAndRol(new Long(eliminarAdministrador.getBuscarTF().getText()), empresa.getNit(), Rol.PRIMER_ADMINISTRADOR);
                    for (UsuarioVO admin : primerosAdmins) {
                        usuariosList.add(admin);
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(eliminarAdministrador, "El campo DNI debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                eliminarAdministrador.getBuscarTF().requestFocus();
                return;
            }

        } else {
            for (EmpresaVO empresa : empresasList) {
                List<UsuarioVO> primerosAdmins = ServiceFactory.getInstance().getUsuarioService()
                        .findByNameAndEnterpriseAndRol(eliminarAdministrador.getBuscarTF().getText(), empresa.getNit(), Rol.PRIMER_ADMINISTRADOR);
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

    public void mostrarEliminarAdmin() {
        int opcion = JOptionPane.showOptionDialog(eliminarAdministrador, "Una empresa debe tener obligatoriamente un primer Administrador.\n\n"
                + "Si elimina el actual debe asignarle uno nuevo. Desea Continuar?", "Confirmación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Si", "Cancelar"}, "Cancelar");
        switch (opcion) {
            case JOptionPane.OK_OPTION:
                //TODO: Eliminar el administrador y asignar el nuevo
                usuarioVO = ServiceFactory.getInstance().getUsuarioService()
                        .find(Long.valueOf(eliminarAdministrador.getUsuarioT().getValueAt(eliminarAdministrador.getUsuarioT().getSelectedRow(), 0).toString()));
                EmpresaVO empresa = ServiceFactory.getInstance().getEmpresaService().find(usuarioVO.getEmpresasNIT());
                eliminarAdministrador.setNitTF(empresa.getNit().toString());
                eliminarAdministrador.setNombreEmpresaTF(empresa.getNombre());
                eliminarAdministrador.setNivelTF(empresa.getNivel().getText());
                eliminarAdministrador.setDireccionTF(empresa.getDireccion() != null ? empresa.getDireccion() : "");
                eliminarAdministrador.setTelefonoTF(empresa.getTelefono() != null ? empresa.getTelefono() : "");
                DibujarPanel.dibujarPanel(secundario, secundario.getViewport(), eliminarAdministrador.getActualizarAdmin());
                break;
            case JOptionPane.CANCEL_OPTION:
                break;
        }

    }

    public void actualizarAdministrador() {
        if (clavesIguales()) {
            UsuarioVO newAdmin = new UsuarioVO();
            newAdmin.setClave(new String(eliminarAdministrador.getContrasenaPF().getPassword()));
            newAdmin.setCorreo(eliminarAdministrador.getCorreoTF().getText());
            try {
                newAdmin.setDni(new Long(eliminarAdministrador.getDniTF().getText()));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(eliminarAdministrador, "El campo DNI debe ser un numero", "Error", JOptionPane.ERROR_MESSAGE);
                eliminarAdministrador.getDniTF().requestFocus();
                return;
            }
            newAdmin.setEmpresasNIT(new Integer(eliminarAdministrador.getNitTF().getText()));
            newAdmin.setNombre(eliminarAdministrador.getNombreTF().getText());
            newAdmin.setNombreDeUsuario(eliminarAdministrador.getNombreDeUsuarioTF().getText());
            newAdmin.setRol(Rol.fromLabel(eliminarAdministrador.getRolTF().getText()));
            try {
                if (ServiceFactory.getInstance().getUsuarioService().validarCampos(newAdmin)) {
                    ServiceFactory.getInstance().getUsuarioService().delete(usuarioVO.getDni());
                    ServiceFactory.getInstance().getUsuarioService().create(newAdmin);
                }
            } catch (PreexistingEntityException | NonexistentEntityException | RequiredAttributeException | InvalidAttributeException | InsufficientPermissionsException ex) {
                JOptionPane.showMessageDialog(eliminarAdministrador, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(secundario, "Primer Administrador Eliminado y nuevo Primer Administrador asignado satisfactoriamente!", "Exito!", JOptionPane.INFORMATION_MESSAGE);
            secundario.setVisible(false);
            secundario = new Secundario();
        } else {
            JOptionPane.showMessageDialog(secundario, "Las contraseñas no coinciden!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean clavesIguales() {
        return (Arrays.equals(eliminarAdministrador.getContrasenaPF().getPassword(), eliminarAdministrador.getConfirmarContrasenaPF().getPassword()));
    }
}
