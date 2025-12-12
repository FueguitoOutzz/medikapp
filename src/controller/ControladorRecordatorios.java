package controller;

import model.Recordatorio;
import java.util.ArrayList;
import java.util.List;

public class ControladorRecordatorios {
	private final List<Recordatorio> recordatorios;
	private int nextId = 1;

	public ControladorRecordatorios() {
		this.recordatorios = new ArrayList<>();
	}

	public Recordatorio agregar(Recordatorio r) {
		if (r == null) throw new IllegalArgumentException("Recordatorio no puede ser null");
		r.setId(nextId++);
		recordatorios.add(r);
		return r;
	}

	public List<Recordatorio> listar() {
		return new ArrayList<>(recordatorios);
	}

	public Recordatorio buscarPorId(int id) {
		for (Recordatorio r : recordatorios) {
			if (r.getId() == id) return r;
		}
		return null;
	}

	public boolean eliminar(int id) {
		Recordatorio r = buscarPorId(id);
		if (r != null) {
			return recordatorios.remove(r);
		}
		return false;
	}

	public boolean actualizar(Recordatorio updated) {
		if (updated == null) return false;
		for (int i = 0; i < recordatorios.size(); i++) {
			if (recordatorios.get(i).getId() == updated.getId()) {
				recordatorios.set(i, updated);
				return true;
			}
		}
		return false;
	}
}
