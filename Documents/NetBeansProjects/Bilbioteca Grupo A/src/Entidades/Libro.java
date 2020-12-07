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
public class Libro extends Elemento{
    
    private String Nombre;
    private String Editorial;
    private String Autor;
    private int nPaginas;
    private Lectura lectura;

    public Libro() {
        super();
    }

    public Libro(String Nombre, String Editorial, String Autor, int nPaginas, Lectura lectura) {
        this.Nombre = Nombre;
        this.Editorial = Editorial;
        this.Autor = Autor;
        this.nPaginas = nPaginas;
        this.lectura = lectura;
    }

    public Libro(String Nombre, String Editorial, String Autor, int nPaginas, Lectura lectura, long id, Genero genero) {
        super(id, genero);
        this.Nombre = Nombre;
        this.Editorial = Editorial;
        this.Autor = Autor;
        this.nPaginas = nPaginas;
        this.lectura = lectura;
    }

    public Libro(String Nombre, String Editorial, String Autor, int nPaginas, Lectura lectura, Elemento el) {
        super(el);
        this.Nombre = Nombre;
        this.Editorial = Editorial;
        this.Autor = Autor;
        this.nPaginas = nPaginas;
        this.lectura = lectura;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
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

    @Override
    public String toString() {
        return "Libro{" + "Nombre=" + Nombre + ", Editorial=" + Editorial + ", Autor=" + Autor + ", nPaginas=" + nPaginas + ", lectura=" + lectura + '}';
    }

    
}
