/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Validaciones.ConcursoException;
import Validaciones.EventoException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DAM102
 */
public class Concurso extends Evento {

    /*
    Valores validos: Caracteres alfanumericos.
    Valores invalidos: Caracteres especiales.
    Otras restricciones: Longitud max 30 caracteres.
     */
    private String tipo;
    /*
    Valores validos: Caracteres alfanumericos.
    Valores invalidos: Caracteres especiales.
    Otras restricciones: Longitud max 30 caracteres.
     */
    private String premio;

    public Concurso() {
        super();
    }

    public Concurso(String tipo, String premio) {
        this.tipo = tipo;
        this.premio = premio;
    }
    public Concurso(Evento e, String tipo, String premio) {
        super(e);
        this.tipo = tipo;
        this.premio = premio;
    }
    public Concurso(Concurso co1) {
        this.tipo = co1.tipo;
        this.premio = co1.premio;
    }

    public Concurso(String tipo, String premio, long id, String nombre, Date fechayhora, long idPenalizacion) {
        super(id, nombre, fechayhora, idPenalizacion);
        this.tipo = tipo;
        this.premio = premio;
    }

    public Concurso(String tipo, String premio, Evento ev1) {
        super(ev1);
        this.tipo = tipo;
        this.premio = premio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }
/*Esto esta editado*/
    public static long nextIdConcurso() {
        long ret = 0;
        for (int i = 0; i < Utilidades.CONCURSOS.length; i++) {
            if (Utilidades.CONCURSOS[i].id > ret) {
                ret = Utilidades.CONCURSOS[i].id;
            }
        }
        return ret + 1;
    }
/*Esto esta editado*/
    public static Concurso nuevoConcurso() throws ConcursoException{
        //Evento e = Evento.nuevoEvento();
        Concurso c1 = new Concurso();
        Scanner in = new Scanner(System.in);
        long idEven = nextIdConcurso();
        if (EventoException.validarId(idEven)){
            c1.setId(idEven);
        } else {
            System.out.println("No se ha introducido correctamente el id");
        }
        System.out.println("Introduzca el tipo de concurso");
        String tipo = in.nextLine();
        if (ConcursoException.validarTipo(tipo)){
            c1.setTipo(tipo);
        } else {
            System.out.println("No se ha introducido correctamente el tipo de concurso");
        }
        System.out.println("Introduzca el premio del concurso");
        String premio = in.nextLine();
        if (ConcursoException.validarPremio(premio)){
            c1.setPremio(premio);
        } else {
            System.out.println("No se ha introducido correctamente el premio del concurso");
        }
        System.out.println("Introduzca el nombre del evento");
        String nombre = in.nextLine();
        if (EventoException.validarNombre(nombre)) {
            c1.setNombre(nombre);
        } else {
            System.out.println("Has introducido mal el nombre del evento");
        }
        System.out.println("Introduzca la fecha y la hora del evento");
        java.sql.Date fechayhora = Utilidades.Fecha.nuevaFecha().conversorFecha();
        c1.setFechayhora(fechayhora);
        //Mas adelante mejorar al introducir validaciones
        return c1;
    }

    public static ArrayList<Concurso> convertirConcurso(Concurso[] array) {
        ArrayList<Concurso> ret = new ArrayList<Concurso>();
        for (Concurso s : array) {
            ret.add(s);

        }
        return ret;
    }

    public static void verConcurso(ArrayList<Concurso> concursos) {
        System.out.println("Concursos de la biblioteca:");
        for (Concurso c : concursos) {
            System.out.println(c.getId() + ".- " + (c.getTipo() + " - " + (c.getPremio())));
        }
    }

    public static void buscarConcurso(ArrayList<Concurso> concursos) {
        Concurso buscado;
        ArrayList<Concurso> encontrados;
        Scanner in;
        int opcion = -1;
        do {
            buscado = null;
            encontrados = new ArrayList<Concurso>();
            in = new Scanner(System.in, "ISO-8859-1");
            System.out.println("Pulse 1 para buscar concurso por TIPO.");
            System.out.println("Pulse 2 para buscar concurso por PREMIO.");
            System.out.println("Pulse 0 para VOLVER.");
            opcion = in.nextInt();
            if (opcion < 0 || opcion > 2) {
                System.out.println("Opción incorrecta.");
                continue;
            }
            in = new Scanner(System.in, "ISO-8859-1");
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    System.out.println("Introduzca el TIPO del Concurso a encontrar:");
                    String nomTipo = in.nextLine();
                    encontrados = Concurso.buscarConcursoPorTipo(nomTipo, concursos);
                    if (encontrados.size() > 0) {
                        System.out.println("Hay coincidencias: ");
                        for (Concurso e : encontrados) {
                            System.out.println(e.getTipo() + ". " + e.getPremio());
                        }
                    } else {
                        System.out.println("Socio con nombre=" + nomTipo + " NO ENCONTRADO.");
                    }
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Introduzca el PREMIO del Concurso a encontrar:");
                    String nomConc = in.nextLine();
                    encontrados = Concurso.buscarConcursoPorPremio(nomConc, concursos);
                    if (encontrados.size() > 0) {
                        System.out.println("Hay coincidencias: ");
                        for (Concurso e : encontrados) {
                            System.out.println(e.getTipo() + ". " + e.getPremio());
                        }
                    } else {
                        System.out.println("Socio con nombre=" + nomConc + " NO ENCONTRADO.");
                    }
                    System.out.println("");
                    break;

                default:
                    break;
            }

        } while (opcion != 0);
    }

    public static ArrayList<Concurso> buscarConcursoPorPremio(String nomPremio, ArrayList<Concurso> concursos) {
        ArrayList<Concurso> ret = new ArrayList<Concurso>();
        for (Concurso e : concursos) {
            if (Utilidades.removeDiacriticalMarks(e.getPremio().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(nomPremio.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getPremio().toLowerCase().contains(nomPremio.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    public static ArrayList<Concurso> buscarConcursoPorTipo(String nomTipo, ArrayList<Concurso> concursos) {
        ArrayList<Concurso> ret = new ArrayList<Concurso>();
        for (Concurso e : concursos) {
            if (Utilidades.removeDiacriticalMarks(e.getTipo().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(nomTipo.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getTipo().toLowerCase().contains(nomTipo.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Concurso{" + "tipo=" + tipo + ", premio=" + premio + '}';
    }
    
    
      /**
     * Atributos separados por el caracter |
     * @return | nombre + telefono
     */
    public String data() {
        return id + "|" + nombre + "|" + fechayhora + "|" + idPenalizacion + "|" + tipo + "|" + premio;
    }
     
}
