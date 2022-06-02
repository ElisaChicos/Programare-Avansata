package com.company;
import java.sql.*;

public class CitiesDao {
    public void create(Cities city) throws SQLException {
        Connection con = Database.getConnection();
        String query = "insert into cities(id, " + "country, "+"  name, " + " capital, " + "latitude, "+" longitude ) VALUES (?, ?, ?, ?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, city.getId());
        ps.setString(2, city.getCountry());
        ps.setString(3, city.getName());
        ps.setInt(4,city.getCapital());
        ps.setDouble(5,city.getLatitude());
        ps.setDouble(6,city.getLongitude());
        ps.executeUpdate();
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from cities where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from cities where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
    public Double findLat(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select latitude from cities where id='" + id + "'")) {
            return rs.next() ? rs.getDouble(1) : null;
        }
    }

    public Double findLong(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select longitude from cities where id='" + id + "'")) {
            return rs.next() ? rs.getDouble(1) : null;
        }
    }
    public Double distance(Double lat1,Double long1, Double lat2, Double long2)
    {
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);
        long1 = Math.toRadians(long1);
        long2 = Math.toRadians(long2);

        double dlon = long2 - long1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956 for miles
        double r = 6371;

        // calculate the result
        return(c * r);

    }

}
