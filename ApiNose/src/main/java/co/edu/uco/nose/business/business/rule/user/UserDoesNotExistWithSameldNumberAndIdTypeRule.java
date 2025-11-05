package co.edu.uco.nose.business.business.rule.user;

import co.edu.uco.nose.business.business.rule.Rule;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.data.factory.DAOFactory;

import java.util.UUID;

public class UserDoesNotExistWithSameldNumberAndIdTypeRule implements Rule {

    @Override
    public void execute(final Object...data) {
        var id = (UUID) data[0];
        var daoFactory = (DAOFactory) data[1];

        var idType = daoFactory.getIdTypeDAO().findById(id);

        if (UUIDHelper.getUUIDHelper().isDefaultUUID(idType.getId())) {
            var userMessage = "El tipo de identificacion deseado no existe....";
            var technicalMessage = "El tipo de identificacion con id ["
                    .concat(id.toString()).concat("] no existe....");
            throw NoseException.create(userMessage, technicalMessage);
        }
    }
}
