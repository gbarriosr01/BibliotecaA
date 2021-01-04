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
public class Prestamo {
   
    private long id;
    private Date fechaDeInicio;
    private Date fechaDeDevolucion;
    private Estado estado;
    private ArrayList<Elemento> elementos = new ArrayList<Elemento>(); /*Maximo 5, Obligatorio*/
    private long idPenalizacion;

    public Prestamo() {
    }

    public Prestamo(Prestamo copia){
        this.id = copia.id;
        this.fechaDeInicio = copia.fechaDeInicio;
        this.fechaDeDevolucion = copia.fechaDeDevolucion;
        this.estado = copia.estado;
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
    
    public Prestamo nuevoPrestamo(){
        Prestamo prestamo1 = new Prestamo();
        
        Scanner in = new Scanner(System.in);
        System.out.println("Inserte su Id");
        int id = in.nextInt();
        prestamo1.setId(id);
        
        
        return prestamo1;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", fechaDeInicio=" + fechaDeInicio + ", fechaDeDevolucion=" + fechaDeDevolucion + ", estado=" + estado + ", elementos=" + elementos + ", idPenalizacion=" + idPenalizacion + '}';
    }
    
}
