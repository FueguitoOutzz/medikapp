package controller;

import view.VistaPrincipal;

/**
 *
 * @author valde
 */
public class ControladorVistaPrincipal {
    private VistaPrincipal vistaPrincipal;
    private ControladorMedicamentos controladorMedicamentos;

    public ControladorVistaPrincipal() {
        this.vistaPrincipal = new VistaPrincipal();
        this.controladorMedicamentos = new ControladorMedicamentos();
    }

    public void iniciar() {
        this.vistaPrincipal.setVisible(true);
        this.vistaPrincipal.getSalirButton().addActionListener(e -> {
            this.vistaPrincipal.dispose();
            new ControladorLogin().iniciar();
        });
        this.vistaPrincipal.getMedicamentosButton().addActionListener(e -> {
            this.vistaPrincipal.setVisible(false);
            this.controladorMedicamentos.setVistaPrincipal(vistaPrincipal);
            this.controladorMedicamentos.iniciar();
        });

    }
}
