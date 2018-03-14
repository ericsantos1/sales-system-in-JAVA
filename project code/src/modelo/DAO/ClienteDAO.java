/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.Cliente;
import modelo.ModeloTabCliente;
import modelo.Pessoa;
import modelo.conexao.Conexao;

/**
 *
 * @author Auricélio
 */
public class ClienteDAO extends Conexao{
    private String tabela = "tb_cliente";
    private PreparedStatement ps;
    private ResultSet rs;
        
    //Metodo para Inserir Usuario no banco de dados
    public boolean inserir(String campoNome, String campoCpf, String campoDataN, String tipoCliente){
    
        String sql1 = "INSERT INTO "+this.tabela+" VALUES (?,?,?,?,?)";
        
        try{
            this.ps = super.getCon().prepareStatement(sql1);
            this.ps.setInt(1, 0);
            this.ps.setString(2,campoNome);
            this.ps.setString(3,campoCpf);
            this.ps.setString(4,campoDataN);
            this.ps.setString(5,tipoCliente);
            this.ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
            return true;
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Infelismente houve Falha no cadastro");
            return false;
        }            
    }  
    
    //Metodo para Atualizar  no banco de dados
    public boolean atualizar(int id, String campoNome, String campoCpf, String campoDataN, String tipoCliente){
    
        String sql = "UPDATE "+this.tabela+" SET nome = ?, cpf = ?, dataN = ?, tipoCliente = ? WHERE ID = ?";
        
        try{
            this.ps = super.getCon().prepareStatement(sql);
            
            this.ps.setString( 1, campoNome);
            this.ps.setString( 2, campoCpf);
            this.ps.setString( 3, campoDataN);
            this.ps.setString( 4, tipoCliente);
            this.ps.setInt( 5, id);
            
            this.ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente Atualizado com Sucesso!");
            return true;
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Infelismente houve Falha ao Atualizar");
            return false;
        }            
    } 
    
    //Metodo para Deletar dados no banco de dados
    public boolean deletar(int id){
    
        String sql = "DELETE FROM "+this.tabela+" WHERE ID = ?";
        
        try{
            this.ps = super.getCon().prepareStatement(sql);
            this.ps.setInt( 1, id);            
            this.ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente Excluido com Sucesso!");
            return true;
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Infelismente houve Falha ao Excluir");
            return false;
        }            
    }
    
    //Metodo para Inserir lista dos Nomes de Clientes em ComboBox
    public void listarClientes(JComboBox cbx){    
        String url = "SELECT nome FROM "+this.tabela;    
        try {
            this.ps = super.getCon().prepareStatement(url);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                Pessoa x = new Pessoa();
                x.setNome(this.rs.getString("nome"));
                cbx.addItem(x.getNome());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //Metodo para listar Clientes em TABELA
    public JTable listarClientes(JTable tb){   
        //criando ArrayLista
        ArrayList<Cliente> listarCliente = new ArrayList<>();
        //instanciando modelo de tabela criado e passando um ArrayList como parametro
                
        String sql2 = "SELECT * FROM "+this.tabela;    
        try {
            this.ps = super.getCon().prepareStatement(sql2);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                Cliente x1 = new Cliente(null, null, null, null);
                x1.setID(this.rs.getInt("ID"));
                x1.setNome(this.rs.getString("nome"));
                x1.setCpf(this.rs.getString("cpf"));
                x1.setDataN(this.rs.getString("dataN"));                                
                x1.setTipo(this.rs.getString("tipoCliente"));
                //add objetos preenchidos no arraylist
                listarCliente.add(x1);
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        //instanciando o modelo da tabela e o preenchendo os valores do arraylist
        ModeloTabCliente modeloTb = new ModeloTabCliente(listarCliente);
        //instanciando uma tabela e adicionando o modelo da tabela
        tb = new JTable(modeloTb);
        return tb;
        
    }
    
}