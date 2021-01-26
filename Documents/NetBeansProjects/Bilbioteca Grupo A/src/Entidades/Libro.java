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
public class Libro extends Elemento{
    /*Valido: cadena caracteres "dadsad" Invalido: " ", >50 caracteres*/
    private String nombre;
    /*Valido: cadena caracteres "dadsad" Invalido: " ", >50 caracteres*/
    private String editorial;
    /*Valido: cadena caracteres "dadsad" Invalido: " ", >50 caracteres*/
    private String autor;
    /*Valido: >0 Invalido: <0*/
    private int nPaginas;
    private Lectura lectura;/*Obligatorio*/

    public Libro() {
        super();
    }

    public Libro(String nombre, String editorial, String autor, int nPaginas) {
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
        this.nPaginas = nPaginas;
    }

    public Libro(String nombre, String editorial, String autor, int nPaginas, Lectura lectura) {
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.lectura = lectura;
    }

    public Libro(String nombre, String editorial, String autor, int nPaginas, Lectura lectura, long id, Genero genero) {
        super(id, genero);
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.lectura = lectura;
    }

    public Libro(String nombre, String editorial, String autor, int nPaginas, Lectura lectura, Elemento el) {
        super(el);
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.lectura = lectura;
    }
    
    public Libro(Libro l) {
        this.nombre = l.nombre;
        this.editorial = l.editorial;
        this.autor = l.autor;
        this.nPaginas = l.nPaginas;
        this.lectura = l.lectura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public Lectura getLectura() {
        return lectura;
    }

    public void setLectura(Lectura lectura) {
        this.lectura = lectura;
    }
    
    public static ArrayList<Libro> convertirLibros(Libro[] array) {
        ArrayList<Libro> ret = new ArrayList<Libro>();
        for (Libro s : array) {
            ret.add(s);
        }

        return ret;
    }
    
    public static Libro nuevoLibro() {
        Libro li = new Libro ();
        Scanner teclado = new Scanner(System.in);
        System.out.println("indica su nombre: ");
        li.setNombre(teclado.nextLine());
        System.out.println("indica la editorial: ");
        li.setEditorial(teclado.nextLine());
        System.out.println("indica el autor: ");
        li.setAutor(teclado.nextLine());
        System.out.println("indica el numero de paginas: ");
        li.setnPaginas(teclado.nextInt());
        
        int numLibros = Utilidades.numLibros + 1;
            li.setId(numLibros);
            
        return li;
    
    }
    
    public static void verLibro(ArrayList<Libro> libros) {
        System.out.println("Socios de la biblioteca:");
        for (Libro s : libros) {
            System.out.println("<" + s.getNombre() +  "> publicado por " + (s.getEditorial() + " y escrito por " + (s.getAutor() + ".")));
        }

    }


    @Override
    public String toString() {
        return "Libro{" + "nombre=" + nombre + ", editorial=" + editorial + ", autor=" + autor + ", nPaginas=" + nPaginas + ", lectura=" + lectura + '}';
    }

    
}
