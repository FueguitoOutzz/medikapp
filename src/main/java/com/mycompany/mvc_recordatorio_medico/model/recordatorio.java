package com.mycompany.mvc_recordatorio_medico.model;


public class recordatorio {
    private int id;
    private String fechaHora;
    private String mensaje;
    private String estado;
    public recordatorio(int id, String fechaHora, String mensaje, String estado) {
        setId(id);
        setFechaHora(fechaHora);
        setMensaje(mensaje);
        setEstado(estado);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFechaHora() {
        return fechaHora;
    }
    public void setFechaHora(String fechaHora) {
        if(fechaHora == null || fechaHora.trim().isEmpty()) {
            throw new IllegalArgumentException("La fecha y hora del recordatorio no puede estar vacío.");
        }
        this.fechaHora = fechaHora;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        if(mensaje == null || mensaje.trim().isEmpty()) {
            throw new IllegalArgumentException("El mensaje del recordatorio no puede estar vacío.");
        }
        this.mensaje = mensaje;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}