package co.edu.uco.nose.data.dao.entity.postgresql;

import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.CountryEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public final class CountryPostgreSqlDAO extends SqlConnection implements CountryDAO {

    public CountryPostgreSqlDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public List<CountryEntity> findAll() {
        return List.of();
    }

    @Override
    public List<CountryEntity> findByFilter(CountryEntity filterEntity) {
        return List.of();
    }

    @Override
    public CountryEntity findById(UUID uuid) {
        return null;
    }
}
