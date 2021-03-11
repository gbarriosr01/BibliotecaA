/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

/**
 *
 * @author diegu
 */
public class DVDException extends Exception{
    public DVDException(String msj){
        super(msj);
    }
    
    public static boolean validarTitulo(String titulo) {
        return titulo.matches("^([A-Za-z]{1}[a-z]{1,30}[ ]?){1,3}$");
    }
    
}
