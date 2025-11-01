package co.edu.uco.nose.business.business.rule.generics;

import co.edu.uco.nose.business.business.rule.Rule;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;

public final class StringValueIsPresentRule implements Rule {



    private static final Rule instance = new StringValueIsPresentRule();

    private StringValueIsPresentRule () {

    }

    private static void executeRule(final Object... data) {
        instance.execute(data);
    }


    @Override
    public void execute(final Object... data) {

        if (ObjectHelper.isNull(data)) {
            var userMessage = "Se ha presentado un problema tratando de llevar a caba la operacion solicitada.";
            var technicalMessage = "No se recibieron los parametros requeridos para ejecutar la regla StringValueIsPresentRule.";
            throw NoseException.create(userMessage, technicalMessage);
        }

        if (data.length < 2) {
            var userMessage = "Se ha presentado un problema tratando de llevar a caba la operacion solicitada.";
            var technicalMessage = "Se requeria dos parametros y llego una cantidad menos a esta requeridos para ejecutar la regla StringValueIsPresentRule.";
            throw NoseException.create(userMessage, technicalMessage);
        }
        if (data.length < 3) {
            var userMessage = "Se ha presentado un problema tratando de llevar a caba la operacion solicitada.";
            var technicalMessage = "Se requeria tres parametros y llego una cantidad menos a esta requeridos para ejecutar la regla StringValueIsPresentRule.";
            throw NoseException.create(userMessage, technicalMessage);
        }

        var stringData = (String) data[0];
        var dataName = (String) data[1];
        boolean mustApplyTrim = (Boolean) data[2];


        if ((mustApplyTrim) ? TextHelper.isEmptyWithTrim(stringData) : TextHelper.isEmpty(stringData)) {
            var userMessage = "El dato[".concat(dataName).concat("] es requerido para llevar a cabo la operacion.");
            var technicalMessage = "La regla StringValueIsPresentRule ha fallado porque el dato [".concat(dataName).concat("] requerido para llevar a cabo la operacion esta vacio");
            throw NoseException.create(userMessage, technicalMessage);
        }

    }
}
