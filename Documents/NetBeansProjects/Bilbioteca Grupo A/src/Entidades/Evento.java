/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DAM102
 */
public class Evento {
    protected long id;
    protected String nombre;
    protected Date fechayhora;
    protected long idPenalizacion;
    protected ArrayList<Socio> socios = new ArrayList<Socio>();/*Obligatorio*/

    public Evento() {
    }

    public Evento(long id, String nombre, Date fechayhora, long idPenalizacion) {
        this.id = id;
        this.nombre = nombre;
        this.fechayhora = fechayhora;
        this.idPenalizacion = idPenalizacion;
    }
    
    public Evento(Evento ev1) {
        this.id = ev1.id;
        this.nombre = ev1.nombre;
        this.fechayhora = ev1.fechayhora;
        this.idPenalizacion = ev1.idPenalizacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechayhora() {
        return fechayhora;
    }

    public void setFechayhora(Date fechayhora) {
        this.fechayhora = fechayhora;
    }

    public long getIdPenalizacion() {
        return idPenalizacion;
    }

    public void setIdPenalizacion(long idPenalizacion) {
        this.idPenalizacion = idPenalizacion;
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public void setSocios(ArrayList<Socio> socios) {
        this.socios = socios;
    }
//    public static ArrayList<Socio> convertir(Socio[] array) {
//        return new Gen<Socio>().convertir(array);
//    }
    public Evento nuevoEvento(){
        Evento ev1 = new Evento();
        Scanner in = new Scanner(System.in);
        System.out.println("Introduzca los datos del Evento");
        System.out.println("Introduzca el id del evento");
        int id = in.nextInt();
        ev1.setId(id);
        System.out.println("Introduzca el nombre del evento");
        String nombre = in.nextLine();
        ev1.setNombre(nombre);
        System.out.println("Introduzca la fecha y la hora del evento");
//      preguntar a Luis
        System.out.println("Introduzca el id de la penalizacion");
        int idPenalizacion = in.nextInt();
        ev1.setIdPenalizacion(idPenalizacion);
        return ev1;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", nombre=" + nombre + ", fechayhora=" + fechayhora + ", idPenalizacion=" + idPenalizacion + ", socios=" + socios + '}';
    }
}
