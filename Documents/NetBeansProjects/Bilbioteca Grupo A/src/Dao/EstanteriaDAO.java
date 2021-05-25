/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;


import BibliotecaBD.BibliotecaBD;
import Entidades.Elemento;
import Entidades.Estanteria;
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
public class EstanteriaDAO {
    
    private Estanteria e;
    private static Connection conn;
    
    public EstanteriaDAO(){
    conn = BibliotecaBD.establecerConexion();
    }
    
    public EstanteriaDAO(Estanteria es){
    this.e = es;    
    conn = BibliotecaBD.establecerConexion();
    }
    
    public ArrayList<Estanteria> todosEstanteria() {
        ArrayList<Estanteria> todosEstanteria = new ArrayList<Estanteria>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM Estanteria");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    long id = prs.getInt("id");
                    char codigo = prs.getString("codigo").charAt(0);
                    String ubicacion = prs.getString("ubicacion");
                    boolean completa = prs.getBoolean("completo");
                    
                    Estanteria es = new Estanteria(id, codigo, ubicacion, completa);
                    todosEstanteria.add(es);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EstanteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstanteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todosEstanteria;
    }
    
    public void modificarEstanteria(Estanteria e) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                char codigo = e.getCodigo();
                String ubicacion = e.getUbicacion();
                Boolean completa = e.isCompleta();

                String sql = "UPDATE Estanteria SET ";
                sql += "codigo=" + "\" " + codigo + "\" ";
                sql += ", ubicacion=" + "\" " + ubicacion + "\" ";
                sql += ", completo=" + completa;
                

                sql += " WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(e.getId()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EstanteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha modificado el elemento de la BD.");
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstanteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Estanteria insertarEstanteria(Estanteria es) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                    long id = es.getId();
                    char codigo = es.getCodigo();
                    String ubicacion = es.getUbicacion();
                    Boolean completa = es.isCompleta();
                String sql = "INSERT INTO estanteria(id, codigo, ubicacion, completo) VALUES(" 
                + id + ", " 
                + "\'" + codigo + "\' " + ", " 
                + "\"" + ubicacion + "\" " + ", " 
                + completa + ")";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

                //Se recupera de la BD el registro recien insertado;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM estanteria WHERE";
                sqlRec += " id=" + id;
                sqlRec += " and codigo=" + "\'" + codigo + "\'";
                sqlRec += " and ubicacion=" + "\"" + ubicacion + "\"";
                sqlRec += " and completo=" + completa;
                sqlRec += " ORDER BY id DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    id = rs.getInt("id");
                    codigo = rs.getString("codigo").charAt(0);
                    ubicacion = rs.getString("ubicacion");
                    completa = rs.getBoolean("completo");
                    e = new Estanteria(id, codigo, ubicacion, completa);
                    return e;
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EstanteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
                e = null;
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstanteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
    public void eliminarEstanteria(long idEstanteria) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM Estanteria WHERE id = ?");
                pstmt.setString(1, String.valueOf(idEstanteria));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado el elemento de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ElementoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado el elemento de la BD.");
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstanteriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
