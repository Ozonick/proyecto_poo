package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class VistaHorario extends JFrame {

	private JPanel contentPane;
	private JTable tableHorario;
	private JButton btnModificar;
	private JButton btnBorrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaHorario frame = new VistaHorario();
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
	public VistaHorario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 402, 261);
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
		
		JButton btnNewButton = new JButton("Nuevo");
		btnNewButton.setBounds(422, 49, 89, 23);
		contentPane.add(btnNewButton);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(422, 83, 89, 23);
		contentPane.add(btnModificar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(422, 117, 89, 23);
		contentPane.add(btnBorrar);
	}
}
