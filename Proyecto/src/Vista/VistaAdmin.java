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
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VistaAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscador;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAdmin frame = new VistaAdmin();
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
	public VistaAdmin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 373);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnGestion = new JMenu("Gestion");
		menuBar.add(mnGestion);
		
		JMenuItem mntmUsuarios = new JMenuItem("Usuarios");
		mnGestion.add(mntmUsuarios);
		
		JMenuItem mntmCursos = new JMenuItem("Cursos");
		mnGestion.add(mntmCursos);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnGestion.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnAgregar = new JButton("Nuevo");
		btnAgregar.setBounds(5, 274, 105, 38);
		
		JButton btnDesactivar = new JButton("Desactivar");
		btnDesactivar.setToolTipText("");
		btnDesactivar.setBounds(257, 276, 105, 35);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(527, 274, 105, 38);
		contentPane.setLayout(null);
		contentPane.add(btnAgregar);
		contentPane.add(btnDesactivar);
		contentPane.add(btnModificar);
		
		JLabel lblBuscador = new JLabel("Buscar:");
		lblBuscador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBuscador.setBounds(5, 8, 55, 22);
		contentPane.add(lblBuscador);
		
		txtBuscador = new JTextField();
		txtBuscador.setBounds(70, 8, 562, 22);
		contentPane.add(txtBuscador);
		txtBuscador.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 44, 627, 219);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
