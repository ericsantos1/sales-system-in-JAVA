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
import modelo.ModeloTabVendedor;
import modelo.Pessoa;
import modelo.Vendedor;
import modelo.conexao.Conexao;

/**
 *
 * @author Auricélio
 */
public class VendedorDAO extends Conexao{
    private String tabela = "tb_vendedor";
    private PreparedStatement ps;
    private ResultSet rs;
      
    //Metodo para Inserir Vendedor no banco de dados
    public boolean inserir(String campoNome, String campoCpf, String campoDataN, double campoSalario){
    
        String sql = "INSERT INTO "+this.tabela+" VALUES (?,?,?,?,?)";
        
        try{
            this.ps = super.getCon().prepareStatement(sql);
            this.ps.setInt(1, 0);
            this.ps.setString(2,campoNome);
            this.ps.setString(3,campoCpf);
            this.ps.setString(4,campoDataN);
            this.ps.setDouble(5,campoSalario);
            this.ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Vendedor Cadastrado com Sucesso!");
            return true;
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Infelismente houve Falha no cadastro");
            return false;
        }            
    } 
    
    //Metodo para Atualizar Vendedor no banco de dados
    public boolean atualizar(int id, String campoNome, String campoCpf, String campoDataN, double campoSalario){
    
        String sql = "UPDATE "+this.tabela+" SET nome = ?, cpf = ?, dataN = ?, salario = ? WHERE ID = ?";
        
        try{
            this.ps = super.getCon().prepareStatement(sql);
            
            this.ps.setString( 1, campoNome);
            this.ps.setString( 2, campoCpf);
            this.ps.setString( 3, campoDataN);
            this.ps.setDouble( 4, campoSalario);
            this.ps.setInt( 5, id);
            
            this.ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Vendedor Atualizado com Sucesso!");
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
            JOptionPane.showMessageDialog(null, "Vendedor Excluido com Sucesso!");
            return true;
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Infelismente houve Falha ao Excluir");
            return false;
        }            
    }
    
    
    //Metodo para Inserir lista dos Nomes de Vendedores em ComboBox
    public void listarVendedores(JComboBox cbx){    
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
  
  //Metodo para listar vendedores em TABELA
    public JTable listarVendedores(JTable tb){   
        //criando ArrayLista
        ArrayList<Vendedor> listarVendedores = new ArrayList<>();
        //instanciando modelo de tabela criado e passando um ArrayList como parametro
                
        String sql2 = "SELECT * FROM "+this.tabela;    
        try {
            this.ps = super.getCon().prepareStatement(sql2);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                Vendedor x1 = new Vendedor(null,null,0);
                x1.setID(this.rs.getInt("ID"));
                x1.setNome(this.rs.getString("nome"));
                x1.setCpf(this.rs.getString("cpf"));
                x1.setDataN(this.rs.getString("dataN"));
                x1.setSalario(this.rs.getDouble("salario"));
                listarVendedores.add(x1);
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        ModeloTabVendedor modeloTb = new ModeloTabVendedor(listarVendedores);
        //instanciando uma tabela e adicionando o modelo da tabela
        tb = new JTable(modeloTb);
        return tb;
        
    }
    
}