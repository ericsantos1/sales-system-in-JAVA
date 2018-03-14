/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;


/**
 *
 * @author Auricélio
 */
public class Cliente extends Pessoa{
    
    private String tipo;
    
    // Sem nescessidade de atributos pois todos já são herdados 
    // da class principal.
    
    //Cliente deve ter pelo menos NOME, DATA N. E CPF.
    public Cliente(String nome, String dataN, String Cpf, String tipo) {
                super.setNome(nome);
                super.setDataN(dataN);
                super.setCpf(Cpf);
                this.setTipo(tipo);
               
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

      
    
}
