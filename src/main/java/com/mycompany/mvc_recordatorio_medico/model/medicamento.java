package com.mycompany.mvc_recordatorio_medico.model;

public class medicamento {
    private String nombre;
    private String dosis;
    private String frecuencia;
    public medicamento(String nombre, String dosis, String frecuencia) {
        setNombre(nombre);
        setDosis(dosis);
        setFrecuencia(frecuencia);
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        if(nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del medicamento no puede estar vacío.");
        }
        this.nombre = nombre;
    }
    public String getDosis() {
        return dosis;
    }
    public void setDosis(String dosis) {
        if(dosis == null || dosis.trim().isEmpty()) {
            throw new IllegalArgumentException("La dosis del medicamento no puede estar vacía.");
        }
        this.dosis = dosis;
    }
    public String getFrecuencia() {
        return frecuencia;
    }
    public void setFrecuencia(String frecuencia) {
        if(frecuencia == null || frecuencia.trim().isEmpty()) {
            throw new IllegalArgumentException("La frecuencia del medicamento no puede estar vacía.");
        }
        this.frecuencia = frecuencia;
    }
}
