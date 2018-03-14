/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.conexao.Conexao;
import modelo.Usuario;

/**
 *
 * @author Auricélio
 */
public class UsuarioDAO extends Conexao{
    private String tbUsuario = "tb_usuario";
    private PreparedStatement ps;
    private ResultSet rs;
      
    //Metodo para Inserir Usuario no banco de dados
    public boolean inserir(String campoNome, String campoCpf, String campoSenha, String campoDataN){
        
        String sql1 = "INSERT INTO "+this.tbUsuario+" VALUES (?,?,?,?,?)";
        
        try{
            this.ps = super.getCon().prepareStatement(sql1);
            this.ps.setInt(1, 0);
            this.ps.setString(2,campoNome);
            this.ps.setString(3,campoCpf);
            this.ps.setString(4,campoSenha);
            this.ps.setString(5,campoDataN);
            this.ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
            return true;
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Infelismente houve Falha no cadastro");
            return false;
        }            
    }
 
    //Metodo para consultar se existe Usuario no banco de dados
    public boolean consultar(String campoCpf, String campoSenha){
        try {   
            String sql2 = "SELECT * FROM "+this.tbUsuario+" WHERE cpf='"+campoCpf+"' && senha='"+campoSenha+"' ";            
                this.ps = super.getCon().prepareStatement(sql2);
                this.rs = this.ps.executeQuery();
                if(this.rs.last()){
                    //JOptionPane.showMessageDialog(null, "BEM VINDO AO SISTEMA!");
                    return true;
               }else{
                JOptionPane.showMessageDialog(null, "Usuario não cadastrado!");
                    return false;
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "usuario não cadastrado!");
                    return false;
          }
        
                 
    }
    
    //Metodo para inserir Usuario caso não exita nenhum
    public void InserirUsuarioPadrao(){
        String sql1 = "SELECT * FROM "+this.tbUsuario; 
        String sql2 = "INSERT INTO "+this.tbUsuario+" VALUES (?,?,?,?,?)";
        try {                        
                this.ps = super.getCon().prepareStatement(sql1);
                this.rs = this.ps.executeQuery();
                //verifica se exite alguma linha com registro de usuario
                if(!this.rs.last()){
                    //Se não tiver, realiza um cadastro altomaticamente
                    this.ps = super.getCon().prepareStatement(sql2);
                    this.ps.setInt(1, 0);
                    this.ps.setString(2,"Eric Santos");
                    this.ps.setString(3,"000.000.000-00");
                    this.ps.setString(4,"000");
                    this.ps.setString(5,"22/03/1995");
                    this.ps.executeUpdate();
                    System.out.println("Tabela vazia, Usuário padrão cadastrado com sucesso!");
                }  
                
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "usuario não cadastrado!");
                    
          }
                    
    }
}

    

