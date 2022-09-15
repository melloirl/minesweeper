/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;
/**
 *
 * @author Pedro
 */

public class Login extends javax.swing.JFrame {
    private final Principal mae;

    public Login(Principal telaPrincipal) {
        initComponents();
        this.mae = telaPrincipal;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputUsuario = new javax.swing.JTextField();
        inputSenha = new javax.swing.JPasswordField();
        labelUsuario = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        inputUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        inputUsuario.setToolTipText("");
        inputUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        inputUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inputUsuario.setName("Nome"); // NOI18N

        inputSenha.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        inputSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        labelUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelUsuario.setText("Usuário:");

        labelSenha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelSenha.setText("Senha:");

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(99, 99, 99)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGap(203, 203, 203))
                        .addComponent(labelUsuario)
                        .addComponent(inputUsuario)
                        .addComponent(inputSenha, javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.CENTER))
                    .addGap(99, 99, 99)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(labelUsuario)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(inputUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addGap(22, 22, 22)
                    .addComponent(labelSenha)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(inputSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(40, 40, 40)
                    .addComponent(jButton1)
                    .addGap(81, 81, 81)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String usuarioExtraido = inputUsuario.getText();
        String senhaExtraida = new String(inputSenha.getPassword());
        System.out.println(senhaExtraida);
        if(mae.getTela().getUsuarios().get(usuarioExtraido) != null){
            System.out.println(mae.getTela().getUsuarios().get(usuarioExtraido).getSenha());
            if(mae.getTela().getUsuarios().get(usuarioExtraido).getSenha().equals(senhaExtraida)){
                mae.setUsuarioLogado(mae.getTela().getUsuarios().get(usuarioExtraido));
                mae.atualizaLogado(mae.getTela().getUsuarios().get(usuarioExtraido).getNome());
                this.setVisible(false);
            }
            else{
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Senha inválida.", "Login", javax.swing.JOptionPane.ERROR_MESSAGE);
                inputUsuario.setText("");
                inputSenha.setText("");
            }
        }
        else{
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Usuário inválido.", "Login", javax.swing.JOptionPane.ERROR_MESSAGE);
             inputUsuario.setText("");
             inputSenha.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField inputSenha;
    private javax.swing.JTextField inputUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelUsuario;
    // End of variables declaration//GEN-END:variables
}
