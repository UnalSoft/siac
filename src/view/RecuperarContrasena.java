/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.RecuperarContrasenaController;
import javax.swing.JTextField;

/**
 *
 * @author Felipe
 */
public class RecuperarContrasena extends javax.swing.JPanel {

    /**
     * Creates new form RecuperarContrasena
     */
    public RecuperarContrasena() {
        initComponents();
    }

    public JTextField getEmailTF() {
        return emailTF;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailL = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        cancelarB = new javax.swing.JButton();
        restablecerContrasenaB = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(0, 0));
        setPreferredSize(new java.awt.Dimension(400, 210));

        emailL.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        emailL.setText("Email:");
        emailL.setToolTipText("");

        emailTF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        cancelarB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cancelarB.setText("Cancelar");
        cancelarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBActionPerformed(evt);
            }
        });

        restablecerContrasenaB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        restablecerContrasenaB.setText("Restablecer Contraseña");
        restablecerContrasenaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restablecerContrasenaBActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(cancelarB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 127, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(restablecerContrasenaB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 203, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(emailL)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(emailTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 291, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(emailTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(emailL))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(restablecerContrasenaB)
                    .add(cancelarB))
                .add(43, 43, 43))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBActionPerformed
        RecuperarContrasenaController.mostrarLogin();
    }//GEN-LAST:event_cancelarBActionPerformed

    private void restablecerContrasenaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restablecerContrasenaBActionPerformed
        RecuperarContrasenaController.restablecerContrasena(emailTF.getText());
    }//GEN-LAST:event_restablecerContrasenaBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarB;
    private javax.swing.JLabel emailL;
    private javax.swing.JTextField emailTF;
    private javax.swing.JButton restablecerContrasenaB;
    // End of variables declaration//GEN-END:variables
}
