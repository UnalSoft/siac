package controller;

import static controller.ConsultarUsuarioController.secundario;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JViewport;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.dao.exceptions.NonexistentEntityException;
import model.entity.Nivel;
import model.entity.Rol;
import model.service.ServiceFactory;
import model.vo.EmpresaVO;
import model.vo.ErrorVO;
import model.vo.UsuarioVO;
import model.vo.VersionVO;
import util.DibujarPanel;
import view.ConsultarEmpresa;
import view.ConsultarUsuario;
import view.CrearEmpresa;
import view.EliminarEmpresa;
import view.EliminarUsuario;
import view.ModificarEmpresa;
import view.ModificarUsuario;
import view.Principal;
import view.Secundario;

/**
 *
 * @author Alexander
 */
public class ProveedorTIPrincipalController {

    static Principal principal;
    static Secundario secundario;
    private static final String EXT = "siac";

    public static void cambiarPanel(JViewport contenedor, JPanel panel) {
        contenedor.setVisible(false);
        contenedor.removeAll();
        contenedor.add(panel);
        contenedor.setSize(panel.getPreferredSize());
        contenedor.setVisible(true);
    }

    public void crearEmpresa() {
        secundario = new Secundario();
        secundario.setLocationRelativeTo(principal);
        CrearEmpresa crearEmpresa = new CrearEmpresa();
        crearEmpresa.getNivelTF().setText(Nivel.DISTRIBUIDORA.getText());
        crearEmpresa.getRolTF().setText(Rol.PRIMER_ADMINISTRADOR.getLabel());
        secundario.setSize(crearEmpresa.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(secundario.getViewport(), crearEmpresa);
    }

    public void consultarEmpresa() {
        secundario = new Secundario();
        secundario.setLocationRelativeTo(principal);
        ConsultarEmpresa consultarEmpresa = new ConsultarEmpresa();
        secundario.setSize(consultarEmpresa.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(secundario.getViewport(), consultarEmpresa);
    }

    public void modificarEmpresa() {
        secundario = new Secundario();
        secundario.setLocationRelativeTo(principal);
        ModificarEmpresa modificarEmpresa = new ModificarEmpresa();
        secundario.setSize(modificarEmpresa.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(secundario.getViewport(), modificarEmpresa);
    }

    public void eliminarEmpresa() {
        secundario = new Secundario();
        secundario.setLocationRelativeTo(principal);
        EliminarEmpresa eliminarEmpresa = new EliminarEmpresa();
        secundario.setSize(eliminarEmpresa.getPreferredSize());
        secundario.setVisible(true);
        cambiarPanel(secundario.getViewport(), eliminarEmpresa);
    }

    public void crearCopiaDeSeguridad() {
        String fileName = null;

        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*." + EXT, EXT);
        fc.setFileFilter(filter);

        if (fc.showSaveDialog(principal) == JFileChooser.APPROVE_OPTION) {
            fileName = fc.getSelectedFile().getAbsolutePath();

            if (fileName.endsWith(EXT) == false) {
                fileName += "." + EXT;
            }
        }

        if (fileName != null) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {

                List<EmpresaVO> empresas = ServiceFactory.getInstance().getEmpresaService().getList();
                List<UsuarioVO> usuarios = ServiceFactory.getInstance().getUsuarioService().getList();
                List<ErrorVO> errores = ServiceFactory.getInstance().getErrorService().getList();

                oos.writeObject(empresas.size() + usuarios.size() + errores.size() + 1);

                for (EmpresaVO e : empresas) {
                    e.setUsuarioList(null);
                    oos.writeObject(e);                    
                }
                for (UsuarioVO u : usuarios) {
                    oos.writeObject(u);                    
                }
                for (ErrorVO e : errores) {
                    oos.writeObject(e);
                }
                oos.writeObject(ServiceFactory.getInstance().getVersionService().getVersion());
                
                oos.close();

                JOptionPane.showMessageDialog(principal, "Copia de seguridad guardada con éxito!", "Copia Exitosa", JOptionPane.INFORMATION_MESSAGE, null);

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(principal, "Falló el proceso de copia de seguridad\n\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
            }
        } else {
            JOptionPane.showMessageDialog(principal, "Nombre de archivo inválido", "Error", JOptionPane.ERROR_MESSAGE, null);
        }


    }

    public void restablecerCopiaDeSeguridad() {
        if (JOptionPane.showConfirmDialog(principal, "Al restablecer una copia de seguridad se borrarán todos los datos actuales...\n\n"
                + "¿Desea Continuar?", "Atencion!", JOptionPane.WARNING_MESSAGE) == JOptionPane.OK_OPTION) {
            String fileName;

            JFileChooser fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("*." + EXT, EXT);
            fc.setFileFilter(filter);

            if (fc.showOpenDialog(principal) == JFileChooser.APPROVE_OPTION) {
                try {
                    ServiceFactory.getInstance().getVersionService().removeAll();
                    ServiceFactory.getInstance().getErrorService().removeAll();
                    ServiceFactory.getInstance().getUsuarioService().removeAll();
                    ServiceFactory.getInstance().getEmpresaService().removeAll();
                } catch (NonexistentEntityException ex) {
                    JOptionPane.showMessageDialog(principal, "Recuperación de copia de seguridad Fallida\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
                    return;
                }

                fileName = fc.getSelectedFile().getAbsolutePath();

                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
                    int n = (Integer) ois.readObject();
                    for (int i = 0; i < n; i++) {
                        Object readObject = ois.readObject();
                        if (readObject instanceof UsuarioVO) {
                            String clave = ((UsuarioVO) readObject).getClave();
                            ((UsuarioVO) readObject).setClave("passwordTemporal");
                            ServiceFactory.getInstance().getUsuarioService().create((UsuarioVO) readObject);
                            ((UsuarioVO) readObject).setClave(clave);
                            ServiceFactory.getInstance().getUsuarioService().update((UsuarioVO) readObject);
                        } else if (readObject instanceof EmpresaVO) {
                            ServiceFactory.getInstance().getEmpresaService().create((EmpresaVO) readObject);
                        } else if (readObject instanceof ErrorVO) {
                            ServiceFactory.getInstance().getErrorService().create((ErrorVO) readObject);
                        } else if (readObject instanceof VersionVO) {
                            ServiceFactory.getInstance().getVersionService().create((VersionVO) readObject);
                        }
                    }
                    
                    ois.close();
                    
                    JOptionPane.showMessageDialog(principal, "Copia de seguridad recuperada con éxito!", "Recuperación Exitosa", JOptionPane.INFORMATION_MESSAGE, null);

                } catch (Exception exc) {
                    exc.printStackTrace();
                    JOptionPane.showMessageDialog(principal, "Recuperación de copia de seguridad Fallida\n" + exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE, null);
                }

            }
        }
    }
}
