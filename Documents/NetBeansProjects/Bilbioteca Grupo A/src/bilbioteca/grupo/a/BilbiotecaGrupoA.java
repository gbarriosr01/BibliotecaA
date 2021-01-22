/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilbioteca.grupo.a;

import Entidades.Socio;
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
             Socio s1 = new Socio().nuevoSocio();
             System.out.println(s1.nuevoSocio());
        
             
     //MENU PRINCIPAL DE AQUI HASTA ABAJO        
             int opcion = -1;
        Scanner in = new Scanner(System.in);

        do {
            mostrarMenuPrincipal();
            opcion = in.nextInt();
            if (opcion < 0 || opcion > 3) {
                System.out.println("Opción incorrecta!");
                continue;
            }
            switch (opcion) {
                case 1: //se ha pulsado la opcion Gestion de Socios
                    break;
                case 2: //se ha pulsado la opcion Gestion de elementos
                    break;
                case 3: //se ha pulsado la opcion Gestion de eventos
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


