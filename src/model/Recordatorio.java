package model;


public class Recordatorio {
    private int idRecordatorio;
    private String fecha_prog;
    private String estado;
    private String mensaje;
    public Recordatorio(int id, String fecha_prog, String mensaje, String estado) {
        setId(id);
        setFechaProg(fecha_prog);
        setMensaje(mensaje);
        setEstado(estado);
    }
    public int getId() {
        return idRecordatorio;
    }
    public void setId(int id) {
        this.idRecordatorio = id;
    }
    public String getFechaProg() {
        return fecha_prog;
    }
    public void setFechaProg(String fecha_prog) {
        if(fecha_prog == null || fecha_prog.trim().isEmpty()) {
            throw new IllegalArgumentException("La fecha y hora del recordatorio no puede estar vacío.");
        }
        this.fecha_prog = fecha_prog;
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
        if(estado == null || estado.trim().isEmpty()) {
            throw new IllegalArgumentException("El estado del recordatorio no puede estar vacío.");
        }
        String norm = estado.trim().toUpperCase();
        if(!norm.equals("PENDIENTE") && !norm.equals("ENVIADO") && !norm.equals("CANCELADO")) {
            throw new IllegalArgumentException("Estado inválido. Valores permitidos: PENDIENTE, ENVIADO, CANCELADO.");
        }
        this.estado = norm;
    }
}