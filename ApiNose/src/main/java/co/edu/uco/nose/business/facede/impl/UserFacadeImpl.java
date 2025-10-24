package co.edu.uco.nose.business.facede.impl;

import co.edu.uco.nose.business.assembler.dto.impl.UserDTOAssembler;
import co.edu.uco.nose.business.business.UserBusiness;
import co.edu.uco.nose.business.business.impl.UserBusinessImpl;
import co.edu.uco.nose.business.facede.UserFacade;
import co.edu.uco.nose.crosscuting.exception.NoseException;
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

        }catch (final NoseException exception){
            daoFactory.rollbackTransaction();
            throw exception;
            }
        catch (final Exception exception){
            daoFactory.rollbackTransaction();

            var userMessage = "";
            var technicalMessage = "";
            throw NoseException.create( userMessage, technicalMessage, exception);

        } finally {
            daoFactory.closeConnection();
        }

    }

    @Override
    public void dropUserInformation(UUID id) {

    }

    @Override
    public void updateUserInformation(UUID id, UserDTO userDTO) {

    }

    @Override
    public List<UserDTO> findAllUser() {
        return List.of();
    }

    @Override
    public List<UserDTO> findUserByFilter(UserDTO userFilters) {
        return List.of();
    }

    @Override
    public UserDTO findSpecificUser(UUID id) {
        return null;
    }
}
