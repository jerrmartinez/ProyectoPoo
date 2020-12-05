/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutrifit;

import clases.Cliente;
import clases.Ingredientes;
import clases.Menu;
import clases.Recetas;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import controladores.ClienteController;
import controladores.IngredientesController;
import controladores.MenuController;
import controladores.RecetasController;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlets.EnviaMail;
import servlets.Utils;


/**
 *
 * @author Jeremy martinez
 */
public class MenuFront extends Utils{

    public MenuFront() throws InterruptedException {
        
        String ls_opcion = "";
        
       do{        
            menu();


            Scanner in = new Scanner(System.in);

            ls_opcion = in.nextLine();            
        
            
        if (!ls_opcion.equals(null) && !ls_opcion.equals("") && ls_opcion.length()>0 && ls_opcion.length()<=1 && !ls_opcion.isEmpty() && (ls_opcion.matches("[0-9]*"))){
            if(Integer.parseInt(ls_opcion)>6){
                System.out.println("Seleccione una opcion enre 1 y 6");
                System.out.println("-------------------------------------------------------");
                Thread.sleep(3000);
            }
        }else{
            ls_opcion = "7";
            System.out.println("Seleccione una opcion enre 1 y 6");
            System.out.println("-------------------------------------------------------");
                Thread.sleep(3000);
        }    
           
        
            
       
        
                    switch(ls_opcion)
                    {
                        case "1":
                           RegistroCliente();
                            break;
                           //return;
                        case "2":
                           SubidaProductos();
                            break;
                        case "3":
                           RegistroRecetas();
                            break;
                        case "4":
                           CreaMenuSem();
                            break;
                        case "5":
                            ConsultaSubscripciones();
                            break;
                        case "6":
                            envioMenuSemanal();
                            break;
                            

                    }
        
        }
      while(Integer.parseInt(ls_opcion)>6); 
        //System.out.println("ud selecciono:"+ls_opcion);
    }
    
    public void menu(){
        System.out.println("SISTEMA  NUTRIFIT");
        System.out.println("-----------------\n");
        System.out.println("OPCIONES:");
        System.out.println("1-Registro de Clientes");
        System.out.println("2-Subida de Productos");
        System.out.println("3-Registro de Recetas");
        System.out.println("4-Creacion de Menú Semanal");
        System.out.println("5-Consulta de Subscripciones Activas");
        System.out.println("6-Envio de menu semanal a clientes");
        
        System.out.println(" ");
        System.out.println("Ingrese una opcion: ");
    }
    

