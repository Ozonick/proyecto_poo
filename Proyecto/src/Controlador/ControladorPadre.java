package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Vista.AgregarCurso;
import Vista.AgregarUsuario;
import Vista.Login;
import Vista.VistaAdmin;
import Vista.VistaHorario;

public class ControladorPadre implements FocusListener, KeyListener, ItemListener, ActionListener{
	private static ControladorPadre instance;
	private VistaHorario vistaHorario;
	private AgregarCurso agregarCurso;
	private AgregarUsuario agregarUsuario;
	private Login login;
	private VistaAdmin vistaAdmin;
	
	public ControladorPadre() {
		//login
	}
	public static ControladorPadre getInstance() {
		if (instance == null) {
			instance = new ControladorPadre();
		}
		return instance;
	}
	public Integer revisarbanderas(Boolean[] bandera) {
		Integer i = 0;
		for (Boolean boolean1 : bandera) {
			if (!boolean1) {
				break;
			}
			i++;
		}
		return i;
	}
	public void inicializadorDeBandera(Boolean[] bandera) {
		for (int i = 0; i < bandera.length; i++) {
			bandera[i] = false;
		}
	}
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public AgregarCurso getAgregarCurso() {
		return agregarCurso;
	}
	public void setAgregarCurso(AgregarCurso agregarCurso) {
		this.agregarCurso = agregarCurso;
	}
	public AgregarUsuario getAgregarUsuario() {
		return agregarUsuario;
	}
	public void setAgregarUsuario(AgregarUsuario agregarUsuario) {
		this.agregarUsuario = agregarUsuario;
	}
	public VistaHorario getVistaHorario() {
		return vistaHorario;
	}
	public void setVistaHorario(VistaHorario vistaHorario) {
		this.vistaHorario = vistaHorario;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public VistaAdmin getVistaAdmin() {
		return vistaAdmin;
	}
	public void setVistaAdmin(VistaAdmin vistaAdmin) {
		this.vistaAdmin = vistaAdmin;
	}
}
