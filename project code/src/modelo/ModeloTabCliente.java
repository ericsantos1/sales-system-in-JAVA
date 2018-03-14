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
public class ModeloTabCliente extends AbstractTableModel{
        
    private ArrayList<Cliente> listaCliente;
    private String[] colunas = {"ID","Nome","Cpf","Data de Nascimento","Tipo do Cliente"};

    public ModeloTabCliente(ArrayList<Cliente> listaCliente) {        
        this.listaCliente = listaCliente;
    }       
    
    @Override // linhas
    public int getRowCount() {
       return this.listaCliente.size();
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
            return this.listaCliente.get(rowIndex).getID();
        }
        if(columnIndex==1){
            return this.listaCliente.get(rowIndex).getNome();
        }
        if(columnIndex==2){
            return this.listaCliente.get(rowIndex).getCpf();
        }
        if(columnIndex==3){
            return this.listaCliente.get(rowIndex).getDataN();
        }
        if(columnIndex==4){
            return this.listaCliente.get(rowIndex).getTipo();
        }        
        else{
            return null;
        }
                
    }
    
}