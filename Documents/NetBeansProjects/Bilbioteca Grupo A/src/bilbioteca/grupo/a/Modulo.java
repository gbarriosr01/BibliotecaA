/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilbioteca.grupo.a;
import BibliotecaBD.*;
import Dao.ElementoDAO;
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
public class Modulo {
    //Aqui metemos biende funciones del main para que nos quede biende bien gucci, incremen
    //asi te quedas satisfacidox
    public static void main(String[] args){
    Elemento el = new Elemento(1,1,1);
    
    ArrayList <Elemento> listaElementos = new ArrayList<>();
    
    ElementoDAO elementoDAO = new ElementoDAO();
    
    listaElementos = elementoDAO.todosElemento();
    }
    
            
            
    
    
    
    
}
