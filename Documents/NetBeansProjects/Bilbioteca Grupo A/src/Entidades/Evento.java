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
    /*
    Valores validos: Caracteres numericos.
    Valores invalidos: Caracteres alfanumericos y especiales.
    Otras restricciones: >0 y es unico.
    */
    protected long id;
    /*
    Valores validos: Caracteres alfanumericos.
    Valores invalidos: Caracteres especiales.
    */
    protected String nombre;
    /*
    Valores validos: Caracteres alfanumericos.
    Valores invalidos: Caracteres especiales excepto "º" y "@".
    Otras restricciones: Longitud max 60 caracteres.
    */
    protected Date fechayhora;
    /*
    Valores validos: Fecha y hora dd/mm/yyyy hh:mm:ss.
    Valores invalidos: Otro tipo de caracteres que no esten contemplados en el formato
    */
    protected long idPenalizacion;
    protected ArrayList<Socio> socios = new ArrayList<Socio>();/*Obligatorio*/

    public Evento() {
        this.id = id = 0;
        this.nombre = nombre = null;
        this.fechayhora = fechayhora;
        this.idPenalizacion = idPenalizacion = 0;
    }

    public Evento(long id, String nombre, Date fechayhora, long idPenalizacion) {
        this.id = id = 0;
        this.nombre = nombre = null;
        this.fechayhora = fechayhora;
        this.idPenalizacion = idPenalizacion = 0;
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
        
        int numEventos = Utilidades.numEventos + 1;
        ev1.setId(numEventos);
        
        
        System.out.println("Introduzca el nombre del evento");
        String nombre = in.nextLine();
        ev1.setNombre(nombre);
        System.out.println("Introduzca la fecha y la hora del evento");
        java.sql.Date fechayhora = Utilidades.Fecha.nuevaFecha().conversorFecha();
        ev1.setFechayhora(fechayhora);
        
        int opcion=-1;
        
        do{
            mostrarMenuEventos();
            opcion = in.nextInt();
            if(opcion <0 || opcion >4){
                System.out.println("Opcion incorrecta");
                continue;
            }
            switch(opcion){
            
                case 1:
                    Concurso con = new Concurso().nuevoConcurso();
                    break;
                case 2:
                    Curso cur = new Curso().nuevoCurso();
                    break;
                case 3:
                    Lectura lec = new Lectura().nuevoLectura();
                    break;
                case 4:
                    Visionado vis = new Visionado().nuevoVisionado();
                    break;
                case 0:
                    continue;
            }
        
        }while(opcion !=0);
        
        
        
        return ev1;
    }
        
    public void mostrarMenuEventos(){
        System.out.println("1.Concurso");
        System.out.println("2.Curso");
        System.out.println("3.Lectura");
        System.out.println("4.Visionado");
        System.out.println("0.Salir");
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", nombre=" + nombre + ", fechayhora=" + fechayhora + ", idPenalizacion=" + idPenalizacion + ", socios=" + socios + '}';
    }
}
