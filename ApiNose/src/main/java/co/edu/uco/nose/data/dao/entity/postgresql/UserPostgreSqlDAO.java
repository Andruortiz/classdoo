// java
package co.edu.uco.nose.data.dao.entity.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.crosscuting.messagecatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.SqlConnection;
import co.edu.uco.nose.data.dao.entity.UserDAO;
import co.edu.uco.nose.entity.UserEntity;

public final class UserPostgreSqlDAO extends SqlConnection implements UserDAO {

    public UserPostgreSqlDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public void create(final UserEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("INSERT INTO User(id, idType, firstName, secondName, firstLastName, secondLastName, residenceCity, email, phoneNumber, emailConfirmed, mobileNumberConfirmed) ");
        sql.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

        try (final PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, entity.getId());
            preparedStatement.setObject(2, entity.getIdType().getId());
            preparedStatement.setString(3, entity.getFirstName());
            preparedStatement.setString(4, entity.getSecondName());
            preparedStatement.setString(5, entity.getFirstLastName());
            preparedStatement.setString(6, entity.getSecondLastName());
            preparedStatement.setObject(7, entity.getResidenceCity().getId());
            preparedStatement.setString(8, entity.getEmail());
            preparedStatement.setString(9, entity.getPhoneNumber());
            preparedStatement.setBoolean(10, entity.isEmailConfirmed());
            preparedStatement.setBoolean(11, entity.isPhoneNumberConfirmed());
            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            throw NoseException.create(
                    MessagesEnum.USER_ERROR_SQL_CREATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_SQL_CREATE.getContent(),
                    exception
            );
        } catch (final Exception exception) {
            throw NoseException.create(
                    MessagesEnum.USER_ERROR_UNEXPECTED_CREATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_CREATE.getContent(),
                    exception
            );
        } catch (final Throwable exception) {
            throw NoseException.create(
                    MessagesEnum.USER_ERROR_CRITICAL_CREATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_CRITICAL_CREATE.getContent(),
                    exception
            );
        }
    }

    @Override
    public List<UserEntity> findByFilter(final UserEntity filterEntity) {
        if (filterEntity == null) {
            return findAll();
        }

        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("SELECT id, idType, firstname, secondname, firstlastname, secondlastname, ");
        sql.append("email, phone, password, emailconfirmation, phoneconfirmation ");
        sql.append("FROM users");

        final List<String> whereClauses = new ArrayList<>();

        if (filterEntity.getId() != null) {
            whereClauses.add("id = ?");
        }
        if (filterEntity.getIdType() != null && filterEntity.getIdType().getId() != null) {
            whereClauses.add("idtype = ?");
        }
        if (filterEntity.getFirstName() != null && !filterEntity.getFirstName().trim().isEmpty()) {
            whereClauses.add("firstname ILIKE ?");
        }
        if (filterEntity.getSecondName() != null && !filterEntity.getSecondName().trim().isEmpty()) {
            whereClauses.add("secondname ILIKE ?");
        }
        if (filterEntity.getFirstLastName() != null && !filterEntity.getFirstLastName().trim().isEmpty()) {
            whereClauses.add("firstlastname ILIKE ?");
        }
        if (filterEntity.getSecondLastName() != null && !filterEntity.getSecondLastName().trim().isEmpty()) {
            whereClauses.add("secondlastname ILIKE ?");
        }
        if (filterEntity.getEmail() != null && !filterEntity.getEmail().trim().isEmpty()) {
            whereClauses.add("email ILIKE ?");
        }
        if (filterEntity.getPhoneNumber() != null && !filterEntity.getPhoneNumber().trim().isEmpty()) {
            whereClauses.add("phonenumber ILIKE ?");
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
            if (filterEntity.getIdType() != null && filterEntity.getIdType().getId() != null) {
                preparedStatement.setObject(index++, filterEntity.getIdType().getId());
            }
            if (filterEntity.getFirstName() != null && !filterEntity.getFirstName().trim().isEmpty()) {
                preparedStatement.setString(index++, "%" + filterEntity.getFirstName().trim() + "%");
            }
            if (filterEntity.getSecondName() != null && !filterEntity.getSecondName().trim().isEmpty()) {
                preparedStatement.setString(index++, "%" + filterEntity.getSecondName().trim() + "%");
            }
            if (filterEntity.getFirstLastName() != null && !filterEntity.getFirstLastName().trim().isEmpty()) {
                preparedStatement.setString(index++, "%" + filterEntity.getFirstLastName().trim() + "%");
            }
            if (filterEntity.getSecondLastName() != null && !filterEntity.getSecondLastName().trim().isEmpty()) {
                preparedStatement.setString(index++, "%" + filterEntity.getSecondLastName().trim() + "%");
            }
            if (filterEntity.getEmail() != null && !filterEntity.getEmail().trim().isEmpty()) {
                preparedStatement.setString(index++, "%" + filterEntity.getEmail().trim() + "%");
            }
            if (filterEntity.getPhoneNumber() != null && !filterEntity.getPhoneNumber().trim().isEmpty()) {
                preparedStatement.setString(index++, "%" + filterEntity.getPhoneNumber().trim() + "%");
            }

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                final List<UserEntity> users = new ArrayList<>();
                while (resultSet.next()) {
                    final UserEntity user = new UserEntity();
                    user.setId((UUID) resultSet.getObject("id"));
                    // Se usan setters para evitar dependencias de constructores no existentes
                    // Si faltan columnas/sets, completar según la entidad real
                    // Ejemplos comunes:
                    // user.setFirstName(resultSet.getString("firstname"));
                    // user.setSecondName(resultSet.getString("secondname"));
                    // user.setFirstLastName(resultSet.getString("firstlastname"));
                    // user.setSecondLastName(resultSet.getString("secondlastname"));
                    // user.setEmail(resultSet.getString("email"));
                    // user.setPhoneNumber(resultSet.getString("phone"));
                    // user.setPassword(resultSet.getString("password"));
                    // user.setEmailConfirmed(resultSet.getBoolean("emailconfirmation"));
                    // user.setPhoneNumberConfirmed(resultSet.getBoolean("phoneconfirmation"));
                    users.add(user);
                }
                return users;
            }

        } catch (final SQLException exception) {
            throw NoseException.create(
                    MessagesEnum.USER_ERROR_FIND_BY_FILTER_SQL.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_FIND_BY_FILTER_SQL.getContent(),
                    exception
            );
        } catch (final Exception exception) {
            throw NoseException.create(
                    MessagesEnum.USER_ERROR_FIND_BY_FILTER_UNEXPECTED.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_FIND_BY_FILTER_UNEXPECTED.getContent(),
                    exception
            );
        } catch (final Throwable exception) {
            throw NoseException.create(
                    MessagesEnum.USER_ERROR_FIND_BY_FILTER_CRITICAL.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_FIND_BY_FILTER_CRITICAL.getContent(),
                    exception
            );
        }
    }

    @Override
    public UserEntity findById(final UUID id) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());

        final var sql = new StringBuilder();
        sql.append("SELECT id, identitydocument, firstname, firstlastname, secondlastname, email, phone, username, ");
        sql.append("password, emailconfirmation, phoneconfirmation FROM users WHERE id = ?");

        try (final PreparedStatement preparedStatement = getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    final UserEntity user = new UserEntity();
                    user.setId((UUID) resultSet.getObject("id"));
                    // usar setters como en findByFilter
                    return user;
                } else {
                    return null;
                }
            }

        } catch (final SQLException exception) {
            throw NoseException.create(
                    MessagesEnum.USER_ERROR_FIND_BY_ID_SQL.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_FIND_BY_ID_SQL.getContent(),
                    exception
            );
        } catch (final Exception exception) {
            throw NoseException.create(
                    MessagesEnum.USER_ERROR_FIND_BY_ID_UNEXPECTED.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED.getContent(),
                    exception
            );
        } catch (final Throwable exception) {
            throw NoseException.create(
                    MessagesEnum.USER_ERROR_FIND_BY_ID_CRITICAL.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_FIND_BY_ID_CRITICAL.getContent(),
                    exception
            );
        }
    }

    @Override
    public void update(final UserEntity entity) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = new StringBuilder();
        sql.append("UPDATE User SET idType = ?, phoneNumber = ?, firstName = ?, secondName = ?, firstLastName = ?, secondLastName = ?, residenceCity = ?, email = ?, phoneNumber = ?, emailConfirmed = ?, mobileNumberConfirmed = ? WHERE id = ?");
        try (final PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, entity.getIdType().getId());
            preparedStatement.setString(2, entity.getPhoneNumber());
            preparedStatement.setString(3, entity.getFirstName());
            preparedStatement.setString(4, entity.getSecondName());
            preparedStatement.setString(5, entity.getFirstLastName());
            preparedStatement.setString(6, entity.getSecondLastName());
            preparedStatement.setObject(7, entity.getResidenceCity().getId());
            preparedStatement.setString(8, entity.getEmail());
            preparedStatement.setString(9, entity.getPhoneNumber());
            preparedStatement.setBoolean(10, entity.isEmailConfirmed());
            preparedStatement.setBoolean(11, entity.isPhoneNumberConfirmed());
            preparedStatement.setObject(12, entity.getId());
            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            throw NoseException.create(
                    MessagesEnum.USER_ERROR_SQL_UPDATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_SQL_UPDATE.getContent(),
                    exception
            );
        } catch (final Exception exception) {
            throw NoseException.create(
                    MessagesEnum.USER_ERROR_UNEXPECTED_UPDATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_UPDATE.getContent(),
                    exception
            );
        } catch (final Throwable exception) {
            throw NoseException.create(
                    MessagesEnum.USER_ERROR_CRITICAL_UPDATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_CRITICAL_UPDATE.getContent(),
                    exception
            );
        }
    }

    @Override
    public void delete(final UUID id) {
        SqlConnectionHelper.ensureTransactionIsStarted(getConnection());
        final var sql = new StringBuilder();
        sql.append("DELETE FROM User WHERE id = ?");
        try (final PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql.toString())) {
            preparedStatement.setObject(1, id);
            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            throw NoseException.create(
                    MessagesEnum.USER_ERROR_SQL_DELETE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_SQL_UPDATE.getContent(),
                    exception
            );
        } catch (final Exception exception) {
            throw NoseException.create(
                    MessagesEnum.USER_ERROR_UNEXPECTED_DELETE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_DELETE.getContent(),
                    exception
            );
        } catch (final Throwable exception) {
            throw NoseException.create(
                    MessagesEnum.USER_ERROR_CRITICAL_DELETE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_CRITICAL_DELETE.getContent(),
                    exception
            );
        }
    }

    @Override
    public List<UserEntity> findAll() {
        // Implementación mínima para cumplir la firma del DAO.
        // Si se requiere la lectura real de la BD, reemplazar por la consulta correspondiente y mapeo de resultados.
        return new ArrayList<>();
    }
}
