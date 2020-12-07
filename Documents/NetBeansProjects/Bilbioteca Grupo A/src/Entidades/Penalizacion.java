/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author DAM102
 */
public class Penalizacion {
     
    private long id;
    private String motivo;
    private Date fechaDeVigencia;

    public Penalizacion() {
    }
    
    public Penalizacion(Penalizacion copia){
        this.id= copia.id;
        this.motivo = copia.motivo;
        this.fechaDeVigencia = copia.fechaDeVigencia;
        
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
}
