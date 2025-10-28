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

public final class  UserPostgreSqlDAO extends SqlConnection implements UserDAO {

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
            preparedStatement.setString(5, entity.getFirstSurname());
            preparedStatement.setString(6, entity.getSecondSurname());
            preparedStatement.setObject(7, entity.getHomeCity().getId());
            preparedStatement.setString(8, entity.getEmail());
            preparedStatement.setString(9, entity.getMobileNumber());
            preparedStatement.setBoolean(10, entity.isEmailConfirmed());
            preparedStatement.setBoolean(11, entity.isMobileNumberConfirmed());
            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_SQL_CREATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_SQL_CREATE.getContent()

            );
        } catch (final Exception exception) {
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_UNEXPECTED_CREATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_CREATE.getContent()

            );
        } catch (final Throwable exception) {
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_CRITICAL_CREATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_CRITICAL_CREATE.getContent()

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
        if (filterEntity.getFirstSurname() != null && !filterEntity.getFirstSurname().trim().isEmpty()) {
            whereClauses.add("firstlastname ILIKE ?");
        }
        if (filterEntity.getSecondSurname() != null && !filterEntity.getSecondSurname().trim().isEmpty()) {
            whereClauses.add("secondlastname ILIKE ?");
        }
        if (filterEntity.getEmail() != null && !filterEntity.getEmail().trim().isEmpty()) {
            whereClauses.add("email ILIKE ?");
        }
        if (filterEntity.getMobileNumber() != null && !filterEntity.getMobileNumber().trim().isEmpty()) {
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
            if (filterEntity.getFirstSurname() != null && !filterEntity.getFirstSurname().trim().isEmpty()) {
                preparedStatement.setString(index++, "%" + filterEntity.getFirstSurname().trim() + "%");
            }
            if (filterEntity.getSecondSurname() != null && !filterEntity.getSecondSurname().trim().isEmpty()) {
                preparedStatement.setString(index++, "%" + filterEntity.getSecondSurname().trim() + "%");
            }
            if (filterEntity.getEmail() != null && !filterEntity.getEmail().trim().isEmpty()) {
                preparedStatement.setString(index++, "%" + filterEntity.getEmail().trim() + "%");
            }
            if (filterEntity.getMobileNumber() != null && !filterEntity.getMobileNumber().trim().isEmpty()) {
                preparedStatement.setString(index++, "%" + filterEntity.getMobileNumber().trim() + "%");
            }

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                final List<UserEntity> users = new ArrayList<>();
                while (resultSet.next()) {
                    final UserEntity user = new UserEntity();
                    user.setId((UUID) resultSet.getObject("id"));
                    user.setFirstName(resultSet.getString("firstname"));
                    user.setSecondName(resultSet.getString("secondname"));
                    user.setFirstSurname(resultSet.getString("firstlastname"));
                    user.setSecondSurname(resultSet.getString("secondlastname"));
                    user.setEmail(resultSet.getString("email"));
                    user.setMobileNumber(resultSet.getString("phone"));
                    user.setEmailConfirmed(resultSet.getBoolean("emailconfirmation"));
                    user.setMobileNumberConfirmed(resultSet.getBoolean("phoneconfirmation"));
                    users.add(user);
                }
                return users;
            }

        } catch (final SQLException exception) {
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_FIND_BY_FILTER_SQL.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_FIND_BY_FILTER_SQL.getContent()

            );
        } catch (final Exception exception) {
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_FIND_BY_FILTER_UNEXPECTED.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_FIND_BY_FILTER_UNEXPECTED.getContent()

            );
        } catch (final Throwable exception) {
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_FIND_BY_FILTER_CRITICAL.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_FIND_BY_FILTER_CRITICAL.getContent()

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
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_FIND_BY_ID_SQL.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_FIND_BY_ID_SQL.getContent()

            );
        } catch (final Exception exception) {
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_FIND_BY_ID_UNEXPECTED.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_FIND_BY_ID_UNEXPECTED.getContent()

            );
        } catch (final Throwable exception) {
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_FIND_BY_ID_CRITICAL.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_FIND_BY_ID_CRITICAL.getContent()

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
            preparedStatement.setString(2, entity.getMobileNumber());
            preparedStatement.setString(3, entity.getFirstName());
            preparedStatement.setString(4, entity.getSecondName());
            preparedStatement.setString(5, entity.getFirstSurname());
            preparedStatement.setString(6, entity.getSecondSurname());
            preparedStatement.setObject(7, entity.getHomeCity().getId());
            preparedStatement.setString(8, entity.getEmail());
            preparedStatement.setString(9, entity.getMobileNumber());
            preparedStatement.setBoolean(10, entity.isEmailConfirmed());
            preparedStatement.setBoolean(11, entity.isMobileNumberConfirmedIsDefaultValue());
            preparedStatement.setObject(12, entity.getId());
            preparedStatement.executeUpdate();

        } catch (final SQLException exception) {
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_SQL_UPDATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_SQL_UPDATE.getContent()

            );
        } catch (final Exception exception) {
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_UNEXPECTED_UPDATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_UPDATE.getContent()

            );
        } catch (final Throwable exception) {
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_CRITICAL_UPDATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_CRITICAL_UPDATE.getContent()

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
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_SQL_DELETE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_SQL_DELETE.getContent()

            );
        } catch (final Exception exception) {
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_UNEXPECTED_DELETE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_DELETE.getContent()

            );
        } catch (final Throwable exception) {
            throw NoseException.create(exception,
                    MessagesEnum.USER_ERROR_CRITICAL_DELETE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_CRITICAL_DELETE.getContent()

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
