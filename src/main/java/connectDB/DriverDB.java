package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverDB {
    public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
        String dbDriver = "org.postgresql.Driver";
        String URL = "jdbc:postgresql://localhost:5432/userdb";
        String USERNAME = "postgres";
        String PASSWORD = "qwerty";;

        Class.forName(dbDriver);
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
