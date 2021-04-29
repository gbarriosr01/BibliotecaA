/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Validaciones.EventoException;
import Validaciones.LecturaException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author DAM102
 */
public class Lectura extends Evento {

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

    }

    public Lectura(boolean leido, String modelo) {
        this.leido = false;
        this.modelo = modelo;
    }

    public Lectura(Evento e, boolean leido, String modelo) {
        super(e);
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

    /*Esto esta editado*/
    public static long nextIdLectura() {
        long ret = 0;
        for (int i = 0; i < Utilidades.LECTURAS.length; i++) {
            if (Utilidades.LECTURAS[i].id > ret) {
                ret = Utilidades.LECTURAS[i].id;
            }
        }
        return ret + 1;
    }

    /*Esto esta editado*/
    public static Lectura nuevoLectura() throws LecturaException{
        Lectura le1 = new Lectura();
        Scanner in = new Scanner(System.in);
        long idEven = nextIdLectura();
        le1.setId(idEven);
        System.out.println("Introduzca si se ha leido el libro(true/false)");
        boolean leido = in.nextBoolean();
        if (LecturaException.validarLeido(true)) {
            le1.setLeido(leido);
        } else {
            System.out.println("Ha ocurrido un error");
        }
        in.nextLine();
        System.out.println("Introduzca el modelo del libro leido");
        String modelo = in.nextLine();
        if(LecturaException.validarModelo(modelo)){
            le1.setModelo(modelo);
        } else {
            System.out.println("El modelo del libro no es correcto");
        }
        System.out.println("Introduzca el nombre del evento");
        String nombre = in.nextLine();
        if(EventoException.validarNombre(nombre)){
            le1.setNombre(nombre);
        } else {
            System.out.println("Has introducido mal el nombre del evento");
        }
        System.out.println("Introduzca la fecha y la hora del evento");
        java.sql.Date fechayhora = Utilidades.Fecha.nuevaFecha().conversorFecha();
        le1.setFechayhora(fechayhora);
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
            System.out.println(c.getId() + ".- " + c.getNombre() + " - " + (c.getModelo() + " - ¿Se ha leido? " + (c.isLeido())));
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

    /**
     * Devuelve primero la primary key, seguido de los demas atributos separados
     * por el caracter |
     *
     * @return Primary key id | Fechallegada + ArrayList de elementos +
     * idProveedor
     */
    public String data() {
        return id + "|" + nombre + "|" + fechayhora + "|" + idPenalizacion + "|" + leido + "|" + modelo;
    }
}
