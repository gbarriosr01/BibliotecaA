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
public class Genero {

    //Valores válidos,  >0
    //Valores inválidos, <=0
    //Tiene que ser único
    private long id;
    //Valores válidos,  <=20
    //Valores inválidos, >20
    //No admite numeros
    private String nombre;

    public Genero() {

    }

    public Genero(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Genero(Genero g1) {
        this.id = g1.id;
        this.nombre = g1.nombre;

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

    public Genero nuevoGenero() {
        Genero g1 = new Genero();
        Scanner in = new Scanner(System.in);

        int numGeneros = Utilidades.numGeneros + 1;
        g1.setId(numGeneros);

        System.out.println("Inserte su nombre");
        String nombre = in.nextLine();
        g1.setNombre(nombre);

        return g1;
    }

    public static ArrayList<Genero> convertirGeneros(Genero[] array) {
        ArrayList<Genero> ret = new ArrayList<Genero>();
        for (Genero s : array) {
            ret.add(s);
        }

        return ret;
    }

    public static void verGenero(ArrayList<Genero> generos) {
        System.out.println("Generos de la biblioteca:");
        for (Genero s : generos) {
            System.out.println(s.getId() + " - " + (s.getNombre() + "."));
        }

    }

    public static Genero buscarGenerosPorId(int idGenero, ArrayList<Genero> generos) {
        Genero ret = null;
        for (Genero s : generos) {
            if (s.getId() == idGenero) {

                ret = s;
                break;
            }

        }
        return ret;
    }

    public void verGeneroElemento() {
        System.out.println( this.getNombre());
    }

    @Override
    public String toString() {
        return "Genero{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
