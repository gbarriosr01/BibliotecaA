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
public class CursoException extends Exception {

    public CursoException(String msj) {
        super(msj);
    }

    public static boolean validarDuracion(String duracion) {
        boolean ret = true;
        if (duracion.isEmpty()) {
            ret = false;
        }

        return ret;
    }

    public static boolean validarAula(String aula) {
        boolean ret = true;
        if (aula.isEmpty()) {
            ret = false;
        }

        return ret;
    }
}
