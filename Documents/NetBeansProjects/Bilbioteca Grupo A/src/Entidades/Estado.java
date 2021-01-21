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
    private long id;/*Mayores que 0, no puede ser nulo*/
    private String estado;/*Pendiente, Parcial o Completo*/

    public Estado() {
        this.id=0;
        this.estado= "Pendiente";
    }

    public Estado(Estado copia) {
        this.id = copia.id;
        this.estado = copia.estado;
    }

    public Estado(long id, String estado) {
        this.id = id;
        this.estado = estado;
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
    
    public Estado nuevoEstado(){
        Estado estado1 = new Estado();
        
        Scanner in = new Scanner(System.in);
        
        int numEstados = Utilidades.numEstados + 1;
        estado1.setId(numEstados);
        
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
