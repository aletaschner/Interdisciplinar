package controller;

import java.net.URL;
import java.util.ResourceBundle;
import view.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControllerCadReserva implements Initializable{

	ObservableList<String> Metodos = FXCollections.observableArrayList("Dinheiro","Cartão", "Cheque");
	ObservableList<String> Parcelas = FXCollections.observableArrayList("1","2","3","4","5");
	@FXML
	private Main Main;
	@FXML
	ComboBox<String> Metodo, QtdParcelas;
	@FXML
	private TextField Cliente, Desconto, Motivo, Valor, Quarto;
	@FXML
	private TextArea Observacao;

	public void setMain(Main m){
		this.Main  = m;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Metodo.setItems(Metodos);
		QtdParcelas.setItems(Parcelas);
	}

	public void CarregaReserva(int Codigo){
		Cliente.setText("João");
		Desconto.setText("5%");
		Motivo.setText("Pagamento a vista");
		Quarto.setText("Quarto 1");
		Metodo.setValue("Cartão");
		QtdParcelas.setValue("2");
		Valor.setText("235.00");
		Observacao.setText("bla blab blab blab bla bla bla bla bla bla bla");
	}

}
