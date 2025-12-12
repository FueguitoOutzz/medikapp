package view;

import model.Recordatorio;
import java.util.List;
import java.util.Scanner;

public class VistaRecordatorios {
	private static final Scanner SC = new Scanner(System.in);

	public static void mostrarListado(List<Recordatorio> list) {
		if (list == null || list.isEmpty()) {
			System.out.println("No hay recordatorios.");
			return;
		}
		for (Recordatorio r : list) {
			mostrarRecordatorio(r);
		}
	}

	public static void mostrarRecordatorio(Recordatorio r) {
		if (r == null) return;
		System.out.println("ID: " + r.getId() + " | Estado: " + r.getEstado() + " | Mensaje: " + r.getMensaje() + " | Fecha: " + r.getFechaProg());
	}

	public static int solicitarId() {
		System.out.print("Ingrese ID: ");
		while (!SC.hasNextInt()) {
			System.out.print("ID inválido. Intente de nuevo: ");
			SC.next();
		}
		int id = SC.nextInt();
		SC.nextLine();
		return id;
	}

	public static Recordatorio leerRecordatorioDatos() {
		System.out.print("Mensaje: ");
		String mensaje = SC.nextLine();
		System.out.print("Fecha (cadena): ");
		String fecha = SC.nextLine();
		System.out.print("Estado (PENDIENTE/ENVIADO/CANCELADO): ");
		String estado = SC.nextLine();
		return new Recordatorio(0, fecha, mensaje, estado);
	}
}
