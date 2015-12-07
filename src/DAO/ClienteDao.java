package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
			// @todo criar procedure
			sql = "INSERT INTO hos_clientes(Nome, CPF, Telefone, Celular, CodCidade, EndRua, EndBairro, EndNum, Senha, Email)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement prmt = this.conn.prepareStatement(sql);

			prmt.setString(1, objeto.getNome());
			prmt.setString(2, objeto.getCPF());
			prmt.setInt(3, objeto.getTelefone());
			prmt.setInt(4, objeto.getCelular());
			prmt.setInt(5, objeto.getCodCidade());
			prmt.setString(6, objeto.getRua());
			prmt.setString(7, objeto.getBairro());
			prmt.setInt(8, objeto.getEndNum());
			prmt.setString(9, objeto.getSenha());
			prmt.setString(10, objeto.getEmail());

			int d = prmt.executeUpdate();
			System.out.println(d);
			if(d > 0){
				JOptionPane.showMessageDialog(null, "Cliente Cadastrado com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}

			prmt.close();
		}
		conn.close();
	}

	@Override
	public void setAlterar(Cliente objeto) throws SQLException {
		if (objeto == null) {
			System.out.println("Nulo");
		} else {

			sql = "UPDATE hos_clientes SET Nome=?, CPF=?, Telefone=?, Celular=?, CodCidade=?, EndRua=?, EndBairro=?, EndNum=?, Senha=?, Email=?"
					+ " WHERE Codigo=?";
			PreparedStatement prmt = this.conn.prepareStatement(sql);

			prmt.setString(1, objeto.getNome());
			prmt.setString(2, objeto.getCPF());
			prmt.setInt(3, objeto.getTelefone());
			prmt.setInt(4, objeto.getCelular());
			prmt.setInt(5, 3);
			prmt.setString(6, objeto.getRua());
			prmt.setString(7, objeto.getBairro());
			prmt.setInt(8, objeto.getEndNum());
			prmt.setString(9, objeto.getSenha());
			prmt.setString(10, objeto.getEmail());
			prmt.setInt(11, objeto.getCodigo());
			prmt.executeUpdate();
			prmt.close();

			JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		conn.close();

	}

	@Override
	public void setExcluir(int codigo) throws SQLException {
		sql = "delete from aluno where alunoId=?";

		PreparedStatement prmt = this.conn.prepareStatement(sql);

	//	prmt.setInt(1, objeto.getId());

		prmt.execute();
		prmt.close();
		conn.close();

	}

	@Override
	public Cliente getDetalhe(int codigo) throws SQLException {
		sql = "Select * FROM hos_clientes WHERE Codigo=?";

		PreparedStatement prmt = this.conn.prepareStatement(sql);

		prmt.setInt(1, codigo);
		ResultSet rs = prmt.executeQuery();
		Cliente a = null;
		if (rs.next()) {
			a = new Cliente();
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
		}
		conn.close();
		return a;
	}

}
