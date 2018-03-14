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
public class Pessoa {
//ATRIBUTOS PARA UMA PESSOA
    private int ID;  
    private String nome;
    private String dataN;
    private String Cpf;
        
//METODOS GETERES E SETERES PARA UMA PESSOA
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataN() {
        return dataN;
    }

    public void setDataN(String dataN) {
        this.dataN = dataN;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }  
    
    
    
}
