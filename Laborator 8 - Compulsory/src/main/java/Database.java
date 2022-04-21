
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Connection con = null;

    static {
        String url =
                "jdbc:postgresql://localhost:5432/cities";
        String username = "postgres";
        String password = "password";
        Connection connection = null;

        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e);
        }
    }

    private Database() {
    }

    public static Connection getConnection() {
        return con;
    }

    public static void closeConnection() throws SQLException {
        con.close();
    }

    public static void rollback() {
    }
}
