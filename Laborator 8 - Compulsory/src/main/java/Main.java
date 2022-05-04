
import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws SQLException{
//        Database.getConnection();
//        Database.closeConnection();
        try {
            Continent c1 = new Continent(1,"Europe");
            var continents = new ContinentDao();
            continents.create(c1);
            Database.getConnection().commit();
            var countries = new CountryDao();
            int europeId = continents.findByName("Europe");
            Country country1 = new Country(europeId, "Romania","123","Europe");
            Country country2 = new Country(europeId, "Ucraina","124","Europe");
            countries.create(country1);
            countries.create(country2);
            Database.getConnection().commit();
            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
