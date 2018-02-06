package Controlador;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import Modelo.Hash;
import Modelo.Usuario;
import Vista.AgregarUsuario;

public class ControladorAgregarUsuario extends ControladorPadre {
	private static ControladorAgregarUsuario instance;
	private Usuario user;
	private Boolean[] bandera;

	public ControladorAgregarUsuario() {
		super.setAgregarUsuario(new AgregarUsuario(this));
		super.getAgregarUsuario().setVisible(true);
		user = new Usuario();
		creadorModelos();
		this.setBandera(new Boolean[12]);
		super.inicializadorDeBandera(this.getBandera());
	}
	public static ControladorAgregarUsuario getInstance() {
		if (instance == null) {
			instance = new ControladorAgregarUsuario();
		}
		return instance;
	}
	private void creadorModelos() {
		String[] str = user.consulColumna("nombre_provincia", "provincia");
		str[0] = "Selecciona una provincia";
		super.getAgregarUsuario().getCbxProvincia().setModel(new DefaultComboBoxModel(str));
		str = user.consulColumna("nombre_genero", "genero");
		str[0] = "Selecciona un genero";
		super.getAgregarUsuario().getCbxGenero().setModel(new DefaultComboBoxModel(str));
		str = user.consulColumna("pregunta", "pregunta");
		str[0] = "Selecciona una pregunta";
		super.getAgregarUsuario().getCbxPregunta().setModel(new DefaultComboBoxModel(str));

		str = user.consulColumna("nombre_localidad", "localidad");
		str[0] = "Selecciona una localidad";
		super.getAgregarUsuario().getCbxLocalidad().setModel(new DefaultComboBoxModel(str));
		str = user.consulColumna("nombre_usuario", "tipo_usuario");
		str[0] = "Seleccione un tipo";
		super.getAgregarUsuario().getCbxTipoUsuario().setModel(new DefaultComboBoxModel(str));
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		switch (arg0.getComponent().getName()) {
		case "txtNombre":
			if (super.getAgregarUsuario().getTxtNombre().getText().isEmpty()) {
				super.getAgregarUsuario().getLblNombre().setForeground(Color.RED);
				super.getAgregarUsuario().getLblError().setVisible(true);
				super.getAgregarUsuario().getLblError2().setText("Se debe ingresar un nombre");
				super.getAgregarUsuario().getLblError2().setVisible(true);
				this.getBandera()[0] = false;
			}
			break;
		case "txtApellido":
			if (super.getAgregarUsuario().getTxtApellido().getText().isEmpty()) {
				super.getAgregarUsuario().getLblApellido().setForeground(Color.RED);
				super.getAgregarUsuario().getLblError().setVisible(true);
				super.getAgregarUsuario().getLblError2().setText("Se debe ingresar un apellido");
				super.getAgregarUsuario().getLblError2().setVisible(true);
				this.getBandera()[1] = false;

			}
			break;
		case "txtDni":
			if (super.getAgregarUsuario().getTxtDni().getText().isEmpty() || super.getAgregarUsuario().getTxtDni().getText().length() < 8) {
				super.getAgregarUsuario().getLblDni().setForeground(Color.RED);
				super.getAgregarUsuario().getLblError().setVisible(true);
				super.getAgregarUsuario().getLblError2().setText("Se debe ingresar un DNI");
				super.getAgregarUsuario().getLblError2().setVisible(true);
				this.getBandera()[2] = false;
			}
			break;
		case "txtTelefono":
			if (super.getAgregarUsuario().getTxtTelefono().getText().isEmpty() || super.getAgregarUsuario().getTxtTelefono().getText().length() < 7) {
				super.getAgregarUsuario().getLblTelefono().setForeground(Color.RED);
				super.getAgregarUsuario().getLblError().setVisible(true);
				super.getAgregarUsuario().getLblError2()
						.setText("Se debe ingresar un telefono sin codigo de area y sin 15");
				super.getAgregarUsuario().getLblError2().setVisible(true);
				this.getBandera()[4] = false;

			}
			break;
		case "cbxProvincia":
			if (super.getAgregarUsuario().getCbxProvincia().getSelectedIndex() == 0) {
				super.getAgregarUsuario().getLblProvincia().setForeground(Color.RED);
				super.getAgregarUsuario().getLblError().setVisible(true);
				super.getAgregarUsuario().getLblError2().setText("Eliga una provincia");
				super.getAgregarUsuario().getLblError2().setVisible(true);
				super.getAgregarUsuario().getCbxLocalidad().setEnabled(false);
				this.getBandera()[5] = false;
			}
			break;
		case "txtRespuesta":
			if (super.getAgregarUsuario().getTxtRespuesta().getText().isEmpty()) {
				super.getAgregarUsuario().getLblPreguntaSecreta().setForeground(Color.RED);
				super.getAgregarUsuario().getLblError().setVisible(true);
				super.getAgregarUsuario().getLblError2().setText("Se debe ingresar una respuesta");
				super.getAgregarUsuario().getLblError2().setVisible(true);
				this.getBandera()[11] = false;
			}
			break;
		case "txtContrasenia":
			if (super.getAgregarUsuario().getTxtContrasenia().getText().isEmpty()) {
				super.getAgregarUsuario().getLblContrasenia().setForeground(Color.RED);
				super.getAgregarUsuario().getLblError().setVisible(true);
				super.getAgregarUsuario().getLblError2().setText("Se debe ingresar una contraseña");
				super.getAgregarUsuario().getLblError2().setVisible(true);
				this.getBandera()[8] = false;
			}
			break;
		case "txtConfirmarContrasenia":
			if (super.getAgregarUsuario().getTxtConfirmarContrasenia().getText().isEmpty()) {
				super.getAgregarUsuario().getLblConfirmarContrasenia().setForeground(Color.RED);
				super.getAgregarUsuario().getLblError().setVisible(true);
				super.getAgregarUsuario().getLblError2().setText("Las contraseñas deben ser iguales");
				super.getAgregarUsuario().getLblError2().setVisible(true);
			}
			break;
		case "cbxTipoUsuario":
			if (super.getAgregarUsuario().getCbxTipoUsuario().getSelectedIndex() == 0) {
				super.getAgregarUsuario().getLblTipoUsuario().setForeground(Color.RED);
				super.getAgregarUsuario().getLblError().setVisible(true);
				super.getAgregarUsuario().getLblError2().setText("Eliga un tipo de usuario");
				super.getAgregarUsuario().getLblError2().setVisible(true);
				this.getBandera()[3] = false;
			} else {
				super.getAgregarUsuario().getLblTipoUsuario().setForeground(Color.BLACK);
				super.getAgregarUsuario().getLblError().setVisible(false);
				super.getAgregarUsuario().getLblError2().setVisible(false);
				this.getBandera()[3] = true;
			}
			break;
		case "cbxLocalidad":
			if (super.getAgregarUsuario().getCbxLocalidad().getSelectedIndex() == 0) {
				super.getAgregarUsuario().getLblLocalidad().setForeground(Color.RED);
				super.getAgregarUsuario().getLblError().setVisible(true);
				super.getAgregarUsuario().getLblError2().setText("Eliga una localidad");
				super.getAgregarUsuario().getLblError2().setVisible(true);
				this.getBandera()[6] = false;
			} else {
				super.getAgregarUsuario().getLblLocalidad().setForeground(Color.BLACK);
				super.getAgregarUsuario().getLblError().setVisible(false);
				super.getAgregarUsuario().getLblError2().setVisible(false);
				this.getBandera()[6] = true;
			}
			break;
		case "cbxGenero":
			if (super.getAgregarUsuario().getCbxGenero().getSelectedIndex() == 0) {
				super.getAgregarUsuario().getLblGenero().setForeground(Color.RED);
				super.getAgregarUsuario().getLblError().setVisible(true);
				super.getAgregarUsuario().getLblError2().setText("Eliga un genero");
				super.getAgregarUsuario().getLblError2().setVisible(true);
				this.getBandera()[7] = false;
			} else {
				super.getAgregarUsuario().getLblGenero().setForeground(Color.BLACK);
				super.getAgregarUsuario().getLblError().setVisible(false);
				super.getAgregarUsuario().getLblError2().setVisible(false);
				this.getBandera()[7] = true;
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {

		if (super.getAgregarUsuario().getCbxProvincia().getSelectedIndex() == 0) {
			super.getAgregarUsuario().getLblProvincia().setForeground(Color.RED);
			super.getAgregarUsuario().getLblError().setVisible(true);
			super.getAgregarUsuario().getLblError2().setText("Eliga una provincia");
			super.getAgregarUsuario().getLblError2().setVisible(true);
			super.getAgregarUsuario().getCbxLocalidad().setEnabled(false);
		} else {
			if (super.getAgregarUsuario().getCbxLocalidad().getSelectedIndex() == 0) {
				super.getAgregarUsuario().getCbxLocalidad().setModel(new DefaultComboBoxModel(this.getUser()
						.consultaLocalidad(super.getAgregarUsuario().getCbxProvincia().getSelectedItem().toString())));
				super.getAgregarUsuario().getCbxLocalidad().setEnabled(true);
				super.getAgregarUsuario().getLblProvincia().setForeground(Color.BLACK);
				super.getAgregarUsuario().getLblError().setVisible(false);
				this.getBandera()[5] = true;
			}
		}
		if (super.getAgregarUsuario().getCbxPregunta().getSelectedIndex() == 0) {
			super.getAgregarUsuario().getTxtRespuesta().setText("");
			super.getAgregarUsuario().getTxtRespuesta().setEditable(false);
			super.getAgregarUsuario().getLblPreguntaSecreta().setForeground(Color.RED);
			super.getAgregarUsuario().getLblError().setVisible(true);
			super.getAgregarUsuario().getLblError2().setText("Eliga una pregunta");
			super.getAgregarUsuario().getLblError2().setVisible(true);
			this.getBandera()[10] = false;
		} else {

			super.getAgregarUsuario().getTxtRespuesta().setEditable(true);
			super.getAgregarUsuario().getLblPreguntaSecreta().setForeground(Color.BLACK);
			super.getAgregarUsuario().getLblError().setVisible(false);
			this.getBandera()[10] = true;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		switch (e.getComponent().getName()) {
		case "txtNombre":
			super.getAgregarUsuario().getLblNombre().setForeground(Color.BLACK);
			super.getAgregarUsuario().getLblError().setVisible(false);
			this.getBandera()[0] = true;
			break;
		case "txtApellido":
			super.getAgregarUsuario().getLblApellido().setForeground(Color.BLACK);
			super.getAgregarUsuario().getLblError().setVisible(false);
			this.getBandera()[1] = true;
			break;
		case "txtDni":
			if (!Character.isDigit(e.getKeyChar()) || (super.getAgregarUsuario().getTxtDni().getText().length()) >= 8) {
				e.consume();
				Toolkit.getDefaultToolkit().beep();
			}
			if (super.getAgregarUsuario().getTxtDni().getText().length() < 8) {
				Boolean marca = true;
				String[] dni = user.consulColumna("dni", "usuario");
				for (int i = 1; i < dni.length; i++) {
					//System.out.println(dni[i]);
					if (dni[i].equals(super.getAgregarUsuario().getTxtDni().getText() + e.getKeyChar())) {
						marca = false;
						break;
					}
				}
				if (marca) {
					super.getAgregarUsuario().getLblDni().setForeground(Color.BLACK);
					super.getAgregarUsuario().getLblError().setVisible(false);
					this.getBandera()[2] = true;
				}else {
					super.getAgregarUsuario().getLblDni().setForeground(Color.RED);
					super.getAgregarUsuario().getLblError().setVisible(true);
					super.getAgregarUsuario().getLblError2().setText("El DNI ya existe");
					super.getAgregarUsuario().getLblError2().setVisible(true);
					this.getBandera()[2] = false;
				}
			}
			break;
		case "txtTelefono":
			if (!Character.isDigit(e.getKeyChar())
					|| (super.getAgregarUsuario().getTxtTelefono().getText().length()) >= 7) {
				e.consume();
				Toolkit.getDefaultToolkit().beep();
			}
			super.getAgregarUsuario().getLblTelefono().setForeground(Color.BLACK);
			super.getAgregarUsuario().getLblError().setVisible(false);
			this.getBandera()[4] = true;
			break;
		case "txtRespuesta":
			super.getAgregarUsuario().getLblPreguntaSecreta().setForeground(Color.BLACK);
			super.getAgregarUsuario().getLblError().setVisible(false);
			this.getBandera()[11] = true;
			break;
		case "txtContrasenia":
			super.getAgregarUsuario().getLblContrasenia().setForeground(Color.BLACK);
			super.getAgregarUsuario().getLblError().setVisible(false);
			this.getBandera()[8] = true;
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getComponent().getName()) {
		case "txtContrasenia":
			if (super.getAgregarUsuario().getTxtContrasenia().getText()
					.equals(super.getAgregarUsuario().getTxtConfirmarContrasenia().getText())) {
				super.getAgregarUsuario().getLblConfirmarContrasenia().setForeground(Color.BLACK);
				super.getAgregarUsuario().getLblError().setVisible(false);
				this.getBandera()[8] = true;
			}
		case "txtConfirmarContrasenia":
			if (super.getAgregarUsuario().getTxtContrasenia().getText()
					.equals(super.getAgregarUsuario().getTxtConfirmarContrasenia().getText())) {
				super.getAgregarUsuario().getLblConfirmarContrasenia().setForeground(Color.BLACK);
				super.getAgregarUsuario().getLblError().setVisible(false);
				this.getBandera()[9] = true;

			} else {
				super.getAgregarUsuario().getLblConfirmarContrasenia().setForeground(Color.RED);
				super.getAgregarUsuario().getLblError().setVisible(true);
				super.getAgregarUsuario().getLblError2().setText("Las contraseña deben ser iguales");
				super.getAgregarUsuario().getLblError2().setVisible(true);
				this.getBandera()[9] = false;
			}
			break;
		default:
			break;
		}
	}

	private void ponerEnRojo() {
		if (!this.getBandera()[0]) {
			super.getAgregarUsuario().getLblNombre().setForeground(Color.RED);
		}
		if (!this.getBandera()[1]) {
			super.getAgregarUsuario().getLblApellido().setForeground(Color.RED);
		}
		if (!this.getBandera()[2]) {
			super.getAgregarUsuario().getLblDni().setForeground(Color.RED);
		}
		if (!this.getBandera()[3]) {
			super.getAgregarUsuario().getLblTipoUsuario().setForeground(Color.RED);
		}
		if (!this.getBandera()[4]) {
			super.getAgregarUsuario().getLblTelefono().setForeground(Color.RED);
		}
		if (!this.getBandera()[5]) {
			super.getAgregarUsuario().getLblProvincia().setForeground(Color.RED);
		}
		if (!this.getBandera()[6]) {
			super.getAgregarUsuario().getLblLocalidad().setForeground(Color.RED);
		}
		if (!this.getBandera()[7]) {
			super.getAgregarUsuario().getLblGenero().setForeground(Color.RED);
		}
		if (!this.getBandera()[8]) {
			super.getAgregarUsuario().getLblContrasenia().setForeground(Color.RED);
		}
		if (!this.getBandera()[9]) {
			super.getAgregarUsuario().getLblConfirmarContrasenia().setForeground(Color.RED);
		}
		if (!this.getBandera()[10]) {
			super.getAgregarUsuario().getLblPreguntaSecreta().setForeground(Color.RED);
		}
		if (!this.getBandera()[11]) {
			super.getAgregarUsuario().getLblPreguntaSecreta().setForeground(Color.RED);
		}
		super.getAgregarUsuario().getLblError().setVisible(true);
		super.getAgregarUsuario().getLblError2().setText("Faltan completar campos");
		super.getAgregarUsuario().getLblError2().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getAgregarUsuario().getBtnGuardar())) {
			super.getAgregarUsuario().getLblError().setVisible(false);
			super.getAgregarUsuario().getLblError2().setVisible(false);
			
			
			if (super.revisarbanderas(this.getBandera()) == 12) {
				this.getUser().setNombre(super.getAgregarUsuario().getTxtNombre().getText());
				
				this.getUser().setApellido(super.getAgregarUsuario().getTxtApellido().getText());
				
				this.getUser().setDNI(Integer.parseInt((super.getAgregarUsuario().getTxtDni().getText())));
				
				this.getUser().setTipo(super.getAgregarUsuario().getCbxTipoUsuario().getSelectedItem().toString());
				
				this.getUser().setTelefono(Integer.parseInt(super.getAgregarUsuario().getTxtTelefono().getText()));
				
				this.getUser().setLocalidad(super.getAgregarUsuario().getCbxLocalidad().getSelectedItem().toString());
				
				this.getUser().setGenero(super.getAgregarUsuario().getCbxGenero().getSelectedItem().toString());
				
				this.getUser().setContrasenia(Hash.md5(super.getAgregarUsuario().getTxtContrasenia().getText()));
				
				this.getUser().setRespuesta(Hash.md5(super.getAgregarUsuario().getTxtRespuesta().getText()));
				
				this.getUser().setPregunta(super.getAgregarUsuario().getCbxPregunta().getSelectedItem().toString());
				user.guardarUsuario(user);
				JOptionPane.showMessageDialog(getAgregarUsuario(), "Guardado correctamente");
				super.getAgregarUsuario().setVisible(false);
			} else {
				//System.out.println(i);
				ponerEnRojo();
			}
		} else {
			super.getAgregarUsuario().dispose();
			ControladorVistaAdmin.getInstance().getVistaAdmin().setVisible(true);
		}
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Boolean[] getBandera() {
		return bandera;
	}

	public void setBandera(Boolean[] bandera) {
		this.bandera = bandera;
	}

}
