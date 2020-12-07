/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author DAM102
 */
public class Prestamo {
   
    private long id;
    private Date fechaDeInicio;
    private Date fechaDeDevolucion;
    private Estado estado;
    private ArrayList<Socio> Socios = new ArrayList<Socio>();
    private ArrayList<Elemento> Elementos = new ArrayList<Elemento>();
    private long idPenalizacion;

    public Prestamo() {
    }

    public long getIdPenalizacion() {
        return idPenalizacion;
    }

    public void setIdPenalizacion(long idPenalizacion) {
        this.idPenalizacion = idPenalizacion;
    }

    public long getId() {
        return id;
    }

    public Date getFechaDeInicio() {
        return fechaDeInicio;
    }

    public Date getFechaDeDevolucion() {
        return fechaDeDevolucion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public void setFechaDeDevolucion(Date fechaDeDevolucion) {
        this.fechaDeDevolucion = fechaDeDevolucion;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public ArrayList<Socio> getSocios() {
        return Socios;
    }

    public void setSocios(ArrayList<Socio> Socios) {
        this.Socios = Socios;
    } 
}
