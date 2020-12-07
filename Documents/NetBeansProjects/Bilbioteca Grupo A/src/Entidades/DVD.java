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
public class DVD extends Elemento{
    
    private String Titulo;
    private Visionado visionado;/*Obligatorio*/

    public DVD() {
        super();
    }
    
    public DVD(DVD d1){
        this.Titulo=d1.Titulo;
        this.visionado=d1.visionado;
        
    
    }
    
    public DVD(String Titulo, Visionado visionado) {
        this.Titulo = Titulo;
        this.visionado = visionado;
    }

    public DVD(String Titulo, Visionado visionado, long id, Genero genero) {
        super(id, genero);
        this.Titulo = Titulo;
        this.visionado = visionado;
    }

    public DVD(String Titulo, Visionado visionado, Elemento el) {
        super(el);
        this.Titulo = Titulo;
        this.visionado = visionado;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public Visionado getVisionado() {
        return visionado;
    }

    public void setVisionado(Visionado visionado) {
        this.visionado = visionado;
    }

    @Override
    public String toString() {
        return "DVD{" + "Titulo=" + Titulo + ", visionado=" + visionado + '}';
    }

    
}
