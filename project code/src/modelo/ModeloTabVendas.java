/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author aluno
 */
public class ModeloTabVendas extends AbstractTableModel{
        
    private ArrayList<Venda> listaVendas;
    private String[] colunas = {"ID","Data da venda","Vendedor","Cliente","Tipo do Cliente","Produto","Valor"};

    public ModeloTabVendas(ArrayList<Venda> listaVendas) {        
        this.listaVendas = listaVendas;
    }

       
    
    @Override // linhas
    public int getRowCount() {
       return this.listaVendas.size();
    }

    @Override // colunas
    public int getColumnCount() {
        return this.colunas.length;
        
    }

    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }    
    
    @Override // valores
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex==0){
            return this.listaVendas.get(rowIndex).getId();
        }
        if(columnIndex==1){
            return this.listaVendas.get(rowIndex).getDataVenda();
        }
        if(columnIndex==2){
            return this.listaVendas.get(rowIndex).getVendedor().getNome();
        }
        if(columnIndex==3){
            return this.listaVendas.get(rowIndex).getCliente().getNome();
        }
        if(columnIndex==4){
            return this.listaVendas.get(rowIndex).getCliente().getTipo();
        }
        if(columnIndex==5){
            return this.listaVendas.get(rowIndex).getNomeProduto();
        }
        if(columnIndex==6){
            return this.listaVendas.get(rowIndex).getValorProduto();
        }
        else{
            return null;
        }
                
    }
    
}
