package co.edu.uco.nose.business.facade;
import co.edu.uco.nose.dto.UserDTO;


import java.util.List;
import java.util.UUID;

public interface UserFacade {

    void registerNewUserInformation(UserDTO userDTO);
    void dropUserInformation(UUID id);
    void updateUserInformation(UUID id, UserDTO userDTO);

    List<UserDTO> findAllUser();



    List<UserDTO>  findUserByFilter(UserDTO userFilters);

    UserDTO findSpecificUser(UUID id);

    void confirmMobileNumber(UUID userId, int confirmationCode);

    void confirmEmail(UUID userid, int confirmationCode);

    void sendMobileNumberConfirmation(UUID userId);

    void sendEmailConfirmation(UUID userId);
}
