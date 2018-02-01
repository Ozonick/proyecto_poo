package Controlador;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;

import Modelo.Usuario;
import Vista.AgregarUsuario;

public class ControladorAgregarUsuario extends ControladorPadre{
	private AgregarUsuario agregarUsuario;
	Usuario user;
	public ControladorAgregarUsuario() {
		this.setAgregarUsuario(new AgregarUsuario(this));
		this.getAgregarUsuario().setVisible(true);
		user = new Usuario();
		String[] str = user.consulColumna("nombre_provincia", "provincia");
		str[0] = "Selecciona una provincia";
		this.getAgregarUsuario().getCbxProvincia().setModel(new DefaultComboBoxModel(str));
		str = user.consulColumna("nombre_genero", "genero");
		str[0] = "Selecciona un genero";
		this.getAgregarUsuario().getCbxGenero().setModel(new DefaultComboBoxModel(str));
		str = user.consulColumna("pregunta", "pregunta");
		str[0] = "Selecciona una pregunta";
		this.getAgregarUsuario().getCbxPregunta().setModel(new DefaultComboBoxModel(str));
	}
	
	@Override
	public void focusLost(FocusEvent arg0) {
		switch (arg0.getComponent().getName()) {
		case "txtNombre":
			if (this.getAgregarUsuario().getTxtNombre().getText().isEmpty()) {
				this.getAgregarUsuario().getLblNombre().setForeground(Color.RED);
				this.getAgregarUsuario().getLblError().setVisible(true);
				this.getAgregarUsuario().getLblError2().setText("Se debe ingresar un nombre");
				this.getAgregarUsuario().getLblError2().setVisible(true);
			}
			break;
		case "txtApellido":
			if (this.getAgregarUsuario().getTxtApellido().getText().isEmpty()) {
				this.getAgregarUsuario().getLblApellido().setForeground(Color.RED);
				this.getAgregarUsuario().getLblError().setVisible(true);
				this.getAgregarUsuario().getLblError2().setText("Se debe ingresar un apellido");
				this.getAgregarUsuario().getLblError2().setVisible(true);
				
			}
			break;
		case "txtDni":
			if (this.getAgregarUsuario().getTxtDni().getText().isEmpty()) {
				this.getAgregarUsuario().getLblDni().setForeground(Color.RED);
				this.getAgregarUsuario().getLblError().setVisible(true);
				this.getAgregarUsuario().getLblError2().setText("Se debe ingresar un DNI");
				this.getAgregarUsuario().getLblError2().setVisible(true);
				
			}
			break;
		case "txtTelefono":
			if (this.getAgregarUsuario().getTxtTelefono().getText().isEmpty()) {
				this.getAgregarUsuario().getLblTelefono().setForeground(Color.RED);
				this.getAgregarUsuario().getLblError().setVisible(true);
				this.getAgregarUsuario().getLblError2().setText("Se debe ingresar un telefono sin codigo de area y sin 15");
				this.getAgregarUsuario().getLblError2().setVisible(true);
				
			}
			break;
		case "txtRespuesta":
			if (this.getAgregarUsuario().getTxtRespuesta().getText().isEmpty()) {
				this.getAgregarUsuario().getLblPreguntaSecreta().setForeground(Color.RED);
				this.getAgregarUsuario().getLblError().setVisible(true);
				this.getAgregarUsuario().getLblError2().setText("Se debe ingresar una respuesta");
				this.getAgregarUsuario().getLblError2().setVisible(true);
			}
			break;
		case "txtContrasenia":
			if (this.getAgregarUsuario().getTxtContrasenia().getText().isEmpty()) {
				this.getAgregarUsuario().getLblContrasenia().setForeground(Color.RED);
				this.getAgregarUsuario().getLblError().setVisible(true);
				this.getAgregarUsuario().getLblError2().setText("Se debe ingresar una contraseña");
				this.getAgregarUsuario().getLblError2().setVisible(true);
			}
			break;
		case "txtConfirmarContrasenia":
			if (this.getAgregarUsuario().getTxtConfirmarContrasenia().getText().isEmpty()) {
				this.getAgregarUsuario().getLblConfirmarContrasenia().setForeground(Color.RED);
				this.getAgregarUsuario().getLblError().setVisible(true);
				this.getAgregarUsuario().getLblError2().setText("Las contraseñas deben ser iguales");
				this.getAgregarUsuario().getLblError2().setVisible(true);
			}
			break;
		case "cbxTipoUsuario":
			if (this.getAgregarUsuario().getCbxTipoUsuario().getSelectedIndex() == 0) {
				this.getAgregarUsuario().getLblTipoUsuario().setForeground(Color.RED);
				this.getAgregarUsuario().getLblError().setVisible(true);
				this.getAgregarUsuario().getLblError2().setText("Eliga un tipo de usuario");
				this.getAgregarUsuario().getLblError2().setVisible(true);
			}
			break;
		case "cbxProvincia":
			if (this.getAgregarUsuario().getCbxProvincia().getSelectedIndex() == 0) {
				this.getAgregarUsuario().getLblProvincia().setForeground(Color.RED);
				this.getAgregarUsuario().getLblError().setVisible(true);
				this.getAgregarUsuario().getLblError2().setText("Eliga una provincia");
				this.getAgregarUsuario().getLblError2().setVisible(true);
				}
			break;
		case "cbxLocalidad":
			if (this.getAgregarUsuario().getCbxLocalidad().getSelectedIndex() == 0) {
				this.getAgregarUsuario().getLblLocalidad().setForeground(Color.RED);
				this.getAgregarUsuario().getLblError().setVisible(true);
				this.getAgregarUsuario().getLblError2().setText("Eliga una localidad");
				this.getAgregarUsuario().getLblError2().setVisible(true);
			}
			break;
		case "cbxGenero":
			if (this.getAgregarUsuario().getCbxGenero().getSelectedIndex() == 0) {
				this.getAgregarUsuario().getLblGenero().setForeground(Color.RED);
				this.getAgregarUsuario().getLblError().setVisible(true);
				this.getAgregarUsuario().getLblError2().setText("Eliga un genero");
				this.getAgregarUsuario().getLblError2().setVisible(true);
			}
			break;
		case "cbxPregunta":
			if (this.getAgregarUsuario().getCbxPregunta().getSelectedIndex() == 0) {
				this.getAgregarUsuario().getTxtRespuesta().setText("");
				this.getAgregarUsuario().getTxtRespuesta().setEditable(false);
				this.getAgregarUsuario().getLblPreguntaSecreta().setForeground(Color.RED);
				this.getAgregarUsuario().getLblError().setVisible(true);
				this.getAgregarUsuario().getLblError2().setText("Eliga una pregunta");
				this.getAgregarUsuario().getLblError2().setVisible(true);
			}else {
				if (this.getAgregarUsuario().getCbxPregunta().getSelectedIndex() != 0) {
					this.getAgregarUsuario().getTxtRespuesta().setEditable(true);
					this.getAgregarUsuario().getLblPreguntaSecreta().setForeground(Color.BLACK);
					this.getAgregarUsuario().getLblError().setVisible(false);
				}
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
				this.getAgregarUsuario().getLblNombre().setForeground(Color.BLACK);
				this.getAgregarUsuario().getLblError().setVisible(false);
			break;
		case "txtApellido":
			this.getAgregarUsuario().getLblApellido().setForeground(Color.BLACK);
			this.getAgregarUsuario().getLblError().setVisible(false);
			break;
		case "txtDni":
			if (!Character.isDigit(e.getKeyChar()) || (this.getAgregarUsuario().getTxtDni().getText().length()) >= 8) {
				e.consume();
				Toolkit.getDefaultToolkit().beep();
			}
			this.getAgregarUsuario().getLblDni().setForeground(Color.BLACK);
			this.getAgregarUsuario().getLblError().setVisible(false);
			break;
		case "txtTelefono":
			if (!Character.isDigit(e.getKeyChar()) || (this.getAgregarUsuario().getTxtTelefono().getText().length()) >= 7) {
				e.consume();
				Toolkit.getDefaultToolkit().beep();
			}
			this.getAgregarUsuario().getLblTelefono().setForeground(Color.BLACK);
			this.getAgregarUsuario().getLblError().setVisible(false);
			break;
		case "txtRespuesta":
			this.getAgregarUsuario().getLblPreguntaSecreta().setForeground(Color.BLACK);
			this.getAgregarUsuario().getLblError().setVisible(false);
			break;
		case "txtContrasenia":
			this.getAgregarUsuario().getLblContrasenia().setForeground(Color.BLACK);
			this.getAgregarUsuario().getLblError().setVisible(false);
			break;
		case "txtConfirmarContrasenia":
			this.getAgregarUsuario().getLblConfirmarContrasenia().setForeground(Color.BLACK);
			this.getAgregarUsuario().getLblError().setVisible(true);
			break;
		default:
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getComponent().getName()) {
		case "txtDni":
			
			break;
		case "txtTelefono":
			
			break;
		case "txtConfirmarContrasenia":
			if (this.getAgregarUsuario().getTxtContrasenia().getText().equals(this.getAgregarUsuario().getTxtConfirmarContrasenia().getText())) {
				this.getAgregarUsuario().getLblConfirmarContrasenia().setForeground(Color.BLACK);
				this.getAgregarUsuario().getLblError().setVisible(false);
				this.getAgregarUsuario().getLblError2().setText("Las contraseña deben ser iguales");
				this.getAgregarUsuario().getLblError2().setVisible(true);
			}
			break;
		default:
			break;
		}
	}
	public AgregarUsuario getAgregarUsuario() {
		return agregarUsuario;
	}
	public void setAgregarUsuario(AgregarUsuario agregarUsuario) {
		this.agregarUsuario = agregarUsuario;
	}
}
