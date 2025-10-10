package co.edu.uco.nose.entity;

import java.util.UUID;

public final class IdTypeEntity {

    private UUID id;
    private String name;

    public IdTypeEntity() {
    }

    public IdTypeEntity(final UUID id, final String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
}
