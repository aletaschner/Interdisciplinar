//implementacao da interface Initializable para o fx entender que esta eh a crontroler referente a tela
//Faz checagem se o usuario esta logado
//faz as chamadas de todas as outras telas

package controller;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import view.Main;

public class ControlerMain implements Initializable{
	private Main main;
	@FXML
	Button BtnListaReserva;

	public void setMain(Main main) {
		this.main = main;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	public void initCadCliente(){
		main.initCadCliente();
	}

	public void initCadQuarto(){
		main.initCadQuarto();
	}

	public void initCadReserva(){
		main.initCadReserva();
	}

	public void initListaReservas(){
		main.initListaReservas();
	}

	public void initListaClientes(){
		main.initListaClientes();
	}

	public void initListaQuartos(){
		main.initListaQuartos();
	}


}
