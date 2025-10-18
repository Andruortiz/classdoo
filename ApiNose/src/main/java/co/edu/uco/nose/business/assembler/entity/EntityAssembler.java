package co.edu.uco.nose.business.assembler.entity;

import co.edu.uco.nose.business.domain.CountryDomain;
import co.edu.uco.nose.entity.Entity;
import co.edu.uco.nose.entity.UserEntity;

public interface EntityAssembler<E, D> {

    E toDTO(D  domain);
    D toDomain(E entity);

}
