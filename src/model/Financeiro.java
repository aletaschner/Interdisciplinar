package model;

import java.sql.Date;
import java.time.LocalDate;

public class Financeiro {
	private int Codigo;
	private char Tipo;
	private String Motivo;
	private java.util.Date Data;
	private Double Valor;

	public void setCodigo(int Codigo){
		this.Codigo = Codigo;
	}
	public int getCodigo(){
		return this.Codigo;
	}
	public void setTipo(char Tipo){
		this.Tipo = Tipo;
	}
	public char getTipo(){
		return this.Tipo;
	}
	public void setMotivo(String Motivo){
		this.Motivo = Motivo;
	}
	public String getMotivo(){
		return this.Motivo;
	}
	public void setValor(Double Valor){
		this.Valor = Valor;
	}
	public Double getValor(){
		return this.Valor;
	}
	public void setDate(java.util.Date date){
		this.Data = date;
	}
	public java.util.Date getDate(){
		return this.Data;
	}
}
