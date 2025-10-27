package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class CityDomain extends Domain {

    private String name;
    private StateDomain state;

    public CityDomain() {
        super(UUIDHelper.getUUIDHelper().getDefault());
        setName(TextHelper.getDefault());
        setState(new StateDomain());
    }

    public CityDomain(final UUID id, final StateDomain state, final String name) {
        super(id);
        setState(state);
        setName(name);
    }

    public CityDomain(final UUID id) {
        super(id);
        setState(new StateDomain());
        setName(TextHelper.getDefault());
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = TextHelper.getDefaultWithTrim(name);
    }

    public StateDomain getState() {
        return state;
    }

    public void setState(final StateDomain state) {
        this.state = ObjectHelper.getDefault(state, new StateDomain());
    }
}
