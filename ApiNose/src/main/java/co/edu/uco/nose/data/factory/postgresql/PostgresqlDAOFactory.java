package co.edu.uco.nose.data.factory.postgresql;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.messagecatalog.MessagesEnum;
import co.edu.uco.nose.data.dao.entity.*;
import co.edu.uco.nose.data.dao.entity.postgresql.*;
import co.edu.uco.nose.data.factory.DAOFactory;

import java.sql.DriverManager;
import java.sql.SQLException;

public final class PostgresqlDAOFactory extends DAOFactory {

    public PostgresqlDAOFactory() {
        openConnection();
    }

    @Override
    protected void openConnection() {
        final String url = "jdbc:postgresql://localhost:5433/classdoo";
        final String user = "postgres";
        final String password = "dino12345";

        try {
            // Registrar el driver JDBC explícitamente
            Class.forName("org.postgresql.Driver");

            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Conexión establecida correctamente con PostgreSQL en: " + url);

        } catch (final SQLException exception) {
            throw NoseException.create(
                    exception,
                    MessagesEnum.USER_ERROR_DATABASE_CONNECTION.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_DATABASE_CONNECTION.getContent()
            );

        } catch (final ClassNotFoundException exception) {
            throw NoseException.create(
                    exception,
                    MessagesEnum.USER_ERROR_MISSING_DRIVER.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_MISSING_DRIVER.getContent()
            );

        } catch (final Exception exception) {
            throw NoseException.create(
                    exception,
                    MessagesEnum.USER_ERROR_UNEXPECTED_CREATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_CREATE.getContent()
            );

        } catch (final Throwable exception) {
            throw NoseException.create(
                    exception,
                    MessagesEnum.USER_ERROR_CRITICAL_CREATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_CRITICAL_CREATE.getContent()
            );
        }
    }

    @Override
    public CountryDAO getCountryDAO() {
        return new CountryPostgreSqlDAO(connection);
    }

    @Override
    public CityDAO getCityDAO() {
        return new CityPostgreSqlDAO(connection);
    }

    @Override
    public IdTypeDAO getIdTypeDAO() {
        return new IdTypePostgreSqlDAO(connection);
    }

    @Override
    public StateDAO getStateDAO() {
        return new StatePostgreSqlDAO(connection);
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserPostgreSqlDAO(connection);
    }
}
