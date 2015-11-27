package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class ClienteDao implements IAbstractDao<Cliente> {
	private Connection conn;
	private String sql;

	public ClienteDao() throws SQLException {
		conn = new ConectaMYSQL().getConnection();
	}

	@Override
	public List<Cliente> getListar() throws SQLException {
		sql = "SELECT Codigo, Nome, CPF, Telefone, Celular,"
			+ " CodCidade, EndRua, EndBairro, EndNum, Senha, Email"
			+ " FROM hos_clientes";

		PreparedStatement prmt = this.conn.prepareStatement(sql);
		ResultSet rs = prmt.executeQuery();
		List<Cliente> Clientes = new ArrayList<Cliente>();

		while (rs.next()) {
			Cliente a = new Cliente();
			a.setCodigo(rs.getInt("Codigo"));
			a.setNome(rs.getString("Nome"));
			a.setCPF(rs.getString("CPF"));
			a.setTelefone(rs.getInt("Telefone"));
			a.setCelular(rs.getInt("Celular"));
			a.setCodCidade(rs.getInt("CodCidade"));
			a.setRua(rs.getString("EndRua"));
			a.setBairro(rs.getString("EndBairro"));
			a.setEndNum(rs.getInt("EndNum"));
			a.setSenha(rs.getString("Senha"));
			a.setEmail(rs.getString("Email"));
			Clientes.add(a);
		}
		conn.close();
		return Clientes;
	}

	@Override
	public void setInserir(Cliente objeto) throws SQLException {
		if (objeto == null) {
			System.out.println("Nulo");

		} else {

			sql = "Insert into Aluno values(?,?,?,?)";
			PreparedStatement prmt = this.conn.prepareStatement(sql);

	//		prmt.setInt(1, objeto.getId());

			prmt.executeUpdate();
			prmt.close();
		}
		conn.close();
	}

	@Override
	public void setAlterar(Cliente objeto) throws SQLException {
		if (objeto == null) {
			System.out.println("Nulo");
		} else {

			sql = "Update Aluno set alunoNome =? , alunoDtNasc = ?, AlunoSexo = ? where alunoId = ?";
			PreparedStatement prmt = this.conn.prepareStatement(sql);

			//prmt.setString(1, objeto.getNome());

			prmt.executeUpdate();
			prmt.close();
		}
		conn.close();

	}

	@Override
	public void setExcluir(Cliente objeto) throws SQLException {
		sql = "delete from aluno where alunoId=?";

		PreparedStatement prmt = this.conn.prepareStatement(sql);

	//	prmt.setInt(1, objeto.getId());

		prmt.execute();
		prmt.close();
		conn.close();

	}

	@Override
	public Cliente getDetalhe(int codigo) throws SQLException {
		sql = "Select AlunoId, AlunoNome, AlunoDtNasc, AlunoSexo from Aluno where AlunoId = ?";

		PreparedStatement prmt = this.conn.prepareStatement(sql);

		prmt.setInt(1, codigo);
		ResultSet rs = prmt.executeQuery();
		Cliente a = null;
		if (rs.next()) {
			a = new Cliente();
		//	a.setId(rs.getInt("AlunoId"));
		}
		conn.close();
		return a;
	}

}
