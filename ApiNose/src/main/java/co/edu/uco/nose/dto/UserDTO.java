package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class UserDTO {

    private UUID id;
    private IdTypeDTO idType;
    private String idNumber;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private CityDTO homeCity;
    private String email;
    private String mobileNumber;
    private boolean emailConfirmed;
    private boolean mobileNumberConfirmed;

    public UserDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setIdType(new IdTypeDTO());
        setIdNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setHomeCity(new CityDTO());
        setEmail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        setEmailConfirmed(false);
        setMobileNumberConfirmed(false);
    }

    public UserDTO(final UUID id) {
        setId(id);
        setIdType(new IdTypeDTO());
        setIdNumber(TextHelper.getDefault());
        setFirstName(TextHelper.getDefault());
        setSecondName(TextHelper.getDefault());
        setFirstSurname(TextHelper.getDefault());
        setSecondSurname(TextHelper.getDefault());
        setHomeCity(new CityDTO());
        setEmail(TextHelper.getDefault());
        setMobileNumber(TextHelper.getDefault());
        setEmailConfirmed(false);
        setMobileNumberConfirmed(false);
    }

    public UserDTO(final UUID id, final IdTypeDTO idType, final String idNumber, final String firstName,
                   final String secondName, final String firstSurname, final String secondSurname, final CityDTO homeCity,
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

    public IdTypeDTO getIdType() {
        return idType;
    }

    public void setIdType(final IdTypeDTO idType) {
        this.idType = ObjectHelper.getDefault(idType, new IdTypeDTO());
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

    public CityDTO getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(final CityDTO homeCity) {
        this.homeCity = ObjectHelper.getDefault(homeCity, new CityDTO());
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

    public boolean isMobileNumberConfirmed() {
        return mobileNumberConfirmed;
    }

    public void setMobileNumberConfirmed(final boolean mobileNumberConfirmed) {
        this.mobileNumberConfirmed = mobileNumberConfirmed;
    }
}