
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection con = null;

    private static Connection getInstance() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "student";
        String password = "student1";
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e);
        }
        con.setAutoCommit(false);
        return con;
    }

    private Database() {
    }

    public static Connection getConnection() throws SQLException {
        if (con == null) {
            con = getInstance();
        }
        return con;
    }

    public static void closeConnection() throws SQLException {
        con.close();
    }

    public static void rollback() {
    }
}
