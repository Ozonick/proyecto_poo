package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import Modelo.Curso;
import Vista.AgregarCurso;

public class ControladorAgregarCurso extends ControladorPadre {
	private static ControladorAgregarCurso instance;
 private Curso curso;
 
 public ControladorAgregarCurso() {
	// TODO Auto-generated constructor stub
	 super.setAgregarCurso(new AgregarCurso(this));
	 super.getAgregarCurso().setVisible(true);
	 curso = new Curso();
	 creadorModelos();
}
 private void creadorModelos() {
		//String[] str = curso.consulColumna("usuario");
		//str[0] = "Selecciona un profesor";
		//super.getAgregarCurso().getCbxProfesor().setModel(new DefaultComboBoxModel(str));
	}
	public static ControladorAgregarCurso getInstance() {
		if (instance == null) {
			instance = new ControladorAgregarCurso();
		}
		return instance;
	}
 @Override
 public void focusLost(FocusEvent arg0) {
		switch (arg0.getComponent().getName()) {
		case "txtNombre":
			if (super.getAgregarCurso().getTxtNombre().getText().isEmpty()) {
				super.getAgregarCurso().getLblNombre().setForeground(Color.RED);
				super.getAgregarCurso().getLblError().setVisible(true);
			}
			break;
		case "cbxProfesor":
			if (super.getAgregarCurso().getCbxProfesor().getSelectedIndex() == 0) {
				super.getAgregarCurso().getLblProfesores().setForeground(Color.RED);
				super.getAgregarCurso().getLblError().setVisible(true);
			}
			break;
		default:
			System.out.println("holaaaaa");
			break;
		}
	}
 @Override
	public void keyTyped(KeyEvent e) {
		switch (e.getComponent().getName()) {
		case "txtNombre":
			super.getAgregarCurso().getLblNombre().setForeground(Color.BLACK);
			super.getAgregarCurso().getLblError().setVisible(false);
			break;

		default:
			break;
		}
	}
@Override
	public void itemStateChanged(ItemEvent arg0) {
	if (super.getAgregarCurso().getCbxProfesor().getSelectedIndex() == 0) {
		super.getAgregarCurso().getLblProfesores().setForeground(Color.RED);
		super.getAgregarCurso().getLblError().setVisible(true);
	}else {
		super.getAgregarCurso().getLblProfesores().setForeground(Color.BLACK);
	}
		
	}

@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getAgregarCurso().getBtnGuardar())) {
			super.getAgregarCurso().getLblError().setVisible(false);
		}
		if (e.getSource().equals(super.getAgregarCurso().getBtnHorarios())) {
			ControladorHorario.getInstance().getHorario().setVisible(true);
		}
		if (e.getSource().equals(super.getAgregarCurso().getBtnCancelar())) {
			super.getAgregarCurso().setVisible(false);
		}
	}
public Curso getCurso() {
	return curso;
}
public void setCurso(Curso curso) {
	this.curso = curso;
}
 
	
}
