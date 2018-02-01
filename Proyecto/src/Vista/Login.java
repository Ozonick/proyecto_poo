package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.ControladorPadre;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Login extends JFrame {
	private JButton btnIniciarSesion;
	private ControladorPadre controlador;

	/**
	 * Create the frame.
	 * @param controlador 
	 */
	
	public Login(ControladorPadre controlador) {
		this.setControlador(controlador);
		setTitle("Sistema de Cursos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 398, 281);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIniciarSesion = new JLabel("Iniciar Sesión");
		lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		lblIniciarSesion.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblIniciarSesion.setBounds(10, 11, 372, 56);
		contentPane.add(lblIniciarSesion);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(75, 72, 58, 30);
		contentPane.add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContraseña.setBounds(57, 113, 80, 27);
		contentPane.add(lblContraseña);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(143, 117, 160, 20);
		contentPane.add(passwordField);
		
		JTextField txtUsuario = new JTextField();
		txtUsuario.setBounds(143, 78, 160, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setToolTipText("");
		
		btnIniciarSesion.setBounds(143, 148, 119, 30);
		contentPane.add(btnIniciarSesion);
		
		JLabel lblContrseaIncorrecta = new JLabel("Contrse\u00F1a o Usuario incorrecta");
		lblContrseaIncorrecta.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrseaIncorrecta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblContrseaIncorrecta.setForeground(Color.RED);
		lblContrseaIncorrecta.setBounds(10, 189, 372, 14);
		contentPane.add(lblContrseaIncorrecta);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(196, 214, 89, 23);
		contentPane.add(btnNewButton);
	}


	public JButton getBtnIniciarSesion() {
		return btnIniciarSesion;
	}

	public void setBtnIniciarSesion(JButton btnIniciarSesion) {
		this.btnIniciarSesion = btnIniciarSesion;
	}


	public ControladorPadre getControlador() {
		return controlador;
	}


	public void setControlador(ControladorPadre controlador) {
		this.controlador = controlador;
	}
}




