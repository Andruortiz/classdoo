package co.edu.uco.nose.crosscuting.helper;

public final class ObjectHelper {
	private ObjectHelper() {

	}

	public static <O> boolean IsNull(O object) {
		return object == null;
	}

	public static <O> O getDefault(O object, final O defaultValue) {
		return IsNull(object) ? defaultValue : object;
	}
}
