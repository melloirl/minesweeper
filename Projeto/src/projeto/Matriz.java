/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Wallace
 */
public class Matriz {
    
    Celula[][] celulas = new Celula[20][20];
    ArrayList<Boolean> bombSelector = new ArrayList<>();
    // 40% de bombas
    int bombs = ((20*20) * 4)/10;
    
    public void generateBombs(){
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                bombSelector.add(false);
            }
        }
        
        for(int i=0; i<bombs; i++){
            bombSelector.set(i, true);
        }
        
        Collections.shuffle(bombSelector);
    }
    
    public void generateMatrix(){
        for(int k=0; k<400; k++){
            int i = k/20;
            int j = k % 20;
            celulas[i][j] = new Numero(i, j, 0);
            
            if ( bombSelector.get(k) ){
                celulas[i][j] = new Bomba(i, j); 
                System.out.println(i + "    " + j);
            }
        }
        
        for(int i=0; i<20; i++){
            for(int j=0; j<20; j++){
                if( ! celulas[i][j].getTipo().equals("Bomba") ){
                    int proximity = 0;
                    
                    if (i>0 &&         celulas[i-1][j].getTipo().equals("Bomba") ) proximity += 1;
                    if (i>0 && j>0  && celulas[i-1][j-1].getTipo().equals("Bomba") ) proximity += 1;
                    if (i>0 && j<19 && celulas[i-1][j+1].getTipo().equals("Bomba") ) proximity += 1;
                    
                    if (i<19 &&         celulas[i+1][j].getTipo().equals("Bomba") ) proximity += 1;
                    if (i<19 && j>0  && celulas[i+1][j-1].getTipo().equals("Bomba") ) proximity += 1;
                    if (i<19 && j<19 && celulas[i+1][j+1].getTipo().equals("Bomba") ) proximity += 1;
                    
                    if (j>0  && celulas[i][j-1].getTipo().equals("Bomba") ) proximity += 1;
                    if (j<19 && celulas[i][j+1].getTipo().equals("Bomba") ) proximity += 1;
                    
                    celulas[i][j] = new Numero(i, j, proximity);
                }
                
                System.out.println(i + "   " + j + "   " + celulas[i][j].getTipo());
            }
        }
    }
}
