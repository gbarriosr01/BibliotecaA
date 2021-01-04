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
public class DVD extends Elemento{
    
    private String titulo;
    private Visionado visionado;/*Obligatorio*/

    public DVD() {
        super();
    }

    public DVD(String titulo) {
        this.titulo = titulo;
    }

    public DVD(String titulo, Visionado visionado) {
        this.titulo = titulo;
        this.visionado = visionado;
    }

    public DVD(String titulo, Visionado visionado, long id, Genero genero) {
        super(id, genero);
        this.titulo = titulo;
        this.visionado = visionado;
    }

    public DVD(String titulo, Visionado visionado, Elemento el) {
        super(el);
        this.titulo = titulo;
        this.visionado = visionado;
    }

    public DVD(DVD d) {
        this.titulo = d.titulo;
        this.visionado = d.visionado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Visionado getVisionado() {
        return visionado;
    }

    public void setVisionado(Visionado visionado) {
        this.visionado = visionado;
    }
    
    public static DVD nuevoDVD() {
        DVD d = new DVD();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Indica el titulo: ");
        d.setTitulo(teclado.nextLine());
        return d;
    
    }

    @Override
    public String toString() {
        return "DVD{" + "titulo=" + titulo + ", visionado=" + visionado + '}';
    }
    
    
}
