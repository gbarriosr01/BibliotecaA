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
public class Lote {
    //Valores válidos,  >0
    //Valores inválidos, <=0
    //Tiene que ser único
    private long id;
    //Valores válidos dd/mm/yyyy - numerico
    //Valores inválidos- No puede contener caracteres ni signos
      private Date fechallegada;
      private ArrayList <Elemento> elementos = new ArrayList <Elemento>();/*Obligatorio*/
    //Valores válidos,  >0
    //Valores inválidos, <=0
    //Tiene que ser único
      private long idProveedor;/*Obligatorio*/

    public Lote() {
       
    }
    
    public Lote(Lote a){
       this.id=a.id;
       this.fechallegada=a.fechallegada;
       this.elementos=a.elementos;
               
        
    }

    public Lote(Date fechallegada, long idProveedor) {
        this.id= id;
        this.fechallegada = fechallegada;
        this.idProveedor = idProveedor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechallegada() {
        return fechallegada;
    }

    public void setFechallegada(Date fechallegada) {
        this.fechallegada = fechallegada;
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

    public long getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(long idProveedor) {
        this.idProveedor = idProveedor;
    }
      
     public Lote nuevoLote(){
         Lote l1 = new Lote();
         Scanner in =new Scanner(System.in);
         
           int numLotes = Utilidades.numLotes + 1;
            l1.setId(numLotes);
         
         System.out.println("Introduzca la fecha de llegada");
         /*Preguntar a Luis*/         
         java.sql.Date fecha = Utilidades.Fecha.nuevaFecha().conversorFecha();
         l1.setFechallegada(fecha);
         
         return l1;
     } 

    @Override
    public String toString() {
        return "Lote{" + "fechallegada=" + fechallegada + ", elementos=" + elementos + ", idProveedor=" + idProveedor + '}';
    }
      
     
   
}
