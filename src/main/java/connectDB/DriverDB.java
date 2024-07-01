package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverDB {
    private static DriverDB instance;
    private static final String dbDriver = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/userdb";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "qwerty";

    private DriverDB() {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading database driver");
        }
    }
    public static DriverDB getInstance() {
        if (instance == null) {
            synchronized (DriverDB.class) {
                if (instance == null) {
                    instance = new DriverDB();
                }
            }
        }
        return instance;
    }

    public static Connection initializeDatabase() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}