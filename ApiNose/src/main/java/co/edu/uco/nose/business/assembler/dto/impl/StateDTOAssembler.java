package co.edu.uco.nose.business.assembler.dto.impl;


import static co.edu.uco.nose.business.assembler.dto.impl.CountryDTOAssembler.getCountryDTOAssembler;
import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.StateDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class StateDTOAssembler extends DTOAssembler<StateDTO, StateDomain> {
    @Override
    public StateDTO toDTO(final StateDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new StateDomain(UUIDHelper.getUUIDHelper()))
        var countryTmp = CountryDTOAssembler.getCountryDTOAssembler().toDTO(domainTmp.getId(), countryDtoTmp, domainTmp.getCountry())

        return new StateDTO(domainTmp.getId(), domainTmp.getName());

    }

    @Override
    public StateDomain toDomain(final StateDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new StateDTO());
        var countryDomainTmp = CountryDTOAssembler.getCountryDTOAssembler().toDomain(dtoTmp.getCountry())
        return new StateDomain(dtoTmp.getId(), dtoTmp.getName());
    }

}
