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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import modelo.Cliente;
import modelo.ModeloTabVendas;
import modelo.Pessoa;
import modelo.Venda;
import modelo.Vendedor;
import modelo.conexao.Conexao;

/**
 *
 * @author Auricélio
 */
public class VendaDAO extends Conexao{
    private String tabela = "tb_venda";
    private PreparedStatement ps;
    private ResultSet rs;
    private JScrollPane jScrollPane1;
        
    //Metodo para Inserir Usuario no banco de dados
    public boolean inserir(String campoVendedor, String campoCliente, String tipoCliente, String campoPruduto, double campoValor, String data){
    
        String sql1 = "INSERT INTO "+this.tabela+" VALUES (?,?,?,?,?,?,?)";
          
        try{
            this.ps = super.getCon().prepareStatement(sql1);
            this.ps.setInt(1, 0);
            this.ps.setString(2, campoVendedor);
            this.ps.setString(3, campoCliente);
            this.ps.setString(4, tipoCliente);
            this.ps.setString(5, campoPruduto);
            this.ps.setDouble(6, campoValor);
            this.ps.setString(7, data);
            this.ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Venda Realisada com Sucesso!");
            return true;
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Infelismente houve Falha na venda");
            return false;
        }            
    }   
    
    //Metodo para Atualizar  no banco de dados
    public boolean atualizar(int id, String vendedor, String cliente, String tipoCliente, String produto, double valor, String data){
    
        String sql = "UPDATE "+this.tabela+" SET vendedor = ?, cliente = ?, tipoCliente = ?, produto = ? valor = ?, data = ? WHERE ID = ?";
        //String sql = "UPDATE "+this.tabela+" SET vendedor = '"+vendedor+"', cliente = '"+cliente+"', tipoCliente = '"+tipoCliente+"', "
          //      + "produto = '"+produto+"' valor = '"+valor+"', data = '"+data+"' WHERE ID = '"+id+"'";
        
        try{
            this.ps = super.getCon().prepareStatement(sql);
            
            this.ps.setString( 1, vendedor);
            this.ps.setString( 2, cliente);
            this.ps.setString( 3, tipoCliente);
            this.ps.setString( 4, produto);
            this.ps.setDouble( 5, valor);
            this.ps.setString( 6, data);            
            this.ps.setInt( 7, id);            
            this.ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Venda Atualizada com Sucesso!");
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
            JOptionPane.showMessageDialog(null, "Venda Excluida com Sucesso!");
            return true;
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Infelismente houve Falha ao Excluir");
            return false;
        }            
    }    
    
     //Metodo para listar vendas em tabela
    public JTable listarVendas(JTable tb){   
        //criando ArrayLista
        ArrayList<Venda> listaVendas = new ArrayList<>();
        //instanciando modelo de tabela criado e passando um ArrayList como parametro
                
        String sql2 = "SELECT * FROM "+this.tabela;    
        try {
            this.ps = super.getCon().prepareStatement(sql2);
            this.rs = this.ps.executeQuery();
            while(this.rs.next()){
                Venda x = new Venda();
                x.setId(this.rs.getInt("ID"));
                x.setDataVenda(this.rs.getString("data"));
                x.setVendedor(new Vendedor(this.rs.getString("vendedor"), null, 0));
                x.setCliente(new Cliente(this.rs.getString("cliente"), null, null,this.rs.getString("tipoCliente")));
                x.setNomeProduto(this.rs.getString("produto"));
                x.setValorProduto(this.rs.getDouble("valor"));
                System.out.println(x.getId());
                System.out.println(x.getDataVenda());
                System.out.println(x.getVendedor().getNome());
                System.out.println(x.getCliente().getNome());
                System.out.println(x.getCliente().getTipo());
                System.out.println(x.getNomeProduto());
                System.out.println(x.getValorProduto());
                listaVendas.add(x);                              
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        ModeloTabVendas modeloTb = new ModeloTabVendas(listaVendas);
        //instanciando uma tabela e adicionando o modelo da tabela
        tb = new JTable(modeloTb);
        return tb;
        
    }
        
}  
