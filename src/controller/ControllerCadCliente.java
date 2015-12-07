package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import DAO.ClienteDao;
import DAO.Uteis;
import view.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cliente;

public class ControllerCadCliente implements Initializable{
	@FXML
	TextField Email, Num, Telefone, Complemento, Referencia, Bairro, Estado, Cidade, CEP, Celular, Senha, SenhaConfirma, Nome, Pais, Rua, CPF;
	@FXML
	TextArea Observacao;
	private Main Main;
	private int Codigo = 0;

	public void setMain(Main m){
		this.Main  = m;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	public void Salvar(ActionEvent event) throws SQLException{
		if(checar()){
			Cliente c = new Cliente();
			c.setNome(Nome.getText());
			c.setCPF(CPF.getText());
			int Tel = Integer.parseInt(Telefone.getText());
			c.setTelefone(Tel);
			int Cel = Integer.parseInt(Celular.getText());
			c.setCelular(Cel);
			c.setCodCidade(5);
			c.setRua(Rua.getText());
			c.setBairro(Bairro.getText());
			int Nume = Integer.parseInt(Num.getText());
			c.setEndNum(Nume);
			c.setSenha(Senha.getText());
			c.setEmail(Email.getText());

			ClienteDao Cd = new ClienteDao();

			if(this.Codigo == 0){
				Cd.setInserir(c);
			} else {
				c.setCodigo(Codigo);
				Cd.setAlterar(c);

			}
			Main.getPrimaryStage().close();
			Main.initMain();
		}


	}

	public Boolean checar() throws SQLException{
		Uteis util = new Uteis();
		Boolean Enviar = true;
		String Meiol = Email.getText();
		if(Email.getText().length() < 8 || util.checaEmailCliente(Email.getText(), Codigo) == false ){
			JOptionPane.showMessageDialog(null, "Preencha um e-mail válido que não tenha sido usado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			Enviar = false;
			return false;
		}
		if(CPF.getText().length() < 8 || util.checaCPFCliente(CPF.getText(), Codigo) == false){
			JOptionPane.showMessageDialog(null, "Preencha um CPF válido que não tenha sido usado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			Enviar = false;
			return false;
		}
		if(Telefone.getText().length() < 8){
			JOptionPane.showMessageDialog(null, "Preencha um telefone válido.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			Enviar = false;
			return false;
		}
		if(Bairro.getText().length() < 8 ){
			JOptionPane.showMessageDialog(null, "Preencha um bairro válido.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			Enviar = false;
			return false;
		}
		if(Estado.getText().length() < 2){
			JOptionPane.showMessageDialog(null, "Preencha um estado válido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			Enviar = false;
			return false;
		}
		if(Nome.getText().length() < 8){
			JOptionPane.showMessageDialog(null, "Preencha um nome válido.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			Enviar = false;
			return false;
		}
		if(Senha.getText().length() < 2 || SenhaConfirma.getText().length() < 2){
			JOptionPane.showMessageDialog(null, "Preencha as duas senhas.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			Enviar = false;
			return false;
		}
		/*
		if(Senha.getText() != SenhaConfirma.getText()){
			JOptionPane.showMessageDialog(null, "Preencha as duas senhas iguais.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			Enviar = false;
			return false;
		} */
		if(Celular.getText().length() < 8){
			JOptionPane.showMessageDialog(null, "Preencha um celular válido.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			Enviar = false;
			return false;
		}
		if(Cidade.getText().length() < 8){
			JOptionPane.showMessageDialog(null, "Preencha uma cidade válida.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			Enviar = false;
			return false;
		}
		return Enviar;
	}

	public void carrega(int Codigo) throws SQLException{
		if(Codigo <= 0){
			return;
		}
		this.Codigo = Codigo;
		ClienteDao cd = new ClienteDao();
		Cliente a = cd.getDetalhe(Codigo);
		Nome.setText(a.getNome());
		CPF.setText(a.getCPF());
		Telefone.setText(String.valueOf(a.getTelefone()));
		Celular.setText(String.valueOf(a.getCelular()));
		Cidade.setText("Brusque");
		Rua.setText(a.getRua());
		Bairro.setText(a.getBairro());
		Num.setText(String.valueOf(a.getEndNum()));
		Senha.setText(a.getSenha());
		SenhaConfirma.setText(a.getSenha());
		Email.setText(a.getEmail());
	}

}
