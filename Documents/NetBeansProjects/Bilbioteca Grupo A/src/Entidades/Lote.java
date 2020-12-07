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
public class Lote {
      private Date fechallegada;
      private ArrayList <Elemento> elementos = new ArrayList <Elemento>();/*Obligatorio*/
      private long idProveedor;/*Obligatorio*/

    public Lote() {
    }
    
    public Lote(Lote a){
       this.fechallegada=a.fechallegada;
       this.elementos=a.elementos;
               
        
    }

    public Lote(Date fechallegada, long idProveedor) {
        this.fechallegada = fechallegada;
        this.idProveedor = idProveedor;
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
      
      
      
}
