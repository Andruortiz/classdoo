package co.edu.uco.nose.business.assembler.dto.impl;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.CountryDomain;
import co.edu.uco.nose.business.domain.IdTypeDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.CityDTO;
import co.edu.uco.nose.dto.CountryDTO;
import co.edu.uco.nose.dto.IdTypeDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final  class IdTypeDTOAssembler implements DTOAssembler<IdTypeDTO, IdTypeDomain> {

    private static final DTOAssembler<IdTypeDTO, IdTypeDomain> instance =
            new IdTypeDTOAssembler();

    private IdTypeDTOAssembler(){


    }

    public static DTOAssembler<IdTypeDTO, IdTypeDomain> getIdTypeDTOAssembler(){
        return instance;
    }

    @Override
    public IdTypeDTO toDTO(IdTypeDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new IdTypeDomain(UUIDHelper.getUUIDHelper().getDefault()));
        return new IdTypeDTO(domainTmp.getId(), domainTmp.getName());
    }

    @Override
    public IdTypeDomain toDomain(IdTypeDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new IdTypeDTO());
        return new IdTypeDomain(dtoTmp.getId(), dtoTmp.getName());
    }

    @Override
    public List<IdTypeDTO> toDTO(final List<IdTypeDomain> domainList) {
        var dtoList = new ArrayList<IdTypeDTO>();
        for (var domain : ObjectHelper.getDefault(domainList, List.<IdTypeDomain>of())) {
            dtoList.add(toDTO(domain));
        }
        return dtoList;
    }
}
