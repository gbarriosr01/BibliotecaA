/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import Entidades.Genero;
import java.util.regex.Pattern;

/**
 *
 * @author DAM102
 */
public class GeneroException extends Exception{
    
     public GeneroException(String msj){
        super(msj);
    }
    
     public static boolean validarGenero(Genero genero) {
        return validarGeneroId(genero.getId()) && validarGeneroNombre(genero.getNombre());
    }
    
    
     public static boolean validarGeneroId(long id) {

        return id > 0;
    }
     
      public static boolean validarGeneroNombre(String nombre) {

        boolean check = false;

        /*Verificamos que no sea null*/
        if (nombre != null) {
           
            int stringSize = nombre.length();
            boolean isValidSize = (stringSize >= 3 && stringSize <= 20);

              
            boolean isOnlyLetters = Pattern.matches("^[a-zA-Z]*$", nombre);

            /* Verificamos que las condiciones son verdaderas*/
            check = ((isOnlyLetters && isValidSize));
        }
        /*Devolvemos el estado de la validación*/
        return check;

    }
     
     
     
    
}
