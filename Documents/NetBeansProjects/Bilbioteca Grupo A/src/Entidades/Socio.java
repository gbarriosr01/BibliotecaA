/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAM102
 */
public class Socio {

    private long id;/*Mayores que 0, no puede ser nulo*/
    private String nombre;/*Menor o igual a 20 caracteres, no se admiten numeros*/
    private String NIF;/*Mayor o igual a 9 caracteres*/
    private String telefono;/*Mayor o igual a 9 caracteres*/
    private String direccion;/*Menor o igual a 30 caracteres*/
    private ArrayList<Penalizacion> penalizaciones = new ArrayList<Penalizacion>();
    private ArrayList<Evento> eventos = new ArrayList<Evento>();/*No obligatorio*/
    private Prestamo prestamo;

    public Socio() {

    }

    public Socio(Socio copia) {
        this.id = copia.id;
        this.nombre = copia.nombre;
        this.NIF = copia.NIF;
        this.telefono = copia.telefono;
        this.direccion = copia.direccion;
        this.penalizaciones = copia.penalizaciones;
        this.eventos = copia.eventos;
        this.prestamo = copia.prestamo;
    }

    public Socio(int id, String nombre, String NIF, String telefono, String direccion, Prestamo prestamo) {
        this.id = id;
        this.nombre = nombre;
        this.NIF = NIF;
        this.telefono = telefono;
        this.direccion = direccion;
        this.prestamo = prestamo;
    }

