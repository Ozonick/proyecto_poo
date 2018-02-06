package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controlador.ControladorPadre;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JLabel;
import javax.swing.JSpinner;

public class VistaHorario extends JFrame {

	private JPanel contentPane;
	private JTable tableHorario;
	private JButton btnGuardar;
	private JButton btnQuitar;
	private ControladorPadre controlador;
	private JButton btnAgregar;
	private JTextField txtLugar;
	private JButton btnCancelar;
	private JComboBox cbxDiaSemana;
	private JSpinner spHoraInicio;
	private JSpinner spHoraFin;
	private JLabel lblDia;
	private JLabel lblHorarioDeInicio;
	private JLabel lblHoraDeFinalizacin;
	private JLabel lblLugarDeLa;
	private JScrollPane scrollPane;

	/**
	 * Create the frame.
	 */
	public VistaHorario(ControladorPadre controlador) {
		this.setControlador(controlador);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 501, 183);
		contentPane.add(scrollPane);
		
		tableHorario = new JTable();
		tableHorario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"D\u00EDa", "Hora de Inicio", "Horario de Finalizaci\u00F3n", "Lugar"
			}
		));
		tableHorario.getColumnModel().getColumn(1).setPreferredWidth(114);
		tableHorario.getColumnModel().getColumn(2).setPreferredWidth(126);
		scrollPane.setViewportView(tableHorario);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(308, 35, 89, 23);
		btnAgregar.addActionListener(getControlador());
		contentPane.add(btnAgregar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(308, 10, 89, 23);
		btnGuardar.addActionListener(getControlador());
		contentPane.add(btnGuardar);
		
		btnQuitar = new JButton("Quitar");
		btnQuitar.setBounds(407, 35, 89, 23);
		btnQuitar.addActionListener(getControlador());
		contentPane.add(btnQuitar);
		
		cbxDiaSemana = new JComboBox();
		cbxDiaSemana.setName("cbxDiaSemana");
		cbxDiaSemana.addFocusListener(getControlador());
		cbxDiaSemana.setModel(new DefaultComboBoxModel(new String[] {"Lunes", "Martes", "M\u00EDercoles", "Jueves", "Viernes", "Sabado", "Domingo"}));
		cbxDiaSemana.setBounds(150, 11, 138, 20);
		contentPane.add(cbxDiaSemana);
		
		lblDia = new JLabel("D\u00EDa de la semana:");
		lblDia.setBounds(10, 14, 130, 14);
		contentPane.add(lblDia);
		
		lblHorarioDeInicio = new JLabel("Horario de inicio:");
		lblHorarioDeInicio.setBounds(10, 39, 130, 14);
		contentPane.add(lblHorarioDeInicio);
		
		lblHoraDeFinalizacin = new JLabel("Hora de finalizaci\u00F3n");
		lblHoraDeFinalizacin.setBounds(10, 64, 130, 14);
		contentPane.add(lblHoraDeFinalizacin);
		
		lblLugarDeLa = new JLabel("Lugar de la actividad:");
		lblLugarDeLa.setBounds(10, 87, 130, 14);
		contentPane.add(lblLugarDeLa);
		
		txtLugar = new JTextField();
		txtLugar.setName("txtLugar");
		txtLugar.setBounds(150, 84, 138, 20);
		contentPane.add(txtLugar);
		txtLugar.setColumns(10);
		txtLugar.addFocusListener(getControlador());
		Date date = new Date();
		SpinnerDateModel spinnerModelInicio = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		spHoraInicio = new JSpinner(spinnerModelInicio);
		spHoraInicio.setName("spHoraInicio");
		JSpinner.DateEditor txtHoraInicio = (JSpinner.DateEditor) spHoraInicio.getEditor();
		txtHoraInicio.getTextField().addFocusListener(getControlador());
		spHoraInicio.setBounds(150, 36, 138, 20);
		JSpinner.DateEditor de_spHoraInicio = new JSpinner.DateEditor(spHoraInicio, "HH:mm");
		spHoraInicio.setEditor(de_spHoraInicio);
		contentPane.add(spHoraInicio);
		
		SpinnerDateModel spinnerModelFin = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
		spHoraFin = new JSpinner(spinnerModelFin);
		spHoraFin.setName("spHoraFin");
		spHoraFin.addFocusListener(getControlador());
		spHoraFin.setBounds(150, 61, 138, 20);
		JSpinner.DateEditor de_spHoraFin = new JSpinner.DateEditor(spHoraFin, "HH:mm");
		spHoraFin.setEditor(de_spHoraFin);
		contentPane.add(spHoraFin);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(407, 10, 89, 23);
		btnCancelar.addActionListener(getControlador());
		contentPane.add(btnCancelar);
	}

	public JTable getTableHorario() {
		return tableHorario;
	}

	public void setTableHorario(JTable tableHorario) {
		this.tableHorario = tableHorario;
	}

	public JButton getBtnModificar() {
		return btnGuardar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnGuardar = btnModificar;
	}

	public JButton getBtnBorrar() {
		return btnQuitar;
	}

	public void setBtnBorrar(JButton btnBorrar) {
		this.btnQuitar = btnBorrar;
	}

	public ControladorPadre getControlador() {
		return controlador;
	}

	public void setControlador(ControladorPadre controlador) {
		this.controlador = controlador;
	}

	public JButton getBtnNuevo() {
		return btnAgregar;
	}

	public void setBtnNuevo(JButton btnNuevo) {
		this.btnAgregar = btnNuevo;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnQuitar() {
		return btnQuitar;
	}

	public void setBtnQuitar(JButton btnQuitar) {
		this.btnQuitar = btnQuitar;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public JTextField getTxtLugar() {
		return txtLugar;
	}

	public void setTxtLugar(JTextField txtLugar) {
		this.txtLugar = txtLugar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JComboBox getCbxDiaSemana() {
		return cbxDiaSemana;
	}

	public void setCbxDiaSemana(JComboBox cbxDiaSemana) {
		this.cbxDiaSemana = cbxDiaSemana;
	}

	public JSpinner getSpHoraInicio() {
		return spHoraInicio;
	}

	public void setSpHoraInicio(JSpinner spHoraInicio) {
		this.spHoraInicio = spHoraInicio;
	}

	public JSpinner getSpHoraFin() {
		return spHoraFin;
	}

	public void setSpHoraFin(JSpinner spHoraFin) {
		this.spHoraFin = spHoraFin;
	}

	public JLabel getLblDia() {
		return lblDia;
	}

	public void setLblDia(JLabel lblDia) {
		this.lblDia = lblDia;
	}

	public JLabel getLblHorarioDeInicio() {
		return lblHorarioDeInicio;
	}

	public void setLblHorarioDeInicio(JLabel lblHorarioDeInicio) {
		this.lblHorarioDeInicio = lblHorarioDeInicio;
	}

	public JLabel getLblHoraDeFinalizacin() {
		return lblHoraDeFinalizacin;
	}

	public void setLblHoraDeFinalizacin(JLabel lblHoraDeFinalizacin) {
		this.lblHoraDeFinalizacin = lblHoraDeFinalizacin;
	}

	public JLabel getLblLugarDeLa() {
		return lblLugarDeLa;
	}

	public void setLblLugarDeLa(JLabel lblLugarDeLa) {
		this.lblLugarDeLa = lblLugarDeLa;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
}
