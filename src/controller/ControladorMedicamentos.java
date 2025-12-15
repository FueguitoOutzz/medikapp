/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAOs.MedicamentosDAO;
import java.util.ArrayList;
import model.GestorMedicamentos;
import model.Medicamento;
import view.VistaMedicamentos;
import view.VistaMensaje;
import javax.swing.table.DefaultTableModel;
import view.VistaMedicamentosEditar;
import view.VistaPrincipal;


/**
 *
 * @author valde
 */
public class ControladorMedicamentos {
    private MedicamentosDAO medicamentosDAO;
    private GestorMedicamentos gestor;
    private VistaMedicamentos vista;    
    private VistaPrincipal vistaPrincipal;
    
    private ArrayList<Medicamento> medicamentos;
    private boolean configurado = false;
    
    public ControladorMedicamentos(){
        this.gestor = new GestorMedicamentos();
        this.vista = new VistaMedicamentos();
        this.medicamentosDAO = new MedicamentosDAO();
        //this.menu = new ControladorMenu();
    }
    
    public void setVistaPrincipal(VistaPrincipal vP){
        this.vistaPrincipal = vP;
    }
    
    public void iniciar(){
        this.vista.setVisible(true);
        
        if (!configurado){
            configurarBotones();
            configurado = true;
        }
        listarMedicamentos();
    }
    
    private void configurarBotones(){
        this.vista.getAgregarBtn().addActionListener(e -> agregarMedicamento());
        this.vista.getLimpiarButton().addActionListener(e -> limpiarFormulario());
        this.vista.getEditarButton().addActionListener(e -> editarMedicamento());
        this.vista.getVolverButton().addActionListener(e -> volverAtras());
        this.vista.getEliminarButton().addActionListener(e -> eliminarMedicamento());
    }
    
    public void agregarMedicamento(){
        String nombre = this.vista.getNombreField().getText();
        String dosis = this.vista.getDosisField().getText();
        
        if (nombre.isEmpty() || dosis.isEmpty()){
            VistaMensaje.verMensajeError(null, "Faltan campos por completar.");
            return;
        }
        
        Medicamento nuevoMed = new Medicamento(nombre, dosis);
        
        try{
            medicamentosDAO.crearMedicamento(nuevoMed);
            
            VistaMensaje.verMensajeInfo(null, "Medicamento Agregado Correctamente");
            limpiarFormulario();  
            listarMedicamentos();
            
        }catch(NumberFormatException ex){
           VistaMensaje.verMensajeError(null, "La frecuencia debe ser en horas.");
        }catch(IllegalArgumentException ex){
            VistaMensaje.verMensajeError(null, "No se pudo crear el objeto");
        }
    }
    
    private void listarMedicamentos() {
        this.medicamentos = medicamentosDAO.getMedicamentos();
        
        DefaultTableModel m = (DefaultTableModel) vista.getTabla().getModel();
        m.setNumRows(0);
        for (Medicamento me: medicamentos) {
            m.addRow(new Object[]{me.getNombre(), me.getDosis()});
        }
        
    }
    
    private void limpiarFormulario() {
        this.vista.getNombreField().setText("");
        this.vista.getDosisField().setText("");
        this.vista.getNombreField().requestFocus();
    }
    
    private void volverAtras(){
        this.vista.setVisible(false);
        vistaPrincipal.setVisible(true);
    }
    
    private void editarMedicamento(){
        VistaMedicamentosEditar editView = new VistaMedicamentosEditar();
        
        int selectedRow = this.vista.getTabla().getSelectedRow();
        
        if (selectedRow == -1){
            VistaMensaje.verMensajeError(null, "Por favor selecciona un medicamento de la tabla.");
            return;
        }
        
        Medicamento med = medicamentos.get(selectedRow);
        editView.setFields(med.getNombre(), med.getDosis());
        editView.setVisible(true);
        editView.getCancelarButton().addActionListener(e -> {
            editView.setVisible(false);
        });
        
        editView.getGuardarButton().addActionListener(e -> {
            String newNombre = editView.getNombreField().getText();
            String newDosis = editView.getDosisField().getText();
            
            Medicamento newMed = new Medicamento(newNombre, newDosis);
            medicamentosDAO.actualizarMedicamento(newMed, med.getID());
            
            listarMedicamentos();
            editView.setVisible(false);
        });
    }
    
    public void eliminarMedicamento(){
        int selectedRow = this.vista.getTabla().getSelectedRow();
        
        if (selectedRow == -1){
            VistaMensaje.verMensajeError(null, "Por favor selecciona un medicamento de la tabla.");
            return;
        }
        
        Medicamento med = medicamentos.get(selectedRow);
        if (med == null){
            VistaMensaje.verMensajeError(null, "Error con el medicamento");
        }
        
        medicamentosDAO.eliminarMedicamento(med.getID());
        
        VistaMensaje.verMensajeInfo(null, "Medicamento eliminado correctamente");
        listarMedicamentos();
    }
    
    
}
