package controller;

import view.VistaPrincipal;
import view.VistaMedicamentos;

/**
 *
 * @author valde
 */
public class ControladorVistaPrincipal {
    private VistaPrincipal menu;
    private ControladorMedicamentos controladorMedicamentos;
    
    public ControladorVistaPrincipal(){
        this.menu = new VistaPrincipal();
        this.controladorMedicamentos = new ControladorMedicamentos();
    }
    
    public void iniciar(){
        this.menu.setVisible(true);
        this.menu.getMedicamentosButton().addActionListener(e -> {
            this.menu.setVisible(false);
            this.controladorMedicamentos.iniciar();
        });
    }
}
