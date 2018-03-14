/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import modelo.conexao.Conexao;
import visao.*;

/**
 *
 * @author Auricélio
 */
public class EventosPagPrincipal implements ActionListener {
    
    private static JFrame janela;
    
    @Override
    public void actionPerformed(ActionEvent ae) {
                
        if(ae.getActionCommand()=="vendedor"){
            new GerenciarVendedor();
            visao.GerenciarVendedor.getJanela().setVisible(true);
            visao.TelaPrincipal.getJanela().setVisible(false);
            
        }
        if(ae.getActionCommand()=="cliente"){
            new GerenciarCliente();
            visao.GerenciarCliente.getJanela().setVisible(true);
            visao.TelaPrincipal.getJanela().setVisible(false);
        }
        if(ae.getActionCommand()=="vendas"){
            new GerenciarVendas();
            visao.GerenciarVendas.getJanela().setVisible(true);
            visao.TelaPrincipal.getJanela().setVisible(false);
        }
        if(ae.getActionCommand()=="sair"){
            Conexao con = new Conexao();
            con.fecharConexao();
            visao.TelaPrincipal.getJanela().setVisible(false);
            new TelaLogin();
        }
        
    }
    
}
