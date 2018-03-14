/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.eventos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import modelo.DAO.UsuarioDAO;
import modelo.Usuario;
import modelo.conexao.Conexao;
import modelo.tratamentos.*;
import visao.TelaLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Auricélio
 */
public class EventosCadastro implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getActionCommand()=="voltar"){
            visao.TelaLogin.getJanela().setVisible(true);
            visao.TelaCadastroUsuario.getJanela().setVisible(false);
        }
        if(ae.getActionCommand()=="cadastrar"){
            
            String campoNome = visao.TelaCadastroUsuario.getCampoNome().getText();
            String campoCpf = visao.TelaCadastroUsuario.getCampoCpf().getText();
            String campoSenha = visao.TelaCadastroUsuario.getCampoSenha().getText();            
            String campoDataNasc = visao.TelaCadastroUsuario.getDataNasc().getText();           
            //acessando metodo estático para testar campos
            boolean verifica = controle.ControleCadastroLogin.verificaCampo(campoNome, campoCpf, campoSenha, campoDataNasc);
            //System.out.println(campoNome+"\n"+campoCpf+"\n"+campoSenha+"\n"+campoDataNasc);
            if(verifica==true){
                boolean inserir = controle.ControleCadastroLogin.inserirNoBanco(campoNome, campoCpf, campoSenha, campoDataNasc);
                if(inserir==true){
                    visao.TelaCadastroUsuario.getJanela().setVisible(false);
                    visao.TelaLogin.getJanela().setVisible(true);
                }
            }
       }
        
    }
    
}