    public Socio(int id, String nombre, String NIF, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.NIF = NIF;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNIF() {
        return NIF;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Penalizacion> getPenalizaciones() {
        return penalizaciones;
    }

    public void setPenalizaciones(ArrayList<Penalizacion> penalizaciones) {
        this.penalizaciones = penalizaciones;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public static ArrayList<Socio> convertirSocios(Socio[] array) {
        ArrayList<Socio> ret = new ArrayList<Socio>();
        for (Socio s : array) {
            ret.add(s);
        }

        return ret;
    }

    public Socio nuevoSocio() {

        Socio s1 = new Socio();
        Scanner in = new Scanner(System.in);

        int numSocios = Utilidades.numSocios + 1;
        s1.setId(numSocios);

        System.out.println("Inserte su nombre: ");
        String nombre = in.nextLine();
        s1.setNombre(nombre);

        System.out.println("Inserte su NIF: ");
        String NIF = in.nextLine();
        s1.setNIF(NIF);

        System.out.println("Inserte su telefono: ");
        String telefono = in.nextLine();
        s1.setTelefono(telefono);

        System.out.println("Inserte su direccion: ");
        String direccion = in.nextLine();
        s1.setDireccion(direccion);

        System.out.println("Socio registrado correctamente con el id " + numSocios);
        return s1;
    }

    public static void verSocio(ArrayList<Socio> socios) {
        System.out.println("Socios de la biblioteca:");
        for (Socio s : socios) {
            System.out.println(s.getId() + ".- " + (s.getNIF() + " - " + (s.getNombre() + " - con teléfono " + (s.getTelefono() + "."))));
        }

    }

    public static void buscarSocios(ArrayList<Socio> socios) {
        Socio buscado;
        ArrayList<Socio> encontrados;
        Scanner in;
        int opcion = -1;
        do {
            buscado = null;
            encontrados = new ArrayList<Socio>();
            in = new Scanner(System.in, "ISO-8859-1");
            System.out.println("Pulse 1 para buscar socio por ID.");
            System.out.println("Pulse 2 para buscar socio por NOMBRE.");
            System.out.println("Pulse 3 para buscar socio por TELEFONO.");
            System.out.println("Pulse 4 para buscar socio por NIF.");
            System.out.println("Pulse 0 para VOLVER.");
            opcion = in.nextInt();
            if (opcion < 0 || opcion > 4) {
                System.out.println("Opción incorrecta.");
                continue;
            }
            in = new Scanner(System.in, "ISO-8859-1");
            switch (opcion) {
                case 0:
                    break;
                case 1:
                    System.out.println("Introduzca el ID del socio a encontrar:");
                    int idSoc = in.nextInt();
                    buscado = Socio.buscarSociosPorId(idSoc, socios);
                    if (buscado != null) {
                        System.out.print("Socio encontrado: ");
                        System.out.println(buscado.getId() + ". " + buscado.getNombre() + " (" + buscado.getNIF() + ")(" + buscado.getTelefono() + ")-->" + buscado.getClass().getSimpleName());
                    } else {
                        System.out.println("Socio con id=" + idSoc + " NO ENCONTRADO.");
                    }
                    break;
                case 2:
                    System.out.println("Introduzca el NOMBRE del Socio a encontrar:");
                    String nomSoc = in.nextLine();
                    encontrados = Socio.buscarSocioPorNombre(nomSoc, socios);
                    if (encontrados.size() > 0) {
                        System.out.println("Hay coincidencias: ");
                        for (Socio e : encontrados) {
                            System.out.println(e.getId() + ". " + e.getNombre() + " (" + e.getNIF() + ")(" + e.getTelefono() + ")-->" + e.getClass().getSimpleName());
                        }
                    } else {
                        System.out.println("Socio con nombre=" + nomSoc + " NO ENCONTRADO.");
                    }
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("Introduzca el TELEFONO del socio a encontrar:");
                    String telSoc = in.nextLine();
                    encontrados = Socio.buscarSocioPorTelefono(telSoc, socios);
                    if (encontrados.size() > 0) {
                        System.out.println("Hay coincidencias: ");
                        for (Socio e : encontrados) {
                            System.out.println(e.getId() + ". " + e.getNombre() + " (" + e.getNIF() + ")(" + e.getTelefono() + ")-->" + e.getClass().getSimpleName());
                        }
                    } else {
                        System.out.println("Socio con teléfono=" + telSoc + " NO ENCONTRADO.");
                    }
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("Introduzca el NIF del socio a encontrar:");
                    String nifSoc = in.nextLine();
                    encontrados = Socio.buscarSocioPorNIF(nifSoc, socios);
                    if (encontrados.size() > 0) {
                        System.out.println("Hay coincidencias: ");
                        for (Socio e : encontrados) {
                            System.out.println(e.getId() + ". " + e.getNombre() + " (" + e.getNIF() + ")(" + e.getTelefono() + ")-->" + e.getClass().getSimpleName());
                        }
                    } else {
                        System.out.println("Socio con NIF=" + nifSoc + " NO ENCONTRADO.");
                    }
                    System.out.println("");
                    break;

                default:
                    break;
            }

        } while (opcion != 0);
    }

    public static Socio buscarSociosPorId(int idSocio, ArrayList<Socio> socios) {
        Socio ret = null;
        for (Socio s : socios) {
            if (s.getId() == idSocio) {

                ret = s;
                break;
            }

        }
        return ret;
    }

    public static ArrayList<Socio> buscarSocioPorNombre(String nomSocio, ArrayList<Socio> socios) {
        ArrayList<Socio> ret = new ArrayList<Socio>();
        for (Socio e : socios) {
            if (Utilidades.removeDiacriticalMarks(e.getNombre().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(nomSocio.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getNombre().toLowerCase().contains(nomSocio.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }
    
    public static ArrayList<Socio> buscarSocioPorTelefono(String telSocio, ArrayList<Socio> socios) {
        ArrayList<Socio> ret = new ArrayList<Socio>();
        for (Socio e : socios) {
            if (Utilidades.removeDiacriticalMarks(e.getTelefono().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(telSocio.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getTelefono().toLowerCase().contains(telSocio.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }
    
    public static ArrayList<Socio> buscarSocioPorNIF(String nifSocio, ArrayList<Socio> socios) {
        ArrayList<Socio> ret = new ArrayList<Socio>();
        for (Socio e : socios) {
            if (Utilidades.removeDiacriticalMarks(e.getNIF().toLowerCase()).contains(Utilidades.removeDiacriticalMarks(nifSocio.toLowerCase()))) {
                ret.add(e);
            }
            if (e.getNIF().toLowerCase().contains(nifSocio.toLowerCase())) {
                if (!ret.contains(e)) {
                    ret.add(e);
                }
            }
        }
        return ret;
    }

    
    public void verDatosSocioCompleto() {
        System.out.println("-----------");
        System.out.println("INFORME completo de SOCIO de ID: " + this.getId());
        System.out.println("NOMBRE: " + this.getNombre());
        System.out.println("TELEFONO: " + this.getTelefono() + "\t\tNIF: " + this.getNIF());

    }

    @Override
    public String toString() {
        return "Socio{" + "id=" + id + ", nombre=" + nombre + ", NIF=" + NIF + ", telefono=" + telefono + ", direccion=" + direccion + ", penalizaciones=" + penalizaciones + ", eventos=" + eventos + ", prestamo=" + prestamo + '}';
    }

}
