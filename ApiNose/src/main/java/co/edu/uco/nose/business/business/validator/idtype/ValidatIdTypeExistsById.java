package co.edu.uco.nose.business.business.validator.idtype;

import co.edu.uco.nose.business.business.rule.idtype.IdTypeExistById;
import co.edu.uco.nose.business.business.validator.Validator;

public class ValidatIdTypeExistsById implements Validator {

    @Override
    public void validate(Object... data) {
        IdTypeExistByIdRule.executeRule*=(data);

    }
}
