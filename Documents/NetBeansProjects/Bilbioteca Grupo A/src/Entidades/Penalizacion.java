/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Validaciones.PenalizacionException;
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DAM102
 */
public class Penalizacion implements Serializable {

    private long id;/*Mayores que 0, no puede ser nulo*/
    private String motivo;/*Maximo 50 caracteres*/
    private Date fechaDeVigencia;
    /*Fecha de la finalizacion de la penalizacion
    LocalDate.now();
     */
    private long id_socio;

    public Penalizacion() {

    }

    public Penalizacion(Penalizacion copia) {
        this.id = copia.id;
        this.motivo = copia.motivo;
        this.fechaDeVigencia = copia.fechaDeVigencia;
        this.id_socio = copia.id_socio;

    }

    public Penalizacion(int id, String motivo, Date fechaDeVigencia) {
        this.id = id;
        this.motivo = motivo;
        this.fechaDeVigencia = fechaDeVigencia;
    }

    Penalizacion(long id, String motivo, long id_socio) throws PenalizacionException {
        if (PenalizacionException.validarId(id)) {
            this.id = id;
        } else {
            throw new PenalizacionException("Debe ser mayor de 0");
        }
        if(PenalizacionException.validarMotivo(motivo)){
            this.motivo= motivo;
        } else {
            throw new PenalizacionException("No se aceptan numeros");
        }
        if(PenalizacionException.validarId(id_socio)){
            this.id_socio=id_socio;
        } else {
            throw new PenalizacionException("Debe ser mayor de 0");
        }
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

    public long getId_socio() {
        return id_socio;
    }

    public void setId_socio(long id_socio) {
        this.id_socio = id_socio;
    }

    public Penalizacion nuevoPenalizacion() {
        Penalizacion ret = new Penalizacion();

        Scanner in = new Scanner(System.in);
        int numPenalizaciones = Utilidades.numPenalizaciones + 1;
        ret.setId(numPenalizaciones);

        System.out.println("Inserte el motivo");
        String motivo = in.nextLine();
        ret.setMotivo(motivo);

        System.out.println("Introduzca fecha de vigencia");
        java.sql.Date fecha = Utilidades.Fecha.nuevaFecha().conversorFecha();
        ret.setFechaDeVigencia(fecha);
        return ret;
    }

    @Override
    public String toString() {
        return "Penalizacion{" + "id=" + id + ", motivo=" + motivo + ", fechaDeVigencia=" + fechaDeVigencia + '}';
    }

    public String data() {
        return id + "|" + motivo + "|" + fechaDeVigencia + "|" + id_socio;
    }

}
