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
public class VisionadoException extends Exception {

    public VisionadoException(String msj) {
        super(msj);
    }

    public static boolean validarAula(String aula) {
        boolean ret = true;
        if (aula.isEmpty()) {
            ret = false;
        }
        if (aula.matches("[,:;¿?¡!|ª\\/#·~$%€¬)(='{}-_@€")) {
            ret = false;
        }
        return ret;
    }
}
