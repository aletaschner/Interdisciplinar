package model;

import java.sql.Date;

public class Reserva {

	private int Codigo, CodigoCliente, StatusPgto, QtdParcelas, MetodoPagamento, CodigoQuarto, QtdDias, QtdVisitantes;
	private java.util.Date DataCadastro, DataEntrada, DataSaida;
	private Double Valor, ValorDesconto;
	private String Observacao, MotivoDesconto;

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
	public java.util.Date getDataCadastro(){
		return this.DataCadastro;
	}
	public void setDataEntrada(java.util.Date date){
		this.DataEntrada = date;
	}
	public java.util.Date getDataEntrada(){
		return this.DataEntrada;
	}
	public void setDataSaida(java.util.Date date){
		this.DataSaida = date;
	}
	public java.util.Date getDataSaida(){
		return this.DataSaida;
	}
	public void setValor(Double Valor){
		this.Valor = Valor;
	}
	public Double getValor(){
		return this.Valor;
	}
	public void setMetodoPgto(int MetodoPgto){
		this.MetodoPagamento = MetodoPgto;
	}
	public int getMetodoPgto(){
		return this.MetodoPagamento;
	}
	public String getObservacao(){
		return this.Observacao;
	}
	public void setObservacao(String Observacao){
		this.Observacao = Observacao;
	}
	public Double getValorDesconto(){
		return this.ValorDesconto;
	}
	public void setValorDesconto(Double ValorDesconto){
		this.ValorDesconto = ValorDesconto;
	}
	public String getMotivoDesconto(){
		return this.MotivoDesconto;
	}
	public void setMotivoDesconto(String MotivoDesconto){
		this.MotivoDesconto = MotivoDesconto;
	}
	public int getQtdParcelas(){
		return this.QtdParcelas;
	}
	public void setQtdParcelas(int QtdParcelas){
		this.QtdParcelas = QtdParcelas;
	}
	public int getCodigoQuarto(){
		return this.CodigoQuarto;
	}
	public void setCodigoQuarto(int CodigoQuarto){
		this.CodigoQuarto = CodigoQuarto;
	}
	public void setQtdDias(int QtdDias){
		this.QtdDias = QtdDias;
	}
	public int getQtdDias(){
		return this.QtdDias;
	}
}
