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
public class Libro extends Elemento {

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

    public static long nextIdLibro() {
        long ret = 0;
        for (int i = 0; i < Utilidades.LIBROS.length; i++) {
            if (Utilidades.LIBROS[i].id > ret) {
                ret = Utilidades.LIBROS[i].id;
            }
        }
        return ret + 1;
    }

    public static Libro nuevoLibro() {
        Libro li = new Libro();
        int opcion = 0;
        int idGenero = 0;
        Genero gen;

        ArrayList<Libro> libros = Libro.convertirLibros(Utilidades.LIBROS);
        ArrayList<Genero> generos = Genero.convertirGeneros(Utilidades.GENEROS);

        Scanner teclado = new Scanner(System.in);
        System.out.println("Indica su nombre: ");
        li.setNombre(teclado.nextLine());
        System.out.println("Indica la editorial: ");
        li.setEditorial(teclado.nextLine());
        System.out.println("Indica el autor: ");
        li.setAutor(teclado.nextLine());
        System.out.println("Indica el numero de paginas: ");
        li.setnPaginas(teclado.nextInt());

        long idLib = nextIdLibro();
        li.setId(idLib);

        System.out.println("Indica el Genero ");
        do {
            Genero.verGenero(generos);
            System.out.println("-------------------------------------------------");
            teclado = new Scanner(System.in);
            idGenero = teclado.nextInt();
            if (idGenero != 0) {
                gen = Genero.buscarGenerosPorId(idGenero, generos);
                if (gen != null) {
                    System.out.println("Genero asignado. ");
                    gen.verGeneroElemento();
                    li.setGenero(gen);
                } else {
                    System.out.println("Genero:  " + idGenero + "  Desconocido");
                }
            }

        } while (opcion != 0);

        return li;

    }
    
    
    
     public static ArrayList<Libro> buscarLibrosPorNombre(String nombreLibro, ArrayList<Libro> Libros) {
        ArrayList<Libro> ret = new ArrayList<Libro>();
        for (Libro lib : Libros) {
            if (Utilidades.removeDiacriticalMarks(lib.getNombre().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(nombreLibro.toLowerCase()))) {
                ret.add(lib);
            }
            if (lib.getNombre().toLowerCase().contains(nombreLibro.toLowerCase())) {
                if (!ret.contains(lib)) {
                    ret.add(lib);
                }
            }
        }
        return ret;
    }
      public static ArrayList<Libro> buscarLibrosPorAutor(String autorLibro, ArrayList<Libro> Libros) {
        ArrayList<Libro> ret = new ArrayList<Libro>();
        for (Libro lib : Libros) {
            if (Utilidades.removeDiacriticalMarks(lib.getAutor().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(autorLibro.toLowerCase()))) {
                ret.add(lib);
            }
            if (lib.getAutor().toLowerCase().contains(autorLibro.toLowerCase())) {
                if (!ret.contains(lib)) {
                    ret.add(lib);
                }
            }
        }
        return ret;
    }
      
        public static ArrayList<Libro> buscarLibrosPorEditorial(String editorialLibro, ArrayList<Libro> Libros) {
        ArrayList<Libro> ret = new ArrayList<Libro>();
        for (Libro lib : Libros) {
            if (Utilidades.removeDiacriticalMarks(lib.getEditorial().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(editorialLibro.toLowerCase()))) {
                ret.add(lib);
            }
            if (lib.getEditorial().toLowerCase().contains(editorialLibro.toLowerCase())) {
                if (!ret.contains(lib)) {
                    ret.add(lib);
                }
            }
        }
        return ret;
    }

    public static void verLibro(ArrayList<Libro> libros) {
        System.out.println("Socios de la biblioteca:");
        for (Libro s : libros) {
            System.out.println("<" + s.getNombre() + "> publicado por " + (s.getEditorial() + " y escrito por " + (s.getAutor()+ " " + (s.getGenero()) + ".")));
        }

    }

    @Override
    public String toString() {
        return "Libro{" + "nombre=" + nombre + ", editorial=" + editorial + ", autor=" + autor + ", nPaginas=" + nPaginas + ", lectura=" + lectura + '}';
    }

}
