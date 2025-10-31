package co.edu.uco.nose.business.facade.impl;

import co.edu.uco.nose.business.assembler.dto.impl.UserDTOAssembler;
import co.edu.uco.nose.business.business.impl.UserBusinessImpl;
import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.business.facade.UserFacade;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.messagecatalog.MessagesEnum;
import co.edu.uco.nose.data.factory.DAOFactory;
import co.edu.uco.nose.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public final class UserFacadeImpl implements UserFacade {


    @Override
    public void registerNewUserInformation(final UserDTO userDTO) {
        var daoFactory = DAOFactory.getFactory();
        var business = new UserBusinessImpl(daoFactory);
        try{
            daoFactory.initTransaction();

            var domain = UserDTOAssembler.getUserDTOAssembler().toDomain(userDTO);
            business.registerNewUserInformation(domain);

            daoFactory.commitTransaction();

        }catch (final NoseException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_UNEXPECTED_CREATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_CREATE.getContent()
            );
        } catch (final Throwable exception) {
            daoFactory.rollbackTransaction();
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_CRITICAL_CREATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_CRITICAL_CREATE.getContent()
            );
        } finally {
            daoFactory.closeConnection();
        }

    }

    @Override
    public void dropUserInformation(final UUID id) {
        var daoFactory = DAOFactory.getFactory();
        var business = new UserBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();

            business.dropUserInformation(id);

            daoFactory.commitTransaction();

        } catch (final NoseException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_UNEXPECTED_DELETE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_DELETE.getContent()
            );
        } catch (final Throwable exception) {
            daoFactory.rollbackTransaction();
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_CRITICAL_DELETE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_CRITICAL_DELETE.getContent()
            );
        } finally {
            daoFactory.closeConnection();
        }
    }


    @Override
    public void updateUserInformation(UUID id, UserDTO userDTO) {
        var daoFactory = DAOFactory.getFactory();
        var business = new UserBusinessImpl(daoFactory);

        try {
            daoFactory.initTransaction();

            var userDomain = UserDTOAssembler.getUserDTOAssembler().toDomain(userDTO);
            business.updateUserInformation(id, userDomain);

            daoFactory.commitTransaction();

        } catch (final NoseException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_UNEXPECTED_UPDATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_UPDATE.getContent()
            );
        } catch (final Throwable exception) {
            daoFactory.rollbackTransaction();
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_CRITICAL_UPDATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_CRITICAL_UPDATE.getContent()
            );
        } finally {
            daoFactory.closeConnection();
        }

    }

    @Override
    public List<UserDTO> findAllUser() {
        var daoFactory = DAOFactory.getFactory();
        var business = new UserBusinessImpl(daoFactory);

        try {
            List<UserDomain> domainList = business.findAllUser();
            List<UserDTO> dtoList = UserDTOAssembler.getUserDTOAssembler().toDTO(domainList);
            return dtoList;

        } catch (final NoseException exception) {
            throw exception;
        } catch (final Exception exception) {
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_UNEXPECTED_FIND_ALL.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_FIND_ALL.getContent()
            );
        } catch (final Throwable exception) {
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_CRITICAL_FIND_ALL.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_CRITICAL_FIND_ALL.getContent()
            );
        } finally {
            daoFactory.closeConnection();
        }
    }


    @Override
    public List<UserDTO> findUserByFilter(UserDTO userFilters) {
        return List.of();
    }

    @Override
    public UserDTO findSpecificUser(UUID id) {
        var daoFactory = DAOFactory.getFactory();
        var business = new UserBusinessImpl(daoFactory);

        try {
            var domain = business.findSpecificUser(id);


            return ObjectHelper.isNull(domain) ? new UserDTO() : UserDTOAssembler.getUserDTOAssembler().toDTO(domain);

        } catch (final NoseException exception) {
            throw exception;
        } catch (final Exception exception) {
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_FIND_BY_ID_UNEXPECTED.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED.getContent()
            );
        } catch (final Throwable exception) {
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_FIND_BY_ID_CRITICAL.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_FIND_BY_ID_CRITICAL.getContent()
            );
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void confirmMobileNumber(UUID userId, int confirmationCode) {

    }

    @Override
    public void confirmEmail(UUID userid, int confirmationCode) {

    }

    @Override
    public void sendMobileNumberConfirmation(UUID userId) {

    }

    @Override
    public void sendEmailConfirmation(UUID userId) {

    }
}
