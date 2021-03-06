/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ConsultarEmpresaController;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Felipe
 */
public class ConsultarEmpresa extends javax.swing.JPanel {

    /**
     * Creates new form AdministradorPrincipal
     */
    public ConsultarEmpresa() {
        initComponents();
    }

    public JTable getEmpresaT() {
        return empresaT;
    }

    public JRadioButton getNitRB() {
        return nitRB;
    }

    public JTextField getBuscarTF() {
        return buscarTF;
    }

    public JTextField getDireccionTF() {
        return direccionTF;
    }

    public JTextField getNitTF() {
        return nitTF;
    }

    public JTextField getNivelTF() {
        return nivelTF;
    }

    public JTextField getNombreEmpresaTF() {
        return nombreEmpresaTF;
    }

    public JTextField getTelefonoTF() {
        return telefonoTF;
    }

    public JPanel getConsultarEmpresaP() {
        return mostrarEmpresaP;
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
        mostrarEmpresaP = new javax.swing.JPanel();
        nitTF = new javax.swing.JTextField();
        nombreEmpresaTF = new javax.swing.JTextField();
        nivelTF = new javax.swing.JTextField();
        direccionTF = new javax.swing.JTextField();
        nombreEmpresaL = new javax.swing.JLabel();
        nivelL = new javax.swing.JLabel();
        direccionL = new javax.swing.JLabel();
        telefonoL = new javax.swing.JLabel();
        nitL = new javax.swing.JLabel();
        atrasB = new javax.swing.JButton();
        telefonoTF = new javax.swing.JTextField();
        empresaL = new javax.swing.JLabel();
        bienvenidoL = new javax.swing.JLabel();
        nitRB = new javax.swing.JRadioButton();
        nombreRB = new javax.swing.JRadioButton();
        buscarTF = new javax.swing.JTextField();
        empresaSP = new javax.swing.JScrollPane();
        empresaT = new javax.swing.JTable();
        cancelarB = new javax.swing.JButton();
        verInformacionB = new javax.swing.JButton();
        buscarB = new javax.swing.JButton();

        nitTF.setEditable(false);
        nitTF.setText("000000000");

        nombreEmpresaTF.setEditable(false);
        nombreEmpresaTF.setText("Nombre");

        nivelTF.setEditable(false);
        nivelTF.setText("Nivel");

        direccionTF.setEditable(false);
        direccionTF.setText("Calle Falsa 123");

        nombreEmpresaL.setText("Nombre:");

        nivelL.setText("Nivel:");

        direccionL.setText("Dirección:");

        telefonoL.setText("Teléfono:");

        nitL.setText("NIT: ");

        atrasB.setText("Atrás");
        atrasB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBActionPerformed(evt);
            }
        });

        telefonoTF.setEditable(false);

        empresaL.setText("Empresa:");

        org.jdesktop.layout.GroupLayout mostrarEmpresaPLayout = new org.jdesktop.layout.GroupLayout(mostrarEmpresaP);
        mostrarEmpresaP.setLayout(mostrarEmpresaPLayout);
        mostrarEmpresaPLayout.setHorizontalGroup(
            mostrarEmpresaPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(mostrarEmpresaPLayout.createSequentialGroup()
                .addContainerGap()
                .add(mostrarEmpresaPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(mostrarEmpresaPLayout.createSequentialGroup()
                        .add(155, 155, 155)
                        .add(atrasB))
                    .add(mostrarEmpresaPLayout.createSequentialGroup()
                        .add(mostrarEmpresaPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(mostrarEmpresaPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(nitL)
                                .add(empresaL))
                            .add(mostrarEmpresaPLayout.createSequentialGroup()
                                .add(27, 27, 27)
                                .add(mostrarEmpresaPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(nivelL)
                                    .add(nombreEmpresaL)
                                    .add(direccionL)
                                    .add(telefonoL))))
                        .add(18, 18, 18)
                        .add(mostrarEmpresaPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(mostrarEmpresaPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(nombreEmpresaTF)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, nivelTF)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, nitTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 271, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, direccionTF)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, telefonoTF))))
                .add(26, 26, 26))
        );
        mostrarEmpresaPLayout.setVerticalGroup(
            mostrarEmpresaPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, mostrarEmpresaPLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .add(empresaL)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(mostrarEmpresaPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nitL)
                    .add(nitTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(mostrarEmpresaPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nombreEmpresaTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(nombreEmpresaL))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(mostrarEmpresaPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(nivelTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(nivelL))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(mostrarEmpresaPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(direccionL)
                    .add(direccionTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(mostrarEmpresaPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(telefonoTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(telefonoL))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(atrasB)
                .addContainerGap())
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

        verInformacionB.setText("Ver información");
        verInformacionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInformacionBActionPerformed(evt);
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
                .add(16, 16, 16)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(verInformacionB)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cancelarB))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                        .add(org.jdesktop.layout.GroupLayout.LEADING, empresaSP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 520, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(layout.createSequentialGroup()
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                    .add(nitRB)
                                    .add(18, 18, 18)
                                    .add(nombreRB)
                                    .add(246, 246, 246))
                                .add(org.jdesktop.layout.GroupLayout.TRAILING, buscarTF)
                                .add(layout.createSequentialGroup()
                                    .add(bienvenidoL)
                                    .add(336, 336, 336)))
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                            .add(buscarB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 114, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(0, 0, Short.MAX_VALUE))
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
                .add(empresaSP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelarB)
                    .add(verInformacionB))
                .add(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void verInformacionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verInformacionBActionPerformed
        new ConsultarEmpresaController().mostrarEmpresa();
    }//GEN-LAST:event_verInformacionBActionPerformed

    private void cancelarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBActionPerformed
        new ConsultarEmpresaController().cancelar();
    }//GEN-LAST:event_cancelarBActionPerformed

    private void atrasBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBActionPerformed
       new ConsultarEmpresaController().consultarEmpresa();
    }//GEN-LAST:event_atrasBActionPerformed

    private void buscarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBActionPerformed
        new ConsultarEmpresaController().buscar();
    }//GEN-LAST:event_buscarBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atrasB;
    private javax.swing.JLabel bienvenidoL;
    private javax.swing.JButton buscarB;
    private javax.swing.JTextField buscarTF;
    private javax.swing.ButtonGroup busquedaBG;
    private javax.swing.JButton cancelarB;
    private javax.swing.JLabel direccionL;
    private javax.swing.JTextField direccionTF;
    private javax.swing.JLabel empresaL;
    private javax.swing.JScrollPane empresaSP;
    private javax.swing.JTable empresaT;
    private javax.swing.JPanel mostrarEmpresaP;
    private javax.swing.JLabel nitL;
    private javax.swing.JRadioButton nitRB;
    private javax.swing.JTextField nitTF;
    private javax.swing.JLabel nivelL;
    private javax.swing.JTextField nivelTF;
    private javax.swing.JLabel nombreEmpresaL;
    private javax.swing.JTextField nombreEmpresaTF;
    private javax.swing.JRadioButton nombreRB;
    private javax.swing.JLabel telefonoL;
    private javax.swing.JTextField telefonoTF;
    private javax.swing.JButton verInformacionB;
    // End of variables declaration//GEN-END:variables
}
