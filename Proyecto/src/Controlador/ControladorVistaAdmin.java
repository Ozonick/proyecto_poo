package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.VistaAdmin;

public class ControladorVistaAdmin extends ControladorPadre {
	private static ControladorVistaAdmin instance;
	private ActionListener usuario;
	private ActionListener curso;
	public ControladorVistaAdmin() {
		super.setVistaAdmin(new VistaAdmin(this));
		this.setUsuario(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorVistaAdmin.getInstance().getVistaAdmin().dispose();
				ControladorAgregarUsuario.getInstance().getAgregarUsuario().setVisible(true);
			}
		});
		this.setCurso(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ControladorVistaAdmin.getInstance().getVistaAdmin().dispose();
				ControladorAgregarCurso.getInstance().getAgregarCurso().setVisible(true);
			}
		});
	}
	public static ControladorVistaAdmin getInstance() {
		if (instance == null) {
			instance = new ControladorVistaAdmin();
		}
		return instance;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(super.getVistaAdmin().getMntmUsuarios())) {
			super.getVistaAdmin().setTitle("Usuarios");
			super.getVistaAdmin().getBtnAgregar().addActionListener(getUsuario());
			super.getVistaAdmin().getBtnAgregar().removeActionListener(getCurso());
		}
		if (e.getSource().equals(super.getVistaAdmin().getMntmCursos())) {
			super.getVistaAdmin().setTitle("Cursos");
			super.getVistaAdmin().getBtnAgregar().addActionListener(getCurso());
			super.getVistaAdmin().getBtnAgregar().removeActionListener(getUsuario());
		}
	}
	public ActionListener getUsuario() {
		return usuario;
	}
	public void setUsuario(ActionListener usuario) {
		this.usuario = usuario;
	}
	public ActionListener getCurso() {
		return curso;
	}
	public void setCurso(ActionListener curso) {
		this.curso = curso;
	}
}
