package Modelo;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDeDatos {
	private static BaseDeDatos instance;
	private java.sql.Connection connection;
	private String url = "jdbc:postgresql://localhost:5432/sistema_cursos";
	private String username = "postgres";
	private String password = "2595";

	private BaseDeDatos() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			this.connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static BaseDeDatos getInstance() throws SQLException {
		if (instance == null) {
			instance = new BaseDeDatos();
		} else if (instance.getConnection().isClosed()) {
			instance = new BaseDeDatos();
		}
		return instance;
	}
	public ResultSet buscarEntidad(String consulta) {
		ResultSet rs = null;
        try
        {
            // Se crea un Statement, para realizar la consulta
            Statement s = connection.createStatement();

            // Se realiza la consulta. Los resultados se guardan en el
            // ResultSet rs
            rs = s.executeQuery(consulta);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return rs;
	}
	public ResultSet consultar(String consulta) throws SQLException {
		return this.getConnection().prepareStatement(consulta).executeQuery();
	}


	public int insertar(String consulta) {
		try {
			return this.getConnection().createStatement().executeUpdate(consulta);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

	public java.sql.Connection getConnection() {
		return connection;
	}

}
