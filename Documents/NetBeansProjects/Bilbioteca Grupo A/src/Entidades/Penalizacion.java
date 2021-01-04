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
     
    private int id;
    private String motivo;
    private Date fechaDeVigencia;

    public Penalizacion() {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setFechaDeVigencia(Date fechaDeVigencia) {
        this.fechaDeVigencia = fechaDeVigencia;
    }
    public Penalizacion nuevoPenalizacion(){
        Penalizacion penalizacion1 = new Penalizacion();
        
        Scanner in = new Scanner(System.in);
        System.out.println("Inserte su ID");
        int id = in.nextInt();
        penalizacion1.setId(id);
        
        System.out.println("Inserte el motivo");
        String motivo = in.nextLine();
        penalizacion1.setMotivo(motivo);
        
        return penalizacion1;
    }

    @Override
    public String toString() {
        return "Penalizacion{" + "id=" + id + ", motivo=" + motivo + ", fechaDeVigencia=" + fechaDeVigencia + '}';
    }
    
}
