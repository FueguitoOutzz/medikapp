package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDAO {

    public boolean insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios(id, nombre, nickname, contrasena, telefono) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            if (conn == null)
                return false;

            pstmt.setString(1, usuario.getId());
            pstmt.setString(2, usuario.getNombre());
            pstmt.setString(3, usuario.getNickname());
            pstmt.setString(4, usuario.getContrasena());
            pstmt.setString(5, usuario.getTelefono());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar usuario: " + e.getMessage());
            return false;
        }
    }

    public Usuario obtenerUsuarioPorNickname(String nickname) {
        String sql = "SELECT * FROM usuarios WHERE nickname = ?";

        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return null;

            pstmt.setString(1, nickname);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("nickname"),
                        rs.getString("contrasena"),
                        rs.getString("telefono"));
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener usuario: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Usuario> listarUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = DatabaseConnection.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            if (conn == null)
                return lista;

            while (rs.next()) {
                lista.add(new Usuario(
                        rs.getString("id"),
                        rs.getString("nombre"),
                        rs.getString("nickname"),
                        rs.getString("contrasena"),
                        rs.getString("telefono")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar usuarios: " + e.getMessage());
        }
        return lista;
    }

    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre=?, nickname=?, contrasena=?, telefono=? WHERE id=?";
        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            if (conn == null)
                return false;

            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getNickname());
            pstmt.setString(3, usuario.getContrasena());
            pstmt.setString(4, usuario.getTelefono());
            pstmt.setString(5, usuario.getId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar usuario: " + e.getMessage());
            return false;
        }
    }
}
