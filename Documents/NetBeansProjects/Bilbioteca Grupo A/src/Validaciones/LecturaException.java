/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

/**
 *
 * @author DAM115
 */
public class LecturaException extends Exception {

    public LecturaException(String msj) {
        super(msj);
    }

    public static boolean validarLeido(boolean leido) {
        boolean ret = true;
        if(ret != true){
            ret = false;
        }
        return ret;
    }

    public static boolean validarModelo(String modelo) {
        boolean ret = true;
         if (modelo.isEmpty()) {
            ret = false;
        }
        return ret;
    }
}
