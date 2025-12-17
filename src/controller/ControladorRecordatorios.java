package controller;

import DAOs.RecordatoriosDAO;
import model.Recordatorio;
import view.VistaRecordatorios;
import view.VistaAñadirRecordatorio;
import view.VistaEditarRecordatorio;
import view.VistaMensaje;
import view.VistaPrincipal;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * Controlador para gestionar recordatorios usando patrón MVC
 * @author Sistema
 */
public class ControladorRecordatorios {
    private RecordatoriosDAO recordatoriosDAO;
    private ArrayList<Recordatorio> recordatorios;
    private VistaRecordatorios vista;
    private VistaAñadirRecordatorio vistaAgregar;
    private VistaEditarRecordatorio vistaEditar;
    private VistaPrincipal vistaPrincipal;
    private boolean configurado = false;

    public ControladorRecordatorios() {
        this.recordatoriosDAO = new RecordatoriosDAO();
        this.recordatorios = new ArrayList<>();
        this.vista = new VistaRecordatorios();
        this.vistaAgregar = new VistaAñadirRecordatorio();
        this.vistaEditar = new VistaEditarRecordatorio();
    }

    public void setVistaPrincipal(VistaPrincipal vP) {
        this.vistaPrincipal = vP;
    }

    public void iniciar() {
        this.vista.setVisible(true);

        if (!configurado) {
            configurarBotones();
            configurado = true;
        }
        listarRecordatorios();
    }

    private void configurarBotones() {
        this.vista.getAgregarButton().addActionListener(e -> abrirDialogoAgregar());
        this.vista.getLimpiarButton().addActionListener(e -> limpiarFormulario());
        this.vista.getEditarButton().addActionListener(e -> editarRecordatorio());
        this.vista.getVolverButton().addActionListener(e -> volverAtras());
        this.vista.getEliminarButton().addActionListener(e -> eliminarRecordatorio());
    }

    private void abrirDialogoAgregar() {
        vistaAgregar.setLocationRelativeTo(vista);
        vistaAgregar.setVisible(true);
        vistaAgregar.getCrearButton().addActionListener(e -> agregarRecordatorio());
        vistaAgregar.getCancelarButton().addActionListener(e -> vistaAgregar.setVisible(false));
    }

    public void agregarRecordatorio() {
        try {
            String mensaje = vistaAgregar.getMensajeField().getText();
            String fecha = vistaAgregar.getFechaField().getText();
            String estado = vistaAgregar.getEstadoBox().getSelectedItem().toString();

            if (mensaje.isEmpty() || fecha.isEmpty()) {
                VistaMensaje.verMensajeError(null, "Faltan campos por completar.");
                return;
            }

            Recordatorio nuevoRecordatorio = new Recordatorio(0, fecha, mensaje, estado);
            recordatoriosDAO.crearRecordatorio(nuevoRecordatorio);

            VistaMensaje.verMensajeInfo(null, "Recordatorio Agregado Correctamente");
            limpiarFormulario();
            vistaAgregar.setVisible(false);
            listarRecordatorios();

        } catch (IllegalArgumentException ex) {
            VistaMensaje.verMensajeError(null, "Error: " + ex.getMessage());
        }
    }

    private void listarRecordatorios() {
        recordatorios = recordatoriosDAO.getRecordatorios();
        DefaultTableModel m = (DefaultTableModel) vista.getTabla().getModel();
        m.setNumRows(0);
        for (Recordatorio r : recordatorios) {
            m.addRow(new Object[]{r.getId(), r.getFechaProg(), r.getMensaje(), r.getEstado()});
        }
    }

    private void editarRecordatorio() {
        int row = vista.getTabla().getSelectedRow();
        if (row == -1) {
            VistaMensaje.verMensajeError(null, "Seleccione un recordatorio para editar.");
            return;
        }

        int id = (Integer) vista.getTabla().getValueAt(row, 0);
        Recordatorio r = buscarPorId(id);

        if (r == null) {
            VistaMensaje.verMensajeError(null, "Recordatorio no encontrado.");
            return;
        }

        vistaEditar.setRecordatorio(r);
        vistaEditar.setLocationRelativeTo(vista);
        vistaEditar.setVisible(true);
        vistaEditar.getGuardarButton().addActionListener(e -> guardarRecordatorioEditado(id));
        vistaEditar.getCancelarButton().addActionListener(e -> vistaEditar.setVisible(false));
    }

    private void guardarRecordatorioEditado(int id) {
        try {
            String mensaje = vistaEditar.getMensajeField().getText();
            String fecha = vistaEditar.getFechaField().getText();
            String estado = vistaEditar.getEstadoBox().getSelectedItem().toString();

            if (mensaje.isEmpty() || fecha.isEmpty()) {
                VistaMensaje.verMensajeError(null, "Faltan campos por completar.");
                return;
            }

            Recordatorio r = new Recordatorio(id, fecha, mensaje, estado);
            recordatoriosDAO.actualizarRecordatorio(r, id);

            VistaMensaje.verMensajeInfo(null, "Recordatorio Actualizado Correctamente");
            vistaEditar.setVisible(false);
            listarRecordatorios();

        } catch (IllegalArgumentException ex) {
            VistaMensaje.verMensajeError(null, "Error: " + ex.getMessage());
        }
    }

    private void eliminarRecordatorio() {
        int row = vista.getTabla().getSelectedRow();
        if (row == -1) {
            VistaMensaje.verMensajeError(null, "Seleccione un recordatorio para eliminar.");
            return;
        }

        int id = (Integer) vista.getTabla().getValueAt(row, 0);
        recordatoriosDAO.eliminarRecordatorio(id);
        VistaMensaje.verMensajeInfo(null, "Recordatorio Eliminado Correctamente");
        listarRecordatorios();
    }

    private void limpiarFormulario() {
        vistaAgregar.getMensajeField().setText("");
        vistaAgregar.getFechaField().setText("");
        vistaAgregar.getMensajeField().requestFocus();
    }

    private void volverAtras() {
        this.vista.setVisible(false);
        if (vistaPrincipal != null) {
            this.vistaPrincipal.setVisible(true);
        }
    }

    public Recordatorio buscarPorId(int id) {
        for (Recordatorio r : recordatorios) {
            if (r.getId() == id) return r;
        }
        return null;
    }

    public ArrayList<Recordatorio> listar() {
        return new ArrayList<>(recordatorios);
    }
}
