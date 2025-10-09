package co.edu.uco.nose.data.dao;

import java.util.UUID;
import co.edu.uco.nose.entity.UserEntity;

public interface UserDAO extends
        CreateDAO<UserEntity>,
        UpdateDAO<UserEntity>,
        RetrieveDAO<UserEntity, UUID>,
        DeleteDAO<UUID> {
}

