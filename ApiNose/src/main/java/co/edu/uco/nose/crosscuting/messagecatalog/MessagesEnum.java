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
            "Se presentó un error no controlado de tipo Exception al validar si el autocommit contra base de datos estaba desactivado. Por favor valide la consola de errores para revisar con detalle el problema presentado."),



    USER_ERROR_SQL_CREATE("Problema creando el registro en la fuente de información deseada",
                                  "No fue posible registrar la información en la fuente de datos. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
    TECHNICAL_ERROR_SQL_CREATE("Error técnico creando registro en la base de datos",
                                       "Se presentó un error de tipo SQLException mientras se intentaba insertar el registro en la base de datos. Revise la consola para más detalles."),

    USER_ERROR_UNEXPECTED_CREATE("Problema inesperado creando registro en la fuente de información deseada",
                                         "Se presentó un problema inesperado al intentar registrar la información. Por favor intente nuevamente o contacte al administrador del sistema."),
    TECHNICAL_ERROR_UNEXPECTED_CREATE("Error técnico inesperado creando registro en la base de datos",
                                              "Se produjo una excepción no controlada mientras se intentaba crear el registro. Revise el log de errores para más información."),

    USER_ERROR_CRITICAL_CREATE("Error crítico creando el registro en la fuente de información deseada",
                                       "Se presentó un error crítico durante la creación del registro. La operación no pudo completarse. Contacte inmediatamente al administrador del sistema."),
    TECHNICAL_ERROR_CRITICAL_CREATE("Falla crítica al crear el registro en la base de datos",
                                            "Se produjo una excepción grave de tipo Throwable al intentar crear el registro. Revise los registros del sistema para identificar la causa raíz."),


    USER_ERROR_FIND_BY_FILTER_SQL(
            "Error ejecutando la búsqueda de información",
            "Ocurrió un problema al intentar consultar los datos. Por favor intente nuevamente o contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_BY_FILTER_SQL(
            "Error SQL ejecutando la operación de búsqueda",
            "Se presentó un SQLException al ejecutar la consulta en la base de datos. Revise la traza técnica para más detalles."
    ),

    USER_ERROR_FIND_BY_FILTER_UNEXPECTED(
            "Error inesperado al intentar realizar la búsqueda",
            "Ocurrió un problema no controlado al intentar buscar los registros. Por favor intente nuevamente."
    ),
    TECHNICAL_ERROR_FIND_BY_FILTER_UNEXPECTED(
            "Excepción no controlada durante la búsqueda de información",
            "Se lanzó una Exception inesperada durante la ejecución de la consulta. Revise la traza técnica."
    ),

    USER_ERROR_FIND_BY_FILTER_CRITICAL(
            "Error crítico al intentar realizar la búsqueda",
            "El sistema encontró un fallo grave durante la operación. Por favor contacte al administrador del sistema."
    ),
    TECHNICAL_ERROR_FIND_BY_FILTER_CRITICAL(
            "Fallo crítico durante la ejecución del proceso de búsqueda",
            "Se capturó un Throwable crítico durante la ejecución de la búsqueda. Revise la traza técnica para más información."
    ),

    USER_ERROR_FIND_BY_ID_SQL(
            "Error al intentar consultar la información por ID",
            "Ocurrió un problema al intentar obtener la información solicitada. Por favor intente nuevamente o contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_BY_ID_SQL(
            "Error SQL ejecutando la búsqueda por ID",
            "Se presentó un SQLException al intentar ejecutar la consulta por ID en la base de datos."
    ),

    USER_ERROR_FIND_BY_ID_UNEXPECTED(
            "Error inesperado al intentar realizar la búsqueda por ID",
            "Ocurrió un problema no controlado al buscar los datos solicitados. Por favor intente nuevamente."
    ),
    TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED(
            "Excepción no controlada durante la búsqueda por ID",
            "Se lanzó una Exception inesperada durante la ejecución de la búsqueda por ID. Revise la traza técnica."
    ),

    USER_ERROR_FIND_BY_ID_CRITICAL(
            "Error crítico al intentar realizar la búsqueda por ID",
            "El sistema encontró un fallo grave durante la operación de búsqueda. Por favor contacte al administrador del sistema."
    ),
    TECHNICAL_ERROR_FIND_BY_ID_CRITICAL(
            "Fallo crítico durante la ejecución de la búsqueda por ID",
            "Se capturó un Throwable crítico durante la ejecución de la búsqueda. Revise la traza técnica para más información."
    ),
    USER_ERROR_SQL_UPDATE(
            "Error al intentar actualizar la información del registro",
            "Ocurrió un problema al intentar actualizar los datos. Por favor intente nuevamente o contacte al administrador."
    ),
    TECHNICAL_ERROR_SQL_UPDATE(
            "Error SQL ejecutando la actualización del registro",
            "Se presentó un SQLException al intentar ejecutar la sentencia UPDATE en la base de datos."
    ),

    USER_ERROR_UNEXPECTED_UPDATE(
            "Error inesperado al intentar actualizar la información del registro",
            "Ocurrió un problema no controlado al intentar realizar la actualización. Por favor intente nuevamente."
    ),
    TECHNICAL_ERROR_UNEXPECTED_UPDATE(
            "Excepción no controlada durante la actualización del registro",
            "Se lanzó una Exception inesperada durante la ejecución de la actualización. Revise la traza técnica."
    ),

    USER_ERROR_CRITICAL_UPDATE(
            "Error crítico al intentar actualizar la información del registro",
            "El sistema encontró un fallo grave durante la operación de actualización. Por favor contacte al administrador del sistema."
    ),
    TECHNICAL_ERROR_CRITICAL_UPDATE(
            "Fallo crítico durante la ejecución de la actualización del registro",
            "Se capturó un Throwable crítico durante la ejecución de la operación UPDATE. Revise la traza técnica para más información."
    ),

    // --- DELETE ---
    USER_ERROR_SQL_DELETE("Error eliminando el usuario",
            "Se presentó un error al intentar eliminar el usuario. Por favor intente de nuevo y si el problema persiste, contacte al administrador de la aplicación."),
    TECHNICAL_ERROR_SQL_DELETE("Error técnico al eliminar el usuario",
            "Se produjo un SQLException al eliminar el usuario en la base de datos."),
    USER_ERROR_UNEXPECTED_DELETE("Error inesperado eliminando el usuario",
            "Ocurrió un problema inesperado durante la eliminación del usuario. Intente nuevamente o contacte al administrador."),
    TECHNICAL_ERROR_UNEXPECTED_DELETE("Error técnico inesperado al eliminar el usuario",
            "Se lanzó una excepción inesperada al eliminar el usuario en la base de datos."),
    USER_ERROR_CRITICAL_DELETE("Error crítico eliminando el usuario",
            "Ocurrió un fallo grave al eliminar el usuario. Contacte al administrador del sistema."),
    TECHNICAL_ERROR_CRITICAL_DELETE("Error técnico crítico al eliminar el usuario",
            "Se presentó un Throwable crítico durante la eliminación del usuario en la base de datos."),

    // java
    ID_TYPE_ERROR_FIND_ALL_SQL(
            "Error al obtener todos los tipos de documento",
            "Ocurrió un problema al intentar obtener los tipos de documento desde la fuente de datos. Por favor intente nuevamente o contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_ALL_SQL_ID_TYPE(
            "Error SQL al obtener todos los tipos de documento",
            "Se presentó un SQLException al ejecutar la consulta para obtener los tipos de documento. Revise la traza técnica para más detalles."
    ),

    ID_TYPE_ERROR_FIND_ALL_UNEXPECTED(
            "Error inesperado al obtener todos los tipos de documento",
            "Ocurrió un problema inesperado al intentar obtener los tipos de documento. Por favor intente nuevamente."
    ),
    TECHNICAL_ERROR_FIND_ALL_UNEXPECTED_ID_TYPE(
            "Excepción no controlada al obtener todos los tipos de documento",
            "Se lanzó una Exception inesperada al ejecutar la operación. Revise la traza técnica."
    ),

    ID_TYPE_ERROR_FIND_ALL_CRITICAL(
            "Error crítico al obtener todos los tipos de documento",
            "Se presentó un fallo crítico al obtener los tipos de documento. Contacte al administrador del sistema."
    ),
    TECHNICAL_ERROR_FIND_ALL_CRITICAL_ID_TYPE(
            "Fallo crítico al obtener todos los tipos de documento",
            "Se capturó un Throwable crítico durante la operación. Revise los registros del sistema."
    ),

    ID_TYPE_ERROR_FIND_BY_FILTER_SQL(
            "Error ejecutando la búsqueda de tipos de documento",
            "Ocurrió un problema al intentar consultar los tipos de documento con el filtro proporcionado. Por favor intente nuevamente o contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_BY_FILTER_SQL_ID_TYPE(
            "Error SQL buscando tipos de documento por filtro",
            "Se presentó un SQLException al ejecutar la consulta de tipos de documento por filtro. Revise la traza técnica."
    ),

    ID_TYPE_ERROR_FIND_BY_FILTER_UNEXPECTED(
            "Error inesperado buscando tipos de documento por filtro",
            "Ocurrió un problema no controlado al intentar buscar los tipos de documento. Por favor intente nuevamente."
    ),
    TECHNICAL_ERROR_FIND_BY_FILTER_UNEXPECTED_ID_TYPE(
            "Excepción no controlada buscando tipos de documento por filtro",
            "Se lanzó una Exception inesperada durante la búsqueda por filtro. Revise la traza técnica."
    ),

    ID_TYPE_ERROR_FIND_BY_FILTER_CRITICAL(
            "Error crítico buscando tipos de documento por filtro",
            "El sistema encontró un fallo grave durante la búsqueda por filtro. Contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_BY_FILTER_CRITICAL_ID_TYPE(
            "Fallo crítico durante búsqueda por filtro de tipos de documento",
            "Se capturó un Throwable crítico durante la operación de búsqueda por filtro."
    ),

    ID_TYPE_ERROR_FIND_BY_ID_SQL(
            "Error al consultar tipo de documento por ID",
            "Ocurrió un problema al intentar obtener el tipo de documento por ID. Por favor intente nuevamente o contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_BY_ID_SQL_ID_TYPE(
            "Error SQL buscando tipo de documento por ID",
            "Se presentó un SQLException al ejecutar la consulta por ID para tipos de documento."
    ),

    ID_TYPE_ERROR_FIND_BY_ID_UNEXPECTED(
            "Error inesperado buscando tipo de documento por ID",
            "Ocurrió un problema no controlado al buscar el tipo de documento por ID. Por favor intente nuevamente."
    ),
    TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED_ID_TYPE(
            "Excepción no controlada buscando tipo de documento por ID",
            "Se lanzó una Exception inesperada durante la búsqueda por ID. Revise la traza técnica."
    ),

    ID_TYPE_ERROR_FIND_BY_ID_CRITICAL(
            "Error crítico buscando tipo de documento por ID",
            "Se presentó un fallo grave durante la búsqueda por ID. Contacte al administrador del sistema."
    ),
    TECHNICAL_ERROR_FIND_BY_ID_CRITICAL_ID_TYPE(
            "Fallo crítico durante búsqueda por ID de tipo de documento",
            "Se capturó un Throwable crítico durante la operación de búsqueda por ID."
    ),

    CITY_ERROR_FIND_ALL_SQL(
            "Error al obtener todas las ciudades",
            "Ocurrió un problema al intentar obtener las ciudades desde la fuente de datos. Por favor intente nuevamente o contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_ALL_SQL_CITY(
            "Error SQL al obtener todas las ciudades",
            "Se presentó un SQLException al ejecutar la consulta para obtener las ciudades. Revise la traza técnica para más detalles."
    ),

    CITY_ERROR_FIND_ALL_UNEXPECTED(
            "Error inesperado al obtener todas las ciudades",
            "Ocurrió un problema inesperado al intentar obtener las ciudades. Por favor intente nuevamente."
    ),
    TECHNICAL_ERROR_FIND_ALL_UNEXPECTED_CITY(
            "Excepción no controlada al obtener todas las ciudades",
            "Se lanzó una Exception inesperada al ejecutar la operación. Revise la traza técnica."
    ),

    CITY_ERROR_FIND_ALL_CRITICAL(
            "Error crítico al obtener todas las ciudades",
            "Se presentó un fallo crítico al obtener las ciudades. Contacte al administrador del sistema."
    ),
    TECHNICAL_ERROR_FIND_ALL_CRITICAL_CITY(
            "Fallo crítico al obtener todas las ciudades",
            "Se capturó un Throwable crítico durante la operación. Revise los registros del sistema."
    ),

    CITY_ERROR_FIND_BY_FILTER_SQL(
            "Error ejecutando la búsqueda de ciudades",
            "Ocurrió un problema al intentar consultar las ciudades con el filtro proporcionado. Por favor intente nuevamente o contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_BY_FILTER_SQL_CITY(
            "Error SQL buscando ciudades por filtro",
            "Se presentó un SQLException al ejecutar la consulta de ciudades por filtro. Revise la traza técnica."
    ),

    CITY_ERROR_FIND_BY_FILTER_UNEXPECTED(
            "Error inesperado buscando ciudades por filtro",
            "Ocurrió un problema no controlado al intentar buscar las ciudades. Por favor intente nuevamente."
    ),
    TECHNICAL_ERROR_FIND_BY_FILTER_UNEXPECTED_CITY(
            "Excepción no controlada buscando ciudades por filtro",
            "Se lanzó una Exception inesperada durante la búsqueda por filtro. Revise la traza técnica."
    ),

    CITY_ERROR_FIND_BY_FILTER_CRITICAL(
            "Error crítico buscando ciudades por filtro",
            "El sistema encontró un fallo grave durante la búsqueda por filtro. Contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_BY_FILTER_CRITICAL_CITY(
            "Fallo crítico durante búsqueda por filtro de ciudades",
            "Se capturó un Throwable crítico durante la operación de búsqueda por filtro."
    ),

    CITY_ERROR_FIND_BY_ID_SQL(
            "Error al consultar ciudad por ID",
            "Ocurrió un problema al intentar obtener la ciudad por ID. Por favor intente nuevamente o contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_BY_ID_SQL_CITY(
            "Error SQL buscando ciudad por ID",
            "Se presentó un SQLException al ejecutar la consulta por ID para ciudades. Revise la traza técnica."
    ),

    CITY_ERROR_FIND_BY_ID_UNEXPECTED(
            "Error inesperado buscando ciudad por ID",
            "Ocurrió un problema no controlado al buscar la ciudad por ID. Por favor intente nuevamente."
    ),
    TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED_CITY(
            "Excepción no controlada buscando ciudad por ID",
            "Se lanzó una Exception inesperada durante la búsqueda por ID. Revise la traza técnica."
    ),

    CITY_ERROR_FIND_BY_ID_CRITICAL(
            "Error crítico buscando ciudad por ID",
            "Se presentó un fallo crítico al buscar la ciudad por ID. Contacte al administrador del sistema."
    ),
    TECHNICAL_ERROR_FIND_BY_ID_CRITICAL_CITY(
            "Fallo crítico durante búsqueda por ID de ciudad",
            "Se capturó un Throwable crítico durante la operación de búsqueda por ID."
    ),

    // java
    COUNTRY_ERROR_FIND_ALL_SQL(
            "Error al obtener todos los países",
            "Ocurrió un problema al intentar obtener los países desde la fuente de datos. Por favor intente nuevamente o contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_ALL_SQL_COUNTRY(
            "Error SQL al obtener todos los países",
            "Se presentó un SQLException al ejecutar la consulta para obtener los países. Revise la traza técnica para más detalles."
    ),

    COUNTRY_ERROR_FIND_ALL_UNEXPECTED(
            "Error inesperado al obtener todos los países",
            "Ocurrió un problema inesperado al intentar obtener los países. Por favor intente nuevamente."
    ),
    TECHNICAL_ERROR_FIND_ALL_UNEXPECTED_COUNTRY(
            "Excepción no controlada al obtener todos los países",
            "Se lanzó una Exception inesperada al ejecutar la operación. Revise la traza técnica."
    ),

    COUNTRY_ERROR_FIND_ALL_CRITICAL(
            "Error crítico al obtener todos los países",
            "Se presentó un fallo crítico al obtener los países. Contacte al administrador del sistema."
    ),
    TECHNICAL_ERROR_FIND_ALL_CRITICAL_COUNTRY(
            "Fallo crítico al obtener todos los países",
            "Se capturó un Throwable crítico durante la operación. Revise los registros del sistema."
    ),

    COUNTRY_ERROR_FIND_BY_FILTER_SQL(
            "Error ejecutando la búsqueda de países",
            "Ocurrió un problema al intentar consultar los países con el filtro proporcionado. Por favor intente nuevamente o contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_BY_FILTER_SQL_COUNTRY(
            "Error SQL buscando países por filtro",
            "Se presentó un SQLException al ejecutar la consulta de países por filtro. Revise la traza técnica."
    ),

    COUNTRY_ERROR_FIND_BY_FILTER_UNEXPECTED(
            "Error inesperado buscando países por filtro",
            "Ocurrió un problema no controlado al intentar buscar los países. Por favor intente nuevamente."
    ),
    TECHNICAL_ERROR_FIND_BY_FILTER_UNEXPECTED_COUNTRY(
            "Excepción no controlada buscando países por filtro",
            "Se lanzó una Exception inesperada durante la búsqueda por filtro. Revise la traza técnica."
    ),

    COUNTRY_ERROR_FIND_BY_FILTER_CRITICAL(
            "Error crítico buscando países por filtro",
            "El sistema encontró un fallo grave durante la búsqueda por filtro. Contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_BY_FILTER_CRITICAL_COUNTRY(
            "Fallo crítico durante búsqueda por filtro de países",
            "Se capturó un Throwable crítico durante la operación de búsqueda por filtro."
    ),

    COUNTRY_ERROR_FIND_BY_ID_SQL(
            "Error al consultar país por ID",
            "Ocurrió un problema al intentar obtener el país por ID. Por favor intente nuevamente o contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_BY_ID_SQL_COUNTRY(
            "Error SQL buscando país por ID",
            "Se presentó un SQLException al ejecutar la consulta por ID para países. Revise la traza técnica."
    ),

    COUNTRY_ERROR_FIND_BY_ID_UNEXPECTED(
            "Error inesperado buscando país por ID",
            "Ocurrió un problema no controlado al buscar el país por ID. Por favor intente nuevamente."
    ),
    TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED_COUNTRY(
            "Excepción no controlada buscando país por ID",
            "Se lanzó una Exception inesperada durante la búsqueda por ID. Revise la traza técnica."
    ),

    COUNTRY_ERROR_FIND_BY_ID_CRITICAL(
            "Error crítico buscando país por ID",
            "Se presentó un fallo crítico al buscar el país por ID. Contacte al administrador del sistema."
    ),
    TECHNICAL_ERROR_FIND_BY_ID_CRITICAL_COUNTRY(
            "Fallo crítico durante búsqueda por ID de país",
            "Se capturó un Throwable crítico durante la operación de búsqueda por ID."
    ),

    // java
    STATE_ERROR_FIND_ALL_SQL(
            "Error al obtener todos los estados",
            "Ocurrió un problema al intentar obtener los estados desde la fuente de datos. Por favor intente nuevamente o contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_ALL_SQL_STATE(
            "Error SQL al obtener todos los estados",
            "Se presentó un SQLException al ejecutar la consulta para obtener los estados. Revise la traza técnica para más detalles."
    ),

    STATE_ERROR_FIND_ALL_UNEXPECTED(
            "Error inesperado al obtener todos los estados",
            "Ocurrió un problema inesperado al intentar obtener los estados. Por favor intente nuevamente."
    ),
    TECHNICAL_ERROR_FIND_ALL_UNEXPECTED_STATE(
            "Excepción no controlada al obtener todos los estados",
            "Se lanzó una Exception inesperada al ejecutar la operación. Revise la traza técnica."
    ),

    STATE_ERROR_FIND_ALL_CRITICAL(
            "Error crítico al obtener todos los estados",
            "Se presentó un fallo crítico al obtener los estados. Contacte al administrador del sistema."
    ),
    TECHNICAL_ERROR_FIND_ALL_CRITICAL_STATE(
            "Fallo crítico al obtener todos los estados",
            "Se capturó un Throwable crítico durante la operación. Revise los registros del sistema."
    ),

    STATE_ERROR_FIND_BY_FILTER_SQL(
            "Error ejecutando la búsqueda de estados",
            "Ocurrió un problema al intentar consultar los estados con el filtro proporcionado. Por favor intente nuevamente o contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_BY_FILTER_SQL_STATE(
            "Error SQL buscando estados por filtro",
            "Se presentó un SQLException al ejecutar la consulta de estados por filtro. Revise la traza técnica."
    ),

    STATE_ERROR_FIND_BY_FILTER_UNEXPECTED(
            "Error inesperado buscando estados por filtro",
            "Ocurrió un problema no controlado al intentar buscar los estados. Por favor intente nuevamente."
    ),
    TECHNICAL_ERROR_FIND_BY_FILTER_UNEXPECTED_STATE(
            "Excepción no controlada buscando estados por filtro",
            "Se lanzó una Exception inesperada durante la búsqueda por filtro. Revise la traza técnica."
    ),

    STATE_ERROR_FIND_BY_FILTER_CRITICAL(
            "Error crítico buscando estados por filtro",
            "El sistema encontró un fallo grave durante la búsqueda por filtro. Contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_BY_FILTER_CRITICAL_STATE(
            "Fallo crítico durante búsqueda por filtro de estados",
            "Se capturó un Throwable crítico durante la operación de búsqueda por filtro."
    ),

    STATE_ERROR_FIND_BY_ID_SQL(
            "Error al consultar estado por ID",
            "Ocurrió un problema al intentar obtener el estado por ID. Por favor intente nuevamente o contacte al administrador."
    ),
    TECHNICAL_ERROR_FIND_BY_ID_SQL_STATE(
            "Error SQL buscando estado por ID",
            "Se presentó un SQLException al ejecutar la consulta por ID para estados. Revise la traza técnica."
    ),

    STATE_ERROR_FIND_BY_ID_UNEXPECTED(
            "Error inesperado buscando estado por ID",
            "Ocurrió un problema no controlado al buscar el estado por ID. Por favor intente nuevamente."
    ),
    TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED_STATE(
            "Excepción no controlada buscando estado por ID",
            "Se lanzó una Exception inesperada durante la búsqueda por ID. Revise la traza técnica."
    ),

    STATE_ERROR_FIND_BY_ID_CRITICAL(
            "Error crítico buscando estado por ID",
            "Se presentó un fallo crítico al buscar el estado por ID. Contacte al administrador del sistema."
    ),
    TECHNICAL_ERROR_FIND_BY_ID_CRITICAL_STATE(
            "Fallo crítico durante búsqueda por ID de estado",
            "Se capturó un Throwable crítico durante la operación de búsqueda por ID."
    ),

    // java
    VALIDATION_ID_DUPLICATED(
            "Validación: identificación duplicada",
            "El tipo de identificación y número ya se encuentran registrados."),
    VALIDATION_EMAIL_DUPLICATED(
            "Validación: email duplicado",
            "El correo electrónico ya se encuentra registrado."),
    VALIDATION_PHONE_DUPLICATED(
            "Validación: teléfono duplicado",
            "El número de teléfono ya se encuentra registrado."),
    USER_ERROR_FIND_ALL_UNEXPECTED(
            "Error inesperado al obtener todos los registros",
            "Ocurrió un problema no controlado al obtener todos los registros. Intente nuevamente."),
    TECHNICAL_ERROR_FIND_ALL_UNEXPECTED(
            "Excepción no controlada al obtener todos los registros",
            "Se lanzó una Exception inesperada durante la operación. Revise la traza técnica."),

    USER_ERROR_DATABASE_CONNECTION("Error al conectar con la base de datos. Por favor, verifique la conexión o contacte al administrador.",
            "No fue posible establecer una conexión con la base de datos debido a un error de configuración o red."),
    TECHNICAL_ERROR_DATABASE_CONNECTION("Se produjo un error SQL al intentar establecer conexión con la base de datos.",
            "Se presentó un SQLException al intentar conectar con la base de datos. Revise la traza técnica para más detalles."),

    USER_ERROR_MISSING_DRIVER("No se pudo establecer la conexión porque falta el driver de base de datos.",
            "La aplicación no pudo encontrar el driver JDBC necesario para conectarse a la base de datos. Por favor, asegúrese de que el driver esté incluido en el classpath."),
    TECHNICAL_ERROR_MISSING_DRIVER("El driver JDBC de PostgreSQL no fue encontrado en el classpath.",
            "Se produjo un error ClassNotFoundException al intentar cargar el driver JDBC de PostgreSQL. Verifique que la dependencia esté correctamente configurada."),
    USER_ERROR_SQL_FIND_ALL(
        "Error ejecutando la consulta para obtener todos los usuarios",
                "Ocurrió un problema al intentar recuperar todos los usuarios desde la fuente de datos. Por favor intente nuevamente o contacte al administrador."
    ),
    TECHNICAL_ERROR_SQL_FIND_ALL(
        "Error SQL al obtener todos los usuarios",
                "Se presentó un SQLException al ejecutar la consulta para obtener todos los usuarios. Revise la traza técnica para más detalles."
    ),
    USER_ERROR_UNEXPECTED_FIND_ALL(
        "Error inesperado al obtener todos los usuarios",
                "Ocurrió un problema no controlado al intentar obtener todos los usuarios. Intente nuevamente."
    ),
    TECHNICAL_ERROR_UNEXPECTED_FIND_ALL(
        "Excepción no controlada al obtener todos los usuarios",
                "Se lanzó una Exception inesperada durante la operación de obtención de todos los usuarios. Revise la traza técnica."
    ),
    USER_ERROR_CRITICAL_FIND_ALL(
        "Error crítico al obtener todos los usuarios",
                "Se presentó un fallo crítico al intentar recuperar todos los usuarios. Contacte al administrador del sistema."
    ),
    TECHNICAL_ERROR_CRITICAL_FIND_ALL(
        "Fallo crítico al obtener todos los usuarios",
                "Se capturó un Throwable crítico durante la operación de obtención de todos los usuarios. Revise los registros del sistema."
    );









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
