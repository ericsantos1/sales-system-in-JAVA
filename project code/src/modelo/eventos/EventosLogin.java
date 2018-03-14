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
import modelo.tratamentos.*;
import visao.*;

/**
 *
 * @author Auricélio
 */
public class EventosLogin implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent ae) {//============ Metodo

        if (ae.getActionCommand() == "entrar") {//-------------------------------

            String campoUser = visao.TelaLogin.getCampoTxt().getText();
            String campoPass = visao.TelaLogin.getCampoSenha().getText();

            boolean verificar = controle.ControleLogin.verificaCampo(campoUser, campoPass);
            //se a verificação for igual a true;
            if (verificar == true) {
                //JOptionPane.showMessageDialog(null, "Clicou em ENTRAR");                
                //instacia a classe UsuarioDAO e acessa o metodo de consulta
                UsuarioDAO ud = new UsuarioDAO();
                boolean consulta = ud.consultar(campoUser, campoPass);
                if(consulta==true){
                    TelaPrincipal telaPrincipal = new TelaPrincipal();
                    visao.TelaLogin.getJanela().setVisible(false);
                    visao.TelaPrincipal.getJanela().setVisible(true);          
                    
                }
                //System.out.println(campoUser);
                //System.out.println(campoPass);

            }

        }//---------------------------------------------------------------------

        if (ae.getActionCommand() == "cadastrar") {//---------------------------------
            
            visao.TelaLogin.getJanela().setVisible(false);
            new TelaCadastroUsuario();
            visao.TelaCadastroUsuario.getJanela().setVisible(true);

        } //--------------------------------------------------------------------       

    }//=============== Fim do metodo
    
}// ================Fim da classe
