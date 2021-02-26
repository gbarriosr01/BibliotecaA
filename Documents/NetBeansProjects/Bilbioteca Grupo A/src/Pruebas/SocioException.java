/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Entidades.Socio;

/**
 *
 * @author DAM102
 */
public class SocioException {

    //Validamos Socio por el ID comprobando si es >0
    public static boolean validarSocioId(long id) {
        if (id > 0) {
            return true;
        } else {
            System.out.println("Error 404 not found");
        }
        return false;

    }

    public static boolean validarSocioNombre(String nombre) {
        if (nombre.length() >= 20 && nombre.length() < 40) {
            return true;
        } else {
            System.out.println("Error 404 not found");
        }
        return false;

    }

    public static boolean validarSocioNIF(String NIF) {
        if (NIF.length() == 9) {
            return true;
        } else {
            System.out.println("Error 404 not found");
        }
        return false;
    }

    public static boolean validarSocioTelefono(String telefono) {
        if (telefono.length() == 9) {
            return true;
        } else {
            System.out.println("Error 404 not found");
        }
        return false;
    }

    public static boolean validarSocioDireccion(String direccion) {
        if (direccion.length() > 30 && direccion.length() < 100) {
            return true;
        } else {
            System.out.println("Error 404 not found");
        }
        return false;
    }

    public static boolean validarNombre(String nombre) {
        boolean check = false;

        /*Verificamos que no sea null*/
        if (nombre != null) {
            /* 1ª Condición: que la letra inicial sea mayúscula*/
            boolean isFirstUpper = Character.isUpperCase(nombre.charAt(0));

            /* 2ª Condición: que el tamaño sea >= 15 y <= 40*/
            int stringSize = nombre.length();
            boolean isValidSize = (stringSize >= 15 && stringSize <= 40);

            /* 3ª Condición: que contenga al menos un espacio*/
            boolean isSpaced = nombre.contains(" ");
            

            /* Verificamos que las tres condiciones son verdaderas*/
            check = ((isFirstUpper == true) && (isFirstUpper && isValidSize && isSpaced));
        }
        /*Devolvemos el estado de la validación*/
        return check;
    }

}
