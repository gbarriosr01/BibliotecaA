/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import BibliotecaBD.BibliotecaBD;
import Entidades.*;
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
 * @author DAM122
 */
public class EstadoDAO {

    private Estado e;
    private static Connection conn;

    public EstadoDAO() {
        conn = BibliotecaBD.establecerConexion();
    }

    public EstadoDAO(Estado est) {
        this.e = est;
        conn = BibliotecaBD.establecerConexion();
    }
    
    public ArrayList<Estado> todasEstados() {
        ArrayList<Estado> todasEstados = new ArrayList<Estado>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM estado");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    long id = prs.getLong("id");
                    String estado = prs.getString("estado");
                    Estado esta = new Estado(id, estado);
                    todasEstados.add(esta);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todasEstados;
    }
    
    public void eliminarEstado(long idEstado) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM estado WHERE id = ?");
                pstmt.setString(1, String.valueOf(idEstado));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado un estado de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado el estado de la BD.");
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarEstado(Estado e) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                long id = e.getId();
                String estado = e.getEstado();
                

                String sql = "UPDATE estado SET ";
                sql += "id=" + id;
                sql += ", estado=" + estado;

                sql += " WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(e.getId()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha modificado el estado de la BD.");
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Estado insertarEstado(Estado e) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                long id = e.getId();
                String estado = e.getEstado();
                String sql = "INSERT INTO estado(id, estado) VALUES(" + id + ", " + estado + ")";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

                //Se recupera de la BD el registro recien insertado;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM estado WHERE ";
                sqlRec += " id=" + id;
                sqlRec += " and estado=" + estado;
                sqlRec += " ORDER BY id DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    long idSocio = rs.getLong("id");
                    String estad = rs.getString("estado");
                    e = new Estado(idSocio, estado);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                e = null;
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
    public void verDetallesEstado(Estado es) {
        System.out.println("DETALLES de Estado");
        System.out.println("------------------------");
        System.out.println("ID: " + es.getId());
        System.out.println("Nombre: " + es.getEstado());
        System.out.println("------------------------");
    }
}
