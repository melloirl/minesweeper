/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;
import javax.swing.ImageIcon;
        
/**
 *
 * @author Wallace
 */
public class Bomba extends Celula implements TipoCelula {
    
    // Constructor 
    public Bomba(int posX, int posY){
        super(posX, posY);
    }
    
    // Methods
    @Override
    public String getTipo(){
        return "Bomba";
    }
    
    @Override
    public ImageIcon mostrarImagem(){
        return new ImageIcon(getClass().getResource("/imagens/bomb.png"));
    }
}
