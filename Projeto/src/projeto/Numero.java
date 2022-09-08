/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;

/**
 *
 * @author Wallace
 */
public class Numero extends Celula implements TipoCelula {
    int algarismo;
    
    public Numero(int posX, int posY, int algarismo){
        super(posX, posY);
        this.algarismo = algarismo;
    }

    @Override
    public String getTipo(){
        return "Numero" + String.valueOf(algarismo);
    }
    
    @Override
    public void mostrarImagem(){
        // todo -> mostra a imagem de numero na célula com um switch para diferentes algarismos
    }
    
    @Override
    public void botaoEsquerdo(){
        mostrarImagem();
    }
}
