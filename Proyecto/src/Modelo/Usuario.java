package Modelo;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Usuario {
private String nombre,apellido,tipo,localidad,genero,contrasenia,respuesta,pregunta;
private Integer DNI,telefono;
private BaseDeDatos baseDeDatos;
public Usuario() {
	try {
		this.setBaseDeDatos(BaseDeDatos.getInstance());
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public String[] consulColumna(String columna, String tabla) {
	ResultSet rs = this.getBaseDeDatos().buscarEntidad("select " + columna + " from " + tabla);
	try {
		ArrayList<String> str = new ArrayList<String>();
		Integer i = 0;
		while (rs.next()) {
			str.add(rs.getString(1));
			i++;
		}
		String[] str2 = new String[i+1];
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
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public Integer getDNI() {
	return DNI;
}
public void setDNI(Integer dNI) {
	DNI = dNI;
}
public Integer getTelefono() {
	return telefono;
}
public void setTelefono(Integer telefono) {
	this.telefono = telefono;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getLocalidad() {
	return localidad;
}
public void setLocalidad(String localidad) {
	this.localidad = localidad;
}
public String getGenero() {
	return genero;
}
public void setGenero(String genero) {
	this.genero = genero;
}
public String getContrasenia() {
	return contrasenia;
}
public void setContrasenia(String contrasenia) {
	this.contrasenia = contrasenia;
}
public String getRespuesta() {
	return respuesta;
}
public void setRespuesta(String respuesta) {
	this.respuesta = respuesta;
}
public String getPregunta() {
	return pregunta;
}
public void setPregunta(String pregunta) {
	this.pregunta = pregunta;
}
public BaseDeDatos getBaseDeDatos() {
	return baseDeDatos;
}
public void setBaseDeDatos(BaseDeDatos baseDeDatos) {
	this.baseDeDatos = baseDeDatos;
}


}
