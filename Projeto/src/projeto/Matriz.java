/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JToggleButton;

/**
 *
 * @author Wallace
 */
public class Matriz {
    private final int TAMANHO = 8;
    // 18.75 % de 64 = 12 bombas:
    private final int bombas = ((TAMANHO*TAMANHO) * 19)/100;
    Celula[][] celulas = new Celula[TAMANHO][TAMANHO];
    ArrayList<Boolean> seletorDeBombas = new ArrayList<>();
    
    // Getters
    public int getTAMANHO(){    
        return TAMANHO;
    }

    public int getBombas() {
        return bombas;
    }

    public Celula[][] getCelulas() {
        return celulas;
    }

    public ArrayList<Boolean> getSeletorDeBombas() {    
        return seletorDeBombas;
    }

    // Setters
    public void setCelulas(Celula[][] celulas) {
        this.celulas = celulas;
    }

    public void setSeletorDeBombas(ArrayList<Boolean> seletorDeBombas) {
        this.seletorDeBombas = seletorDeBombas;
    }
    
    // Methods
    public final void gerarBombas() {
        for(int i=0; i<TAMANHO; i++){
            for(int j=0; j<TAMANHO; j++){
                seletorDeBombas.add(false);
            }
        }
        
        for(int i=0; i<bombas; i++){
            seletorDeBombas.set(i, true);
        }
        
        Collections.shuffle(seletorDeBombas);
    }

    public final void gerarMatriz(JToggleButton[][] botoes){
        for(int k=0; k<TAMANHO*TAMANHO; k++){
            int i = k/TAMANHO;
            int j = k % TAMANHO;
            celulas[i][j] = new Numero(i, j, 0);
            
            if ( seletorDeBombas.get(k) ){
                celulas[i][j] = new Bomba(i, j); 
            }
        }
        
        System.out.println();
        for(int i=0; i<TAMANHO; i++){
            System.out.print("| ");
            for(int j=0; j<TAMANHO; j++){
                if( ! celulas[i][j].getTipo().equals("Bomba") ){
                    int adjacentes = 0;
                    
                    if (i>0      &&                   celulas[i-1][j  ].getTipo().equals("Bomba") ) adjacentes += 1;
                    if (i>0      && j>0      &&       celulas[i-1][j-1].getTipo().equals("Bomba") ) adjacentes += 1;
                    if (i>0      && j<TAMANHO-1 &&    celulas[i-1][j+1].getTipo().equals("Bomba") ) adjacentes += 1;
                    
                    if (i<TAMANHO-1 &&                celulas[i+1][j  ].getTipo().equals("Bomba") ) adjacentes += 1;
                    if (i<TAMANHO-1 && j>0      &&    celulas[i+1][j-1].getTipo().equals("Bomba") ) adjacentes += 1;
                    if (i<TAMANHO-1 && j<TAMANHO-1 && celulas[i+1][j+1].getTipo().equals("Bomba") ) adjacentes += 1;
                    
                    if (j>0      &&             celulas[i  ][j-1].getTipo().equals("Bomba") ) adjacentes += 1;
                    if (j<TAMANHO-1 &&             celulas[i  ][j+1].getTipo().equals("Bomba") ) adjacentes += 1;
                    
                    celulas[i][j] = new Numero(i, j, adjacentes);
                }
                celulas[i][j].setBotao( botoes[i][j] );
                
                System.out.printf("(%d,%d)=%7s |", i, j, celulas[i][j].getTipo());
            }
            System.out.println();
        }
    }
}
