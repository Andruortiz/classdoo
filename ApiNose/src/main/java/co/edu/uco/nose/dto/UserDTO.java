package co.edu.uco.nose.dto;

import java.util.UUID;

public class UserDTO {

    private UUID id;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private String identification;
    private CityDTO residenceCity;
    private IdTypeDTO idType;
    private String email;
    private String phoneNumber;
    private boolean emailConfirmed;
    private boolean mobileNumberConfirmed;

    public UserDTO() {
        super();
        this.id = UUID.randomUUID();
        this.firstName = "";
        this.secondName = "";
        this.firstLastName = "";
        this.secondLastName = "";
        this.identification = "";
        this.residenceCity = new CityDTO();
        this.idType = new IdTypeDTO();
        this.email = "";
        this.phoneNumber = "";
        this.emailConfirmed = false;
        this.mobileNumberConfirmed = false;
    }

    public UserDTO(UUID id, String firstName, String secondName, String firstLastName, String secondLastName,
                   String identification, CityDTO residenceCity, IdTypeDTO idType, String email,
                   String phoneNumber, boolean emailConfirmed, boolean mobileNumberConfirmed) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.identification = identification;
        this.residenceCity = residenceCity;
        this.idType = idType;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.emailConfirmed = emailConfirmed;
        this.mobileNumberConfirmed = mobileNumberConfirmed;
    }

    public static UserDTO build() {
        return new UserDTO();
    }

    // Getters y Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public CityDTO getResidenceCity() {
        return residenceCity;
    }

    public void setResidenceCity(CityDTO residenceCity) {
        this.residenceCity = residenceCity;
    }

    public IdTypeDTO getIdType() {
        return idType;
    }

    public void setIdType(IdTypeDTO idType) {
        this.idType = idType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    public boolean isMobileNumberConfirmed() {
        return mobileNumberConfirmed;
    }

    public void setMobileNumberConfirmed(boolean mobileNumberConfirmed) {
        this.mobileNumberConfirmed = mobileNumberConfirmed;
    }
}
