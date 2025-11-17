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
        this.fechaHora = fechaHora;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}