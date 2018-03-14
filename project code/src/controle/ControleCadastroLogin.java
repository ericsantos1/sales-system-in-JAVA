/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.tratamentos.Tratamentos;
import javax.swing.*;
import modelo.DAO.UsuarioDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author aluno
 */
public abstract class ControleCadastroLogin{
    
    public static boolean verificaCampo(String campoNome, String campoCpf, String campoSenha, String campoDataN){
        
        try{            
            ControleCadastroLogin.verificaCampo(campoNome);
            ControleCadastroLogin.verificaCampo(campoCpf);
            ControleCadastroLogin.verificaCampo(campoSenha);
            ControleCadastroLogin.verificaCampo(campoDataN);
            return true;     
        }catch(Tratamentos campoVazio){
            JOptionPane.showMessageDialog(null, campoVazio.getMessage());
            return false;   
        }  
    }
       
    
    //Metodo para inserir dados no banco de dados
    public static boolean inserirNoBanco(String campoNome, String campoCpf, String campoSenha, String campoDataN){
       //instaciando classe DAO.              
       UsuarioDAO ud = new UsuarioDAO();
       boolean inserir= ud.inserir(campoNome, campoCpf, campoSenha, campoDataN);       
       if(inserir==true){
           return true;
       }
       else{
           return false;
       }
    }
    
    
    //Metodo para testar campos de cadastro
    private static void verificaCampo(String txt) throws Tratamentos{
        if(txt.isEmpty()){
            throw new Tratamentos("campo vazio");
        }
    }

    
}//FIM DA CLASSE
