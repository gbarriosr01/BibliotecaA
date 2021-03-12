/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Validaciones.ProveedorException;
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
public class Proveedor implements Serializable{
     static final long serialVersionUID = 1L;

    //Valores válidos,  >0
    //Valores inválidos, <=0
    //Tiene que ser único 
    private long id;
    //Valores válidos,  <=20 caracteres
    //Valores inválidos, >20 caracteres
    //No se admiten números
    private String nombre;
    //Valores válidos,  >=9 numeros
    //Valores inválidos, <9 numeros
    //NO admite letras
    private String telefono;

    public Proveedor() {

    }

    public Proveedor(long id, String nombre, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Proveedor(Proveedor p1) {
        this.id = p1.id;
        this.nombre = p1.nombre;
        this.telefono = p1.telefono;

    }

    Proveedor(long id, long idProveedor) throws ProveedorException {
        if (ProveedorException.validarProveedorId(id)) {
            this.id = id;
        } else {
            throw new ProveedorException("Valor id debe ser > 0");
        }
        if (ProveedorException.validarProveedorNombre(nombre)) {
            this.nombre = nombre;
        } else {
            throw new ProveedorException("Valor Nombre no cumple los requisitos");
        }
        if (ProveedorException.validarProveedorTelefono(telefono)) {
            this.telefono = telefono;
        } else {
            throw new ProveedorException("Valor del telefono incorrecto. Deben ser 9numeros");
        }
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public static ArrayList<Proveedor> convertir(Proveedor[] array) {
        ArrayList<Proveedor> ret = new ArrayList<Proveedor>();
        for (Proveedor p : array) {
            ret.add((Proveedor) p);
        }
        return ret;
    }

    public Proveedor nuevoProveedor() {
        Proveedor p1 = new Proveedor();
        Scanner in = new Scanner(System.in);

        int numProveedores = Utilidades.numProveedores + 1;
        p1.setId(numProveedores);

        System.out.println("Ingrese nombre del proveedor");
        String nombre = in.nextLine();
        p1.setNombre(nombre);
        System.out.println("Ingrese el telefono del proveedor");
        String telefono = in.nextLine();
        p1.setTelefono(telefono);

        return p1;
    }

    public void exportarObjetoProveedorTexto(String path) {
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

    public static void exportarColeccionDeObjetosProveedorTexto(String path) {
        ArrayList<Proveedor> coleccion;
        coleccion = Proveedor.convertir(Utilidades.PROVEEDORES);
        File fichero = new File(path);
        FileWriter escritor = null;
        PrintWriter buffer = null;
        try {
            try {
                escritor = new FileWriter(fichero, true);
                buffer = new PrintWriter(escritor);
                for (Proveedor p : coleccion) {
                    buffer.print(p.data() + "\n");
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

    public void exportarProveedoraArchivoBinario(String path) {
        try {
            FileOutputStream fichero = new FileOutputStream(path, true);
            ObjectOutputStream proveedor = new ObjectOutputStream(fichero);
            proveedor.writeObject(this);
            proveedor.flush();
            proveedor.close();
        } catch (FileNotFoundException s) {
            System.out.println("No se ha encontrado el fichero");
        } catch (IOException s) {
            System.out.println("Se ha producido un error en la inserción de los datos");
        } catch (Exception s) {
            System.out.println("Se ha producido un error inesperado intentelo de nuevo");
        }
    }

    public static void exportarColeccionProveedoraArchivoBinario(String path) {
        ArrayList<Proveedor> coleccion;
        coleccion = Proveedor.convertir(Utilidades.PROVEEDORES);
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

    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + '}';
    }
    
    public static ArrayList<Proveedor> importarProveedorDesdeFicheroTexto(String path) {
        ArrayList<Proveedor> ret = new ArrayList<Proveedor>();
        FileReader inputStream = null;
        BufferedReader lector = null;
        try {
            try {
                inputStream = new FileReader(path);
                lector = new BufferedReader(inputStream);
                Proveedor p;
                while (lector.ready()) {
                    String cadena = lector.readLine();
                    if (cadena.isEmpty() == false) {
                        String[] parametros = cadena.split("\\|");
                        p = new Proveedor(Integer.valueOf(parametros[0]), parametros[1], parametros[2]);
                        ret.add(p);
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
    
    public static ArrayList<Proveedor> importarProveedorDesdeFicheroBinario(String path) {
        ArrayList<Proveedor> ret = new ArrayList<Proveedor>();
        FileInputStream lector = null;
        ObjectInputStream lectorObjeto = null;
        try {
            try {
                lector = new FileInputStream(path);
                lectorObjeto = new ObjectInputStream(lector);
                Proveedor p;
                while ((p = (Proveedor) lectorObjeto.readObject()) != null) {
                    ret.add(p);
                    
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
    
    public static ArrayList<Proveedor> buscarPorIDEnFicheroDeTexto(String path) {
        ArrayList<Proveedor> ret = new ArrayList<Proveedor>();
        FileReader inputStream = null;
        BufferedReader lector = null;
        try {
            try {
                inputStream = new FileReader(path);
                lector = new BufferedReader(inputStream);
                Proveedor p;
                while (lector.ready()) {
                    String cadena = lector.readLine();
                    if (cadena.isEmpty() == false) {
                        String[] parametros = cadena.split("\\|");
                        p = new Proveedor(Integer.valueOf(parametros[0]), parametros[1], parametros[2]);
                        ret.add(p);
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
                for (Proveedor po : ret) {
                    if (po.getId() == idBuscar) {
                        System.out.println(po.data());
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

    /**
     * Devuelve primero la primary key, seguido de los demas atributos separados
     * por el caracter |
     *
     * @return Primary key id | nombre + telefono
     */
    public String data() {
        return id + "|" + nombre + "|" + telefono;
    }
}
