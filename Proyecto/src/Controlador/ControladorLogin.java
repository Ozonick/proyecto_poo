package Controlador;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import Modelo.Hash;
import Modelo.Usuario;
import Vista.Login;

public class ControladorLogin extends ControladorPadre {
	private static ControladorLogin instance;
	
	public ControladorLogin() {
		super.setLogin(new Login(this));
		super.getLogin().setVisible(true);
	}
	public static ControladorLogin getInstance() {
		if (instance == null) {
			instance = new ControladorLogin();
		}
		return instance;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (Usuario.getInstance().iniciarSecion(super.getLogin().getTxtUsuario().getText(), Hash.md5(super.getLogin().getTxtContrasenia().getText()))) {
				super.getLogin().dispose();
				ControladorVistaAdmin.getInstance().getVistaAdmin().setVisible(true);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
