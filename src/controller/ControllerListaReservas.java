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

public class ControllerListaReservas implements Initializable{
	@FXML
	ComboBox<String> Nivel;
	private Main Main;

	public void setMain(Main m){
		this.Main  = m;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	public void Salvar(ActionEvent event){
		String valor = Nivel.getValue();
		System.out.println(valor);
	}

}
