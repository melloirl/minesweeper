/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

/**
 *
 * @author Wallace
 */
public abstract class Celula {
    private final int posI, posJ;
    private boolean bandeira = false;
    private JToggleButton botao;
    
    // Constructor
    public Celula(int posI, int posJ){
        this.posI = posI;
        this.posJ = posJ;
    }
    
    // Getters
    public boolean getBandeira(){
        return this.bandeira;
    }

    public int getPosI(){
        return this.posI;
    }
    
    public int getPosJ(){
        return this.posJ;
    }
    
    public JToggleButton getBotao() {
        return botao;
    }
    
    // Setters
    public void setBandeira(boolean bandeira) {
        this.bandeira = bandeira;
    }
    
    public void setBotao(JToggleButton botao) {
        this.botao = botao;
    }
    
    // Methods
    public ImageIcon mostrarBandeira(){
        return new ImageIcon(getClass().getResource("/imagens/flag.png"));
    }
    
    public void inverterBandeira(){
        this.bandeira = !this.bandeira;
    }
    
    public abstract String getTipo();
}
