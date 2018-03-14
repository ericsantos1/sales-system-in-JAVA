/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.eventos;

import controle.VerificaCPF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import visao.CadastroVendedor;
import visao.EditarVendedor;
import visao.GerenciarVendedor;
import visao.TelaPrincipal;

/**
 *
 * @author Auricélio
 */
public class EventosVendedor implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getActionCommand().equals("limpar")){
            visao.GerenciarVendedor.getId().setText(null);
            visao.GerenciarVendedor.getCampoNome().setText(null);
            visao.GerenciarVendedor.getCampoCpf().setText(null);
            visao.GerenciarVendedor.getDataNasc().setText(null);
            visao.GerenciarVendedor.getSalario().setText(null);
        }
        
        if(ae.getActionCommand().equals("addVendedor")){ 
            String nome = visao.GerenciarVendedor.getCampoNome().getText();
            String cpf = visao.GerenciarVendedor.getCampoCpf().getText();
            String dataN = visao.GerenciarVendedor.getDataNasc().getText();
            String salario = visao.GerenciarVendedor.getSalario().getText();
            //metodo para testar se campos estão preenchidos        
            boolean verifica = controle.ControleCadastroVendedor.verificaCampo(nome, cpf, dataN, salario);
            
            // se todos os campos estiverem preenchidos, chama metodo para inserir no banco
            if(verifica==true){
                //converte salario de string para nº decimal
                double sal = Double.parseDouble(salario);
                //verifica se valor do salario é muito baixo
                if(sal>500){
                    //instancia a classe que testa o cpf
                    VerificaCPF vCpf = new VerificaCPF();
                    boolean resultadoCPF = vCpf.consultarCpfVendedor(cpf);
                    /*se o resultado for igual a true, ou seja, ainda não tem nenhum user com esse cpf,
                    insere no banco de dados*/
                    if(resultadoCPF==true){    
                        boolean inserir = controle.ControleCadastroVendedor.inserirNoBanco(nome, cpf, dataN, sal);                     
                        if(inserir==true){
                            //atualizar tabela do vendedor
                            visao.GerenciarVendedor.getJanela().setVisible(false);
                            new GerenciarVendedor();
                        }
                    }else{
                        System.err.println("CPF já está em uso!");
                        JOptionPane.showMessageDialog(null, "CPF já está em uso!");
                    }
                    //System.out.println(sal+sal);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Salário muito baixo!");
                }
            }
        }
        
        if(ae.getActionCommand().equals("editarVendedor")){
            
            if(visao.GerenciarVendedor.isLinhaSelecionada()==true){
                //JOptionPane.showMessageDialog(null, "Editado com Sucesso!");
                String IDstring = visao.GerenciarVendedor.getId().getText();
                String nome = visao.GerenciarVendedor.getCampoNome().getText();
                String cpf = visao.GerenciarVendedor.getCampoCpf().getText();
                String dataN = visao.GerenciarVendedor.getDataNasc().getText();
                String salario = visao.GerenciarVendedor.getSalario().getText();
                //metodo para testar se campos estão preenchidos        
                boolean verifica = controle.ControleCadastroVendedor.verificaCampo(nome, cpf, dataN, salario);

                // se todos os campos estiverem preenchidos, chama metodo para inserir no banco
                if(verifica==true){
                    double sal = Double.parseDouble(salario);
                    int IDint = Integer.parseInt(IDstring);
                    //gambiarra para testar salario
                    if(sal>500){
                            //instancia a classe que testa o cpf
                            VerificaCPF vCpf = new VerificaCPF();
                            boolean resultadoCPF = vCpf.consultarCpfVendedor(cpf);
                            int x=0;
                            if(resultadoCPF==false){
                                x = 1;
                            }
                            /*se o resultado for igual a true, ou seja, ainda não tem nenhum user com esse cpf
                            inseri dentro do banco de dados*/
                            if(x==1){
                                    boolean atualizar = controle.ControleCadastroVendedor.AtualizarBanco(IDint, nome, cpf, dataN, sal);
                                    if(atualizar==true){
                                        //atualizar tabela do vendedor
                                        visao.GerenciarVendedor.getJanela().setVisible(false);
                                        new GerenciarVendedor();
                                        //varivel para conferir se alguna linha esta selecionada volta a ser "false"
                                        visao.GerenciarVendedor.setLinhaSelecionada(false);
                                    }
                                    //System.out.println(sal+sal);
                            }else{
                                JOptionPane.showMessageDialog(null, "Desculpe, não é permitido editar o CPF, se você trocou de CPF, \nfaça um novo cadastro com o CPF atual.");
                            }
                    }else{
                         JOptionPane.showMessageDialog(null, "Salário muito baixo!");
                    }   
                }
            }
        
            else{
                JOptionPane.showMessageDialog(null, "Nemhum Vendedor selecionado!");
                System.err.println("Nemhum Vendedor selecionado!");
            }
        }
        
        if(ae.getActionCommand().equals("excluirVendedor")){
            if(visao.GerenciarVendedor.isLinhaSelecionada()==true){
                int pergunta = JOptionPane.showConfirmDialog(null, "Excluir mesmo este Vendedor do banco de dados?");
                if(pergunta==0){
                    Object IDstring = GerenciarVendedor.getTabela().getValueAt(GerenciarVendedor.getTabela().getSelectedRow(), 0);
                    int id = Integer.parseInt(IDstring.toString());
                    //acessando a classe controle e chamando o metodo de exclusão de dados
                    boolean excluir = controle.ControleCadastroVendedor.DeletarDados(id);
                    if(excluir==true){
                        //atualiza a tabela de vendedores após exclusão bem sucedida
                        GerenciarVendedor.getJanela().setVisible(false);
                        new GerenciarVendedor();
                        //varivel para conferir se alguna linha esta selecionada volta a ser "false"
                        visao.GerenciarVendedor.setLinhaSelecionada(false);
                        

                    }
                }
           }
            else{
                System.err.println("Nenhum Vendedor selecionado!");
                JOptionPane.showMessageDialog(null, "Nenhum Vendedor selecionado!");            
            }
        }
        
        if(ae.getActionCommand().equals("voltar")){
            new TelaPrincipal();
            visao.GerenciarVendedor.getJanela().setVisible(false);
        }
              
    }
  
}
