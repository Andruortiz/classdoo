package co.edu.uco.nose.business.facede;
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
}
