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

/**
 *
 * @author DAM115
 */
public class EventoDAO {

    private Evento e;
    private static Connection conn;

    public EventoDAO() {
        conn = BibliotecaBD.establecerConexion();
    }

    public EventoDAO(Evento ev) {
        this.e = ev;
        conn = BibliotecaBD.establecerConexion();
    }

    public ArrayList<Evento> todosEventos() {
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
                    Evento local = new Evento(id, nombre, fechayhora, idPenalizacion);
                    todosEventos.add(local);
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

    public static Evento buscarEventoId(int idEvento) {
        Evento evento = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM localizaciones WHERE id = ?");
                pstmt.setString(1, String.valueOf(idEvento));
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    long id = prs.getLong("id");
                    String nombre = prs.getString("nombre");
                    Date fechayhora = prs.getDate("fechayhora");
                    evento = new Evento(id, nombre, fechayhora);
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

    public void eliminarEvento(int idevento) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM ejemplares WHERE id = ?");
                pstmt.setString(1, String.valueOf(idevento));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado el evento de la BD.");
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
                String nombre = e.getNombre();
                //Fecha
                long idPenal = e.getIdPenalizacion();

                String sql = "UPDATE ejemplares SET ";
                sql += "edad=" + nombre;
                //sql += ", fecha=" + fecha;
                sql += ", idPenalizacion=" + idPenal;
                sql += " WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(e.getId()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha modificado el ejemplar de la BD.");
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public Evento insertarEvento(Evento e) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                String nombre = e.getNombre();
                Date fecha = (Date) e.getFechayhora(); //Revisar
                long idPenal = e.getIdPenalizacion();
                String sql = "INSERT INTO ejemplares(edad, fechaCompra, fechaPlantacion, idLocalizacion, idPlanta) VALUES(" + nombre + ", " + fecha + ", " + idPenal + ")";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM eventos WHERE ";
                sqlRec += " nombre=" + nombre;
                sqlRec += " and fecha=" + fecha;
                sqlRec += " and idPenalizacion=" + idPenal;
                sqlRec += " ORDER BY id DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    long id = rs.getInt("id");
                    nombre = rs.getNString("nombre");
                    fecha = rs.getDate("fecha");
                    idPenal = rs.getInt("idPlanta");
                    e = new Evento(id, nombre, fecha, idPenal); //Revisar.
                    return e;
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
}
