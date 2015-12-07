package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import DAO.ReservaDao;
import view.*;
import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.*;

public class ControllerListaReservas implements Initializable{

	private Main Main;
	private ObservableList<TabListaReserva> itens = FXCollections.observableArrayList();

	@FXML
	TableColumn<TabListaReserva,Number> Codigo, Hospedes, Valor;
	@FXML
	TableColumn<TabListaReserva,String> Cliente, Entrada, Saida, Quarto, StatusPgto;
	@FXML
	TableView<TabListaReserva> ListaReservas;
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

		Codigo.setCellValueFactory(cellData -> cellData.getValue().getCodigo());
		Valor.setCellValueFactory(cellData -> cellData.getValue().getValor());
		Hospedes.setCellValueFactory(cellData -> cellData.getValue().getHospedes());
		Cliente.setCellValueFactory(cellData -> cellData.getValue().getCliente());
		Entrada.setCellValueFactory(cellData -> cellData.getValue().getEntrada());
		Saida.setCellValueFactory(cellData -> cellData.getValue().getSaida());
		Quarto.setCellValueFactory(cellData -> cellData.getValue().getQuarto());
		StatusPgto.setCellValueFactory(cellData -> cellData.getValue().getStatusPgto());

		List<Reserva> reservas;

		try {
			reservas = new ReservaDao().getListar();

			for(int i=0; i< reservas.size(); i++){
				TabListaReserva t = new TabListaReserva(reservas.get(i).getCodigo(), reservas.get(i).getValor(), reservas.get(i).getCodigoCliente(), );

			}

		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(int i = 1; i < 10; i++){
		TabListaReserva t = new TabListaReserva(i, 120, 2, "Quarto", "José da Silva", "14-11-2015", "17-11-2015", "Confirmado");
		itens.add(t);
		}
		ListaReservas.setItems(itens);
		itens.addListener(new ListChangeListener<TabListaReserva>() {
			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends TabListaReserva> arg0) {
				Total.setText(Integer.toString(ListaReservas.getItems().size()));
			}
		});

	}

	public void botoesCtrl(){
		int item = ListaReservas.getSelectionModel().getSelectedCells().size();

		if(item > 0){
			BtnConfirmar.setDisable(false);
			BtnEditar.setDisable(false);
			BtnExcluir.setDisable(false);
		}else{
			BtnConfirmar.setDisable(true);
			BtnEditar.setDisable(true);
			BtnExcluir.setDisable(true);
		}

	}

	public void Editar(){
		int selectedIndex = ListaReservas.getSelectionModel().getSelectedIndex();
		int IdSelecionado = ListaReservas.getItems().get(selectedIndex).getCodigoInt();
		Main.initCadReserva(IdSelecionado);
	}
}