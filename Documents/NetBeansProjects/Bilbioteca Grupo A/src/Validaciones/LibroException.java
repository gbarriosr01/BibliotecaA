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
public class LibroException extends Exception{
    public LibroException(String msj){
        super(msj);
    }
    
    public static boolean validarNombre(String nombre) {
        return nombre.matches("^([A-Za-z]{1}[a-z]{1,30}[ ]?){1,3}$");
    }
    
    public static boolean validarEditorial(String editorial) {
        return editorial.matches("^([A-Za-z]{1}[a-z]{1,30}[ ]?){1,3}$");
    }
    
    public static boolean validarNPaginas(int NPaginas) {
        return NPaginas >0;
    }
    
}
