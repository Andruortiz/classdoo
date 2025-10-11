package co.edu.uco.nose.data.factory;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.data.dao.UserDAO;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.IdTypeDAO;
import co.edu.uco.nose.data.dao.entity.StateDAO;
import co.edu.uco.nose.data.factory.sqlserver.SqlServerDAOFactory;

/**
 * Clase abstracta base para las fábricas DAO.
 * Gestiona la conexión, las transacciones y define los métodos
 * que deben implementar las subclases concretas (como SqlServerDAOFactory).
 */
public abstract class DAOFactory {

    // Conexión compartida por los DAOs creados en la misma transacción
    protected Connection connection;

    // Tipo de fábrica (permite cambiar entre SQLServer, MySQL, etc.)
    protected static FactoryEnum factory = FactoryEnum.SQLSERVER;

    /**
     * Devuelve la implementación concreta de la fábrica según el tipo configurado.
     */
    public static DAOFactory getFactory() {
        switch (factory) {
            case SQLSERVER:
                return new SqlServerDAOFactory();
            default:
                var userMessage = "La fábrica de datos no fue inicializada correctamente.";
                var technicalMessage = "Tipo de fábrica no soportado.";
                throw NoseException.create(userMessage, technicalMessage);
        }
    }

    // Métodos que deben implementar las subclases concretas
    public abstract CountryDAO getCountryDAO();
    public abstract CityDAO getCityDAO();
    public abstract IdTypeDAO getIdTypeDAO();
    public abstract StateDAO getStateDAO();
    public abstract UserDAO getUserDAO();

    /**
     * Método abstracto para abrir la conexión a la base de datos.
     * Implementado en SqlServerDAOFactory.
     */
    protected abstract void openConnection();

    /**
     * Inicia una transacción (desactiva auto-commit).
     */
    protected final void initTransaction() {
        SqlConnectionHelper.ensureConnectionIsOpen(connection);

        try {
            connection.setAutoCommit(false);
        } catch (final SQLException exception) {
            var userMessage = "No fue posible iniciar la transacción.";
            var technicalMessage = "Error SQL al desactivar el auto-commit.";
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    /**
     * Confirma (commit) la transacción actual.
     */
    protected final void commitTransaction() {
        SqlConnectionHelper.ensureTransactionIsStarted(connection);

        try {
            connection.commit();
        } catch (final SQLException exception) {
            var userMessage = "No fue posible confirmar los cambios.";
            var technicalMessage = "Error SQL al realizar commit.";
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    /**
     * Revierte (rollback) la transacción actual.
     */
    protected final void rollbackTransaction() {
        SqlConnectionHelper.ensureTransactionIsStarted(connection);

        try {
            connection.rollback();
        } catch (final SQLException exception) {
            var userMessage = "No fue posible revertir los cambios.";
            var technicalMessage = "Error SQL al realizar rollback.";
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }

    /**
     * Cierra la conexión activa.
     */
    protected final void closeConnection() {
        SqlConnectionHelper.ensureConnectionIsOpen(connection);

        try {
            connection.close();
        } catch (final SQLException exception) {
            var userMessage = "No fue posible cerrar la conexión.";
            var technicalMessage = "Error SQL al cerrar la conexión.";
            throw NoseException.create(exception, userMessage, technicalMessage);
        }
    }
}
