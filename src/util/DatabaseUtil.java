package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String connectionUrl = "jdbc:postgresql://localhost:5432/employeesdb";
    public DatabaseUtil() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong." + e);
        }
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl, "postgres", "Raider66");
    }
}
