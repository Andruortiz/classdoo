package co.edu.uco.nose.business.assembler.dto.impl;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.CityDomain;
import co.edu.uco.nose.business.domain.CountryDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.CityDTO;
import co.edu.uco.nose.dto.CountryDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static co.edu.uco.nose.business.assembler.dto.impl.StateDTOAssembler.getStateDTOAssembler;

public final  class CityDTOAssembler implements DTOAssembler<CityDTO, CityDomain> {


    private static final DTOAssembler<CityDTO, CityDomain> instance =
            new CityDTOAssembler();

    private CityDTOAssembler(){

    }

    public static DTOAssembler<CityDTO, CityDomain> getCityDTOAssembler(){
        return instance;
    }


    @Override
    public CityDTO toDTO(CityDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new CityDomain(UUIDHelper.getUUIDHelper().getDefault()));
        var stateDTO = getStateDTOAssembler().toDTO(domainTmp.getState());
        return new CityDTO(domainTmp.getId(), stateDTO, domainTmp.getName());
    }

    @Override
    public CityDomain toDomain(CityDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new CityDTO());
        var stateDomain = getStateDTOAssembler().toDomain(dtoTmp.getState());
        return new CityDomain(dtoTmp.getId(), stateDomain, dtoTmp.getName());
    }

    @Override
    public List<CityDTO> toDTO(List<CityDomain> domainList) {
        var dtoList = new ArrayList<CityDTO>();
        for (var domain : ObjectHelper.getDefault(domainList, List.<CityDomain>of())) {
            dtoList.add(toDTO(domain));
        }
        return dtoList;
    }
}
