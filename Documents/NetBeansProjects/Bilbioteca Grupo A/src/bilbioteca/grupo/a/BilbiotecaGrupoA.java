/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilbioteca.grupo.a;

import Entidades.*;
import java.util.Scanner;



/**
 *
 * @author DAM102
 */
public class BilbiotecaGrupoA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Socio s1 = new Socio().nuevoSocio();
//        System.out.println(s1.nuevoSocio());

        //MENU PRINCIPAL DE AQUI HASTA ABAJO        
        int opcion = -1;
        int opcion2 = -1;
        int opcion3 = -1;
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
                                do {
                                   
                                    System.out.println("-------------------------------------------------");
                                    System.out.println("Pulse 0 para salir");
                                    in = new Scanner(System.in);
                                    opcion3 = in.nextInt();
                                    if (opcion3 !=0) {
                                        System.out.println("Pulse 0 para salir");
                                        continue;
                                    }
                                } while (opcion3 != 0);
                                break;
                            case 2://Nuevo Socio
                                System.out.println("-------------------------------------------------");
                                System.out.println("Ha pulsado la opcion Nuevo Socio");
                                do {

                                    Socio soc = new Socio().nuevoSocio();
                                    System.out.println("-------------------------------------------------");
                                    System.out.println("Pulse 0 para salir");
                                    System.out.println("-------------------------------------------------");
                                    in = new Scanner(System.in);
                                    opcion3 = in.nextInt();
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
                        }
                    } while (opcion2 != 0);

                    break;
                case 2: //se ha pulsado la opcion Gestion de elementos
                    System.out.println("-------------------------------------------------");
                    System.out.println("Ha pulsado la opcion Gestion de elementos");

                    do {
                        mostrarMenuGestionElemetos();
                        in = new Scanner(System.in);
                        opcion2 = in.nextInt();
                        if (opcion2 < 0 || opcion2 > 4) {
                            System.out.println("Opción incorrecta!");
                            continue;
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


