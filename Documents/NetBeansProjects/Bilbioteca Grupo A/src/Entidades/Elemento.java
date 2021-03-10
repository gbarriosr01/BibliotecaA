/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Validaciones.ElementoException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAM102
 */
public class Elemento {
    /*Valido: >0 Invalido: <=0 Otros: Es unico*/
    protected long id; 
    protected ArrayList <Prestamo> prestamos = new ArrayList <Prestamo>();/*Obligatorio*/
    protected Genero genero;/*Obligatorio*/
    protected long idGenero;/*Obligatorio*/
    public Elemento() {
    }

//    public Elemento(long id, Genero genero) throws ElementoException{
//        if(ElementoException.validarId(id)){
//        this.id = id;
//        }else{
//            throw new ElementoException("El id debe ser >0");
//        }
//        this.genero = genero;
//    }
    
    public Elemento(long id, Genero genero){
        
        this.id = id;
        
        this.genero = genero;
    }
    
//    public Elemento(Elemento el) throws ElementoException{
//        if(ElementoException.validarId(el.id)){
//        this.id = el.id;
//        }else{
//            throw new ElementoException("El id debe ser >0");
//        }
//        this.genero = el.genero;
//    }
    
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
    
    public static Elemento nuevoElemento() throws ElementoException{
        Elemento el = new Elemento();
        Scanner teclado = new Scanner(System.in);
        
        int numElementos;
        numElementos = Utilidades.numElementos + 1;
        if(ElementoException.validarId(numElementos)){
        el.setId(numElementos);
        }else{
        throw new ElementoException("El id debe ser >0");
        }
 
        System.out.println("Socio registrado correctamente con el id " + numElementos);
        return el;
    
    }
    
    @Override
    public String toString() {
        return "Elemento{" + "id=" + id + ", prestamos=" + prestamos + ", genero=" + genero + '}';
    }
    
     /**
     * Atributos separados por el caracter |
     * @return Primary key id | idGenero
     */
    public String data() {
        return  "|" + id + "|" + idGenero;
    }
    
}
