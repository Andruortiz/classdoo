package co.edu.uco.nose.crosscuting.messagecatalog;

public enum MessagesEnum {


    USER_ERROR_SQL_CONNECTION_IS_EMPTY(
            "No se pudo establecer conexión con la base de datos.",
            "El objeto Connection es nulo."),

    TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY(
            "Error técnico al validar conexión nula.",
            "Connection recibido es null en la capa de datos."),

    USER_ERROR_SQL_CONNECTION_IS_CLOSED(
            "La conexión con la base de datos está cerrada.",
            "Intentó usarse una conexión cerrada para ejecutar operaciones."),

    TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED(
            "Error técnico: conexión SQL cerrada.",
            "Se detectó que la conexión estaba cerrada durante la validación."),

    USER_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS(
            "Ocurrió un error inesperado al validar el estado de la conexión.",
            "SQLException lanzada al ejecutar connection.isClosed()."),

    TECHNICAL_ERROR_SQL_CONNECTION_IS_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS(
            "Error SQL inesperado al validar conexión.",
            "SQLException inesperado durante la validación de la conexión."),

    USER_ERROR_CONNECTION_OPEN_FAILED(
            "No fue posible abrir la conexión a la base de datos.",
            "Error al intentar establecer conexión con la base de datos."),

    TECHNICAL_ERROR_CONNECTION_OPEN_FAILED(
            "Fallo técnico al abrir conexión SQL.",
            "DriverManager.getConnection lanzó una SQLException."),

    USER_ERROR_CONNECTION_CLOSE_FAILED(
            "No fue posible cerrar la conexión a la base de datos.",
            "Error al intentar cerrar la conexión SQL."),

    TECHNICAL_ERROR_CONNECTION_CLOSE_FAILED(
            "Fallo técnico al cerrar la conexión SQL.",
            "SQLException al ejecutar connection.close()."),


    USER_ERROR_TRANSACTION_NOT_INITIATED(
            "Transacción no iniciada.",
            "Intentó realizar una operación sin haber iniciado la transacción."),

    TECHNICAL_ERROR_TRANSACTION_NOT_INITIATED(
            "Error técnico: transacción SQL no iniciada.",
            "AutoCommit está activo. Debe desactivarse antes de operar con transacciones."),

    USER_ERROR_TRANSACTION_ALREADY_INITIATED(
            "Transacción ya iniciada.",
            "Se intentó iniciar una nueva transacción cuando ya existía una activa."),

    TECHNICAL_ERROR_TRANSACTION_ALREADY_INITIATED(
            "Error técnico: transacción SQL ya iniciada.",
            "El modo autoCommit ya está desactivado. No puede iniciarse otra transacción."),

    USER_ERROR_TRANSACTION_INIT_FAILED(
            "Fallo al iniciar la transacción.",
            "No se pudo desactivar el autoCommit de la conexión."),

    TECHNICAL_ERROR_TRANSACTION_INIT_FAILED(
            "Error SQL iniciando transacción.",
            "SQLException lanzada al ejecutar connection.setAutoCommit(false)."),

    USER_ERROR_TRANSACTION_COMMIT_FAILED(
            "Fallo al confirmar la transacción.",
            "No se pudo realizar el commit de los cambios en la base de datos."),

    TECHNICAL_ERROR_TRANSACTION_COMMIT_FAILED(
            "Error SQL confirmando transacción.",
            "SQLException lanzada al ejecutar connection.commit()."),

    USER_ERROR_TRANSACTION_ROLLBACK_FAILED(
            "Fallo al revertir la transacción.",
            "No se pudo revertir los cambios de la base de datos."),

    TECHNICAL_ERROR_TRANSACTION_ROLLBACK_FAILED(
            "Error SQL revirtiendo transacción.",
            "SQLException lanzada al ejecutar connection.rollback()."),


    USER_ERROR_SQL_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS(
            "Error inesperado al validar el estado de la transacción.",
            "Ocurrió un error desconocido mientras se comprobaba el estado de la conexión."),

    TECHNICAL_ERROR_SQL_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_STATUS(
            "Error SQL validando estado de transacción.",
            "SQLException inesperado al validar autoCommit o estado de conexión.");

    private final String userMessage;
    private final String technicalMessage;

    MessagesEnum(final String userMessage, final String technicalMessage) {
        this.userMessage = userMessage;
        this.technicalMessage = technicalMessage;
    }

    public String getContent() {
        return userMessage;
    }

    public String getTechnicalMessage() {
        return technicalMessage;
    }
}
