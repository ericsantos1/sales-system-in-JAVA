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
import modelo.DAO.VendedorDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author aluno
 */
public abstract class ControleCadastroVendedor{
    
    public static boolean verificaCampo(String campoNome, String campoCpf, String campoDataN, String campoSalario){
        
        try{            
            ControleCadastroVendedor.verificaCampo(campoNome);
            ControleCadastroVendedor.verificaCampo(campoCpf);
            ControleCadastroVendedor.verificaCampo(campoDataN);
            ControleCadastroVendedor.verificaCampo(campoSalario);
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
    public static boolean inserirNoBanco(String campoNome, String campoCpf, String campoDataN, double campoSalario){
            
            //instaciando classe DAO.              
            VendedorDAO vd = new VendedorDAO();
            boolean inserir = vd.inserir(campoNome, campoCpf, campoDataN, campoSalario);
            if(inserir==true){
                return true;
             }
            else{
                return false;
            }
       
    }
    
    //Metodo para Atualizar dados no banco de dados
    public static boolean AtualizarBanco(int id, String campoNome, String campoCpf, String campoDataN, double campoSalario){
       //instaciando classe DAO.              
       VendedorDAO vd = new VendedorDAO();
       boolean atualizar = vd.atualizar( id, campoNome, campoCpf, campoDataN, campoSalario);
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
       VendedorDAO vd = new VendedorDAO();
       boolean excluir = vd.deletar(id);
       if(excluir==true){
           return true;
        }
       else{
           return false;
       }
    }
    
}//FIM DA CLASSE