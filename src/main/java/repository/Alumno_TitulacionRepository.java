package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractConnection;
import connection.H2Connection;
import model.Alumno_Titulacion;

public class Alumno_TitulacionRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT from './src/main/resources/scripts/create.sql'";
	AbstractConnection manager = new H2Connection();
	 

	public void insert(Alumno_Titulacion alumno_tit) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("INSERT INTO Alumno_Titulacion (id_materia, id_alumno) VALUES (?, ?)");
			preparedStatement.setInt(1, alumno_tit.getId_titulacion());
			preparedStatement.setInt(2, alumno_tit.getId_alumno());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}

	}

	public List<Alumno_Titulacion> listAll() {
		List<Alumno_Titulacion> lista = new ArrayList<>();
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("SELECT * FROM Alumno_Titulacion ");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Alumno_Titulacion alumno_tit = new Alumno_Titulacion();
				alumno_tit.setId_alumno(resultSet.getInt("id_alumno"));
				alumno_tit.setId_titulacion(resultSet.getInt("id_materia"));

				
				lista.add(alumno_tit);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return lista;
	}

/*
	public void delete(int id) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("DELETE FROM Alumno WHERE id = ?");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
*/
	
}
