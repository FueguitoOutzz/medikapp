package DAOs;
import model.Medicamento;
import config.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author valde
 */
public class MedicamentosDAO {
    
    public void crearMedicamento(Medicamento med) {
        String sql = "INSERT INTO medicamentos(nombre, dosis) VALUES(?, ?)";

        try (Connection conn = DatabaseConnection.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, med.getNombre());
            pstmt.setString(2, med.getDosis());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Medicamento> getMedicamentos(){
        ArrayList<Medicamento> medicamentos = new ArrayList<>();
        String sql = "SELECT id, nombre, dosis FROM medicamentos;";
        
        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String dosis = rs.getString("dosis");

                Medicamento med = new Medicamento(id, nombre, dosis);

                medicamentos.add(med);
            }

        } catch (SQLException e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        
        return medicamentos;
    }
    
    public void actualizarMedicamento(Medicamento med, int id){
        String sql = "UPDATE medicamentos SET nombre = ?, dosis = ? WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.connect();
           PreparedStatement pstmt = conn.prepareStatement(sql)) {

           pstmt.setString(1, med.getNombre());
           pstmt.setString(2, med.getDosis());
           pstmt.setInt(3, id);

           pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }
    
    public void eliminarMedicamento(int id){
        String sql = "DELETE FROM medicamentos WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.connect();
           PreparedStatement pstmt = conn.prepareStatement(sql)) {

           pstmt.setInt(1, id);

           pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error al actualizar: " + e.getMessage());
        }
    }
    
}
