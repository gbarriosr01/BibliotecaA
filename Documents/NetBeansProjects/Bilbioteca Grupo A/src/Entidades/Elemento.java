/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Validaciones.ElementoException;
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
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author DAM102
 */
public class Elemento implements Serializable {

    static final long serialVersionUID = 1L;
    /*Valido: >0 Invalido: <=0 Otros: Es unico*/
    protected long id;
    protected ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();/*Obligatorio*/
    protected Genero genero;/*Obligatorio*/
    protected long idGenero;/*Obligatorio*/
    protected long idLote;/*Obligatorio*/
    protected long idEstanteria;/*Obligatorio*/
    public Elemento() {
    }

//    public Elemento(long id, Genero genero) throws ElementoException{
//        if(ElementoException.validarId(id)){
//        this.id = id;
//        }else{
//            throw new ElementoException("El id debe ser >0");
//        }
//        this.genero = genero;
//    }
    public Elemento(long id, Genero genero) {

        this.id = id;

        this.genero = genero;
    }

//    public Elemento(Elemento el) throws ElementoException{
//        if(ElementoException.validarId(el.id)){
//        this.id = el.id;
//        }else{
//            throw new ElementoException("El id debe ser >0");
//        }
//        this.genero = el.genero;
//    }
    public Elemento(Elemento el) {

        this.id = el.id;

        this.genero = el.genero;
    }

    public Elemento(long id, long idGenero, long idLote, long idEstanteria) {

        this.id = id;
        this.idGenero = idGenero;
        this.idLote = idLote;
        this.idEstanteria = idEstanteria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(long idGenero) {
        this.idGenero = idGenero;
    }

    public long getIdLote() {
        return idLote;
    }

    public void setIdLote(long idLote) {
        this.idLote = idLote;
    }

    public long getIdEstanteria() {
        return idEstanteria;
    }

    public void setIdEstanteria(long idEstanteria) {
        this.idEstanteria = idEstanteria;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public static Elemento nuevoElemento() throws ElementoException {
        Elemento el = new Elemento();
        Scanner teclado = new Scanner(System.in);

        int numElementos;
        numElementos = Utilidades.numElementos + 1;
        if (ElementoException.validarId(numElementos)) {
            el.setId(numElementos);
        } else {
            throw new ElementoException("El id debe ser >0");
        }

        System.out.println("Socio registrado correctamente con el id " + numElementos);
        return el;

    }

    //funcion 1 entrada salida
    public void exportarObjetoElementoTexto(String path) {
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

    //Funcion 2 entrada y salida
    public static void exportarColeccionDeObjetosElementoTexto(String path) {
        ArrayList<Elemento> coleccion;
        coleccion = Elemento.convertir(Utilidades.ELEMENTOS);
        File fichero = new File(path);
        FileWriter escritor = null;
        PrintWriter buffer = null;
        try {
            try {
                escritor = new FileWriter(fichero, true);
                buffer = new PrintWriter(escritor);
                for (Elemento e : coleccion) {
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

    //Funcion 3 entrada y salida
    public void exportarElementoArchivoBinario(String path) {
        try {
            FileOutputStream fichero = new FileOutputStream(path, true);
            ObjectOutputStream empleado = new ObjectOutputStream(fichero);
            empleado.writeObject(this);
            empleado.flush();
            empleado.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception e) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }

    //Funcion 4 entrada y salida
    public static void exportarColeccionElementosaArchivoBinario(String path) {
        ArrayList<Elemento> coleccion;
        coleccion = Elemento.convertir(Utilidades.ELEMENTOS);
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

    //Funcion 5 entrada y salida
    public static ArrayList<Elemento> importarEmpleadoDesdeFicheroTexto(String path) {
        ArrayList<Elemento> ret = new ArrayList<Elemento>();
        FileReader inputStream = null;
        BufferedReader lector = null;
        try {
            try {
                inputStream = new FileReader(path);
                lector = new BufferedReader(inputStream);
                Elemento e;
                while (lector.ready()) {
                    String cadena = lector.readLine();
                    if (cadena.isEmpty() == false) {
                        String[] parametros = cadena.split("\\|");
                        e = new Elemento(Long.parseLong(parametros[0]), Long.parseLong(parametros[1]), Long.parseLong(parametros[2]), Long.parseLong(parametros[3]));
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

    //Funcion 6 entrada y salida
    public static ArrayList<Elemento> importarEmpleadoDesdeFicheroBinario(String path) {
        ArrayList<Elemento> ret = new ArrayList<Elemento>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try {
            try {
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Elemento e;
                while ((e = (Elemento) lectorObjeto.readObject()) != null) {
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

    //Funcion 7 entrada y salida
    public static ArrayList<Elemento> buscarPorIDEnFicheroDeTexto(String path) {
        ArrayList<Elemento> ret = new ArrayList<Elemento>();
        FileReader inputStream = null;
        BufferedReader lector = null;
        try {
            try {
                inputStream = new FileReader(path);
                lector = new BufferedReader(inputStream);
                Elemento e;
                while (lector.ready()) {
                    String cadena = lector.readLine();
                    if (cadena.isEmpty() == false) {
                        String[] parametros = cadena.split("\\|");
                        e = new Elemento(Long.parseLong(parametros[0]), Long.parseLong(parametros[1]), Long.parseLong(parametros[2]), Long.parseLong(parametros[3]));
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
                for (Elemento em : ret) {
                    if (em.getId() == idBuscar) {
                        System.out.println(em.data());
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

    public static ArrayList<Elemento> convertir(Elemento[] array) {
        ArrayList<Elemento> ret = new ArrayList<Elemento>();
        for (Elemento e : array) {
            ret.add((Elemento) e);
        }
        return ret;
    }

    @Override
    public String toString() {
        return "Elemento{" + "id=" + id + ", prestamos=" + prestamos + ", genero=" + genero + '}';
    }

    /**
     * Atributos separados por el caracter |
     *
     * @return Primary key id | idGenero
     */
    
     public String data() {
        return id + "|" + idGenero + "|" + idLote + "|" + idEstanteria;
    }

}
