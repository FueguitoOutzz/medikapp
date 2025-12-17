package controller;

import view.VistaPrincipal;

/**
 * Controlador principal que gestiona la vista principal
 * @author Sistema
 */
public class ControladorVistaPrincipal {
    private VistaPrincipal vistaPrincipal;
    private ControladorMedicamentos controladorMedicamentos;
    private ControladorRecordatorios controladorRecordatorios;

    public ControladorVistaPrincipal() {
        this.vistaPrincipal = new VistaPrincipal();
        this.controladorMedicamentos = new ControladorMedicamentos();
        this.controladorRecordatorios = new ControladorRecordatorios();
    }

    public void iniciar() {
        this.vistaPrincipal.setVisible(true);
        
        // Botón Salir
        this.vistaPrincipal.getSalirButton().addActionListener(e -> {
            this.vistaPrincipal.dispose();
            new ControladorLogin().iniciar();
        });
        
        // Botón Medicamentos
        this.vistaPrincipal.getMedicamentosButton().addActionListener(e -> {
            this.vistaPrincipal.setVisible(false);
            this.controladorMedicamentos.setVistaPrincipal(vistaPrincipal);
            this.controladorMedicamentos.iniciar();
        });
        
        // Botón Recordatorios
        this.vistaPrincipal.getRecordatoriosButton().addActionListener(e -> {
            this.vistaPrincipal.setVisible(false);
            this.controladorRecordatorios.setVistaPrincipal(vistaPrincipal);
            this.controladorRecordatorios.iniciar();
        });
    }
}
