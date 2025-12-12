/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package mvc_recordatorio_medico;

import controller.ControladorMedicamentos;
import controller.ControladorVistaPrincipal;

/**
 *
 * @author Mizu
 */
public class Mvc_recordatorio_medico {

    public static void main(String[] args) {
        ControladorMedicamentos controlador = new ControladorMedicamentos();
        ControladorVistaPrincipal controladorMenu = new ControladorVistaPrincipal();
        
        controladorMenu.iniciar();
        //controlador.iniciar();
        
    }
}
