/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clases.Cliente;
import clases.Ingredientes;
import clases.Recetas;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import nutrifit.MenuFront;

/**
 *
 * @author Jeremy martinez
 */
public class DbRecetas {
    
    
    public boolean guardarRecetas(Recetas rc){
        boolean b_retorna = false;
        
        String cabecera[] = {"ID_RECETA","NOMBRE_RECETA","TIPO_RECETA","ID_INGREDIENTE","GRAMOS","PREPARACION", "TOTCALORIAS", "TOTHIDRATOS", "TOTPROTEINAS", "TOTGRASAS", "TOTFIBRAS"};
        
         String receta[] = {Integer.toString(rc.getLn_Idrecetas()),
                            rc.getNombre_receta(),
                            rc.getLs_tipo_receta().toUpperCase(),
                            //Integer.toString(rc.getIngrediente().getLn_idIngrediente()),
                            Integer.toString(rc.getLn_idIngrediente()),
                            Float.toString(rc.getLf_cant_gramos()),
                            rc.getLs_preparacion(),
                            Float.toString(rc.getLf_calorias()),
                            Float.toString(rc.getLf_hidratos()),
                            Float.toString(rc.getLf_proteinas()),
                            Float.toString(rc.getLf_grasas()),
                            Float.toString(rc.getLf_fibras())
                            
                            };
        
        ArrayList<String[]> datos = new ArrayList<String[]>();
        
        datos.add(cabecera);
        datos.add(receta);
        
        try{
            
            String archCSV = "D:\\Users\\Jeremy\\Documents\\NetBeansProjects\\nutrifit\\recetas.csv";
            File tempFile = new File(archCSV);
            boolean exists = tempFile.exists();

            //si no existe el archivo lo crea
            if (!exists){
                
                CSVWriter writer = new CSVWriter(new FileWriter(archCSV));
                writer.writeAll(datos);
                writer.close();
                 b_retorna = true;
            }
            else{ //si existe inserta
                CSVWriter writer = new CSVWriter(new FileWriter(archCSV,true));

                writer.writeNext(receta);

                writer.close();

                 b_retorna = true;
            }
        }catch(Exception ex){
                 b_retorna = false;
        }
        
        return b_retorna;
        
    }
    
    
    
    public ArrayList<Recetas>  consultaRecetas(){
        ArrayList<Recetas> arrRecetas = new ArrayList<Recetas>();
        Recetas recetas;
        int lnContador = 0;
        //////////////
        String archCSV = "D:\\Users\\Jeremy\\Documents\\NetBeansProjects\\nutrifit\\recetas.csv";
        File archivo = new File(archCSV);
         if (archivo.exists()) {
                            
                        //String archCSV = "D:\\Users\\Jeremy\\Documents\\NetBeansProjects\\nutrifit\\ingredientes.csv";
                        CSVReader csvReader;
                        try {
                            csvReader = new CSVReader(new FileReader(archCSV));
                            String[] fila = null;
                            ///lectura del archivo  carga_productos.csv
                            while((fila = csvReader.readNext()) != null) {
                                
                              if(lnContador > 0){  
                                recetas = new Recetas();  
                                    recetas.setLn_Idrecetas(Integer.parseInt(fila[0]));
                                    recetas.setNombre_receta(fila[1]);
                                    recetas.setLs_tipo_receta(fila[2]);
                                    recetas.setLn_idIngrediente(Integer.parseInt(fila[3]));
                                    recetas.setLf_cant_gramos(Float.parseFloat(fila[4]));
                                    recetas.setLs_preparacion(fila[5]);
                                    recetas.setLf_calorias(Float.parseFloat(fila[6]));
                                    recetas.setLf_hidratos(Float.parseFloat(fila[7]));
                                    recetas.setLf_proteinas(Float.parseFloat(fila[8]));
                                    recetas.setLf_grasas(Float.parseFloat(fila[9]));
                                    recetas.setLf_fibras(Float.parseFloat(fila[10]));
                                    
                                    
                                     //System.out.println(fila);
                                     
                                     arrRecetas.add(recetas);
                                 }
                              
                                 lnContador = lnContador+1;
                                
                            }
                            
                        csvReader.close();
                        } catch (FileNotFoundException ex) {
                            Logger.getLogger(MenuFront.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                Logger.getLogger(MenuFront.class.getName()).log(Level.SEVERE, null, ex);
            } catch (CsvValidationException ex) {
                Logger.getLogger(MenuFront.class.getName()).log(Level.SEVERE, null, ex);
            }
                            
        }
    else{
       System.out.println("¡¡No existen recetas configuradas..!!"); 
    }
        /////////////
        
        
        
        return arrRecetas;
    }
    
    
}
