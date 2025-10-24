package co.edu.uco.nose.business.assembler.dto.impl;

import co.edu.uco.nose.business.assembler.dto.DTOAssembler;
import co.edu.uco.nose.business.domain.CountryDomain;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.dto.CountryDTO;
import co.edu.uco.nose.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public final class UserDTOAssembler implements DTOAssembler<UserDTO, UserDomain> {



    private static final DTOAssembler<UserDTO, UserDomain> instance =
            new UserDTOAssembler();

    private UserDTOAssembler(){
    }

    public static DTOAssembler<UserDTO, UserDomain> getUserDTOAssembler(){
        return instance;}

    @Override
    public UserDTO toDTO(UserDomain domain) {
        var domainTmp = ObjectHelper.getDefault(domain, new UserDomain());
        return new UserDTO(domainTmp.getId(), domainTmp.getFirstName());

    }

    @Override
    public UserDomain toDomain(UserDTO dto) {
        var dtoTmp = ObjectHelper.getDefault(dto, new UserDTO());
        return new UserDomain(dtoTmp.getId(),
                dtoTmp.getFirstName(),
                dtoTmp.getEmail());

    }

    @Override
    public List<UserDTO> toDTO(List<UserDomain> domaindList) {

        var userDtoList = new ArrayList<UserDTO>();
        for (var userDomain: domaindList){
            userDtoList.add(toDTO(userDomain));
        }
        return userDtoList;
    }
}
