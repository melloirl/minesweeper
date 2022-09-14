/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import projeto.*;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author Wallace, Lucas
 */
public class telaMatriz extends javax.swing.JFrame {
    private final Principal mae;
    private int contador = 0;
    private Temporizador cronometro = new Temporizador();
    Matriz matriz = new Matriz();
    private int bombas = matriz.getBombs();
    
    /**
     * Creates new form telaMatriz
     */
    public telaMatriz(Principal telaprincipal) {
        initComponents();
        this.mae = telaprincipal;
        matriz.generateBombs();
        associateButtons();
        
        Timer tm = new Timer();
        tm.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                cronometro.rodar();
                jLabel2.setText(Integer.toString(cronometro.getContador()));
                jLabel1.setText(Integer.toString(bombas));
            }
            
        },1000,1000);
    }
    
    public final void associateButtons(){
        int n = matriz.getSIZE();
        javax.swing.JToggleButton[][] botoes = new javax.swing.JToggleButton[n][n];
        javax.swing.JToggleButton[] linear = new javax.swing.JToggleButton[n*n+1];
        
        linear[1] = jToggleButton1;
        linear[2] = jToggleButton2;
        linear[3] = jToggleButton3;
        linear[4] = jToggleButton4;
        linear[5] = jToggleButton5;
        linear[6] = jToggleButton6;
        linear[7] = jToggleButton7;
        linear[8] = jToggleButton8;
        linear[9] = jToggleButton9;
        
        linear[10] = jToggleButton10;
        linear[11] = jToggleButton11;
        linear[12] = jToggleButton12;
        linear[13] = jToggleButton13;
        linear[14] = jToggleButton14;
        linear[15] = jToggleButton15;
        linear[16] = jToggleButton16;
        linear[17] = jToggleButton17;
        linear[18] = jToggleButton18;
        linear[19] = jToggleButton19;
        
        linear[20] = jToggleButton20;
        linear[21] = jToggleButton21;
        linear[22] = jToggleButton22;
        linear[23] = jToggleButton23;
        linear[24] = jToggleButton24;
        linear[25] = jToggleButton25;
        linear[26] = jToggleButton26;
        linear[27] = jToggleButton27;
        linear[28] = jToggleButton28;
        linear[29] = jToggleButton29;
        
        linear[30] = jToggleButton30;
        linear[31] = jToggleButton31;
        linear[32] = jToggleButton32;
        linear[33] = jToggleButton33;
        linear[34] = jToggleButton34;
        linear[35] = jToggleButton35;
        linear[36] = jToggleButton36;
        linear[37] = jToggleButton37;
        linear[38] = jToggleButton38;
        linear[39] = jToggleButton39;
        
        linear[40] = jToggleButton40;
        linear[41] = jToggleButton41;
        linear[42] = jToggleButton42;
        linear[43] = jToggleButton43;
        linear[44] = jToggleButton44;
        linear[45] = jToggleButton45;
        linear[46] = jToggleButton46;
        linear[47] = jToggleButton47;
        linear[48] = jToggleButton48;
        linear[49] = jToggleButton49;
        
        linear[50] = jToggleButton50;
        linear[51] = jToggleButton51;
        linear[52] = jToggleButton52;
        linear[53] = jToggleButton53;
        linear[54] = jToggleButton54;
        linear[55] = jToggleButton55;
        linear[56] = jToggleButton56;
        linear[57] = jToggleButton57;
        linear[58] = jToggleButton58;
        linear[59] = jToggleButton59;
        
        linear[60] = jToggleButton60;
        linear[61] = jToggleButton61;
        linear[62] = jToggleButton62;
        linear[63] = jToggleButton63;
        linear[64] = jToggleButton64;
        
        int k = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                botoes[i][j] = linear[k];
                k += 1;
            }
        }
        
        matriz.generateMatrix(botoes);
    }
    
    public void revealNumber(int i, int j){
        Celula cell = matriz.getCelulas()[i][j];
        Numero numero = (Numero) cell;
        javax.swing.JToggleButton botao = cell.getBotao();
        
        botao.setIcon(numero.mostrarImagem());
        botao.setEnabled(false);
        
        contador++;
        if(contador == matriz.getSIZE()*matriz.getSIZE() - matriz.getBombs()){
            javax.swing.JOptionPane.showMessageDialog(rootPane, "Você ganhou :)", "Vitoria", javax.swing.JOptionPane.INFORMATION_MESSAGE);
        }
        
        if ( numero.getTipo().equals("Numero0") ){
            propagate(i, j);
        }
    }
    
    public void propagate(int i, int j){
        int SIZE = matriz.getSIZE();
        Celula[][] celulas = matriz.getCelulas();
        
        if (i>0                  && celulas[i-1][j  ].getBotao().isEnabled() ) revealNumber(i-1, j  );
        if (i>0      && j>0      && celulas[i-1][j-1].getBotao().isEnabled() ) revealNumber(i-1, j-1);
        if (i>0      && j<SIZE-1 && celulas[i-1][j+1].getBotao().isEnabled() ) revealNumber(i-1, j+1);

        if (i<SIZE-1             && celulas[i+1][j  ].getBotao().isEnabled() ) revealNumber(i+1, j  );
        if (i<SIZE-1 && j>0      && celulas[i+1][j-1].getBotao().isEnabled() ) revealNumber(i+1, j-1);
        if (i<SIZE-1 && j<SIZE-1 && celulas[i+1][j+1].getBotao().isEnabled() ) revealNumber(i+1, j+1);

        if (j>0                  && celulas[i  ][j-1].getBotao().isEnabled() ) revealNumber(i  , j-1);
        if (j<SIZE-1             && celulas[i  ][j+1].getBotao().isEnabled() ) revealNumber(i  , j+1);
    }
    
    private void ganhou(String user){
        try{
            File saveData = new File("ranking.txt");
            Scanner reader = new Scanner(saveData);
            System.out.println("Save carregado.");
            
        } catch (FileNotFoundException e) {
            try{
                File newSave = new File("ranking.txt");
                if(newSave.createNewFile()){
                    
                    System.out.println("Save criado.");
                }
            } catch (IOException er){
                System.out.println("Um erro ocorreu.");
            }
        }
            
        try{
            try (FileWriter writer = new FileWriter("ranking.txt",true); BufferedWriter buffwriter = new BufferedWriter(writer)) {
                buffwriter.write(user);
                buffwriter.newLine();
            }
        } catch (IOException e){
            System.out.println("Ocorreu um erro.");
        }
    
    }
    
    public void clicks(javax.swing.JToggleButton botao, java.awt.event.MouseEvent evt, int i, int j){
        Celula cell = matriz.getCelulas()[i][j];
        String tipo = cell.getTipo();
        
        if (evt.getButton() == 1){
            if (tipo.equals("Bomba")){
                Bomba bomba = (Bomba) cell;
                botao.setIcon(bomba.mostrarImagem());
                javax.swing.JOptionPane.showMessageDialog(rootPane, "Você perdeu :(", "Derrota", javax.swing.JOptionPane.ERROR_MESSAGE);
                this.setVisible(false);
                mae.regeneraTela();
                botao.setEnabled(false);
            }
            else{
                revealNumber(i, j);
                if(contador == (matriz.getSIZE()*matriz.getSIZE()) - matriz.getBombs()+1){
                    javax.swing.JOptionPane.showMessageDialog(rootPane, "Você ganhou :)", "Vitoria", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                    new Ranking(new Principal()).setVisible(true);
                    this.ganhou(mae.getUsuariologado().getLogin()+" "+Integer.toString(cronometro.getContador()));
                }
            }
        }
        else if(evt.getButton() == 3 && botao.isEnabled()){
            if (cell.getBandeira()){
                botao.setIcon(null);
                bombas++;
            }
            else{
                botao.setIcon(cell.mostrarBandeira());
                bombas--;
            }
            cell.invertBandeira();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton8 = new javax.swing.JToggleButton();
        jToggleButton9 = new javax.swing.JToggleButton();
        jToggleButton10 = new javax.swing.JToggleButton();
        jToggleButton11 = new javax.swing.JToggleButton();
        jToggleButton12 = new javax.swing.JToggleButton();
        jToggleButton13 = new javax.swing.JToggleButton();
        jToggleButton14 = new javax.swing.JToggleButton();
        jToggleButton15 = new javax.swing.JToggleButton();
        jToggleButton16 = new javax.swing.JToggleButton();
        jToggleButton17 = new javax.swing.JToggleButton();
        jToggleButton18 = new javax.swing.JToggleButton();
        jToggleButton19 = new javax.swing.JToggleButton();
        jToggleButton20 = new javax.swing.JToggleButton();
        jToggleButton21 = new javax.swing.JToggleButton();
        jToggleButton22 = new javax.swing.JToggleButton();
        jToggleButton23 = new javax.swing.JToggleButton();
        jToggleButton24 = new javax.swing.JToggleButton();
        jToggleButton25 = new javax.swing.JToggleButton();
        jToggleButton26 = new javax.swing.JToggleButton();
        jToggleButton27 = new javax.swing.JToggleButton();
        jToggleButton28 = new javax.swing.JToggleButton();
        jToggleButton29 = new javax.swing.JToggleButton();
        jToggleButton30 = new javax.swing.JToggleButton();
        jToggleButton31 = new javax.swing.JToggleButton();
        jToggleButton32 = new javax.swing.JToggleButton();
        jToggleButton33 = new javax.swing.JToggleButton();
        jToggleButton34 = new javax.swing.JToggleButton();
        jToggleButton35 = new javax.swing.JToggleButton();
        jToggleButton36 = new javax.swing.JToggleButton();
        jToggleButton37 = new javax.swing.JToggleButton();
        jToggleButton38 = new javax.swing.JToggleButton();
        jToggleButton39 = new javax.swing.JToggleButton();
        jToggleButton40 = new javax.swing.JToggleButton();
        jToggleButton41 = new javax.swing.JToggleButton();
        jToggleButton42 = new javax.swing.JToggleButton();
        jToggleButton43 = new javax.swing.JToggleButton();
        jToggleButton44 = new javax.swing.JToggleButton();
        jToggleButton45 = new javax.swing.JToggleButton();
        jToggleButton46 = new javax.swing.JToggleButton();
        jToggleButton47 = new javax.swing.JToggleButton();
        jToggleButton48 = new javax.swing.JToggleButton();
        jToggleButton49 = new javax.swing.JToggleButton();
        jToggleButton50 = new javax.swing.JToggleButton();
        jToggleButton51 = new javax.swing.JToggleButton();
        jToggleButton52 = new javax.swing.JToggleButton();
        jToggleButton53 = new javax.swing.JToggleButton();
        jToggleButton54 = new javax.swing.JToggleButton();
        jToggleButton55 = new javax.swing.JToggleButton();
        jToggleButton56 = new javax.swing.JToggleButton();
        jToggleButton57 = new javax.swing.JToggleButton();
        jToggleButton58 = new javax.swing.JToggleButton();
        jToggleButton59 = new javax.swing.JToggleButton();
        jToggleButton60 = new javax.swing.JToggleButton();
        jToggleButton61 = new javax.swing.JToggleButton();
        jToggleButton62 = new javax.swing.JToggleButton();
        jToggleButton63 = new javax.swing.JToggleButton();
        jToggleButton64 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(620, 710));

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.setMaximumSize(new java.awt.Dimension(640, 640));
        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(560, 560));
        jPanel1.setLayout(new java.awt.GridLayout(8, 8, 1, 1));

        jToggleButton1.setToolTipText(null);
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton1MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton1);

        jToggleButton2.setToolTipText(null);
        jToggleButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton2MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton2);

        jToggleButton3.setToolTipText(null);
        jToggleButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton3MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton3);

        jToggleButton4.setToolTipText(null);
        jToggleButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton4MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton4);

        jToggleButton5.setToolTipText(null);
        jToggleButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton5MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton5);

        jToggleButton6.setToolTipText(null);
        jToggleButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton6MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton6);

        jToggleButton7.setToolTipText(null);
        jToggleButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton7MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton7);

        jToggleButton8.setToolTipText(null);
        jToggleButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton8MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton8);

        jToggleButton9.setToolTipText(null);
        jToggleButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton9MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton9);

        jToggleButton10.setToolTipText(null);
        jToggleButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton10MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton10);

        jToggleButton11.setToolTipText(null);
        jToggleButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton11MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton11);

        jToggleButton12.setToolTipText(null);
        jToggleButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton12MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton12);

        jToggleButton13.setToolTipText(null);
        jToggleButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton13MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton13);

        jToggleButton14.setToolTipText(null);
        jToggleButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton14MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton14);

        jToggleButton15.setToolTipText(null);
        jToggleButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton15MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton15);

        jToggleButton16.setToolTipText(null);
        jToggleButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton16MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton16);

        jToggleButton17.setToolTipText(null);
        jToggleButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton17MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton17);

        jToggleButton18.setToolTipText(null);
        jToggleButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton18MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton18);

        jToggleButton19.setToolTipText(null);
        jToggleButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton19MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton19);

        jToggleButton20.setToolTipText(null);
        jToggleButton20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton20MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton20);

        jToggleButton21.setToolTipText(null);
        jToggleButton21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton21MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton21);

        jToggleButton22.setToolTipText(null);
        jToggleButton22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton22MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton22);

        jToggleButton23.setToolTipText(null);
        jToggleButton23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton23MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton23);

        jToggleButton24.setToolTipText(null);
        jToggleButton24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton24MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton24);

        jToggleButton25.setToolTipText(null);
        jToggleButton25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton25MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton25);

        jToggleButton26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton26MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton26);

        jToggleButton27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton27MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton27);

        jToggleButton28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton28MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton28);

        jToggleButton29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton29MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton29);

        jToggleButton30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton30MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton30);

        jToggleButton31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton31MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton31);

        jToggleButton32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton32MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton32);

        jToggleButton33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton33MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton33);

        jToggleButton34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton34MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton34);

        jToggleButton35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton35MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton35);

        jToggleButton36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton36MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton36);

        jToggleButton37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton37MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton37);

        jToggleButton38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton38MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton38);

        jToggleButton39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton39MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton39);

        jToggleButton40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton40MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton40);

        jToggleButton41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton41MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton41);

        jToggleButton42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton42MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton42);

        jToggleButton43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton43MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton43);

        jToggleButton44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton44MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton44);

        jToggleButton45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton45MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton45);

        jToggleButton46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton46MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton46);

        jToggleButton47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton47MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton47);

        jToggleButton48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton48MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton48);

        jToggleButton49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton49MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton49);

        jToggleButton50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton50MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton50);

        jToggleButton51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton51MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton51);

        jToggleButton52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton52MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton52);

        jToggleButton53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton53MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton53);

        jToggleButton54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton54MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton54);

        jToggleButton55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton55MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton55);

        jToggleButton56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton56MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton56);

        jToggleButton57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton57MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton57);

        jToggleButton58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton58MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton58);

        jToggleButton59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton59MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton59);

        jToggleButton60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton60MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton60);

        jToggleButton61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton61MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton61);

        jToggleButton62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton62MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton62);

        jToggleButton63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton63MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton63);

        jToggleButton64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jToggleButton64MousePressed(evt);
            }
        });
        jPanel1.add(jToggleButton64);

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jMenu1.setText("Menu");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ranking");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(461, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(95, 95, 95)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(601, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MousePressed
        clicks(jToggleButton1, evt, 0, 0);
    }//GEN-LAST:event_jToggleButton1MousePressed

    private void jToggleButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton2MousePressed
        clicks(jToggleButton2, evt, 0, 1);
    }//GEN-LAST:event_jToggleButton2MousePressed

    private void jToggleButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton3MousePressed
        clicks(jToggleButton3, evt, 0, 2);
    }//GEN-LAST:event_jToggleButton3MousePressed

    private void jToggleButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton4MousePressed
        clicks(jToggleButton4, evt, 0, 3);
    }//GEN-LAST:event_jToggleButton4MousePressed

    private void jToggleButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton5MousePressed
        clicks(jToggleButton5, evt, 0, 4);
    }//GEN-LAST:event_jToggleButton5MousePressed

    private void jToggleButton6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton6MousePressed
        clicks(jToggleButton6, evt, 0, 5);
    }//GEN-LAST:event_jToggleButton6MousePressed

    private void jToggleButton7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton7MousePressed
        clicks(jToggleButton7, evt, 0, 6);
    }//GEN-LAST:event_jToggleButton7MousePressed

    private void jToggleButton8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton8MousePressed
        clicks(jToggleButton8, evt, 0, 7);
    }//GEN-LAST:event_jToggleButton8MousePressed

    private void jToggleButton9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton9MousePressed
        clicks(jToggleButton9, evt, 1, 0);
    }//GEN-LAST:event_jToggleButton9MousePressed

    private void jToggleButton10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton10MousePressed
        clicks(jToggleButton10, evt, 1, 1);
    }//GEN-LAST:event_jToggleButton10MousePressed

    private void jToggleButton11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton11MousePressed
        clicks(jToggleButton11, evt, 1, 2);
    }//GEN-LAST:event_jToggleButton11MousePressed

    private void jToggleButton12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton12MousePressed
        clicks(jToggleButton12, evt, 1, 3);
    }//GEN-LAST:event_jToggleButton12MousePressed

    private void jToggleButton13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton13MousePressed
        clicks(jToggleButton13, evt, 1, 4);
    }//GEN-LAST:event_jToggleButton13MousePressed

    private void jToggleButton14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton14MousePressed
        clicks(jToggleButton14, evt, 1, 5);
    }//GEN-LAST:event_jToggleButton14MousePressed

    private void jToggleButton15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton15MousePressed
        clicks(jToggleButton15, evt, 1, 6);
    }//GEN-LAST:event_jToggleButton15MousePressed

    private void jToggleButton17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton17MousePressed
        clicks(jToggleButton17, evt, 2, 0);
    }//GEN-LAST:event_jToggleButton17MousePressed

    private void jToggleButton18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton18MousePressed
        clicks(jToggleButton18, evt, 2, 1);
    }//GEN-LAST:event_jToggleButton18MousePressed

    private void jToggleButton19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton19MousePressed
        clicks(jToggleButton19, evt, 2, 2);
    }//GEN-LAST:event_jToggleButton19MousePressed

    private void jToggleButton20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton20MousePressed
        clicks(jToggleButton20, evt, 2, 3);
    }//GEN-LAST:event_jToggleButton20MousePressed

    private void jToggleButton21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton21MousePressed
        clicks(jToggleButton21, evt, 2, 4);
    }//GEN-LAST:event_jToggleButton21MousePressed

    private void jToggleButton22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton22MousePressed
        clicks(jToggleButton22, evt, 2, 5);
    }//GEN-LAST:event_jToggleButton22MousePressed

    private void jToggleButton23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton23MousePressed
        clicks(jToggleButton23, evt, 2, 6);
    }//GEN-LAST:event_jToggleButton23MousePressed

    private void jToggleButton24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton24MousePressed
        clicks(jToggleButton24, evt, 2, 7);
    }//GEN-LAST:event_jToggleButton24MousePressed

    private void jToggleButton25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton25MousePressed
        clicks(jToggleButton25, evt, 3, 0);
    }//GEN-LAST:event_jToggleButton25MousePressed
        
    private void jToggleButton26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton26MousePressed
        clicks(jToggleButton26, evt, 3, 1);
    }//GEN-LAST:event_jToggleButton26MousePressed
        
    private void jToggleButton27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton27MousePressed
        clicks(jToggleButton27, evt, 3, 2);
    }//GEN-LAST:event_jToggleButton27MousePressed
        
    private void jToggleButton28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton28MousePressed
        clicks(jToggleButton28, evt, 3, 3);
    }//GEN-LAST:event_jToggleButton28MousePressed
        
    private void jToggleButton29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton29MousePressed
        clicks(jToggleButton29, evt, 3, 4);
    }//GEN-LAST:event_jToggleButton29MousePressed

    private void jToggleButton30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton30MousePressed
        clicks(jToggleButton30, evt, 3, 5);
    }//GEN-LAST:event_jToggleButton30MousePressed

    private void jToggleButton31MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton31MousePressed
        clicks(jToggleButton31, evt, 3, 6);
    }//GEN-LAST:event_jToggleButton31MousePressed

    private void jToggleButton32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton32MousePressed
        clicks(jToggleButton32, evt, 3, 7);
    }//GEN-LAST:event_jToggleButton32MousePressed

    private void jToggleButton33MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton33MousePressed
        clicks(jToggleButton33, evt, 4, 0);
    }//GEN-LAST:event_jToggleButton33MousePressed

    private void jToggleButton34MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton34MousePressed
        clicks(jToggleButton34, evt, 4, 1);
    }//GEN-LAST:event_jToggleButton34MousePressed

    private void jToggleButton35MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton35MousePressed
        clicks(jToggleButton35, evt, 4, 2);
    }//GEN-LAST:event_jToggleButton35MousePressed

    private void jToggleButton36MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton36MousePressed
        clicks(jToggleButton36, evt, 4, 3);
    }//GEN-LAST:event_jToggleButton36MousePressed

    private void jToggleButton37MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton37MousePressed
        clicks(jToggleButton37, evt, 4, 4);
    }//GEN-LAST:event_jToggleButton37MousePressed

    private void jToggleButton38MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton38MousePressed
        clicks(jToggleButton38, evt, 4, 5);
    }//GEN-LAST:event_jToggleButton38MousePressed

    private void jToggleButton39MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton39MousePressed
        clicks(jToggleButton39, evt, 4, 6);
    }//GEN-LAST:event_jToggleButton39MousePressed

    private void jToggleButton40MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton40MousePressed
        clicks(jToggleButton40, evt, 4, 7);
    }//GEN-LAST:event_jToggleButton40MousePressed

    private void jToggleButton41MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton41MousePressed
        clicks(jToggleButton41, evt, 5, 0);
    }//GEN-LAST:event_jToggleButton41MousePressed

    private void jToggleButton42MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton42MousePressed
        clicks(jToggleButton42, evt, 5, 1);
    }//GEN-LAST:event_jToggleButton42MousePressed

    private void jToggleButton43MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton43MousePressed
        clicks(jToggleButton43, evt, 5, 2);
    }//GEN-LAST:event_jToggleButton43MousePressed

    private void jToggleButton44MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton44MousePressed
        clicks(jToggleButton44, evt, 5, 3);
    }//GEN-LAST:event_jToggleButton44MousePressed

    private void jToggleButton45MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton45MousePressed
        clicks(jToggleButton45, evt, 5, 4);
    }//GEN-LAST:event_jToggleButton45MousePressed

    private void jToggleButton46MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton46MousePressed
        clicks(jToggleButton46, evt, 5, 5);
    }//GEN-LAST:event_jToggleButton46MousePressed

    private void jToggleButton47MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton47MousePressed
        clicks(jToggleButton47, evt, 5, 6);
    }//GEN-LAST:event_jToggleButton47MousePressed

    private void jToggleButton48MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton48MousePressed
        clicks(jToggleButton48, evt, 5, 7);
    }//GEN-LAST:event_jToggleButton48MousePressed

    private void jToggleButton49MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton49MousePressed
        clicks(jToggleButton49, evt, 6, 0);
    }//GEN-LAST:event_jToggleButton49MousePressed

    private void jToggleButton50MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton50MousePressed
        clicks(jToggleButton50, evt, 6, 1);
    }//GEN-LAST:event_jToggleButton50MousePressed

    private void jToggleButton51MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton51MousePressed
        clicks(jToggleButton51, evt, 6, 2);
    }//GEN-LAST:event_jToggleButton51MousePressed

    private void jToggleButton52MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton52MousePressed
        clicks(jToggleButton52, evt, 6, 3);
    }//GEN-LAST:event_jToggleButton52MousePressed

    private void jToggleButton53MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton53MousePressed
        clicks(jToggleButton53, evt, 6, 4);
    }//GEN-LAST:event_jToggleButton53MousePressed

    private void jToggleButton54MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton54MousePressed
        clicks(jToggleButton54, evt, 6, 5);
    }//GEN-LAST:event_jToggleButton54MousePressed

    private void jToggleButton55MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton55MousePressed
        clicks(jToggleButton55, evt, 6, 6);
    }//GEN-LAST:event_jToggleButton55MousePressed

    private void jToggleButton56MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton56MousePressed
        clicks(jToggleButton56, evt, 6, 7);
    }//GEN-LAST:event_jToggleButton56MousePressed

    private void jToggleButton57MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton57MousePressed
        clicks(jToggleButton57, evt, 7, 0);
    }//GEN-LAST:event_jToggleButton57MousePressed

    private void jToggleButton58MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton58MousePressed
        clicks(jToggleButton58, evt, 7, 1);
    }//GEN-LAST:event_jToggleButton58MousePressed

    private void jToggleButton59MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton59MousePressed
        clicks(jToggleButton59, evt, 7, 2);
    }//GEN-LAST:event_jToggleButton59MousePressed

    private void jToggleButton60MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton60MousePressed
        clicks(jToggleButton60, evt, 7, 3);
    }//GEN-LAST:event_jToggleButton60MousePressed

    private void jToggleButton61MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton61MousePressed
        clicks(jToggleButton61, evt, 7, 4);
    }//GEN-LAST:event_jToggleButton61MousePressed

    private void jToggleButton62MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton62MousePressed
        clicks(jToggleButton62, evt, 7, 5);
    }//GEN-LAST:event_jToggleButton62MousePressed

    private void jToggleButton63MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton63MousePressed
        clicks(jToggleButton63, evt, 7, 6);
    }//GEN-LAST:event_jToggleButton63MousePressed

    private void jToggleButton64MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton64MousePressed
        clicks(jToggleButton64, evt, 7, 7);
    }//GEN-LAST:event_jToggleButton64MousePressed

    private void jToggleButton16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton16MousePressed
        clicks(jToggleButton16, evt, 1, 7);
    }//GEN-LAST:event_jToggleButton16MousePressed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        this.setVisible(false);
        new Principal().setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        this.setVisible(false);
        new Ranking(new Principal()).setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

    }//GEN-LAST:event_jLabel1MouseClicked
                                             

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton10;
    private javax.swing.JToggleButton jToggleButton11;
    private javax.swing.JToggleButton jToggleButton12;
    private javax.swing.JToggleButton jToggleButton13;
    private javax.swing.JToggleButton jToggleButton14;
    private javax.swing.JToggleButton jToggleButton15;
    private javax.swing.JToggleButton jToggleButton16;
    private javax.swing.JToggleButton jToggleButton17;
    private javax.swing.JToggleButton jToggleButton18;
    private javax.swing.JToggleButton jToggleButton19;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton20;
    private javax.swing.JToggleButton jToggleButton21;
    private javax.swing.JToggleButton jToggleButton22;
    private javax.swing.JToggleButton jToggleButton23;
    private javax.swing.JToggleButton jToggleButton24;
    private javax.swing.JToggleButton jToggleButton25;
    private javax.swing.JToggleButton jToggleButton26;
    private javax.swing.JToggleButton jToggleButton27;
    private javax.swing.JToggleButton jToggleButton28;
    private javax.swing.JToggleButton jToggleButton29;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton30;
    private javax.swing.JToggleButton jToggleButton31;
    private javax.swing.JToggleButton jToggleButton32;
    private javax.swing.JToggleButton jToggleButton33;
    private javax.swing.JToggleButton jToggleButton34;
    private javax.swing.JToggleButton jToggleButton35;
    private javax.swing.JToggleButton jToggleButton36;
    private javax.swing.JToggleButton jToggleButton37;
    private javax.swing.JToggleButton jToggleButton38;
    private javax.swing.JToggleButton jToggleButton39;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton40;
    private javax.swing.JToggleButton jToggleButton41;
    private javax.swing.JToggleButton jToggleButton42;
    private javax.swing.JToggleButton jToggleButton43;
    private javax.swing.JToggleButton jToggleButton44;
    private javax.swing.JToggleButton jToggleButton45;
    private javax.swing.JToggleButton jToggleButton46;
    private javax.swing.JToggleButton jToggleButton47;
    private javax.swing.JToggleButton jToggleButton48;
    private javax.swing.JToggleButton jToggleButton49;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton50;
    private javax.swing.JToggleButton jToggleButton51;
    private javax.swing.JToggleButton jToggleButton52;
    private javax.swing.JToggleButton jToggleButton53;
    private javax.swing.JToggleButton jToggleButton54;
    private javax.swing.JToggleButton jToggleButton55;
    private javax.swing.JToggleButton jToggleButton56;
    private javax.swing.JToggleButton jToggleButton57;
    private javax.swing.JToggleButton jToggleButton58;
    private javax.swing.JToggleButton jToggleButton59;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton60;
    private javax.swing.JToggleButton jToggleButton61;
    private javax.swing.JToggleButton jToggleButton62;
    private javax.swing.JToggleButton jToggleButton63;
    private javax.swing.JToggleButton jToggleButton64;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JToggleButton jToggleButton9;
    // End of variables declaration//GEN-END:variables
}
