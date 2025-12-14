package model;

public class Usuario {
    private String id;
    private String nombre;
    private String nickname;
    private String contrasena;
    private String telefono;

    public Usuario(String id, String nombre, String nickname, String contrasena, String telefono) {
        setId(id);
        setNombre(nombre);
        setNickname(nickname);
        setContrasena(contrasena);
        setTelefono(telefono);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El id del usuario no puede estar vacío.");
        }
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del usuario no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        if (nickname == null || nickname.trim().isEmpty()) {
            throw new IllegalArgumentException("El nickname del usuario no puede estar vacío.");
        }
        this.nickname = nickname;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if (contrasena == null || contrasena.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña del usuario no puede estar vacía.");
        }
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El teléfono del usuario no puede estar vacío.");
        }
        this.telefono = telefono;
    }
}