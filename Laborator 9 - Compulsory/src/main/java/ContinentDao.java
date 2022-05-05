import java.sql.*;

public class ContinentDao{

    public void create(Continent continent) throws SQLException {
        Connection con = Database.getConnection();
        String query = "insert into continents(id, " + "name) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, continent.getId());
        ps.setString(2, continent.getName());
        ps.executeUpdate();
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select id from continents where name='" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }

    public String findById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "select name from continents where id='" + id + "'")) {
            return rs.next() ? rs.getString(1) : null;
        }
    }
}