package model;

public class Medicamento {
    private int id;
    private String nombre;
    private String dosis;
    
    public Medicamento(String nombre, String dosis) {
        setNombre(nombre);
        setDosis(dosis);
    }
    
    // Para cuando se recibe de la base de datos
    public Medicamento(int id, String nombre, String dosis){
        setNombre(nombre);
        setDosis(dosis);
        setID(id);
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
    
    public int getID(){
        return id;
    }
    
    public void setID(int id){
        this.id = id;
    }
    
}
