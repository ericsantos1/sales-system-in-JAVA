/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import visao.GerenciarCliente;

/**
 *
 * @author Auricélio
 */
public class EventosTabelaCliente implements MouseListener{

    @Override //clicou no elemento
    public void mouseClicked(MouseEvent e) {
        //Atribuindo valor boolean a variavel para checar se linha da tabela esta  selecionada
        visao.GerenciarCliente.setLinhaSelecionada(true);
        Object obj0 = GerenciarCliente.getTabela().getValueAt(GerenciarCliente.getTabela().getSelectedRow(), 0);
        Object obj1 = GerenciarCliente.getTabela().getValueAt(GerenciarCliente.getTabela().getSelectedRow(), 1);
        Object obj2 = GerenciarCliente.getTabela().getValueAt(GerenciarCliente.getTabela().getSelectedRow(), 2);
        Object obj3 = GerenciarCliente.getTabela().getValueAt(GerenciarCliente.getTabela().getSelectedRow(), 3);
        //System.out.println(obj1+", "+obj2+", "+obj3+", "+", "+obj4);
        visao.GerenciarCliente.getId().setText(obj0.toString());
        visao.GerenciarCliente.getCampoNome().setText(obj1.toString());
        visao.GerenciarCliente.getCampoCpf().setText(obj2.toString());
        visao.GerenciarCliente.getDataNasc().setText(obj3.toString());        
   }

    @Override//prescionou no elemento
    public void mousePressed(MouseEvent e) {
       
    }

    @Override//soltou no elemento
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override//entrou no elemento
    public void mouseEntered(MouseEvent e) {
       
    }

    @Override//saiu do elemento
    public void mouseExited(MouseEvent e) {
       
    }
    
}
