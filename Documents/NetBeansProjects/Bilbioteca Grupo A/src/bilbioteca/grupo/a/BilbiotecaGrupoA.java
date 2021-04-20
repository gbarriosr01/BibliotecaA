/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilbioteca.grupo.a;
import BibliotecaBD.*;
import Entidades.*;
import Validaciones.ConcursoException;
import Validaciones.CursoException;
import Validaciones.DVDException;
import Validaciones.LecturaException;
import Validaciones.LibroException;
import Validaciones.SocioException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAM102
 */
public class BilbiotecaGrupoA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
//        Socio s1 = new Socio().nuevoSocio();
//        System.out.println(s1.nuevoSocio());
        ArrayList<Socio> socios = Socio.convertirSocios(Utilidades.SOCIOS);
        ArrayList<DVD> DVDS = DVD.convertirDVDS(Utilidades.DVDS);
        ArrayList<Libro> libros = Libro.convertirLibros(Utilidades.LIBROS);
        ArrayList<Concurso> concursos = Concurso.convertirConcurso(Utilidades.CONCURSOS);
        ArrayList<Curso> cursos = Curso.convertirCurso(Utilidades.CURSOS);
        ArrayList<Lectura> lecturas = Lectura.convertirLectura(Utilidades.LECTURAS);
        ArrayList<Visionado> visionados = Visionado.convertirVisionado(Utilidades.VISIONADOS);
        //MENU PRINCIPAL DE AQUI HASTA ABAJO

        Connection conn = BibliotecaBD.establecerConexion();
        BibliotecaBD.cerrarConexion();
        
        int opcion = -1;
        int opcion2 = -1;
        int opcion3 = -1;

        int idSocio;
        Socio s;

        Scanner in = new Scanner(System.in);

        do {
            System.out.println("-------------------------------------------------");
            mostrarMenuPrincipal();
            System.out.println("-------------------------------------------------");
            opcion = in.nextInt();
            if (opcion < 0 || opcion > 3) {
                System.out.println("Opción incorrecta!");
                continue;
            }
            switch (opcion) {
                case 1: //se ha pulsado la opcion Gestion de Socios
                    System.out.println("-------------------------------------------------");
                    System.out.println("Ha pulsado la opcion Gestion de Socios");

                    do {
                        System.out.println("-------------------------------------------------");
                        mostrarMenuGestionSocios();
                        System.out.println("-------------------------------------------------");
                        in = new Scanner(System.in);
                        opcion2 = in.nextInt();
                        if (opcion2 < 0 || opcion2 > 3) {
                            System.out.println("Opción incorrecta!");
                            continue;
                        }
                        switch (opcion2) {
                            case 1:// Ver socio
                                System.out.println("-------------------------------------------------");
                                System.out.println("Ha pulsado la opcion Ver Socio");
                                Socio.verSocio(socios);
                                in = new Scanner(System.in);
                                idSocio = in.nextInt();
                                if (idSocio != 0) {
                                    s = Socio.buscarSociosPorId(idSocio, socios);
                                    if (s != null) {
                                        System.out.println("Socio encontrado: ");
                                        s.verDatosSocioCompleto();
                                    } else {
                                        System.out.println("Socio de ID = " + idSocio + " no encontrado");
                                    }
                                }
                                do {

                                    System.out.println("-------------------------------------------------");
                                    System.out.println("Pulse 0 para salir");
                                    in = new Scanner(System.in);
                                    opcion3 = in.nextInt();
                                    if (opcion3 != 0) {
                                        System.out.println("Pulse 0 para salir");
                                        continue;
                                    }
                                } while (opcion3 != 0);
                                break;
                            case 2://Nuevo Socio
                                System.out.println("-------------------------------------------------");
                                System.out.println("Ha pulsado la opcion Nuevo Socio");
                                do {
                                    Socio nuevoSocio;
                                    try {
                                        nuevoSocio = Socio.nuevoSocio();
                                        socios.add(nuevoSocio);
                                    } catch (SocioException ex) {
                                        System.out.println("Dato invalido");
                                    }

                                    do {
                                        System.out.println("-------------------------------------------------");
                                        System.out.println("Pulse 0 para salir");
                                        System.out.println("-------------------------------------------------");

                                        in = new Scanner(System.in);
                                        opcion3 = in.nextInt();
                                        if (opcion3 != 0) {
                                            continue;
                                        }
                                    } while (opcion3 != 0);

                                } while (opcion3 != 0);
                                break;
                            case 3://Buscar Socio
                                System.out.println("-------------------------------------------------");
                                System.out.println("Ha pulsado la opcion Buscar Socio");
                                Socio.buscarSocios(socios);

                        }
                    } while (opcion2 != 0);

                    break;
                case 2: //se ha pulsado la opcion Gestion de elementos
                    System.out.println("-------------------------------------------------");
                    System.out.println("Ha pulsado la opcion Gestion de elementos");
                    System.out.println("-------------------------------------------------");

                    do {
                        mostrarMenuGestionElemetos();
                        in = new Scanner(System.in);
                        opcion2 = in.nextInt();
                        if (opcion2 < 0 || opcion2 > 4) {
                            System.out.println("Opción incorrecta!");
                            continue;
                        }
                        switch (opcion2) {
                            case 1://Ver Elemento
                                System.out.println("-------------------------------------------------");
                                System.out.println("Ha pulsado la opcion Ver Elemento");
                                System.out.println("-------------------------------------------------");
                                do {
                                    System.out.println("-------------------------------------------------");
                                    System.out.println("1.-Ver DVDs");
                                    System.out.println("2.-Ver Libros");
                                    System.out.println("0.-Volver");
                                    System.out.println("-------------------------------------------------");
                                    opcion3 = in.nextInt();
                                    if (opcion3 < 0 || opcion3 > 2) {
                                        System.out.println("-------------------------------------------------");
                                        System.out.println("Opción incorrecta!");

                                        continue;
                                    }

                                    switch (opcion3) {
                                        case 1:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Ver DVDs");
                                            System.out.println("-------------------------------------------------");
                                            DVD.verDvd(DVDS);
                                            do {

                                                System.out.println("-------------------------------------------------");
                                                System.out.println("Pulse 0 para salir");
                                                in = new Scanner(System.in);
                                                opcion3 = in.nextInt();
                                                if (opcion3 != 0) {
                                                    System.out.println("Pulse 0 para salir");
                                                    continue;
                                                }
                                            } while (opcion3 != 0);
                                            break;
                                        case 2:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Ver libros");
                                            System.out.println("-------------------------------------------------");
                                            Libro.verLibro(libros);
                                            do {

                                                System.out.println("-------------------------------------------------");
                                                System.out.println("Pulse 0 para salir");
                                                in = new Scanner(System.in);
                                                opcion3 = in.nextInt();
                                                if (opcion3 != 0) {
                                                    System.out.println("Pulse 0 para salir");
                                                    continue;
                                                }
                                            } while (opcion3 != 0);
                                            break;

                                        default:
                                            break;
                                    }
                                } while (opcion3 != 0);
                                break;

                            case 2:
                                // Nuevo Elemento
                                System.out.println("-------------------------------------------------");
                                System.out.println("Ha pulsado la opcion Nuevo Elemento");
                                System.out.println("-------------------------------------------------");
                                do {
                                    System.out.println("-------------------------------------------------");
                                    System.out.println("1.-Nuevo DVDs");
                                    System.out.println("2.-Nuevo Libros");
                                    System.out.println("0.-Volver");
                                    System.out.println("-------------------------------------------------");
                                    opcion3 = in.nextInt();
                                    if (opcion3 < 0 || opcion3 > 2) {
                                        System.out.println("-------------------------------------------------");
                                        System.out.println("Opción incorrecta!");

                                        continue;
                                    }
                                    switch (opcion3) {
                                        case 1:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Nuevo DVDs");
                                            System.out.println("-------------------------------------------------");
                                            do {
                                        try {
                                            DVD nuevoDVD = DVD.nuevoDVD();
                                            DVDS.add(nuevoDVD);
                                            do {
                                                System.out.println("-------------------------------------------------");
                                                System.out.println("Pulse 0 para salir");
                                                System.out.println("-------------------------------------------------");
                                                
                                                in = new Scanner(System.in);
                                                opcion3 = in.nextInt();
                                                if (opcion3 != 0) {
                                                    continue;
                                                }
                                            } while (opcion3 != 0);
                                        } catch (DVDException ex) {
                                            System.out.println("Se ha producido una DVDException, " + ex.getMessage());
                                        }

                                            } while (opcion3 != 0);
                                            break;
                                        case 2:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Nuevo Libro");
                                            System.out.println("-------------------------------------------------");
                                            do {
                                        try {
                                            Libro nuevoLibro = Libro.nuevoLibro();
                                            libros.add(nuevoLibro);
                                            do {
                                                System.out.println("-------------------------------------------------");
                                                System.out.println("Pulse 0 para salir");
                                                System.out.println("-------------------------------------------------");
                                                
                                                in = new Scanner(System.in);
                                                opcion3 = in.nextInt();
                                                if (opcion3 != 0) {
                                                    continue;
                                                }
                                            } while (opcion3 != 0);
                                        } catch (LibroException ex) {
                                            System.out.println("Se ha producido una LibroException, " + ex.getMessage());
                                        }

                                            } while (opcion3 != 0);
                                            break;

                                    }

                                } while (opcion3 != 0);
                                break;
                            case 3:  //Buscar Elemento                              
                                System.out.println("-------------------------------------------------");
                                System.out.println("¿Que elemento desea buscar?");
                                do {
                                    System.out.println("-------------------------------------------------");
                                    System.out.println("1.- DVDs");
                                    System.out.println("2.- libros");
                                    System.out.println("0.-Volver");
                                    System.out.println("-------------------------------------------------");
                                    opcion3 = in.nextInt();
                                    if (opcion3 < 0 || opcion3 > 2) {
                                        System.out.println("-------------------------------------------------");
                                        System.out.println("Opción incorrecta!");

                                        continue;
                                    }
                                    switch (opcion3) {
                                        case 1:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Buscar DVDs");
                                            System.out.println("-------------------------------------------------");
                                            do {
                                                // Funcion BuscarDVDs
                                                DVD.buscarDVDs(DVDS);
                                                do {
                                                    System.out.println("-------------------------------------------------");
                                                    System.out.println("Pulse 0 para salir");
                                                    System.out.println("-------------------------------------------------");

                                                    in = new Scanner(System.in);
                                                    opcion3 = in.nextInt();
                                                    if (opcion3 != 0) {
                                                        continue;
                                                    }
                                                } while (opcion3 != 0);

                                            } while (opcion3 != 0);
                                            break;

                                        case 2:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Buscar Libros");
                                            System.out.println("-------------------------------------------------");
                                            do {
                                                // Funcion BuscarLibros
                                                Libro.buscarLibros(libros);
                                                do {
                                                    System.out.println("-------------------------------------------------");
                                                    System.out.println("Pulse 0 para salir");
                                                    System.out.println("-------------------------------------------------");

                                                    in = new Scanner(System.in);
                                                    opcion3 = in.nextInt();
                                                    if (opcion3 != 0) {
                                                        continue;
                                                    }
                                                } while (opcion3 != 0);

                                            } while (opcion3 != 0);
                                            break;

                                    }
                                    while (opcion3 != 0);

                                } while (opcion3 != 0);
                                break;
                        }

                    } while (opcion2 != 0);

                    break;
                case 3: //se ha pulsado la opcion Gestion de eventos
                    System.out.println("-------------------------------------------------");
                    System.out.println("Ha pulsado la opcion Gestion de eventos");

                    do {
                        mostrarMenuGestionEventos();
                        in = new Scanner(System.in);
                        opcion2 = in.nextInt();
                        if (opcion2 < 0 || opcion2 > 4) {
                            System.out.println("Opción incorrecta!");
                            continue;
                        }
                        switch (opcion2) {

                            case 1:
                                System.out.println("-------------------------------------------------");
                                System.out.println("Ha pulsado la opcion Ver Evento");
                                // Opcion Ver Evento

                                do {
                                    System.out.println("-------------------------------------------------");
                                    System.out.println("1.-Ver Concursos");
                                    System.out.println("2.-Ver Cursos");
                                    System.out.println("3.-Ver Lecturas");
                                    System.out.println("4.-Ver Visionados");
                                    System.out.println("0.-Volver");
                                    System.out.println("-------------------------------------------------");
                                    opcion3 = in.nextInt();
                                    if (opcion3 < 0 || opcion3 > 4) {
                                        System.out.println("-------------------------------------------------");
                                        System.out.println("Opción incorrecta!");

                                        continue;
                                    }
                                    switch (opcion3) {
                                        case 1:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Ver Concursos");
                                            System.out.println("-------------------------------------------------");
                                            //Funcion VerConcursos
                                            Concurso.verConcurso(concursos);
                                            do {

                                                System.out.println("-------------------------------------------------");
                                                System.out.println("Pulse 0 para salir");
                                                in = new Scanner(System.in);
                                                opcion3 = in.nextInt();
                                                if (opcion3 != 0) {
                                                    System.out.println("Pulse 0 para salir");
                                                    continue;
                                                }
                                            } while (opcion3 != 0);
                                            break;
                                        case 2:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Ver Cursos");
                                            System.out.println("-------------------------------------------------");
                                            //Funcion Ver Cursos
                                            Curso.verCurso(cursos);
                                            do {

                                                System.out.println("-------------------------------------------------");
                                                System.out.println("Pulse 0 para salir");
                                                in = new Scanner(System.in);
                                                opcion3 = in.nextInt();
                                                if (opcion3 != 0) {
                                                    System.out.println("Pulse 0 para salir");
                                                    continue;
                                                }
                                            } while (opcion3 != 0);
                                            break;
                                        case 3:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Ver Lecturas");
                                            System.out.println("-------------------------------------------------");
                                            //Funcion VerLecturas
                                            Lectura.verLectura(lecturas);
                                            do {

                                                System.out.println("-------------------------------------------------");
                                                System.out.println("Pulse 0 para salir");
                                                in = new Scanner(System.in);
                                                opcion3 = in.nextInt();
                                                if (opcion3 != 0) {
                                                    System.out.println("Pulse 0 para salir");
                                                    continue;
                                                }
                                            } while (opcion3 != 0);
                                            break;
                                        case 4:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Ver Visionados");
                                            System.out.println("-------------------------------------------------");
                                            //Funcion VerVisionados
                                            Visionado.verVisionado(visionados);
                                            do {

                                                System.out.println("-------------------------------------------------");
                                                System.out.println("Pulse 0 para salir");
                                                in = new Scanner(System.in);
                                                opcion3 = in.nextInt();
                                                if (opcion3 != 0) {
                                                    System.out.println("Pulse 0 para salir");
                                                    continue;
                                                }
                                            } while (opcion3 != 0);
                                            break;

                                        default:
                                            break;
                                    }
                                } while (opcion3 != 0);
                                break;
                            case 2:
                                System.out.println("-------------------------------------------------");
                                System.out.println("Ha pulsado la opcion Nuevo Evento");
                                // Opcion Nuevo Evento
                                do {
                                    System.out.println("-------------------------------------------------");
                                    System.out.println("1.-Nuevo Concurso");
                                    System.out.println("2.-Nuevo Curso");
                                    System.out.println("3.-Nueva Lectura");
                                    System.out.println("4.-Nuevo Visionado");
                                    System.out.println("0.-Volver");
                                    System.out.println("-------------------------------------------------");
                                    opcion3 = in.nextInt();
                                    if (opcion3 < 0 || opcion3 > 4) {
                                        System.out.println("-------------------------------------------------");
                                        System.out.println("Opción incorrecta!");

                                        continue;
                                    }
                                    switch (opcion3) {
                                        case 1:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Nuevo Concurso");
                                            System.out.println("-------------------------------------------------");
                                            do {
                                                //Nuevo Concurso
                                                
                                        try {
                                            Concurso nuevoConcurso = Concurso.nuevoConcurso();
                                            concursos.add(nuevoConcurso);
                                        } catch (ConcursoException ex) {
                                            System.out.println("Algo ha ido mal...");
                                        }
                                                
                                                do {
                                                    System.out.println("-------------------------------------------------");
                                                    System.out.println("Pulse 0 para salir");
                                                    System.out.println("-------------------------------------------------");

                                                    in = new Scanner(System.in);
                                                    opcion3 = in.nextInt();
                                                    if (opcion3 != 0) {
                                                        continue;
                                                    }
                                                } while (opcion3 != 0);

                                            } while (opcion3 != 0);
                                            break;
                                        case 2:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Nuevo Curso");
                                            System.out.println("-------------------------------------------------");
                                            do {
                                                //Nuevo Curso
                                                
                                        try {
                                            Curso nuevoCurso = Curso.nuevoCurso();
                                            cursos.add(nuevoCurso);
                                        } catch (CursoException ex) {
                                            System.out.println("Algo ha ido mal...");
                                        }
                                                
                                                do {
                                                    System.out.println("-------------------------------------------------");
                                                    System.out.println("Pulse 0 para salir");
                                                    System.out.println("-------------------------------------------------");

                                                    in = new Scanner(System.in);
                                                    opcion3 = in.nextInt();
                                                    if (opcion3 != 0) {
                                                        continue;
                                                    }
                                                } while (opcion3 != 0);

                                            } while (opcion3 != 0);
                                            break;
                                        case 3:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Nueva Lectura");
                                            System.out.println("-------------------------------------------------");
                                            do {
                                                //Nueva Lectura
                                                
                                        try {
                                            Lectura nuevoLectura = Lectura.nuevoLectura();
                                            lecturas.add(nuevoLectura);
                                        } catch (LecturaException ex) {
                                            System.out.println("Algo ha ido mal...");
                                        }
                                                
                                                do {
                                                    System.out.println("-------------------------------------------------");
                                                    System.out.println("Pulse 0 para salir");
                                                    System.out.println("-------------------------------------------------");

                                                    in = new Scanner(System.in);
                                                    opcion3 = in.nextInt();
                                                    if (opcion3 != 0) {
                                                        continue;
                                                    }
                                                } while (opcion3 != 0);

                                            } while (opcion3 != 0);
                                            break;
                                        case 4:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Nuevo Visionado");
                                            System.out.println("-------------------------------------------------");
                                            do {
                                                //Nuevo visionado
                                                
                                        try {
                                            Visionado nuevoVisionado = Visionado.nuevoVisionado();
                                            visionados.add(nuevoVisionado);
                                        } catch (LecturaException ex) {
                                            System.out.println("Algo ha ido mal...");
                                        }
                                                
                                                do {
                                                    System.out.println("-------------------------------------------------");
                                                    System.out.println("Pulse 0 para salir");
                                                    System.out.println("-------------------------------------------------");

                                                    in = new Scanner(System.in);
                                                    opcion3 = in.nextInt();
                                                    if (opcion3 != 0) {
                                                        continue;
                                                    }
                                                } while (opcion3 != 0);

                                            } while (opcion3 != 0);
                                            break;
                                    }
                                    while (opcion3 != 0);
                                    break;
                                } while (opcion3 != 0);
                                break;

                            case 3:
                                System.out.println("-------------------------------------------------");
                                System.out.println("Ha pulsado la opcion Buscar Evento");
                                // Opcion Buscar Evento
                                do {
                                    System.out.println("-------------------------------------------------");
                                    System.out.println("1.- Buscar Concurso");
                                    System.out.println("2.- Buscar Curso");
                                    System.out.println("3.- Buscar Lectura");
                                    System.out.println("4.- Buscar Visionado");
                                    System.out.println("0.-Volver");
                                    System.out.println("-------------------------------------------------");
                                    opcion3 = in.nextInt();
                                    if (opcion3 < 0 || opcion3 > 4) {
                                        System.out.println("-------------------------------------------------");
                                        System.out.println("Opción incorrecta!");

                                        continue;
                                    }
                                    switch (opcion3) {
                                        case 1:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Buscar Concurso");
                                            System.out.println("-------------------------------------------------");
                                            do {
                                                Concurso.buscarConcurso(concursos);

                                                do {
                                                    System.out.println("-------------------------------------------------");
                                                    System.out.println("Pulse 0 para salir");
                                                    System.out.println("-------------------------------------------------");

                                                    in = new Scanner(System.in);
                                                    opcion3 = in.nextInt();
                                                    if (opcion3 != 0) {
                                                        continue;
                                                    }
                                                } while (opcion3 != 0);

                                            } while (opcion3 != 0);
                                            break;
                                        case 2:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Buscar Curso");
                                            System.out.println("-------------------------------------------------");
                                            do {
                                                Curso.buscarCurso(cursos);

                                                do {
                                                    System.out.println("-------------------------------------------------");
                                                    System.out.println("Pulse 0 para salir");
                                                    System.out.println("-------------------------------------------------");

                                                    in = new Scanner(System.in);
                                                    opcion3 = in.nextInt();
                                                    if (opcion3 != 0) {
                                                        continue;
                                                    }
                                                } while (opcion3 != 0);

                                            } while (opcion3 != 0);
                                            break;
                                        case 3:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Buscar Lectura");
                                            System.out.println("-------------------------------------------------");
                                            do {
                                                Lectura.buscarLectura(lecturas);

                                                do {
                                                    System.out.println("-------------------------------------------------");
                                                    System.out.println("Pulse 0 para salir");
                                                    System.out.println("-------------------------------------------------");

                                                    in = new Scanner(System.in);
                                                    opcion3 = in.nextInt();
                                                    if (opcion3 != 0) {
                                                        continue;
                                                    }
                                                } while (opcion3 != 0);

                                            } while (opcion3 != 0);
                                            break;
                                        case 4:
                                            System.out.println("-------------------------------------------------");
                                            System.out.println("Ha pulsado la opcion Buscar Visionado");
                                            System.out.println("-------------------------------------------------");
                                            do {
                                                Visionado.buscarVisionado(visionados);

                                                do {
                                                    System.out.println("-------------------------------------------------");
                                                    System.out.println("Pulse 0 para salir");
                                                    System.out.println("-------------------------------------------------");

                                                    in = new Scanner(System.in);
                                                    opcion3 = in.nextInt();
                                                    if (opcion3 != 0) {
                                                        continue;
                                                    }
                                                } while (opcion3 != 0);

                                            } while (opcion3 != 0);
                                            break;

                                    }
                                    while (opcion3 != 0);
                                    break;
                                } while (opcion3 != 0);
                                break;

                            case 4:
                                System.out.println("-------------------------------------------------");
                                System.out.println("Ha pulsado la opcion Participar en Evento");
                            // Opcion Participar en Evento
                        }

                    } while (opcion2 != 0);

                    break;
                case 0: //se ha pulsado Salir
                    continue;
                default: //opcion incorrecta   
            }
            opcion = -1;
        } while (opcion < 0 || opcion > 3);

    }

    private static void mostrarMenuPrincipal() {
        System.out.println("Pulse 1 para Gestionar los Socios");
        System.out.println("Pulse 2 para Gestionar Elementos");
        System.out.println("Pulse 3 para Gestionar Eventos");
        System.out.println("Pulse 0 para SALIR");
    }

    private static void mostrarMenuGestionSocios() {
        System.out.println("Pulse 1 para Ver Socio");
        System.out.println("Pulse 2 para Nuevo Socio");
        System.out.println("Pulse 3 para Buscar Socio");
        System.out.println("Pulse 0 para Volver");
    }

    private static void mostrarMenuGestionElemetos() {
        System.out.println("Pulse 1 para Ver Elemento");
        System.out.println("Pulse 2 para Nuevo Elemento");
        System.out.println("Pulse 3 para Buscar Elemento");
        System.out.println("Pulse 4 para Hacer Préstamo");
        System.out.println("Pulse 0 para Volver");
    }

    private static void mostrarMenuGestionEventos() {
        System.out.println("Pulse 1 para Ver Evento");
        System.out.println("Pulse 2 para Nuevo Evento");
        System.out.println("Pulse 3 para Buscar Eventos");
        System.out.println("Pulse 4 para Participar en Evento");
        System.out.println("Pulse 0 para Volver");
    }

}
