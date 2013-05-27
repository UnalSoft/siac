/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ConsultarUsuarioController;
import controller.LoginController;
import javax.swing.JLabel;

/**
 *
 * @author Felipe
 */
public class ConsultarPrincipal extends javax.swing.JPanel {

    /**
     * Creates new form AdministradorPrincipal
     */
    public ConsultarPrincipal() {
        initComponents();
    }
    
    public JLabel getNombreEmpresaL() {
        return nombreEmpresaL;
    }

    public JLabel getNombreUsuarioL() {
        return nombreUsuarioL;
    }

    public JLabel getRolL() {
        return rolL;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cerrarSesionB = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        accionesL = new javax.swing.JLabel();
        consultarUsuariosP = new javax.swing.JPanel();
        consultarB = new javax.swing.JButton();
        bienvenidoL = new javax.swing.JLabel();
        nombreUsuarioL = new javax.swing.JLabel();
        registradoL = new javax.swing.JLabel();
        nombreEmpresaL = new javax.swing.JLabel();
        rolLabelL = new javax.swing.JLabel();
        rolL = new javax.swing.JLabel();

        cerrarSesionB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/CerrarSesion.png"))); // NOI18N
        cerrarSesionB.setText("Cerrar sesión");
        cerrarSesionB.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cerrarSesionB.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        cerrarSesionB.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        cerrarSesionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionBActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/User.png"))); // NOI18N

        accionesL.setText("Las acciones que puede realizar son:");

        consultarUsuariosP.setBorder(javax.swing.BorderFactory.createTitledBorder("Consultar Usuarios de Empresa"));

        consultarB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        consultarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Consultar.png"))); // NOI18N
        consultarB.setText("Consultar");
        consultarB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        consultarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarBActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout consultarUsuariosPLayout = new org.jdesktop.layout.GroupLayout(consultarUsuariosP);
        consultarUsuariosP.setLayout(consultarUsuariosPLayout);
        consultarUsuariosPLayout.setHorizontalGroup(
            consultarUsuariosPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(consultarUsuariosPLayout.createSequentialGroup()
                .add(140, 140, 140)
                .add(consultarB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );
        consultarUsuariosPLayout.setVerticalGroup(
            consultarUsuariosPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(consultarUsuariosPLayout.createSequentialGroup()
                .addContainerGap()
                .add(consultarB)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        bienvenidoL.setText("Bienvenido de nuevo: ");

        nombreUsuarioL.setText("Administrador de TI");

        registradoL.setText("Esta registrado en la empresa: ");

        nombreEmpresaL.setText("UnalSoft S.A.S.");

        rolLabelL.setText("Su rol en esta empresa es: ");

        rolL.setText("Proveedor de TI");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(25, 25, 25)
                .add(jLabel2)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(rolLabelL)
                        .add(18, 18, 18)
                        .add(rolL)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(registradoL)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(nombreEmpresaL))
                    .add(layout.createSequentialGroup()
                        .add(bienvenidoL)
                        .add(18, 18, 18)
                        .add(nombreUsuarioL)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 18, Short.MAX_VALUE)
                .add(cerrarSesionB))
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(accionesL))
                    .add(layout.createSequentialGroup()
                        .add(41, 41, 41)
                        .add(consultarUsuariosP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(17, 17, 17)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel2)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(bienvenidoL)
                                    .add(nombreUsuarioL))
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(registradoL)
                                    .add(nombreEmpresaL))
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(rolLabelL)
                                    .add(rolL)))))
                    .add(cerrarSesionB))
                .add(29, 29, 29)
                .add(accionesL)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(consultarUsuariosP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void consultarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarBActionPerformed
        ConsultarUsuarioController consultarUsuarioController = new ConsultarUsuarioController();
        consultarUsuarioController.consultarUsuario();
    }//GEN-LAST:event_consultarBActionPerformed

    private void cerrarSesionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionBActionPerformed
        LoginController.cerrarSesion();
    }//GEN-LAST:event_cerrarSesionBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accionesL;
    private javax.swing.JLabel bienvenidoL;
    private javax.swing.JButton cerrarSesionB;
    private javax.swing.JButton consultarB;
    private javax.swing.JPanel consultarUsuariosP;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel nombreEmpresaL;
    private javax.swing.JLabel nombreUsuarioL;
    private javax.swing.JLabel registradoL;
    private javax.swing.JLabel rolL;
    private javax.swing.JLabel rolLabelL;
    // End of variables declaration//GEN-END:variables
}
