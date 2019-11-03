package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorPadre;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class AgregarUsuario extends JFrame {

	private JPanel contentPane;
	private JLabel lblAgregarUsuario;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JPasswordField txtContrasenia;
	private JPasswordField txtConfirmarContrasenia;
	private ControladorPadre controlador;
	private JComboBox cbxTipoUsuario;
	private JLabel lblGenero;
	private JComboBox cbxProvincia;
	private JComboBox cbxLocalidad;
	private JComboBox cbxGenero;
	private JComboBox cbxPregunta;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JTextField txtRespuesta;
	private JLabel lblError;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblDni;
	private JLabel lblTipoUsuario;
	private JLabel lblTelefono;
	private JLabel lblProvincia;
	private JLabel lblLocalidad;
	private JLabel lblContrasenia;
	private JLabel lblConfirmarContrasenia;
	private JLabel lblPreguntaSecreta;
	private JLabel lblError2;

	/**
	 * /** Create the frame.
	 */
	public AgregarUsuario(ControladorPadre controlador) {
		setResizable(false);
		this.setControlador(controlador);
		setLocationRelativeTo(null);
		setTitle("Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 629);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblAgregarUsuario = new JLabel("Agregar usuario");
		lblAgregarUsuario.setBounds(11, 11, 304, 37);
		lblAgregarUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarUsuario.setFont(new Font("Arial Black", Font.PLAIN, 15));

		lblNombre = new JLabel("Nombre:*");
		lblNombre.setBounds(11, 69, 94, 25);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblApellido = new JLabel("Apellido:*");
		lblApellido.setBounds(11, 103, 65, 25);
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblDni = new JLabel("DNI:*");

		lblDni.setBounds(11, 139, 46, 14);
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblTipoUsuario = new JLabel("Tipo de usuario:*");
		lblTipoUsuario.setBounds(11, 164, 112, 25);
		lblTipoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));

		cbxTipoUsuario = new JComboBox();
		cbxTipoUsuario.addFocusListener(getControlador());
		cbxTipoUsuario.setName("cbxTipoUsuario");
		cbxTipoUsuario.setBounds(144, 166, 171, 22);

		lblTelefono = new JLabel("Telefono:*");
		lblTelefono.setBounds(11, 200, 65, 22);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblContrasenia = new JLabel("Contrase\u00F1a:*");
		lblContrasenia.setBounds(11, 335, 94, 25);
		lblContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtTelefono = new JTextField();
		txtTelefono.setName("txtTelefono");
		txtTelefono.addFocusListener(getControlador());
		txtTelefono.addKeyListener(getControlador());
		txtTelefono.setBounds(144, 202, 171, 20);
		txtTelefono.setColumns(10);

		txtDni = new JTextField();
		txtDni.setName("txtDni");
		txtDni.addFocusListener(getControlador());
		txtDni.addKeyListener(getControlador());
		txtDni.setBounds(144, 137, 171, 20);
		txtDni.setColumns(10);

		txtApellido = new JTextField();
		txtApellido.setName("txtApellido");
		txtApellido.addFocusListener(getControlador());
		txtApellido.addKeyListener(getControlador());
		txtApellido.setBounds(144, 106, 171, 20);
		txtApellido.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setName("txtNombre");
		txtNombre.addFocusListener(getControlador());
		txtNombre.addKeyListener(getControlador());
		txtNombre.setBounds(144, 72, 171, 20);
		txtNombre.setColumns(10);

		txtContrasenia = new JPasswordField();
		txtContrasenia.setName("txtContrasenia");
		txtContrasenia.addFocusListener(getControlador());
		txtContrasenia.addKeyListener(getControlador());
		txtContrasenia.setBounds(144, 337, 171, 22);

		lblConfirmarContrasenia = new JLabel("Conf. contrase\u00F1a:*");
		lblConfirmarContrasenia.setBounds(11, 371, 112, 21);
		lblConfirmarContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtConfirmarContrasenia = new JPasswordField();
		txtConfirmarContrasenia.setName("txtConfirmarContrasenia");
		txtConfirmarContrasenia.addFocusListener(getControlador());
		txtConfirmarContrasenia.addKeyListener(getControlador());
		txtConfirmarContrasenia.setBounds(144, 371, 171, 22);

		lblGenero = new JLabel("Genero:*");
		lblGenero.setBounds(11, 300, 65, 25);
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 12));

		cbxGenero = new JComboBox();
		cbxGenero.setName("cbxGenero");
		cbxGenero.addFocusListener(getControlador());
		cbxGenero.setBounds(144, 302, 171, 22);

		cbxPregunta = new JComboBox();
		cbxPregunta.addItemListener(getControlador());
		cbxPregunta.setName("cbxPregunta");
		cbxPregunta.addFocusListener(getControlador());
		cbxPregunta.setBounds(11, 431, 304, 22);

		lblPreguntaSecreta = new JLabel("Pregunta secreta:*");
		lblPreguntaSecreta.setBounds(11, 399, 304, 21);
		lblPreguntaSecreta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPreguntaSecreta.setFont(new Font("Tahoma", Font.PLAIN, 12));

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(getControlador());
		btnGuardar.setBounds(11, 556, 89, 23);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(getControlador());
		btnCancelar.setBounds(226, 556, 89, 23);

		lblProvincia = new JLabel("Provincia:*");
		lblProvincia.setBounds(11, 233, 65, 25);
		lblProvincia.setFont(new Font("Tahoma", Font.PLAIN, 12));

		cbxProvincia = new JComboBox();
		cbxProvincia.addItemListener(getControlador());
		cbxProvincia.setName("cbxProvincia");
		cbxProvincia.addFocusListener(getControlador());
		cbxProvincia.setBounds(144, 235, 171, 22);

		lblLocalidad = new JLabel("Localidad:*");
		lblLocalidad.setBounds(11, 269, 65, 25);
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 12));

		cbxLocalidad = new JComboBox();
		cbxLocalidad.setEnabled(false);
		cbxLocalidad.setName("cbxLocalidad");
		cbxLocalidad.addFocusListener(getControlador());
		cbxLocalidad.setBounds(144, 269, 171, 22);

		txtRespuesta = new JTextField();
		txtRespuesta.setEditable(false);
		txtRespuesta.setName("txtRespuesta");
		txtRespuesta.addFocusListener(getControlador());
		txtRespuesta.addKeyListener(getControlador());
		txtRespuesta.setBounds(11, 473, 304, 20);
		txtRespuesta.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblAgregarUsuario);
		contentPane.add(lblNombre);
		contentPane.add(lblApellido);
		contentPane.add(lblDni);
		contentPane.add(lblTipoUsuario);
		contentPane.add(cbxTipoUsuario);
		contentPane.add(lblTelefono);
		contentPane.add(lblContrasenia);
		contentPane.add(txtTelefono);
		contentPane.add(txtDni);
		contentPane.add(txtApellido);
		contentPane.add(txtNombre);
		contentPane.add(txtContrasenia);
		contentPane.add(lblConfirmarContrasenia);
		contentPane.add(txtConfirmarContrasenia);
		contentPane.add(lblGenero);
		contentPane.add(cbxGenero);
		contentPane.add(cbxPregunta);
		contentPane.add(lblPreguntaSecreta);
		contentPane.add(btnGuardar);
		contentPane.add(btnCancelar);
		contentPane.add(lblProvincia);
		contentPane.add(cbxProvincia);
		contentPane.add(lblLocalidad);
		contentPane.add(cbxLocalidad);
		contentPane.add(txtRespuesta);

		lblError = new JLabel("Los campos con un * son obligatorios");
		lblError.setVisible(false);
		lblError.setForeground(Color.RED);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(11, 504, 304, 14);
		contentPane.add(lblError);

		lblError2 = new JLabel("Error2");
		lblError2.setVisible(false);
		lblError2.setHorizontalAlignment(SwingConstants.CENTER);
		lblError2.setBounds(11, 529, 303, 14);
		contentPane.add(lblError2);
	}

	public JComboBox getCbxTipoUsuario() {
		return cbxTipoUsuario;
	}

	public void setCbxTipoUsuario(JComboBox cbxTipoUsuario) {
		this.cbxTipoUsuario = cbxTipoUsuario;
	}

	public JLabel getLblAgregarUsuario() {
		return lblAgregarUsuario;
	}

	public void setLblAgregarUsuario(JLabel lblAgregarUsuario) {
		this.lblAgregarUsuario = lblAgregarUsuario;
	}

	public ControladorPadre getControlador() {
		return controlador;
	}

	public void setControlador(ControladorPadre controlador) {
		this.controlador = controlador;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public void setTxtTelefono(JTextField txtTelefono) {
		this.txtTelefono = txtTelefono;
	}

	public JTextField getTxtDni() {
		return txtDni;
	}

	public void setTxtDni(JTextField txtDni) {
		this.txtDni = txtDni;
	}

	public JTextField getTxtApellido() {
		return txtApellido;
	}

	public void setTxtApellido(JTextField txtApellido) {
		this.txtApellido = txtApellido;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JPasswordField getTxtContrasenia() {
		return txtContrasenia;
	}

	public void setTxtContrasenia(JPasswordField txtContrasenia) {
		this.txtContrasenia = txtContrasenia;
	}

	public JPasswordField getTxtConfirmarContrasenia() {
		return txtConfirmarContrasenia;
	}

	public void setTxtConfirmarContrasenia(JPasswordField txtConfirmarContrasenia) {
		this.txtConfirmarContrasenia = txtConfirmarContrasenia;
	}

	public JLabel getLblGenero() {
		return lblGenero;
	}

	public void setLblGenero(JLabel lblGenero) {
		this.lblGenero = lblGenero;
	}

	public JComboBox getCbxProvincia() {
		return cbxProvincia;
	}

	public void setCbxProvincia(JComboBox cbxProvincia) {
		this.cbxProvincia = cbxProvincia;
	}

	public JComboBox getCbxLocalidad() {
		return cbxLocalidad;
	}

	public void setCbxLocalidad(JComboBox cbxLocalidad) {
		this.cbxLocalidad = cbxLocalidad;
	}

	public JComboBox getCbxGenero() {
		return cbxGenero;
	}

	public void setCbxGenero(JComboBox cbxGenero) {
		this.cbxGenero = cbxGenero;
	}

	public JComboBox getCbxPregunta() {
		return cbxPregunta;
	}

	public void setCbxPregunta(JComboBox cbxPregunta) {
		this.cbxPregunta = cbxPregunta;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JTextField getTxtRespuesta() {
		return txtRespuesta;
	}

	public void setTxtRespuesta(JTextField txtRespuesta) {
		this.txtRespuesta = txtRespuesta;
	}

	public JLabel getLblError() {
		return lblError;
	}

	public void setLblError(JLabel lblError) {
		this.lblError = lblError;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblApellido() {
		return lblApellido;
	}

	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

	public JLabel getLblDni() {
		return lblDni;
	}

	public void setLblDni(JLabel lblDni) {
		this.lblDni = lblDni;
	}

	public JLabel getLblTipoUsuario() {
		return lblTipoUsuario;
	}

	public void setLblTipoUsuario(JLabel lblTipoUsuario) {
		this.lblTipoUsuario = lblTipoUsuario;
	}

	public JLabel getLblTelefono() {
		return lblTelefono;
	}

	public void setLblTelefono(JLabel lblTelefono) {
		this.lblTelefono = lblTelefono;
	}

	public JLabel getLblProvincia() {
		return lblProvincia;
	}

	public void setLblProvincia(JLabel lblProvincia) {
		this.lblProvincia = lblProvincia;
	}

	public JLabel getLblLocalidad() {
		return lblLocalidad;
	}

	public void setLblLocalidad(JLabel lblLocalidad) {
		this.lblLocalidad = lblLocalidad;
	}

	public JLabel getLblPreguntaSecreta() {
		return lblPreguntaSecreta;
	}

	public void setLblPreguntaSecreta(JLabel lblPreguntaSecreta) {
		this.lblPreguntaSecreta = lblPreguntaSecreta;
	}

	public JLabel getLblContrasenia() {
		return lblContrasenia;
	}

	public void setLblContrasenia(JLabel lblContrasenia) {
		this.lblContrasenia = lblContrasenia;
	}

	public JLabel getLblConfirmarContrasenia() {
		return lblConfirmarContrasenia;
	}

	public void setLblConfirmarContrasenia(JLabel lblConfirmarContrasenia) {
		this.lblConfirmarContrasenia = lblConfirmarContrasenia;
	}

	public JLabel getLblError2() {
		return lblError2;
	}

	public void setLblError2(JLabel lblError2) {
		this.lblError2 = lblError2;
	}
}
