/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;

/**
 *
 * @author lucas
 */
public class Temporizador {
    private int contador;
    
    public Temporizador(){
        this.contador = 300;
    }
    
    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    
    public void rodar(){
        contador--;
    }
    
}
