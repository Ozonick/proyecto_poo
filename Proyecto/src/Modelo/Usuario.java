package Modelo;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Controlador.ControladorPadre;

public class Usuario {
	private static Usuario instance;
	private String nombre, apellido, tipo, localidad, genero, contrasenia, respuesta, pregunta,provincia;
	private Integer DNI, telefono;
	private BaseDeDatos baseDeDatos;
	
	public static Usuario getInstance() {
		if (instance == null) {
			instance = new Usuario();
		}
		return instance;
	}
	public Usuario() {
		try {
			this.setBaseDeDatos(BaseDeDatos.getInstance());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Boolean iniciarSecion(String usuario, String contrasenia) throws SQLException {
		if (this.getBaseDeDatos().consultar("select usuario.dni, usuario.contrasenia from usuario where usuario.dni = '" + usuario + "' and usuario.contrasenia = '" + contrasenia + "'").next()) {
			return true;
		}
		throw new SQLException();
	}
	public String[] consultaLocalidad(String provincia) {
		ResultSet rs = this.getBaseDeDatos().buscarEntidad(
				"select nombre_localidad from localidad where localidad.provincia = (select id_provincia from provincia where nombre_provincia = '"
						+ provincia + "')");
		try {
			ArrayList<String> str = new ArrayList<String>();
			Integer i = 0;
			while (rs.next()) {
				str.add(rs.getString(1));
				i++;
			}
			String[] str2 = new String[i + 1];
			str2[0] = "Selecciona una localidad";
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

	public String[] consulColumna(String columna, String tabla) {
		String consultas = "select " + columna + " from " + tabla;
		ResultSet rs = this.getBaseDeDatos().buscarEntidad(consultas);
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
	public void guardarUsuario(Usuario user) {
		try {
			this.getBaseDeDatos().getInstance().insertar("INSERT INTO public.usuario(nombre, apellido, dni, tipo_usuario, telefono, localidad, genero, contrasenia, respuesta, pregunta) VALUES ('" + user.nombre + "', '" + user.apellido + "', " + user.DNI + ", (select id_tipo from tipo_usuario where nombre_usuario = '" + user.tipo + "'), " + user.telefono + ", (select id_localidad from localidad where nombre_localidad = '" + user.localidad + "'), (select id_genero from genero where nombre_genero = '" + user.genero + "'), '" + user.contrasenia + "', '" + user.respuesta + "', (select id_pregunta from pregunta where pregunta = '" + user.pregunta + "'))");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}
