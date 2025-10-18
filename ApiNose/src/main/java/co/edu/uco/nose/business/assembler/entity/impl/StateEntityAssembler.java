package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.StateDomain;
import co.edu.uco.nose.entity.StateEntity;

public final class StateEntityAssembler implements EntityAssembler<StateEntity, StateDomain> {
    @Override
    public StateEntity toDTO(StateDomain domain) {
        return null;
    }

    @Override
    public StateDomain toDomain(StateEntity entity) {
        return null;
    }
}
