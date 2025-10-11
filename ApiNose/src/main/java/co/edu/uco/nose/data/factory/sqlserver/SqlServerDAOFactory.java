package co.edu.uco.nose.data.factory.sqlserver;

import co.edu.uco.nose.data.dao.UserDAO;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.IdTypeDAO;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.data.dao.entity.sqlserver.*;
import co.edu.uco.nose.data.factory.DAOFactory;

import java.sql.DriverManager;
import java.sql.SQLException;

public final class SqlServerDAOFactory extends DAOFactory {



    public SqlServerDAOFactory() {
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
        return new CountrySqlServerDAO(connection);
    }

    @Override
    public CityDAO getCityDAO() {

        return new CitySqlServerDAO(connection);
    }

    @Override
    public IdTypeDAO getIdTypeDAO() {
        return new IdTypeSqlServerDAO(connection);
    }

    @Override
    public StateDAO getStateDAO() {
        return new StateSqlServerDAO(connection);
    }

    @Override
    public UserDAO getUserDAO() {
        return new UserSqlServerDAO(connection);
    }


}
