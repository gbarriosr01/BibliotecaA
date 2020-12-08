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
    private ArrayList<Socio> socios = new ArrayList<Socio>();/*Obligatorio*/
    private ArrayList<Elemento> elementos = new ArrayList<Elemento>(); /*Maximo 5, Obligatorio*/
    private long idPenalizacion;

    public Prestamo() {
    }

    public Prestamo(Prestamo copia){
        this.id = copia.id;
        this.fechaDeInicio = copia.fechaDeInicio;
        this.fechaDeDevolucion = copia.fechaDeDevolucion;
        this.estado = copia.estado;
        this.socios = copia.socios;
        this.elementos = copia.elementos;
        this.idPenalizacion = copia.idPenalizacion;
    }

    public Prestamo(long id, Date fechaDeInicio, Date fechaDeDevolucion, Estado estado, long idPenalizacion) {
        this.id = id;
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeDevolucion = fechaDeDevolucion;
        this.estado = estado;
        this.idPenalizacion = idPenalizacion;
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

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
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
        return socios;
    }

    public void setSocios(ArrayList<Socio> Socios) {
        this.socios = Socios;
    } 
}
