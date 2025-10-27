package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class CityDTO {

    private UUID id;
    private StateDTO state;
    private String name;

    public CityDTO() {
        setId(UUIDHelper.getUUIDHelper().getDefault());
        setState(new StateDTO());
        setName(TextHelper.getDefault());
    }

    public CityDTO(final UUID id) {
        setId(id);
        setState(new StateDTO());
        setName(TextHelper.getDefault());
    }

    public CityDTO(final UUID id, final StateDTO state, final String name) {
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

    public StateDTO getState() {
        return state;
    }

    public void setState(final StateDTO state) {
        this.state = ObjectHelper.getDefault(state, new StateDTO());
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }
}