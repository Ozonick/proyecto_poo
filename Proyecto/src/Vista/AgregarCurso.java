package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Calendar;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

import Controlador.ControladorAgregarCurso;
import Controlador.ControladorPadre;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class AgregarCurso extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JLabel lblError;
	private ControladorPadre controlador;
	private JLabel lblNombre;
	private JLabel lblDesde;
	private JLabel lblHasta;
	private JLabel lblProfesores;
	private JLabel lblLimiteDeCupos;
	private JDateChooser dateInicio;
	private JDateChooser dateFinalizacion;
	private JComboBox cbxProfesor;
	private JSpinner spLimiteDeCupos;
	private JButton btnHorarios;
	private JButton btnGuardar ;
	private JButton btnCancelar ;
	
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param controladorAgregarCurso 
	 */
	
	public AgregarCurso(ControladorPadre controlador) {
		setTitle("Cursos");
		this.setControlador(controlador);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCa = new JLabel("Agregar Curso");
		lblCa.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblCa.setBounds(90, 11, 139, 31);
		contentPane.add(lblCa);
		
		dateInicio = new JDateChooser();
		dateInicio.setName("dateInicio");
		dateInicio.addFocusListener(getControlador());
		dateInicio.setBounds(138, 100, 174, 20);
		contentPane.add(dateInicio);
		
		lblNombre = new JLabel("Nombre:*");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(10, 66, 79, 20);
		contentPane.add(lblNombre);
		
		lblDesde = new JLabel("Inicio:*");
		lblDesde.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDesde.setBounds(10, 100, 79, 20);
		contentPane.add(lblDesde);
		
		lblHasta = new JLabel("Finalizacion:*");
		lblHasta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHasta.setBounds(10, 131, 79, 20);
		contentPane.add(lblHasta);
		
		lblProfesores = new JLabel("Profesor:*");
		lblProfesores.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProfesores.setBounds(10, 162, 79, 20);
		contentPane.add(lblProfesores);
		
		lblLimiteDeCupos = new JLabel("Limite de cupos:*");
		lblLimiteDeCupos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLimiteDeCupos.setBounds(10, 193, 110, 20);
		contentPane.add(lblLimiteDeCupos);
		
		txtNombre = new JTextField();
		txtNombre.setName("txtNombre");
		txtNombre.setColumns(10);
		txtNombre.addFocusListener(getControlador());
		txtNombre.setBounds(138, 69, 174, 20);
		contentPane.add(txtNombre);
		
		dateFinalizacion = new JDateChooser();
		dateFinalizacion.addFocusListener(getControlador());
		dateFinalizacion.setName("dateFinalizacion");
		dateFinalizacion.setBounds(138, 131, 174, 20);
		contentPane.add(dateFinalizacion);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(getControlador());
		btnGuardar.setBounds(10, 282, 103, 31);
		contentPane.add(btnGuardar);
		
		btnCancelar  = new JButton("Cancelar");
		btnCancelar .setBounds(177, 282, 103, 31);
		contentPane.add(btnCancelar );
		
		cbxProfesor = new JComboBox();
		cbxProfesor.addItemListener(getControlador());
		cbxProfesor.setName("cbxProfesor");
		cbxProfesor.setModel(new DefaultComboBoxModel(new String[] {"Selecciona un profesor"}));
		cbxProfesor.setToolTipText("");
		cbxProfesor.addFocusListener(getControlador());
		cbxProfesor.setBounds(138, 163, 174, 20);
		contentPane.add(cbxProfesor);
		
		SpinnerNumberModel rangoSpinner = new SpinnerNumberModel();
		rangoSpinner.setMaximum(100);
		rangoSpinner.setMinimum(0);
		spLimiteDeCupos = new JSpinner();
		spLimiteDeCupos.addFocusListener(getControlador());
		spLimiteDeCupos.setName("spLimiteDeCupos");
		spLimiteDeCupos.setBounds(138, 194, 174, 20);
		spLimiteDeCupos.setModel(rangoSpinner);
		contentPane.add(spLimiteDeCupos);
		
		btnHorarios = new JButton("Horarios");
		btnHorarios.addActionListener(getControlador());
		btnHorarios.setBounds(10, 224, 302, 23);
		contentPane.add(btnHorarios);
		
		lblError = new JLabel("Los campos con un * son obligatorios");
		lblError.setVisible(false);
		lblError.setForeground(Color.RED);
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(10, 258, 302, 14);
		contentPane.add(lblError);
		
		/*Date date = new Date();
		  SpinnerDateModel sm = 
		  new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		
		
		
		Date date1 = new Date();
		  SpinnerDateModel sm1 = 
		  new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		
		JSpinner spHasta = new JSpinner(sm1);
		JSpinner.DateEditor de_spHasta = new JSpinner.DateEditor(spHasta, "HH:mm:ss");
		spHasta.setEditor(de_spHasta);
		spHasta.setBounds(106, 259, 174, 20);
		contentPane.add(spHasta);*/
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JLabel getLblError() {
		return lblError;
	}

	public void setLblError(JLabel lblError) {
		this.lblError = lblError;
	}


	public ControladorPadre getControlador() {
		return controlador;
	}

	public void getControlador(ControladorPadre controlador) {
		this.controlador = controlador;
	}

	public JComboBox getCbxProfesor() {
		return cbxProfesor;
	}

	public void setCbxProfesor(JComboBox cbxProfesor) {
		this.cbxProfesor = cbxProfesor;
	}

	public void setControlador(ControladorPadre controlador) {
		this.controlador = controlador;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JSpinner getSpLimiteDeCupos() {
		return spLimiteDeCupos;
	}

	public void setSpLimiteDeCupos(JSpinner spLimiteDeCupos) {
		this.spLimiteDeCupos = spLimiteDeCupos;
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

	public JLabel getLblDesde() {
		return lblDesde;
	}

	public void setLblDesde(JLabel lblDesde) {
		this.lblDesde = lblDesde;
	}

	public JLabel getLblHasta() {
		return lblHasta;
	}

	public void setLblHasta(JLabel lblHasta) {
		this.lblHasta = lblHasta;
	}

	public JLabel getLblProfesores() {
		return lblProfesores;
	}

	public void setLblProfesores(JLabel lblProfesores) {
		this.lblProfesores = lblProfesores;
	}

	public JLabel getLblLimiteDeCupos() {
		return lblLimiteDeCupos;
	}

	public void setLblLimiteDeCupos(JLabel lblLimiteDeCupos) {
		this.lblLimiteDeCupos = lblLimiteDeCupos;
	}

	public JDateChooser getDateInicio() {
		return dateInicio;
	}

	public void setDateInicio(JDateChooser dateInicio) {
		this.dateInicio = dateInicio;
	}

	public JDateChooser getDateFinalizacion() {
		return dateFinalizacion;
	}

	public void setDateFinalizacion(JDateChooser dateFinalizacion) {
		this.dateFinalizacion = dateFinalizacion;
	}

	public JButton getBtnHorarios() {
		return btnHorarios;
	}

	public void setBtnHorarios(JButton btnHorarios) {
		this.btnHorarios = btnHorarios;
	}
}
