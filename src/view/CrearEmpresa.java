/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CrearEmpresaController;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Felipe
 */
public class CrearEmpresa extends javax.swing.JPanel {
    private final JFrame frame;

    /**
     * Creates new form AdministradorPrincipal
     */
    public CrearEmpresa(JFrame frame) {
        initComponents();
        this.frame = frame;
    }

    public JPasswordField getConfirmarContrasenaPF() {
        return confirmarContrasenaPF;
    }

    public JPasswordField getContrasenaPF() {
        return contrasenaPF;
    }

    public JTextField getCorreoTF() {
        return correoTF;
    }

    public JTextField getDireccionTF() {
        return direccionTF;
    }

    public JTextField getDniTF() {
        return dniTF;
    }

    public JTextField getNitTF() {
        return nitTF;
    }

    public JTextField getNivelTF() {
        return nivelTF;
    }

    public JTextField getNombreDeUsuarioTF() {
        return nombreDeUsuarioTF;
    }

    public JTextField getNombreEmpresaTF() {
        return nombreEmpresaTF;
    }

    public JTextField getNombreTF() {
        return nombreTF;
    }

    public JTextField getRolTF() {
        return rolTF;
    }

    public JTextField getTelefonoTF() {
        return telefonoTF;
    }

    public JFrame getFrame() {
        return frame;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSupP = new javax.swing.JPanel();
        crearEmpresaL = new javax.swing.JLabel();
        panelInfP = new javax.swing.JPanel();
        dniL = new javax.swing.JLabel();
        nombreL = new javax.swing.JLabel();
        nombreTF = new javax.swing.JTextField();
        dniTF = new javax.swing.JTextField();
        nombreDeUsuarioL = new javax.swing.JLabel();
        nombreDeUsuarioTF = new javax.swing.JTextField();
        contrasenaL = new javax.swing.JLabel();
        confirmarContrasenaL = new javax.swing.JLabel();
        correoL = new javax.swing.JLabel();
        rolL = new javax.swing.JLabel();
        contrasenaPF = new javax.swing.JPasswordField();
        confirmarContrasenaPF = new javax.swing.JPasswordField();
        correoTF = new javax.swing.JTextField();
        cancelarB = new javax.swing.JButton();
        crearUsuarioB = new javax.swing.JButton();
        rolTF = new javax.swing.JTextField();
        nitL = new javax.swing.JLabel();
        nombreEmpresaL = new javax.swing.JLabel();
        nivelL = new javax.swing.JLabel();
        direccionL = new javax.swing.JLabel();
        telefonoL = new javax.swing.JLabel();
        nitTF = new javax.swing.JTextField();
        nombreEmpresaTF = new javax.swing.JTextField();
        nivelTF = new javax.swing.JTextField();
        direccionTF = new javax.swing.JTextField();
        telefonoTF = new javax.swing.JTextField();
        separadorS = new javax.swing.JSeparator();
        primerAdministradorL = new javax.swing.JLabel();
        empresaL = new javax.swing.JLabel();

        panelSupP.setBackground(new java.awt.Color(181, 181, 181));
        panelSupP.setLayout(null);

        crearEmpresaL.setText("SIAC - Crear Empresa");
        panelSupP.add(crearEmpresaL);
        crearEmpresaL.setBounds(6, 7, 150, 14);

        panelInfP.setBackground(new java.awt.Color(181, 181, 181));
        panelInfP.setLayout(null);

        dniL.setText("DNI:");

        nombreL.setText("Nombre:");

        nombreDeUsuarioL.setText("Nombre de usuario:");

        contrasenaL.setText("Contraseña:");

        confirmarContrasenaL.setText("Confirmar contraseña:");

        correoL.setText("Correo:");

        rolL.setText("Rol:");

        cancelarB.setText("Cancelar");
        cancelarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBActionPerformed(evt);
            }
        });

        crearUsuarioB.setText("Crear usuario");
        crearUsuarioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearUsuarioBActionPerformed(evt);
            }
        });

        rolTF.setText("Primer Administrador");
        rolTF.setEnabled(false);

        nitL.setText("NIT: ");

        nombreEmpresaL.setText("Nombre:");

        nivelL.setText("Nivel:");

        direccionL.setText("Dirección:");

        telefonoL.setText("Teléfono:");

        nivelTF.setText("Nivel");
        nivelTF.setEnabled(false);

        primerAdministradorL.setText("Primer Administrador");

        empresaL.setText("Empresa:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelInfP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(panelSupP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                    .add(separadorS))
                .add(0, 0, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(29, 29, 29)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(nombreDeUsuarioL)
                            .add(nombreL)
                            .add(dniL)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(contrasenaL)
                                    .add(confirmarContrasenaL)
                                    .add(correoL)
                                    .add(rolL)
                                    .add(nitL)
                                    .add(nombreEmpresaL)
                                    .add(nivelL)
                                    .add(direccionL)
                                    .add(telefonoL))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(nombreTF)
                                    .add(dniTF, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                    .add(nombreDeUsuarioTF)
                                    .add(contrasenaPF)
                                    .add(confirmarContrasenaPF)
                                    .add(correoTF)
                                    .add(rolTF, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                    .add(nitTF)
                                    .add(nombreEmpresaTF)
                                    .add(nivelTF)
                                    .add(direccionTF)
                                    .add(telefonoTF)))))
                    .add(layout.createSequentialGroup()
                        .add(94, 94, 94)
                        .add(cancelarB)
                        .add(65, 65, 65)
                        .add(crearUsuarioB))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(primerAdministradorL))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(empresaL)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(panelSupP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(4, 4, 4)
                .add(empresaL)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nitL)
                    .add(nitTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nombreEmpresaL)
                    .add(nombreEmpresaTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nivelL)
                    .add(nivelTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(direccionL)
                    .add(direccionTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(telefonoL)
                    .add(telefonoTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(separadorS, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(primerAdministradorL)
                .add(5, 5, 5)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(dniL)
                    .add(dniTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nombreL)
                    .add(nombreTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nombreDeUsuarioL)
                    .add(nombreDeUsuarioTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(contrasenaL)
                    .add(contrasenaPF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(confirmarContrasenaL)
                    .add(confirmarContrasenaPF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(correoL)
                    .add(correoTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(rolL)
                    .add(rolTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelarB)
                    .add(crearUsuarioB))
                .add(18, 18, Short.MAX_VALUE)
                .add(panelInfP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void crearUsuarioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearUsuarioBActionPerformed
        CrearEmpresaController.crearEmpresa(this);
    }//GEN-LAST:event_crearUsuarioBActionPerformed

    private void cancelarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBActionPerformed
        frame.dispose();
    }//GEN-LAST:event_cancelarBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarB;
    private javax.swing.JLabel confirmarContrasenaL;
    private javax.swing.JPasswordField confirmarContrasenaPF;
    private javax.swing.JLabel contrasenaL;
    private javax.swing.JPasswordField contrasenaPF;
    private javax.swing.JLabel correoL;
    private javax.swing.JTextField correoTF;
    private javax.swing.JLabel crearEmpresaL;
    private javax.swing.JButton crearUsuarioB;
    private javax.swing.JLabel direccionL;
    private javax.swing.JTextField direccionTF;
    private javax.swing.JLabel dniL;
    private javax.swing.JTextField dniTF;
    private javax.swing.JLabel empresaL;
    private javax.swing.JLabel nitL;
    private javax.swing.JTextField nitTF;
    private javax.swing.JLabel nivelL;
    private javax.swing.JTextField nivelTF;
    private javax.swing.JLabel nombreDeUsuarioL;
    private javax.swing.JTextField nombreDeUsuarioTF;
    private javax.swing.JLabel nombreEmpresaL;
    private javax.swing.JTextField nombreEmpresaTF;
    private javax.swing.JLabel nombreL;
    private javax.swing.JTextField nombreTF;
    private javax.swing.JPanel panelInfP;
    private javax.swing.JPanel panelSupP;
    private javax.swing.JLabel primerAdministradorL;
    private javax.swing.JLabel rolL;
    private javax.swing.JTextField rolTF;
    private javax.swing.JSeparator separadorS;
    private javax.swing.JLabel telefonoL;
    private javax.swing.JTextField telefonoTF;
    // End of variables declaration//GEN-END:variables
}
