/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ModificarAdministradorController;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Felipe
 */
public class ModificarAdministrador extends javax.swing.JPanel {

    /**
     * Creates new form AdministradorPrincipal
     */
    public ModificarAdministrador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        busquedaBG = new javax.swing.ButtonGroup();
        modificarUsuarioP = new javax.swing.JPanel();
        dniL = new javax.swing.JLabel();
        nombreL = new javax.swing.JLabel();
        nombreTF = new javax.swing.JTextField();
        dniTF = new javax.swing.JTextField();
        nombreDeUsuarioL = new javax.swing.JLabel();
        nombreDeUsuarioTF = new javax.swing.JTextField();
        correoL = new javax.swing.JLabel();
        rolL = new javax.swing.JLabel();
        correoTF = new javax.swing.JTextField();
        rolCB = new javax.swing.JComboBox();
        cancelarB1 = new javax.swing.JButton();
        modificarB1 = new javax.swing.JButton();
        bienvenidoL = new javax.swing.JLabel();
        dniRB = new javax.swing.JRadioButton();
        nombreRB = new javax.swing.JRadioButton();
        buscarTF = new javax.swing.JTextField();
        usuarioSP = new javax.swing.JScrollPane();
        usuarioT = new javax.swing.JTable();
        cancelarB = new javax.swing.JButton();
        modificarB = new javax.swing.JButton();
        buscarB = new javax.swing.JButton();

        dniL.setText("DNI:");

        nombreL.setText("Nombre:");

        dniTF.setEditable(false);

        nombreDeUsuarioL.setText("Nombre de usuario:");

        correoL.setText("Correo:");

        rolL.setText("Rol:");

        rolCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Primer Administrador" }));
        rolCB.setEnabled(false);

        cancelarB1.setText("Cancelar");
        cancelarB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarB1ActionPerformed(evt);
            }
        });

        modificarB1.setText("Modificar");
        modificarB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarB1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout modificarUsuarioPLayout = new org.jdesktop.layout.GroupLayout(modificarUsuarioP);
        modificarUsuarioP.setLayout(modificarUsuarioPLayout);
        modificarUsuarioPLayout.setHorizontalGroup(
            modificarUsuarioPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(modificarUsuarioPLayout.createSequentialGroup()
                .add(40, 40, 40)
                .add(modificarUsuarioPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(modificarUsuarioPLayout.createSequentialGroup()
                        .add(modificarUsuarioPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(nombreL)
                            .add(dniL)
                            .add(nombreDeUsuarioL))
                        .add(22, 22, 22)
                        .add(modificarUsuarioPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, nombreDeUsuarioTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 228, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, dniTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 228, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, nombreTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 228, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(modificarUsuarioPLayout.createSequentialGroup()
                        .add(modificarUsuarioPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(correoL)
                            .add(rolL))
                        .add(100, 100, 100)
                        .add(modificarUsuarioPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, correoTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 228, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(modificarUsuarioPLayout.createSequentialGroup()
                                .add(cancelarB1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(modificarB1))
                            .add(rolCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 175, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        modificarUsuarioPLayout.setVerticalGroup(
            modificarUsuarioPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(modificarUsuarioPLayout.createSequentialGroup()
                .addContainerGap()
                .add(modificarUsuarioPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(dniL)
                    .add(dniTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(modificarUsuarioPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nombreL)
                    .add(nombreTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(modificarUsuarioPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nombreDeUsuarioL)
                    .add(nombreDeUsuarioTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(modificarUsuarioPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(correoTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(correoL))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(modificarUsuarioPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(rolL)
                    .add(rolCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 29, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(modificarUsuarioPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelarB1)
                    .add(modificarB1))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bienvenidoL.setText("Buscar por:");

        busquedaBG.add(dniRB);
        dniRB.setSelected(true);
        dniRB.setText("DNI");

        busquedaBG.add(nombreRB);
        nombreRB.setText("Nombre");

        buscarTF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        usuarioT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Correo", "Rol", "Empresa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usuarioSP.setViewportView(usuarioT);

        cancelarB.setText("Cancelar");
        cancelarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBActionPerformed(evt);
            }
        });

        modificarB.setText("Modificar");
        modificarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarBActionPerformed(evt);
            }
        });

        buscarB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        buscarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Consultar.png"))); // NOI18N
        buscarB.setText("Buscar");
        buscarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(15, 15, 15)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(modificarB)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(cancelarB))
                            .add(layout.createSequentialGroup()
                                .add(dniRB)
                                .add(18, 18, 18)
                                .add(nombreRB))
                            .add(bienvenidoL)
                            .add(usuarioSP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 520, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(0, 6, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(buscarTF)
                        .add(11, 11, 11)
                        .add(buscarB)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(bienvenidoL)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(dniRB)
                    .add(nombreRB))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(buscarTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(buscarB))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(usuarioSP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelarB)
                    .add(modificarB))
                .add(12, 12, 12))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void modificarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarBActionPerformed
        new ModificarAdministradorController().mostrarUsuarioEditable();
    }//GEN-LAST:event_modificarBActionPerformed

    private void cancelarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBActionPerformed
        new ModificarAdministradorController().cancelar();
    }//GEN-LAST:event_cancelarBActionPerformed

    private void cancelarB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarB1ActionPerformed
        new ModificarAdministradorController().listarUsuarios();
    }//GEN-LAST:event_cancelarB1ActionPerformed

    private void modificarB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarB1ActionPerformed
        new ModificarAdministradorController().modificarUsuario();
    }//GEN-LAST:event_modificarB1ActionPerformed

    private void buscarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBActionPerformed
        new ModificarAdministradorController().buscar();
    }//GEN-LAST:event_buscarBActionPerformed

    public JTable getUsuarioT() {
        return usuarioT;
    }

    public JRadioButton getDniRB() {
        return dniRB;
    }

    public JTextField getBuscarTF() {
        return buscarTF;
    }

    public JTextField getCorreoTF() {
        return correoTF;
    }

    public JTextField getDniTF() {
        return dniTF;
    }

    public JTextField getNombreTF() {
        return nombreTF;
    }

    public JPanel getModificarUsuarioP() {
        return modificarUsuarioP;
    }

    public JTextField getNombreDeUsuarioTF() {
        return nombreDeUsuarioTF;
    }

    public JComboBox getRolCB() {
        return rolCB;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bienvenidoL;
    private javax.swing.JButton buscarB;
    private javax.swing.JTextField buscarTF;
    private javax.swing.ButtonGroup busquedaBG;
    private javax.swing.JButton cancelarB;
    private javax.swing.JButton cancelarB1;
    private javax.swing.JLabel correoL;
    private javax.swing.JTextField correoTF;
    private javax.swing.JLabel dniL;
    private javax.swing.JRadioButton dniRB;
    private javax.swing.JTextField dniTF;
    private javax.swing.JButton modificarB;
    private javax.swing.JButton modificarB1;
    private javax.swing.JPanel modificarUsuarioP;
    private javax.swing.JLabel nombreDeUsuarioL;
    private javax.swing.JTextField nombreDeUsuarioTF;
    private javax.swing.JLabel nombreL;
    private javax.swing.JRadioButton nombreRB;
    private javax.swing.JTextField nombreTF;
    private javax.swing.JComboBox rolCB;
    private javax.swing.JLabel rolL;
    private javax.swing.JScrollPane usuarioSP;
    private javax.swing.JTable usuarioT;
    // End of variables declaration//GEN-END:variables
}
