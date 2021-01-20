/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DAM102
 */
public class Penalizacion {
     
    private long id;/*Mayores que 0, no puede ser nulo*/
    private String motivo;/*Maximo 50 caracteres*/
    private Date fechaDeVigencia;
    /*Fecha de la finalizacion de la penalizacion
    LocalDate.now();
    */

    public Penalizacion() {
        this.id=0;
        this.motivo=null;
    }
    
    public Penalizacion(Penalizacion copia){
        this.id= copia.id;
        this.motivo = copia.motivo;
        this.fechaDeVigencia = copia.fechaDeVigencia;
        
    }

    public Penalizacion(int id, String motivo, Date fechaDeVigencia) {
        this.id = id;
        this.motivo = motivo;
        this.fechaDeVigencia = fechaDeVigencia;
    }


    public long getId() {
        return id;
    }

    public String getMotivo() {
        return motivo;
    }

    public Date getFechaDeVigencia() {
        return fechaDeVigencia;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setFechaDeVigencia(Date fechaDeVigencia) {
        this.fechaDeVigencia = fechaDeVigencia;
    }
    public Penalizacion nuevoPenalizacion(){
        Penalizacion ret = new Penalizacion();

        Scanner in = new Scanner(System.in);
        System.out.println("Inserte su ID");
        int id = in.nextInt();
        ret.setId(id);

        System.out.println("Inserte el motivo");
        String motivo = in.nextLine();
        ret.setMotivo(motivo);

        System.out.println("Introduzca fecha de vigencia");
        java.sql.Date fecha = Utilidades.Fecha.nuevaFecha().conversorFecha();
        ret.setFechaDeVigencia(fecha);
        return ret;
    }

    @Override
    public String toString() {
        return "Penalizacion{" + "id=" + id + ", motivo=" + motivo + ", fechaDeVigencia=" + fechaDeVigencia + '}';
    }
    
}
