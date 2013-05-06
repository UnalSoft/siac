/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;

/**
 *
 * @author Felipe
 */
public class EliminarUsuario extends javax.swing.JPanel {

    /**
     * Creates new form AdministradorPrincipal
     */
    public EliminarUsuario() {
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
        ventanaConfirmacionD = new javax.swing.JDialog();
        ventanaConfirmacionOP = new javax.swing.JOptionPane();
        panelSupP = new javax.swing.JPanel();
        AdministradorL = new javax.swing.JLabel();
        bienvenidoL = new javax.swing.JLabel();
        panelInfP = new javax.swing.JPanel();
        dniRB = new javax.swing.JRadioButton();
        nombreRB = new javax.swing.JRadioButton();
        buscarTF = new javax.swing.JTextField();
        buscarB = new javax.swing.JToggleButton();
        usuarioSP = new javax.swing.JScrollPane();
        usuarioT = new javax.swing.JTable();
        cancelarB = new javax.swing.JButton();
        eliminarB = new javax.swing.JButton();

        ventanaConfirmacionOP.setMessage("¿Realmente desea eliminar al usuario?");
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

        panelSupP.setBackground(new java.awt.Color(181, 181, 181));
        panelSupP.setLayout(null);

        AdministradorL.setText("SIAC - Empresa");
        panelSupP.add(AdministradorL);
        AdministradorL.setBounds(6, 7, 100, 16);

        bienvenidoL.setText("Buscar por:");

        panelInfP.setBackground(new java.awt.Color(181, 181, 181));
        panelInfP.setLayout(null);

        dniRB.setText("DNI");

        busquedaBG.add(nombreRB);
        nombreRB.setText("Nombre");

        buscarTF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        buscarB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        buscarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Consultar.png"))); // NOI18N
        buscarB.setText("Buscar");

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

        eliminarB.setText("Eliminar");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelSupP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(panelInfP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .add(layout.createSequentialGroup()
                                .add(dniRB)
                                .add(18, 18, 18)
                                .add(nombreRB))
                            .add(bienvenidoL)
                            .add(layout.createSequentialGroup()
                                .add(buscarTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 277, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(buscarB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(usuarioSP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 520, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(panelSupP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
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
                    .add(eliminarB))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(panelInfP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AdministradorL;
    private javax.swing.JLabel bienvenidoL;
    private javax.swing.JToggleButton buscarB;
    private javax.swing.JTextField buscarTF;
    private javax.swing.ButtonGroup busquedaBG;
    private javax.swing.JButton cancelarB;
    private javax.swing.JRadioButton dniRB;
    private javax.swing.JButton eliminarB;
    private javax.swing.JRadioButton nombreRB;
    private javax.swing.JPanel panelInfP;
    private javax.swing.JPanel panelSupP;
    private javax.swing.JScrollPane usuarioSP;
    private javax.swing.JTable usuarioT;
    private javax.swing.JDialog ventanaConfirmacionD;
    private javax.swing.JOptionPane ventanaConfirmacionOP;
    // End of variables declaration//GEN-END:variables
}
