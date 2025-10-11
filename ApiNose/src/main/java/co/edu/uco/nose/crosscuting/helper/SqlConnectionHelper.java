package co.edu.uco.nose.crosscuting.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.messagecatalog.MessagesEnum;


public abstract class SqlConnectionHelper {

    private final Connection connection;  // Final para inmutabilidad

    protected SqlConnectionHelper(final Connection connection) {
        this.connection = validateAndSetConnection(connection);
    }

    protected Connection getConnection() {
        return connection;
    }

    /**
     * Valida la conexión: lanza NoseException si es nula, cerrada o hay error en validación.
     * Cita mensajes del enum para conexión vacía, cerrada o error inesperado.
     */
    public static void validateConnection(final Connection connection) {
        if (ObjectHelper.isNull(connection)) {
            final String userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY.getContent();
            throw NoseException.create(userMessage, technicalMessage);
        }

        try {
            if (connection.isClosed()) {
                final String userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
                final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED.getContent();
                throw NoseException.create(userMessage, technicalMessage);
            }
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    private Connection validateAndSetConnection(final Connection connection) {
        validateConnection(connection);
        return connection;
    }

    /**
     * Valida si la transacción fue iniciada (autoCommit == false). Lanza excepción citando mensajes del enum si no.
     * Útilse en DAOs antes de INSERT/UPDATE/DELETE para asegurar transacción activa.
     */
    public static void validateIfTransactionWasInitiated(final Connection connection) {
        try {
            if (connection.getAutoCommit()) {
                final String userMessage = MessagesEnum.USER_ERROR_TRANSACTION_NOT_INITIATED.getContent();
                final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_TRANSACTION_NOT_INITIATED.getContent();
                throw NoseException.create(new Exception(),userMessage, technicalMessage);
            }
        } catch (SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    /**
     * Valida si la transacción ya está iniciada (autoCommit == false) para evitar re-inicio. Cita mensajes del enum.
     */
    public static void validateIfTransactionNotAlreadyInitiated(final Connection connection) {
        try {
            if (!connection.getAutoCommit()) {
                final String userMessage = MessagesEnum.USER_ERROR_TRANSACTION_ALREADY_INITIATED.getContent();
                final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_TRANSACTION_ALREADY_INITIATED.getContent();
                throw NoseException.create(new Exception(), userMessage, technicalMessage);
            }
        } catch (SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    /**
     * Inicia la transacción (setAutoCommit(false)). Valida conexión y estado previo, citando mensajes del enum.
     */
    public static void initTransaction(final Connection connection) {
        validateConnection(connection);
        validateIfTransactionNotAlreadyInitiated(connection);

        try {
            connection.setAutoCommit(false);
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_TRANSACTION_INIT_FAILED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_TRANSACTION_INIT_FAILED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    /**
     * Confirma la transacción (commit). Valida conexión y transacción iniciada, citando mensajes del enum.
     */
    public static void commitTransaction(final Connection connection) {
        validateConnection(connection);
        validateIfTransactionWasInitiated(connection);

        try {
            connection.commit();
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_TRANSACTION_COMMIT_FAILED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_TRANSACTION_COMMIT_FAILED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    /**
     * Cancela la transacción (rollback). Valida conexión y transacción iniciada, citando mensajes del enum.
     */
    public static void rollbackTransaction(final Connection connection) {
        validateConnection(connection);
        validateIfTransactionWasInitiated(connection);

        try {
            connection.rollback();
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_TRANSACTION_ROLLBACK_FAILED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_TRANSACTION_ROLLBACK_FAILED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    /**
     * Cierra la conexión. Valida que esté abierta, citando mensajes del enum.
     */
    public static void closeConnection(final Connection connection) {
        validateConnection(connection);  // Asegurar que esté abierta antes de cerrar

        try {
            connection.close();
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_CONNECTION_CLOSE_FAILED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_CONNECTION_CLOSE_FAILED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    // Métodos para apertura de conexión (estándar para PostgreSQL)
    public static Connection openConnection(final String connectionString) {
        try {
            return DriverManager.getConnection(connectionString);
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_CONNECTION_OPEN_FAILED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_CONNECTION_OPEN_FAILED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    public static Connection openConnection(final String url, final String user, final String password) {
        try {
            final Connection connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (final SQLException exception) {
            final String userMessage = MessagesEnum.USER_ERROR_CONNECTION_OPEN_FAILED.getContent();
            final String technicalMessage = MessagesEnum.TECHNICAL_ERROR_CONNECTION_OPEN_FAILED.getContent();
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }
}
/**
 * Asegura que la transacción esté iniciada.
 * Lanza una excepción si la conexión es nula, está cerrada o el autoCommit está activo.
 */
public static void ensureTransactionIsStarted(final Connection connection) {
    validateConnection(connection);
    try {
        if (connection.getAutoCommit()) {
            throw NoseException.create(
                    MessagesEnum.USER_ERROR_TRANSACTION_NOT_INITIATED.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_TRANSACTION_NOT_INITIATED.getTechnicalMessage());
        }
    } catch (final SQLException exception) {
        throw NoseException.create(exception,
                MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS.getContent(),
                MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS.getTechnicalMessage());
    }
}

/**
 * Asegura que la transacción NO esté iniciada.
 * Lanza una excepción si el autoCommit está desactivado (ya hay transacción activa).
 */
public static void ensureTransactionIsNotStarted(final Connection connection) {
    validateConnection(connection);
    try {
        if (!connection.getAutoCommit()) {
            throw NoseException.create(
                    MessagesEnum.USER_ERROR_TRANSACTION_ALREADY_INITIATED.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_TRANSACTION_ALREADY_INITIATED.getTechnicalMessage());
        }
    } catch (final SQLException exception) {
        throw NoseException.create(exception,
                MessagesEnum.USER_ERROR_SQL_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS.getContent(),
                MessagesEnum.TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS.getTechnicalMessage());
    }
}
