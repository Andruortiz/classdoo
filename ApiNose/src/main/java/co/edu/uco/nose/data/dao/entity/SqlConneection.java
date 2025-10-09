package co.edu.uco.nose.data.dao.entity;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;

import java.sql.Connection;

public abstract class SqlConnection {
	
	private Connection connection;
	
	protected SqlConnection() {
		setConnection(connection);
		
	}

	protected Connection getConnection() {
		return connection;
	}

	protected void setConnection(final Connection connection) {
		if (ObjectHelper.IsNull(connection)) {
			var userMessage = "No se ha recibido una conexión válida a la base de datos.";
            var technicalMessage = "La conexión SQL recibida es nula.";
			throw NoseException.create(null, null);
		}
		this.connection = connection;
	}

}
