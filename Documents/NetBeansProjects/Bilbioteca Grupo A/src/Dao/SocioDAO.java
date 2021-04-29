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
                pstmt = conn.prepareStatement("SELECT * FROM socio");
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
                pstmt = conn.prepareStatement("SELECT * FROM socio WHERE id = ?");
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

    public void eliminarSocio(long idSocio) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM socio WHERE id = ?");
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

    public void modificarSocio(Socio s) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                long id = s.getId();
                String nombre = s.getNombre();
                String nif = s.getNIF();
                String telefono = s.getTelefono();
                String direccion = s.getDireccion();

                String sql = "UPDATE socio SET ";
                sql += "id=" + id;
                sql += ", nombre=" + "\" " + nombre +"\" ";
                sql += ", nif=" + "\" " + nif + "\" ";
                sql += ", telefono=" + "\" " + telefono + "\" ";
                sql += ", direccion=" + "\" " +direccion + "\" ";

                sql += " WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(s.getId()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha modificado el Socio de la BD.");
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Socio insertarSocio(Socio s) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                long id = s.getId();
                String nombre = s.getNombre();
                String nif = s.getNIF();
                String telefono = s.getTelefono();
                String direccion = s.getDireccion();
                String sql = "INSERT INTO socio(id, nombre, nif, telefono, direccion) VALUES(" + id + ", " 
                + "\" " + nombre + "\" " +", " 
                + "\" " + nif + "\" "+ ", " 
                + "\" " + telefono + "\" "+ ", " 
                + "\" " + direccion + "\" "+ ")";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

                //Se recupera de la BD el registro recien insertado;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM socio WHERE";
                sqlRec += " id=" + id;
                sqlRec += " and nombre=" + "\" " + nombre + "\" ";
                sqlRec += " and nif=" + "\" " + nif + "\" ";
                sqlRec += " and telefono=" + "\" " + telefono + "\" ";
                sqlRec += " and direccion=" + "\" " + direccion + "\" ";
                sqlRec += " ORDER BY id DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    long idSocio = rs.getLong("id");
                    String nom = rs.getString("nombre");
                    String NIF = rs.getString("nif");
                    String tlf = rs.getString("telefono");
                    String direccionSocio = rs.getString("direccion");
                    s = new Socio(idSocio, nom, NIF, tlf, direccionSocio);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, ex);
                s = null;
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(SocioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public void verDetallesSocio(Socio so) {
        System.out.println("DETALLES de Socio");
        System.out.println("------------------------");
        System.out.println("ID: " + so.getId());
        System.out.println("Nombre: " + so.getNombre());
        System.out.println("NIF: " + so.getNIF());
        System.out.println("Telefono: " + so.getTelefono());
        System.out.println("Direccion: " + so.getDireccion());
        System.out.println("------------------------");
    }

}
