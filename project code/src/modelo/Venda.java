/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import modelo.Cliente;
import modelo.Vendedor;

/**
 *
 * @author Auricélio
 */
public class Venda {
    private int id;   
    private Vendedor vendedor;
    private Cliente cliente; 
    private Cliente tipoCliente;
    private String nomeProduto;
    private double valorProduto;
    private String dataVenda;
        
    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(Cliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
       
    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double ValorProduto) {
        this.valorProduto = ValorProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String NomeProduto) {
        this.nomeProduto = NomeProduto;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
