package controller;

import java.net.URL;
import java.util.ResourceBundle;
import view.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.TabListaCliente;

public class ControllerListaClientes implements Initializable{

	private Main Main;

	private ObservableList<TabListaCliente> itens = FXCollections.observableArrayList();

	@FXML
	TableColumn<TabListaCliente,Number> Codigo;
	@FXML
	TableColumn<TabListaCliente,String> Nome, Email, Telefone, Celular, Pais;
	@FXML
	TableView<TabListaCliente> ListaClientes;
	@FXML
	TextField Total;
	@FXML
	Button btnConfirmar, btnEditar, btnExcluir;

	public void setMain(Main m){
		this.Main  = m;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		Codigo.setCellValueFactory(cellData -> cellData.getValue().getCodigo());
		Nome.setCellValueFactory(cellData -> cellData.getValue().getNome());
		Email.setCellValueFactory(cellData -> cellData.getValue().getEmail());
		Telefone.setCellValueFactory(cellData -> cellData.getValue().getTelefone());
		Celular.setCellValueFactory(cellData -> cellData.getValue().getCelular());
		Pais.setCellValueFactory(cellData -> cellData.getValue().getPais());
		for(int i = 1; i < 10; i++){
		TabListaCliente t = new TabListaCliente(i, "João", "joão@gmail.com", "(47)3396-7819", "(47)9754-7721", "Brasil");
		itens.add(t);
		}
		ListaClientes.setItems(itens);

	}

}
