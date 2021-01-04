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
public class Estado {
    private int id;
    private String estado;

    public Estado() {
    }

    public Estado(Estado copia) {
        this.id = copia.id;
        this.estado = copia.estado;
    }

    public Estado(int id, String estado) {
        this.id = id;
        this.estado = estado;
    }
    
    
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Estado nuevoEstado(){
        Estado estado1 = new Estado();
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Inserte su id");
        int id = in.nextInt();
        estado1.setId(id);
        
        System.out.println("Inserte el estado");
        String estado = in.nextLine();
        estado1.setEstado(estado);
        return estado1;
    }

    @Override
    public String toString() {
        return "Estado{" + "id=" + id + ", estado=" + estado + '}';
    }
    
}
