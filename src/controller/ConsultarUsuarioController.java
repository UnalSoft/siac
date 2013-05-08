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
import model.service.UsuarioService;
import model.vo.UsuarioVO;
import view.ConsultarUsuario;
import view.Principal;
import view.Secundario;

/**
 *
 * @author Felipe
 */
public class ConsultarUsuarioController {
    
    static Principal principal;
    static Secundario secundario;
    static ConsultarUsuario consultarUsuario = new ConsultarUsuario();
    List<UsuarioVO> usuariosList = ServiceFactory.getInstance()
            .getUsuarioService().getList();
    DefaultTableModel model = (DefaultTableModel)consultarUsuario.getUsuarioT()
            .getModel();
    
    public void llenarTabla(){
        for(UsuarioVO usuarioVO : usuariosList){
            if(usuarioVO.getEmpresasNIT().equals
                    (LoginController.usuarioActivo.getEmpresasNIT())){
                Object [] datos = {usuarioVO.getDni(), usuarioVO.getNombre(),
                    usuarioVO.getCorreo(), usuarioVO.getRol(),
                    usuarioVO.getEmpresasNIT()};
                model.addRow(datos);
            }
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
        secundario.setLocationRelativeTo(principal);
        secundario.setSize(consultarUsuario.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(secundario.getViewport(), consultarUsuario);
        llenarTabla();
    }

    public void buscar() {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();  
        if (consultarUsuario.getDniRB().isSelected()) {
            for (UsuarioVO usuarioVO : usuariosList) {
                if (usuarioVO.getDni().toString()
                        .equals(consultarUsuario.getBuscarTF().getText())&&
                        usuarioVO.getEmpresasNIT().equals
                        (LoginController.usuarioActivo.getEmpresasNIT())) {
                    Object[] datos = {usuarioVO.getDni(), usuarioVO.getNombre(),
                        usuarioVO.getCorreo(), usuarioVO.getRol(),
                        usuarioVO.getEmpresasNIT()};
                    model.addRow(datos);
                }
            }
        }else{
            for (UsuarioVO usuarioVO : usuariosList) {
                if (usuarioVO.getNombre().toString()
                        .equals(consultarUsuario.getBuscarTF().getText())&&
                        usuarioVO.getEmpresasNIT().equals
                        (LoginController.usuarioActivo.getEmpresasNIT())) {
                    Object[] datos = {usuarioVO.getDni(), usuarioVO.getNombre(),
                        usuarioVO.getCorreo(), usuarioVO.getRol(),
                        usuarioVO.getEmpresasNIT()};
                    model.addRow(datos);
                }
            }
        }
    }

}
