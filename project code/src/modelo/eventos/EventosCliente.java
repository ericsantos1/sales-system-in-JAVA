/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.eventos;

import controle.ControleCadastroCliente;
import controle.VerificaCPF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import visao.CadastroCliente;
import visao.EditarCliente;
import visao.GerenciarCliente;
import visao.TelaPrincipal;

/**
 *
 * @author Auricélio
 */
public class EventosCliente implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       
        if(ae.getActionCommand().equals("limpar")){
            visao.GerenciarCliente.getId().setText(null);
            visao.GerenciarCliente.getCampoNome().setText(null);
            visao.GerenciarCliente.getCampoCpf().setText(null);
            visao.GerenciarCliente.getDataNasc().setText(null);
        }
        
        if(ae.getActionCommand()=="addCliente"){
            //testando e pegandfo o tipo de cliente 
            JRadioButton fisico = visao.GerenciarCliente.getFisico();
            JRadioButton juridico = visao.GerenciarCliente.getJuridico();    
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
            String nome = visao.GerenciarCliente.getCampoNome().getText();
            String cpf = visao.GerenciarCliente.getCampoCpf().getText();
            String dataN = visao.GerenciarCliente.getDataNasc().getText();
                        
            //metodo para testar se campos estão preenchidos        
            boolean verifica = controle.ControleCadastroCliente.verificaCampo(nome, cpf, dataN, tipoCliente);
            
            // se todos os campos estiverem preenchidos, chama metodo para inserir no banco
            if(verifica==true){                
                    //instancia a classe que testa o cpf
                    VerificaCPF vCpf = new VerificaCPF();
                    boolean resultadoCPF = vCpf.consultarCpfCliente(cpf);
                    /*se o resultado for igual a true, ou seja, ainda não tem nenhum user com esse cpf
                    inseri dentro do banco de dados*/
                    if(resultadoCPF==true){    
                        boolean inserir = controle.ControleCadastroCliente.inserirNoBanco(nome, cpf, dataN, tipoCliente);                     
                        if(inserir==true){
                            //atualizar tabela do vendedor
                            visao.GerenciarCliente.getJanela().setVisible(false);
                            new GerenciarCliente();
                        }
                    }
                    
             }
        }
        if(ae.getActionCommand()=="editarCliente"){
            if(visao.GerenciarCliente.isLinhaSelecionada()==true){
                    //testando e pegandfo o tipo de cliente 
                    JRadioButton fisico = visao.GerenciarCliente.getFisico();
                    JRadioButton juridico = visao.GerenciarCliente.getJuridico();    
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
                    String IDstring = visao.GerenciarCliente.getId().getText();
                    String nome = visao.GerenciarCliente.getCampoNome().getText();
                    String cpf = visao.GerenciarCliente.getCampoCpf().getText();
                    String dataN = visao.GerenciarCliente.getDataNasc().getText();

                    //metodo para testar se campos estão preenchidos        
                    boolean verifica = controle.ControleCadastroCliente.verificaCampo(nome, cpf, dataN, tipoCliente);

                    // se todos os campos estiverem preenchidos, chama metodo para inserir no banco
                    if(verifica==true){
                            int IDint = Integer.parseInt(IDstring);
                            //instancia a classe que testa o cpf
                            VerificaCPF vCpf = new VerificaCPF();
                            boolean resultadoCPF = vCpf.consultarCpfCliente(cpf);
                            int x=0;
                            if(resultadoCPF==false){
                                x = 1;
                            }
                            /*se o resultado for igual a true, ou seja, ainda não tem nenhum user com esse cpf
                            inseri dentro do banco de dados*/
                            if(x==1){
                                    boolean atualizar = controle.ControleCadastroCliente.AtualizarBanco(IDint, nome, cpf, dataN, tipoCliente);
                                    if(atualizar==true){
                                        //atualizar tabela do vendedor
                                        visao.GerenciarCliente.getJanela().setVisible(false);
                                        new GerenciarCliente();
                                        //varivel para conferir se alguna linha esta selecionada volta a ser "false"
                                        visao.GerenciarCliente.setLinhaSelecionada(false);
                                    }
                                    //System.out.println(sal+sal);
                            }else{
                                JOptionPane.showMessageDialog(null, "Desculpe, não é permitido editar o CPF, se você trocou de CPF, \nfaça um novo cadastro com o CPF atual.");
                            }

                   }
            }else{
                System.err.println("Nenhum Cliente Selecionado!");
                JOptionPane.showMessageDialog(null, "Nenhum Cliente Selecionado!");
            }
        }
        
        if(ae.getActionCommand()=="excluirCliente"){
            if(visao.GerenciarCliente.isLinhaSelecionada()==true){
                    int pergunta = JOptionPane.showConfirmDialog(null, "Excluir mesmo este Cliente do banco de dados?");
                    if(pergunta==0){
                        Object IDstring = GerenciarCliente.getTabela().getValueAt(GerenciarCliente.getTabela().getSelectedRow(), 0);
                        int id = Integer.parseInt(IDstring.toString());
                        //acessando a classe controle e chamando o metodo de exclusão de dados
                        boolean excluir = controle.ControleCadastroCliente.DeletarDados(id);
                        if(excluir==true){
                            //atualiza a tabela de clientes após exclusão bem sucedida
                            GerenciarCliente.getJanela().setVisible(false);
                            new GerenciarCliente();
                            //varivel para conferir se alguna linha esta selecionada volta a ser "false"
                            visao.GerenciarCliente.setLinhaSelecionada(false);
                        }
                    }
            }else{
                System.err.println("Nenhum Cliente Selecionado!");
                JOptionPane.showMessageDialog(null, "Nenhum Cliente Selecionado!");
            }
        }
        
        if(ae.getActionCommand()=="voltar"){
            visao.GerenciarCliente.getJanela().setVisible(false);
            new TelaPrincipal();
        }
     
            
      }
}
