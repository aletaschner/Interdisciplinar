package controller;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import DAO.ClienteDao;
import DAO.FinanceiroDao;
import DAO.Uteis;
import view.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Cliente;
import model.Financeiro;

public class ControllerCadFinanceiro implements Initializable{
	@FXML
	TextField Valor, Motivo;
	@FXML
	DatePicker Data;
	@FXML
	Label Tipo;
	private Main Main;
	private int Codigo = 0;
	public char tipo;

	public void setMain(Main m){
		this.Main  = m;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public void Salvar(ActionEvent event) throws SQLException{
		if(checar()){
			FinanceiroDao fd = new FinanceiroDao(this.tipo);
			Financeiro f = new Financeiro();
			f.setTipo(this.tipo);
			Date data;
			//(Data.getEditor().getText().isEmpty());
			//f.setDate(data);
			//Data.getEditor().get
			f.setMotivo(Motivo.getText());
			f.setValor(Double.parseDouble(Valor.getText()));
			fd.setInserir(f);
		}


	}

	public Boolean checar() throws SQLException{
		Boolean Enviar = true;

		if(Motivo.getText().length() < 5){
			JOptionPane.showMessageDialog(null, "Preencha o motivo.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			Enviar = false;
			return false;
		}
		if(Data.getEditor().getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Preencha a data.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			Enviar = false;
			return false;
		}
		if(Valor.getText().length() < 2){
			JOptionPane.showMessageDialog(null, "Preencha o valor.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			Enviar = false;
			return false;
		}
		return Enviar;
	}

	public void carrega(int Codigo) throws SQLException{
		if(Codigo <= 0){
			return;
		}

		FinanceiroDao fd = new FinanceiroDao();
		Financeiro f = fd.getDetalhe(Codigo);


	}

}
