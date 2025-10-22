package co.edu.uco.nose.business.assembler.dto.impl;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.IdTypeDomain;
import co.edu.uco.nose.dto.IdTypeDTO;

import java.util.List;

public final  class IdTypeDTOAssembler implements DTOAssembler<IdTypeDTO, IdTypeDomain> {


    @Override
    public List toDTO(List domaindList) {
        return List.of();
    }

    @Override
    public IdTypeDTO toDTO(IdTypeDomain domain) {
        return null;
    }

    @Override
    public IdTypeDomain toDomain(IdTypeDTO dto) {
        return null;
    }
}
