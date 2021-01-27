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
public class Visionado extends Evento{
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
        
        System.out.println("Introduzca los datos del aula en el que se va a ver el DVD");
        String aula = in.nextLine();
        v1.setAula(aula);
        
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

    @Override
    public String toString() {
        return "Visionado{" + "aula=" + aula + '}';
    }
}
