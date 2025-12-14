/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;
import model.Medicamento;
import config.ConnectDB;
import view.VistaMensaje;
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
    
    public void guardar(Medicamento med) {
        String sql = "INSERT INTO medicamentos(nombre, dosis) VALUES(?, ?)";

        try (Connection conn = ConnectDB.conectar();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, med.getNombre());
            pstmt.setString(2, med.getDosis());

            pstmt.executeUpdate();
            VistaMensaje.verMensajeInfo(null, "Medicamento agregado exitosamente");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Medicamento> getMedicamentos(){
        ArrayList<Medicamento> medicamentos = new ArrayList<>();
        String sql = "SELECT id, nombre, dosis FROM medicamentos;";
        
        try (Connection conn = ConnectDB.conectar();
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
    
}
