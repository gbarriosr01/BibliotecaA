/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

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
    
}
