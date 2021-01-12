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
   
    private int id;/*Mayores o iguales que 0, no puede ser nulo*/
    private Date fechaDeInicio;/*Fecha en la cual hizo el prestamo, valor por defecto "1/1/2020"*/
    private Date fechaDeDevolucion;/*Fecha en la cual finalizo el prestamo, valor por defecto "1/1/2020"*/
    private Estado estado;
    private ArrayList<Elemento> elementos = new ArrayList<Elemento>(); /*Maximo 5, Obligatorio*/
    private int idPenalizacion;/*Mayores o iguales que 0, no puede ser nulo*/

    public Prestamo() {
        this.id= 0;
        this.idPenalizacion= 0;
    }

    public Prestamo(int id, Date fechaDeInicio, Date fechaDeDevolucion) {
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
        this.idPenalizacion = copia.idPenalizacion;
    }

    public Prestamo(int id, Date fechaDeInicio, Date fechaDeDevolucion, Estado estado, int idPenalizacion) {
        this.id = id;
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeDevolucion = fechaDeDevolucion;
        this.estado = estado;
        this.idPenalizacion = idPenalizacion;
    }

    public long getIdPenalizacion() {
        return idPenalizacion;
    }

    public void setIdPenalizacion(int idPenalizacion) {
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
        Prestamo prestamo1 = new Prestamo();
        
        Scanner in = new Scanner(System.in);
        System.out.println("Inserte su Id");
        int id = in.nextInt();
        prestamo1.setId(id);
        System.out.println("Introduzca la fecha de inicio");
        /*Preguntar a Luis*/
        System.out.println("Introduzca la fecha de devolucion");
        /*Preguntar a Luis*/
        return prestamo1;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", fechaDeInicio=" + fechaDeInicio + ", fechaDeDevolucion=" + fechaDeDevolucion + ", estado=" + estado + ", elementos=" + elementos + ", idPenalizacion=" + idPenalizacion + '}';
    }
    
}
