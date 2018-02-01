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
import javax.swing.JLabel;
import java.awt.Font;

public class VistaSecretaria extends JFrame {

	private JPanel contentPane;
	private JTable tablaCurso;
	private JTextField txtBuscador;
	private JTable tablaAlumno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaSecretaria frame = new VistaSecretaria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VistaSecretaria() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 44, 664, 254);
		
		JPanel panelUsuario = new JPanel();
		tabbedPane.addTab("Lista de cursos", null, panelUsuario, null);
		panelUsuario.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 651, 226);
		panelUsuario.add(scrollPane);
		
		tablaCurso = new JTable();
		tablaCurso.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Inicio", "Finalizacion", "Lugar", "Profesor", "Horario Desde", "Horario Hasta", "Cupos Disponibles"
			}
		));
		tablaCurso.getColumnModel().getColumn(0).setPreferredWidth(67);
		tablaCurso.getColumnModel().getColumn(5).setPreferredWidth(91);
		tablaCurso.getColumnModel().getColumn(6).setPreferredWidth(88);
		tablaCurso.getColumnModel().getColumn(7).setPreferredWidth(110);
		scrollPane.setViewportView(tablaCurso);
		
		JPanel panelCursos = new JPanel();
		tabbedPane.addTab("Lista de Alumnos", null, panelCursos, null);
		panelCursos.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 649, 224);
		panelCursos.add(scrollPane_1);
		
		tablaAlumno = new JTable();
		tablaAlumno.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Dni", "Tipo_usuario", "Telefono"
			}
		));
		scrollPane_1.setViewportView(tablaAlumno);
		contentPane.setLayout(null);
		contentPane.add(tabbedPane);
		
		JLabel lblBuscador = new JLabel("Buscar:");
		lblBuscador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBuscador.setBounds(5, 11, 82, 22);
		contentPane.add(lblBuscador);
		
		txtBuscador = new JTextField();
		txtBuscador.setBounds(56, 8, 576, 25);
		contentPane.add(txtBuscador);
		txtBuscador.setColumns(10);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(15, 295, 105, 38);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(499, 295, 105, 38);
		contentPane.add(btnModificar);
	}
}
