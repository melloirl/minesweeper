/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;
import java.util.Arrays;
import projeto.*;

/**
 *
 * @author Pedro
 */
public class Login extends javax.swing.JFrame {
    private final Principal mae;
    /**
     * Creates new form Login
     */
    public Login(Principal telaprincipal) {
        initComponents();
        this.mae = telaprincipal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        inputUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputUsuarioActionPerformed(evt);
            }
        });

        inputSenha.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        inputSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        inputSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSenhaActionPerformed(evt);
            }
        });

        labelUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelUsuario.setText("Usuário:");

        labelSenha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelSenha.setText("Senha:");

        jButton1.setText("Entrar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
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

    private void inputSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputSenhaActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String usuarioExtraido = inputUsuario.getText();
        String senhaExtraida = new String(inputSenha.getPassword());
        System.out.println(senhaExtraida);
        if(mae.tela.getUsuarios().get(usuarioExtraido) != null){
            System.out.println(mae.tela.getUsuarios().get(usuarioExtraido).getSenha());
            if(mae.tela.getUsuarios().get(usuarioExtraido).getSenha().equals(senhaExtraida)){
                mae.setUsuariologado(mae.tela.getUsuarios().get(usuarioExtraido));
                mae.atualizaLogado(mae.tela.getUsuarios().get(usuarioExtraido).getNome());
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

    private void inputUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField inputSenha;
    private javax.swing.JTextField inputUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelUsuario;
    // End of variables declaration//GEN-END:variables
}