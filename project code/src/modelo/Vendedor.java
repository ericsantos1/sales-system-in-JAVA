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
public class Vendedor extends Pessoa{

    private double salario;
    
//Vendedor deve ter pelo menos NOME, CPF E SALARIO.
    public Vendedor(String nome, String cpf, double salario) {              
        super.setNome(nome);
        super.setCpf(cpf);
        this.setSalario(salario);      
    }

    
//METODOS GETTERES E SETTERES ADICIONAIS PARA VENDEDOR
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }  
   
    
}
