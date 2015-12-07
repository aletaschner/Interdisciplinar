package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import DAO.ClienteDao;
import DAO.QuartoDao;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Cliente;
import model.Quarto;
import model.TabListaCliente;
import model.TabListaQuarto;

public class ControllerListaQuartos implements Initializable{

	private ObservableList<TabListaQuarto> itens = FXCollections.observableArrayList();

	@FXML
	TableColumn<TabListaQuarto,Number> Codigo, Capacidade;
	@FXML
	TableColumn<TabListaQuarto,String> Nome, Configuracao;
	@FXML
	TableColumn<TabListaQuarto,Double> Preco;
	@FXML
	TableView<TabListaQuarto> ListaQuartos;
	@FXML
	TextField Total;
	@FXML
	Button BtnConfirmar, BtnEditar, BtnExcluir;
	private Main Main;

	public void setMain(Main m){
		this.Main  = m;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		Nome.setCellValueFactory(cellData -> cellData.getValue().getNome());
		Codigo.setCellValueFactory(cellData -> cellData.getValue().getCodigo());
		Capacidade.setCellValueFactory(cellData -> cellData.getValue().getCapacidade());
		//Preco.setCellValueFactory(cellData -> cellData.getValue().getPreco());
		Configuracao.setCellValueFactory(cellData -> cellData.getValue().getConfiguracao());
		List<Quarto> quartos;

		try {
			quartos = new QuartoDao().getListar();
			for(int contador = 0; contador<quartos.size();contador++){
				TabListaQuarto tab = new TabListaQuarto(quartos.get(contador).getCodigo(), quartos.get(contador).getQtdCamas(), quartos.get(contador).getNome(), "Mixed", quartos.get(contador).getPreco());
				itens.add(tab);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ListaQuartos.setItems(itens);

	}

	public void cadastrarQuarto(){
		Main.initCadQuarto();
	}

	public void editarQuarto(){
		int selectedIndex = ListaQuartos.getSelectionModel().getSelectedIndex();
		int IdSelecionado = ListaQuartos.getItems().get(selectedIndex).getCodigoInt();
		Main.initCadQuarto(IdSelecionado);
	}

	public void deletarQuarto() throws SQLException{
		int selectedIndex = ListaQuartos.getSelectionModel().getSelectedIndex();
		int IdSelecionado = ListaQuartos.getItems().get(selectedIndex).getCodigoInt();
		int opt = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar este quarto");
		if(opt == 0){
			new QuartoDao().setExcluir(IdSelecionado);
		}
	}

	public void botoesCtrl(){
		int item = ListaQuartos.getSelectionModel().getSelectedCells().size();

		if(item > 0){
			BtnEditar.setDisable(false);
			BtnExcluir.setDisable(false);
		}else{
			BtnEditar.setDisable(true);
			BtnExcluir.setDisable(true);
		}

	}
}
