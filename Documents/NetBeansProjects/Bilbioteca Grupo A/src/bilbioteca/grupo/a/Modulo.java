/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilbioteca.grupo.a;
import BibliotecaBD.*;
import Dao.*;
import Entidades.*;
import Validaciones.ConcursoException;
import Validaciones.CursoException;
import Validaciones.DVDException;
import Validaciones.LecturaException;
import Validaciones.LibroException;
import Validaciones.SocioException;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DAM102
 */
public class Modulo {
    //Aqui metemos biende funciones del main para que nos quede biende bien gucci, incremen
    //asi te quedas satisfacidox
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    public static void main(String[] args){
    Elemento el = new Elemento(1,1,1);
    
    ArrayList<Socio> si = new ArrayList<>();
    
    Socio soc= new Socio(1, "Jose luis", "12", "1", "si");
    
    SocioDAO socDao = new SocioDAO();
    
    Socio so = SocioDAO.insertarSocio(soc);
    
    Prestamo pre = new Prestamo(1,Date.valueOf(LocalDate.parse("04/24/2021", dateFormatter)), Date.valueOf(LocalDate.parse("04/28/2021", dateFormatter)), 1, 1);
    
    PrestamoDAO preDAO = new PrestamoDAO();
    
        Prestamo pr = preDAO.insertarPrestamo(pre);
        
        System.out.println(pr);
        
      Estanteria est = new Estanteria(9, 'C', "Viva espania", true);
      
      EstanteriaDAO estDAO = new EstanteriaDAO();
      
      Estanteria esta = estDAO.insertarEstanteria(est);

        System.out.println(esta);
        
    Evento eve = new Evento(2,"Jose Luis", Date.valueOf(LocalDate.parse("04/28/2021", dateFormatter)), 1);
    
    EventoDAO eveDAO = new EventoDAO();
    
        Evento ev = eveDAO.insertarEvento(eve);
        
        System.out.println(ev);
        
    }
    
            
            
    
    
    
    
}
