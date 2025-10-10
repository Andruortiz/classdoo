package co.edu.uco.nose.crosscuting.messagecatalog;

import co.edu.uco.nose.crosscuting.helper.TextHelper;

public enum MessagesEnum {
	USER_ERROR_SQLCONNECTION_ID_EMPTY("Conexion contra la uente de informacion vacia","La conexion requerida para llevar acabo la operacion contra la fuente de informacion deseada esta vacia. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion."),
    TECHNICAL_ERROR_SQLCONNECTION_ID_EMPTY("Conexion contra la fuente de informacion deseada nula","La conexion requerida para llevar acabo la operacion contra la base de datos llego nula.");
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
