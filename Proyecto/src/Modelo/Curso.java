package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Curso {
private String nombre,profesor;
private Integer limiteDeCupos;
private Date inicio,finalizacion;
private Horario horario;
private BaseDeDatos baseDeDatos;

public Curso() {
	// TODO Auto-generated constructor stub
	try {
		this.setBaseDeDatos(BaseDeDatos.getInstance());
	} catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}

public String[] consulColumna() {
	ResultSet rs = this.getBaseDeDatos().buscarEntidad("SELECT nombre, apellido FROM usuario where tipo_usuario = '3'");
	try {
		ArrayList<String> str = new ArrayList<String>();
		Integer i = 0;
		while (rs.next()) {
			str.add(rs.getString(1) + " " + rs.getString(2));
			i++;
		}
		String[] str2 = new String[i + 1];
		for (int j = 1; j < str2.length; j++) {
			str2[j] = str.remove(0);
		}
		return str2;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}

public void crearCurso(Curso curso) {
		this.getBaseDeDatos().insertar("INSERT INTO public.curso(nombre_curso, inicio_curso, finalizacion_curso, profesor, limite_cupos)VALUES ('" + curso.nombre + "', '" + curso.inicio + "', '" + curso.finalizacion +"', '" + curso.profesor + "', " + curso.limiteDeCupos + ");");
	for (int i = 0; i < curso.horario.getDiaDeSemana().size(); i++) {
			this.getBaseDeDatos().insertar("INSERT INTO public.horario(dia_horario, horario_inicio, horario_fin, lugar, curso_horario) VALUES ('" + curso.horario.getDiaDeSemana().get(i) + "', '" + curso.horario.getHoraInicio().get(i) + "', '" + curso.horario.getHoraFinal().get(i) + "', '" + curso.horario.getLugarDeLaActividad().get(i) + "', (select id_curso from curso where nombre_curso = '" + curso.nombre + "'));");
	}
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getProfesor() {
	return profesor;
}
public void setProfesor(String profesor) {
	this.profesor = profesor;
}
public Integer getLimiteDeCupos() {
	return limiteDeCupos;
}
public void setLimiteDeCupos(Integer limiteDeCupos) {
	this.limiteDeCupos = limiteDeCupos;
}







public BaseDeDatos getBaseDeDatos() {
	return baseDeDatos;
}







public void setBaseDeDatos(BaseDeDatos baseDeDatos) {
	this.baseDeDatos = baseDeDatos;
}

public Horario getHorario() {
	return horario;
}

public void setHorario(Horario horario) {
	this.horario = horario;
}

public Date getInicio() {
	return inicio;
}

public void setInicio(Date inicio) {
	this.inicio = inicio;
}

public Date getFinalizacion() {
	return finalizacion;
}

public void setFinalizacion(Date finalizacion) {
	this.finalizacion = finalizacion;
}

}
