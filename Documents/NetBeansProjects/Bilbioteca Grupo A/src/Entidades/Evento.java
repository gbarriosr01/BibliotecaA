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
public class Evento {
    protected long ID;
    protected String Nombre;
    protected Date Fecha;
    protected long IDPenalizaion;
    protected ArrayList<Socio> socios = new ArrayList<Socio>();/*Obligatorio*/
    
    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public long getIDPenalizaion() {
        return IDPenalizaion;
    }

    public void setIDPenalizaion(long IDPenalizaion) {
        this.IDPenalizaion = IDPenalizaion;
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public void setSocios(ArrayList<Socio> socios) {
        this.socios = socios;
    }

    public Evento() {
    }
    
}
