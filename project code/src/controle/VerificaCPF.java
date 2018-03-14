/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.conexao.Conexao;

/**
 *
 * @author Auricélio
 */
public class VerificaCPF extends Conexao{
    
    private String tabelaVendedor = "tb_vendedor";
    private String tabelaCliente = "tb_cliente";
    private String tabelaUsuario = "tb_usuario";
    private PreparedStatement ps;
    private ResultSet rs;
    

    
   public boolean consultarCpfVendedor(String Cpf){
        try {   
            String sql = "SELECT * FROM "+this.tabelaVendedor+" WHERE cpf='"+Cpf+"' ";            
                this.ps = super.getCon().prepareStatement(sql);
                this.rs = this.ps.executeQuery();
                if(!this.rs.last()){                    
                    return true;
               }else{
                    //JOptionPane.showMessageDialog(null, "CPF digitado já está em uso!");
                    return false;
                }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "CPF digitado já está em uso!");
                    return false;
          }
                    
    }
   
   public boolean consultarCpfCliente(String Cpf){
        try {   
            String sql = "SELECT * FROM "+this.tabelaCliente+" WHERE cpf='"+Cpf+"' ";            
                this.ps = super.getCon().prepareStatement(sql);
                this.rs = this.ps.executeQuery();
                if(!this.rs.last()){                    
                    return true;
               }else{
                    //JOptionPane.showMessageDialog(null, "CPF digitado já está em uso!");
                    return false;
                }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "CPF digitado já está em uso!");
                    return false;
          }
                    
    }
   
   public boolean consultarCpfUsuario(String Cpf){
        try {   
            String sql = "SELECT * FROM "+this.tabelaUsuario+" WHERE cpf='"+Cpf+"' ";            
                this.ps = super.getCon().prepareStatement(sql);
                this.rs = this.ps.executeQuery();
                if(!this.rs.last()){                    
                    return true;
               }else{
                    JOptionPane.showMessageDialog(null, "CPF digitado já está em uso!");
                    return false;
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "CPF digitado já está em uso!");
                    return false;
          }
                    
    }
    
}
