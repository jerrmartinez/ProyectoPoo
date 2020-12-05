/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clases.Cliente;
import clases.Ingredientes;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nutrifit.MenuFront;

/**
 *
 * @author Jeremy martinez
 */
public class DbCliente {
    
    
    public boolean guardarCl(Cliente cl){
        boolean b_retorna = false;
        
        String cabecera[] = {"CEDULA","NOMBRES","APELLIDOS","TELEFONO","MAIL","DIRECCION","PESO","ESTATURA","HORAS EJERCICIO SEMANAL","PROFESION","IMC","TIPO_CLIENTE","FECHA_SUSCRIPCION","FECHA_FIN_SUSCRIPCION","PRECIO"};
        
        String cliente[] = {cl.getLs_cedula(), cl.getLs_nombres(), cl.getLs_apellidos(),
                            cl.getLs_telefonos(), cl.getLs_mail(), cl.getLs_direccion(),
                            Float.toString(cl.getLf_peso()), Float.toString(cl.getLf_estatura()), Float.toString(cl.getLf_horas_ejercicio_semanal()),
                            cl.getProfesion(), Float.toString(cl.getLf_IMC()), cl.getLs_tipo_cliente(),
                            cl.getFecha_suscripcion().toString(),cl.getFecha_fin_suscripcion().toString(),
                            Float.toString(cl.getLf_precio())};
        
        ArrayList<String[]> datos = new ArrayList<String[]>();
        
        datos.add(cabecera);
        datos.add(cliente);
        
        try{
            
            String archCSV = "D:\\Users\\Jeremy\\Documents\\NetBeansProjects\\nutrifit\\clientes.csv";
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

                writer.writeNext(cliente);

                writer.close();

                 b_retorna = true;
            }
        }catch(Exception ex){
                 b_retorna = false;
        }
        
        return b_retorna;
        
    }
    
    
    public ArrayList<Cliente> consultaClientexTipo(String tipoCliente){
        ArrayList<Cliente> arrCliente = new ArrayList<Cliente>();
        Cliente cliente;
        int lnNumLinea = 0;
        LocalDate fechaAc = LocalDate.now();
        
                    String archCSV = "D:\\Users\\Jeremy\\Documents\\NetBeansProjects\\nutrifit\\clientes.csv";
                    File archivo = new File(archCSV);
                     if (archivo.exists()) {

                                    //String archCSV = "D:\\Users\\Jeremy\\Documents\\NetBeansProjects\\nutrifit\\ingredientes.csv";
                                    CSVReader csvReader;
                                    try {
                                        csvReader = new CSVReader(new FileReader(archCSV));
                                        String[] fila = null;
                                        ///lectura del archivo  carga_productos.csv
                                        while((fila = csvReader.readNext()) != null) {
                                            //ingrediente = new Ingredientes();  
                                             cliente = new Cliente();
                                              
                                             if (lnNumLinea > 0){ //para que no obtenga la cabecera
                                                // System.out.println(fechaAc+" "+fila[13]);
                                                 if(fechaAc.isBefore(LocalDate.parse(fila[13])))//si fecha actual esta antes de la fecha fin de suscripcion
                                                   {
                                                     
                                                 
                                                        if (tipoCliente.equals("T")){
                                                             cliente.setLs_cedula(fila[0]);
                                                             cliente.setLs_nombres(fila[1]);
                                                             cliente.setLs_apellidos(fila[2]);
                                                             cliente.setLs_telefonos(fila[3]);
                                                             cliente.setLs_mail(fila[4]);
                                                             cliente.setLs_direccion(fila[5]);
                                                             cliente.setLf_peso(Float.parseFloat(fila[6]));
                                                             cliente.setLf_estatura(Float.parseFloat(fila[7]));
                                                             cliente.setLf_horas_ejercicio_semanal(Float.parseFloat(fila[8]));
                                                             cliente.setProfesion(fila[9]);
                                                             cliente.setLf_IMC(Float.parseFloat(fila[10]));
                                                             cliente.setLs_tipo_cliente(fila[11]);
                                                             cliente.setFecha_suscripcion(LocalDate.parse(fila[12]));
                                                             cliente.setFecha_fin_suscripcion(LocalDate.parse(fila[13]));
                                                             cliente.setLf_precio(Float.parseFloat(fila[14]));


                                                             //System.out.println(fila);

                                                             arrCliente.add(cliente);
                                                        }else{ 

                                                                //if(fila[1].indexOf(nombre_ingrediente) >0){
                                                                if(fila[11].contains(tipoCliente)){
                                                                   // System.out.println(fila[0]+" "+fila[1]);
                                                                     cliente.setLs_cedula(fila[0]);
                                                                     cliente.setLs_nombres(fila[1]);
                                                                     cliente.setLs_apellidos(fila[2]);
                                                                     cliente.setLs_telefonos(fila[3]);
                                                                     cliente.setLs_mail(fila[4]);
                                                                     cliente.setLs_direccion(fila[5]);
                                                                     cliente.setLf_peso(Float.parseFloat(fila[6]));
                                                                     cliente.setLf_estatura(Float.parseFloat(fila[7]));
                                                                     cliente.setLf_horas_ejercicio_semanal(Float.parseFloat(fila[8]));
                                                                     cliente.setProfesion(fila[9]);
                                                                     cliente.setLf_IMC(Float.parseFloat(fila[10]));
                                                                     cliente.setLs_tipo_cliente(fila[11]);
                                                                     cliente.setFecha_suscripcion(LocalDate.parse(fila[12]));
                                                                     cliente.setFecha_fin_suscripcion(LocalDate.parse(fila[13]));
                                                                     cliente.setLf_precio(Float.parseFloat(fila[14]));


                                                                     //System.out.println(fila);

                                                                     arrCliente.add(cliente);
                                                                 }
                                                        }
                                                    }    
                                                }
                                             lnNumLinea = lnNumLinea+1;
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
        
     return arrCliente;   
        
    }
    
}
