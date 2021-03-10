/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validaciones;

import Entidades.Socio;
import java.util.regex.Pattern;

/**
 *
 * @author DAM102
 */
public class SocioException extends Exception {

    public SocioException(String msj) {
        super(msj);
    }

    public static boolean validarSocio(Socio socio) {
        return validarId(socio.getId()) && validarNombre(socio.getNombre()) && validarNIF(socio.getNIF()) && validarTelefono(socio.getTelefono()) && validarDireccion(socio.getDireccion());
    }

    public static boolean validarId(long id) {
        return id > 0;
    }

    public static boolean validarNombre(String nombre) {
        return nombre.matches("^([A-Za-z]{1}[a-z]{1,20}[ ]?){1,3}$");
    }

    public static boolean validarNIF(String NIF) {
        return NIF.matches("^([0-9]{8})[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$");
    }

    public static boolean validarTelefono(String telefono) {
        return telefono.matches("^([0-9]{9})");
    }

    public static boolean validarDireccion(String direccion) {
        return direccion.matches("^([A-Z]{1}[a-z]{1,30}[ ]?){1,5}$");
    }

}
