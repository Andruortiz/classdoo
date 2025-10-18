package co.edu.uco.nose.business.business;

import co.edu.uco.nose.business.domain.UserDomain;
import co.edu.uco.nose.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserBusiness {

    void registerNewUserInformation(UserDomain userDomain) {

        1. validar que la informacion sea consistente da nivel de tipo de dato, longitud, obligatopriedad, formato, rango, reglas propias de negocio

                2. validadr que no exista previamnet ptro usuario  con el mismo tipo y numero de identificacion

                3. validar que no exista previamente otro usuario con el mismo correo electronico

                4. validar que no exista otro usuario con el mismo numero de telefono

                5. generar un identificar para el nuevo usuario, asegurando que no exista otro
    }
    void dropUserInformation(UUID id);
    void updateUserInformation(UUID id, UserDomain userDomain);

    List<UserDomain> findAllUser();

    List<UserDomain> findAlluser();

    List<UserDomain>  findUserByFilter(UserEntity userFilters);

    UserDomain findSpecificUser(UUID id);


    void confirmMobileNumber(UUID id, int confirmationCode);
    void confirmEmail(UUID id);
    void sendMobileNumberConfirmation(UUID id);
    void senddEmailConfirmation(UUID id);



}
