/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import java.sql.Date;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;

/**
 *
 * @author DAM115
 */
public class EventoException extends Exception {

    public EventoException(String msj) {
        super(msj);
    }

    public static boolean validarId(long id) {
        boolean ret = true;
        if (id < 0) {
            ret = false;
        }
        return ret;
    }

    public static boolean validarNombre(String nombre) {
        boolean ret = true;
        if (nombre.isEmpty()) {
            ret = false;
        }
        if (nombre.length() < 1 || nombre.length() > 100) {
            ret = false;
        }
        return ret;
    }

//    public static boolean validarFecha(String s) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        sdf.setLenient(false);
//        return sdf.parse(s, new ParsePosition(0)) != null;
//    }
    public static boolean validarIdPenalizacion(long idPenalizacion) {
        boolean ret = true;
        if (idPenalizacion < 0) {
            ret = false;
        }
        return ret;
    }
}
