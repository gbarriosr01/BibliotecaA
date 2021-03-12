/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Validaciones.SocioException;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
    private long id_prestamo;

    public Socio() {

    }

    public Socio(String nombre) {
        this.nombre = nombre;
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
        this.id_prestamo = copia.id_prestamo;
    }

    public Socio(long id, String nombre, String NIF, String telefono, String direccion, Prestamo prestamo) {
        this.id = id;
        this.nombre = nombre;
        this.NIF = NIF;
        this.telefono = telefono;
        this.direccion = direccion;
        this.prestamo = prestamo;
    }

    Socio(long id, String nombre, String NIF, String telefono, String direccion, long id_prestamo) throws SocioException {
        if (SocioException.validarId(id)) {
            this.id = id;
        } else {
            throw new SocioException("Dato invalido");
        }

        if (SocioException.validarNombre(nombre)) {
            this.nombre = nombre;
        } else {
            throw new SocioException("Dato invalido");
        }

        if (SocioException.validarNIF(NIF)) {
            this.NIF = NIF;
        } else {
            throw new SocioException("Dato invalido");
        }

        if (SocioException.validarTelefono(telefono)) {
            this.telefono = telefono;
        } else {
            throw new SocioException("Dato invalido");
        }

        if (SocioException.validarDireccion(direccion)) {
            this.direccion = direccion;
        } else {
            throw new SocioException("Dato invalido");
        }
        if (SocioException.validarId(id_prestamo)) {
            this.id_prestamo = id_prestamo;
        } else {
            throw new SocioException("Dato invalido");
        }

    }

    public Socio(long id, String nombre, String NIF, String telefono, String direccion) {
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

    public void setId(long id) {
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

    public long getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(long id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public static ArrayList<Socio> convertirSocios(Socio[] array) {
        ArrayList<Socio> ret = new ArrayList<Socio>();
        for (Socio s : array) {
            ret.add(s);
        }

        return ret;
    }

    public static long nextIdSocio() {
        long ret = 0;
        for (int i = 0; i < Utilidades.SOCIOS.length; i++) {
            if (Utilidades.SOCIOS[i].id > ret) {
                ret = Utilidades.SOCIOS[i].id;
            }
        }
        return ret + 1;
    }

    public static ArrayList<Socio> convertir(Socio[] array) {
        ArrayList<Socio> ret = new ArrayList<Socio>();
        for (Socio s : array) {
            ret.add((Socio) s);
        }
        return ret;
    }

    public static Socio nuevoSocio() throws SocioException {

        Socio s1 = new Socio();
        Scanner in = new Scanner(System.in);

        long idSoc = nextIdSocio();

        if (SocioException.validarId(idSoc)) {
            s1.setId(idSoc);
        } else {
            throw new SocioException("Dato invalido");
        }

        System.out.println("Inserte su nombre: ");
        String nombre = in.nextLine();
        if (SocioException.validarNombre(nombre)) {
            s1.setNombre(nombre);
        } else {
            throw new SocioException("Dato invalido");
        }

        System.out.println("Inserte su NIF: ");
        String NIF = in.nextLine();

        if (SocioException.validarNIF(NIF)) {
            s1.setNIF(NIF);
        } else {
            throw new SocioException("Dato invalido");
        }

        System.out.println("Inserte su telefono: ");
        String telefono = in.nextLine();

        if (SocioException.validarTelefono(telefono)) {
            s1.setTelefono(telefono);
        } else {
            throw new SocioException("Dato invalido");
        }

        System.out.println("Inserte su direccion: ");
        String direccion = in.nextLine();

        if (SocioException.validarDireccion(direccion)) {
            s1.setDireccion(direccion);
        } else {
            throw new SocioException("Dato invalido");
        }

        System.out.println("Socio registrado correctamente con el id " + idSoc);
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
                        System.out.println(buscado.getId() + ". " + buscado.getNombre() + " (" + buscado.getNIF() + ")( con telefono" + buscado.getTelefono() + ")-->" + buscado.getClass().getSimpleName());
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

    public void exportarObjetoSocioTexto(String path) {
        File fichero = new File(path);
        FileWriter escritor = null;
        PrintWriter buffer = null;
        try {
            try {
                escritor = new FileWriter(fichero, true);
                buffer = new PrintWriter(escritor);
                buffer.print(this.data() + "\r\n");
            } finally {
                if (buffer != null) {
                    buffer.close();
                }
                if (escritor != null) {
                    escritor.close();
                }
            }
        } catch (FileNotFoundException s) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException s) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception s) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }

    public static void exportarColeccionDeObjetosSocioTexto(String path) {
        ArrayList<Socio> coleccion;
        coleccion = Socio.convertir(Utilidades.SOCIOS);
        File fichero = new File(path);
        FileWriter escritor = null;
        PrintWriter buffer = null;
        try {
            try {
                escritor = new FileWriter(fichero, true);
                buffer = new PrintWriter(escritor);
                for (Socio s : coleccion) {
                    buffer.print(s.data() + "\n");
                }
            } finally {
                if (buffer != null) {
                    buffer.close();
                }
                if (escritor != null) {
                    escritor.close();
                }
            }
        } catch (FileNotFoundException s) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException s) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception s) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }
    
    public void exportarSocioaArchivoBinario(String path) {
        try {
            FileOutputStream fichero = new FileOutputStream(path, true);
            ObjectOutputStream socio = new ObjectOutputStream(fichero);
            socio.writeObject(this);
            socio.flush();
            socio.close();
        } catch (FileNotFoundException s) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException s) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception s) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }

    public static void exportarColeccionSociosaArchivoBinario(String path) {
        ArrayList<Socio> coleccion;
        coleccion = Socio.convertir(Utilidades.SOCIOS);
        try {
            FileOutputStream fichero = new FileOutputStream(path, true);
            ObjectOutputStream escritor = new ObjectOutputStream(fichero);
            escritor.writeObject(coleccion);
            escritor.flush();
            escritor.close();
        } catch (FileNotFoundException s) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException s) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception s) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }
    public static ArrayList<Socio> importarSocioDesdeFicheroTexto(String path) {
        ArrayList<Socio> ret = new ArrayList<Socio>();
        FileReader inputStream = null;
        BufferedReader lector = null;
        try {
            try {
                inputStream = new FileReader(path);
                lector = new BufferedReader(inputStream);
                Socio s;
                while (lector.ready()) {
                    String cadena = lector.readLine();
                    if (cadena.isEmpty() == false) {
                        String[] parametros = cadena.split("\\|");
                        s = new Socio(Integer.valueOf(parametros[0]), parametros[1], parametros[2], parametros[3], parametros[4], Integer.valueOf(parametros[5]));
                        ret.add(s);
                    }
                }
            } finally {
                if (lector != null) {
                    lector.close();
                }
            }
        } catch (FileNotFoundException s) {
            System.out.println("No se ha encontrado el fichero");
        } catch (EOFException s) {
            System.out.println("Final de fichero");
        } catch (IOException s) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception s) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
        return ret;
    }
    
    public static ArrayList<Socio> importarSocioDesdeFicheroBinario(String path) {
        ArrayList<Socio> ret = new ArrayList<Socio>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try {
            try {
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Socio s;
                while ((s = (Socio) lectorObjeto.readObject()) != null) {
                    ret.add(s);
                    
                }
            } finally {
                if (lectorObjeto != null) {
                    lectorObjeto.close();
                }
                if (lector != null) {
                    lector.close();
                }
            }
        } catch (FileNotFoundException s) {
            System.out.println("No se ha encontrado el fichero");
        } catch (EOFException s) {
            System.out.println("Final de fichero");
        } catch (IOException s) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (ClassNotFoundException s) {
            System.out.println("No se ha encontrado la clase a la cual haces referencia");
        } catch (Exception s) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
        return ret;
    }
    
    public static ArrayList<Socio> buscarPorIDEnFicheroDeTexto(String path) {
        ArrayList<Socio> ret = new ArrayList<Socio>();
        FileReader inputStream = null;
        BufferedReader lector = null;
        try {
            try {
                inputStream = new FileReader(path);
                lector = new BufferedReader(inputStream);
                Socio s;
                while (lector.ready()) {
                    String cadena = lector.readLine();
                    if (cadena.isEmpty() == false) {
                        String[] parametros = cadena.split("\\|");
                        s = new Socio(Integer.valueOf(parametros[0]), parametros[1], parametros[2], parametros[3], parametros[4], Integer.valueOf(parametros[5]));
                        ret.add(s);
                    }
                }
                Scanner in = new Scanner(System.in);
                int idBuscar = 0;
                do {
                    System.out.print("Introduce el id que desea buscar dentro del fichero de texto: ");
                    idBuscar = in.nextInt();
                    if (idBuscar <= 0) {
                        System.out.println("Debe introducir un valor mayor que cero");
                    }
                } while (idBuscar <= 0);
                for (Socio so : ret) {
                    if (so.getId() == idBuscar) {
                        System.out.println(so.data());
                        break;
                    }
                }
            } finally {
                if (lector != null) {
                    lector.close();
                }
            }
        } catch (InputMismatchException s) {
            System.out.println("El carácter introducido no es un entero");
        } catch (FileNotFoundException s) {
            System.out.println("No se ha encontrado el fichero");
        } catch (EOFException s) {
            System.out.println("Final de fichero");
        } catch (IOException s) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception s) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
        return ret;
    }

    
    @Override
    public String toString() {
        return "Socio{" + "id=" + id + ", nombre=" + nombre + ", NIF=" + NIF + ", telefono=" + telefono + ", direccion=" + direccion + ", penalizaciones=" + penalizaciones + ", eventos=" + eventos + ", prestamo=" + prestamo + '}';
    }

    public String data() {
        return id + "|" + nombre + "|" + NIF + "|" + telefono + "|" + direccion + "|" + id_prestamo;
    }
}
