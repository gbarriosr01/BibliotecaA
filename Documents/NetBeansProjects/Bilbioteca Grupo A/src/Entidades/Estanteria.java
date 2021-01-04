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
public class Estanteria {
    
    private long id;
    private char codigo;
    private String ubicacion;
    private boolean completa;
    private ArrayList <Elemento> elementos = new ArrayList <Elemento>();

    public Estanteria() {
    }

    public Estanteria(long id, char codigo, String ubicacion, boolean completa) {
        this.id = id;
        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.completa = completa;
    }

    public Estanteria(Estanteria e) {
        this.id = e.id;
        this.codigo = e.codigo;
        this.ubicacion = e.ubicacion;
        this.completa = e.completa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getCodigo() {
        return codigo;
    }

    public void setCodigo(char codigo) {
        this.codigo = codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public boolean isCompleta() {
        return completa;
    }

    public void setCompleta(boolean completa) {
        this.completa = completa;
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }
    
    public static Estanteria nuevaEstanteria() {
        Estanteria es = new Estanteria();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escribe id: ");
        es.setId(teclado.nextLong());
        System.out.println("Escribe codigo: ");
        es.setCodigo(teclado.nextLine().charAt(0));
        System.out.println("Escribe ubicacion: ");
        es.setUbicacion(teclado.nextLine());
        System.out.println("Indica si la estanteria esta completa: ");
        es.setCompleta(teclado.nextBoolean());
        return es;
    
    }

    @Override
    public String toString() {
        return "Estanteria{" + "id=" + id + ", codigo=" + codigo + ", ubicacion=" + ubicacion + ", completa=" + completa + ", elementos=" + elementos + '}';
    }
    
    
    
}
