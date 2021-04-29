/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import BibliotecaBD.BibliotecaBD;
import Entidades.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAM122
 */
public class PrestamoDAO {

    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private Prestamo p;
    private static Connection conn;

    public PrestamoDAO() {
        conn = BibliotecaBD.establecerConexion();
    }

    public PrestamoDAO(Prestamo pre) {
        this.p = pre;
        conn = BibliotecaBD.establecerConexion();
    }

    public ArrayList<Prestamo> todasPrestamos() {
        ArrayList<Prestamo> todasPrestamos = new ArrayList<Prestamo>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM prestamo");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    long id = prs.getLong("id");
                    Date fechaDeInicio = prs.getDate("fechaDeInicio");
                    Date fechaDeDevolucion = prs.getDate("fechaDeDevolucion");
                    Long idEstado = prs.getLong("idEstado");
                    Long idSocio = prs.getLong("idSocio");
                    Prestamo pres = new Prestamo(id, fechaDeInicio, fechaDeDevolucion, idEstado, idSocio);
                    todasPrestamos.add(pres);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todasPrestamos;
    }

    public void eliminarPrestamo(long idPrestamo) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM prestamo WHERE id = ?");
                pstmt.setString(1, String.valueOf(idPrestamo));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado un Prestamo de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado el Prestamo de la BD.");
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarPrestamo(Prestamo p) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                long id = p.getId();
                String fechaDeInicio = p.getFechaDeInicio().toLocalDate().format(dateFormatter);
                String fechaDeDevolucion = p.getFechaDeDevolucion().toLocalDate().format(dateFormatter);
                long idEstado = p.getIdEstado();
                long idSocio = p.getIdSocio();

                String sql = "UPDATE prestamo SET ";
                sql += "id=" + id;
                sql += ", fechaDeInicio=" + "\'" + fechaDeInicio + "\' ";
                sql += ", fechaDeDevolucion=" + "\'" + fechaDeDevolucion + "\' ";
                sql += ", idEstado=" + idEstado;
                sql += ", idSocio=" + idSocio;

                sql += " WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(p.getId()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha modificado el Prestamo de la BD.");
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Prestamo insertarPrestamo(Prestamo p) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                long id = p.getId();
                String fechaDeInicio = p.getFechaDeInicio().toLocalDate().format(dateFormatter);
                String fechaDeDevolucion = p.getFechaDeDevolucion().toLocalDate().format(dateFormatter);
                long idEstado = p.getIdEstado();
                long idSocio = p.getIdSocio();
                String sql = "INSERT INTO prestamo(id, fechaDeInicio, fechaDeDevolucion, idEstado, idSocio) VALUES(" 
                + id + ", " 
                + "\'" + fechaDeInicio + "\' " + ", " 
                + "\'" + fechaDeDevolucion + "\' " + ", " 
                + idEstado + ", " 
                + idSocio + ")";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

                //Se recupera de la BD el registro recien insertado;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM prestamo WHERE ";
                sqlRec += " id=" + id;
                sqlRec += " and fechaDeInicio=" + "\'" + fechaDeInicio + "\' ";
                sqlRec += " and fechaDeDevolucion=" + "\'" + fechaDeDevolucion + "\' ";
                sqlRec += " and idEstado=" + idEstado;
                sqlRec += " and idSocio=" + idSocio;
                sqlRec += " ORDER BY id DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    long idPrestamo = rs.getLong("id");
                    fechaDeInicio = rs.getString("fechaDeInicio");
                    fechaDeDevolucion = rs.getString("fechaDeDevolucion");
                    idEstado = rs.getLong("idEstado");
                    idSocio = rs.getLong("idSocio");
                    p = new Prestamo(idPrestamo, java.sql.Date.valueOf(LocalDate.parse(fechaDeInicio, dateFormatter)), java.sql.Date.valueOf(LocalDate.parse(fechaDeDevolucion, dateFormatter)), idEstado, idSocio);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
                p = null;
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public void verDetallesPrestamo(Prestamo pr) {
        System.out.println("DETALLES de Prestamo");
        System.out.println("------------------------");
        System.out.println("ID: " + pr.getId());
        System.out.println("fechaDeInicio: " + pr.getFechaDeInicio());
        System.out.println("fechaDeDevolucion: " + pr.getFechaDeDevolucion());
        System.out.println("idEstado: " + pr.getIdEstado());
        System.out.println("idSocio: " + pr.getIdSocio());
        System.out.println("------------------------");
    }

}
