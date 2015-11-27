package model;

public class Quarto {

	private int Codigo, QtdCamas;
	private double Preco;
	private String[] Fotos;

	public void setCodigo(int Codigo){
		this.Codigo = Codigo;
	}
	public int getCodigo(){
		return this.Codigo;
	}
	public void setQtdCamas(int QtdCamas){
		this.QtdCamas = QtdCamas;
	}
	public int getQtdCamas(){
		return this.QtdCamas;
	}
	public void setPreco(Double Preco){
		this.Preco = Preco;
	}
	public Double getPreco(){
		return this.Preco;
	}
	public void setFotos(String[] Fotos){
		this.Fotos = Fotos;
	}
	public String[] getFotos(){
		return this.Fotos;
	}
}
