/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clases.Menu;
import clases.Recetas;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import nutrifit.MenuFront;

/**
 *
 * @author Jeremy martinez
 */
public class DbMenu {
    
    
    public boolean grabarMenu(Menu menu){
        boolean b_retorna;
        
        String cabecera[] = {"ID_MENU","ID_RECETA","NOM_RECETA","TIPO_MENU","CALORIAS","HIDRATOS","PROTEINAS","GRASAS","FIBRAS", "FECHA_INI", "FECHA_FIN"};
        
        String menus[] = {Integer.toString(menu.getLn_Idmenu()), 
                            Integer.toString(menu.getLn_Idrecetas()),
                            menu.getLsNombreReceta(),
                            menu.getLsTipoMenu(),
                            Float.toString(menu.getLf_calorias()),
                            Float.toString(menu.getLf_hidratos()),
                            Float.toString(menu.getLf_proteinas()),
                            Float.toString(menu.getLf_grasas()),
                            Float.toString(menu.getLf_fibras()),
                            menu.getLfFechaIni().toString(),
                            menu.getLfFechaFin().toString()
                            };
        
        ArrayList<String[]> datos = new ArrayList<String[]>();
        
        datos.add(cabecera);
        datos.add(menus);
        
        try{
            
            String archCSV = "D:\\Users\\Jeremy\\Documents\\NetBeansProjects\\nutrifit\\menu.csv";
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

                writer.writeNext(menus);

                writer.close();

                 b_retorna = true;
            }
        }catch(Exception ex){
                 b_retorna = false;
        }
        
        
        
        
        return b_retorna;
    }
    
    
    public ArrayList<Menu> consultaMenu(){
        ArrayList<Menu> arrmenu = new ArrayList<Menu>();
        
        Menu menu;
        int lnContador = 0;
        //////////////
        String archCSV = "D:\\Users\\Jeremy\\Documents\\NetBeansProjects\\nutrifit\\menu.csv";
        File archivo = new File(archCSV);
         if (archivo.exists()) {
                            
                        
                        CSVReader csvReader;
                        try {
                            csvReader = new CSVReader(new FileReader(archCSV));
                            String[] fila = null;
                            ///lectura del archivo  carga_productos.csv
                            while((fila = csvReader.readNext()) != null) {
                                
                              if(lnContador > 0){  
                                menu = new Menu();  
                                    menu.setLn_Idmenu(Integer.parseInt(fila[0]));
                                    menu.setLn_Idrecetas(Integer.parseInt(fila[1]));
                                    menu.setLsNombreReceta(fila[2]);
                                    menu.setLsTipoMenu(fila[3]);
                                    menu.setLf_calorias(Float.parseFloat(fila[4]));
                                    menu.setLf_hidratos(Float.parseFloat(fila[5]));
                                    menu.setLf_proteinas(Float.parseFloat(fila[6]));
                                    menu.setLf_grasas(Float.parseFloat(fila[7]));
                                    menu.setLf_fibras(Float.parseFloat(fila[8]));
                                    menu.setLfFechaIni(LocalDate.parse(fila[9]));
                                    menu.setLfFechaFin(LocalDate.parse(fila[10]));
                                  
                                    arrmenu.add(menu);
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
        
        
        
        return arrmenu;
    }
    
    
}
