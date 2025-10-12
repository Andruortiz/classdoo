package co.edu.uco.nose.data.factory.postgresql;

import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.IdTypeDAO;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.data.dao.entity.UserDAO;
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
        try {
            this.connection = DriverManager.getConnection("");

        }catch (final SQLException exception) {
            var userMessage =  "";
            var technicalMessage = "";
            throw new RuntimeException(technicalMessage);

        }catch (final Exception exception) {

            var userMessage =  "";
            var technicalMessage = "";
            throw new RuntimeException(technicalMessage);
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
