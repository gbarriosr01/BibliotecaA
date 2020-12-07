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
public class Elemento {
    
    protected long id;
    protected ArrayList <Prestamo> prestamos = new ArrayList <Prestamo>();/*Obligatorio*/
    protected Genero genero;/*Obligatorio*/

    public Elemento() {
    }

    public Elemento(long id, Genero genero) {
        this.id = id;
        this.genero = genero;
    }
    
    public Elemento(Elemento el) {
        this.id = el.id;
        this.genero = el.genero;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Elemento{" + "id=" + id + ", prestamos=" + prestamos + ", genero=" + genero + '}';
    }
    
    
}
