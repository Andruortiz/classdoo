package co.edu.uco.nose.crosscuting.messagecatalog;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public enum MessagesEnum {


    USER_ERROR_SQL_CONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada vacía",
            "La conexión requerida para llevar a cabo la operación contra la fuente de información deseada está vacía. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
    TECHNICAL_ERROR_SQL_CONNECTION_IS_EMPTY("Conexión contra la fuente de información deseada nula",
            "La conexión requerida para llevar a cabo la operación contra la base de datos llegó nula."),
    USER_ERROR_SQL_CONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada",
            "La conexión requerida para llevar a cabo la operación contra la fuente de información deseada está cerrada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
    TECHNICAL_ERROR_SQL_CONNECTION_IS_CLOSED("Conexión contra la fuente de información deseada cerrada",
            "La conexión requerida para llevar a cabo la operación contra la base de datos está cerrada."),
    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_CONNECTION_STATUS(
            "Error inesperado validando si la conexión contra la base de datos estaba abierta",
            "Se presentó un error de tipo SQLException al validar si la conexión contra base de datos estaba o no abierta. Por favor valide la consola de errores para revisar con detalle el problema presentado."),
    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS(
            "Problema inesperado validando el estado de la conexión contra la fuente de datos deseada",
            "Se ha presentado un problema inesperado tratando de validar el estado de la conexión requerida para llevar a cabo la operación contra la fuente de información deseada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_CONNECTION_STATUS(
            "Error inesperado validando si la conexión contra la base de datos estaba abierta",
            "Se presentó un error no controlado de tipo Exception al validar si la conexión contra base de datos estaba o no abierta. Por favor valide la consola de errores para revisar con detalle el problema presentado."),
    USER_ERROR_TRANSACTION_IS_NOT_STARTED("Manejo de operaciones contra la fuente de información deseada no iniciada",
            "No se ha iniciado el manejo de operaciones contra la fuente de información deseada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
    TECHNICAL_ERROR_TRANSACTION_IS_NOT_STARTED("Autocommit contra la fuente de información deseada activado",
            "El autocommit requerido para llevar a cabo la operación contra la base de datos para operaciones de insert, update y delete no fue desactivado."),
    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_STARTED(
            "Error inesperado validando si el autocommint contra la base de datos estaba desactivado",
            "Se presentó un error de tipo SQLException al validar si el autocommit había sido desactivado. Por favor valide la consola de errores para revisar con detalle el problema presentado."),
    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED(
            "Problema inesperado validando el manejo de operaciones contra la fuente de datos deseada",
            "Se ha presentando un problema inesperado tratando de validar el estado del manejo de las operaciones para llevar a cabo la operación contra la fuente de información deseada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_STARTED(
            "Error inesperado validando si el autocommit contra la base de datos estaba desactivado",
            "Se presentó un error no controlado de tipo Exception al validar si el autocommit contra base de datos estaba desactivado. Por favor valide la consola de errores para revisar con detalle el problema presentado."),


    USER_ERROR_TRANSACTION_IS_STARTED("Manejo de operaciones contra la fuente de información deseada ya iniciado",
            "Ya se ha iniciado el manejo de operaciones contra la fuente de información deseada por lo que no es posible volverlo a iniciar. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
    TECHNICAL_ERROR_TRANSACTION_IS_STARTED("Autocommit contra la fuente de información deseada ya activado",
            "El autocommit requerido para llevar a cabo la operación contra la base de datos para operaciones de insert, update y delete ya había sido desactivado previamente."),

    USER_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED(
            "Error inesperado validando si el autocommint contra la base de datos estaba desactivado",
            "Se presentó un error de tipo SQLException al validar si el autocommit había sido desactivado. Por favor valide la consola de errores para revisar con detalle el problema presentado."),
    TECHNICAL_ERROR_SQL_CONNECTION_SQL_EXCEPTION_VALIDATING_TRANSACTION_IS_NOT_STARTED(
            "Problema inesperado validando el manejo de operaciones contra la fuente de datos deseada",
            "Se ha presentando un problema inesperado tratando de validar el estado del manejo de las operaciones para llevar a cabo la operación contra la fuente de información deseada. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
    TECHNICAL_ERROR_SQL_CONNECTION_UNEXPECTED_ERROR_VALIDATING_TRANSACTION_IS_NOT_STARTED(
            "Error inesperado validando si el autocommit contra la base de datos estaba desactivado",
            "Se presentó un error no controlado de tipo Exception al validar si el autocommit contra base de datos estaba desactivado. Por favor valide la consola de errores para revisar con detalle el problema presentado.");




    private String title;
    private String content;

    private MessagesEnum(final String title, final String content) {
        setTitle(title);
        setContent(content);
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(final String title) {
        this.title = TextHelper.getDefaultWithTrim(title);
    }

    public String getContent() {
        return content;
    }

    private void setContent(final String content) {
        this.content = TextHelper.getDefaultWithTrim(content);
    }
}
