package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:sqlite:medikapp.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(URL);
            createTables(conn);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    private static void createTables(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS usuarios ("
                + "id TEXT PRIMARY KEY,"
                + "nombre TEXT NOT NULL,"
                + "nickname TEXT NOT NULL UNIQUE,"
                + "contrasena TEXT NOT NULL,"
                + "telefono TEXT NOT NULL"
                + ");";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Error al crear las tablas: " + e.getMessage());
        }
    }
}
