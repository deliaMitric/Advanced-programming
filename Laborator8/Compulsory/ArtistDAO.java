package org.example.compulsory;

import java.sql.*;

public class ArtistDAO {
    public void create(String name, int id) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "insert into artists (id,name) values ("+ id + "," + "'"+name+"'" + ")")) {
            //pstmt.setString(1, name);
            System.out.println("Aici");
            pstmt.executeUpdate();

        } catch (Exception e){
            System.err.println("Something went wrong");
        }
    }
    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from artists where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select name from artists where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}