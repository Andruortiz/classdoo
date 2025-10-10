package co.edu.uco.nose.data.dao.entity.sqlserver;

import co.edu.uco.nose.data.dao.UserDAO;
import co.edu.uco.nose.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public final class UserSqlServerDAO implements UserDAO {

	@Override
	public void create(UserEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(UserEntity entity) {
		// TODO Auto-generated method stub
		 
	}

    @Override
    public void delete(UUID uuid) {

    }

    @Override
    public List<UserEntity> findAll() {
        return List.of();
    }

    @Override
    public List<UserEntity> findByFilter(UserEntity filterEntity) {
        return List.of();
    }

    @Override
    public UserEntity findById(UUID uuid) {
        return null;
    }
}


