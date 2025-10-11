package co.edu.uco.nose.crosscuting.helper;

import java.sql.Connection;

public final class ObjectHelper {
	private ObjectHelper() {

	}

	public static <O> boolean IsNull(O object) {

        return object == null;
	}

	public static <O> O getDefault(O object, final O defaultValue) {

        return IsNull(object) ? defaultValue : object;
	}

    public static String getDefaultWithTrim(final String value) {
        return getDefaultWithTrim(value).trim();
    }


}
