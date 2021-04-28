/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import BibliotecaBD.BibliotecaBD;
import Entidades.Evento;
import Entidades.Visionado;
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
public class VisionadoDAO {

    private Visionado v;
    private static Connection conn;

    public VisionadoDAO() {
        conn = BibliotecaBD.establecerConexion();
    }

    public VisionadoDAO(Visionado vi) {
        this.v = vi;
        conn = BibliotecaBD.establecerConexion();
    }

    public ArrayList<Visionado> todosVisionados() {
        ArrayList<Visionado> todosVisionados = new ArrayList<Visionado>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM visionado");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    String aula = prs.getString("aula");
                    Visionado visionado = new Visionado(aula);
                    todosVisionados.add(visionado);
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
            Logger.getLogger(VisionadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todosVisionados;
    }

    public static Visionado buscarVisionadoById(int idVisionado) {
        Visionado v = null;
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM visionado WHERE id = ?");
                pstmt.setString(1, String.valueOf(idVisionado));
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    String aula = prs.getString("aula");
                    v = new Visionado(aula);
                }
                prs.close();
                pstmt.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(VisionadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            System.out.println("Se ha producido una SQLException:" + ex.getMessage());
            Logger.getLogger(VisionadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    public void eliminarVisionado(int idVisionado) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM visionado WHERE id = ?");
                pstmt.setString(1, String.valueOf(idVisionado));
                pstmt.executeUpdate();
                System.out.println("Se ha eliminado el visionado de la BD.");
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(VisionadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha eliminado el visionado de la BD.");
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(LecturaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Visionado> filtrarVisionadoPorAula(String aula) {
        ArrayList<Visionado> visionados = new ArrayList<Visionado>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * FROM visionado WHERE nombre LIKE '" + aula + "'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String au = rs.getString("aula");
                    Visionado v = new Visionado(au);
                    visionados.add(v);
                }
                rs.close();
                stmt.close();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(VisionadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(VisionadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return visionados;
    }

    /*public void verDetallesVisionado(Visionado v) {
        System.out.println("DETALLES del visionado");
        System.out.println("------------------------");
        
        System.out.println("AULA: " + v.getAula());
        ArrayList<Evento> eventosDeVisionado = new ArrayList<Evento>();
        eventosDeVisionado = EventoDAO.buscarEventosByIdVisionado(v.getId());
        System.out.println("Se tienen " + ejemplaresDePlanta.size() + " ejemplares de esta planta.");
        ArrayList<Parcela> parcelasConPlanta = new ArrayList<Parcela>();
        parcelasConPlanta = ParcelaDAO.parcelasConPlanta(p);
        System.out.println("Hay " + parcelasConPlanta.size() + " parcelas con esta planta.");
        for (Parcela par : parcelasConPlanta) {
            System.out.println("\tEn la parcela " + par.getNombre() + " hay un " + ParcelaDAO.calcularPorcentajePlantaEnParcela(p.getId(), par.getId()) + "% de esta planta.");
        }
        System.out.println("------------------------");
    }*/
    public void modificarVisionado(Visionado v) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                String aula = v.getAula();

                String sql = "UPDATE visionado SET ";
                sql += "aula='" + aula + "'";

                sql += " WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(v.getId()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(VisionadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(VisionadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Visionado insertarVisionado(Visionado v) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;

                String aula = v.getAula();

                String sql = "INSERT INTO visionado(aula) VALUES('" + aula + "')";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

                //Se recupera de la BD el registro recien insertado;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM visionado WHERE ";
                sqlRec += " aula='" + aula + "'";
                sqlRec += " ORDER BY id DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    aula = rs.getString("aula");
                    v = new Visionado(aula);
                    return v;
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(VisionadoDAO.class.getName()).log(Level.SEVERE, null, ex);
                v = null;
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(VisionadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

}
