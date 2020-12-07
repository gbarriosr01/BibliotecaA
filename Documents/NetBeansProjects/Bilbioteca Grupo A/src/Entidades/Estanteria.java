/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author DAM102
 */
public class Estanteria {
    
    private long id;
    private char Codigo;
    private String Ubicacion;
    private boolean Completa;
    private ArrayList <Elemento> elementos = new ArrayList <Elemento>();

    public Estanteria() {
    }

    public Estanteria(long id, char Codigo, String Ubicacion, boolean Completa) {
        this.id = id;
        this.Codigo = Codigo;
        this.Ubicacion = Ubicacion;
        this.Completa = Completa;
    }
    
    public Estanteria(Estanteria e) {
        this.id = e.id;
        this.Codigo = e.Codigo;
        this.Ubicacion = e.Ubicacion;
        this.Completa = e.Completa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public char getCodigo() {
        return Codigo;
    }

    public void setCodigo(char Codigo) {
        this.Codigo = Codigo;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public boolean isCompleta() {
        return Completa;
    }

    public void setCompleta(boolean Completa) {
        this.Completa = Completa;
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

    @Override
    public String toString() {
        return "Estanteria{" + "id=" + id + ", Codigo=" + Codigo + ", Ubicacion=" + Ubicacion + ", Completa=" + Completa + ", elementos=" + elementos + '}';
    }
    
    
    
}
