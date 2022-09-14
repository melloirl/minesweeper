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
    final int SIZE = 8;
    // 18.7SIZE% de 64 = 12 bombs
    int bombs = ((SIZE*SIZE) * 19)/100;
    Celula[][] celulas = new Celula[SIZE][SIZE];
    ArrayList<Boolean> bombSelector = new ArrayList<>();
    
    public int getSIZE() {
        return SIZE;
    }

    public int getBombs() {
        return bombs;
    }

    public void setBombs(int bombs) {
        this.bombs = bombs;
    }
    
    public Celula[][] getCelulas(){
        return this.celulas;
    }

    public final void generateBombs(){
        for(int i=0; i<SIZE; i++){
            for(int j=0; j<SIZE; j++){
                bombSelector.add(false);
            }
        }
        
        for(int i=0; i<bombs; i++){
            bombSelector.set(i, true);
        }
        
        Collections.shuffle(bombSelector);
    }

    public final void generateMatrix(JToggleButton[][] botoes){
        for(int k=0; k<SIZE*SIZE; k++){
            int i = k/SIZE;
            int j = k % SIZE;
            celulas[i][j] = new Numero(i, j, 0);
            
            if ( bombSelector.get(k) ){
                celulas[i][j] = new Bomba(i, j); 
            }
        }
        
        System.out.println();
        for(int i=0; i<SIZE; i++){
            System.out.print("| ");
            for(int j=0; j<SIZE; j++){
                if( ! celulas[i][j].getTipo().equals("Bomba") ){
                    int proximity = 0;
                    
                    if (i>0      &&             celulas[i-1][j  ].getTipo().equals("Bomba") ) proximity += 1;
                    if (i>0      && j>0      && celulas[i-1][j-1].getTipo().equals("Bomba") ) proximity += 1;
                    if (i>0      && j<SIZE-1 && celulas[i-1][j+1].getTipo().equals("Bomba") ) proximity += 1;
                    
                    if (i<SIZE-1 &&             celulas[i+1][j  ].getTipo().equals("Bomba") ) proximity += 1;
                    if (i<SIZE-1 && j>0      && celulas[i+1][j-1].getTipo().equals("Bomba") ) proximity += 1;
                    if (i<SIZE-1 && j<SIZE-1 && celulas[i+1][j+1].getTipo().equals("Bomba") ) proximity += 1;
                    
                    if (j>0      &&             celulas[i  ][j-1].getTipo().equals("Bomba") ) proximity += 1;
                    if (j<SIZE-1 &&             celulas[i  ][j+1].getTipo().equals("Bomba") ) proximity += 1;
                    
                    celulas[i][j] = new Numero(i, j, proximity);
                }
                celulas[i][j].setBotao( botoes[i][j] );
                
                System.out.printf("(%d,%d)=%7s |", i, j, celulas[i][j].getTipo());
            }
            System.out.println();
        }
    }
}
