package co.edu.uco.nose.data.factory;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.nose.crosscuting.exception.NoseException;
import co.edu.uco.nose.crosscuting.helper.SqlConnectionHelper;
import co.edu.uco.nose.data.dao.entity.*;
import co.edu.uco.nose.data.factory.postgresql.PostgresqlDAOFactory;

public abstract class DAOFactory {

    // Conexión compartida por los DAOs creados en la misma transacción
    protected Connection connection;

    // Tipo de fábrica (permite cambiar entre SQLServer, MySQL, etc.)
    protected static FactoryEnum factory = FactoryEnum.POSTGRESQL;

    /**
     * Devuelve la implementación concreta de la fábrica según el tipo configurado.
     */
    public static DAOFactory getFactory() {
        switch (factory) {
            case POSTGRESQL:
                return new PostgresqlDAOFactory();
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

    // Método que abre la conexión en cada implementación
    protected abstract void openConnection();

    /**
     * Permite acceder a la conexión activa (útil para pruebas o transacciones).
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Inicia una transacción (desactiva auto-commit).
     */
    public final void initTransaction() {
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
    public final void commitTransaction() {
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
    public final void rollbackTransaction() {
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
    public final void closeConnection() {
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
