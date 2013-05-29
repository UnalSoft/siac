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
public class AdministradorPrincipal extends javax.swing.JPanel {

    /**
     * Creates new form AdministradorPrincipal
     */
    public AdministradorPrincipal() {
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

        jLabel2 = new javax.swing.JLabel();
        accionesL = new javax.swing.JLabel();
        administrarUsuariosP = new javax.swing.JPanel();
        crearB = new javax.swing.JButton();
        consultarB = new javax.swing.JButton();
        modificarB = new javax.swing.JButton();
        eliminarB = new javax.swing.JButton();
        bienvenidoL = new javax.swing.JLabel();
        nombreUsuarioL = new javax.swing.JLabel();
        registradoL = new javax.swing.JLabel();
        nombreEmpresaL = new javax.swing.JLabel();
        rolLabelL = new javax.swing.JLabel();
        rolL = new javax.swing.JLabel();
        cerrarSesionB = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(590, 360));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/User.png"))); // NOI18N

        accionesL.setText("Las acciones que puede realizar son:");

        administrarUsuariosP.setBorder(javax.swing.BorderFactory.createTitledBorder("Administrar Usuarios de Empresa"));

        crearB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        crearB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Crear.png"))); // NOI18N
        crearB.setText("Crear");
        crearB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        consultarB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        consultarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Consultar.png"))); // NOI18N
        consultarB.setText("Consultar");
        consultarB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        consultarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarBActionPerformed(evt);
            }
        });

        modificarB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        modificarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Modificar.png"))); // NOI18N
        modificarB.setText("Modificar");
        modificarB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        eliminarB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        eliminarB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Eliminar.png"))); // NOI18N
        eliminarB.setText("Eliminar");
        eliminarB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        org.jdesktop.layout.GroupLayout administrarUsuariosPLayout = new org.jdesktop.layout.GroupLayout(administrarUsuariosP);
        administrarUsuariosP.setLayout(administrarUsuariosPLayout);
        administrarUsuariosPLayout.setHorizontalGroup(
            administrarUsuariosPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(administrarUsuariosPLayout.createSequentialGroup()
                .add(31, 31, 31)
                .add(administrarUsuariosPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(crearB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(modificarB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 72, Short.MAX_VALUE)
                .add(administrarUsuariosPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(consultarB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(eliminarB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(38, 38, 38))
        );
        administrarUsuariosPLayout.setVerticalGroup(
            administrarUsuariosPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(administrarUsuariosPLayout.createSequentialGroup()
                .add(16, 16, 16)
                .add(administrarUsuariosPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(crearB)
                    .add(consultarB))
                .add(30, 30, 30)
                .add(administrarUsuariosPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(modificarB)
                    .add(eliminarB))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        bienvenidoL.setText("Bienvenido de nuevo: ");

        nombreUsuarioL.setText("Administrador de TI");

        registradoL.setText("Esta registrado en la empresa: ");

        nombreEmpresaL.setText("UnalSoft S.A.S.");

        rolLabelL.setText("Su rol en esta empresa es: ");

        rolL.setText("Proveedor de TI");

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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(44, 44, 44)
                .add(jLabel2)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(registradoL)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(nombreEmpresaL))
                    .add(layout.createSequentialGroup()
                        .add(rolLabelL)
                        .add(18, 18, 18)
                        .add(rolL))
                    .add(layout.createSequentialGroup()
                        .add(bienvenidoL)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(nombreUsuarioL)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(cerrarSesionB)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(accionesL)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(administrarUsuariosP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                            .add(22, 22, 22)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(bienvenidoL)
                                .add(nombreUsuarioL)))
                        .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .add(cerrarSesionB)
                            .add(42, 42, 42)))
                    .add(layout.createSequentialGroup()
                        .add(22, 22, 22)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(registradoL)
                                    .add(nombreEmpresaL))
                                .add(18, 18, 18)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(rolLabelL)
                                    .add(rolL)))
                            .add(jLabel2))))
                .add(18, 18, 18)
                .add(accionesL)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(administrarUsuariosP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarSesionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionBActionPerformed
        LoginController.cerrarSesion();
    }//GEN-LAST:event_cerrarSesionBActionPerformed

    private void consultarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarBActionPerformed
        new ConsultarUsuarioController().consultarUsuario();
    }//GEN-LAST:event_consultarBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accionesL;
    private javax.swing.JPanel administrarUsuariosP;
    private javax.swing.JLabel bienvenidoL;
    private javax.swing.JButton cerrarSesionB;
    private javax.swing.JButton consultarB;
    private javax.swing.JButton crearB;
    private javax.swing.JButton eliminarB;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton modificarB;
    private javax.swing.JLabel nombreEmpresaL;
    private javax.swing.JLabel nombreUsuarioL;
    private javax.swing.JLabel registradoL;
    private javax.swing.JLabel rolL;
    private javax.swing.JLabel rolLabelL;
    // End of variables declaration//GEN-END:variables
}
