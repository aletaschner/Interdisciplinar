package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TabListaReserva {
	private final IntegerProperty Codigo, Valor, Hospedes;
	private final StringProperty Cliente, Quarto, Entrada, Saida, StatusPgto;

	public TabListaReserva(){
		this.Codigo = null;
		this.Valor = null;
		this.Hospedes = null;
		this.Cliente = null;
		this.Quarto = null;
		this.Entrada = null;
		this.Saida = null;
		this.StatusPgto = null;
	}

	public TabListaReserva(int c, int v, int h, String cl ,String q, String e, String s, String pgt){
		Codigo = new SimpleIntegerProperty(c);
		Valor = new SimpleIntegerProperty(v);
		Hospedes = new SimpleIntegerProperty(h);
		Cliente = new SimpleStringProperty(cl);
		Quarto = new SimpleStringProperty(q);
		Entrada = new SimpleStringProperty(e);
		Saida = new SimpleStringProperty(s);
		StatusPgto = new SimpleStringProperty(pgt);
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
	public IntegerProperty getValor() {
		return Valor;
	}
	public void setValor(int valor){
		this.Valor.set(valor);
	}
	public int getValorInt(){
		return Valor.get();
	}
	public IntegerProperty getHospedes(){
		return Hospedes;
	}
	public void setHospedes(int hospedes){
		this.Hospedes.set(hospedes);
	}
	public int getHospedesInt(){
		return Hospedes.get();
	}
	public StringProperty getCliente(){
		return Cliente;
	}
	public void setCliente(String cliente){
		this.Cliente.set(cliente);
	}
	public String getClienteString(){
		return Cliente.get();
	}
	public StringProperty getQuarto(){
		return Quarto;
	}
	public void setQuarto(String quarto){
		this.Quarto.set(quarto);
	}
	public String getQuartoString(){
		return Quarto.get();
	}
	public StringProperty getEntrada(){
		return Entrada;
	}
	public void setEntrada(String entrada){
		this.Entrada.set(entrada);
	}
	public String getEntradaString(){
		return Entrada.get();
	}
	public StringProperty getSaida(){
		return Saida;
	}
	public void setSaida(String saida){
		this.Saida.set(saida);
	}
	public String getSaidaString(){
		return Saida.get();
	}
	public StringProperty getStatusPgto(){
		return StatusPgto;
	}
	public void setStatusPgto(String statuspgto){
		this.StatusPgto.set(statuspgto);
	}
	public String getStatusPgtoString(){
		return StatusPgto.get();
	}
}
