package co.edu.uco.nose.data.dao.entity.sqlserver;

import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.CountryEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public final class CountrySqlServerDAO extends SqlConnection implements CountryDAO {

    CountrySqlServerDAO(final Connection connection) {
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
