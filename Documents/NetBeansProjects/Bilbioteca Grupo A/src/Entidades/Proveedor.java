/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Scanner;

/**
 *
 * @author DAM102
 */
public class Proveedor {
    //Valores válidos,  >0
    //Valores inválidos, <=0
    //Tiene que ser único 
    private long id;
    //Valores válidos,  <=20 caracteres
    //Valores inválidos, >20 caracteres
    //No se admiten números
    private String nombre;
    //Valores válidos,  >=9 numeros
    //Valores inválidos, <9 numeros
    //NO admite letras
    private String telefono;

    public Proveedor() {
        
    }

    public Proveedor(long id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    
    public Proveedor(Proveedor p1){
        this.id=p1.id;
        this.nombre=p1.nombre;
        this.telefono=p1.telefono;
    
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    public Proveedor nuevoProveedor(){
          Proveedor p1 = new Proveedor();
          Scanner in =new Scanner(System.in);
          
          System.out.println("Ingrese su id");
          long id = in.nextLong();
          p1.setId(id);
          System.out.println("Ingrese nombre del proveedor");
          String nombre = in.nextLine();
          p1.setNombre(nombre);
          System.out.println("Ingrese el telefono del proveedor");
          String telefono = in.nextLine();
          p1.setTelefono(telefono);
          
          
          return p1;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + '}';
    }
     
    
}
