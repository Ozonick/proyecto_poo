package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.security.cert.TrustAnchor;

import javax.swing.DefaultComboBoxModel;

import Modelo.Curso;
import Vista.AgregarCurso;

public class ControladorAgregarCurso extends ControladorPadre {
	private static ControladorAgregarCurso instance;
	private Curso curso;
	private Boolean[] bandera;
 public ControladorAgregarCurso() {
	// TODO Auto-generated constructor stub
	 super.setAgregarCurso(new AgregarCurso(this));
	 super.getAgregarCurso().setVisible(true);
	 this.setCurso(new Curso());
	 this.getCurso().setHorario(null);
	 this.setBandera(new Boolean[6]);
	 super.inicializadorDeBandera(this.getBandera());
	 creadorModelos();
}
 private void creadorModelos() {
		String[] str = curso.consulColumna();
		str[0] = "Selecciona un profesor";
		super.getAgregarCurso().getCbxProfesor().setModel(new DefaultComboBoxModel(str));
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
			break;
		}
	}
 @Override
	public void keyTyped(KeyEvent e) {
		switch (e.getComponent().getName()) {
		case "txtNombre":
			super.getAgregarCurso().getLblNombre().setForeground(Color.BLACK);
			super.getAgregarCurso().getLblError().setVisible(false);
			this.getBandera()[0] = true;
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
		this.getBandera()[3] = true;
	}
		
	}

@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getAgregarCurso().getBtnGuardar())) {
			this.getBandera()[4] = true;
			this.getBandera()[1] = true;
			this.getBandera()[2] = true;
			if (this.getCurso().getHorario() != null) {
				this.getBandera()[5] = true;
			}
			if (super.revisarbanderas(this.getBandera()) == 6) {
				this.getCurso().setNombre(super.getAgregarCurso().getTxtNombre().getText());
				this.getCurso().setInicio(super.getAgregarCurso().getDateInicio().getDate());
				this.getCurso().setFinalizacion(super.getAgregarCurso().getDateFinalizacion().getDate());
				this.getCurso().setProfesor(super.getAgregarCurso().getCbxProfesor().getSelectedItem().toString());
				this.getCurso().setLimiteDeCupos(Integer.valueOf(super.getAgregarCurso().getSpLimiteDeCupos().getValue().toString()));
				this.getCurso().crearCurso(this.getCurso());
			}
		}
		if (e.getSource().equals(super.getAgregarCurso().getBtnHorarios())) {
			ControladorHorario.getInstance(this.getCurso()).getVistaHorario().setVisible(true);
		}
		if (e.getSource().equals(super.getAgregarCurso().getBtnCancelar())) {
			super.getAgregarCurso().dispose();
			ControladorVistaAdmin.getInstance().getVistaAdmin().setVisible(true);
		}
	}
public Curso getCurso() {
	return curso;
}
public void setCurso(Curso curso) {
	this.curso = curso;
}
public Boolean[] getBandera() {
	return bandera;
}
public void setBandera(Boolean[] bandera) {
	this.bandera = bandera;
}
 
	
}
