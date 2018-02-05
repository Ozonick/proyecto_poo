package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

public class Curso {
private String nombre,profesor;
private Integer limiteDeCupos;
private Calendar inicio,finalizacion;
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

public String[] consulColumna(String usuario) {
	ResultSet rs = this.getBaseDeDatos().buscarEntidad("SELECT nombre, apellido FROM "+usuario+" where tipo_usuario = '3'");
	try {
		ArrayList<String> str = new ArrayList<String>();
		Integer i = 0;
		while (rs.next()) {
			str.add(rs.getString(1));
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
public Calendar getInicio() {
	return inicio;
}
public void setInicio(Calendar inicio) {
	this.inicio = inicio;
}
public Calendar getFinalizacion() {
	return finalizacion;
}
public void setFinalizacion(Calendar finalizacion) {
	this.finalizacion = finalizacion;
}







public BaseDeDatos getBaseDeDatos() {
	return baseDeDatos;
}







public void setBaseDeDatos(BaseDeDatos baseDeDatos) {
	this.baseDeDatos = baseDeDatos;
}

}
