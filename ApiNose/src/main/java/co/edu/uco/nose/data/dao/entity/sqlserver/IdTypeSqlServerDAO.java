package co.edu.uco.nose.data.dao.entity.sqlserver;

import co.edu.uco.nose.data.dao.entity.IdTypeDAO;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.entity.IdTypeEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public final class IdTypeSqlServerDAO extends SqlConnection implements IdTypeDAO {

    IdTypeSqlServerDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public List<IdTypeEntity> findAll() {
        return List.of();
    }

    @Override
    public List<IdTypeEntity> findByFilter(IdTypeEntity filterEntity) {
        return List.of();
    }

    @Override
    public IdTypeEntity findById(UUID uuid) {
        return null;
    }
}
