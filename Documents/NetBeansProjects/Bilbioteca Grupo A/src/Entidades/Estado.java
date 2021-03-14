/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Validaciones.EstadoException;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author DAM102
 */
public class Estado implements Serializable {

    private long id;/*Mayores que 0, no puede ser nulo*/
    private String estado;/*Pendiente, Parcial o Completo*/

    public Estado() {
        
        this.estado = "Pendiente";
    }

//    Estado(long id, String estado) throws EstadoException{
//        if(EstadoException.validarId(id)){
//            this.id=id;
//        } else
//            throw new EstadoException("Dato invalido");
//        
//        if(EstadoException.validarEstado(estado)){
//            this.estado=estado;
//        } else
//            throw new EstadoException("Dato invalido");
//        
//    }
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

    public Estado nuevoEstado() throws EstadoException {
        Estado estado1 = new Estado();

        Scanner in = new Scanner(System.in);

        int numEstados = Utilidades.numEstados + 1;
        if(EstadoException.validarId(id)){
            estado1.setId(numEstados);
        }else {
            throw new EstadoException("Tiene que ser mayor de 0");
        }
        

        System.out.println("Inserte el estado");
        String estado = in.nextLine();
        if(EstadoException.validarEstado(estado)){
        estado1.setEstado(estado);
        }else {
            throw new EstadoException("Solo se acepta Pendiente, Parcial o Completo");
        }
        return estado1;
    }

    @Override
    public String toString() {
        return "Estado{" + "id=" + id + ", estado=" + estado + '}';
    }

    /**
     * Atributos separados por el caracter |
     *
     * @return primary key id| estado
     */
    public String data() {
        return id + "|" + estado;
    }
}
