package co.edu.uco.nose.entity;

import java.util.UUID;

public final class CityEntity {

    private UUID id;
    private StateEntity state;
    private String name;

    public CityEntity() {
    }

    public CityEntity(final UUID id, final StateEntity state, final String name) {
        this.id = id;
        this.state = state;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public StateEntity getState() {
        return state;
    }

    public void setState(final StateEntity state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
