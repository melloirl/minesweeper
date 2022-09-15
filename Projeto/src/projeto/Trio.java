/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;
import java.lang.Comparable;
/**
 *
 * @author lucas
 */
public class Trio{
    private final int numero;
    private final String nome;
    private final String tipo;
    
    public Trio(int numero, String nome, String tipo) {
        this.numero = numero;
        this.nome = nome;
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return tipo;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

}