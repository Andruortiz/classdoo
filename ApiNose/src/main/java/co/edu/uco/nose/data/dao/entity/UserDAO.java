package co.edu.uco.nose.data.dao.entity;

import co.edu.uco.nose.data.dao.RetrieveDAO;
import co.edu.uco.nose.entity.UserEntity;

import java.util.UUID;

public interface UserDAO extends RetrieveDAO<UserEntity, UUID> {

    void create(UserEntity user);
    void update(UserEntity user);
    void delete(UUID id);
}
