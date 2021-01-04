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
public class Curso extends Evento{
    private String duracion;
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
        this.duracion = duracion;
        this.aula = aula;
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
        System.out.println("Introduzca los datos del curso");
        System.out.println("Introduzca la duracion del curso");
        String duracion = in.nextLine();
        cu1.setDuracion(duracion);
        System.out.println("Introduzca el aula del curso");
        String aula = in.nextLine();
        cu1.setAula(aula);
        return cu1;
    }

    @Override
    public String toString() {
        return "Curso{" + "duracion=" + duracion + ", aula=" + aula + '}';
    }
}

