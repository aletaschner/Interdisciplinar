package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMYSQL implements FactoryDataBase {

	@Override
	public Connection getConnection() throws SQLException  {

		DriverManager.registerDriver(new org.sqlite.JDBC());
		String url = "jdbc:sqlite:C:\\Users\\Diego\\Downloads\\ExemploFX\\ExemploFX\\DB\\DataBase.db";

		return DriverManager.getConnection(url);
	}

}
