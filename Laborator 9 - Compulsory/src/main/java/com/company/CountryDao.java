package com.company;
import java.sql.*;

public class CountryDao {
    public void create(Country country) throws SQLException {
        Connection con = Database.getConnection();
        String query = "insert into countries(id, " + "name, " + " code, " + "continent ) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, country.getId());
        ps.setString(2, country.getName());
        ps.setString(3,country.getCode());
        ps.setString(4,country.getContinent());
        ps.executeUpdate();
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from countries where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from countries where id='" + id + "'")) {
            return rs.next() ? rs.getString(2) : null;
        }
    }
    public String findByContinent(String continentt) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from countries where continent='" + continentt + "'")) {
            return rs.next() ? rs.getString(2) : null;
        }
    }
}
