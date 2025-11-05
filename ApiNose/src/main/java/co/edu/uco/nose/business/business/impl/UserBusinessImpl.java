package co.edu.uco.nose.business.business.impl;

import co.edu.uco.nose.business.assembler.entity.impl.UserEntityAssembler;
import co.edu.uco.nose.business.business.UserBusiness;
import co.edu.uco.nose.business.business.validator.idtype.ValidateIdTypeExistsById;
import co.edu.uco.nose.business.business.validator.user.ValidateDataUserConsistencyForRegisterNewInformation;
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
// 1. Validar que la informacion sea consistente a nivel de Tipo de Dato,
        //longitud, obligatoriedad, formato, rango, reglas propias del objeto
        ValidateDataUserConsistencyForRegisterNewInformation.executeValidation(userDomain);

        // 2. Validar que exista tipo de identificacion
        ValidateIdTypeExistsById.executeValidation(userDomain.getIdType().getId(), daoFactory);



        // 7. Ensamblar  objeto como Entity
        var userEntity = UserEntityAssembler.getUserEntityAssembler().toEntity(userDomain);

        // 8. Generar ID
        userEntity.setId(generateId());

        // 9. Registrar la informacion del nuevo usuario
        daoFactory.getUserDAO().create(userEntity);
    }

    private UUID generateId() {
        var id = UUIDHelper.getUUIDHelper().generateNewUUID();
        var UserEntity = daoFactory.getUserDAO().findById(id);

        while (!UUIDHelper.getUUIDHelper().isDefaultUUID(UserEntity.getId())) {
            id = UUIDHelper.getUUIDHelper().generateNewUUID();
            UserEntity  = daoFactory.getUserDAO().findById(id);
        }
        return id;
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
            System.out.println("➡️ Entrando a findAllUser()...");
            var userDAO = daoFactory.getUserDAO();

            System.out.println("➡️ Ejecutando findAll() del UserDAO...");
            var entities = userDAO.findAll();
            System.out.println("✅ Cantidad de entidades obtenidas: " + (entities != null ? entities.size() : 0));

            System.out.println("➡️ Convirtiendo entidades a dominio...");
            var domains = UserEntityAssembler.getUserEntityAssembler().toDomainList(entities);
//            System.out.println("✅ Conversión exitosa. Cantidad: " + domains.size());

            return domains;

        } catch (Exception exception) {
            exception.printStackTrace();
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
