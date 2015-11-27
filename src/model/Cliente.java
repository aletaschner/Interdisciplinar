package model;

public class Cliente {
 private int Codigo, Telefone, Celular, CodCidade, EndNum;
 private String CPF, Rua, Bairro, Nome, Senha, Email;

 public void setCodigo(int Codigo){
	 this.Codigo = Codigo;
 }
 public int getCodigo(){
	 return this.Codigo;
 }
 public void setTelefone(int Telefone){
	 this.Telefone = Telefone;
 }
 public int getTelefone(){
	 return this.Telefone;
 }
 public void setCelular(int Celular){
	 this.Celular = Celular;
 }
 public int getCelular(){
	 return this.Celular;
 }
 public void setCodCidade(int CodCidade){
	 this.CodCidade = CodCidade;
 }
 public int getCodCidade(){
	 return this.CodCidade;
 }
 public void setEndNum(int EndNum){
	 this.EndNum = EndNum;
 }
 public int getEndNum(){
	 return this.EndNum;
 }
 public void setCPF(String CPF){
	 this.CPF = CPF;
 }
 public String getCPF(){
	 return this.CPF;
 }
 public void setRua(String Rua){
	 this.Rua = Rua;
 }
 public String getRua(){
	 return this.Rua;
 }
 public void setBairro(String Bairro){
	 this.Bairro = Bairro;
 }
 public String getBairro(){
	 return this.Bairro;
 }
 public void setNome(String Nome){
	 this.Nome = Nome;
 }
 public String getNome(){
	 return this.Nome;
 }
 public void setEmail(String Email){
	 this.Email = Email;
 }
 public String getEmail(){
	 return this.Email;
 }
 public void setSenha(String Senha){
	 this.Senha = Senha;
 }
 public String getSenha(){
	 return this.Senha;
 }
}
