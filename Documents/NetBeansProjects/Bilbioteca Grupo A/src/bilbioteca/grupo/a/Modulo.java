/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bilbioteca.grupo.a;
import BibliotecaBD.*;
import Dao.SocioDAO;
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
    
    ArrayList<Socio> si = new ArrayList<>();
    Socio soc = new Socio(1,"Jose luis","63","84","no");
    
    SocioDAO socioDAO = new SocioDAO();
    
    
        socioDAO.modificarSocio(soc);
        

    }
    
            
            
    
    
    
    
}
