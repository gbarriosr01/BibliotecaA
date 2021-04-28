/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Validaciones.ElementoException;
import Validaciones.LibroException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAM102
 */
public class Libro extends Elemento {

    /*Valido: cadena caracteres "dadsad" Invalido: " ", >30 caracteres*/
    private String nombre;
    /*Valido: cadena caracteres "dadsad" Invalido: " ", >30 caracteres*/
    private String editorial;
    /*Valido: cadena caracteres "dadsad" Invalido: " ", >30 caracteres*/
    private String autor;
    /*Valido: >0 Invalido: <0*/
    private int nPaginas;
    private long idLectura;/*Obligatorio*/

    public Libro() {
        super();
    }

    public Libro(String nombre, String editorial, String autor, int nPaginas) {
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
        this.nPaginas = nPaginas;
    }
    public Libro(Elemento e,String nombre, String editorial, String autor, int nPaginas)  {
        super(e);
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
        this.nPaginas = nPaginas;
    }

    public Libro(String nombre, String editorial, String autor, int nPaginas, long idLectura) {
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.idLectura = idLectura;
    }

    public Libro(String nombre, String editorial, String autor, int nPaginas, long idLectura, long id, Genero genero) throws ElementoException {
        super(id, genero);
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.idLectura = idLectura;
    }

    public Libro(String nombre, String editorial, String autor, int nPaginas, long idLectura, Elemento el) throws ElementoException {
        super(el);
        this.nombre = nombre;
        this.editorial = editorial;
        this.autor = autor;
        this.nPaginas = nPaginas;
        this.idLectura = idLectura;
    }

    public Libro(Libro l) {
        this.nombre = l.nombre;
        this.editorial = l.editorial;
        this.autor = l.autor;
        this.nPaginas = l.nPaginas;
        this.idLectura = l.idLectura;
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

    public long getIdLectura() {
        return idLectura;
    }

    public void setidLectura(long idLectura) {
        this.idLectura = idLectura;
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

    public static Libro nuevoLibro() throws LibroException {
        Libro li = new Libro();
        int opcion = 0;
        int idGenero = 0;
        Genero gen;

        ArrayList<Libro> libros = Libro.convertirLibros(Utilidades.LIBROS);
        ArrayList<Genero> generos = Genero.convertirGeneros(Utilidades.GENEROS);

        Scanner teclado = new Scanner(System.in);
        System.out.println("Indica su nombre: ");
        String nombre=teclado.nextLine();
        if(LibroException.validarNombre(nombre)){
        li.setNombre(nombre);
        }else{
        throw new LibroException("El nombre solo puede contener letras");
        }
        System.out.println("Indica la editorial: ");
        String editorial=teclado.nextLine();
        if(LibroException.validarEditorial(editorial)){
        li.setEditorial(editorial);
        }else{
        throw new LibroException("La editorial solo puede contener letras");
        }
        System.out.println("Indica el autor: ");
        String autor=teclado.nextLine();
        if(LibroException.validarAutor(autor)){
        li.setAutor(autor);
        }else{
        throw new LibroException("El autor solo puede contener letras");
        }
        System.out.println("Indica el numero de paginas: ");
        int npaginas=teclado.nextInt();
        if(LibroException.validarNPaginas(npaginas)){
        li.setnPaginas(npaginas);
        }else{
        throw new LibroException("El nPaginas debe ser >0");
        }
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
    
    public static void buscarLibros(ArrayList<Libro> Libros) {
        Libro buscado;
        ArrayList<Libro> encontrados;
        Scanner in;
        int opcion = -1;

        do {
            buscado = null;
            encontrados = new ArrayList<Libro>();
            in = new Scanner(System.in, "ISO-8859-1");
            System.out.println("Pulse 1 para buscar Libro por Nombre.");
            System.out.println("Pulse 2 para buscar Libro por Autor.");
            System.out.println("Pulse 3 para buscar Libro por Editorial.");
            System.out.println("Pulse 0 para VOLVER");
            opcion = in.nextInt();
            if (opcion < 0 || opcion > 3) {
                System.out.println("Opción incorrecta.");
                continue;
            }
            in = new Scanner(System.in, "ISO-8859-1");
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    System.out.println("-------------------------------------------------");
                    System.out.println("Introduzca el Nombre del Libro a buscar:");
                    String NombreLib = in.nextLine();
                    encontrados = Libro.buscarLibrosPorNombre(NombreLib, Libros);
                    if (encontrados.size() > 0) {
                        System.out.println("-------------------------------------------------");
                        System.out.println("Hay coincidencias: ");
                        for (Libro lib : encontrados) {
                            System.out.println("-------------------------------------------------");
                            System.out.println("<" + lib.getNombre()+">  escrito por " + lib.getAutor()+ " editado por " + lib.getEditorial());
                            System.out.println("-------------------------------------------------");
                        }
                    } else {
                        System.out.println("-------------------------------------------------");
                        System.out.println("Libro  " + NombreLib + "  NO ENCONTRADO.");
                    }
                    break;
                     case 2:
                    System.out.println("-------------------------------------------------");
                    System.out.println("Introduzca el Autor del Libro a buscar:");
                    String AutorLib = in.nextLine();
                    encontrados = Libro.buscarLibrosPorAutor(AutorLib, Libros);
                    if (encontrados.size() > 0) {
                        System.out.println("-------------------------------------------------");
                        System.out.println("Hay coincidencias: ");
                        for (Libro lib : encontrados) {
                            System.out.println("-------------------------------------------------");
                            System.out.println("<" + lib.getNombre()+">  escrito por " + lib.getAutor()+ " editado por " + lib.getEditorial());
                            System.out.println("-------------------------------------------------");
                        }
                    } else {
                        System.out.println("-------------------------------------------------");
                        System.out.println("Autor  " + AutorLib + "  NO ENCONTRADO.");
                    }
                    break;
                     case 3:
                    System.out.println("-------------------------------------------------");
                    System.out.println("Introduzca la Editorial del Libro a buscar:");
                    String EditorialLib = in.nextLine();
                    encontrados = Libro.buscarLibrosPorEditorial(EditorialLib, Libros);
                    if (encontrados.size() > 0) {
                        System.out.println("-------------------------------------------------");
                        System.out.println("Hay coincidencias: ");
                        for (Libro lib : encontrados) {
                            System.out.println("-------------------------------------------------");
                            System.out.println("<" + lib.getNombre()+">  escrito por " + lib.getAutor()+ " editado por " + lib.getEditorial());
                            System.out.println("-------------------------------------------------");
                        }
                    } else {
                        System.out.println("-------------------------------------------------");
                        System.out.println("Editorial " + EditorialLib + "  NO ENCONTRADO.");
                    }
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
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
    public String data() {
        return nombre + "|" + editorial + "|" + autor + "|" + nPaginas;
    }

    @Override
    public String toString() {
        return "Libro{" + "nombre=" + nombre + ", editorial=" + editorial + ", autor=" + autor + ", nPaginas=" + nPaginas + ", idLectura=" + idLectura + '}';
    }

}
