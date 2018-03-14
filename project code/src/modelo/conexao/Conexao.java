package modelo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.tratamentos.Tratamentos;

public class Conexao {
    private String endereco = "localhost";
    private String nomeBanco = "db_projeto";
    private String login = "root";
    private String senha = "";
    private Connection con;
    
    //Construtor de conexão
    public Conexao(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //URL DE CANEXÃO
            String url = "jdbc:mysql://"+this.endereco+"/"+this.nomeBanco+"?user="+this.login+"&password="+this.senha;
            //COLOCANDO A URL DENTRO DO DRIVER DE CONEXÃO, retornando automaticamente true ou false para this.con;
            this.con = DriverManager.getConnection(url);            
            System.out.println("Conexão feita");                   
           
        } catch (Exception erroConexao) {
            JOptionPane.showMessageDialog(null, erroConexao.getMessage());    
            System.out.println("Erro de conexao"); 
        }
    }
    
    //Metodo para pegar e retornar uma conexão
    public Connection getCon() {
        return con;
    }
    
    //Metodo para fechar 
    public void fecharConexao(){
        try {
            this.con.close();
            System.out.println("coneção fechada!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
    }
      
    
}
