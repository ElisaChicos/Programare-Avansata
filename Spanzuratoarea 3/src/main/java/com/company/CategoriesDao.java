package com.company;

import java.sql.*;
import java.util.Locale;

public class CategoriesDao {
    public String findById(int id, String table) throws SQLException {
        Connection con = Database.getConnection();
        if (table.toLowerCase(Locale.ROOT).equals("plante")) {
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select name from plante where id='" + id + "'")) {
                return rs.next() ? rs.getString(1) : null;
            }
        }
        if (table.toLowerCase(Locale.ROOT).equals("animale")) {
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select name from animale where id='" + id + "'")) {
                return rs.next() ? rs.getString(1) : null;
            }
        }
        if (table.toLowerCase(Locale.ROOT).equals("geografie")) {
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select name from geografie where id='" + id + "'")) {
                return rs.next() ? rs.getString(1) : null;
            }
        }
        if (table.toLowerCase(Locale.ROOT).equals("istorie")) {
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select name from istorie where id='" + id + "'")) {
                return rs.next() ? rs.getString(1) : null;
            }
        }
        if (table.toLowerCase(Locale.ROOT).equals("literatura")) {
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select name from literatura where id='" + id + "'")) {
                return rs.next() ? rs.getString(1) : null;
            }
        }
        if (table.toLowerCase(Locale.ROOT).equals("medicina")) {
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select name from medicina where id='" + id + "'")) {
                return rs.next() ? rs.getString(1) : null;
            }
        }
        return "Nu exista!";
    }

    public Integer idMaxim(String table) throws SQLException {
        Connection con = Database.getConnection();
        if (table.toLowerCase(Locale.ROOT).equals("plante")) {
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select MAX(id) from plante")) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
        if (table.toLowerCase(Locale.ROOT).equals("animale")) {
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select MAX(id) from animale")) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
        if (table.toLowerCase(Locale.ROOT).equals("geografie")) {
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select MAX(id) from geografie")) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
        if (table.toLowerCase(Locale.ROOT).equals("istorie")) {
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select MAX(id) from istorie")) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
        if (table.toLowerCase(Locale.ROOT).equals("literatura")) {
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select MAX(id) from literatura")) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
        if (table.toLowerCase(Locale.ROOT).equals("medicina")) {
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select MAX(id) from medicina")) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
        return 0;
    }

    public void addtoPlante(Categories category) throws SQLException {
        Connection con = Database.getConnection();
        String query = "insert into plante(id, " + "name) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, category.getId());
        ps.setString(2, category.getName());
        ps.executeUpdate();
    }

    public void addtoGeografie(Categories category) throws SQLException {
        Connection con = Database.getConnection();
        String query = "insert into geografie(id, " + "name) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, category.getId());
        ps.setString(2, category.getName());
        ps.executeUpdate();
    }

    public void addtoIstorie(Categories category) throws SQLException {
        Connection con = Database.getConnection();
        String query = "insert into istorie(id, " + "name) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, category.getId());
        ps.setString(2, category.getName());
        ps.executeUpdate();
    }

    public void addtoLiteratura(Categories category) throws SQLException {
        Connection con = Database.getConnection();
        String query = "insert into literatura(id, " + "name) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, category.getId());
        ps.setString(2, category.getName());
        ps.executeUpdate();
    }

    public void addtoAnimale(Categories category) throws SQLException {
        Connection con = Database.getConnection();
        String query = "insert into animale(id, " + "name) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, category.getId());
        ps.setString(2, category.getName());
        ps.executeUpdate();
    }

    public void addtoMedicina(Categories category) throws SQLException {
        Connection con = Database.getConnection();
        String query = "insert into medicina(id, " + "name) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, category.getId());
        ps.setString(2, category.getName());
        ps.executeUpdate();
    }
}
