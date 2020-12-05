/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import DAO.DbMenu;
import clases.Menu;
import clases.Recetas;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Jeremy martinez
 */
public class MenuController {
    
    public boolean generaMenuAleatorio(String lsFechaIni){
        boolean retorna = false;
        int  id_menu;
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate ldFechaIni = LocalDate.parse(lsFechaIni,formateador);
        LocalDate ldFechaFin = ldFechaIni.plusDays(5);
        
////        System.out.println("Fecha inicio: "+ldFechaIni);
////        System.out.println("Fecha fin: "+ldFechaFin);
////        
        ArrayList<Recetas> arrRecetas = new ArrayList<Recetas>();
        ArrayList<Recetas> arrRecetas2 = new ArrayList<Recetas>();
        ArrayList<Recetas> arrRecetas3 = new ArrayList<Recetas>();
        ArrayList<Recetas> arrRecetas4 = new ArrayList<Recetas>();
        
        Recetas receta;
        RecetasController rcon = new RecetasController();
        arrRecetas = rcon.consultarRecetas();
  
       Integer lnIdreceta =0; 
        for (int i =0; i<arrRecetas.size(); i++){
           if (!lnIdreceta.equals(arrRecetas.get(i).getLn_Idrecetas()) ){ 
              receta = new Recetas(); 
            //System.out.println(arrRecetas.get(i).getLn_Idrecetas() + "|" + arrRecetas.get(i).getNombre_receta() + "|" + arrRecetas.get(i).getLs_tipo_receta());
            lnIdreceta = arrRecetas.get(i).getLn_Idrecetas();
              receta.setLn_Idrecetas(arrRecetas.get(i).getLn_Idrecetas());
              receta.setNombre_receta(arrRecetas.get(i).getNombre_receta());
              receta.setLs_tipo_receta(arrRecetas.get(i).getLs_tipo_receta());
              receta.setLf_calorias(arrRecetas.get(i).getLf_calorias());
              receta.setLf_hidratos(arrRecetas.get(i).getLf_hidratos());
              receta.setLf_proteinas(arrRecetas.get(i).getLf_proteinas());
              receta.setLf_grasas(arrRecetas.get(i).getLf_grasas());
              receta.setLf_fibras(arrRecetas.get(i).getLf_fibras());
              
              arrRecetas2.add(receta); //distincr de recetas, ecetas disponibles para el menu
              
           }
        }
        
        arrRecetas4.addAll(arrRecetas2);//copia del arrRecetas2
        //recetas disponibles para el menu..
//        for (int i =0; i<arrRecetas2.size(); i++){
//            System.out.println(arrRecetas2.get(i).getLn_Idrecetas() + "|" + arrRecetas2.get(i).getNombre_receta() + "|" + arrRecetas2.get(i).getLs_tipo_receta());
//        }
        
        Random ramd = new Random();
        Menu menu ;
        
        
        //---------------------------------------- bucle para los 5 dias
        for (int y=1 ; y <= 5 ; y++){ //begin for
              
            arrRecetas4.clear();
            arrRecetas4.addAll(arrRecetas2);
            arrRecetas3.clear();
            
                    id_menu = (int)(Math.random()*10000+1);
                    menu = new Menu();
                    int j = 0;
                    String lstiporeceta  = "";
                    List<String> tipo_receta = new ArrayList<String>();
                    int repetido=0;
                  //----------------------------------------------------------  
                   do //genera desayuno, almuerzo y cena
                    {  
                       repetido = 0;
                       int lnaleatorio = ramd.nextInt(arrRecetas4.size());
                        receta = new Recetas();
                        //receta = arrRecetas2.get(lnaleatorio);

                        if(!tipo_receta.isEmpty()){
                                if (tipo_receta.size()>0){
                                    for (int x = 0; x < tipo_receta.size(); x++){
                                        if( tipo_receta.get(x).toString().equals(arrRecetas4.get(lnaleatorio).getLs_tipo_receta()) ){
                                          repetido = 1;  
                                        }

                                    }
                                }
                        }


                        if (tipo_receta.isEmpty() || repetido == 0){
                        //if (!lstiporeceta.equals(arrRecetas4.get(lnaleatorio).getLs_tipo_receta())){
                            //lstiporeceta = arrRecetas4.get(lnaleatorio).getLs_tipo_receta();
                            tipo_receta.add(arrRecetas4.get(lnaleatorio).getLs_tipo_receta());
                            //System.out.println(arrRecetas2.get(lnaleatorio).getLn_Idrecetas() + "|" + arrRecetas2.get(lnaleatorio).getNombre_receta() + "|" + arrRecetas2.get(lnaleatorio).getLs_tipo_receta());
                              //arrRecetas3.addAll(arrRecetas2);
                             receta.setLn_Idrecetas(arrRecetas4.get(lnaleatorio).getLn_Idrecetas());
                             receta.setNombre_receta(arrRecetas4.get(lnaleatorio).getNombre_receta());
                             receta.setLs_tipo_receta(arrRecetas4.get(lnaleatorio).getLs_tipo_receta());
                             receta.setLf_calorias(arrRecetas4.get(lnaleatorio).getLf_calorias());
                             receta.setLf_hidratos(arrRecetas4.get(lnaleatorio).getLf_hidratos());
                             receta.setLf_proteinas(arrRecetas4.get(lnaleatorio).getLf_proteinas());
                             receta.setLf_grasas(arrRecetas4.get(lnaleatorio).getLf_grasas());
                             receta.setLf_fibras(arrRecetas4.get(lnaleatorio).getLf_fibras());

                             arrRecetas3.add(receta);
                             arrRecetas4.remove(lnaleatorio); //remueve el ya asignado

                            j++;
                        }




                    }
                   while (j<3); 
                   //----------------------------------------------------------

        //           for (int i =0; i<arrRecetas3.size(); i++){
        //            System.out.println(arrRecetas3.get(i).getLn_Idrecetas() + "|" + arrRecetas3.get(i).getNombre_receta() + "|" + arrRecetas3.get(i).getLs_tipo_receta());
        //            }
                   //----------------------------------------------------------
                   //GRABA el MENU DEL DIA

                  DbMenu dbmenu = new DbMenu();

                  for (int i =0; i<arrRecetas3.size(); i++){
                      menu.setLn_Idmenu(id_menu);
                      menu.setLn_Idrecetas(arrRecetas3.get(i).getLn_Idrecetas());
                      menu.setLsNombreReceta(arrRecetas3.get(i).getNombre_receta());
                      menu.setLsTipoMenu(arrRecetas3.get(i).getLs_tipo_receta());
                      menu.setLf_calorias(arrRecetas3.get(i).getLf_calorias());
                      menu.setLf_hidratos(arrRecetas3.get(i).getLf_hidratos());
                      menu.setLf_proteinas(arrRecetas3.get(i).getLf_proteinas());
                      menu.setLf_grasas(arrRecetas3.get(i).getLf_grasas());
                      menu.setLf_fibras(arrRecetas3.get(i).getLf_fibras());
                      menu.setLfFechaIni(ldFechaIni);
                      menu.setLfFechaFin(ldFechaFin);

                      dbmenu = new DbMenu();
                      dbmenu.grabarMenu(menu);



                  }
           
                  ldFechaIni = ldFechaIni.plusDays(1); //incrementa un dia
            
        } //end for
        retorna = true;
        
        
        return retorna;
    }
    
    public ArrayList<Menu> consultaMenu(){
        ArrayList<Menu> arrMenu = new ArrayList<Menu>();
        DbMenu dbmenu = new DbMenu();
        
       arrMenu = dbmenu.consultaMenu();
        
        
        return arrMenu;
    }
    
}
