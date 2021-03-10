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
public class ElementoException extends Exception{
    public ElementoException(String msj){
        super(msj);
    }
    
    public static boolean validarId(long id) {
        return id > 0 ;
    }
    
    public static boolean validarIdGenero(long idGenero) {
        return idGenero > 0 ;
    }
    
    
}
