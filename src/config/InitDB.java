package config;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import config.ConnectDB;
/**
 *
 * @author valde
 */
public class InitDB {
    public static void crearTablas(){
        String usuarios = "CREATE TABLE IF NOT EXISTS usuarios ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nombre TEXT NOT NULL,"
                + "nickname TEXT NOT NULL,"
                + "contraseña TEXT NOT NULL,"
                + "telefono INT"
                + ");";
        
        String medicamentos = "CREATE TABLE IF NOT EXISTS medicamentos ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nombre TEXT NOT NULL,"
                + "dosis TEXT NOT NULL"
                + ");";
        
        try (Connection conn = ConnectDB.conectar();
             Statement stmt = conn.createStatement()) {

            stmt.execute(usuarios);
            stmt.execute(medicamentos);
            
        } catch (SQLException e) {
            System.out.println("Error creando tablas: " + e.getMessage());
        }
    }
}
