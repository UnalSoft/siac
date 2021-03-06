/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EliminarEmpresaController;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Felipe
 */
public class EliminarEmpresa extends javax.swing.JPanel {

    /**
     * Creates new form AdministradorPrincipal
     */
    public EliminarEmpresa() {
        initComponents();
    }

    public JTextField getBuscarTF() {
        return buscarTF;
    }

    public JTable getEmpresaT() {
        return empresaT;
    }

    public JRadioButton getNitRB() {
        return nitRB;
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
        ventanaConfirmacionD = new javax.swing.JDialog();
        ventanaConfirmacionOP = new javax.swing.JOptionPane();
        bienvenidoL = new javax.swing.JLabel();
        nitRB = new javax.swing.JRadioButton();
        nombreRB = new javax.swing.JRadioButton();
        buscarTF = new javax.swing.JTextField();
        empresaSP = new javax.swing.JScrollPane();
        empresaT = new javax.swing.JTable();
        cancelarB = new javax.swing.JButton();
        eliminarB = new javax.swing.JButton();
        buscarB = new javax.swing.JButton();

        ventanaConfirmacionOP.setMessage("¿Realmente desea eliminar a la empresa?");
        ventanaConfirmacionOP.setMessageType(JOptionPane.WARNING_MESSAGE);
        ventanaConfirmacionOP.setOptionType(JOptionPane.OK_CANCEL_OPTION);

        org.jdesktop.layout.GroupLayout ventanaConfirmacionDLayout = new org.jdesktop.layout.GroupLayout(ventanaConfirmacionD.getContentPane());
        ventanaConfirmacionD.getContentPane().setLayout(ventanaConfirmacionDLayout);
        ventanaConfirmacionDLayout.setHorizontalGroup(
            ventanaConfirmacionDLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(ventanaConfirmacionOP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        ventanaConfirmacionDLayout.setVerticalGroup(
            ventanaConfirmacionDLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(ventanaConfirmacionOP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 112, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        bienvenidoL.setText("Buscar por:");

        busquedaBG.add(nitRB);
        nitRB.setSelected(true);
        nitRB.setText("NIT");

        busquedaBG.add(nombreRB);
        nombreRB.setText("Nombre");

        buscarTF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        empresaT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NIT", "Nombre", "Nivel", "Dirección", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        empresaSP.setViewportView(empresaT);

        cancelarB.setText("Cancelar");
        cancelarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBActionPerformed(evt);
            }
        });

        eliminarB.setText("Eliminar");
        eliminarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBActionPerformed(evt);
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
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(layout.createSequentialGroup()
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(cancelarB)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(eliminarB))
                    .add(org.jdesktop.layout.GroupLayout.LEADING, layout.createSequentialGroup()
                        .add(16, 16, 16)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(bienvenidoL)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                .add(org.jdesktop.layout.GroupLayout.LEADING, empresaSP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 520, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(layout.createSequentialGroup()
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(buscarTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 277, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(layout.createSequentialGroup()
                                            .add(nitRB)
                                            .add(18, 18, 18)
                                            .add(nombreRB)))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(buscarB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))))
                .add(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(bienvenidoL)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nitRB)
                    .add(nombreRB))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(buscarTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(buscarB))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(empresaSP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 28, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelarB)
                    .add(eliminarB))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBActionPerformed
        new EliminarEmpresaController().buscar();
    }//GEN-LAST:event_buscarBActionPerformed

    private void cancelarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBActionPerformed
        new EliminarEmpresaController().cancelar();
    }//GEN-LAST:event_cancelarBActionPerformed

    private void eliminarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBActionPerformed
        new EliminarEmpresaController().eliminarEmpresa();
    }//GEN-LAST:event_eliminarBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bienvenidoL;
    private javax.swing.JButton buscarB;
    private javax.swing.JTextField buscarTF;
    private javax.swing.ButtonGroup busquedaBG;
    private javax.swing.JButton cancelarB;
    private javax.swing.JButton eliminarB;
    private javax.swing.JScrollPane empresaSP;
    private javax.swing.JTable empresaT;
    private javax.swing.JRadioButton nitRB;
    private javax.swing.JRadioButton nombreRB;
    private javax.swing.JDialog ventanaConfirmacionD;
    private javax.swing.JOptionPane ventanaConfirmacionOP;
    // End of variables declaration//GEN-END:variables
}
