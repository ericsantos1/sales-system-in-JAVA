/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import modelo.Pessoa;

/**
 *
 * @author Auricélio
 */
public class Usuario extends Pessoa{
    //METODOS ADICIOPNASIS PARA USUARIO   
    private String senha;
    
    //Usuariuo deve ter pelo menos NOME, LOGIN E SENHA.
    public Usuario(String nome, String cpf, String senha) {        
        super.setNome(nome);
        this.setCpf(cpf);
        this.setSenha(senha);      
    }
    //METODOS GETERES E SETERES ADICIONAIS PARA USUARIO
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
}
