/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Validaciones.PrestamoException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DAM102
 */
public class Prestamo implements Serializable{
   
    private long id;/*Mayores que 0, no puede ser nulo*/
    private Date fechaDeInicio;
    /*Fecha de hoy
    LocalDate.now();
    */
    private Date fechaDeDevolucion;
    /*Fecha en la cual finalizo el prestamo
    LocalDate.now();
    */
    private Estado estado;
    private ArrayList<Elemento> elementos = new ArrayList<Elemento>(); /*Maximo 5, Obligatorio*/
   

    public Prestamo() {
        
    }

    public Prestamo(long id, Date fechaDeInicio, Date fechaDeDevolucion) {
        this.id = id;
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeDevolucion = fechaDeDevolucion;
    }
    
    public Prestamo(Prestamo copia){
        this.id = copia.id;
        this.fechaDeInicio = copia.fechaDeInicio;
        this.fechaDeDevolucion = copia.fechaDeDevolucion;
        this.estado = copia.estado;
        this.elementos = copia.elementos;
        
    }

    public Prestamo(long id, Date fechaDeInicio, Date fechaDeDevolucion, Estado estado, long idPenalizacion) {
        this.id = id;
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeDevolucion = fechaDeDevolucion;
        this.estado = estado;
        
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

    public void setId(int id) {
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
        Prestamo ret = new Prestamo();

        Scanner in = new Scanner(System.in);
        
       int numPrestamos = Utilidades.numPrestamos + 1;
            ret.setId(numPrestamos);

        System.out.println("Introduzca la fecha de inicio del prestamo");

        java.sql.Date fecha = Utilidades.Fecha.nuevaFecha().conversorFecha();
        ret.setFechaDeInicio(fecha);

        System.out.println("Introduzca la fecha de finalizacion del prestamo");
        java.sql.Date devolucion = Utilidades.Fecha.nuevaFecha().conversorFecha();
        ret.setFechaDeDevolucion(devolucion);


        return ret;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", fechaDeInicio=" + fechaDeInicio + ", fechaDeDevolucion=" + fechaDeDevolucion + ", estado=" + estado + ", elementos=" + elementos + ", idPenalizacion=" +'}';
    }
     /**
     * Devuelve primero la primary key, seguido de los demas atributos separados por el caracter |
     * @return Primary key id | FechadeInicio + fechaDevoluion + idPenalizacion
     */
    public String data() {
        return id + "|" + fechaDeInicio + "|" + fechaDeDevolucion;
    }
    
}
