package DAO;

import java.sql.Connection;
import java.sql.SQLException;

public interface FactoryDataBase {
	Connection getConnection() throws SQLException;
}

