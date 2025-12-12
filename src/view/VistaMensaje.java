package view;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class VistaMensaje {
    public static void verMensajeError(JDialog parent, String mensaje) {
        JOptionPane.showMessageDialog(parent, mensaje,
                "Descripción error", JOptionPane.ERROR_MESSAGE);
    }

    public static void verMensajeInfo(JDialog parent, String mensaje) {
        JOptionPane.showMessageDialog(parent, mensaje, "Información",
                JOptionPane.INFORMATION_MESSAGE);
    }    
}
