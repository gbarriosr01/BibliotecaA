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
public class Lectura {
    private boolean Leido;
    private String Modelo;

    public boolean isLeido() {
        return Leido;
    }

    public void setLeido(boolean Leido) {
        this.Leido = Leido;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public Lectura() {
    }
    
}
