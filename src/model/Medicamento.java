package model;

public class Medicamento {
    private String nombre;
    private String dosis;
    public Medicamento(String nombre, String dosis) {
        setNombre(nombre);
        setDosis(dosis);
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
}
