package Controlador;

import java.awt.EventQueue;

import Vista.Login;
import Vista.AgregarUsuario;
public class Main {
Login miLogin;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					ControladorAgregarCurso.getInstance();
					//controlador.getVista().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	}


