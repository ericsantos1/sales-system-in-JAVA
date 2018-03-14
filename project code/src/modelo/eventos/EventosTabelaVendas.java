/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.eventos;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import visao.GerenciarVendas;

/**
 *
 * @author Auricélio
 */
public class EventosTabelaVendas implements MouseListener{

    @Override //clicou no elemento
    public void mouseClicked(MouseEvent e) {
        //Atribuindo valor boolean a variavel para checar se linha da tabela esta  selecionada
        visao.GerenciarVendas.setLinhaSelecionada(true);
        Object obj0 = GerenciarVendas.getTabela().getValueAt(GerenciarVendas.getTabela().getSelectedRow(), 0);
        Object obj1 = GerenciarVendas.getTabela().getValueAt(GerenciarVendas.getTabela().getSelectedRow(), 1);
        Object obj2 = GerenciarVendas.getTabela().getValueAt(GerenciarVendas.getTabela().getSelectedRow(), 2);
        Object obj3 = GerenciarVendas.getTabela().getValueAt(GerenciarVendas.getTabela().getSelectedRow(), 3);
        Object obj5 = GerenciarVendas.getTabela().getValueAt(GerenciarVendas.getTabela().getSelectedRow(), 5);
        Object obj6 = GerenciarVendas.getTabela().getValueAt(GerenciarVendas.getTabela().getSelectedRow(), 6);
        //System.out.println(obj1+", "+obj2+", "+obj3+", "+", "+obj4);
        visao.GerenciarVendas.getId().setText(obj0.toString());
        visao.GerenciarVendas.getDataVenda().setText(obj1.toString());
        visao.GerenciarVendas.getCampoVendedor().setText(obj2.toString());
        visao.GerenciarVendas.getCampoCliente().setText(obj3.toString());
        visao.GerenciarVendas.getCampoProduto().setText(obj5.toString());
        visao.GerenciarVendas.getCampoValor().setText(obj6.toString());
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
