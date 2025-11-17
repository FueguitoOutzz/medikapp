package com.mycompany.mvc_recordatorio_medico.model;
import java.util.ArrayList;

public class paciente extends usuario {
    private String edad;
    private String historialMedico;
    private ArrayList<medicamento> medicamentos;
    
    public paciente(String id, String nombre, String email, String edad, String historialMedico) {
        super(id, nombre, email);
        setEdad(edad);
        setHistorialMedico(historialMedico);
        setMedicamentos(null);
    }
    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }
    public String getHistorialMedico() {
        return historialMedico;
    }
    public void setHistorialMedico(String historialMedico) {
        this.historialMedico = historialMedico;
    }
    public ArrayList<medicamento> getMedicamentos() {
        return medicamentos;
    }
    public void setMedicamentos(ArrayList<medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
    
}
