/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;

/**
 *
 * @author Wallace
 */
public abstract class Celula {
    int posI, posJ;
    boolean bandeira = false;
    
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
}
