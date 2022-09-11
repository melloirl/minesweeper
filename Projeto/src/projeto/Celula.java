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
    int posX, posY;
    boolean bandeira = false;
    
    public Celula(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }
    
    public abstract String getTipo(); 
    
    public boolean getBandeira(){
        return this.bandeira;
    }
    
    public void invertBandeira(){
        this.bandeira = !this.bandeira;
    }
    
    public int getPosX(){
        return this.posX;
    }
    
    public int getPosY(){
        return this.posY;
    }
    
    public void mostrarNaoJogado(){
        // todo -> mostrar imagem de um quadrado a ser selecionado
    };
    
    public void mostrarBandeira(){
        // todo -> mostrar imagem de uma bandeira
    }
    
    public void botaoDireito(){
        if (bandeira){
            mostrarNaoJogado();
            bandeira = false;
        }
        else{
            mostrarBandeira();
            bandeira = true;
        }
    }
}
