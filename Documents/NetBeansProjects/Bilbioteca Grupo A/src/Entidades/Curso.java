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
public class Curso extends Evento{
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
    public Curso nuevoCurso(){
        Curso cu1 = new Curso();
        Scanner in = new Scanner(System.in);
        
        
       
        System.out.println("Introduzca la duracion del curso");
        String duracion = in.nextLine();
        cu1.setDuracion(duracion);
        System.out.println("Introduzca el aula en el que se realiza el curso");
        String aula = in.nextLine();
        cu1.setAula(aula);
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

    @Override
    public String toString() {
        return "Curso{" + "duracion=" + duracion + ", aula=" + aula + '}';
    }
}

