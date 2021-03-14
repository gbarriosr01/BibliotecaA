/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import Entidades.Prestamo;
import Entidades.Socio;

/**
 *
 * @author Vicente Urrutia
 */
public class PrestamoException extends Exception {

    public PrestamoException(String msj) {
        super(msj);
    }

    public static boolean validarPrestamo(Prestamo prestamo) {
        return validarId(prestamo.getId());
    }

    public static boolean validarId(long id) {
        return id > 0;
    }
}
