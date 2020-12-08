/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author DAM102
 */
public class Socio {
                
    private long id;
    private String nombre;
    private String NIF;
    private String telefono;
    private String direccion;
    private ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
    private ArrayList<Evento> eventos = new ArrayList<Evento>();/*No obligatorio*/
    private ArrayList<Penalizacion> penalizaciones = new ArrayList<Penalizacion>();

    
    public Socio() {
    }

    public Socio(Socio copia){
        this.id = copia.id;
        this.nombre = copia.nombre;
        this.NIF = copia.NIF;
        this.telefono = copia.telefono;
        this.direccion = copia.direccion;
        this.prestamos = copia.prestamos;
        this.eventos = copia.eventos;
    }
    
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNIF() {
        return NIF;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
