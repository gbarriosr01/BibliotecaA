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
public class Visionado extends Evento{
    private String aula;

    public Visionado() {
        super();
    }

    public Visionado(String aula) {
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
    public Visionado nuevoVisionado(){
        Visionado v1 = new Visionado();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduzca los datos del visionados");
        System.out.println("Introduzca los datos del aula");
        String aula = in.nextLine();
        v1.setAula(aula);
        return v1;
    }

    @Override
    public String toString() {
        return "Visionado{" + "aula=" + aula + '}';
    }
}
