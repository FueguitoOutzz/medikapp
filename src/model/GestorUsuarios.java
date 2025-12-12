package model;

import java.util.ArrayList;

public class GestorUsuarios {
    private ArrayList<Usuario> usuarios;

    public GestorUsuarios() {
        this.usuarios = new ArrayList<>();
        Administrador admin = new Administrador("1", "Administrador", "admin", "1234", "555-5555");
        usuarios.add(admin);
    }

    public Usuario validarUsuario(String nickname, String contrasena) {
        for (Usuario u : usuarios) {
            if (u.getNickname().equals(nickname) && u.getContrasena().equals(contrasena)) {
                return u;
            }
        }
        return null;
    }
}
