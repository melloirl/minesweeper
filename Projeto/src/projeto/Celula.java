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
    private int posI, posJ;
    private boolean bandeira = false;
    private JToggleButton botao;
    
    public Celula(int posI, int posJ){
        this.posI = posI;
        this.posJ = posJ;
    }
    
    public abstract String getTipo(); 
    
    public boolean getBandeira(){
        return this.bandeira;
    }
    
    public void invertBandeira(){
        this.bandeira = !this.bandeira;
    }
    
    public int getPosI(){
        return this.posI;
    }
    
    public int getPosJ(){
        return this.posJ;
    }
    
    public void setBotao(JToggleButton botao) {
        this.botao = botao;
    }

    public JToggleButton getBotao() {
        return botao;
    }
    
    public ImageIcon mostrarBandeira(){
        return new ImageIcon(getClass().getResource("/Images/flag.png"));
    }
}
