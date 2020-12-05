/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DAO.DbCliente;
import DAO.DbIngrediente;
import clases.Cliente;
import clases.Ingredientes;
import java.util.ArrayList;


/**
 *
 * @author Jeremy martinez
 */
public class IngredientesController {
     
    public boolean grabaIngrediente(String[] ingrediente){
        boolean bl = false;
        DbIngrediente di = new DbIngrediente();
       
        if (di.guardarIngrediente(ingrediente)) {
            bl = true;
        }
        
        return bl;
    }
    
    
    public ArrayList<Ingredientes> consultaIngredientes(String nombreIngrediente){
         
        //boolean retorna = false;
        DbIngrediente dbingrediente = new DbIngrediente();
        ArrayList<Ingredientes> ingredientes = new ArrayList<Ingredientes>();
        
        ingredientes = dbingrediente.consultaIngrediente(nombreIngrediente.toUpperCase());
        
        if (ingredientes.size()> 0){
                    System.out.println("El ingrediente A BUSCAR es:");

                    //System.out.println("tamaño arreglo:" + ingredientes.size());

                    //System.out.println("Id_Ingrediente  Alimento                    Calorias    Hidratos    Proteinas   Grasas  Fibras");
                    System.out.println("Id_Ingrediente  Alimento");

                    for (int i=0; i<ingredientes.size(); i++){
                        System.out.print("           "+ingredientes.get(i).getLn_idIngrediente()+"    ");
                        System.out.println(ingredientes.get(i).getLs_Alimento());
            //            System.out.print(ingredientes.get(i).getLf_calorias()+"     ");
            //            System.out.print(ingredientes.get(i).getLf_hidratos()+" ");
            //            System.out.print(ingredientes.get(i).getLf_proteinas()+"    ");
            //            System.out.print(ingredientes.get(i).getLf_grasas()+"   ");
            //            System.out.println(ingredientes.get(i).getLf_fibras());

                    }
        }else{
            System.out.println("***INGREDIENTE NO ENCONTRADO***");
        }             
        
////        if (ingredientes.size() > 0) {
////            retorna = true;
////        }
////        
////        return retorna;

  return ingredientes;
        
    }
    
    
    
}
