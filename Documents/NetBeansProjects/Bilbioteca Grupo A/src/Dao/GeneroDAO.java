/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import BibliotecaBD.BibliotecaBD;
import Entidades.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase de acceso a Datos para la entidad Genero
 *
 * @author DAM102
 */
public class GeneroDAO {

    private Genero l;
    private static Connection conn;

    public GeneroDAO() {
        conn = BibliotecaBD.establecerConexion();
    }

    public GeneroDAO(Genero gen) {
        this.l = gen;
        conn = BibliotecaBD.establecerConexion();
    }
    
    public ArrayList<Genero> todosGeneros() {
        ArrayList<Genero> todosGeneros= new ArrayList<Genero>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM generos");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    long id = prs.getLong("id");
                    String nombre = prs.getString("nombre");
                   
                    Genero gen = new Genero(id, nombre);
                    todosGeneros.add(gen);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todosGeneros;
    }
    
     public static Genero buscarGeneroById(long idGenero) {
        Genero genero = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM generos WHERE id = ?");
                pstmt.setString(1, String.valueOf(idGenero));
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("id");
                    String nombre = prs.getString("nombre");
                   
                    genero= new Genero(id, nombre);
                }
                prs.close();
                pstmt.close();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return genero;
    }
     
     public static void eliminarGenero(long idGenero) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM genero WHERE id = ?");
                pstmt.setString(1, String.valueOf(idGenero));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado el genero de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado el genero de la BD.");
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     
     //FILTRAR -- SELECT
      public ArrayList<Genero> filtrarGeneroPorNombre(String nombre) {
        ArrayList<Genero> generos = new ArrayList<Genero>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * FROM generos WHERE nombre LIKE '" + nombre + "'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nom = rs.getString("nombre");
                   
                    Genero g = new Genero(id, nom);
                    generos.add(g);
                }
                rs.close();
                stmt.close();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return generos;
    }
      //VER
      public void verDetallesGenero(Genero g) {
        System.out.println("DETALLES de Genero");
        System.out.println("------------------------");
        System.out.println("ID: " + g.getId());
        System.out.println("NOMBRE: " + g.getNombre());
        
        System.out.println("------------------------");
    }
      
       public static void modificarGenero(Genero g) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                String nombre = g.getNombre();

                String sql = "UPDATE genero SET ";
                sql += "nombre='" + nombre + "'";

                sql += " WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(g.getId()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

        public static Genero insertarGenero(Genero g) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;

                String nombre = g.getNombre();

                String sql = "INSERT INTO genero(nombre) VALUES('" + nombre + "')";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

                //Se recupera de la BD el registro recien insertado;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM genero WHERE ";
                sqlRec += " nombre='" + nombre + "'";
                sqlRec += " ORDER BY id DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    long id = rs.getLong("id");
                    nombre = rs.getString("nombre");
                    g = new Genero(id, nombre);
                    return g;
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
                g = null;
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(GeneroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return g;
    }
      

    
    
    
    
}
