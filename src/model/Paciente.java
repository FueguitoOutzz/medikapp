package model;
import java.util.ArrayList;

public class Paciente extends Usuario {
    private int edad;
    private ArrayList<String> enfermedades;
    
    public Paciente(String id, String nombre, String nickname, String contrasena, String telefono, int edad) {
        super(id, nombre, nickname, contrasena, telefono);
        setEdad(edad);
        setEnfermedades(enfermedades);
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        if(edad < 0 || edad > 130) {
            throw new IllegalArgumentException("La edad debe estar en el rango 0-130.");
        }
        this.edad = edad;
    }
    public ArrayList<String> getEnfermedades() {
        return enfermedades;
    }
    public void setEnfermedades(ArrayList<String> enfermedades) {
        if(enfermedades == null) {
            this.enfermedades = new ArrayList<>();
        } else {
            this.enfermedades = enfermedades;
        }
    }
}
