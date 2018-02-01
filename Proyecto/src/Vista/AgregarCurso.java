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
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

public class AgregarCurso extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JSpinner spDesde;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarCurso frame = new AgregarCurso();
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
	public AgregarCurso() {
		setTitle("Cursos");
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
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(106, 100, 174, 20);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 66, 79, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblDesde = new JLabel("Inicio:");
		lblDesde.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDesde.setBounds(10, 100, 79, 20);
		contentPane.add(lblDesde);
		
		JLabel lblHasta = new JLabel("Finalizacion:");
		lblHasta.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHasta.setBounds(10, 131, 79, 20);
		contentPane.add(lblHasta);
		
		JLabel lblProfesores = new JLabel("Profesor:");
		lblProfesores.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProfesores.setBounds(10, 162, 79, 20);
		contentPane.add(lblProfesores);
		
		JLabel lblLimiteDeCupos = new JLabel("Limite de cupos:");
		lblLimiteDeCupos.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLimiteDeCupos.setBounds(10, 193, 110, 20);
		contentPane.add(lblLimiteDeCupos);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(107, 67, 174, 20);
		contentPane.add(textField_2);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(106, 131, 174, 20);
		contentPane.add(dateChooser_1);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(10, 282, 103, 31);
		contentPane.add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(177, 282, 103, 31);
		contentPane.add(btnCancelar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(106, 163, 174, 20);
		contentPane.add(comboBox);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(106, 194, 174, 20);
		contentPane.add(spinner);
		
		JButton btnNewButton_1 = new JButton("Horarios");
		btnNewButton_1.setBounds(10, 224, 270, 23);
		contentPane.add(btnNewButton_1);
		
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
}
