package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.CountryDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.CountryEntity;

public final  class CountryEntityAssembler implements EntityAssembler<CountryEntity, CountryDomain> {

    @Override
    public CountryEntity toDTO(final CountryDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new CountryDomain(UUIDHelper.getUUIDHelper()))
        return new CountryEntity(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public CountryDomain TODomain(final CountryEntity Entity) {
        var dtoTmp = ObjectHelper.getDefault(Entity, new CountryEntity())
        return new CountryEntity(dtoTmp.getId(), dtoTmp.getName());
    }

}
