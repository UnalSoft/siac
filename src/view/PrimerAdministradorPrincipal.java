/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ConsultarAdministradorController;
import controller.ConsultarEmpresaController;
import controller.ConsultarUsuarioController;
import controller.CrearEmpresaController;
import controller.CrearUsuarioController;
import controller.EliminarUsuarioController;
import controller.LoginController;
import controller.ModificarAdministradorController;
import controller.ModificarUsuarioController;
import javax.swing.JLabel;

/**
 *
 * @author Felipe
 */
public class PrimerAdministradorPrincipal extends javax.swing.JPanel {

    /**
     * Creates new form AdministradorPrincipal
     */
    public PrimerAdministradorPrincipal() {
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
        consultarUsuarioB = new javax.swing.JButton();
        modificarUsuarioB = new javax.swing.JButton();
        eliminarUsuarioB = new javax.swing.JButton();
        crearUsuarioB = new javax.swing.JButton();
        administrarPrimerAdminP = new javax.swing.JPanel();
        consultarPrimerAdminB = new javax.swing.JButton();
        modificarPrimerAdminB = new javax.swing.JButton();
        eliminarPrimerAdminB = new javax.swing.JButton();
        administrarNivelP = new javax.swing.JPanel();
        crearEmpresaB = new javax.swing.JButton();
        consultarEmpresaB = new javax.swing.JButton();
        modificarEmpresaB = new javax.swing.JButton();
        eliminarEmpresaB = new javax.swing.JButton();
        bienvenidoL = new javax.swing.JLabel();
        nombreUsuarioL = new javax.swing.JLabel();
        registradoL = new javax.swing.JLabel();
        nombreEmpresaL = new javax.swing.JLabel();
        rolLabelL = new javax.swing.JLabel();
        rolL = new javax.swing.JLabel();
        cerrarSesionB = new javax.swing.JButton();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/User.png"))); // NOI18N

        accionesL.setText("Las acciones que puede realizar son:");

        administrarUsuariosP.setBorder(javax.swing.BorderFactory.createTitledBorder("Administrar Usuarios de Empresa"));

        consultarUsuarioB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        consultarUsuarioB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Consultar.png"))); // NOI18N
        consultarUsuarioB.setText("Consultar");
        consultarUsuarioB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        consultarUsuarioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarUsuarioBActionPerformed(evt);
            }
        });

        modificarUsuarioB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        modificarUsuarioB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Modificar.png"))); // NOI18N
        modificarUsuarioB.setText("Modificar");
        modificarUsuarioB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        modificarUsuarioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarUsuarioBActionPerformed(evt);
            }
        });

        eliminarUsuarioB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        eliminarUsuarioB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Eliminar.png"))); // NOI18N
        eliminarUsuarioB.setText("Eliminar");
        eliminarUsuarioB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        eliminarUsuarioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarUsuarioBActionPerformed(evt);
            }
        });

        crearUsuarioB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        crearUsuarioB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Crear.png"))); // NOI18N
        crearUsuarioB.setText("Crear");
        crearUsuarioB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        crearUsuarioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearUsuarioBActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout administrarUsuariosPLayout = new org.jdesktop.layout.GroupLayout(administrarUsuariosP);
        administrarUsuariosP.setLayout(administrarUsuariosPLayout);
        administrarUsuariosPLayout.setHorizontalGroup(
            administrarUsuariosPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(administrarUsuariosPLayout.createSequentialGroup()
                .addContainerGap()
                .add(administrarUsuariosPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(administrarUsuariosPLayout.createSequentialGroup()
                        .add(modificarUsuarioB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(eliminarUsuarioB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(38, 38, 38))
                    .add(administrarUsuariosPLayout.createSequentialGroup()
                        .add(crearUsuarioB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(consultarUsuarioB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        administrarUsuariosPLayout.setVerticalGroup(
            administrarUsuariosPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(administrarUsuariosPLayout.createSequentialGroup()
                .add(16, 16, 16)
                .add(administrarUsuariosPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(consultarUsuarioB)
                    .add(crearUsuarioB))
                .add(30, 30, 30)
                .add(administrarUsuariosPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(modificarUsuarioB)
                    .add(eliminarUsuarioB))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        administrarPrimerAdminP.setBorder(javax.swing.BorderFactory.createTitledBorder("Administrar Primer Administrador de Nivel"));

        consultarPrimerAdminB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        consultarPrimerAdminB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Consultar.png"))); // NOI18N
        consultarPrimerAdminB.setText("Consultar");
        consultarPrimerAdminB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        consultarPrimerAdminB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarPrimerAdminBActionPerformed(evt);
            }
        });

        modificarPrimerAdminB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        modificarPrimerAdminB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Modificar.png"))); // NOI18N
        modificarPrimerAdminB.setText("Modificar");
        modificarPrimerAdminB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        modificarPrimerAdminB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarPrimerAdminBActionPerformed(evt);
            }
        });

        eliminarPrimerAdminB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        eliminarPrimerAdminB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Eliminar.png"))); // NOI18N
        eliminarPrimerAdminB.setText("Eliminar");
        eliminarPrimerAdminB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        org.jdesktop.layout.GroupLayout administrarPrimerAdminPLayout = new org.jdesktop.layout.GroupLayout(administrarPrimerAdminP);
        administrarPrimerAdminP.setLayout(administrarPrimerAdminPLayout);
        administrarPrimerAdminPLayout.setHorizontalGroup(
            administrarPrimerAdminPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(administrarPrimerAdminPLayout.createSequentialGroup()
                .addContainerGap()
                .add(modificarPrimerAdminB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(eliminarPrimerAdminB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(38, 38, 38))
            .add(administrarPrimerAdminPLayout.createSequentialGroup()
                .add(84, 84, 84)
                .add(consultarPrimerAdminB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        administrarPrimerAdminPLayout.setVerticalGroup(
            administrarPrimerAdminPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(administrarPrimerAdminPLayout.createSequentialGroup()
                .add(15, 15, 15)
                .add(consultarPrimerAdminB)
                .add(32, 32, 32)
                .add(administrarPrimerAdminPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(modificarPrimerAdminB)
                    .add(eliminarPrimerAdminB))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        administrarNivelP.setBorder(javax.swing.BorderFactory.createTitledBorder("Administrar Nivel"));

        crearEmpresaB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        crearEmpresaB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Crear.png"))); // NOI18N
        crearEmpresaB.setText("Crear");
        crearEmpresaB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        crearEmpresaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearEmpresaBActionPerformed(evt);
            }
        });

        consultarEmpresaB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        consultarEmpresaB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Consultar.png"))); // NOI18N
        consultarEmpresaB.setText("Consultar");
        consultarEmpresaB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        consultarEmpresaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarEmpresaBActionPerformed(evt);
            }
        });

        modificarEmpresaB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        modificarEmpresaB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Modificar.png"))); // NOI18N
        modificarEmpresaB.setText("Modificar");
        modificarEmpresaB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        modificarEmpresaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarEmpresaBActionPerformed(evt);
            }
        });

        eliminarEmpresaB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        eliminarEmpresaB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Eliminar.png"))); // NOI18N
        eliminarEmpresaB.setText("Eliminar");
        eliminarEmpresaB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        org.jdesktop.layout.GroupLayout administrarNivelPLayout = new org.jdesktop.layout.GroupLayout(administrarNivelP);
        administrarNivelP.setLayout(administrarNivelPLayout);
        administrarNivelPLayout.setHorizontalGroup(
            administrarNivelPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(administrarNivelPLayout.createSequentialGroup()
                .addContainerGap()
                .add(administrarNivelPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(administrarNivelPLayout.createSequentialGroup()
                        .add(modificarEmpresaB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(eliminarEmpresaB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(38, 38, 38))
                    .add(administrarNivelPLayout.createSequentialGroup()
                        .add(crearEmpresaB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(consultarEmpresaB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 145, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        administrarNivelPLayout.setVerticalGroup(
            administrarNivelPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(administrarNivelPLayout.createSequentialGroup()
                .add(16, 16, 16)
                .add(administrarNivelPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(crearEmpresaB)
                    .add(consultarEmpresaB))
                .add(30, 30, 30)
                .add(administrarNivelPLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(modificarEmpresaB)
                    .add(eliminarEmpresaB))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap()
                .add(accionesL)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(administrarNivelP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 337, Short.MAX_VALUE)
                .add(18, 18, 18)
                .add(administrarPrimerAdminP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 320, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .add(layout.createSequentialGroup()
                .add(59, 59, 59)
                .add(jLabel2)
                .add(68, 68, 68)
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
                        .add(18, 18, 18)
                        .add(nombreUsuarioL)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 100, Short.MAX_VALUE)
                        .add(cerrarSesionB))))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(administrarUsuariosP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 341, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(28, 28, 28)
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
                            .add(rolL)))
                    .add(cerrarSesionB)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jLabel2)))
                .add(18, 18, 18)
                .add(accionesL)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(administrarPrimerAdminP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(administrarNivelP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(administrarUsuariosP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarSesionBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionBActionPerformed
        LoginController.cerrarSesion();
    }//GEN-LAST:event_cerrarSesionBActionPerformed

    private void crearUsuarioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearUsuarioBActionPerformed
        new CrearUsuarioController().mostrarCrearUsuario();        
    }//GEN-LAST:event_crearUsuarioBActionPerformed

    private void consultarUsuarioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarUsuarioBActionPerformed
        new ConsultarUsuarioController().consultarUsuario();
    }//GEN-LAST:event_consultarUsuarioBActionPerformed

    private void modificarUsuarioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarUsuarioBActionPerformed
        new ModificarUsuarioController().listarUsuarios();
    }//GEN-LAST:event_modificarUsuarioBActionPerformed

    private void eliminarUsuarioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarUsuarioBActionPerformed
        new EliminarUsuarioController().listarUsuarios();
    }//GEN-LAST:event_eliminarUsuarioBActionPerformed

    private void crearEmpresaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearEmpresaBActionPerformed
        new CrearEmpresaController().mostrarCrearEmpresa();
    }//GEN-LAST:event_crearEmpresaBActionPerformed

    private void consultarEmpresaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarEmpresaBActionPerformed
        new ConsultarEmpresaController().consultarEmpresa();
    }//GEN-LAST:event_consultarEmpresaBActionPerformed

    private void consultarPrimerAdminBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarPrimerAdminBActionPerformed
        new ConsultarAdministradorController().consultarUsuario();
    }//GEN-LAST:event_consultarPrimerAdminBActionPerformed

    private void modificarPrimerAdminBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarPrimerAdminBActionPerformed
        new ModificarAdministradorController().listarUsuarios();
    }//GEN-LAST:event_modificarPrimerAdminBActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accionesL;
    private javax.swing.JPanel administrarNivelP;
    private javax.swing.JPanel administrarPrimerAdminP;
    private javax.swing.JPanel administrarUsuariosP;
    private javax.swing.JLabel bienvenidoL;
    private javax.swing.JButton cerrarSesionB;
    private javax.swing.JButton consultarEmpresaB;
    private javax.swing.JButton consultarPrimerAdminB;
    private javax.swing.JButton consultarUsuarioB;
    private javax.swing.JButton crearEmpresaB;
    private javax.swing.JButton crearUsuarioB;
    private javax.swing.JButton eliminarEmpresaB;
    private javax.swing.JButton eliminarPrimerAdminB;
    private javax.swing.JButton eliminarUsuarioB;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton modificarEmpresaB;
    private javax.swing.JButton modificarPrimerAdminB;
    private javax.swing.JButton modificarUsuarioB;
    private javax.swing.JLabel nombreEmpresaL;
    private javax.swing.JLabel nombreUsuarioL;
    private javax.swing.JLabel registradoL;
    private javax.swing.JLabel rolL;
    private javax.swing.JLabel rolLabelL;
    // End of variables declaration//GEN-END:variables
}
