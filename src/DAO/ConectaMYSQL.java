package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMYSQL implements FactoryDataBase {

	@Override
	public Connection getConnection() throws SQLException  {

		Connection Conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","");

		return Conn;
	}

}
