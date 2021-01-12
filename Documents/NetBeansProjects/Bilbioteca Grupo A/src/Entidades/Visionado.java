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
    /*
    Valores validos: Caracteres alfanumericos.
    Valores invalidos: Caracteres especiales.
    Otras restricciones: Longitud max 20 caracteres.
    */
    private String aula;

    public Visionado() {
        super();
        this.aula = aula = null;
    }

    public Visionado(String aula) {
        this.aula = aula = null;
    }
    public Visionado(Visionado v1) {
        this.aula = v1.aula;
    }    
    
    public Visionado(String aula, long id, String nombre, Date fechayhora, long idPenalizacion) {
        super(id, nombre, fechayhora, idPenalizacion);
        this.aula = aula = null;
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
        int id = in.nextInt();
        v1.setId(id);
        System.out.println("Introduzca el nombre del visionado");
        String nombre = in.nextLine();
        v1.setNombre(nombre);
        System.out.println("Introduzca la fecha en la que se va a ver el DVD");
        //        
        System.out.println("Introduzca los datos del aula en el que se va a ver el DVD");
        String aula = in.nextLine();
        v1.setAula(aula);
        return v1;
    }

    @Override
    public String toString() {
        return "Visionado{" + "aula=" + aula + '}';
    }
}
