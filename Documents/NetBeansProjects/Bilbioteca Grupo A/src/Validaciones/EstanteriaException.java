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
public class EstanteriaException extends Exception{
    public EstanteriaException(String msj){
        super(msj);
    }
    
    public static boolean validarId(long id) {
        return id > 0 ;
    }
    
    public static boolean validarCodigo(char codigo) {
        if (Character.isUpperCase(codigo)) {
            return true;
        } else {
            return false;
        }  
            
    }
    
    public static boolean validarUbicacion(String ubicacion) {
        return ubicacion.matches("^([A-Za-z]{1}[a-z]{1,30}[ ]?){1,3}$");
    }
    
    public static boolean validarCompleta(boolean completa) {
        if(completa != true && completa != false){
        return false;
        }else{
        return true;
        }
    }
}
