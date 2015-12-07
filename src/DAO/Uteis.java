package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Uteis {

	private Connection conn;
	private String sql;

	public Uteis() throws SQLException {
		conn = new ConectaMYSQL().getConnection();
		this.sql = null;
	}

	public boolean checaEmailCliente(String Email, int Codigo) throws SQLException{
		String Where = "";
		if(Codigo != 0){
			Where = " AND Codigo != "+Codigo;
		}
		this.sql = "SELECT Codigo FROM hos_clientes WHERE Email = '"+Email+"'"+Where;
		PreparedStatement prmt = this.conn.prepareStatement(sql);
		ResultSet rs = prmt.executeQuery();
		if( rs.getFetchSize() > 0){
			System.out.println(rs.getFetchSize());
		return false;
		} else {
			return true;
		}
	}
	public boolean checaCPFCliente(String CPF, int Codigo) throws SQLException{
		String Where = "";
		if(Codigo != 0){
			Where = " AND Codigo != "+Codigo;
		}
		this.sql = "SELECT Codigo FROM hos_clientes WHERE CPF='"+CPF+"'"+Where;
		PreparedStatement prmt = this.conn.prepareStatement(sql);
		ResultSet rs = prmt.executeQuery();
		if( rs.getFetchSize() > 0){
		return false;
		} else {
			return true;
		}
	}
}
