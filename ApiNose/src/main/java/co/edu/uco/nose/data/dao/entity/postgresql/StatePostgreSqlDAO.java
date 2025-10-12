package co.edu.uco.nose.data.dao.entity.postgresql;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.entity.StateEntity;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

public final class StatePostgreSqlDAO extends SqlConnection implements StateDAO{

    public StatePostgreSqlDAO(final Connection connection) {
        super(connection);
    }
    @Override
    public List<StateEntity> findAll() {
        return List.of();
    }

    @Override
    public List<StateEntity> findByFilter(StateEntity filterEntity) {
        return List.of();
    }


    @Override
    public StateEntity findById(UUID uuid) {
        return null;
    }
}
