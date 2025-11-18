package com.mycompany.mvc_recordatorio_medico.model;

public abstract class usuario {
    private String id;
    private String nombre;
    private String email;
    public usuario(String id, String nombre, String email) {
        setId(id);
        setNombre(nombre);
        setEmail(email);
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if(nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del usuario no puede estar vacío.");
        }
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if(email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email del usuario no puede estar vacío.");
        }
        this.email = email;
    }
}
