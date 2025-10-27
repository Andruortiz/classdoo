package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class UserEntity {

    private UUID id;
    private IdTypeEntity idType;
    private String idNumber;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private CityEntity homeCity;
    private String email;
    private String mobileNumber;
    private boolean emailConfirmed;
    private boolean mobileNumberConfirmed;
    private boolean emailConfirmedIsDefaultValue;
    private boolean mobileNumberConfirmedIsDefaultValue;

    public UserEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setIdType(new IdTypeEntity());
        setIdNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setHomeCity(new CityEntity());
        setEmail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        setEmailConfirmed(false);
        setEmailConfirmedIsDefaultValue(true);
        setMobileNumberConfirmed(false);
        setMobileNumberConfirmedIsDefaultValue(true);
    }

    public UserEntity(final UUID id) {
        setId(id);
        setIdType(new IdTypeEntity());
        setIdNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setHomeCity(new CityEntity());
        setEmail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        setEmailConfirmed(false);
        setEmailConfirmedIsDefaultValue(true);
        setMobileNumberConfirmed(false);
        setMobileNumberConfirmedIsDefaultValue(true);
    }

    public UserEntity(final UUID id, final IdTypeEntity idType, final String idNumber, final String firstName,
                      final String secondName, final String firstSurname, final String secondSurname, final CityEntity homeCity,
                      final String email, final String mobileNumber, final boolean emailConfirmed,
                      final boolean mobileNumberConfirmed) {
        setId(id);
        setIdType(idType);
        setIdNumber(idNumber);
        setFirstName(firstName);
        setSecondName(secondName);
        setFirstSurname(firstSurname);
        setSecondSurname(secondSurname);
        setHomeCity(homeCity);
        setEmail(email);
        setMobileNumber(mobileNumber);
        setEmailConfirmed(emailConfirmed);
        setMobileNumberConfirmed(mobileNumberConfirmed);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public IdTypeEntity getIdType() {
        return idType;
    }

    public void setIdType(final IdTypeEntity idType) {
        this.idType = ObjectHelper.getDefault(idType, new IdTypeEntity());
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(final String secondName) {
        this.secondName = TextHelper.getDefaultWithTrim(secondName);
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(final String firstSurname) {
        this.firstSurname = TextHelper.getDefaultWithTrim(firstSurname);
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(final String secondSurname) {
        this.secondSurname = TextHelper.getDefaultWithTrim(secondSurname);
    }

    public CityEntity getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(final CityEntity homeCity) {
        this.homeCity = ObjectHelper.getDefault(homeCity, new CityEntity());
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
        setEmailConfirmedIsDefaultValue(false);
    }

    public boolean isMobileNumberConfirmed() {
        return mobileNumberConfirmed;
    }

    public void setMobileNumberConfirmed(final boolean mobileNumberConfirmed) {
        this.mobileNumberConfirmed = mobileNumberConfirmed;
        setMobileNumberConfirmedIsDefaultValue(false);
    }

    public boolean isEmailConfirmedIsDefaultValue() {
        return emailConfirmedIsDefaultValue;
    }

    private void setEmailConfirmedIsDefaultValue(final boolean emailConfirmedIsDefaultValue) {
        this.emailConfirmedIsDefaultValue = emailConfirmedIsDefaultValue;
    }

    public boolean isMobileNumberConfirmedIsDefaultValue() {
        return mobileNumberConfirmedIsDefaultValue;
    }

    private void setMobileNumberConfirmedIsDefaultValue(final boolean mobileNumberConfirmedIsDefaultValue) {
        this.mobileNumberConfirmedIsDefaultValue = mobileNumberConfirmedIsDefaultValue;
    }
}