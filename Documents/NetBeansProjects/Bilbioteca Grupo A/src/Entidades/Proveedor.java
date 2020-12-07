/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author DAM102
 */
public class Proveedor {
     
    private long id;
    private String nombre;
    private String telefono;

    public Proveedor() {
    }

    public Proveedor(long id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public Proveedor(Proveedor p1){
        this.id=p1.id;
        this.nombre=p1.nombre;
        this.telefono=p1.telefono;
    
    }
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
