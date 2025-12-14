package model;

import java.util.ArrayList;

public class GestorUsuarios {
    private UsuarioDAO usuarioDAO;

    public GestorUsuarios() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public Usuario validarUsuario(String nickname, String contrasena) {
        Usuario u = usuarioDAO.obtenerUsuarioPorNickname(nickname);
        if (u != null && u.getContrasena().equals(contrasena)) {
            return u;
        }
        return null;
    }
}
