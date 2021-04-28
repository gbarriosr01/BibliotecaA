/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import BibliotecaBD.BibliotecaBD;
import Entidades.Lectura;
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
 * @author DAM115
 */
public class LecturaDAO {

    private Lectura l;
    private static Connection conn;

    public LecturaDAO() {
        conn = BibliotecaBD.establecerConexion();
    }

    public LecturaDAO(Lectura lec) {
        this.l = lec;
        conn = BibliotecaBD.establecerConexion();
    }

    public ArrayList<Lectura> todasLectura() {
        ArrayList<Lectura> todasLecturas = new ArrayList<Lectura>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM lectura");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    boolean leido = prs.getBoolean("leido");
                    String modelo = prs.getNString("modelo");
                    Lectura lectura = new Lectura(leido, modelo);
                    todasLecturas.add(lectura);
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
            Logger.getLogger(LecturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todasLecturas;
    }

    public static Lectura buscarLecturaById(int idLectura) {
        Lectura l = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM lectura WHERE id = ?");
                pstmt.setString(1, String.valueOf(idLectura));
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    boolean leido = prs.getBoolean("leido");
                    String modelo = prs.getString("modelo");
                    l = new Lectura(leido, modelo);
                }
                prs.close();
                pstmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(LecturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            System.out.println("Se ha producido una SQLException:" + ex.getMessage());
            Logger.getLogger(LecturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public void eliminarLectura(int idLectura) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM lectura WHERE id = ?");
                pstmt.setString(1, String.valueOf(idLectura));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado la lectura de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado la planta de la BD.");
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Lectura> filtrarLecturaPorNombre(String nombre) {
        ArrayList<Lectura> lecturas = new ArrayList<Lectura>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * FROM lectura WHERE nombre LIKE '" + nombre + "'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    boolean leido = rs.getBoolean("leido");
                    String modelo = rs.getString("modelo");
                    Lectura l = new Lectura(leido, modelo);
                    lecturas.add(l);
                }
                rs.close();
                stmt.close();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(LecturaDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LecturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lecturas;
    }

    public void modificarLecura(Lectura l) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                String modelo = l.getModelo();

                String sql = "UPDATE lectura SET ";
                sql += "modelo='" + modelo + "'";

                sql += " WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(l.getId()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LecturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Lectura insertarLectura(Lectura l) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;

                String modelo = l.getModelo();

                String sql = "INSERT INTO lectura(modelo) VALUES('" + modelo + "')";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

                //Se recupera de la BD el registro recien insertado;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM lectura WHERE ";
                sqlRec += " modelo='" + modelo + "'";
                sqlRec += " ORDER BY id DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    boolean leido = rs.getBoolean("leido");
                    modelo = rs.getString("modelo");
                    l = new Lectura(leido, modelo);
                    return l;
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(LecturaDAO.class.getName()).log(Level.SEVERE, null, ex);
                l = null;
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LecturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

}
