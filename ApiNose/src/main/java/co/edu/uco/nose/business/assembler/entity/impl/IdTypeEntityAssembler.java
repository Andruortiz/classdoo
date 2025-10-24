package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.IdTypeDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.IdTypeEntity;

public final class IdTypeEntityAssembler implements EntityAssembler<IdTypeEntity, IdTypeDomain> {

    private static final IdTypeEntityAssembler INSTANCE = new IdTypeEntityAssembler();

    private IdTypeEntityAssembler() {}

    public static IdTypeEntityAssembler getInstance() {
        return INSTANCE;
    }


    @Override
    public IdTypeEntity toEntity(IdTypeDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new IdTypeDomain());
        return new IdTypeEntity(
                UUIDHelper.getUUIDHelper().getDefault(domainTmp.getId()),
                TextHelper.getDefaultWithTrim(domainTmp.getName())
        );
    }

    @Override
    public IdTypeDomain toDomain(IdTypeEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new IdTypeEntity());
        return new IdTypeDomain(
                UUIDHelper.getUUIDHelper().getDefault(entityTmp.getId()),
                TextHelper.getDefaultWithTrim(entityTmp.getName())
        );
    }
}
