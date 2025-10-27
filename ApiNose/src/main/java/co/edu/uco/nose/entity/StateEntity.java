package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class StateEntity {

    private UUID id;
    private CountryEntity country;
    private String name;

    public StateEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setCountry(new CountryEntity());
        setName(TextHelper.getDefault());
    }

    public StateEntity(final UUID id) {
        setId(id);
        setCountry(new CountryEntity());
        setName(TextHelper.getDefault());
    }

    public StateEntity(final UUID id, final CountryEntity country, final String name) {
        setId(id);
        setCountry(country);
        setName(name);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(final CountryEntity country) {
        this.country = ObjectHelper.getDefault(country, new CountryEntity());
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
}