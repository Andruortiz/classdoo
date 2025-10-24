package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.UserEntity;

public final class UserEntityAssembler implements EntityAssembler<UserEntity, UserDomain> {

    private static final UserEntityAssembler INSTANCE = new UserEntityAssembler();

    private UserEntityAssembler() {}

    public static UserEntityAssembler getUserEntityAssembler() {
        return INSTANCE;
    }

    @Override
    public UserEntity toEntity(final UserDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new UserEntity( domainTmp.getId());
    }

    @Override
    public UserDomain toDomain(final UserEntity Entity) {
        var entityTmp  = ObjectHelper.getDefault(Entity, new UserEntity());
        return new UserDomain( entityTmp.getId(),
                entityTmp.getFirstName(),
                entityTmp.getEmail());
    }
}


