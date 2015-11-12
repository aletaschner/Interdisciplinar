//cria conecao com o banco de dados
//Inclui, altera, exclui dados no banco
//Retorna dados solitarios ou conjuntos de dados do BD
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioDAO implements IAbstractDao<Usuario> {
	private Connection conn;
	private String sql;

	public UsuarioDAO() throws SQLException {
		conn = new ConectaSqlite().getConnection();
	}

	@Override
	public List<Usuario> getListar() throws SQLException {
		sql = "Select UsuarioID, UsuarioNome, UsuarioSenha, UsuarioNivel, AlunoId from usuario";

		PreparedStatement prmt = this.conn.prepareStatement(sql);
		ResultSet rs = prmt.executeQuery();
		List<Usuario> Usuarios = new ArrayList<Usuario>();

		while (rs.next()) {
			Usuario u = new Usuario();
			u.setUsuarioid(rs.getInt("UsuarioId"));
			u.setUsuarioNome(rs.getString("UsuarioNome"));
			u.setUsuarioSenha(rs.getString("UsuarioSenha"));
			u.setUsuarioNivel(rs.getInt("UsuarioNivel"));
			u.setAlunoId(rs.getInt("AlunoId"));
			Usuarios.add(u);
		}
		conn.close();
		return Usuarios;
	}

	@Override
	public void setInserir(Usuario objeto) throws SQLException {
		sql = "Insert into Usuario values(?,?,?,?,?)";
		PreparedStatement prmt = this.conn.prepareStatement(sql);

		prmt.setInt(1, objeto.getUsuarioid());
		prmt.setString(2, objeto.getUsuarioNome());
		prmt.setString(3, objeto.getUsuarioSenha());
		prmt.setInt(4, objeto.getUsuarioNivel());
		prmt.setInt(5, objeto.getAlunoId());

		prmt.execute();
		prmt.close();
		conn.close();
	}

	@Override
	public void setAlterar(Usuario objeto) throws SQLException {
		sql = "Update Usuario set UsuarioNome = ?, UsuarioSenha = ?, UsuarioNivel = ?, AlunoId = ? where UsuarioID = ?";
		PreparedStatement prmt = this.conn.prepareStatement(sql);

		prmt.setString(1, objeto.getUsuarioNome());
		prmt.setString(2, objeto.getUsuarioSenha());
		prmt.setInt(3, objeto.getUsuarioNivel());
		prmt.setInt(4, objeto.getAlunoId());
		prmt.setInt(5, objeto.getUsuarioid());

		prmt.execute();
		prmt.close();
		conn.close();

	}

	@Override
	public void setExcluir(Usuario objeto) throws SQLException {
		sql = "delete from usuario where UsuaruiID=?";

		PreparedStatement prmt = this.conn.prepareStatement(sql);

		prmt.setInt(1, objeto.getUsuarioid());

		prmt.execute();
		prmt.close();
		conn.close();

	}

	@Override
	public Usuario getDetalhe(int codigo) throws SQLException {
		sql = "Select UsuarioID, UsuarioNome, UsuarioSenha, UsuarioNivel, AlunoId from usuario where usuarioId = ? ";

		PreparedStatement prmt = this.conn.prepareStatement(sql);
		prmt.setInt(1, codigo);

		ResultSet rs = prmt.executeQuery();
		Usuario u = null;
		if (rs.next()) {
			u = new Usuario();
			u.setUsuarioid(rs.getInt("UsuarioId"));
			u.setUsuarioNome(rs.getString("UsuarioNome"));
			u.setUsuarioSenha(rs.getString("UsuarioSenha"));
			u.setUsuarioNivel(rs.getInt("UsuarioNivel"));
			u.setAlunoId(rs.getInt("AlunoId"));
		}
		conn.close();
		return u;
	}

	public Usuario getDetalhe(String user) throws SQLException {
		sql = "Select UsuarioID, UsuarioNome, UsuarioSenha, UsuarioNivel, AlunoId from usuario where UsuarioNome like ?";

		PreparedStatement prmt = this.conn.prepareStatement(sql);
		prmt.setString(1, user);
		ResultSet rs = prmt.executeQuery();

		Usuario u = null;
		if (rs.next()) {
			u = new Usuario();
			u.setUsuarioid(rs.getInt("UsuarioId"));
			u.setUsuarioNome(rs.getString("UsuarioNome"));
			u.setUsuarioSenha(rs.getString("UsuarioSenha"));
			u.setUsuarioNivel(rs.getInt("UsuarioNivel"));
			u.setAlunoId(rs.getInt("AlunoId"));
		}
		conn.close();
		return u;
	}

}
