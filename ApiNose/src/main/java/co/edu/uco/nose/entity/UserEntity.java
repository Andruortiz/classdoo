package co.edu.uco.nose.entity;

import java.util.UUID;

public final class UserEntity {

    private UUID id;
    private IdTypeEntity idType;
    private String identificationNumber;
    private String firstName;
    private String middleName;
    private String firstLastName;
    private String secondLastName;
    private CityEntity residenceCity;
    private String email;
    private String mobileNumber;
    private boolean emailConfirmed;
    private boolean mobileNumberConfirmed;

    public UserEntity() {
    }

    public UserEntity(final UUID id, final IdTypeEntity idType, final String identificationNumber, final String firstName,
                      final String middleName, final String firstLastName, final String secondLastName,
                      final CityEntity residenceCity, final String email, final String mobileNumber,
                      final boolean emailConfirmed, final boolean mobileNumberConfirmed) {
        this.id = id;
        this.idType = idType;
        this.identificationNumber = identificationNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.residenceCity = residenceCity;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.emailConfirmed = emailConfirmed;
        this.mobileNumberConfirmed = mobileNumberConfirmed;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public IdTypeEntity getIdType() {
        return idType;
    }

    public void setIdType(final IdTypeEntity idType) {
        this.idType = idType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(final String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(final String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(final String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public CityEntity getResidenceCity() {
        return residenceCity;
    }

    public void setResidenceCity(final CityEntity residenceCity) {
        this.residenceCity = residenceCity;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(final String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(final boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public boolean isMobileNumberConfirmed() {
        return mobileNumberConfirmed;
    }

    public void setMobileNumberConfirmed(final boolean mobileNumberConfirmed) {
        this.mobileNumberConfirmed = mobileNumberConfirmed;
    }
}
