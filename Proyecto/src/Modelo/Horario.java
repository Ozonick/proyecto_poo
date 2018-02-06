package Modelo;

import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

public class Horario {
private ArrayList<String> lugarDeLaActividad, diaDeSemana;
private ArrayList<LocalTime> horaInicio, horaFinal;
private BaseDeDatos baseDeDatos;
 public Horario() {
	 this.setDiaDeSemana(new ArrayList<String>());
	 this.setHoraInicio(new ArrayList<LocalTime>());
	 this.setHoraFinal(new ArrayList<LocalTime>());
	 this.setLugarDeLaActividad(new ArrayList<String>());
	 try {
			this.setBaseDeDatos(BaseDeDatos.getInstance());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
public BaseDeDatos getBaseDeDatos() {
	return baseDeDatos;
}
public void setBaseDeDatos(BaseDeDatos baseDeDatos) {
	this.baseDeDatos = baseDeDatos;
}

public ArrayList<String> getLugarDeLaActividad() {
	return lugarDeLaActividad;
}

public void setLugarDeLaActividad(ArrayList<String> lugarDeLaActividad) {
	this.lugarDeLaActividad = lugarDeLaActividad;
}

public ArrayList<String> getDiaDeSemana() {
	return diaDeSemana;
}

public void setDiaDeSemana(ArrayList<String> diaDeSemana) {
	this.diaDeSemana = diaDeSemana;
}

public ArrayList<LocalTime> getHoraInicio() {
	return horaInicio;
}

public void setHoraInicio(ArrayList<LocalTime> horaInicio) {
	this.horaInicio = horaInicio;
}

public ArrayList<LocalTime> getHoraFinal() {
	return horaFinal;
}

public void setHoraFinal(ArrayList<LocalTime> horaFinal) {
	this.horaFinal = horaFinal;
}
 
}
