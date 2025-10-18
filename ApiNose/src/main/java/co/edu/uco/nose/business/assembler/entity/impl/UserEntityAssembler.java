package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.CountryDomain;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.CountryEntity;
import co.edu.uco.nose.entity.UserEntity;

public final class UserEntityAssembler extends EntityAssembler<UserEntity, UserDomain> {

    public static Object getUserEntityAssembler() {
    }

    @Override
    public UserEntity toDTO(final CountryDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new UserDomain(UUIDHelper.getUUIDHelper()))
        return new UserEntity(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public UserDomain TODomain(final CountryEntity Entity) {
        var dtoTmp = ObjectHelper.getDefault(Entity, new UserEntity())
        return new UserEntity(dtoTmp.getId(), dtoTmp.getName());
    }


    @Override
    public UserEntity toDTO(UserDomain domain) {
        return null;
    }

    @Override
    public UserDomain toDomain(UserEntity entity) {
        return null;
    }
}
