
package controle;

import modelo.tratamentos.Tratamentos;
import javax.swing.*;
import modelo.DAO.ClienteDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author aluno
 */
public abstract class ControleCadastroCliente{
    
    public static boolean verificaCampo(String campoNome, String campoCpf, String campoDataN, String tipoCliente){
        
        try{            
            ControleCadastroCliente.verificaCampo(campoNome);
            ControleCadastroCliente.verificaCampo(campoCpf);
            ControleCadastroCliente.verificaCampo(campoDataN);
            ControleCadastroCliente.verificaCampo(tipoCliente);
            return true;     
        }catch(Tratamentos campoVazio){
            JOptionPane.showMessageDialog(null, campoVazio.getMessage());
            return false;   
        }              
        
    
    }
       
    //Metodo para testar campos de cadastro
    private static void verificaCampo(String txt) throws Tratamentos{
        if(txt.isEmpty()){
            throw new Tratamentos("Campo Obrigatório vazio!");
        }
        if(txt.equals("   .   .   -  ")){
            throw new Tratamentos("Campo CPF está vazio!");
        }
        if(txt.equals("  /  /    ")){
            throw new Tratamentos("Campo Data está vazio!");
        }
    }
    
    //Metodo para inserir dados no banco de dados
    public static boolean inserirNoBanco(String campoNome, String campoCpf, String campoDataN, String tipoCliente){
       //instaciando classe DAO.              
       ClienteDAO cd = new ClienteDAO();
       boolean inserir = cd.inserir(campoNome, campoCpf, campoDataN, tipoCliente);
       if(inserir==true){
           return true;
        }
       else{
           return false;
       }
    }
    
    //Metodo para Atualizar dados no banco de dados
    public static boolean AtualizarBanco(int id, String campoNome, String campoCpf, String campoDataN, String tipoCliente){
       //instaciando classe DAO.              
       ClienteDAO cd = new ClienteDAO();
       boolean atualizar = cd.atualizar( id, campoNome, campoCpf, campoDataN, tipoCliente);
       if(atualizar==true){
           return true;
        }
       else{
           return false;
       }
    }
    
    //Metodo para Excluir dados no banco de dados
    public static boolean DeletarDados(int id){
       //instaciando classe DAO.              
       ClienteDAO cd = new ClienteDAO();
       boolean excluir = cd.deletar(id);
       if(excluir==true){
           return true;
        }
       else{
           return false;
       }
    }
    
    
            
    
}//FIM DA CLASSE