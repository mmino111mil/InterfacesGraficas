/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesgraficas.dao;

import interfacesgraficas.model.Pais;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PaisJdbcDaoImpl extends  PaisDAO {
    
    
    private final String SQL_INSERT = "INSERT INTO paises  (code, name ) VALUES ( ?, ? )";
    private final String SQL_UPDATE = "UPDATE paises SET name =  ? WHERE code = ?";
    private final String SQL_DELETE = "DELETE FROM paises WHERE code = ?";
    private final String SQL_SELECT = "SELECT code, name FROM paises";
    
    Connection conn = null;

    public PaisJdbcDaoImpl() {
        createConn();
    }
    
            
    public Connection createConn() {
        try {

            String DRIVER = "com.mysql.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost/paises";
            String USER   = "root";
            String PASS   = "pass";

            System.out.println(DRIVER);
            System.out.println(DB_URL);
            System.out.println(USER);
            System.out.println(PASS);

            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
   
        } catch (Exception ex) {
            Logger.getLogger(PaisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
    }

    @Override
    public void create(Pais pais) {

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = createConn();
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, pais.getCode());
            ps.setString(2, pais.getNombre());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    @Override
    public void delete(Pais pais) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {         
            conn = createConn();
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setString(1, pais.getCode());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    @Override
    public void update(Pais genero) {
        PreparedStatement ps = null;
        try {
            String sql = SQL_UPDATE;
            ps = conn.prepareStatement(sql);
            ps.setString(1, genero.getNombre()); 
            ps.setString(2, genero.getCode());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    @Override
    public List<Pais> all() {

        List<Pais> generos = new ArrayList<>();
        Statement stmt = null;
        try {
           
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL_SELECT);
            while (rs.next()) {
                String id = rs.getString("code");
                String nombre = rs.getString("name");
                generos.add(new Pais(id,nombre));
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return generos;

    }
    
    public void close(){
        try {
            if (conn != null) { 
                conn.close();
            }
        } catch (SQLException se) { se.printStackTrace(); 
        }

    }


}
