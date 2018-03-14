/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import modelo.DAO.VendaDAO;
import modelo.DAO.VendedorDAO;
import modelo.tratamentos.Tratamentos;

/**
 *
 * @author aluno
 */
public abstract class ControleVenda{
    //metodo para verificar todos os campos
    public static boolean verificaCampo(String campoVendedor, String campoCliente, String tipoCliente, String campoProduto, String campoValor, String data){
        
        try{            
            ControleVenda.verificaCampo(campoVendedor);
            ControleVenda.verificaCampo(campoCliente);
            ControleVenda.verificaCampo(tipoCliente);
            ControleVenda.verificaCampo(campoProduto);
            ControleVenda.verificaCampo(campoValor);
            ControleVenda.verificaCampo(data);            
            return true;     
        }catch(Tratamentos campoVazio){
            JOptionPane.showMessageDialog(null, campoVazio.getMessage());
            return false;   
        }  
    
    }
       
    //Metodo para testar campo individualmente
    private static void verificaCampo(String txt) throws Tratamentos{
        if(txt.isEmpty()){
            throw new Tratamentos("Campo Obrigatório Vazio!");
        }
        if(txt.equals("  /  /   -   :  ")){
            throw new Tratamentos("Campo Data Vazio!");
        }
    }
        
    //Metodo para inserir dados no banco de dados
    public static boolean inserirNoBanco(String campoVendedor, String campoCliente, String tipoCliente, String campoProduto, double campoValor, String data){
       //instaciando classe DAO.              
       VendaDAO vd = new VendaDAO();
       boolean inserir = vd.inserir(campoVendedor, campoCliente, tipoCliente, campoProduto, campoValor, data);
       if(inserir==true){
           return true;
        }
       else{
           return false;
       }
    }
    
    //metodo para atualizar dados do banco
    public static boolean atualizarBanco(int id, String campoVendedor, String campoCliente, String tipoCliente, String campoProduto, double campoValor, String data){
        VendaDAO vd = new VendaDAO();
        boolean atualizar = vd.atualizar(id, campoVendedor, campoCliente, tipoCliente, campoProduto, campoValor, data);
        if(atualizar==true){
            return true;
        }else{
            return false;
        }
    }
    
    //metodo para deletar dados do banco
    public static boolean deletarDados(int id){
        VendaDAO vd = new VendaDAO();
        boolean deletar = vd.deletar(id);
        if(deletar==true){
            return true;
        }else{
            return false;
        }
    }
            
    
}//FIM DA CLASSE