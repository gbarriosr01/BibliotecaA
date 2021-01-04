/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAM102
 */
public class Socio {
                
    private int id;
    private String nombre;
    private String NIF;
    private String telefono;
    private String direccion;
    private ArrayList<Penalizacion> penalizaciones = new ArrayList<Penalizacion>();
    private ArrayList<Evento> eventos = new ArrayList<Evento>();/*No obligatorio*/
    private Prestamo prestamo;

    
    public Socio() {
    }

    public Socio(Socio copia){
        this.id = copia.id;
        this.nombre = copia.nombre;
        this.NIF = copia.NIF;
        this.telefono = copia.telefono;
        this.direccion = copia.direccion;
        this.penalizaciones = copia.penalizaciones;
        this.eventos = copia.eventos;
        this.prestamo = copia.prestamo;
    }

    public Socio(int id, String nombre, String NIF, String telefono, String direccion, Prestamo prestamo) {
        this.id = id;
        this.nombre = nombre;
        this.NIF = NIF;
        this.telefono = telefono;
        this.direccion = direccion;
        this.prestamo = prestamo;
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNIF() {
        return NIF;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Penalizacion> getPenalizaciones() {
        return penalizaciones;
    }

    public void setPenalizaciones(ArrayList<Penalizacion> penalizaciones) {
        this.penalizaciones = penalizaciones;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Socio nuevoSocio(){
        
        Socio s1 = new Socio();
        Scanner in = new Scanner(System.in);
        
        System.out.println("Inserte su id");
        int id = in.nextInt();
        s1.setId(id);
        
        System.out.println("Inserte su nombre");
        String nombre = in.nextLine();
        s1.setNombre(nombre);
        
        System.out.println("Inserte su NIF");
        String NIF = in.nextLine();
        s1.setNIF(NIF);
        
        System.out.println("Inserte su telefono");
        String telefono = in.nextLine();
        s1.setTelefono(telefono);
        
        System.out.println("Inserte su direccion");
        String direccion = in.nextLine();
        s1.setDireccion(direccion);
        
        
        
        return s1;
    }

    @Override
    public String toString() {
        return "Socio{" + "id=" + id + ", nombre=" + nombre + ", NIF=" + NIF + ", telefono=" + telefono + ", direccion=" + direccion + ", penalizaciones=" + penalizaciones + ", eventos=" + eventos + ", prestamo=" + prestamo + '}';
    }
    
    
}
