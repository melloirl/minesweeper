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
public class Numero extends Celula implements TipoCelula {
    private int algarismo;
    
    // Constructor
    public Numero(int posI, int posJ, int algarismo){
        super(posI, posJ);
        this.algarismo = algarismo;
    }
    
    // Getters
    public int getAlgarismo() {
        return algarismo;
    }
    
    // Setters
    public void setAlgarismo(int algarismo) {
        this.algarismo = algarismo;
    }
    
    // Methods
    @Override
    public String getTipo(){
        return "Numero" + String.valueOf(algarismo);
    }
    
    @Override
    public ImageIcon mostrarImagem(){
        String tipo = this.getTipo();
        return switch (tipo) {
            case "Numero0" -> new ImageIcon(getClass().getResource("/Images/0.png"));
            case "Numero1" -> new ImageIcon(getClass().getResource("/Images/1.png"));
            case "Numero2" -> new ImageIcon(getClass().getResource("/Images/2.png"));
            case "Numero3" -> new ImageIcon(getClass().getResource("/Images/3.png"));
            case "Numero4" -> new ImageIcon(getClass().getResource("/Images/4.png"));
            case "Numero5" -> new ImageIcon(getClass().getResource("/Images/5.png"));
            case "Numero6" -> new ImageIcon(getClass().getResource("/Images/6.png"));
            case "Numero7" -> new ImageIcon(getClass().getResource("/Images/7.png"));
            case "Numero8" -> new ImageIcon(getClass().getResource("/Images/8.png"));
            default -> new ImageIcon();
        };
    }
}
