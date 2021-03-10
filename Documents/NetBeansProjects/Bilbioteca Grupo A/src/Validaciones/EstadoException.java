/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import Entidades.Estado;

/**
 *
 * @author DAM122
 */
public class EstadoException extends Exception{
    
    public EstadoException(String msj) {
        super(msj);
    }
    public static boolean validarEstado(Estado estado) {
        return validarId(estado.getId()) && validarEstado(estado.getEstado());
    }
    
    public static boolean validarId(long id) {
        return id > 0;
    }
    
    public static boolean validarEstado(String nombre) {
        if(nombre=="Pendiente" || nombre== "Parcial" || nombre=="Completo")
            return true;
        else
            return false;
    }
    
}
