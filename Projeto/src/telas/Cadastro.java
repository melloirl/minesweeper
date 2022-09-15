/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;
import projeto.Usuario;

/**
 *
 * @author Pedro
 */
public class Cadastro extends javax.swing.JFrame {
    private final Principal mae;
    
    public Cadastro(Principal telaprincipal) {
        initComponents();
        this.mae = telaprincipal;
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputNome = new javax.swing.JTextField();
        inputUsuario = new javax.swing.JTextField();
        inputSenha = new javax.swing.JPasswordField();
        labelNome = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        cadastrarButton = new javax.swing.JButton();

        inputNome.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        inputNome.setToolTipText("");
        inputNome.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        inputNome.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inputNome.setName("Nome"); // NOI18N

        inputUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        inputUsuario.setToolTipText("");
        inputUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        inputUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inputUsuario.setName("Nome"); // NOI18N

        inputSenha.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        inputSenha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        labelNome.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelNome.setText("Nome:");

        labelUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelUsuario.setText("Usuário:");

        labelSenha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        labelSenha.setText("Senha:");

        cadastrarButton.setText("Cadastrar");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(307, 307, 307))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(312, 312, 312))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUsuario)
                            .addComponent(inputUsuario)
                            .addComponent(inputSenha, javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(cadastrarButton, javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(inputNome))
                        .addGap(104, 104, 104))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(labelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputNome, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addComponent(labelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addComponent(labelSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(cadastrarButton)
                .addGap(37, 37, 37))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        String nomeExtraido = inputNome.getText();
        String usuarioExtraido = inputUsuario.getText();
        String senhaExtraida = new String(inputSenha.getPassword());
        
        Usuario novo = new Usuario(nomeExtraido,usuarioExtraido,senhaExtraida);
        inputNome.setText("");
        inputUsuario.setText("");
        inputSenha.setText("");
        String resultado = mae.getTela().cadastraUsuario(novo);
        javax.swing.JOptionPane.showMessageDialog(rootPane, resultado, "Cadastro", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        if(resultado.equals("Usuario cadastrado com sucesso.")){
            mae.setUsuariologado(mae.getTela().getUsuarios().get(usuarioExtraido));
            mae.atualizaLogado(mae.getTela().getUsuarios().get(usuarioExtraido).getNome());
            mae.salvarDados(nomeExtraido+" "+usuarioExtraido+" "+senhaExtraida);
            this.setVisible(false);
        }
    }//GEN-LAST:event_cadastrarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JTextField inputNome;
    private javax.swing.JPasswordField inputSenha;
    private javax.swing.JTextField inputUsuario;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelUsuario;
    // End of variables declaration//GEN-END:variables
}
