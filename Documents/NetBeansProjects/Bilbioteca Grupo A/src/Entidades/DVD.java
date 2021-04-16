/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Scanner;
import Entidades.Genero;
import Validaciones.DVDException;
import Validaciones.ElementoException;
import static java.lang.System.in;

/**
 *
 * @author DAM102
 */
public class DVD extends Elemento {

    /*Valido: cadena caracteres "dsadsa" Invalido: " ", >30caracteres*/
    private String titulo;
    private Visionado visionado;/*Obligatorio*/

    public DVD() {
        super();
    }

    public DVD(String titulo) {
        this.titulo = titulo;
    }
    public DVD(Elemento e,String titulo)  {
        super(e);
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

    public DVD(String titulo, Visionado visionado, Elemento el)  {
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

    public static ArrayList<DVD> convertirDVDS(DVD[] array) {
        ArrayList<DVD> ret = new ArrayList<DVD>();
        for (DVD s : array) {
            ret.add(s);
        }

        return ret;
    }

    public static long nextIdDVD() {
        long ret = 0;
        for (int i = 0; i < Utilidades.DVDS.length; i++) {
            if (Utilidades.DVDS[i].id > ret) {
                ret = Utilidades.DVDS[i].id;
            }
        }
        return ret + 1;
    }

    public static DVD nuevoDVD() throws DVDException {
        DVD d = new DVD();
        int opcion = 0;
        int idGenero = 0;
        Genero gen;
        ArrayList<DVD> DVDS = DVD.convertirDVDS(Utilidades.DVDS);
        ArrayList<Genero> generos = Genero.convertirGeneros(Utilidades.GENEROS);

        Scanner teclado = new Scanner(System.in);
        System.out.println("Indica el titulo: ");
        String titulo=teclado.nextLine();
        if(DVDException.validarTitulo(titulo)){
        d.setTitulo(titulo);
        }else{
        throw new DVDException("La cadena introducida para el campo \"titulo\" no es valida ");
        }
        long idEle = nextIdDVD();
        d.setId(idEle);
        System.out.println("Indica el genero");
        do {
            Genero.verGenero(generos);
            System.out.println("-------------------------------------------------");
            teclado = new Scanner(System.in);
            idGenero = teclado.nextInt();
            if (idGenero != 0) {
                gen = Genero.buscarGenerosPorId(idGenero, generos);
                if (gen != null) {
                    System.out.println("Genero asignado: ");
                    gen.verGeneroElemento();
                    d.setGenero(gen);
                } else {
                    System.out.println("Genero:  " + idGenero + "  Desconocido");

                }
            }

        } while (opcion != 0);

        return d;

    }

    public static void buscarDVDs(ArrayList<DVD> DVDS) {
        DVD buscado;
        ArrayList<DVD> encontrados;
        Scanner in;
        int opcion = -1;

        do {
            buscado = null;
            encontrados = new ArrayList<DVD>();
            in = new Scanner(System.in, "ISO-8859-1");
            System.out.println("Pulse 1 para buscar DVD por Titulo.");
            System.out.println("Pulse 0 para VOLVER");
            opcion = in.nextInt();
            if (opcion < 0 || opcion > 1) {
                System.out.println("Opción incorrecta.");
                continue;
            }
            in = new Scanner(System.in, "ISO-8859-1");
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    System.out.println("-------------------------------------------------");
                    System.out.println("Introduzca el Titulo del DVD a buscar:");
                    String TituloDVD = in.nextLine();
                    encontrados = DVD.buscarDVDsPorTitulo(TituloDVD, DVDS);
                    if (encontrados.size() > 0) {
                        System.out.println("-------------------------------------------------");
                        System.out.println("Hay coincidencias: ");
                        for (DVD d : encontrados) {
                            System.out.println("-------------------------------------------------");
                            System.out.println(d.getTitulo());
                        }
                    } else {
                        System.out.println("-------------------------------------------------");
                        System.out.println("DVD  " + TituloDVD + "  NO ENCONTRADO.");
                    }
                    break;
                default:
                    break;
            }
        } while (opcion != 0);
    }

    public static ArrayList<DVD> buscarDVDsPorTitulo(String tituloDVD, ArrayList<DVD> DVDS) {
        ArrayList<DVD> ret = new ArrayList<DVD>();
        for (DVD d : DVDS) {
            if (Utilidades.removeDiacriticalMarks(d.getTitulo().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(tituloDVD.toLowerCase()))) {
                ret.add(d);
            }
            if (d.getTitulo().toLowerCase().contains(tituloDVD.toLowerCase())) {
                if (!ret.contains(d)) {
                    ret.add(d);
                }
            }
        }
        return ret;
    }

    public static void verDvd(ArrayList<DVD> DVDS) {
        System.out.println("DVD de la biblioteca:");
        for (DVD d : DVDS) {
            System.out.println(d.getId() + ".- " + (d.getTitulo() + " - " + (d.getGenero() + ".")));
        }

    }

    @Override
    public String toString() {
        return "DVD{" + "titulo=" + titulo + ", visionado=" + visionado + '}';
    }

     /**
     * Atributos separados por el caracter |
     * @return | titulo + visionado
     */
    
    @Override
    public String data() {
        return  id + "|" + titulo + "|" + visionado;
    }
}
