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
public class Visionado extends Evento {

    /*
    Valores validos: Caracteres alfanumericos.
    Valores invalidos: Caracteres especiales.
    Otras restricciones: Longitud max 20 caracteres.
     */
    private String aula;

    public Visionado() {
        super();
        this.aula = aula;
    }

    public Visionado(String aula) {
        this.aula = aula;
    }

    public Visionado(Evento e, String aula) {
        super(e);
        this.aula = aula;
    }

    public Visionado(Visionado v1) {
        this.aula = v1.aula;
    }

    public Visionado(String aula, long id, String nombre, Date fechayhora, long idPenalizacion) {
        super(id, nombre, fechayhora, idPenalizacion);
        this.aula = aula;
    }

    public Visionado(String aula, Evento ev1) {
        super(ev1);
        this.aula = aula;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    /*Esto esta editado*/
    public static long nextIdVisionado() {
        long ret = 0;
        for (int i = 0; i < Utilidades.VISIONADOS.length; i++) {
            if (Utilidades.VISIONADOS[i].id > ret) {
                ret = Utilidades.VISIONADOS[i].id;
            }
        }
        return ret + 1;
    }

    /*Esto esta editado*/
    public static Visionado nuevoVisionado() {
        Visionado v1 = new Visionado();
        Scanner in = new Scanner(System.in);
        long idEven = nextIdVisionado();
        v1.setId(idEven);
        System.out.println("Introduzca el nombre del evento");
        String nombre = in.nextLine();
        v1.setNombre(nombre);
        System.out.println("Introduzca los datos del aula en el que se va a ver el DVD");
        String aula = in.nextLine();
        v1.setAula(aula);
        System.out.println("Introduzca la fecha y la hora del evento");
        java.sql.Date fechayhora = Utilidades.Fecha.nuevaFecha().conversorFecha();
        v1.setFechayhora(fechayhora);

        return v1;
    }

    public static ArrayList<Visionado> convertirVisionado(Visionado[] array) {
        ArrayList<Visionado> ret = new ArrayList<Visionado>();
        for (Visionado s : array) {
            ret.add(s);

        }
        return ret;
    }

    public static void verVisionado(ArrayList<Visionado> visionados) {
        System.out.println("Visionados de la biblioteca:");
        for (Visionado c : visionados) {
            System.out.println(c.getId() + ".- " + (c.getAula()));
        }
    }

    public static void buscarVisionado(ArrayList<Visionado> visionados) {
        Visionado buscado;
        ArrayList<Visionado> encontrados;
        Scanner in;
        int opcion = -1;
        do {
            buscado = null;
            encontrados = new ArrayList<Visionado>();
            in = new Scanner(System.in, "ISO-8859-1");
            System.out.println("Pulse 1 para buscar visionado por AULA.");
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
                    System.out.println("Introduzca el AULA del Visionado a encontrar:");
                    String nomAula = in.nextLine();
                    encontrados = Visionado.buscarVisionadoPorAula(nomAula, visionados);
                    if (encontrados.size() > 0) {
                        System.out.println("Hay coincidencias: ");
                        for (Visionado e : encontrados) {
                            System.out.println(e.getAula());
                        }
                    } else {
                        System.out.println("Socio con nombre=" + nomAula + " NO ENCONTRADO.");
                    }
                    System.out.println("");
                    break;

            }

        } while (opcion != 0);
    }

    public static ArrayList<Visionado> buscarVisionadoPorAula(String aula, ArrayList<Visionado> visionados) {
        ArrayList<Visionado> ret = new ArrayList<Visionado>();
        for (Visionado e : visionados) {
            if (Utilidades.removeDiacriticalMarks(e.getAula().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(aula.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getAula().toLowerCase().contains(aula.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Visionado{" + "aula=" + aula + '}';
    }
    public String data() {
        return id + "|" + nombre + "|" + fechayhora + "|" + idPenalizacion + "|" + aula;
    }
}
