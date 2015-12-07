package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import DAO.FinanceiroDao;
import view.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Financeiro;
import model.TabListaCliente;
import model.TabListaFinanceiro;
import model.TabListaReserva;

public class ControllerFinanceiro implements Initializable{

	private Main Main;

	private ObservableList<TabListaFinanceiro> entradas = FXCollections.observableArrayList();
	private ObservableList<TabListaFinanceiro> saidas = FXCollections.observableArrayList();
	ObservableList<String> PeriodoEntrada = FXCollections.observableArrayList("Este Ano","Este mês", "Esta Semana");
	ObservableList<String> PeriodoSaida = FXCollections.observableArrayList("Este Ano","Este mês", "Esta Semana");
	@FXML
	TableColumn<TabListaFinanceiro,Number> CodigoEntrada, CodigoSaida, ValorEntrada, ValorSaida;
	@FXML
	TableColumn<TabListaFinanceiro,String> MotivoEntrada, MotivoSaida;
	@FXML
	TableView<TabListaFinanceiro> ListaEntradas, ListaSaidas;
	@FXML
	TextField TotalSaida, TotalEntrada;
	@FXML
	Button BtnCadEntrada, BtnEdEntrada, BtnExcEntrada, BtnCadSaida, BtnEdSaida, BtnExcSaida;
	@FXML
	ComboBox ComboBoxEntradas, ComboBoxSaidas;

	public void setMain(Main m){
		this.Main  = m;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		try {
			this.CarregaListaSaida(1);
			this.CarregaListaEntrada(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ComboBoxEntradas.setItems(PeriodoEntrada);
		ComboBoxSaidas.setItems(PeriodoSaida);
		ComboBoxEntradas.setValue("Este mês");
		ComboBoxSaidas.setValue("Este mês");
	}

	public void CarregaListaEntrada(int opt) throws SQLException{
		CodigoEntrada.setCellValueFactory(cellData -> cellData.getValue().getCodigo());
		MotivoEntrada.setCellValueFactory(cellData -> cellData.getValue().getMotivo());
		ValorEntrada.setCellValueFactory(cellData -> cellData.getValue().getValor());
		List<Financeiro> entrada;
		FinanceiroDao f = new FinanceiroDao('E');
			entrada = f.getListar();
		for(int i = 0; i < entrada.size(); i++){

		TabListaFinanceiro t = new TabListaFinanceiro(entrada.get(i).getCodigo(), entrada.get(i).getMotivo(), entrada.get(i).getValor());
		entradas.add(t);
		}
		ListaEntradas.setItems(entradas);
		entradas.addListener(new ListChangeListener<TabListaFinanceiro>() {
			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends TabListaFinanceiro> arg0) {
				TotalEntrada.setText(Integer.toString(ListaEntradas.getItems().size()));
			}
		});

	}
	public void CarregaListaSaida(int opt) throws SQLException{
		CodigoSaida.setCellValueFactory(cellData -> cellData.getValue().getCodigo());
		MotivoSaida.setCellValueFactory(cellData -> cellData.getValue().getMotivo());
		ValorSaida.setCellValueFactory(cellData -> cellData.getValue().getValor());
		List<Financeiro> entrada;
		FinanceiroDao f = new FinanceiroDao('S');
			entrada = f.getListar();
		for(int i = 0; i < entrada.size(); i++){

		TabListaFinanceiro t = new TabListaFinanceiro(entrada.get(i).getCodigo(), entrada.get(i).getMotivo(), entrada.get(i).getValor());
		saidas.add(t);
		}		ListaSaidas.setItems(saidas);
		saidas.addListener(new ListChangeListener<TabListaFinanceiro>() {
			@Override
			public void onChanged(javafx.collections.ListChangeListener.Change<? extends TabListaFinanceiro> arg0) {
				TotalSaida.setText(Integer.toString(ListaSaidas.getItems().size()));
			}
		});
	}

	public void saidaBotoes(){
		int item = ListaSaidas.getSelectionModel().getSelectedCells().size();

		if(item > 0){
			BtnEdSaida.setDisable(false);
			BtnExcSaida.setDisable(false);
		}else{
			BtnEdSaida.setDisable(true);
			BtnExcSaida.setDisable(true);
		}

	}
	public void entradaBotoes(){
		int item = ListaEntradas.getSelectionModel().getSelectedCells().size();

		if(item > 0){
			BtnEdEntrada.setDisable(false);
			BtnExcEntrada.setDisable(false);
		}else{
			BtnEdEntrada.setDisable(true);
			BtnExcEntrada.setDisable(true);
		}

	}

	public void initCadEntrada(){
		Main.initCadFinanceiro('E');
	}

	public void initCadSaida(){
		Main.initCadFinanceiro('S');
	}
}
