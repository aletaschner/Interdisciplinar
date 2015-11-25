package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TabListaFinanceiro {
	private final IntegerProperty Codigo;
	private final StringProperty Motivo;
	private final DoubleProperty Valor;

	public TabListaFinanceiro(){
		this.Codigo = null;
		this.Motivo = null;
		this.Valor = null;
	}

	public TabListaFinanceiro(int Codigo, String Motivo, Double Valor){
		this.Codigo = new SimpleIntegerProperty(Codigo);
		this.Motivo = new SimpleStringProperty(Motivo);
		this.Valor = new SimpleDoubleProperty(Valor);
		}

	public IntegerProperty getCodigo() {
		return Codigo;
	}
	public void setCodigo(int codigo) {
		this.Codigo.set(codigo);
	}
	public int getCodigoInt() {
		return Codigo.get();
	}
	public StringProperty getMotivo(){
		return this.Motivo;
	}
	public void setMotivo(String Motivo){
		this.Motivo.set(Motivo);
	}
	public String getMotivoString(){
		return this.Motivo.get();
	}
	public DoubleProperty getValor(){
		return this.Valor;
	}
	public void setValor(Double valor){
		this.Valor.set(valor);
	}
	public Double getValorDouble(){
		return this.Valor.get();
	}
}
