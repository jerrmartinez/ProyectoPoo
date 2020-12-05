/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DAO.DbRecetas;
import clases.Recetas;
import java.util.ArrayList;

/**
 *
 * @author Jeremy martinez
 */
public class RecetasController {
    
    
    public boolean guardarReceta(Recetas recetas){
        boolean retorna = false;
        
        DbRecetas dbr = new DbRecetas();
        retorna = dbr.guardarRecetas(recetas);
        
        
        return retorna;
    }
    
    
    
    public ArrayList<Recetas> consultarRecetas(){
        
        ArrayList<Recetas> arrRecetas = new ArrayList<Recetas>();
        DbRecetas  dbrecetas = new DbRecetas();
        arrRecetas = dbrecetas.consultaRecetas();
        return arrRecetas;
    }
    
    
}
