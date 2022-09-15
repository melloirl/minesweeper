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
    
    // Constructors
    public Temporizador(){
        this.contador = 0;
    }
    public Temporizador(int time){
        this.contador = time;
    }
    
    // Getters
    public int getContador() {
        return contador;
    }
    
    // Setters
    public void setContador(int contador) {
        this.contador = contador;
    }
    
    // Methods
    public void decrementar(){
        this.contador--;
    }
    
    public void incrementar(){
        this.contador++;
    }
    
}
