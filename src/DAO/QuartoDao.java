package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Cliente;
import model.Quarto;

public class QuartoDao implements IAbstractDao<Quarto> {
	private Connection conn;
	private String sql;

	public QuartoDao() throws SQLException {
		conn = new ConectaMYSQL().getConnection();
	}

	@Override
	public List<Quarto> getListar() throws SQLException {
		sql = "SELECT Codigo, Nome, FotoCapa, Preco, Vagas"
			+ " FROM hos_quartos";

		PreparedStatement prmt = this.conn.prepareStatement(sql);
		ResultSet rs = prmt.executeQuery();
		List<Quarto> Quartos = new ArrayList<Quarto>();

		while (rs.next()) {
			Quarto q = new Quarto();
			q.setCodigo(rs.getInt("Codigo"));
			q.setNome(rs.getString("Nome"));
			q.setFotoCapa(rs.getString("FotoCapa"));
			q.setPreco(rs.getDouble("Preco"));
			q.setQtdCamas(rs.getInt("Vagas"));
			Quartos.add(q);
		}
		conn.close();
		return Quartos;
	}

	@Override
	public void setInserir(Quarto objeto) throws SQLException {
		if (objeto == null) {
			System.out.println("Nulo");

		} else {
			// @todo criar procedure
			sql = "INSERT INTO hos_quartos(Nome, Preco, Vagas, Observacao, FotoCapa)"
					+ " VALUES (?,?,?,?,?)";
			PreparedStatement prmt = this.conn.prepareStatement(sql);

			prmt.setString(1, objeto.getNome());
			prmt.setDouble(2, objeto.getPreco());
			prmt.setInt(3, objeto.getQtdCamas());
			prmt.setString(4, objeto.getNome());
			prmt.setString(5, objeto.getFotoCapa());

			int d = prmt.executeUpdate();
			System.out.println(d);
			if(d > 0){
				JOptionPane.showMessageDialog(null, "Quarto Cadastrado com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}

			prmt.close();
		}
		conn.close();
	}

	@Override
	public void setAlterar(Quarto objeto) throws SQLException {
		if (objeto == null) {
			System.out.println("Nulo");
		} else {

			sql = "UPDATE hos_quartos SET Nome=?, Preco=?, Vagas=?, Observacao=?, FotoCapa=?"
					+ " WHERE Codigo=?";
			PreparedStatement prmt = this.conn.prepareStatement(sql);

			prmt.setString(1, objeto.getNome());
			prmt.setDouble(2, objeto.getPreco());
			prmt.setInt(3, objeto.getQtdCamas());
			prmt.setString(4, objeto.getNome());
			prmt.setString(5, objeto.getFotoCapa());
			prmt.setInt(6, objeto.getCodigo());
			prmt.executeUpdate();
			prmt.close();
			JOptionPane.showMessageDialog(null, "Quarto alterado com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
		}
		conn.close();

	}

	@Override
	public void setExcluir(int Codigo) throws SQLException {
		sql = "DELETE FROM hos_quartos WHERE Codigo = ?";

		PreparedStatement prmt = this.conn.prepareStatement(sql);

		prmt.setInt(1, Codigo);

		prmt.execute();
		prmt.close();
		conn.close();

	}

	@Override
	public Quarto getDetalhe(int codigo) throws SQLException {
		sql = "Select * FROM hos_quartos WHERE Codigo=?";

		PreparedStatement prmt = this.conn.prepareStatement(sql);

		prmt.setInt(1, codigo);
		ResultSet rs = prmt.executeQuery();
		Quarto q = null;
		if (rs.next()) {
			q = new Quarto();
			q.setCodigo(rs.getInt("Codigo"));
			q.setNome(rs.getString("Nome"));
			q.setPreco(rs.getDouble("Preco"));
			q.setQtdCamas(rs.getInt("Vagas"));
			q.setFotoCapa(rs.getString("FotoCapa"));
		}
		conn.close();
		return q;

	}

}
