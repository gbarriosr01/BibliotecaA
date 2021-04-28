/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import BibliotecaBD.BibliotecaBD;
import Entidades.Estanteria;
import Entidades.Libro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diegu
 */
public class LibroDAO {
    
    private Libro l;
    private static Connection conn;
    
    public LibroDAO(){
    conn = BibliotecaBD.establecerConexion();
    }
    
    public LibroDAO(Libro li){
    this.l = li;    
    conn = BibliotecaBD.establecerConexion();
    }
    
//    public ArrayList<Libro> todosLibro() {
//        ArrayList<Libro> todosLibro = new ArrayList<Libro>();
//        try {
//            if (conn == null || conn.isClosed()) {
//                conn = BibliotecaBD.establecerConexion();
//            }
//            try {
//                PreparedStatement pstmt = null;
//                pstmt = conn.prepareStatement("SELECT * FROM Libro");
//                ResultSet prs = pstmt.executeQuery();
//                while (prs.next()) {
//                    long id = prs.getInt("idElemento");
//                    String nombre = prs.getString("nombre");
//                    String editorial = prs.getString("editorial");
//                    String autor = prs.getString("autor");
//                    int nPaginas = prs.getInt("nPaginas");
//                    long 
//
//                    Libro li = new Libro(id, nombre, editorial, autor, nPaginas);
//                    todosEstanteria.add(es);
//                }
//            } catch (SQLException ex) {
//                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
//                Logger.getLogger(EstanteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
//            } finally {
//                if (conn != null) {
//                    BibliotecaBD.cerrarConexion();
//                }
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(EstanteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return todosEstanteria;
//    }
//
//    public void modificarEstanteria(Estanteria e) {
//        try {
//            if (conn == null || conn.isClosed()) {
//                conn = BibliotecaBD.establecerConexion();
//            }
//            try {
//                PreparedStatement pstmt = null;
//                char codigo = e.getCodigo();
//                String ubicacion = e.getUbicacion();
//                Boolean completa = e.isCompleta();
//
//                String sql = "UPDATE Estanteria SET ";
//                sql += "codigo=" + codigo;
//                sql += ", ubicacion=" + ubicacion;
//                sql += ", completo=" + completa;
//
//
//                sql += " WHERE id = ?";
//                pstmt = conn.prepareStatement(sql);
//                pstmt.setString(1, String.valueOf(e.getId()));
//                pstmt.executeUpdate();
//            } catch (SQLException ex) {
//                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
//                Logger.getLogger(EstanteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
//                System.out.println("NO se ha modificado el elemento de la BD.");
//            } finally {
//                if (conn != null) {
//                    BibliotecaBD.cerrarConexion();
//                }
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(EstanteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    public Estanteria insertarEstanteria(Estanteria es) {
//        try {
//            if (conn == null || conn.isClosed()) {
//                conn = BibliotecaBD.establecerConexion();
//            }
//            try {
//                PreparedStatement pstmt = null;
//                    char codigo = es.getCodigo();
//                    String ubicacion = es.getUbicacion();
//                    Boolean completa = es.isCompleta();
//                String sql = "INSERT INTO Estanteria(codigo, ubicacion, completo) VALUES(" + codigo + ", " + ubicacion + ", " + completa + ")";
//                pstmt = conn.prepareStatement(sql);
//                pstmt.execute();
//
//                //Se recupera de la BD el registro recien insertado;
//                Statement stmt = null;
//                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//                String sqlRec = "SELECT * FROM Estanteria WHERE ";
//                sqlRec += " codigo=" + codigo;
//                sqlRec += " and ubicacion=" + ubicacion;
//                sqlRec += " and completo=" + completa;
//                sqlRec += " ORDER BY id DESC";
//                ResultSet rs = stmt.executeQuery(sqlRec);
//                while (rs.next()) {
//                    long id = rs.getInt("id");
//                    codigo = rs.getString("codigo").charAt(0);
//                    ubicacion = rs.getString("ubicacion");
//                    completa = rs.getBoolean("completo");
//                    e = new Estanteria(id, codigo, ubicacion, completa);
//                    return e;
//                }
//            } catch (SQLException ex) {
//                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
//                Logger.getLogger(EstanteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
//                e = null;
//            } finally {
//                if (conn != null) {
//                    BibliotecaBD.cerrarConexion();
//                }
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(EstanteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return e;
//    }
//
//    public void eliminarEstanteria(long idEstanteria) {
//        try {
//            if (conn == null || conn.isClosed()) {
//                conn = BibliotecaBD.establecerConexion();
//            }
//            try {
//                PreparedStatement pstmt = null;
//                pstmt = conn.prepareStatement("DELETE FROM Estanteria WHERE id = ?");
//                pstmt.setString(1, String.valueOf(idEstanteria));
//                pstmt.executeUpdate();
//                System.out.println("Se ha eliminado el elemento de la BD.");
//            } catch (SQLException ex) {
//                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
//                Logger.getLogger(ElementoDAO.class.getName()).log(Level.SEVERE, null, ex);
//                System.out.println("NO se ha eliminado el elemento de la BD.");
//            } finally {
//                if (conn != null) {
//                    BibliotecaBD.cerrarConexion();
//                }
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(EstanteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
}
