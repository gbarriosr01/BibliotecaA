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
public class Concurso extends Evento {
    private String tipo;
    private String premio;

    public Concurso() {
        super();
    }

    public Concurso(String tipo, String premio) {
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
    public Concurso nuevoConcurso(){
        Concurso c1 = new Concurso();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduzca los datos del concurso");
        System.out.println("Introduzca el tipo de concurso");
        String tipo = in.nextLine();
        c1.setTipo(tipo);
        System.out.println("Introduzca el premio del concurso");
        String premio = in.nextLine();
        c1.setPremio(premio);
        return c1;
    }

    @Override
    public String toString() {
        return "Concurso{" + "tipo=" + tipo + ", premio=" + premio + '}';
    }
}
