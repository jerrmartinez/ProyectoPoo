/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clases.Ingredientes;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import controladores.IngredientesController;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import nutrifit.MenuFront;


/**
 *
 * @author Jeremy martinez
 */
public class DbIngrediente {
    
    
    //public boolean guardarIngrediente(ArrayList<String[]> ingrediente){
    public boolean guardarIngrediente(String[] ingrediente){
     boolean b_retorna = false;
          
        ArrayList<String[]> datos = new ArrayList<String[]>();
       
       
        //datos.add(cabecera);
        datos.add(ingrediente);
        
        try{
            
            String archCSV = "D:\\Users\\Jeremy\\Documents\\NetBeansProjects\\nutrifit\\ingredientes.csv";
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
                
                writer.writeNext(ingrediente);

                writer.close();

                 b_retorna = true;
            }
        }catch(Exception ex){
                 b_retorna = false;
        }
        
        return b_retorna;

    }
    
    
    public Ingredientes consultaIngrediente(int id_ingrediente){
        Ingredientes ingrediente = new Ingredientes();
        
        //////////////
        String archCSV = "D:\\Users\\Jeremy\\Documents\\NetBeansProjects\\nutrifit\\ingredientes.csv";
        File archivo = new File(archCSV);
         if (archivo.exists()) {
                            
                        //String archCSV = "D:\\Users\\Jeremy\\Documents\\NetBeansProjects\\nutrifit\\ingredientes.csv";
                        CSVReader csvReader;
                        try {
                            csvReader = new CSVReader(new FileReader(archCSV));
                            String[] fila = null;
                            ///lectura del archivo  carga_productos.csv
                            while((fila = csvReader.readNext()) != null) {
                                 if (fila[0] == Integer.toString(id_ingrediente)){
                                     ingrediente.setLn_idIngrediente(id_ingrediente);
                                     ingrediente.setLs_Alimento(fila[1]);
                                     ingrediente.setLf_calorias(Float.parseFloat(fila[2]));
                                     ingrediente.setLf_hidratos(Float.parseFloat(fila[3]));
                                     ingrediente.setLf_proteinas(Float.parseFloat(fila[4]));
                                     ingrediente.setLf_grasas(Float.parseFloat(fila[5]));
                                     ingrediente.setLf_fibras(Float.parseFloat(fila[6]));
                                     
                                 }
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
       System.out.println("¡¡No existen ingredientes cargados..!!"); 
    }
        /////////////
        
        
        
        
        return ingrediente;
    }
    
    public ArrayList<Ingredientes> consultaIngrediente(String nombre_ingrediente){
        ArrayList<Ingredientes> ingredientes = new ArrayList<Ingredientes>();
        Ingredientes ingrediente = new Ingredientes();
        //////////////
        String archCSV = "D:\\Users\\Jeremy\\Documents\\NetBeansProjects\\nutrifit\\ingredientes.csv";
        File archivo = new File(archCSV);
         if (archivo.exists()) {
                            
                        //String archCSV = "D:\\Users\\Jeremy\\Documents\\NetBeansProjects\\nutrifit\\ingredientes.csv";
                        CSVReader csvReader;
                        try {
                            csvReader = new CSVReader(new FileReader(archCSV));
                            String[] fila = null;
                            ///lectura del archivo  carga_productos.csv
                            while((fila = csvReader.readNext()) != null) {
                                ingrediente = new Ingredientes();  
                                
                                //if(fila[1].indexOf(nombre_ingrediente) >0){
                                if(fila[1].contains(nombre_ingrediente)){
                                   // System.out.println(fila[0]+" "+fila[1]);
                                    
                                     ingrediente.setLn_idIngrediente(Integer.parseInt(fila[0]));
                                     ingrediente.setLs_Alimento(fila[1]);
                                     ingrediente.setLf_calorias(Float.parseFloat(fila[2]));
                                     ingrediente.setLf_hidratos(Float.parseFloat(fila[3]));
                                     ingrediente.setLf_proteinas(Float.parseFloat(fila[4]));
                                     ingrediente.setLf_grasas(Float.parseFloat(fila[5]));
                                     ingrediente.setLf_fibras(Float.parseFloat(fila[6]));
                                     
                                     //System.out.println(fila);
                                     
                                     ingredientes.add(ingrediente);
                                 }
                                
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
       System.out.println("¡¡No existen ingredientes cargados..!!"); 
    }
        /////////////
        
        
        
        
        return ingredientes;
    }
}
