/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projeto;
import java.util.Scanner;

/**
 *
 * @author Pedro
 */
public class Projeto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Testing user signup
        
        TelaPrincipal tela1 = new TelaPrincipal();
        
        String nome, usuario, senha;
        
        while(true){
            //Create
            Scanner ls = new Scanner(System.in);

            System.out.println("Insira seu nome:");

            nome = ls.nextLine();

            System.out.println("Insira seu usuario:");

            usuario = ls.nextLine();

            System.out.println("Insira sua senha:");

            senha = ls.nextLine();
            
            tela1.cadastraUsuario(new Usuario(nome,usuario,senha));
            System.out.println(tela1.getUsuarios());
            
            //Read
            System.out.println("Insira o nome a ser buscado:");
            
            String buscar;
            
            buscar = ls.nextLine();
            
            
            tela1.buscaUsuario(buscar);
            System.out.println(tela1.getUsuarios());
            
            //Update
            
            //Delete
            System.out.println("Insira o login a ser deletado:");
            
            String deletar;
            
            deletar = ls.nextLine();
            
            tela1.deletaUsuario(deletar);
            
            System.out.println(tela1.getUsuarios());
        }
    }
    
}
