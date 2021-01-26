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
public class DVD extends Elemento{
    /*Valido: cadena caracteres "dsadsa" Invalido: " ", >100caracteres*/
    private String titulo=null;
    private Visionado visionado;/*Obligatorio*/

    public DVD() {
        super();
    }

    public DVD(String titulo) {
        this.titulo = titulo;
    }

    public DVD(String titulo, Visionado visionado) {
        this.titulo = titulo;
        this.visionado = visionado;
    }

    public DVD(String titulo, Visionado visionado, long id, Genero genero) {
        super(id, genero);
        this.titulo = titulo;
        this.visionado = visionado;
    }

    public DVD(String titulo, Visionado visionado, Elemento el) {
        super(el);
        this.titulo = titulo;
        this.visionado = visionado;
    }

    public DVD(DVD d) {
        this.titulo = d.titulo;
        this.visionado = d.visionado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Visionado getVisionado() {
        return visionado;
    }

    public void setVisionado(Visionado visionado) {
        this.visionado = visionado;
    }
    
    public static ArrayList<DVD> convertirDVDS(DVD[] array) {
        ArrayList<DVD> ret = new ArrayList<DVD>();
        for (DVD s : array) {
            ret.add(s);
        }

        return ret;
    }

    
    public static DVD nuevoDVD() {
        DVD d = new DVD();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Indica el titulo: ");
        d.setTitulo(teclado.nextLine());
        System.out.println("Indica el ID del DVD");
        d.setId(teclado.nextLong());
        return d;
    
    }
    public static void verDvd(ArrayList<DVD> DVDS) {
        System.out.println("DVD de la biblioteca:");
        for (DVD s : DVDS) {
            System.out.println(s.getId() + ".- " + (s.getTitulo()));
        }

    }
    @Override
    public String toString() {
        return "DVD{" + "titulo=" + titulo + ", visionado=" + visionado + '}';
    }
    
    
}
