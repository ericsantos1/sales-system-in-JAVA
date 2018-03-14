/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.tratamentos.Tratamentos;
import javax.swing.*;

/**
 *
 * @author aluno
 */
public abstract class ControleLogin {
    
    public static boolean verificaCampo(String campo1,String campo2){
        
        try{            
            ControleLogin.verificaCampo(campo1);
            ControleLogin.verificaCampo(campo2);
            return true;     
        }catch(Tratamentos campoVazio){
            JOptionPane.showMessageDialog(null, campoVazio.getMessage());
            return false;   
        }              
        
    
    }
    //Metodo para testar login
    private static void verificaCampo(String txt) throws Tratamentos{
        if(txt.isEmpty()){
            throw new Tratamentos("campo vazio");
        }
    }

    
}//FIM DA CLASSE
