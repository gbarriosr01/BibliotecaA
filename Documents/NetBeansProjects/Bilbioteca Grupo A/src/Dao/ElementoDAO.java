/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import BibliotecaBD.BibliotecaBD;
import Entidades.Elemento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author diegu
 */
public class ElementoDAO {
    
    private Elemento e;
    private static Connection conn;
    
    public ElementoDAO(){
    conn = BibliotecaBD.establecerConexion();
    }
    
    public ElementoDAO(Elemento el){
    this.e = el;    
    conn = BibliotecaBD.establecerConexion();
    }
    
    public ArrayList<Elemento> todosElemento() {
        ArrayList<Elemento> todosElemento = new ArrayList<Elemento>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM Elemento");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    long id = prs.getInt("id");
                    long idGenero = prs.getInt("idGenero");
                    long idLote = prs.getInt("idLote");
                    long idEstanteria = prs.getInt("idEstanteria");
                    
                    Elemento el = new Elemento(id, idGenero, idLote, idEstanteria);
                    todosElemento.add(el);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ElementoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ElementoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return todosElemento;
    }
    
    public void eliminarElemento(long idElemento) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("DELETE FROM Elemento WHERE id = ?");
                pstmt.setString(1, String.valueOf(idElemento));
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
            Logger.getLogger(ElementoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarElemento(Elemento e) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                long idGenero = e.getIdGenero();
                long idLote = e.getIdLote();
                long idEstanteria = e.getIdEstanteria();

                String sql = "UPDATE ejemplares SET ";
                sql += "idGenero=" + idGenero;
                sql += ", idLote=" + idLote;
                sql += ", idEstanteria=" + idEstanteria;
                

                sql += " WHERE id = ?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, String.valueOf(e.getId()));
                pstmt.executeUpdate();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ElementoDAO.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("NO se ha modificado el elemento de la BD.");
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ElementoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Elemento insertarElemento(Elemento el) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = BibliotecaBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                    long idGenero = el.getIdGenero();
                    long idLote = el.getIdLote();
                    long idEstanteria = el.getIdEstanteria();
                String sql = "INSERT INTO Elemento(idGenero, idLote, idEstanteria) VALUES(" + idGenero + ", " + idLote + ", " + idEstanteria + ")";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

                //Se recupera de la BD el registro recien insertado;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM Elemento WHERE ";
                sqlRec += " idGenero=" + idGenero;
                sqlRec += " and idLote=" + idLote;
                sqlRec += " and idEstanteria=" + idEstanteria;
                sqlRec += " ORDER BY id DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    long id = rs.getInt("id");
                    idGenero = rs.getInt("idGenero");
                    idLote = rs.getInt("idLote");
                    idEstanteria = rs.getInt("idEstanteria");
                    e = new Elemento(id, idGenero, idLote, idEstanteria);
                    return e;
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ElementoDAO.class.getName()).log(Level.SEVERE, null, ex);
                e = null;
            } finally {
                if (conn != null) {
                    BibliotecaBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(ElementoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return e;
    }
    
    
    
}
