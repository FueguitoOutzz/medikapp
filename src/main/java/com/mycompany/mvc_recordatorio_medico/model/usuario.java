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
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
