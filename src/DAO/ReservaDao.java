package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import model.Cliente;
import model.Reserva;

public class ReservaDao implements IAbstractDao<Reserva> {
	private Connection conn;
	private String sql;

	public ReservaDao() throws SQLException {
		conn = new ConectaMYSQL().getConnection();
	}

	@Override
	public List<Reserva> getListar() throws SQLException {
		sql = "SELECT *"
			+ " FROM hos_reservas";

		PreparedStatement prmt = this.conn.prepareStatement(sql);
		ResultSet rs = prmt.executeQuery();
		List<Reserva> Reservas = new ArrayList<Reserva>();

		while (rs.next()) {
			Reserva r = new Reserva();
			r.setCodigo(rs.getInt("Codigo"));
			r.setCodigoCliente(rs.getInt("CodigoCliente"));
			r.setValor(rs.getDouble("Valor"));
			r.setValorDesconto(rs.getDouble("ValorDesconto"));
			r.setDataEntrada(rs.getDate("DataEntrada"));
			r.setDataSaida(rs.getDate("DataSaida"));
			r.setObservacao(rs.getString("Observacao"));
			r.setMetodoPgto(rs.getInt("CodigoMetodoPagamento"));
			r.setDataCadastro(rs.getDate("DataCadastro"));
			r.setQtdParcelas(rs.getInt("QtdParcelas"));
			r.setMotivoDesconto(rs.getString("MotivoDesconto"));
			r.setCodigoQuarto(rs.getInt("CodigoQuarto"));

		}
		conn.close();
		return Reservas;
	}

	@Override
	public void setInserir(Reserva objeto) throws SQLException {
		if (objeto == null) {
			System.out.println("Nulo");

		} else {
			// @todo criar procedure
			sql = "INSERT INTO hos_reservas( DataEntrada, DataSaida, Valor, ValorDesconto, MotivoDesconto, IsParcelamento, QtdParcelas, CodigoMetodoPagamento, CodigoCliente, CodigoQuarto, Observacao)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement prmt = this.conn.prepareStatement(sql);

		//	prmt.setDate(1, new java.sql.Date(objeto.getDataCadastro().getTime()));
			prmt.setDate(1, new java.sql.Date(objeto.getDataEntrada().getTime()));
			prmt.setDate(2, new java.sql.Date(objeto.getDataSaida().getTime()));
			prmt.setDouble(3, objeto.getValor());
			prmt.setDouble(4, objeto.getValorDesconto());
			prmt.setString(5, objeto.getMotivoDesconto());
			prmt.setString(6, "N");
			prmt.setInt(7, objeto.getQtdParcelas());
			prmt.setInt(8, objeto.getMetodoPgto());
			prmt.setInt(9, objeto.getCodigoCliente());
			prmt.setInt(10, objeto.getCodigoQuarto());
			prmt.setString(11, objeto.getObservacao());

			int d = prmt.executeUpdate();
			System.out.println(d);
			if(d > 0){
				objeto.setCodigo(d);
				addDatas(objeto);
				JOptionPane.showMessageDialog(null, "Reserva cadastrada com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}



			prmt.close();
		}
		conn.close();
	}
	public boolean addDatas(Reserva r) throws SQLException{
		Boolean suc = true;
		for(int i =0; i <= r.getQtdDias(); i++){
			this.sql = "INSERT INTO hos_reservas_datas(CodigoReserva, CodigoQuarto, Data) "+
						" VALUES (?, ?, ?)";
			Date d = r.getDataEntrada();
			d.setDate(d.getDate()+i);
			java.sql.Date ds = new java.sql.Date(d.getTime());
			PreparedStatement prmt = this.conn.prepareStatement(sql);
			prmt.setInt(1, r.getCodigo());
			prmt.setInt(2, r.getCodigoQuarto());
			prmt.setDate(3, ds);
			prmt.execute();
		}

		return suc;
	}

	public Boolean checaDatas(Reserva r) throws SQLException{
		Boolean suc = true;
		for(int i =0; i <= r.getQtdDias(); i++){
			this.sql = "SELECT * FROM hos_reservas_datas WHERE Data=? AND CodigoQuarto=?";
			Date d = r.getDataEntrada();
			d.setDate(d.getDate()+i);
			java.sql.Date ds = new java.sql.Date(d.getTime());
			PreparedStatement prmt = this.conn.prepareStatement(sql);
			prmt.setDate(1, ds);
			prmt.setInt(2, r.getCodigoQuarto());
			ResultSet rs =	prmt.executeQuery();
			while(rs.next()){
				suc = false;
			}
		}
		return suc;
	}

	@Override
	public void setAlterar(Reserva objeto) throws SQLException {
		if (objeto == null) {
			System.out.println("Nulo");
		} else {

			sql = "UPDATE hos_reservas SET Valor=?, ValorDesconto=?, IsParcelamento=?, QtdParcelas=?, CodigoMetodoPagamento=?, CodigoCliente=?, CodigoQuarto=?, Observacao=?"
					+ " WHERE Codigo=?";
			PreparedStatement prmt = this.conn.prepareStatement(sql);

			prmt.setDouble(1, objeto.getValor());
			prmt.setDouble(2, objeto.getValorDesconto());
			prmt.setString(3, objeto.getMotivoDesconto());
			prmt.setString(4, "N");
			prmt.setInt(5, objeto.getQtdParcelas());
			prmt.setInt(6, objeto.getMetodoPgto());
			prmt.setInt(7, objeto.getCodigoQuarto());
			prmt.setString(8, objeto.getObservacao());

			prmt.setInt(9, objeto.getCodigo());

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
	public Reserva getDetalhe(int codigo) throws SQLException {
		sql = "Select * FROM hos_reservas WHERE Codigo=?";

		PreparedStatement prmt = this.conn.prepareStatement(sql);

		prmt.setInt(1, codigo);
		ResultSet rs = prmt.executeQuery();
		Reserva r = null;
		if (rs.next()) {
			r = new Reserva();
			r.setCodigo(rs.getInt("Codigo"));
			r.setDataCadastro(rs.getDate("DataCadastro"));
			r.setDataEntrada(rs.getDate("DataEntrada"));
			r.setDataSaida(rs.getDate("DataSaida"));
			r.setValor(rs.getDouble("Valor"));
			r.setValorDesconto(rs.getDouble("ValoDesconto"));
			r.setMotivoDesconto(rs.getString("MotivoDesconto"));
			r.setQtdParcelas(rs.getInt("QtdParcelas"));
			r.setMetodoPgto(rs.getInt("CodigoMetodoPagamento"));
			r.setCodigoCliente(rs.getInt("CodigoCliente"));
			r.setCodigoQuarto(rs.getInt("CodigoQuarto"));
			r.setObservacao(rs.getString("Observacao"));
		}
		conn.close();
		return r;
	}

}
