package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.IdTypeDomain;
import co.edu.uco.nose.entity.IdTypeEntity;

public final class IdTypeEntityAssembler implements EntityAssembler<IdTypeEntity, IdTypeDomain> {
    @Override
    public IdTypeEntity toDTO(IdTypeDomain domain) {
        return null;
    }

    @Override
    public IdTypeDomain toDomain(IdTypeEntity entity) {
        return null;
    }
}
