/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projeto;
import java.util.HashMap;
import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class TelaPrincipal {
    
    private final HashMap<String,Usuario> usuarios = new HashMap<>();

    public HashMap<String, Usuario> getUsuarios() {
        return usuarios;
    }
    
    public String cadastraUsuario(Usuario cadastrado){
        if(cadastrado.getNome().length() == 0){
            return "Nao foi possivel realizar o cadastro. O campo nome nao pode ser nulo.";
        }
        else if(cadastrado.getLogin().length() == 0){
            return "Nao foi possivel realizar o cadastro. O campo login nao pode ser nulo.";
        }
        else if(cadastrado.getSenha().length() == 0){
            return "Nao foi possível realizar o cadastro. O campo senha nao pode ser nulo.";
        }
        else if(usuarios.containsKey(cadastrado.getLogin())){
            return "Nao foi possível realizar o cadastro. Este login ja  esta sendo utilizado.";
        }
        else{
            usuarios.put(cadastrado.getLogin(), cadastrado);
            return "Usuario cadastrado com sucesso.";
        }
    }
    
    public void alteraNome(String login,String senha, String novo){
        Usuario encontrado = usuarios.get(login);
       if(encontrado != null){
           if(encontrado.getSenha().equals(senha)){
               usuarios.get(login).setNome(novo);
           }
       }
       
    }
    public void alteraSenha(String login,String senha, String novo){
        Usuario encontrado = usuarios.get(login);
       if(encontrado != null){
           if(encontrado.getSenha().equals(senha)){
               usuarios.get(login).setSenha(novo);
           }
       }
       
    }
    
    public void deletaUsuario(String login){
        usuarios.remove(login);
    }
    
    public ArrayList<Usuario> buscaUsuario(String nome){
        ArrayList<Usuario> encontrados = new ArrayList<>();
        for(Usuario usuario : usuarios.values()){
            if(usuario.getNome().equals(nome)){
                encontrados.add(usuario);
            }
        }
        if(!encontrados.isEmpty()){
            System.out.println(encontrados.size() + " usuarios encontrados.");
        }
        else{
            System.out.println("Nenhum usuario encontrado.");
        }
        
        return encontrados;
    }
    

    
}
