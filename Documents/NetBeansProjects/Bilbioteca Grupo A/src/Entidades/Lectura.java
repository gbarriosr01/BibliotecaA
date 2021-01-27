/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
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
        this.leido = false;
        this.modelo = null;
    }
    
    public Lectura(boolean leido, String modelo) {
        this.leido = false;
        this.modelo = modelo;
    }
    
    public Lectura(Lectura l1) {
        this.leido = l1.leido;
        this.modelo = l1.modelo;
    }
    
    public Lectura(boolean leido, String modelo, long id, String nombre, Date fechayhora, long idPenalizacion) {
        super(id, nombre, fechayhora, idPenalizacion);
        this.leido = false;
        this.modelo = modelo;
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
       
        System.out.println("Introduzca si se ha leido el libro");
        boolean leido = in.nextBoolean();
        le1.setLeido(leido);
        System.out.println("Introduzca el modelo del libro leido");
        String modelo = in.nextLine();
        le1.setModelo(modelo);
        return le1;
    }
    
    public static ArrayList<Lectura> convertirLectura(Lectura[] array) {
        ArrayList<Lectura> ret = new ArrayList<Lectura>();
        for (Lectura s : array) {
            ret.add(s);
       
        }
        return ret;
    }


    public static void verLectura(ArrayList<Lectura> lecturas) {
        System.out.println("Lecturas de la biblioteca:");
        for (Lectura c : lecturas) {
            System.out.println(c.getId() + ".- " + (c.isLeido() + " - " + (c.getModelo())));
        }
    }
    
    public static void buscarLectura(ArrayList<Lectura> lecturas) {
        Lectura buscado;
        ArrayList<Lectura> encontrados;
        Scanner in;
        int opcion = -1;
        do {
            buscado = null;
            encontrados = new ArrayList<Lectura>();
            in = new Scanner(System.in, "ISO-8859-1");
            System.out.println("Pulse 1 para buscar Lectura por MODELO de libro.");
            System.out.println("Pulse 0 para VOLVER.");
            opcion = in.nextInt();
            if (opcion < 0 || opcion > 1) {
                System.out.println("Opción incorrecta.");
                continue;
            }
            in = new Scanner(System.in, "ISO-8859-1");
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    System.out.println("Introduzca el Modelo del Concurso a encontrar:");
                    String nomModelo = in.nextLine();
                    encontrados = Lectura.buscarLecturaPorModelo(nomModelo, lecturas);
                    if (encontrados.size() > 0) {
                        System.out.println("Hay coincidencias: ");
                        for (Lectura e : encontrados) {
                            System.out.println(e.getModelo());
                        }
                    } else {
                        System.out.println("Lectura con nombre=" + nomModelo + " NO ENCONTRADO.");
                    }
                    System.out.println("");
                    break;
               
            }

        } while (opcion != 0);
    }
    
     public static ArrayList<Lectura> buscarLecturaPorModelo(String nomModelo, ArrayList<Lectura> lecturas) {
        ArrayList<Lectura> ret = new ArrayList<Lectura>();
        for (Lectura e : lecturas) {
            if (Utilidades.removeDiacriticalMarks(e.getModelo().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(nomModelo.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getModelo().toLowerCase().contains(nomModelo.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Lectura{" + "leido=" + leido + ", modelo=" + modelo + '}';
    }
}