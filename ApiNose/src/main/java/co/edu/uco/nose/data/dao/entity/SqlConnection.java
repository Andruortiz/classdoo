 package co.edu.uco.nose.data.dao.entity;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.messagecatalog.MessagesEnum;

import java.sql.Connection;
import java.sql.SQLException;

 public abstract class SqlConnection {

	private Connection connection;

	protected SqlConnection(final Connection connection) {
		setConnection(connection);

	}

	protected Connection getConnection() {
		return connection;
	}

	private void setConnection(final Connection connection) {
		if (ObjectHelper.IsNull(connection)) {
			var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
			throw NoseException.create(userMessage, technicalMessage);
		}
        try {
            if(connection.isClosed()){
                var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
                throw NoseException.create(userMessage, technicalMessage);

            }
            } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
            }
        this.connection = connection;
        }



    private void ensureTransactionIsStarted()  {
        try {
            if (ObjectHelper.IsNull(getConnection()) || getConnection().isClosed()) {
                var userMessage = MessagesEnum.USER_ERROR_SQL_TRANSACTION_IS_NOT_STARTED.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_TRANSACTION_IS_NOT_STARTED.getContent();
                throw NoseException.create(userMessage, technicalMessage);
            }

            if (getConnection().getAutoCommit()) {
                var userMessage = MessagesEnum.USER_ERROR_SQL_TRANSACTION_IS_NOT_STARTED.getContent();
                var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_TRANSACTION_IS_NOT_STARTED.getContent();
                throw NoseException.create(userMessage, technicalMessage);
            }

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

	}

