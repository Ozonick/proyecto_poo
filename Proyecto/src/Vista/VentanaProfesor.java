package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

public class VentanaProfesor extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProfesor frame = new VentanaProfesor();
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
	public VentanaProfesor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCurso.setBounds(10, 11, 66, 24);
		contentPane.add(lblCurso);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(86, 14, 220, 21);
		contentPane.add(comboBox);
		
		JLabel lblListadoDeAlumnos = new JLabel("Listado de alumnos:");
		lblListadoDeAlumnos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblListadoDeAlumnos.setBounds(10, 46, 139, 24);
		contentPane.add(lblListadoDeAlumnos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 517, 233);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Apellido", "Dni", "Tipo_usuario", "Telefono", "Nota"
			}
		));
		scrollPane.setViewportView(table);
	}

}
