/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DAO.DbCliente;
import clases.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Jeremy martinez
 */
public class ClienteController {
    
    public boolean Cliente(Cliente cl){
        boolean bl = false;
        DbCliente dc = new DbCliente();
       
        if (dc.guardarCl(cl)) {
            bl = true;
        }
        
        return bl;
    }
    
    public ArrayList<Cliente> consultaClientexTipo(String tipoCliente){
        ArrayList<Cliente> arrCliente = new ArrayList<Cliente>();
        //Cliente cliente;
        
        DbCliente dbcliente = new DbCliente();
        arrCliente = dbcliente.consultaClientexTipo(tipoCliente);
        
        return arrCliente;
    }
    
    
}
