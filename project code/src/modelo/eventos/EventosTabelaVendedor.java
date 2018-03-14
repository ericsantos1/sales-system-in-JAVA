/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.eventos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import visao.*;
/**
 *
 * @author Auricélio
 */
public class EventosTabelaVendedor implements MouseListener{

    @Override //clicou no elemento
    public void mouseClicked(MouseEvent e) {
        //Atribuindo valor boolean a variavel para checar se linha da tabela esta  selecionada
        visao.GerenciarVendedor.setLinhaSelecionada(true);
        Object obj1 = GerenciarVendedor.getTabela().getValueAt(GerenciarVendedor.getTabela().getSelectedRow(), 0);
        Object obj2 = GerenciarVendedor.getTabela().getValueAt(GerenciarVendedor.getTabela().getSelectedRow(), 1);
        Object obj3 = GerenciarVendedor.getTabela().getValueAt(GerenciarVendedor.getTabela().getSelectedRow(), 2);
        Object obj4 = GerenciarVendedor.getTabela().getValueAt(GerenciarVendedor.getTabela().getSelectedRow(), 3);
        Object obj5 = GerenciarVendedor.getTabela().getValueAt(GerenciarVendedor.getTabela().getSelectedRow(), 4);
        //System.out.println(obj1+", "+obj2+", "+obj3+", "+", "+obj4);
        visao.GerenciarVendedor.getId().setText(obj1.toString());
        visao.GerenciarVendedor.getCampoNome().setText(obj2.toString());
        visao.GerenciarVendedor.getCampoCpf().setText(obj3.toString());
        visao.GerenciarVendedor.getDataNasc().setText(obj4.toString());
        visao.GerenciarVendedor.getSalario().setText(obj5.toString());

        
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
