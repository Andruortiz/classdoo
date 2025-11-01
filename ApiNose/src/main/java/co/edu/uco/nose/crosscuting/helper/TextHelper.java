package co.edu.uco.nose.crosscuting.helper;

public final class TextHelper {

    private static final String EMPTY = "";

    private TextHelper() {
    }

    public static String getDefault() {
        return EMPTY;
    }

    public static String getDefault(final String value) {
        return ObjectHelper.getDefault(value, getDefault());
    }

    public static String getDefaultWithTrim(final String value) {
        return getDefault(value).trim();
    }

    public static boolean isEmpty(final String value) {
        return EMPTY.equals(getDefault(value));
    }

    public static boolean isEmptyWithTrim(final String value) {
        return EMPTY.equals(getDefaultWithTrim(value));
    }

    public static boolean LengthIsValid(final String value, final int min, final int max, final boolean mustApplyTrim) {
        var Length = (mustApplyTrim ? getDefaultWithTrim(value) : getDefault(value),
        var Length = value.length();
        return Length >= min && Length <= max;
    }

    public static boolean LenghtIsValidWithTrim(final String value, final int min, final int max) {
        return LengthIsValid(getDefaultWithTrim(value), min, max, true);
    }

}
