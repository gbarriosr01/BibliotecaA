/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAM102
 */
public class Elemento {
    /*Valido: >=0 Invalido: <0 Otros: Es unico*/
    protected long id=0; 
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
    
    public static Elemento nuevoElemento() {
        Elemento el = new Elemento();
        Scanner teclado = new Scanner(System.in);
        
        int numElementos = Utilidades.numElementos + 1;
        el.setId(numElementos);
        
        
        return el;
    
    }

    @Override
    public String toString() {
        return "Elemento{" + "id=" + id + ", prestamos=" + prestamos + ", genero=" + genero + '}';
    }
    
    
}
