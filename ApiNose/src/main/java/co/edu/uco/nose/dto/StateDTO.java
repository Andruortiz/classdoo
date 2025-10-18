package co.edu.uco.nose.dto;

import java.util.UUID;

public class StateDTO {

    private UUID id;
    private String name;
    private CountryDTO country;

    public StateDTO() {
        super();
        this.id = UUID.randomUUID();
        this.name = "";
        this.country = new CountryDTO();
    }

    public StateDTO(UUID id, String name, CountryDTO country) {
        super();
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public static StateDTO build() {
        return new StateDTO();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

}
