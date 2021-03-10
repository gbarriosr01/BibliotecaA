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
public class ConcursoException extends Exception {

    /*
    Valores validos: Caracteres alfanumericos.
    Valores invalidos: Caracteres especiales.
    Otras restricciones: Longitud max 30 caracteres.
     */
    private String tipo;
    /*
    Valores validos: Caracteres alfanumericos.
    Valores invalidos: Caracteres especiales.
    Otras restricciones: Longitud max 30 caracteres.
     */
    private String premio;

    public ConcursoException(String msj) {
        super(msj);
    }

    public static boolean validarTipo(String tipo) {
        boolean ret = true;
        if (tipo.isEmpty()) {
            ret = false;
        }
        if (tipo.length() < 1 || tipo.length() > 30) {
            ret = false;
        }
        return ret;
    }

    public static boolean validarPremio(String premio) {
        boolean ret = true;
        if (premio.isEmpty()) {
            ret = false;
        }
        if (premio.length() < 1 || premio.length() > 30) {
            ret = false;
        }
        return ret;
    }
}
