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
public class ModeloTabVendedor extends AbstractTableModel{
        
    private ArrayList<Vendedor> listaVendedor;
    private String[] colunas = {"ID","Nome","Cpf","Data de Nasc.","Salario"};

    public ModeloTabVendedor(ArrayList<Vendedor> listaVendedor) {        
        this.listaVendedor = listaVendedor;
    }      
    
    @Override // linhas
    public int getRowCount() {
       return this.listaVendedor.size();
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
            return this.listaVendedor.get(rowIndex).getID();
        }
        if(columnIndex==1){
            return this.listaVendedor.get(rowIndex).getNome();            
        }
        if(columnIndex==2){
            return this.listaVendedor.get(rowIndex).getCpf();            
        }
        if(columnIndex==3){
            return this.listaVendedor.get(rowIndex).getDataN();            
        }        
        if(columnIndex==4){
            return this.listaVendedor.get(rowIndex).getSalario();            
        }
        
        else{
            return null;
        }
                
    }
    
}
