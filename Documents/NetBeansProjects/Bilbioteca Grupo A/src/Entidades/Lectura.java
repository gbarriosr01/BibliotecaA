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
public class Lectura extends Evento{
    private boolean leido;
    private String modelo;

    public Lectura() {
        super();
    }
    
    public Lectura(boolean leido, String modelo) {
        this.leido = leido;
        this.modelo = modelo;
    }
    
    public Lectura(Lectura l1) {
        this.leido = l1.leido;
        this.modelo = l1.modelo;
    }
    
    public Lectura(boolean leido, String modelo, long id, String nombre, Date fechayhora, long idPenalizacion) {
        super(id, nombre, fechayhora, idPenalizacion);
        this.leido = leido;
        this.modelo = modelo;
    }

    public Lectura(boolean leido, String modelo, Evento ev1) {
        super(ev1);
        this.leido = leido;
        this.modelo = modelo;
    }


    public boolean isLeido() {
        return leido;
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
}