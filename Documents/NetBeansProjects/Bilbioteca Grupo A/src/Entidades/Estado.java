/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author DAM102
 */
public class Estado {
    private long id;
    private String estado;

    public Estado() {
    }

    public Estado(Estado copia) {
        this.id = copia.id;
        this.estado = copia.estado;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
