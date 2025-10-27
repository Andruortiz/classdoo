package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class CityEntity {

    private UUID id;
    private StateEntity state;
    private String name;

    public CityEntity() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setState(new StateEntity());
        setName(TextHelper.getDefault());
    }

    public CityEntity(final UUID id) {
        setId(id);
        setState(new StateEntity());
        setName(TextHelper.getDefault());
    }

    public CityEntity(final UUID id, final StateEntity state, final String name) {
        setId(id);
        setState(state);
        setName(name);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = UUIDHelper.getUUIDHelper().getDefault(id);
    }

    public StateEntity getState() {
        return state;
    }

    public void setState(final StateEntity state) {
        this.state = ObjectHelper.getDefault(state, new StateEntity());
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
}