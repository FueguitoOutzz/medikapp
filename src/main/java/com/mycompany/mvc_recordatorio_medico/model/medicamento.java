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
        this.nombre = nombre;
    }
    public String getDosis() {
        return dosis;
    }
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }
    public String getFrecuencia() {
        return frecuencia;
    }
    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }
}
