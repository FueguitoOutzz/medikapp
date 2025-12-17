package DAOs;

import model.Recordatorio;
import config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * DAO para gestionar recordatorios en la base de datos
 * @author Sistema
 */
public class RecordatoriosDAO {
    
    /**
     * Crear un nuevo recordatorio en la base de datos
     */
    public void crearRecordatorio(Recordatorio rec) {
        String sql = "INSERT INTO recordatorios(fecha_prog, mensaje, estado) VALUES(?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, rec.getFechaProg());
            pstmt.setString(2, rec.getMensaje());
            pstmt.setString(3, rec.getEstado());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al crear recordatorio: " + e.getMessage());
        }
    }
    
    /**
     * Obtener todos los recordatorios de la base de datos
     */
    public ArrayList<Recordatorio> getRecordatorios(){
        ArrayList<Recordatorio> recordatorios = new ArrayList<>();
        String sql = "SELECT id, fecha_prog, mensaje, estado FROM recordatorios;";
        
        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String fechaProg = rs.getString("fecha_prog");
                String mensaje = rs.getString("mensaje");
                String estado = rs.getString("estado");

                Recordatorio rec = new Recordatorio(id, fechaProg, mensaje, estado);

                recordatorios.add(rec);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar recordatorios: " + e.getMessage());
        }
        
        return recordatorios;
    }
    
    /**
     * Actualizar un recordatorio existente en la base de datos
     * @param rec
     * @param id
     */
    public void actualizarRecordatorio(Recordatorio rec, int id){
        String sql = "UPDATE recordatorios SET fecha_prog = ?, mensaje = ?, estado = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.connect();
           PreparedStatement pstmt = conn.prepareStatement(sql)) {

           pstmt.setString(1, rec.getFechaProg());
           pstmt.setString(2, rec.getMensaje());
           pstmt.setString(3, rec.getEstado());
           pstmt.setInt(4, id);

           pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar recordatorio: " + e.getMessage());
        }
    }
    
    /**
     * Eliminar un recordatorio de la base de datos
     */
    public void eliminarRecordatorio(int id){
        String sql = "DELETE FROM recordatorios WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.connect();
           PreparedStatement pstmt = conn.prepareStatement(sql)) {

           pstmt.setInt(1, id);

           pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al eliminar recordatorio: " + e.getMessage());
        }
    }
    
}