   public void envioMenuSemanal(){
       System.out.println("Envio de menu semanal a los clientes");
       
       EnviaMail m = new EnviaMail();
       ArrayList<Menu> arrmenu = new ArrayList<Menu>();
       
       MenuController mc = new MenuController();
       arrmenu = mc.consultaMenu();
       
       LocalDate fechaActual = LocalDate.now();
       LocalDate fechaFin    =fechaActual.plusDays(5);
       
       String texto = "";
       
       if (arrmenu.size()> 0){
          for (int w = 0; w < arrmenu.size(); w++){
              
            //if( !(fechaActual.isBefore(arrmenu.get(w).getLfFechaIni())  && fechaActual.isBefore(arrmenu.get(w).getLfFechaFin())) )  
           if(arrmenu.get(w).getLfFechaIni().isBefore(fechaFin))
            {  
              texto += arrmenu.get(w).getLsNombreReceta() + " - " + arrmenu.get(w).getLsTipoMenu() + " - " + arrmenu.get(w).getLfFechaIni() + "\n" + 
                      "Calorias: " + arrmenu.get(w).getLf_calorias() + "\n"+
                      "Hidratos: " + arrmenu.get(w).getLf_hidratos() + "\n"+
                      "Proteinas: " + arrmenu.get(w).getLf_proteinas() + "\n"+
                      "Grasas: " + arrmenu.get(w).getLf_grasas()+ "\n"+
                      "Fibras: " + arrmenu.get(w).getLf_fibras();
              texto += "\n";
              texto += "=============================================================================";
              texto += "\n";
            }
          }    
           
       }
       
      
       ClienteController cc = new ClienteController();
       ArrayList<Cliente> arrCliente = new ArrayList<Cliente>();
       arrCliente = cc.consultaClientexTipo("T");       
       
       
       if (arrCliente.size()> 0){
           
           for (int v=0; v < arrCliente.size(); v++){
              if (arrCliente.get(v).getLs_mail().length()>0){ 
                 m.enviaMailMenu(arrCliente.get(v).getLs_mail().trim(), texto);
                 //System.out.println(arrCliente.get(v).getLs_mail());
              }
               try {
                   Thread.sleep(5000);
               } catch (InterruptedException ex) {
                   Logger.getLogger(MenuFront.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           
       }
       
  
       
   }
    
    public void RegistroCliente(){
        //System.out.println("RegistroCliente");
        
        Scanner in = new Scanner(System.in);
        float IMC = 0;
        String ls_peso;
        String ls_estatura;
        String ls_horasEjerSem;
        //String s = in.nextLine();
        //System.out.println("Usted ingresó la cadena: "+s);
        
        Cliente cli = new Cliente();
        System.out.println("=============================================");
        System.out.println("               INGRESO DE CLIENTES            ");
        System.out.println("=============================================");
        System.out.println(" ");
        
        ///nombres
        do{
        System.out.print("Ingrese su nombre:");
        cli.setLs_nombres(in.nextLine());
           if (cli.getLs_nombres().matches("[0-9]*")){
               System.out.println("***Ingrese solo caracteres***");
           }
        }
        while(cli.getLs_nombres().matches("[0-9]*"));
        
        ///apellidos
        do{
         System.out.print("Ingrese su apellidos:");
          cli.setLs_apellidos(in.nextLine());
          if (cli.getLs_apellidos().matches("[0-9]*")){
              System.out.println("***Ingrese solo caracteres***");
          }
        }while(cli.getLs_apellidos().matches("[0-9]*"));
        
        //cedulas
        do{
        System.out.print("Ingrese su cedula:");
        cli.setLs_cedula(in.nextLine());
        }while(!validadorDeCedula(cli.getLs_cedula()));
        
        //telefonos
        do{
        System.out.print("Ingrese su telefono:");
        cli.setLs_telefonos(in.nextLine());
          if (!cli.getLs_telefonos().matches("[0-9]*")){
             System.out.println("***Ingrese solo numeros***") ;
          }
        }while(!cli.getLs_telefonos().matches("[0-9]*"));
        
        
        //mail
        do{
        System.out.print("Ingrese su mail:");
        cli.setLs_mail(in.nextLine());
          if(!ValidarMail(cli.getLs_mail())){
              System.out.println("***Formato de mail incorrecto***");
          }
        }while(!ValidarMail(cli.getLs_mail()));
        
        //DIRECCION
        System.out.print("Ingrese su direccion:");
        cli.setLs_direccion(in.nextLine());
        
        //TIPO CLIENTE
        do{
        System.out.print("Ingrese su tipo de cliente [V (VIP),F (FRESH)]:");
        cli.setLs_tipo_cliente(in.nextLine().toUpperCase());
         if (!cli.getLs_tipo_cliente().equals("V") && !cli.getLs_tipo_cliente().equals("F")){
             System.out.println("***Escoja V (VIP) o F (FRESH)***");
         }
        }while(!cli.getLs_tipo_cliente().equals("V") && !cli.getLs_tipo_cliente().equals("F"));
        
        //SI ES TIPO VIP
        if(cli.getLs_tipo_cliente().toUpperCase().equals("V")){
             
            //PESO
            do{
             System.out.print("Ingrese su Peso (Kg.):");
             ls_peso = in.nextLine();
             if (!ls_peso.matches("[0-9]*") && !esDecimal(ls_peso)){
                 System.out.println("***Ingrese solo numeros enteros o decimanes***");
             }else{
                 cli.setLf_peso(Float.parseFloat(ls_peso));
             }
            }while(!ls_peso.matches("[0-9]*") && !esDecimal(ls_peso));
            
             //ESTATURA
            do{ 
             System.out.print("Ingrese su Estatura (cm.):");
             ls_estatura = in.nextLine();
             if (!ls_estatura.matches("[0-9]*") && !esDecimal(ls_estatura)){
                 System.out.println("***Ingrese solo numeros enteros o decimanes***");
             }else{
                 cli.setLf_estatura(Float.parseFloat(ls_estatura));
             }
            }while(!ls_estatura.matches("[0-9]*") && !esDecimal(ls_estatura)); 
             
            //HORAS
             do{
                System.out.print("Ingrese su Horas de Ejercicio Semanal:");
                ls_horasEjerSem = in.nextLine();
                if (!ls_horasEjerSem.matches("[0-9]*") && !esDecimal(ls_horasEjerSem)){
                    System.out.println("***Ingrese solo numeros enteros o decimanes***");
                }else{
                    cli.setLf_horas_ejercicio_semanal(Float.parseFloat(ls_horasEjerSem));
                }
             }
             while(!ls_horasEjerSem.matches("[0-9]*") && !esDecimal(ls_horasEjerSem));
          
             
             System.out.print("Ingrese su Profesion:");
             cli.setProfesion(in.nextLine());
             
             IMC = cli.getLf_peso()/(cli.getLf_estatura()*cli.getLf_estatura());
             cli.setLf_IMC(IMC);
             
             cli.setLf_precio(Float.parseFloat("120.00"));
        }else{
            cli.setLf_precio(Float.parseFloat("70.00"));
        }
        
        cli.setFecha_suscripcion(LocalDate.now());
        cli.setFecha_fin_suscripcion(LocalDate.now().plusDays(30));
       
        
        //Envio de datos al controlador
        ClienteController cc = new ClienteController();
        
        if (cc.Cliente(cli)){
            System.out.println("*****Se guardo con Exito la informacion del cliente...*****");
        }
        else{
            System.out.println("*****Error al guardar cliente...*****");
        }
        
        System.out.println("================================================================");
        
        
    }    
    public void SubidaProductos(){
       
        String urlArchivo;
           //System.out.println("SubidaProd");
        System.out.println("=============================================");
        System.out.println("               SUBIDA DE PRODUCTOS           ");
        System.out.println("=============================================");
        System.out.println(" ");
        
        System.out.println("Por favor verfique que el archivo carga_productos.csv se encuentre en la unidad D:/ antes de procesar.");
                        File archivo = new File("D:\\carga_productos.csv");
                        if (archivo.exists()) {
                            
                        String archCSV = "D:\\carga_productos.csv";
                        CSVReader csvReader;
                        try {
                            csvReader = new CSVReader(new FileReader(archCSV));
                            String[] fila = null;
                            String[] fila2 = new String[7];
                            //si ya existe el archivo ingredientes.csv lo elimina
                            String archCSV2 = "C:\\Users\\Edison Mena\\Documents\\Programas Miguel\\nutrifit\\ingredientes.csv";
                            File tempFile = new File(archCSV2);
                            boolean exists = tempFile.exists();
                                    if(exists){
                                        tempFile.delete();
                                    }
                             ///////////////////////////////
                            
                            ///lectura del archivo  carga_productos.csv
                            int id_ingrediente=0;
                            while((fila = csvReader.readNext()) != null) {
//                            System.out.println(fila[0]
//                                      + " | " + fila[1]
//                                      + " |  " + fila[2
                                //carga de los datos en el nuevo archivo ingredientes.csv
                                fila2[0] = Integer.toString(id_ingrediente);
                                fila2[1] = fila[0];
                                fila2[2] = fila[1];
                                fila2[3] = fila[2];
                                fila2[4] = fila[3];
                                fila2[5] = fila[4];
                                fila2[6] = fila[5];
                                
                              IngredientesController ic = new IngredientesController();
                              ic.grabaIngrediente(fila2);
                                id_ingrediente = id_ingrediente +1;
                            }
                            
                            System.out.println("****Carga de Productos exitoso..***");
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
                           System.out.println("¡¡No existe el archivo C:\\carga_productos.csv , por favor crearlo!!"); 
                        }
    }    
    public void RegistroRecetas(){
    
        Scanner in = new Scanner(System.in);
        
//System.out.println("RegistroRecetas");
        System.out.println("=============================================");
        System.out.println("               REGISTRO DE RECETAS           ");
        System.out.println("=============================================");
        System.out.println(" ");
        
        String nombreReceta = "";
        String tipoReceta = "";
        int  id_receta = (int)(Math.random()*10000+1);
        String lsIdingrediente;
        String lsCantGramos;
        String lsPregunta;
        String lsPreparacion;
        Recetas receta;
        //Ingredientes ingredientes;
        //boolean existeIngrediente;
        ArrayList<Ingredientes> ingredientes = new ArrayList<Ingredientes>();
        int lnEncontro ;
        int indiceIngrediente=0;
//-----------------------   
        System.out.print("Ingrese Nombre de la RECETA:     ");
          nombreReceta = in.nextLine();
          
      //-----------    
       do{   
        System.out.print("Ingrese Clasificacion de la RECETA:     ");
          tipoReceta = in.nextLine();
          
          //tipoReceta = tipoReceta.toUpperCase();
          
          if (tipoReceta.length()==0 || (!tipoReceta.toString().toUpperCase().equals("CENA") && !tipoReceta.toString().toUpperCase().equals("ALMUERZO") && !tipoReceta.toString().toUpperCase().equals("DESAYUNO"))){
           System.out.println("*****Ingrese ALMUERZO, CENA O DESAYUNO****");
          // System.out.println("*****"+tipoReceta+"******");
          }
          
          //System.out.print("tiporeceta: "+tipoReceta);
       }while(tipoReceta.length()==0 || (!tipoReceta.toString().toUpperCase().equals("CENA") && !tipoReceta.toString().toUpperCase().equals("ALMUERZO") && !tipoReceta.toString().toUpperCase().equals("DESAYUNO")));
      //------------ 
        System.out.println("Ingrese Ingredientes de la receta:     ");
        System.out.println(" ----->"); 
        ArrayList<String[]> arrIngredientes = new ArrayList<String[]>();
        String[] caIngrediente ; //= new String[2];
                        
        do{
            System.out.println("==========================================");
                        //------------------------------------------------
                        String nombreIngrediente;

                     do{       
                        do{
                        System.out.print("     Nombre de INGREDIENTE a buscar:     ");

                        nombreIngrediente = in.nextLine();
                           if (nombreIngrediente.matches("[0-9]*")){
                               System.out.println("***Ingrese solo caracteres***");
                           }
                        }
                        while(nombreIngrediente.matches("[0-9]*"));


                //---------------------------------------
                        //consulta de ingredientes por nombre
                        IngredientesController ingcontroller = new IngredientesController();
                        ingredientes = new ArrayList<Ingredientes>();
                        ingredientes = ingcontroller.consultaIngredientes(nombreIngrediente);
                     }   
                    while(ingredientes.size()==0); //si no existe el ingrediente vuelve a preguntar
                        
                        
                    do{    
                            System.out.print("Ingrese el Id_ingrediente a registrar en receta: ");
                             lnEncontro = 0;
                             lsIdingrediente = in.nextLine();
                              if (!lsIdingrediente.matches("[0-9]*")) {
                                  System.out.println("***ingrese solo numeros***");
                              }
                              else{///valida que se ingrese un idIngrediente de los que se encuentra en la busqueda
                                    for(int i=0; i< ingredientes.size(); i++)
                                    {
                                        if (Integer.parseInt(lsIdingrediente) == ingredientes.get(i).getLn_idIngrediente()){
                                            lnEncontro = 1;
                                            indiceIngrediente = i;
                                        }
                                    }
                                    if (lnEncontro == 0){
                                             System.out.println("***Ingrese un id_ingrediente de la busqueda realizada***");
                                    }
                              } 
                    }while (!lsIdingrediente.matches("[0-9]*") || lnEncontro==0) ;//si no es un id_ingrediente correspondiente a la busqueda vuelva a ingresar
                    
                    System.out.print("Ingrese los gramos a utilizar del ingrediente seleccionado: ");
                    lsCantGramos = in.nextLine();
                    
                    caIngrediente  = new String[7];
                    caIngrediente[0] = lsIdingrediente;
                    caIngrediente[1] = lsCantGramos;
                    caIngrediente[2] = Float.toString(ingredientes.get(indiceIngrediente).getLf_calorias());
                    caIngrediente[3] = Float.toString(ingredientes.get(indiceIngrediente).getLf_hidratos());
                    caIngrediente[4] = Float.toString(ingredientes.get(indiceIngrediente).getLf_proteinas());
                    caIngrediente[5] = Float.toString(ingredientes.get(indiceIngrediente).getLf_grasas());
                    caIngrediente[6] = Float.toString(ingredientes.get(indiceIngrediente).getLf_fibras());
                    
                    
                    arrIngredientes.add(caIngrediente);
                    
                  do{  
                    System.out.print("Desea Ingresar otro Ingrediente a la Receta? (S) o (N):  ");
                    lsPregunta = in.nextLine();
                  }
                 while(!lsPregunta.toUpperCase().equals("S") && !lsPregunta.toUpperCase().equals("N")); 
        }
        while(lsPregunta.toUpperCase().equals("S"));
        
        System.out.println("Ingrese la preparacion de la receta: ");
        lsPreparacion = in.nextLine();
        
        ///se obtiene ingredientes de la receta
        float lftotCalorias = 0;
        float lftotHidratos = 0;
        float lftotProteinas = 0;
        float lftotGrasas = 0;
        float lftotFibras = 0;
        
        for(int i=0 ;i < arrIngredientes.size(); i++) //para sumatoria de informacion nutricional
        {
                lftotCalorias = lftotCalorias + Float.parseFloat(arrIngredientes.get(i)[2]);
                lftotHidratos = lftotHidratos + Float.parseFloat(arrIngredientes.get(i)[3]);
                lftotProteinas = lftotProteinas + Float.parseFloat(arrIngredientes.get(i)[4]);
                lftotGrasas = lftotGrasas + Float.parseFloat(arrIngredientes.get(i)[5]);
                lftotFibras = lftotFibras + Float.parseFloat(arrIngredientes.get(i)[6]);
                
        }
        
        for(int i=0 ;i < arrIngredientes.size(); i++)
        {
            
        receta = new Recetas();
        receta.setLn_Idrecetas(id_receta);
        receta.setNombre_receta(nombreReceta);
        receta.setLs_tipo_receta(tipoReceta);
        receta.setLs_preparacion(lsPreparacion);
        receta.setLn_idIngrediente(Integer.parseInt(arrIngredientes.get(i)[0]));
        receta.setLf_cant_gramos(Integer.parseInt(arrIngredientes.get(i)[1]));
        receta.setLf_calorias(lftotCalorias);
        receta.setLf_hidratos(lftotHidratos);
        receta.setLf_proteinas(lftotProteinas);
        receta.setLf_grasas(lftotGrasas);
        receta.setLf_fibras(lftotFibras);
        
            RecetasController rcon = new RecetasController();
            rcon.guardarReceta(receta);
        }
        
        
        
        
    }   
    
   //====================================================================================== 
    public void CreaMenuSem(){
        Scanner in = new Scanner(System.in);
        
        System.out.println("============================================================");
        System.out.println("               GENERACION AUTOMATICA DE MENU SEMANAL         ");
        System.out.println("============================================================");
        System.out.println(" ");
        
        String lsFechaLunes;
        int longitudFecha;
        
        do{
                System.out.println("Ingrese la fecha desde donde se generara el menu - (dd/mm/yyyy)");
                System.out.println("--> considerar que la fecha ingresada debera ser el de 1er lunes de una semana ");


                 lsFechaLunes = in.nextLine();
                 longitudFecha = lsFechaLunes.length();
                 if (!isValidDate(lsFechaLunes) || (longitudFecha != 10)) {
                     System.out.println("**** Fecha NO valida, ingrese en el formato dd/mm/yyyy ****");
                 }
                 System.out.println(" ");
          }       
       while(!isValidDate(lsFechaLunes) || (longitudFecha != 10));  
        
        MenuController mc = new MenuController();
        if( mc.generaMenuAleatorio(lsFechaLunes) )
        {
            System.out.println("**** GENERACION DE MENU CORRECTAMENTE ****");
        }
        else{
             System.out.println("**** ERROR AL GENERAR EL MENU ALEATORIO ****");
        }
        
    }    
//======================================================================================
    
    
    public void ConsultaSubscripciones(){
        Scanner in = new Scanner(System.in);
        
//System.out.println("RegistroRecetas");
        System.out.println("============================================================");
        System.out.println("               CONSULTA DE SUBSCRIPCIONES ACTIVAS           ");
        System.out.println("============================================================");
        System.out.println(" ");
        
        String lsTipoSusbscripcion;
        
        do{
            System.out.print("Ingrese tipo de Subscripcion [V (VIP), F (FRESH), T (TODAS)]:");
            lsTipoSusbscripcion = in.nextLine().toUpperCase();
            if (!lsTipoSusbscripcion.equals("V") && !lsTipoSusbscripcion.equals("F") && !lsTipoSusbscripcion.equals("T")){
                System.out.println("***** Ingrese V, F o T *****");
            }
            
        }while(!lsTipoSusbscripcion.equals("V") && !lsTipoSusbscripcion.equals("F") && !lsTipoSusbscripcion.equals("T"));
        
        System.out.println(" ");
        
        ArrayList<Cliente> arrCliente = new ArrayList<Cliente>();
        ClienteController cc = new ClienteController();
        arrCliente = cc.consultaClientexTipo(lsTipoSusbscripcion);
         
        if (arrCliente.size() > 0){
            
            for (int i = 0; i<arrCliente.size(); i++){
                System.out.println(arrCliente.get(i).getLs_cedula() + " | "+
                                   arrCliente.get(i).getLs_nombres() + " | "+
                                   arrCliente.get(i).getLs_apellidos()+ " | "+
                                   arrCliente.get(i).getLs_telefonos()+ " | "+
                                   arrCliente.get(i).getLs_mail()+ " | "+
                                   arrCliente.get(i).getLs_direccion()+ " | "+
                                   arrCliente.get(i).getLf_peso()+ " | "+
                                   arrCliente.get(i).getLf_estatura()+ " | "+
                                   arrCliente.get(i).getLf_horas_ejercicio_semanal()+ " | "+
                                   arrCliente.get(i).getProfesion()+ " | "+
                                   arrCliente.get(i).getLf_IMC()+ " | "+
                                   ((arrCliente.get(i).getLs_tipo_cliente().equals("V"))?"VIP":"FRESH") + " | "+
                                   arrCliente.get(i).getFecha_suscripcion()+ " | "+
                                   arrCliente.get(i).getFecha_fin_suscripcion()+ " | "+
                                   arrCliente.get(i).getLf_precio()+ " | "
                        
                                  );
            }
            
            
        }else{
            System.out.println("**** NO HAY INFORMACION PARA CONSULTAR ****");
        }
    
    }
        
    
    
    
}
    

