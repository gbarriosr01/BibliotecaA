/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import Entidades.Proveedor;
import java.util.regex.Pattern;

/**
 *
 * @author DAM102
 */
public class ProveedorException extends Exception{
    
     public ProveedorException(String msj){
        super(msj);
    }
    
     public static boolean validarProveedor(Proveedor proveedor) {
        return validarProveedorId(proveedor.getId()) && validarProveedorNombre(proveedor.getNombre()) && validarProveedorTelefono(proveedor.getTelefono());
    }
  
  
    public static boolean validarProveedorId(long id) {

        return id > 0;
    }

    public static boolean validarProveedorNombre(String nombre) {

        boolean check = false;

        /*Verificamos que no sea null*/
        if (nombre != null) {
            /* 1ª Condición: que la letra inicial sea mayúscula*/
            boolean isFirstUpper = Character.isUpperCase(nombre.charAt(0));

            /* 2ª Condición: que el tamaño sea >= 15 y <= 40*/
            int stringSize = nombre.length();
            boolean isValidSize = (stringSize >= 3 && stringSize <= 20);

            //3º Condición:  que contenga solo letras de la A-z, no numeros ni simbolos.    
            boolean isOnlyLetters = Pattern.matches("^[a-zA-Z]*$", nombre);

            /* Verificamos que las condiciones son verdaderas*/
            check = ((isFirstUpper == true) && (isFirstUpper && isValidSize));
        }
        /*Devolvemos el estado de la validación*/
        return check;

    }

    public static boolean validarProveedorTelefono(String telefono) {

        boolean check = false;

        if (telefono != null) {
            int stringSize = telefono.length();
            boolean isValidSize = (stringSize == 9);

            boolean isOnlyNumbers = Pattern.matches("^[0-9]*$", telefono);

            check = ((isValidSize && isOnlyNumbers));
        }
        return check;
    }
}
