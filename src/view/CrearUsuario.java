/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author Felipe
 */
public class CrearUsuario extends javax.swing.JPanel {

    /**
     * Creates new form AdministradorPrincipal
     */
    public CrearUsuario() {
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

        panelSupP = new javax.swing.JPanel();
        crearUsuarioL = new javax.swing.JLabel();
        cerrarB = new javax.swing.JButton();
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
        rolCB = new javax.swing.JComboBox();
        cancelarB = new javax.swing.JButton();
        crearUuarioB = new javax.swing.JButton();

        panelSupP.setBackground(new java.awt.Color(181, 181, 181));
        panelSupP.setLayout(null);

        crearUsuarioL.setText("SIAC - Crear usuario");
        panelSupP.add(crearUsuarioL);
        crearUsuarioL.setBounds(6, 7, 130, 16);

        cerrarB.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        cerrarB.setText("X");
        cerrarB.setBorderPainted(false);
        cerrarB.setContentAreaFilled(false);
        cerrarB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cerrarB.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cerrarB.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        panelSupP.add(cerrarB);
        cerrarB.setBounds(400, 0, 55, 30);

        panelInfP.setBackground(new java.awt.Color(181, 181, 181));
        panelInfP.setLayout(null);

        dniL.setText("DNI:");

        nombreL.setText("Nombre:");

        nombreDeUsuarioL.setText("Nombre de usuario:");

        contrasenaL.setText("Contraseña:");

        confirmarContrasenaL.setText("Confirmar contraseña:");

        correoL.setText("Correo:");

        rolL.setText("Rol:");

        contrasenaPF.setText("jPasswordField1");

        confirmarContrasenaPF.setText("jPasswordField2");

        rolCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Administrador", "Consulta", "Otro rol" }));

        cancelarB.setText("Cancelar");

        crearUuarioB.setText("Crear usuario");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(panelInfP, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(panelSupP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 442, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
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
                                    .add(rolL))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(nombreTF)
                                    .add(dniTF, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                    .add(nombreDeUsuarioTF)
                                    .add(contrasenaPF)
                                    .add(confirmarContrasenaPF)
                                    .add(correoTF)
                                    .add(rolCB, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .add(layout.createSequentialGroup()
                        .add(94, 94, 94)
                        .add(cancelarB)
                        .add(65, 65, 65)
                        .add(crearUuarioB)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(panelSupP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
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
                    .add(rolCB, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(cancelarB)
                    .add(crearUuarioB))
                .add(18, 18, Short.MAX_VALUE)
                .add(panelInfP, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarB;
    private javax.swing.JButton cerrarB;
    private javax.swing.JLabel confirmarContrasenaL;
    private javax.swing.JPasswordField confirmarContrasenaPF;
    private javax.swing.JLabel contrasenaL;
    private javax.swing.JPasswordField contrasenaPF;
    private javax.swing.JLabel correoL;
    private javax.swing.JTextField correoTF;
    private javax.swing.JLabel crearUsuarioL;
    private javax.swing.JButton crearUuarioB;
    private javax.swing.JLabel dniL;
    private javax.swing.JTextField dniTF;
    private javax.swing.JLabel nombreDeUsuarioL;
    private javax.swing.JTextField nombreDeUsuarioTF;
    private javax.swing.JLabel nombreL;
    private javax.swing.JTextField nombreTF;
    private javax.swing.JPanel panelInfP;
    private javax.swing.JPanel panelSupP;
    private javax.swing.JComboBox rolCB;
    private javax.swing.JLabel rolL;
    // End of variables declaration//GEN-END:variables
}
