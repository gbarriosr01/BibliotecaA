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
public class Curso extends Evento {

    /*
    Valores validos: Caracteres alfanumericos.
    Valores invalidos: Caracteres especiales.
    Otras restricciones: Longitud max 15 caracteres.
     */
    private String duracion;
    /*
    Valores validos: Caracteres alfanumericos.
    Valores invalidos: Caracteres especiales.
    Otras restricciones: Longitud max 20 caracteres.
     */
    private String aula;

    public Curso() {
        super();
    }

    public Curso(String duracion, String aula) {
        this.duracion = duracion;
        this.aula = aula;
    }

    public Curso(Evento e, String duracion, String aula) {
        super(e);
        this.duracion = duracion;
        this.aula = aula;
    }

    public Curso(Curso cu1) {
        this.duracion = cu1.duracion;
        this.aula = cu1.aula;
    }

    public Curso(String duracion, String aula, long id, String nombre, Date fechayhora, long idPenalizacion) {
        super(id, nombre, fechayhora, idPenalizacion);
        this.duracion = duracion = null;
        this.aula = aula = null;
    }

    public Curso(String duracion, String aula, Evento ev1) {
        super(ev1);
        this.duracion = duracion;
        this.aula = aula;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    /*Esto esta editado*/
    public static long nextIdCurso() {
        long ret = 0;
        for (int i = 0; i < Utilidades.CURSOS.length; i++) {
            if (Utilidades.CURSOS[i].id > ret) {
                ret = Utilidades.CURSOS[i].id;
            }
        }
        return ret + 1;
    }

    /*Esto esta editado*/

    public static Curso nuevoCurso() {
        Curso cu1 = new Curso();
        Scanner in = new Scanner(System.in);

        long idEven = nextIdCurso();
        cu1.setId(idEven);

        System.out.println("Introduzca la duracion del curso");
        String duracion = in.nextLine();
        cu1.setDuracion(duracion);
        System.out.println("Introduzca el aula en el que se realiza el curso");
        String aula = in.nextLine();
        cu1.setAula(aula);
        System.out.println("Introduzca el nombre del evento");
        String nombre = in.nextLine();
        cu1.setNombre(nombre);
        System.out.println("Introduzca la fecha y la hora del evento");
        java.sql.Date fechayhora = Utilidades.Fecha.nuevaFecha().conversorFecha();
        cu1.setFechayhora(fechayhora);
        return cu1;
    }

    public static ArrayList<Curso> convertirCurso(Curso[] array) {
        ArrayList<Curso> ret = new ArrayList<Curso>();
        for (Curso s : array) {
            ret.add(s);

        }
        return ret;
    }

    public static void verCurso(ArrayList<Curso> cursos) {
        System.out.println("Cursos de la biblioteca:");
        for (Curso c : cursos) {
            System.out.println(c.getId() + ".- " + (c.getDuracion() + " - " + (c.getAula())));
        }
    }

    public static void buscarCurso(ArrayList<Curso> cursos) {
        Curso buscado;
        ArrayList<Curso> encontrados;
        Scanner in;
        int opcion = -1;
        do {
            buscado = null;
            encontrados = new ArrayList<Curso>();
            in = new Scanner(System.in, "ISO-8859-1");
            System.out.println("Pulse 1 para buscar curso por AULA.");
            System.out.println("Pulse 2 para buscar curso por DURACION.");
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
                    System.out.println("Introduzca el AULA del Curso a encontrar:");
                    String nomAula = in.nextLine();
                    encontrados = Curso.buscarCursoPorAula(nomAula, cursos);
                    if (encontrados.size() > 0) {
                        System.out.println("Hay coincidencias: ");
                        for (Curso e : encontrados) {
                            System.out.println(e.getAula() + ". " + e.getDuracion());
                        }
                    } else {
                        System.out.println("Curso de aula=" + nomAula + " NO ENCONTRADO.");
                    }
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Introduzca la DURACUON del Curso a encontrar:");
                    String nomCurs = in.nextLine();
                    encontrados = Curso.buscarCursoPorDuracion(nomCurs, cursos);
                    if (encontrados.size() > 0) {
                        System.out.println("Hay coincidencias: ");
                        for (Curso e : encontrados) {
                            System.out.println(e.getAula() + ". " + e.getDuracion());
                        }
                    } else {
                        System.out.println("Socio con nombre=" + nomCurs + " NO ENCONTRADO.");
                    }
                    System.out.println("");
                    break;

                default:
                    break;
            }

        } while (opcion != 0);
    }

    public static ArrayList<Curso> buscarCursoPorAula(String nomAula, ArrayList<Curso> cursos) {
        ArrayList<Curso> ret = new ArrayList<Curso>();
        for (Curso e : cursos) {
            if (Utilidades.removeDiacriticalMarks(e.getAula().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(nomAula.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getAula().toLowerCase().contains(nomAula.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    public static ArrayList<Curso> buscarCursoPorDuracion(String duracion, ArrayList<Curso> cursos) {
        ArrayList<Curso> ret = new ArrayList<Curso>();
        for (Curso e : cursos) {
            if (Utilidades.removeDiacriticalMarks(e.getDuracion().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(duracion.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getAula().toLowerCase().contains(duracion.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Curso{" + "duracion=" + duracion + ", aula=" + aula + '}';
    }
    
     /**
     * Atributos separados por el caracter |
     * @return  duracion + aula
     */
    public String data() {
        return  "|" + duracion + "|" + aula;
    }
}
