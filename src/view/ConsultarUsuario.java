/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ConsultarUsuarioController;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Felipe
 */
public class ConsultarUsuario extends javax.swing.JPanel {

    /**
     * Creates new form AdministradorPrincipal
     */
    public ConsultarUsuario() {
        initComponents();
    }

    public JTable getUsuarioT() {
        return usuarioT;
    }

    public void setUsuarioT(JTable usuarioT) {
        this.usuarioT = usuarioT;
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
        consultaF = new javax.swing.JFrame();
        dniL = new javax.swing.JLabel();
        nombreL = new javax.swing.JLabel();
        nombreTF = new javax.swing.JTextField();
        dniTF = new javax.swing.JTextField();
        nombreDeUsuarioL = new javax.swing.JLabel();
        nombreDeUsuarioTF = new javax.swing.JTextField();
        correoL = new javax.swing.JLabel();
        rolL = new javax.swing.JLabel();
        correoTF = new javax.swing.JTextField();
        atrasB = new javax.swing.JButton();
        rolTF = new javax.swing.JTextField();
        bienvenidoL = new javax.swing.JLabel();
        dniRB = new javax.swing.JRadioButton();
        nombreRB = new javax.swing.JRadioButton();
        buscarTF = new javax.swing.JTextField();
        buscarB = new javax.swing.JButton();
        usuarioSP = new javax.swing.JScrollPane();
        usuarioT = new javax.swing.JTable();
        cancelarB = new javax.swing.JButton();
        verInformacionB = new javax.swing.JButton();

        dniL.setText("DNI:");

        nombreL.setText("Nombre:");

        nombreTF.setEditable(false);

        dniTF.setEditable(false);

        nombreDeUsuarioL.setText("Nombre de usuario:");

        nombreDeUsuarioTF.setEditable(false);

        correoL.setText("Correo:");

        rolL.setText("Rol:");

        correoTF.setEditable(false);

        atrasB.setText("Atrás");
        atrasB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBActionPerformed(evt);
            }
        });

        rolTF.setEditable(false);

        org.jdesktop.layout.GroupLayout consultaFLayout = new org.jdesktop.layout.GroupLayout(consultaF.getContentPane());
        consultaF.getContentPane().setLayout(consultaFLayout);
        consultaFLayout.setHorizontalGroup(
            consultaFLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(consultaFLayout.createSequentialGroup()
                .add(consultaFLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(consultaFLayout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(dniL)
                        .add(102, 102, 102)
                        .add(dniTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 245, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(consultaFLayout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(nombreL)
                        .add(76, 76, 76)
                        .add(nombreTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 245, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(consultaFLayout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(nombreDeUsuarioL)
                        .add(6, 6, 6)
                        .add(nombreDeUsuarioTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 245, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(consultaFLayout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(correoL)
                        .add(84, 84, 84)
                        .add(correoTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 245, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(consultaFLayout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(rolL)
                        .add(106, 106, 106)
                        .add(rolTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 245, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(consultaFLayout.createSequentialGroup()
                        .add(170, 170, 170)
                        .add(atrasB)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        consultaFLayout.setVerticalGroup(
            consultaFLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(consultaFLayout.createSequentialGroup()
                .add(6, 6, 6)
                .add(consultaFLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(consultaFLayout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(dniL))
                    .add(dniTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(consultaFLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(consultaFLayout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(nombreL))
                    .add(nombreTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(consultaFLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(consultaFLayout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(nombreDeUsuarioL))
                    .add(nombreDeUsuarioTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(6, 6, 6)
                .add(consultaFLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(consultaFLayout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(correoL))
                    .add(correoTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(12, 12, 12)
                .add(consultaFLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(consultaFLayout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(rolL))
                    .add(rolTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(12, 12, 12)
                .add(atrasB)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bienvenidoL.setText("Buscar por:");

        busquedaBG.add(dniRB);
        dniRB.setSelected(true);
        dniRB.setText("DNI");

        busquedaBG.add(nombreRB);
        nombreRB.setText("Nombre");

        buscarTF.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N

        buscarB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        buscarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Consultar.png"))); // NOI18N
        buscarB.setText("Buscar");
        buscarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBActionPerformed(evt);
            }
        });

        usuarioT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        verInformacionB.setText("Ver información");
        verInformacionB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verInformacionBActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(15, 15, 15)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(dniRB)
                        .add(18, 18, 18)
                        .add(nombreRB))
                    .add(bienvenidoL)
                    .add(layout.createSequentialGroup()
                        .add(buscarTF, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 277, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(buscarB))
                    .add(usuarioSP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 520, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(269, 269, 269)
                .add(cancelarB)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(verInformacionB)
                .add(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(18, 18, 18)
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
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelarB)
                    .add(verInformacionB))
                .addContainerGap(8, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarBActionPerformed
        new ConsultarUsuarioController().buscar();
    }//GEN-LAST:event_buscarBActionPerformed

    private void cancelarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBActionPerformed
        new ConsultarUsuarioController().cancelar();
    }//GEN-LAST:event_cancelarBActionPerformed

    private void verInformacionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verInformacionBActionPerformed
        new ConsultarUsuarioController().mostrarUsuario();
    }//GEN-LAST:event_verInformacionBActionPerformed

    private void atrasBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBActionPerformed
        new ConsultarUsuarioController().ocultarUsuario();
    }//GEN-LAST:event_atrasBActionPerformed

    public JTextField getBuscarTF() {
        return buscarTF;
    }

    public void setBuscarTF(JTextField buscarTF) {
        this.buscarTF = buscarTF;
    }

    public JRadioButton getDniRB() {
        return dniRB;
    }

    public void setDniRB(JRadioButton dniRB) {
        this.dniRB = dniRB;
    }

    public JFrame getConsultaF() {
        return consultaF;
    }

    public JTextField getCorreoTF() {
        return correoTF;
    }

    public JTextField getDniTF() {
        return dniTF;
    }

    public JTextField getNombreDeUsuarioTF() {
        return nombreDeUsuarioTF;
    }

    public JTextField getNombreTF() {
        return nombreTF;
    }

    public JTextField getRolTF() {
        return rolTF;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atrasB;
    private javax.swing.JLabel bienvenidoL;
    private javax.swing.JButton buscarB;
    private static javax.swing.JTextField buscarTF;
    private javax.swing.ButtonGroup busquedaBG;
    private javax.swing.JButton cancelarB;
    private javax.swing.JFrame consultaF;
    private javax.swing.JLabel correoL;
    private javax.swing.JTextField correoTF;
    private javax.swing.JLabel dniL;
    private static javax.swing.JRadioButton dniRB;
    private javax.swing.JTextField dniTF;
    private javax.swing.JLabel nombreDeUsuarioL;
    private javax.swing.JTextField nombreDeUsuarioTF;
    private javax.swing.JLabel nombreL;
    private javax.swing.JRadioButton nombreRB;
    private javax.swing.JTextField nombreTF;
    private javax.swing.JLabel rolL;
    private javax.swing.JTextField rolTF;
    private javax.swing.JScrollPane usuarioSP;
    private static javax.swing.JTable usuarioT;
    private javax.swing.JButton verInformacionB;
    // End of variables declaration//GEN-END:variables
}
