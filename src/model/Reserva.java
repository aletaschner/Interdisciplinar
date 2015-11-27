package model;

import java.sql.Date;

public class Reserva {

	private int Codigo, CodigoCliente, StatusPgto;
	private Date DataCadastro, DataEntrada, DataSaida;
	private Double Valor;
	private String MetodoPagamento;

	public void setCodigo(int Codigo){
		this.Codigo = Codigo;
	}
	public int getCodigo(){
		return this.Codigo;
	}
	public void setCodigoCliente(int CodigoCliente){
		this.CodigoCliente = CodigoCliente;
	}
	public int getCodigoCliente(){
		return this.CodigoCliente;
	}
	public void setStatusPgto(int StatusPgto){
		this.StatusPgto = StatusPgto;
	}
	public int getStatusPgto(){
		return this.StatusPgto;
	}
	public void setDataCadastro(Date DataCadastro){
		this.DataCadastro = DataCadastro;
	}
	public Date getDataCadastro(){
		return this.DataCadastro;
	}
	public void setDataEntrada(Date DataEntrada){
		this.DataEntrada = DataEntrada;
	}
	public Date getDataEntrada(){
		return this.DataEntrada;
	}
	public void setDataSaida(Date DataSaida){
		this.DataSaida = DataSaida;
	}
	public Date getDataSaida(){
		return this.DataSaida;
	}
	public void setValor(Double Valor){
		this.Valor = Valor;
	}
	public Double getValor(){
		return this.Valor;
	}
	public void setMetodoPgto(String MetodoPgto){
		this.MetodoPagamento = MetodoPgto;
	}
	public String getMetodoPgto(){
		return this.MetodoPagamento;
	}
}
