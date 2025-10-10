package co.edu.uco.nose.data.factory;

import java.sql.Connection;

import co.edu.uco.nose.data.dao.UserDAO;
import co.edu.uco.nose.data.dao.entity.CityDAO;
import co.edu.uco.nose.data.dao.entity.CountryDAO;
import co.edu.uco.nose.data.dao.entity.IdTypeDAO;
import co.edu.uco.nose.data.dao.entity.StateDAO;

public abstract class DAOFactory {
	
	
	protected Connection connection;
	protected FactoryEnum factory = FactoryEnum.SQLSERVER;
	
	
	public static DAOFactory getFactory() {
		return null;
	}
	
	public abstract CountryDAO getCountryDAO();
	
	public abstract CityDAO getCityDAO();
	
	public abstract IdTypeDAO getIdTypeDAO();
	
	public abstract StateDAO getStateDAO();
	
	public abstract UserDAO getUserDAO();
	
	protected abstract void openConnection();
	
	protected final void initTransaccion(){
		
	}
	
	protected final void commitTransaccion() {
		
	}
	
	protected final void rollbackTransaccion() {
	}
	
	
	protected final void closeConnection() {
	
	}
	
	
}
