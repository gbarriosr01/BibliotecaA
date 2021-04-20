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
public class SocioDAO {

    private Socio s;
    private static Connection conn;

    public SocioDAO() {
        conn = BibliotecaBD.establecerConexion();
    }

    public SocioDAO(Socio soc) {
        this.s = soc;
        conn = BibliotecaBD.establecerConexion();
    }

    public ArrayList<Socio> todasSocios() {
        ArrayList<Socio> todasSocios = new ArrayList<Socio>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM Socio");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    long id = prs.getLong("id");
                    String nombre = prs.getString("nombre");
                    String NIF = prs.getString("NIF");
                    String telefono = prs.getString("telefono");
                    String direccion = prs.getString("direccion");
                    Socio soci = new Socio(id, nombre, NIF, telefono, direccion);
                    todasSocios.add(soci);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todasSocios;
    }

    public static Socio buscarSocioById(int idSocio) {
        Socio socio = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM Socio WHERE id = ?");
                pstmt.setString(1, String.valueOf(idSocio));
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    long id = prs.getLong("id");
                    String nombre = prs.getString("nombre");
                    String NIF = prs.getString("NIF");
                    String telefono = prs.getString("telefono");
                    String direccion = prs.getString("direccion");
                    socio = new Socio(id, nombre, NIF, telefono, direccion);
                }
                prs.close();
                pstmt.close();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return socio;
    }

    public void eliminarSocio(int idSocio) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM Socio WHERE id = ?");
                pstmt.setString(1, String.valueOf(idSocio));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado un socio de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado el socio de la BD.");
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Socio> filtrarSocioPorNombre(String nombre) {
        ArrayList<Socio> socios = new ArrayList<Socio>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * FROM Socio WHERE nombre LIKE '" + nombre + "'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    long id = rs.getLong("id");
                    String nom = rs.getString("nombre");
                    String NIF = rs.getString("NIF");
                    String telefono = rs.getString("telefono");
                    String direccion = rs.getString("direccion");
                    Socio s = new Socio(id, nombre, NIF, telefono, direccion);
                    socios.add(s);
                }
                rs.close();
                stmt.close();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return socios;
    }
}
