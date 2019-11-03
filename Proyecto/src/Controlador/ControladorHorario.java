package Controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelo.Curso;
import Modelo.Horario;
import Vista.VistaHorario;

public class ControladorHorario extends ControladorPadre {
	private static ControladorHorario instance;
	private Horario horario;
	private Curso curso;
	private Boolean[] bandera;
	private Boolean guardado; 
	public ControladorHorario(Curso curso) {
		super.setVistaHorario(new VistaHorario(this));
		this.setHorario(new Horario());
		this.setCurso(curso);
		this.setBandera(new Boolean[4]);
		super.inicializadorDeBandera(this.getBandera());
		this.setGuardado(false);
	}
	
	public static ControladorHorario getInstance(Curso curso) {
		if (instance == null) {
			instance = new ControladorHorario(curso);
		}
		return instance;
	}
	 @Override
	public void focusLost(FocusEvent arg0) {
		 this.getBandera()[1] = true;
		 this.getBandera()[2] = true;
		 //System.out.println(arg0.getComponent().getName());
		 //System.out.println(this.getVistaHorario().getSpHoraInicio().getValue().toString().split(" ")[3].split(":")[0] + this.getVistaHorario().getSpHoraFin().getValue().toString().split(" ")[3].split(":")[0]);
			switch (arg0.getComponent().getName()) {
			case "cbxDiaSemana":
				this.getBandera()[0] = true;
				break;
			case "spHoraInicio":
				if (Integer.parseInt(this.getVistaHorario().getSpHoraInicio().getValue().toString().split(" ")[3].split(":")[0]) > Integer.parseInt(this.getVistaHorario().getSpHoraFin().getValue().toString().split(" ")[3].split(":")[0])) {
					System.out.println("asd");
				}
				break;
			case "spHoraFin":
				
				break;
			case "txtLugar":
				if (getVistaHorario().getTxtLugar().getText().isEmpty()) {
					getVistaHorario().getLblLugarDeLa().setForeground(Color.RED);
				}else {
					this.getBandera()[3] = true;
				}
				
				break;

			default:
				break;
			}
		}
	 @Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		super.itemStateChanged(arg0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getVistaHorario().getBtnGuardar()) && this.getGuardado()) {
			this.getCurso().setHorario(this.getHorario());
			JOptionPane.showMessageDialog(super.getVistaHorario(),"todo oc");
			super.getVistaHorario().dispose();//esto borra memoria?
			super.setVistaHorario(new VistaHorario(this));
		}else if (e.getSource().equals(getVistaHorario().getBtnGuardar())) {
			JOptionPane.showMessageDialog(super.getVistaHorario(),"todo mal");
		}
		if (e.getSource().equals(getVistaHorario().getBtnAgregar())) {
			if (super.revisarbanderas(this.getBandera()) == 4) {
				this.getHorario().getDiaDeSemana().add(super.getVistaHorario().getCbxDiaSemana().getSelectedItem().toString());
				this.getHorario().getHoraInicio().add(LocalTime.of(Integer.parseInt(super.getVistaHorario().getSpHoraInicio().getValue().toString().split(" ")[3].split(":")[0]), Integer.parseInt(super.getVistaHorario().getSpHoraInicio().getValue().toString().split(" ")[3].split(":")[1])));
				this.getHorario().getHoraFinal().add(LocalTime.of(Integer.parseInt(super.getVistaHorario().getSpHoraFin().getValue().toString().split(" ")[3].split(":")[0]), Integer.parseInt(super.getVistaHorario().getSpHoraFin().getValue().toString().split(" ")[3].split(":")[1])));
				this.getHorario().getLugarDeLaActividad().add(super.getVistaHorario().getTxtLugar().getText());
				DefaultTableModel modelo = (DefaultTableModel) super.getVistaHorario().getTableHorario().getModel();
				Object[] row = {super.getVistaHorario().getCbxDiaSemana().getSelectedItem().toString(), LocalTime.of(Integer.parseInt(super.getVistaHorario().getSpHoraInicio().getValue().toString().split(" ")[3].split(":")[0]), Integer.parseInt(super.getVistaHorario().getSpHoraInicio().getValue().toString().split(" ")[3].split(":")[1])),LocalTime.of(Integer.parseInt(super.getVistaHorario().getSpHoraFin().getValue().toString().split(" ")[3].split(":")[0]), Integer.parseInt(super.getVistaHorario().getSpHoraFin().getValue().toString().split(" ")[3].split(":")[1])),super.getVistaHorario().getTxtLugar().getText()};
				modelo.addRow(row);
				super.getVistaHorario().getTableHorario().setModel(modelo);
				this.setGuardado(true);
			}
		}
		if (e.getSource().equals(getVistaHorario().getBtnQuitar())) {
			this.getHorario().getDiaDeSemana().remove(super.getVistaHorario().getTableHorario().getSelectedRow());
			this.getHorario().getHoraInicio().remove(super.getVistaHorario().getTableHorario().getSelectedRow());
			this.getHorario().getHoraFinal().remove(super.getVistaHorario().getTableHorario().getSelectedRow());
			this.getHorario().getLugarDeLaActividad().remove(super.getVistaHorario().getTableHorario().getSelectedRow());
			DefaultTableModel modelo = (DefaultTableModel) super.getVistaHorario().getTableHorario().getModel();
			modelo.removeRow(super.getVistaHorario().getTableHorario().getSelectedRow());
		}
		if (e.getSource().equals(getVistaHorario().getBtnCancelar())) {
			super.getVistaHorario().dispose();//esto borra memoria?
			super.setVistaHorario(new VistaHorario(this));
		}
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Boolean[] getBandera() {
		return bandera;
	}

	public void setBandera(Boolean[] bandera) {
		this.bandera = bandera;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Boolean getGuardado() {
		return guardado;
	}

	public void setGuardado(Boolean guardado) {
		this.guardado = guardado;
	}
}
