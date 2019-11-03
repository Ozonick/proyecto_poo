package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Controlador.ControladorPadre;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VistaAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscador;
	private JTable tableAdmin;
	private ControladorPadre controladorPadre;
	private JMenuItem mntmUsuarios;
	private JMenuItem mntmCursos;
	private JMenuItem mntmSalir;
	private JButton btnAgregar;
	private JButton btnDesactivar;
	private JButton btnModificar;
	private JScrollPane scrollPane;
	private JLabel lblBuscador;

	/**
	 * Create the frame.
	 */
	public VistaAdmin(ControladorPadre controlador) {
		this.setControladorPadre(controlador);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 373);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnGestion = new JMenu("Gestion");
		menuBar.add(mnGestion);
		
		mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.setName("mntmUsuarios");
		mntmUsuarios.addActionListener(getControladorPadre());
		mnGestion.add(mntmUsuarios);
		
		mntmCursos = new JMenuItem("Cursos");
		mntmCursos.addActionListener(getControladorPadre());
		mnGestion.add(mntmCursos);
		
		mntmSalir = new JMenuItem("Salir");
		mnGestion.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(5, 274, 105, 38);
		
		btnDesactivar = new JButton("Desactivar");
		btnDesactivar.setToolTipText("");
		btnDesactivar.setBounds(257, 276, 105, 35);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(527, 274, 105, 38);
		contentPane.setLayout(null);
		contentPane.add(btnAgregar);
		contentPane.add(btnDesactivar);
		contentPane.add(btnModificar);
		
		lblBuscador = new JLabel("Buscar:");
		lblBuscador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBuscador.setBounds(5, 8, 55, 22);
		contentPane.add(lblBuscador);
		
		txtBuscador = new JTextField();
		txtBuscador.setBounds(70, 8, 562, 22);
		contentPane.add(txtBuscador);
		txtBuscador.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 44, 627, 219);
		contentPane.add(scrollPane);
		
		tableAdmin = new JTable();
		scrollPane.setViewportView(tableAdmin);
	}

	public JTextField getTxtBuscador() {
		return txtBuscador;
	}

	public void setTxtBuscador(JTextField txtBuscador) {
		this.txtBuscador = txtBuscador;
	}

	public JTable getTable() {
		return tableAdmin;
	}

	public void setTable(JTable table) {
		this.tableAdmin = table;
	}

	public ControladorPadre getControladorPadre() {
		return controladorPadre;
	}

	public void setControladorPadre(ControladorPadre controladorPadre) {
		this.controladorPadre = controladorPadre;
	}
	public JTable getTableAdmin() {
		return tableAdmin;
	}

	public void setTableAdmin(JTable tableAdmin) {
		this.tableAdmin = tableAdmin;
	}

	public JMenuItem getMntmUsuarios() {
		return mntmUsuarios;
	}

	public void setMntmUsuarios(JMenuItem mntmUsuarios) {
		this.mntmUsuarios = mntmUsuarios;
	}

	public JMenuItem getMntmCursos() {
		return mntmCursos;
	}

	public void setMntmCursos(JMenuItem mntmCursos) {
		this.mntmCursos = mntmCursos;
	}

	public JMenuItem getMntmSalir() {
		return mntmSalir;
	}

	public void setMntmSalir(JMenuItem mntmSalir) {
		this.mntmSalir = mntmSalir;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}

	public JButton getBtnDesactivar() {
		return btnDesactivar;
	}

	public void setBtnDesactivar(JButton btnDesactivar) {
		this.btnDesactivar = btnDesactivar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JLabel getLblBuscador() {
		return lblBuscador;
	}

	public void setLblBuscador(JLabel lblBuscador) {
		this.lblBuscador = lblBuscador;
	}
}
