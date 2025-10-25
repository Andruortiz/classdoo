package co.edu.uco.nose.business.assembler.entity.impl;

import co.edu.uco.nose.business.assembler.entity.EntityAssembler;
import co.edu.uco.nose.business.domain.StateDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.entity.StateEntity;

public final class StateEntityAssembler implements EntityAssembler<StateEntity, StateDomain> {

    private static final StateEntityAssembler INSTANCE = new StateEntityAssembler();

    private StateEntityAssembler() {}

    public static StateEntityAssembler getInstance() {
        return  INSTANCE;
    }


    @Override
    public StateEntity toEntity(StateDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new StateDomain());

        return new StateEntity(
                UUIDHelper.getUUIDHelper().getDefault(domainTmp.getId()),
                TextHelper.getDefaultWithTrim(domainTmp.getName())
        );
    }

    @Override
    public StateDomain toDomain(StateEntity entity) {
        var entityTmp = ObjectHelper.getDefault(entity, new StateEntity());
        var countryDomain = CountryEntityAssembler.getCountryEntityAssembler().toDomain(entityTmp.getCountry());

        return new StateDomain(
                UUIDHelper.getUUIDHelper().getDefault(entityTmp.getId()),
                countryDomain,
                TextHelper.getDefaultWithTrim(entityTmp.getName())
        );
    }
}
