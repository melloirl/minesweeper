/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;

/**
 *
 * @author Wallace
 */
public class Bomba extends Celula implements TipoCelula {

    public Bomba(int posX, int posY){
        super(posX, posY);
    }
    
    @Override
    public String getTipo(){
        return "Bomba";
    }
    
    @Override
    public void mostrarImagem(){
        // todo -> mostra a imagem de bomba na célula
    }
    
    @Override
    public void botaoEsquerdo(){
        mostrarImagem();
    } 
}
