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

        if (this.connection == null) {
            System.out.println("❌ Conexión no se creó (connection sigue en null)");
        } else {
            System.out.println("✅ Conexión activa: " + this.connection);
        }

    }

    @Override
    protected void openConnection() {
        final String url = "jdbc:postgresql://localhost:5433/classdoo";
        final String user = "postgres";
        final String password = "dino12345";

        try {
            System.out.println("Intentando registrar driver PostgreSQL...");
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver PostgreSQL cargado exitosamente.");

            System.out.println("Intentando conectar a " + url);
            this.connection = DriverManager.getConnection(url, user, password);

            if (this.connection != null && !this.connection.isClosed()) {
                System.out.println("✅ Conexión establecida correctamente con PostgreSQL en: " + url);
            } else {
                System.out.println("❌ La conexión se creó pero está cerrada o es nula.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error SQL al intentar conectarse: " + e.getMessage());
            throw NoseException.create(e,
                    MessagesEnum.USER_ERROR_DATABASE_CONNECTION.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_DATABASE_CONNECTION.getContent());
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Driver de PostgreSQL no encontrado: " + e.getMessage());
            throw NoseException.create(e,
                    MessagesEnum.USER_ERROR_MISSING_DRIVER.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_MISSING_DRIVER.getContent());
        } catch (Exception e) {
            System.out.println("❌ Error inesperado: " + e.getMessage());
            throw NoseException.create(e,
                    MessagesEnum.USER_ERROR_UNEXPECTED_CREATE.getContent(),
                    MessagesEnum.TECHNICAL_ERROR_UNEXPECTED_CREATE.getContent());
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
