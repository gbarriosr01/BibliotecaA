/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DAM102
 */
public class Lectura extends Evento{
    /*
    Valores validos: Verdadero y falso.
    Valores invalidos: Cualquier tipo de caracter que no sea T o F.
    */
    private boolean leido;
    /*
    Valores validos: Caracteres alfanumericos.
    Valores invalidos: Caracteres especiales.
    Otras restricciones: Longitud max 30 caracteres.
    */
    private String modelo;

    public Lectura() {
        super();
        this.leido = leido = false;
        this.modelo = modelo = null;
    }
    
    public Lectura(boolean leido, String modelo) {
        this.leido = leido = false;
        this.modelo = modelo = null;
    }
    
    public Lectura(Lectura l1) {
        this.leido = l1.leido;
        this.modelo = l1.modelo;
    }
    
    public Lectura(boolean leido, String modelo, long id, String nombre, Date fechayhora, long idPenalizacion) {
        super(id, nombre, fechayhora, idPenalizacion);
        this.leido = leido = false;
        this.modelo = modelo = null;
    }

    public Lectura(boolean leido, String modelo, Evento ev1) {
        super(ev1);
        this.leido = leido;
        this.modelo = modelo;
    }


    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public Lectura nuevoLectura(){
        Lectura le1 = new Lectura();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduzca los datos de la lectura");
        System.out.println("Introduzca si se ha leido el libro");
        boolean leido = in.nextBoolean();
        le1.setLeido(leido);
        System.out.println("Introduzca el modelo del libro leido");
        String modelo = in.nextLine();
        le1.setModelo(modelo);
        return le1;
    }

    @Override
    public String toString() {
        return "Lectura{" + "leido=" + leido + ", modelo=" + modelo + '}';
    }
}