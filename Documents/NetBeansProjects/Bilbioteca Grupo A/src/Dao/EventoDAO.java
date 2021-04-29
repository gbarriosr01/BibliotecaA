/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import BibliotecaBD.BibliotecaBD;
//import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.Evento;
import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author DAM115
 */
public class EventoDAO {

    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private Evento e;
    private static Connection conn;

    public EventoDAO() {
        conn = BibliotecaBD.establecerConexion();
    }

    public EventoDAO(Evento eve) {
        this.e = eve;
        conn = BibliotecaBD.establecerConexion();
    }

    public ArrayList<Evento> todasSocios() {
        ArrayList<Evento> todosEventos = new ArrayList<Evento>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM evento");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    long id = prs.getLong("id");
                    String nombre = prs.getString("nombre");
                    Date fechayhora = prs.getDate("fechayhora");
                    long idPenalizacion = prs.getLong("idPenalizacion");
                    Evento evento = new Evento(id, nombre, fechayhora, idPenalizacion);
                    todosEventos.add(evento);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todosEventos;
    }

    public static Evento buscarSocioById(long idEvento) {
        Evento evento = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM evento WHERE id = ?");
                pstmt.setString(1, String.valueOf(idEvento));
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    long id = prs.getLong("id");
                    String nombre = prs.getString("nombre");
                    Date fechayhora = prs.getDate("fechayhora");
                    long idPenalizacion = prs.getLong("idPenalizacion");
                    evento = new Evento(id, nombre, fechayhora, idPenalizacion);
                }
                prs.close();
                pstmt.close();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return evento;
    }

    public void eliminarEvento(long idEvento) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM evento WHERE id = ?");
                pstmt.setString(1, String.valueOf(idEvento));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado un evento de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado el evento de la BD.");
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarEvento(Evento e) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                long id = e.getId();
                String nombre = e.getNombre();
                String fechayhora = e.getFechayhora().toLocalDate().format(dateFormatter);
                long idPenalizacion = e.getIdPenalizacion();

                String sql = "UPDATE evento SET ";
                sql += "id=" + id;
                sql += ", nombre=" + "\" " + nombre + "\" ";
                sql += ", fechayhora=" + "\" " + fechayhora + "\" ";
                sql += ", idPenalizacion=" + "\" " + idPenalizacion + "\" ";

                sql += " WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(e.getId()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha modificado el evento de la BD.");
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Evento insertarEvento(Evento e) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                long id = e.getId();
                String nombre = e.getNombre();
                String fechayhora = e.getFechayhora().toLocalDate().format(dateFormatter);
                long idPenalizacion = e.getIdPenalizacion();
                String sql = "INSERT INTO evento(id, nombre, fechayhora, idPenalizacion) VALUES(" + id + ", "
                        + "\" " + nombre + "\" " + ", "
                        + "\" " + fechayhora + "\" " + ", "
                        + "\" " + idPenalizacion + "\" " + ")";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

                //Se recupera de la BD el registro recien insertado;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM evento WHERE";
                sqlRec += " id=" + id;
                sqlRec += " and nombre=" + "\" " + nombre + "\" ";
                sqlRec += " and fechayhora=" + "\" " + fechayhora + "\" ";
                sqlRec += " and idPenalizacion=" + "\" " + idPenalizacion + "\" ";
                sqlRec += " ORDER BY id DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    long idEvento = rs.getLong("id");
                    String nom = rs.getString("nombre");
                    Date fecha = rs.getDate("fechayhora");
                    long idPenal = rs.getLong("idPenalizacion");
                    e = new Evento(idEvento, nom, fecha, idPenal);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
                e = null;
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }

    public void verDetallesSocio(Evento ev) {
        System.out.println("DETALLES de Evento");
        System.out.println("------------------------");
        System.out.println("ID: " + ev.getId());
        System.out.println("Nombre: " + ev.getNombre());
        System.out.println("Fechayhora: " + ev.getFechayhora());
        System.out.println("idPenalizacion: " + ev.getIdPenalizacion());

        System.out.println("------------------------");
    }
}
