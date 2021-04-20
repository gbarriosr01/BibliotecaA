/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import BibliotecaBD.BibliotecaBD;
import Entidades.Lote;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAM102
 */
public class LoteDAO {

    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Lote lo;
    private static Connection conn;
    
     public LoteDAO() {
        conn = BibliotecaBD.establecerConexion();
    }

    public LoteDAO(Lote lot) {
        this.lo = lot;
        conn = BibliotecaBD.establecerConexion();
    }
    
     public ArrayList<Lote> todosLotes() {
        ArrayList<Lote> todosLotes = new ArrayList<Lote>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM lotes");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    long id = prs.getLong("id");
                    Date fechallegada = prs.getDate("fechallegada");
                    long idProveedor = prs.getLong("idProveedor");
                    Lote lo = new Lote(id, fechallegada, idProveedor);
                    todosLotes.add(lo);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(LoteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todosLotes;
    }
    public static Lote buscarLoteById(long idLote) {
       Lote lote = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM lotes WHERE id = ?");
                pstmt.setString(1, String.valueOf(idLote));
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    long id = prs.getLong("id");
                    Date fechallegada = prs.getDate("fechallegada");
                    long idProveedor = prs.getLong("idProveedor");
                    lote = new Lote(id, fechallegada, idProveedor);
                }
                prs.close();
                pstmt.close();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(LoteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lote;
    }
    public static Lote buscarLoteByIdProveedor(long idProv) {
        Lote lote = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM lotes WHERE idProveedor = ?");
                pstmt.setString(1, String.valueOf(idProv));
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    long id = prs.getLong("id");
                    Date fechallegada = prs.getDate("fechallegada");
                    long idProveedor = prs.getLong("idProveedor");
                    lote = new Lote(id, fechallegada, idProveedor);
                }
                prs.close();
                pstmt.close();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(LoteDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lote;
    }
     public void eliminarLote(long idLote) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM lotes WHERE id = ?");
                pstmt.setString(1, String.valueOf(idLote));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado el lote de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(LoteDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado el lote de la BD.");
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
