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
public class Genero {
    private long id;
    private String nombre;
    
    

    public Genero() {
    }

    public Genero(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
   
    public Genero(Genero g1){
       this.id=g1.id;
       this.nombre=g1.nombre;
        
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
    
    
}
