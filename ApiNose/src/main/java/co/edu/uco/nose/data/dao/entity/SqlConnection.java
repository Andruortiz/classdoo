 package co.edu.uco.nose.data.dao.entity;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.messagecatalog.MessagesEnum;

import java.sql.Connection;
import java.sql.SQLException;

 public abstract class SqlConnection {
	
	private Connection connection;
	
	protected SqlConnection() {
		setConnection(connection);
		
	}

	protected Connection getConnection() {
		return connection;
	}

	private void setConnection(final Connection connection) {
		if (ObjectHelper.IsNull(connection)) {
			var userMessage = MessagesEnum.USER_ERROR_SQLCONNECTION_ID_EMPTY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQLCONNECTION_ID_EMPTY.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
        try {
            if(connection.isClosed()){

            }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


		this.connection = connection;
	}

}
