package Controlador;

import Vista.VistaHorario;

public class ControladorHorario extends ControladorPadre {
	private static ControladorHorario instance;
	public ControladorHorario() {
		super.setHorario(new VistaHorario(this));
	}
	
	public static ControladorHorario getInstance() {
		if (instance == null) {
			instance = new ControladorHorario();
		}
		return instance;
	}
}
