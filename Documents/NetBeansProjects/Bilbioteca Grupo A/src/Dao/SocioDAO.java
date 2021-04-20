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
                    long id = prs.getInt("id");
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
}
