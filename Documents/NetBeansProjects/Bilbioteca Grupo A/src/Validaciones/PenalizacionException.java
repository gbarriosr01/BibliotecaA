/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import Entidades.Penalizacion;

/**
 *
 * @author Vicente Urrutia
 */
public class PenalizacionException extends Exception{
    

    public PenalizacionException(String msj) {
        super(msj);
    }
    
    public static boolean validarPenalizacion(Penalizacion penalizacion) {
        return validarId(penalizacion.getId()) && validarMotivo(penalizacion.getMotivo()) && validarId(penalizacion.getId_socio());
    }


    public static boolean validarId(long id) {
        return id > 0;
    }
    
    public static boolean validarMotivo(String nombre) {
        return nombre.matches("^([A-Za-z]{1}[a-z]{1,50}[ ]?){1,20}$");
    }
    
}
