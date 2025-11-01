package co.edu.uco.nose.business.business.rule.idtype;

import co.edu.uco.nose.business.business.rule.Rule;
import co.edu.uco.nose.business.business.rule.generics.StringLengthValuelsValidRule;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.data.factory.DAOFactory;

import java.util.UUID;

public class IdTypeExistById implements Rule {



    private static final Rule instance = new IdTypeExistById();

    private IdTypeExistById () {

    }

    private static void executeRule(final Object... data) {
        instance.execute(data);
    }
    @Override
    public void execute(final Object... data) {

        //mismas validaciones de las de mas reglas
        //que data no llegue nulo
        //que data no tenga menos de dos elementos
        //que id no llegue nulo
        //que daoFactory no llegue nulo
        var id = (UUID) data[0];
        var daoFactory = (DAOFactory) data[1];

        var idType = daoFactory.getIdTypeDAO().findById(id);

        if(UUIDHelper.getUUIDHelper().isDefaultUUID(idType.getId())){

            if (ObjectHelper.isNull(data)) {
                var userMessage = "Se ha presentado un problema tratando de llevar a caba la operacion solicitada.";
                var technicalMessage = "No se recibieron los parametros requeridos para ejecutar la regla StringLengthValuelsValidRule.";
                throw NoseException.create(userMessage, technicalMessage);
            }

            if (data.length < 2) {
                var userMessage = "Se ha presentado un problema tratando de llevar a caba la operacion solicitada.";
                var technicalMessage = "Se requeria dos parametros y llego una cantidad menos a esta requeridos para ejecutar la regla StringValueIsPresentRule.";
                throw NoseException.create(userMessage, technicalMessage);
            }
            if (data.length < 3) {
                var userMessage = "Se ha presentado un problema tratando de llevar a caba la operacion solicitada.";
                var technicalMessage = "Se requeria cinco parametros y llego una cantidad menos a esta requeridos para ejecutar la regla StringValueIsPresentRule.";
                throw NoseException.create(userMessage, technicalMessage);
            }
        }

    }
}
