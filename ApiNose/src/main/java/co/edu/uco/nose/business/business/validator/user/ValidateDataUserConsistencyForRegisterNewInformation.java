package co.edu.uco.nose.business.business.validator.user;

import co.edu.uco.nose.business.business.rule.Rule;
import co.edu.uco.nose.business.business.rule.generics.StringLengthValuelsValidRule;
import co.edu.uco.nose.business.business.rule.generics.StringValueIsPresentRule;
import co.edu.uco.nose.business.business.rule.user.UserMobileNumberDoesNotExistRule;
import co.edu.uco.nose.business.business.validator.Validator;
import co.edu.uco.nose.business.domain.UserDomain;

public class ValidateDataUserConsistencyForRegisterNewInformation implements Validator{


    private static final Rule instance = new ValidateDataUserConsistencyForRegisterNewInformation();

    private ValidateDataUserConsistencyForRegisterNewInformation () {

    }

    private static void executeValidation(final Object... data) {
        instance.execute(data);
    }

    @Override
    public void validate(final Object... data) {


        //validacion del objeto data
        var userDomainData = (UserDomain) data[0];

        //valid empty data
        validateEmptyData();
        //valid data length
        vali
        //valid data format
        //vaalid data valid range

    }



    private void validateEmptyData(final UserDomain data) {
        private String idNumber;
        private String firstName;
        private String secondName;
        private String firstSurname;
        private String secondSurname;

        StringValueIsPresentRule.executeRule(data.getIdNumber(), "");
        StringValueIsPresentRule.executeRule(data.getFirstName(), "");
        StringValueIsPresentRule.executeRule(data.getFirstSurname(), "");
        //continue another validation
    }
}
