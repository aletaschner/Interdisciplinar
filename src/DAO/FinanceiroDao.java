package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;

import model.Cliente;
import model.Financeiro;

public class FinanceiroDao implements IAbstractDao<Financeiro> {

	public char Tipo;
	private String sql;
	private java.sql.Connection conn;

	public FinanceiroDao(char Tipo) throws SQLException{
		this.Tipo = Tipo;
		conn = new ConectaMYSQL().getConnection();
	}
	public FinanceiroDao() throws SQLException {
		conn = new ConectaMYSQL().getConnection();
	}

	@Override
	public List<Financeiro> getListar() throws SQLException {

		sql = "SELECT Codigo, Valor, Motivo, Data, Tipo"
				+ " FROM hos_financeiro WHERE Tipo='"+this.Tipo+"'"
				+ " ORDER BY Data Desc";

			PreparedStatement prmt = this.conn.prepareStatement(sql);
			ResultSet rs = prmt.executeQuery();
			List<Financeiro> Financeiros = new ArrayList<Financeiro>();

			while (rs.next()) {
				Financeiro a = new Financeiro();
				a.setCodigo(rs.getInt("Codigo"));
				a.setValor(rs.getDouble("Valor"));
				a.setMotivo(rs.getString("Motivo"));
				a.setDate(rs.getDate("Data"));
				a.setTipo(this.Tipo);
				Financeiros.add(a);
			}
			conn.close();
			return Financeiros;
	}

	@Override
	public void setInserir(Financeiro objeto) throws SQLException {
		this.sql = "INSERT INTO hos_financeiro(Valor, Motivo, Data, Tipo) VALUES"
				+ "(?, ?, ?, '"+this.Tipo+"')";
		PreparedStatement prmt = this.conn.prepareStatement(sql);

		prmt.setDouble(1, objeto.getValor());
		prmt.setString(2, objeto.getMotivo());
		prmt.setDate(3, objeto.getDate());
		prmt.execute();

		JOptionPane.showMessageDialog(null, "Cadastrado com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);

	}

	@Override
	public void setAlterar(Financeiro objeto) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setExcluir(int codigo) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Financeiro getDetalhe(int codigo) throws SQLException {
		this.sql = "SELECT * FROM hos_financeiro WHERE Codigo=?";

		PreparedStatement prmt = this.conn.prepareStatement(sql);

		prmt.setInt(1, codigo);
		ResultSet rs = prmt.executeQuery();
		Financeiro f = new Financeiro();

		return f;
	}

}
