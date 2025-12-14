/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAOs.MedicamentosDAO;
import model.GestorMedicamentos;
import model.Medicamento;
import view.VistaMedicamentos;
import view.VistaMensaje;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author valde
 */
public class ControladorMedicamentos {
    private MedicamentosDAO medicamentosDAO;
    private GestorMedicamentos gestor;
    private VistaMedicamentos vista;
    //private ControladorMenu menu;
    
    public ControladorMedicamentos(){
        this.gestor = new GestorMedicamentos();
        this.vista = new VistaMedicamentos();
        this.medicamentosDAO = new MedicamentosDAO();
        //this.menu = new ControladorMenu();
    }
    
    public void iniciar(){
        this.vista.setVisible(true);
        this.vista.getAgregarBtn().addActionListener(e -> agregarMedicamento());
        this.vista.getLimpiarButton().addActionListener(e -> limpiarFormulario());
        
        listarMedicamentos();
        /*this.vista.getVolverButton().addActionListener(e -> {
            
            //this.menu.iniciar();
        });*/
    }
    
    public void agregarMedicamento(){
        String nombre = this.vista.getNombreField().getText();
        String dosis = this.vista.getDosisField().getText();
        Medicamento nuevoMed = new Medicamento(nombre, dosis);
        
        try{
            medicamentosDAO.guardar(nuevoMed);
            
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
        DefaultTableModel m = (DefaultTableModel) vista.getTabla().getModel();
        m.setNumRows(0);
        for (Medicamento me: medicamentosDAO.getMedicamentos()) {
            m.addRow(new Object[]{me.getNombre(), me.getDosis()});
        }
    }
    
    private void limpiarFormulario() {
        this.vista.getNombreField().setText("");
        this.vista.getDosisField().setText("");
        this.vista.getNombreField().requestFocus();
    }
    
    
    
}
