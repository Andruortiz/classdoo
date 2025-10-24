package co.edu.uco.nose.data.dao.entity.postgresql;
import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.messagecatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.entity.StateEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class StatePostgreSqlDAO extends SqlConnection implements StateDAO{

    public StatePostgreSqlDAO(Connection connection2) {
        super(connection2);
    }

    @Override
    public List<StateEntity> findAll() {
        final StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, name FROM state");

        try (final PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString());
             final ResultSet resultSet = preparedStatement.executeQuery()) {

            final List<StateEntity> results = new ArrayList<>();

            while (resultSet.next()) {
                var state = new StateEntity(
                        (UUID) resultSet.getObject("id"),
                        resultSet.getString("name")
                );
                results.add(state);
            }

            return results;

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.STATE_ERROR_FIND_ALL_SQL.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FIND_ALL_SQL_STATE.getContent();
            throw NoseException.create(userMessage, technicalMessage, exception);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.STATE_ERROR_FIND_ALL_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FIND_ALL_UNEXPECTED_STATE.getContent();
            throw NoseException.create(userMessage, technicalMessage, exception);

        } catch (final Throwable exception) {
            var userMessage = MessagesEnum.STATE_ERROR_FIND_ALL_CRITICAL.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FIND_ALL_CRITICAL_STATE.getContent();
            throw NoseException.create(userMessage, technicalMessage, exception);
        }
    }

    @Override
    public List<StateEntity> findByFilter(StateEntity filterEntity) {
        if (filterEntity == null) {
            return findAll();
        }

        final StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, name FROM state");

        final List<String> whereClauses = new ArrayList<>();
        if (filterEntity.getId() != null) {
            whereClauses.add("id = ?");
        }
        if (filterEntity.getName() != null && !filterEntity.getName().trim().isEmpty()) {
            whereClauses.add("name ILIKE ?");
        }

        if (!whereClauses.isEmpty()) {
            sql.append(" WHERE ");
            sql.append(String.join(" AND ", whereClauses));
        }

        try (final PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {

            int index = 1;
            if (filterEntity.getId() != null) {
                preparedStatement.setObject(index++, filterEntity.getId());
            }
            if (filterEntity.getName() != null && !filterEntity.getName().trim().isEmpty()) {
                preparedStatement.setString(index++, "%" + filterEntity.getName().trim() + "%");
            }

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                final List<StateEntity> results = new ArrayList<>();
                while (resultSet.next()) {
                    results.add(new StateEntity(
                            (UUID) resultSet.getObject("id"),
                            resultSet.getString("name")
                    ));
                }
                return results;
            }

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.STATE_ERROR_FIND_BY_FILTER_SQL.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FIND_BY_FILTER_SQL_STATE.getContent();
            throw NoseException.create(userMessage, technicalMessage, exception);

        } catch (final Exception exception) {
            var userMessage = MessagesEnum.STATE_ERROR_FIND_BY_FILTER_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FIND_BY_FILTER_UNEXPECTED_STATE.getContent();
            throw NoseException.create(userMessage, technicalMessage, exception);

        } catch (final Throwable exception) {
            var userMessage = MessagesEnum.STATE_ERROR_FIND_BY_FILTER_CRITICAL.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FIND_BY_FILTER_CRITICAL_STATE.getContent();
            throw NoseException.create(userMessage, technicalMessage, exception);
        }
    }



    @Override
    public StateEntity findById(UUID id) {
        final StringBuilder sql = new StringBuilder();
        sql.append("SELECT id, name FROM state WHERE id = ?");

        try (final PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, id);

            final ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new StateEntity(
                        (UUID) resultSet.getObject("id"),
                        resultSet.getString("name")
                );
            }

            return null;

        } catch (final SQLException exception) {
            var userMessage = MessagesEnum.STATE_ERROR_FIND_BY_ID_SQL.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FIND_BY_ID_SQL_STATE.getContent();
            throw NoseException.create(userMessage, technicalMessage, exception);



        } catch (final Exception exception) {
            var userMessage = MessagesEnum.STATE_ERROR_FIND_BY_ID_UNEXPECTED.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED_STATE.getContent();
            throw NoseException.create(userMessage, technicalMessage, exception);



        } catch (final Throwable exception) {
            var userMessage = MessagesEnum.STATE_ERROR_FIND_BY_ID_CRITICAL.getContent();
            var technicalMessage = MessagesEnum.TECHNICAL_ERROR_FIND_BY_ID_CRITICAL_STATE.getContent();
            throw NoseException.create(userMessage, technicalMessage, exception);
        }
        }
    }

