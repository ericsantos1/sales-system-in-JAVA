/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.eventos.EventosCliente;



/**
 *
 * @author aluno
 */
public class CadastroCliente extends JFrame{
    
    private Container container;
    private static JFrame janela;
    private JLabel rotulo;
    private static JTextField campoNome,campoCpf,dataNasc;
    private ButtonGroup btnG;
    private static JRadioButton fisico,juridico;
    private static JButton limpar, cadastrar;
    
   
//INICIO DO CONSTRUTOR==========================================================
    public CadastroCliente() {
              
        //amazenar os elementos da janela
        this.container = super.getContentPane();        
        //definindo o tipo de layout
        this.container.setLayout(null);
        this.container.setBackground(Color.decode("#F6F6F6")); 
       
        //metodo para construir a tela
        //            Nome da janela    lar  alt
        this.addJanela("Cadastrar Cliente", 302, 350); 
        //add rotulos                       x   y   l  a
        this.addRotulo(this.rotulo,"Nome:", 140, 20, 100, 14);
        this.addRotulo(this.rotulo,"CPF:",140, 80, 100, 14);
        this.addRotulo(this.rotulo,"Data Nasc.:", 110, 140, 100, 14);
        this.addRotulo(this.rotulo,"Tipo do Cliente:", 110, 200, 100, 14);
                     
        //add campos e recebendo seus retornos
        campoNome = addCampo(campoNome, "inputNome", 60, 40, 180, 30);        
        campoCpf = addCampo(campoCpf, "inputCpf", 60, 100, 180, 30);
        dataNasc = addCampo(dataNasc, "inputDatNas", 60, 160, 180, 30);
        this.btnG = new ButtonGroup();     
        fisico = addJRadioButton(fisico, "Físico", 80, 223, 70, 14);
        juridico = addJRadioButton(juridico, "Jurídico", 150, 223, 80, 14);
        //add butão
        limpar = this.addBotao(limpar, "btnLimpar", "Limpar", 50, 270, 90, 30);
        cadastrar = this.addBotao(cadastrar, "btnCadastrar", "Cadastrar", 140, 270, 110, 30);        
        //EVENTOS
        //add evento no botão voltar
        limpar.setActionCommand("limpar");
        limpar.addActionListener(new EventosCliente());
        //add evento no botão cadastrar
        cadastrar.setActionCommand("cadastrar");
        cadastrar.addActionListener(new EventosCliente());
        
        
    }// FIM DO CONTRUTOR========================================================
  
    
    //Metodo para construir janela de login
    public void addJanela(String NomeDaTela, int lar, int alt){
        CadastroCliente.janela = this;
        super.setTitle(NomeDaTela);//Titulo da janela
        super.setSize(lar, alt);//dimenção
        //super.setLocation(200, 50); //posição
        super.setLocationRelativeTo(null);//para centralizar
        super.setResizable(false);// true ou false para redimencionar ou não.
        super.setVisible(true);       
    }
    
    
    //Metodos set e get Staticos para criar janela
    public static JFrame getJanela() {
        return janela;
    }

    public static void setJanela(JFrame janela) {
        CadastroCliente.janela = janela;
    }  
    
    //Metodo para criar rotulo
    public void addRotulo(JLabel lbl,String rotulo,int codX, int codY, int lar, int alt){        
        lbl = new JLabel(rotulo);
        lbl.setBounds(codX, codY, lar, alt);
        this.container.add(lbl);    
    }
    
    //SOBRECARGA DE METODO PARA CRIAR CAMPOS
    //Metodo para criar campo de texto 
    public JTextField addCampo(JTextField txt,String nome,int codX, int codY, int lar, int alt){
        txt = new JTextField();
        txt.setName(nome);
        txt.setBounds(codX, codY, lar, alt);
        this.container.add(txt);
        return txt;        
    }
    //Metodo para criar campo de texto 
    private JPasswordField addCampo(JPasswordField pass, String nome, int codX, int codY, int lar, int alt){        
        pass = new JPasswordField();
        pass.setName(nome);
        pass.setBounds(codX, codY, lar, alt);
        this.container.add(pass);
        return pass;        
    }
    //Metodo para criar JRadioButton
    public JRadioButton addJRadioButton(JRadioButton btnRadio,String nome,int codX, int codY, int lar, int alt){
        btnRadio = new JRadioButton(nome);       
        btnRadio.setBounds(codX, codY, lar, alt);
        this.btnG.add(btnRadio);
        btnRadio.setVisible(true);
        this.container.add(btnRadio);
        return btnRadio;        
    } 
    
    //Metodo para criar botão 
    public JButton addBotao(JButton btn, String nome, String texto, int codX, int codY, int lar, int alt){
        
        btn = new JButton(texto);
        btn.setName(nome);
        btn.setBounds(codX, codY, lar, alt);
        btn.setBackground(Color.WHITE);
        this.container.add(btn);
        return btn;
        
    }

    //Metodos set e get Staticos para criar campos
    public static JTextField getCampoNome() {
        return campoNome;
    }

    public static void setCampoNome(JTextField campoNome) {
        CadastroCliente.campoNome = campoNome;
    }
    
    //==========================================================================
    public static JRadioButton getFisico() {
        return fisico;
    }
    public static void setFisico(JRadioButton fisico) {
        CadastroCliente.fisico = fisico;
    }
    
    //==========================================================================
    public static JRadioButton getJuridico() {
        return juridico;
    }
    public static void setJuridico(JRadioButton juridico) {
        CadastroCliente.juridico = juridico;
    }      
    //==========================================================================
    
    public static JTextField getCampoCpf() {
        return campoCpf;
    }

    public static void setCampoCpf(JTextField campoCpf) {
        CadastroCliente.campoCpf = campoCpf;
    }

    public static JTextField getDataNasc() {
        return dataNasc;
    }

    public static void setDataNasc(JTextField dataNasc) {
        CadastroCliente.dataNasc = dataNasc;
    }
        
    
}