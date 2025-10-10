package co.edu.uco.nose.entity;

import java.util.UUID;

public final class StateEntity {

    private UUID id;
    private CountryEntity country;
    private String name;

    public StateEntity() {
    }

    public StateEntity(final UUID id, final CountryEntity country, final String name) {
        this.id = id;
        this.country = country;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(final CountryEntity country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
