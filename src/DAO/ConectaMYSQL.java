package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMYSQL implements FactoryDataBase {

	@Override
	public Connection getConnection() throws SQLException  {

		DriverManager.registerDriver(new org.sqlite.JDBC());

		return DriverManager.getConnection(url);
	}

}
