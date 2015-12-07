package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import DAO.ClienteDao;
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
import model.Cliente;
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
	Button BtnConfirmar, BtnEditar, BtnExcluir;

	public void setMain(Main m){
		this.Main  = m;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		String telefone, celular;
		Codigo.setCellValueFactory(cellData -> cellData.getValue().getCodigo());
		Nome.setCellValueFactory(cellData -> cellData.getValue().getNome());
		Email.setCellValueFactory(cellData -> cellData.getValue().getEmail());
		Telefone.setCellValueFactory(cellData -> cellData.getValue().getTelefone());
		Celular.setCellValueFactory(cellData -> cellData.getValue().getCelular());
		Pais.setCellValueFactory(cellData -> cellData.getValue().getPais());
		List<Cliente> clientes;
		try {
			clientes = new ClienteDao().getListar();
			for(int contador = 0; contador<clientes.size();contador++){
				telefone = String.valueOf(clientes.get(contador).getTelefone());
				celular = String.valueOf(clientes.get(contador).getCelular());
				TabListaCliente tab = new TabListaCliente(clientes.get(contador).getCodigo(), clientes.get(contador).getNome(), clientes.get(contador).getEmail(), telefone, celular, clientes.get(contador).getRua());
				itens.add(tab);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ListaClientes.setItems(itens);

	}

	public void botoesCtrl(){
		int item = ListaClientes.getSelectionModel().getSelectedCells().size();

		if(item > 0){
			BtnEditar.setDisable(false);
			BtnExcluir.setDisable(false);
		}else{
			BtnEditar.setDisable(true);
			BtnExcluir.setDisable(true);
		}

	}

	public void editarCliente(){
		int selectedIndex = ListaClientes.getSelectionModel().getSelectedIndex();
		int IdSelecionado = ListaClientes.getItems().get(selectedIndex).getCodigoInt();
		Main.initCadCliente(IdSelecionado);
	}

	public void cadastrarCliente(){
		Main.initCadCliente();
	}

}
