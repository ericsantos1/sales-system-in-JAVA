/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.eventos;

import controle.ControleVenda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import modelo.DAO.VendaDAO;
import modelo.Venda;
import visao.GerenciarVendas;
import visao.TelaPrincipal;

/**
 *
 * @author Auricélio
 */
public class EventosVenda implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getActionCommand().equals("addVenda")){
            visao.GerenciarVendas.getJanela().setVisible(false);
            visao.GerenciarVendas.setLinhaSelecionada(false);
            new TelaPrincipal();
        }  
        
        if(ae.getActionCommand().equals("limpar")){
            visao.GerenciarVendas.getId().setText(null);
            visao.GerenciarVendas.getDataVenda().setText(null);
            visao.GerenciarVendas.getCampoVendedor().setText(null);  
            visao.GerenciarVendas.getCampoCliente().setText(null);
            visao.GerenciarVendas.getCampoProduto().setText(null);
            visao.GerenciarVendas.getCampoValor().setText(null);            
        }
        
        //VENDER================================================================
        if(ae.getActionCommand()=="vender"){
            //testando e pegandfo o tipo de cliente 
            JRadioButton fisico = visao.TelaPrincipal.getFisico();
            JRadioButton juridico = visao.TelaPrincipal.getJuridico();    
            //System.out.println(fisico+"\n"+juridico);
            String tipoCliente = null;
            if(fisico.isSelected() || juridico.isSelected()){
                if(fisico.isSelected()){
                    tipoCliente = fisico.getText();
                }
                else if(juridico.isSelected()){
                    tipoCliente = juridico.getText();
                }                   
            }
            else{
                JOptionPane.showMessageDialog(null, "Por Favor, Escolha o tipo de Cliente!");
            }
            //pegando os demais valores         
            String vendedor = visao.TelaPrincipal.getCbxVendedor().getSelectedItem().toString();
            String cliente = visao.TelaPrincipal.getCbxCliente().getSelectedItem().toString();           
            String produto = visao.TelaPrincipal.getCampoProduto().getText();
            String valor = visao.TelaPrincipal.getCampoValor().getText();
            String data = visao.TelaPrincipal.getCampoData().getText();
                        
            //chamando metodo para testar se campos estão preechidos
            boolean verifica = controle.ControleVenda.verificaCampo(vendedor, cliente, tipoCliente, produto, valor, data);
            //se todos os campos estiveram preenchidos vai inserir no banco 
            if(verifica==true){
                //transformando string do valor em decimal
                double valorVenda = Double.parseDouble(valor);
                //chamando metodo statico para inserir no banco
                boolean inserir = controle.ControleVenda.inserirNoBanco(vendedor, cliente, tipoCliente, produto, valorVenda, data);
                if(inserir==true){
                    //atualiza a janela principal
                    visao.TelaPrincipal.getJanela().setVisible(false);
                    new TelaPrincipal();
                }
            }
        }
        //======================================================================
        
        //EDITAR VENDAS=========================================================       
        if(ae.getActionCommand()=="editarVenda"){
            boolean linhaSelecionada = visao.GerenciarVendas.isLinhaSelecionada();
            if(linhaSelecionada==true){
                //pegando os valores do tipo de cliente
                JRadioButton fisico = visao.GerenciarVendas.getFisico();
                JRadioButton juridico = visao.GerenciarVendas.getJuridico();
                String tipoCliente = null;
                if(fisico.isSelected() || juridico.isSelected()){
                    if(fisico.isSelected()){
                        tipoCliente = fisico.getText();
                    }
                    else if(juridico.isSelected()){
                        tipoCliente = juridico.getText();
                    }                   
                }
                else{
                    JOptionPane.showMessageDialog(null, "Por Favor, Escolha o tipo de Cliente!");
                }
                //pegando os demais valores
                String IDstring = visao.GerenciarVendas.getId().getText();
                String data = visao.GerenciarVendas.getDataVenda().getText();
                String vendedor = visao.GerenciarVendas.getCampoVendedor().getText();
                String cliente = visao.GerenciarVendas.getCampoCliente().getText();                
                String produto = visao.GerenciarVendas.getCampoProduto().getText();
                String valorString = visao.GerenciarVendas.getCampoValor().getText();
                
                boolean verifica = controle.ControleVenda.verificaCampo(vendedor, cliente, tipoCliente, produto, valorString, data);
                              
                if(verifica==true){ 
                    //convertendo valores dos campos "IDstring e valorString"
                    int IDint = Integer.parseInt(IDstring);
                    double valorDouble = Double.parseDouble(valorString);
                    //instanciando classe DAO
                    VendaDAO vd = new VendaDAO();
                    //chamando metodo statico para atulaizar.
                    boolean atualizar = vd.atualizar(IDint, vendedor, cliente, tipoCliente, produto, valorDouble, data);
                    if(atualizar==true){
                        //atualiza a tabela de vendas
                        visao.GerenciarVendas.getJanela().setVisible(false);                        
                        new GerenciarVendas();
                        //variavel que verifica se alguma venda esta selecionada volta a ser false
                        visao.GerenciarVendas.setLinhaSelecionada(false);
                    }
                }
            }else{
                System.err.println("Nenhuma venda selecionada!");
                JOptionPane.showMessageDialog(null, "Nenhuma venda selecionada!");
            }
                
        }
        
        // EXCLUIR==============================================================
        if(ae.getActionCommand()=="excluirVenda"){
            boolean linhaSelecionada = visao.GerenciarVendas.isLinhaSelecionada();
            if(linhaSelecionada==true){
                    //pegando valor strring do id
                    String IDstring = visao.GerenciarVendas.getId().getText();
                    //convertendo id string para int
                    int IDint = Integer.parseInt(IDstring);
                    //instanciando classe DAO
                    VendaDAO vd = new VendaDAO();
                    boolean deletar = vd.deletar(IDint);
                    if(deletar==true){
                        //atualiza a tabela de vendas
                        visao.GerenciarVendas.getJanela().setVisible(false);                        
                        new GerenciarVendas();
                        //variavel que verifica se alguma venda esta selecionada volta a ser false
                        visao.GerenciarVendas.setLinhaSelecionada(false);
                    }
            }else{
                System.err.println("Nenhuma venda selecionada!");
                JOptionPane.showMessageDialog(null, "Nenhuma venda selecionada!");
            }
        }
        //======================================================================
            
        //VOLTAR================================================================
        if(ae.getActionCommand().equals("voltar")){
            visao.GerenciarVendas.getJanela().setVisible(false);
            new TelaPrincipal();
            visao.GerenciarVendas.setLinhaSelecionada(false);
        }
        //======================================================================
    }
    
}
