package co.edu.uco.nose.data.dao.entity;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;

import java.sql.Connection;

public abstract class SqlConneection {
	
	private Connection connection;
	
	protected SqlConnection() {
		setConnection(connection);
		
	}

	protected Connection getConnection() {
		return connection;
	}

	protected void setConnection(final Connection connection) {
		if (ObjectHelper.IsNull(connection)) {
			var userMessage = "";
			var technicalMessage = "";
			throw NoseException.create(null, null);
		}
		this.connection = connection;
	}

}
