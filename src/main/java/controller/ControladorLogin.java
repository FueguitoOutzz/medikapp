package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.GestorUsuarios;
import model.Usuario;
import view.VistaMensaje;
import view.VistaLogin;

public class ControladorLogin {
    private VistaLogin view;
    private GestorUsuarios gestorUsuarios;
    private ControladorMenu controladorMenu;

    public ControladorLogin() {
        this.view = new VistaLogin();
        this.gestorUsuarios = new GestorUsuarios();
        this.controladorMenu = new ControladorMenu();

        this.view.getBtnIngresar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarLogin();
            }
        });
    }

    public void iniciar() {
        this.view.setVisible(true);
    }

    private void validarLogin() {
        String nickname = this.view.getTxtNickname().getText();
        String contrasena = new String(this.view.getTxtPass().getPassword());

        Usuario usuario = this.gestorUsuarios.validarUsuario(nickname, contrasena);

        if (usuario != null) {
            this.view.dispose();
            this.controladorMenu.iniciar();
        } else {
            VistaMensaje.verMensajeError(null, "Usuario o contraseña incorrectos.");
        }
    }
}
