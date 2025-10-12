package co.edu.uco.nose.data.dao.entity.postgresql;

import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.CityEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public final class CityPostgreSqlDAO extends SqlConnection implements CityDAO{


    public CityPostgreSqlDAO(final Connection connection) {
        super(connection);
    }
    @Override
    public List<CityEntity> findAll() {
        return List.of();
    }

    @Override
    public List<CityEntity> findByFilter(CityEntity filterEntity) {
        return List.of();
    }

    @Override
    public CityEntity findById(UUID uuid) {
        return null;
    }
}
