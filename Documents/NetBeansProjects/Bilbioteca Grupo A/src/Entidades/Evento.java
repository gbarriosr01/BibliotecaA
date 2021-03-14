/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Validaciones.EventoException;
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
import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author DAM102
 */
public class Evento implements Serializable {

    static final long serialVersionUID = 1L;
    /*
    Valores validos: Caracteres numericos.
    Valores invalidos: Caracteres alfanumericos y especiales.
    Otras restricciones: >0 y es unico.
     */
    protected long id;
    /*
    Valores validos: Caracteres alfanumericos.
    Valores invalidos: Caracteres especiales.
     */
    protected String nombre;
    /*
    Valores validos: Caracteres alfanumericos.
    Valores invalidos: Caracteres especiales excepto "º" y "@".
    Otras restricciones: Longitud max 60 caracteres.
     */
    protected Date fechayhora;
    /*
    Valores validos: Fecha y hora dd/mm/yyyy hh:mm:ss.
    Valores invalidos: Otro tipo de caracteres que no esten contemplados en el formato
     */
    protected long idPenalizacion;
    protected ArrayList<Socio> socios = new ArrayList<Socio>();/*Obligatorio*/

    public Evento() {
        this.id = id = 0;
        this.nombre = nombre = null;
        this.fechayhora = fechayhora;
        this.idPenalizacion = idPenalizacion = 0;
    }

    public Evento(long id, String nombre, Date fechayhora) {
        this.id = id;
        this.nombre = nombre;
        this.fechayhora = fechayhora;
    }
    public Evento(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Evento(long id, String nombre, Date fechayhora, long idPenalizacion) {
        this.id = id = 0;
        this.nombre = nombre = null;
        this.fechayhora = fechayhora;
        this.idPenalizacion = idPenalizacion = 0;
    }

    public Evento(Evento ev1) {
        this.id = ev1.id;
        this.nombre = ev1.nombre;
        this.fechayhora = ev1.fechayhora;
        this.idPenalizacion = ev1.idPenalizacion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechayhora() {
        return fechayhora;
    }

    public void setFechayhora(Date fechayhora) {
        this.fechayhora = fechayhora;
    }

    public long getIdPenalizacion() {
        return idPenalizacion;
    }

    public void setIdPenalizacion(long idPenalizacion) {
        this.idPenalizacion = idPenalizacion;
    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }

    public void setSocios(ArrayList<Socio> socios) {
        this.socios = socios;
    }

    public static Evento nuevoEvento() throws EventoException {
        Evento ev1 = new Evento();
        Scanner in = new Scanner(System.in);
        int numEventos = Utilidades.numEventos + 1;
        if (EventoException.validarId(numEventos)) {
            ev1.setId(numEventos);
        } else {
            System.out.println("Has introducido mal el id del evento");
        }
        System.out.println("Introduzca el nombre del evento");
        String nombre = in.nextLine();
        if (EventoException.validarNombre(nombre)) {
            ev1.setNombre(nombre);
        } else {
            System.out.println("Has introducido mal el nombre del evento");
        }
        System.out.println("Introduzca la fecha y la hora del evento");
        java.sql.Date fechayhora = Utilidades.Fecha.nuevaFecha().conversorFecha();
        ev1.setFechayhora(fechayhora);
        return ev1;
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", nombre=" + nombre + ", fechayhora=" + fechayhora + ", idPenalizacion=" + idPenalizacion + ", socios=" + socios + '}';
    }

    public static ArrayList<Evento> convertir(Evento[] array) {
        ArrayList<Evento> ret = new ArrayList<Evento>();
        for (Evento e : array) {
            ret.add((Evento) e);
        }
        return ret;
    }

    public void exportarObjetoEventoTexto(String path) {
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
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }

    public static void exportarColeccionDeObjetosEventoTexto(String path) {
        ArrayList<Evento> coleccion;
        coleccion = Evento.convertir(Utilidades.EVENTOS);
        File fichero = new File(path);
        FileWriter escritor = null;
        PrintWriter buffer = null;
        try {
            try {
                escritor = new FileWriter(fichero, true);
                buffer = new PrintWriter(escritor);
                for (Evento e : coleccion) {
                    buffer.print(e.data() + "\n");
                }
            } finally {
                if (buffer != null) {
                    buffer.close();
                }
                if (escritor != null) {
                    escritor.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }

    public void exportarEventoaArchivoBinario(String path) {
        try {
            FileOutputStream fichero = new FileOutputStream(path, true);
            ObjectOutputStream evento = new ObjectOutputStream(fichero);
            evento.writeObject(this);
            evento.flush();
            evento.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }

    public static void exportarColeccionEventoaArchivoBinario(String path) {
        ArrayList<Evento> coleccion;
        coleccion = Evento.convertir(Utilidades.EVENTOS);
        try {
            FileOutputStream fichero = new FileOutputStream(path, true);
            ObjectOutputStream escritor = new ObjectOutputStream(fichero);
            escritor.writeObject(coleccion);
            escritor.flush();
            escritor.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }

    public static ArrayList<Evento> importarEventoDesdeFicheroTexto(String path) {
        ArrayList<Evento> ret = new ArrayList<Evento>();
        FileReader inputStream = null;
        BufferedReader lector = null;
        try {
            try {
                inputStream = new FileReader(path);
                lector = new BufferedReader(inputStream);
                Evento e;
                while (lector.ready()) {
                    String cadena = lector.readLine();
                    if (cadena.isEmpty() == false) {
                        String[] parametros = cadena.split("\\|");
                        e = new Evento(Integer.valueOf(parametros[0]), parametros[1]);
                        ret.add(e);
                    }
                }
            } finally {
                if (lector != null) {
                    lector.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (EOFException e) {
            System.out.println("Final de fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
        return ret;
    }

    public static ArrayList<Evento> importarEventoDesdeFicheroBinario(String path) {
        ArrayList<Evento> ret = new ArrayList<Evento>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try {
            try {
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Evento e;
                while ((e = (Evento) lectorObjeto.readObject()) != null) {
                    ret.add(e);

                }
            } finally {
                if (lectorObjeto != null) {
                    lectorObjeto.close();
                }
                if (lector != null) {
                    lector.close();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (EOFException e) {
            System.out.println("Final de fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (ClassNotFoundException e) {
            System.out.println("No se ha encontrado la clase a la cual haces referencia");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
        return ret;
    }

    public static ArrayList<Evento> buscarPorIDEnFicheroDeTexto(String path) {
        ArrayList<Evento> ret = new ArrayList<Evento>();
        FileReader inputStream = null;
        BufferedReader lector = null;
        try {
            try {
                inputStream = new FileReader(path);
                lector = new BufferedReader(inputStream);
                Evento e;
                while (lector.ready()) {
                    String cadena = lector.readLine();
                    if (cadena.isEmpty() == false) {
                        String[] parametros = cadena.split("\\|");
                        e = new Evento(Integer.valueOf(parametros[0]), parametros[1]);
                        ret.add(e);
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
                for (Evento ev : ret) {
                    if (ev.getId() == idBuscar) {
                        System.out.println(ev.data());
                        break;
                    }
                }
            } finally {
                if (lector != null) {
                    lector.close();
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("El carácter introducido no es un entero");
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (EOFException e) {
            System.out.println("Final de fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
        return ret;
    }

    /**
     * Devuelve primero la primary key, seguido de los demas atributos separados
     * por el caracter |
     *
     * @return Primary key id | Fechallegada + ArrayList de elementos +
     * idProveedor
     */
    public String data() {
        return id + "|" + nombre + "|" + fechayhora + "|" + idPenalizacion;
    }
}
