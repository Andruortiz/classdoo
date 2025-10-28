package co.edu.uco.nose.business.domain;

import java.util.UUID;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class UserDomain extends Domain {

    private IdTypeDomain idType;
    private String idNumber;
    private String firstName;
    private String middleName;
    private String firstLastName;
    private String secondLastName;
    private CityDomain cityOfResidence;
    private String email;
    private String mobileNumber;
    private boolean emailConfirmed;
    private boolean mobileConfirmed;

    public UserDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setIdType(new IdTypeDomain());
        setIdNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setMiddleName(TextHelper.getDefault());
        setFirstLastName(TextHelper.getDefault());
        setSecondLastName(TextHelper.getDefault());
        setCityOfResidence(new CityDomain());
        setEmail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        setEmailConfirmed(false);
        setMobileConfirmed(false);
    }

    public UserDomain(final UUID id, final IdTypeDomain idType, final String idNumber,
                      final String firstName, final String middleName,
                      final String firstLastName, final String secondLastName,
                      final CityDomain cityOfResidence, final String email,
                      final String mobileNumber, final boolean emailConfirmed,
                      final boolean mobileConfirmed) {
        super(UUIDHelper.getUUIDHelper().getDefault(id));
        setIdType(idType);
        setIdNumber(idNumber);
        setFirstName(firstName);
        setMiddleName(middleName);
        setFirstLastName(firstLastName);
        setSecondLastName(secondLastName);
        setCityOfResidence(cityOfResidence);
        setEmail(email);
        setMobileNumber(mobileNumber);
        setEmailConfirmed(emailConfirmed);
        setMobileConfirmed(mobileConfirmed);
    }

    public UserDomain(final UUID id) {
        super(UUIDHelper.getUUIDHelper().getDefault(id));
        setIdType(new IdTypeDomain());
        setIdNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setMiddleName(TextHelper.getDefault());
        setFirstLastName(TextHelper.getDefault());
        setSecondLastName(TextHelper.getDefault());
        setCityOfResidence(new CityDomain());
        setEmail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        setEmailConfirmed(false);
        setMobileConfirmed(false);
    }

    public UserDomain(UUID id, String firstName, String email) {
        super(UUIDHelper.getUUIDHelper().getDefault(id));
        setFirstName(firstName);
        setEmail(email);
    }


    public IdTypeDomain getIdType() {
        return idType;
    }

    public void setIdType(final IdTypeDomain idType) {
        this.idType = (idType == null) ? new IdTypeDomain() : idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(final String idNumber) {
        this.idNumber = TextHelper.getDefaultWithTrim(idNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = TextHelper.getDefaultWithTrim(firstName);
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(final String middleName) {
        this.middleName = TextHelper.getDefaultWithTrim(middleName);
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(final String firstLastName) {
        this.firstLastName = TextHelper.getDefaultWithTrim(firstLastName);
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(final String secondLastName) {
        this.secondLastName = TextHelper.getDefaultWithTrim(secondLastName);
    }

    public CityDomain getCityOfResidence() {
        return cityOfResidence;
    }

    public void setCityOfResidence(final CityDomain cityOfResidence) {
        this.cityOfResidence = (cityOfResidence == null) ? new CityDomain() : cityOfResidence;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = TextHelper.getDefaultWithTrim(email);
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(final String mobileNumber) {
        this.mobileNumber = TextHelper.getDefaultWithTrim(mobileNumber);
    }

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(final boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public boolean isMobileConfirmed() {
        return mobileConfirmed;
    }

    public void setMobileConfirmed(final boolean mobileConfirmed) {
        this.mobileConfirmed = mobileConfirmed;
    }
}
