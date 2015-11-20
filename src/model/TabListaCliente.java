package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TabListaCliente {
	private final IntegerProperty Codigo;
	private final StringProperty Nome, Email, Telefone, Celular, Pais;

	public TabListaCliente(){
		this.Codigo = null;
		this.Nome = null;
		this.Telefone = null;
		this.Celular = null;
		this.Email = null;
		this.Pais = null;
	}

	public TabListaCliente(int Codigo, String Nome, String Email, String Telefone, String Celular, String Pais){
		this.Codigo = new SimpleIntegerProperty(Codigo);
		this.Nome = new SimpleStringProperty(Nome);
		this.Email = new SimpleStringProperty(Email);
		this.Telefone = new SimpleStringProperty(Telefone);
		this.Celular = new SimpleStringProperty(Celular);
		this.Pais = new SimpleStringProperty(Pais);
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
	public StringProperty getNome(){
		return this.Nome;
	}
	public void setNome(String cliente){
		this.Nome.set(cliente);
	}
	public String getNomeString(){
		return this.Nome.get();
	}
	public StringProperty getEmail(){
		return this.Email;
	}
	public void setEmail(String email){
		this.Email.set(email);
	}
	public String getEmailString(){
		return this.Email.get();
	}
	public StringProperty getTelefone(){
		return this.Telefone;
	}
	public void setTelefone(String telefone){
		this.Telefone.set(telefone);
	}
	public String getTelefoneString(){
		return this.Telefone.get();
	}
	public StringProperty getCelular(){
		return this.Celular;
	}
	public void setCelular(String celular){
		this.Celular.set(celular);
	}
	public String getCelularString(){
		return this.Celular.get();
	}
	public StringProperty getPais(){
		return this.Pais;
	}
	public void setPais(String pais){
		this.Pais.set(pais);
	}
	public String getPaisString(){
		return this.Pais.get();
	}

}
