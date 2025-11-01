package co.edu.uco.nose.business.business.impl;

import co.edu.uco.nose.business.assembler.entity.impl.UserEntityAssembler;
import co.edu.uco.nose.business.business.UserBusiness;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;
import co.edu.uco.nose.data.factory.DAOFactory;
import co.edu.uco.nose.entity.IdTypeEntity;
import co.edu.uco.nose.entity.UserEntity;

import java.util.List;
import java.util.UUID;

import static co.edu.uco.nose.crosscuting.messagecatalog.MessagesEnum.*;

public final  class UserBusinessImpl implements UserBusiness {

    private DAOFactory daoFactory;

    public UserBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void registerNewUserInformation(UserDomain userDomain) {

        var id = UUIDHelper.getUUIDHelper().generateNewUUID();
        var userEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);

        userEntity.setId(id);

        daoFactory.getUserDAO().create(userEntity);
    }

    private void validateUserDomain(UserDomain user) {
        if (user == null) throw new IllegalArgumentException("El usuario no puede ser nulo");
        if (user.getEmail() == null || !user.getEmail().matches(".+@.+\\..+")) {
            throw new IllegalArgumentException("Email inválido");
        }
        if (user.getMobileNumber() == null || user.getMobileNumber().length() != 10) {
            throw new IllegalArgumentException("Número de teléfono inválido");
        }
    }

    private void checkUserUniqueness(UserDomain user) {
        var userDAO = daoFactory.getUserDAO();

        // Tipo de identificación + número
        var filterById = new UserEntity();
        filterById.setIdType(new IdTypeEntity(user.getIdType().getId()));
        filterById.setIdNumber(user.getIdNumber());
        if (!userDAO.findByFilter(filterById).isEmpty()) {
            throw NoseException.create(VALIDATION_ID_DUPLICATED.getTitle(),
                    VALIDATION_ID_DUPLICATED.getContent());
        }

        // Correo electrónico
        var filterByEmail = new UserEntity();
        filterByEmail.setEmail(user.getEmail());
        if (!userDAO.findByFilter(filterByEmail).isEmpty()) {
            throw NoseException.create(VALIDATION_EMAIL_DUPLICATED.getTitle(),
                    VALIDATION_EMAIL_DUPLICATED.getContent());
        }

        // Número de teléfono
        var filterByPhone = new UserEntity();
        filterByPhone.setMobileNumber(user.getMobileNumber());
        if (!userDAO.findByFilter(filterByPhone).isEmpty()) {
            throw NoseException.create(VALIDATION_PHONE_DUPLICATED.getTitle(),
                    VALIDATION_PHONE_DUPLICATED.getContent());
        }
    }



    @Override
    public void dropUserInformation(UUID id) {
        try {
            daoFactory.getUserDAO().delete(id);
        } catch (Exception exception) {
            throw NoseException.create(exception, TECHNICAL_ERROR_UNEXPECTED_DELETE.getTitle(),
                    TECHNICAL_ERROR_UNEXPECTED_DELETE.getContent());
        }
    }


    @Override
    public void updateUserInformation(UUID id, UserDomain userDomain) {
        try {
            validateUserDomain(userDomain);
            UserEntity userEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);
            userEntity.setId(id);
            daoFactory.getUserDAO().update(userEntity);
        } catch (Exception exception) {
            throw NoseException.create(exception, TECHNICAL_ERROR_UNEXPECTED_UPDATE.getTitle(),
                    TECHNICAL_ERROR_UNEXPECTED_UPDATE.getContent());
        }
    }


    @Override
    public List<UserDomain> findAllUser() {
        try {
            var entities = daoFactory.getUserDAO().findAll();
            return UserEntityAssembler.getUserEntityAssembler().toDomainList(entities);
        } catch (Exception exception) {
            throw NoseException.create(exception, TECHNICAL_ERROR_FIND_ALL_UNEXPECTED.getTitle(),
                    TECHNICAL_ERROR_FIND_ALL_UNEXPECTED.getContent());
        }
    }


    @Override
    public List<UserDomain> findAlluser() {
        try {
            var entities = daoFactory.getUserDAO().findAll();
            return UserEntityAssembler.getUserEntityAssembler().toDomainList(entities);
        } catch (Exception exception) {
            throw NoseException.create(exception, USER_ERROR_FIND_ALL_UNEXPECTED.getContent(),
                    TECHNICAL_ERROR_FIND_ALL_UNEXPECTED.getContent());
        }
    }

    @Override
    public List<UserDomain> findUserByFilter(UserEntity userFilters) {
        try {
            var entities = daoFactory.getUserDAO().findByFilter(userFilters);
            return UserEntityAssembler.getUserEntityAssembler().toDomainList(entities);
        } catch (Exception exception) {
            throw NoseException.create(exception, USER_ERROR_FIND_BY_FILTER_UNEXPECTED.getContent(),
                    TECHNICAL_ERROR_FIND_BY_FILTER_UNEXPECTED.getContent());
        }
    }


    @Override
    public UserDomain findSpecificUser(UUID id) {
        try {
            UserEntity entity = daoFactory.getUserDAO().findById(id);
            return entity == null ? null : UserEntityAssembler.getUserEntityAssembler().toDomain(entity);
        } catch (Exception exception) {
            throw NoseException.create(exception, USER_ERROR_FIND_BY_ID_UNEXPECTED.getContent(),
                    TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED.getContent());
        }
    }


    @Override
    public void confirmMobileNumber(UUID id, int confirmationCode) {


    }

    @Override
    public void confirmEmail(UUID id) {
       }

    @Override
    public void sendMobileNumberConfirmation(UUID id) {

    }

    @Override
    public void sendEmailConfirmation(UUID id) {

    }

}
