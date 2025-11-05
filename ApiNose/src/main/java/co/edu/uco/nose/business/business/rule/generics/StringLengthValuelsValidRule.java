package co.edu.uco.nose.business.business.rule.generics;

import co.edu.uco.nose.business.business.rule.Rule;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;

public class StringLengthValuelsValidRule implements Rule {
    private static final Rule instance = new StringLengthValuelsValidRule();
    private StringLengthValuelsValidRule() {

    }

    public static void executeRule(final Object... data) {
        instance.execute(data);

    }

    @Override
    public void execute(final Object... data) {
        if (ObjectHelper.isNull (data)) {
            var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada....";
            var technicalMessage = "No se recibieron los parametros requeridos para ejecutar la regla StringLengthValueIsValidRule";
            throw NoseException.create(userMessage, technicalMessage);

        }
        if (data.length < 5) {
            var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada....";
            var technicalMessage = "Se requerian cinco parametros y llego una cantidad menor a esta requeridos para ejecutar la regla StringLengthValueIsValidRule";
            throw NoseException.create(userMessage, technicalMessage);

        }

        var stringData = (String) data[0];
        var dataName = (String) data[1];
        int minLength = (int) data[2];
        int maxLength = (int) data[3];
        boolean mustApplyTrim = (boolean) data[4];


        if (TextHelper.lengthIsValid(stringData, minLength, maxLength, mustApplyTrim))  {
            var userMessage = "El dato[".concat(dataName).concat("] no tiene una longitud entre"
                    .concat(String.valueOf(minLength)).concat( " y ").concat(String.valueOf(maxLength)).concat(" ..."));
            var technicalMessage = "La regla StringLengthValueIsValidRule fallo porque el dato [".concat(dataName)
                    .concat("] no cumple con la longitud requerida de minimo ")
                    .concat(String.valueOf(minLength)).concat(" y ").concat(String.valueOf(maxLength)).concat(" caracteres ");
            throw NoseException.create(userMessage, technicalMessage);
        }
    }
}