package co.edu.uco.nose.business.business.validator.user;

import co.edu.uco.nose.business.business.rule.Rule;
import co.edu.uco.nose.business.business.rule.generics.StringLengthValuelsValidRule;
import co.edu.uco.nose.business.business.rule.generics.StringValueIsPresentRule;
import co.edu.uco.nose.business.business.rule.user.UserMobileNumberDoesNotExistRule;
import co.edu.uco.nose.business.business.validator.Validator;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.TextHelper;

public class ValidateDataUserConsistencyForRegisterNewInformation implements Validator{
    private static final Validator instance = new ValidateDataUserConsistencyForRegisterNewInformation();
    private ValidateDataUserConsistencyForRegisterNewInformation() {

    }

    public static void executeValidation(final Object... data) {
        instance.validate(data);

    }

    @Override
    public void validate(final Object... data) {
        // Validaciones del objeto data
        var userDomainData = (UserDomain) data[0];

        // Valid empty data
        validateEmptyData(userDomainData);

        // Valid data length
        validateDataLength(userDomainData);

        // Valid data format

        // Valid data valid range
    }

    private void validateEmptyData(final UserDomain data) {

        StringValueIsPresentRule.executeRule(data.getIdNumber(), "Numero de identificacion", true);
        StringValueIsPresentRule.executeRule(data.getFirstName(), "Primer Nombre", true);
        StringValueIsPresentRule.executeRule(data.getFirstSurname(), "Primer apellido", true);
    }

    private void validateDataLength(final UserDomain data) {


        StringLengthValuelsValidRule.executeRule(data.getIdNumber(), "Numero de identificacion", 1, 50, true);
        StringLengthValuelsValidRule.executeRule(data.getFirstName(), "Primer Nombre", 1, 100, true);

        if (!TextHelper.isEmpty(data.getSecondName())) {
            StringLengthValuelsValidRule.executeRule(data.getSecondName(), "Segundo Nombre", 1, 100, true);
        }

        StringLengthValuelsValidRule.executeRule(data.getFirstSurname(), "Primer apellido", 1, 100, true);
        if (!TextHelper.isEmpty(data.getSecondSurname())) {
            StringLengthValuelsValidRule.executeRule(data.getSecondSurname(), "Segundo apellido", 1, 100, true);
        }





    }
}
