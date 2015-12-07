package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TabListaQuarto {
	private final IntegerProperty Codigo, Capacidade;
	private final StringProperty Nome, Configuracao;
	private final DoubleProperty Preco;

	public TabListaQuarto(){
		this.Codigo = null;
		this.Capacidade = null;
		this.Nome = null;
		this.Configuracao = null;
		this.Preco = null;
	}

	public TabListaQuarto(int c, int ca, String n, String co ,Double p){
		Codigo = new SimpleIntegerProperty(c);
		Nome = new SimpleStringProperty(n);
		Capacidade = new SimpleIntegerProperty(ca);
		Configuracao = new SimpleStringProperty(co);
		Preco = new SimpleDoubleProperty(p);
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
	public IntegerProperty getCapacidade(){
		return Capacidade;
	}
	public void setCapacidade(int Capacidade){
		this.Capacidade.set(Capacidade);
	}
	public int getCapacidadeInt(){
		return this.Capacidade.get();
	}
	public StringProperty getNome(){
		return Nome;
	}
	public void setNome(String Nome){
		this.Nome.set(Nome);
	}
	public String getNomeString(){
		return this.Nome.get();
	}
	public DoubleProperty getPreco(){
		return this.Preco;
	}
	public void setPreco(Double Preco){
		this.Preco.set(Preco);
	}
	public Double getPrecoDouble(){
		return this.Preco.get();
	}
	public StringProperty getConfiguracao(){
		return this.Configuracao;
	}
	public void setConfiguracao(String Configuracao){
		this.Configuracao.set(Configuracao);
	}
	public String getConfiguracaoString(){
		return this.Configuracao.get();
	}
}
