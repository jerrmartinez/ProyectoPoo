/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Jeremy martinez
 */
public class Utils {
 
    public boolean validadorDeCedula(String cedula) 
		{
			boolean cedulaCorrecta = false;
			 
			try {		 
				if (cedula.length() == 10) // ConstantesApp.LongitudCedula
				{
					int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
					if (tercerDigito < 6) {
					// Coeficientes de validación cédula
					// El decimo digito se lo considera dígito verificador
					 int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
					 int verificador = Integer.parseInt(cedula.substring(9,10));
					 int suma = 0;
					 int digito = 0;
					for (int i = 0; i < (cedula.length() - 1); i++) {
					 digito = Integer.parseInt(cedula.substring(i, i + 1))* coefValCedula[i];
					 suma += ((digito % 10) + (digito / 10));
					}			 
					if ((suma % 10 == 0) && (suma % 10 == verificador)) {
					 cedulaCorrecta = true;
					}
					else if ((10 - (suma % 10)) == verificador) {
					 cedulaCorrecta = true;
					} else { cedulaCorrecta = false; }
					} else { cedulaCorrecta = false; }
				} 
				else { cedulaCorrecta = false; }
			} catch (NumberFormatException nfe) {
				cedulaCorrecta = false;
			} catch (Exception err) {
				System.out.println("Una excepcion ocurrio en el proceso de validacion de cedula");
				cedulaCorrecta = false;
			}		 
			if (!cedulaCorrecta) {
				System.out.println("La cedula ingresada es Incorrecta");
			}
			return cedulaCorrecta;
		}
    
    public int calcularEdad(String fecha) 
		{
			String datetext = fecha;
			try {
				Calendar birth = new GregorianCalendar();
				Calendar today = new GregorianCalendar();
				int age=0;
				int factor=0;
				Date birthDate=new SimpleDateFormat("dd/MM/yyyy").parse(datetext);
				Date currentDate=new Date(); //current date
				birth.setTime(birthDate);
				today.setTime(currentDate);
				if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
				if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
				if (today.get(Calendar.DATE) > birth.get(Calendar.DATE)) {
				factor = -1; //Aun no celebra su cumpleaÃ±os
				}
				} else {
				factor = -1; //Aun no celebra su cumpleaÃ±os
				}
				}
				age=(today.get(Calendar.YEAR)-birth.get(Calendar.YEAR))+factor;
				
				if (age <0)
					age = 0;
				
				return age;
			} catch (ParseException e) {
				return -1;
			}
		}
                

    public static boolean ValidarMail(String email) {
                // Patron para validar el email
                Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

                Matcher mather = pattern.matcher(email);
                return mather.find();
            }

    //Devuelve true si la cadena que llega tiene la sintaxis de un decimal
                 public boolean esDecimal(String cad)
                 {
                 boolean hayPunto=false;
                 StringBuffer parteEntera = new StringBuffer();
                 StringBuffer parteDecimal = new StringBuffer();
                 int i=0, posicionDelPunto;

                 for( i=0;i<cad.length(); i++ )
                 if ( cad.charAt(i) == '.')                          //Detectar si hay un punto decimal en la cadena
                 hayPunto=true;
                 if(hayPunto)                                            //Si hay punto guardar la posicion donde se encuentra el carater punto
                 posicionDelPunto=cad.indexOf('.');                  //(si la cadena tiene varios puntos, detecta donde esta el primero).
                 else
                 return false;                                       //Si no hay punto; no es decimal

                 if( posicionDelPunto == cad.length()-1 || posicionDelPunto== 0)    //Si el punto esta al final o al principio no es un decimal
                 return false;

                 for( i=0;i<posicionDelPunto; i++ )
                 parteEntera.append(cad.charAt(i)) ;                 //Guardar la parte entera en una variable

                 for(i = 0; i<parteEntera.length(); i++)
                 if( ! Character.isDigit(parteEntera.charAt(i)) )    //Si alguno de los caracteres de la parte entera no son digitos no es decimal
                 return false;

                 for( i=posicionDelPunto+1;i<cad.length(); i++ )
                 parteDecimal.append(cad.charAt(i));                 //Guardar la parte decimal en una variable

                 for(i = 0; i<parteDecimal.length(); i++)
                 if( ! Character.isDigit(parteDecimal.charAt(i)) )   //Si alguno de los caracteres de la parte decimal no es un digito no es decimal
                 return false;                                   //Incluye el caso en el que la cadena tenga dos o mas puntos

                 return true;                                            //Si paso todas las pruebas anteriores, la cadena es un Numero decimal
                 }
                 
                 
                 
              public boolean isValidDate(String dateString) {
                    SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");//SimpleDateFormat("yyyyMMdd");
                    try {
                        df.parse(dateString);
                        return true;
                    } catch (ParseException e) {
                        return false;
                    }
             }   
                 
                 
                 
                 
                 
                 
                 
}
