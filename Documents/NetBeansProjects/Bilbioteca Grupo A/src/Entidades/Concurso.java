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
public class Concurso extends Evento {
    private String Tipo;
    private String Premio;

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getPremio() {
        return Premio;
    }

    public void setPremio(String Premio) {
        this.Premio = Premio;
    }

    public Concurso() {
    }
    
}
