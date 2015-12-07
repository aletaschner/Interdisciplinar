package controller;

import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import DAO.ClienteDao;
import DAO.QuartoDao;
import DAO.ReservaDao;
import view.*;
import model.Quarto;
import model.Reserva;
import model.TabListaQuarto;
import model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControllerCadReserva implements Initializable{

	private int CodigoCliente, CodigoQuarto, QtdDias;
	private Cliente cliente;
	private Quarto quarto;
	private Double ValorQuarto;

	 ObservableList<Cliente> itens = FXCollections.observableArrayList();
	 ObservableList<Quarto>  itens2 = FXCollections.observableArrayList();
	ObservableList<String> Metodos = FXCollections.observableArrayList("Dinheiro","Cartão", "Cheque");
	ObservableList<String> Parcelas = FXCollections.observableArrayList("1","2","3","4","5");
	@FXML
	private Main Main;
	@FXML
	ComboBox<String> Metodo, QtdParcelas;
	@FXML
	ComboBox<String> QuartoSelect;
	@FXML
	ComboBox<String> ClienteSelect;
	@FXML
	private TextField Cliente, Desconto, Motivo, Valor, Quarto, VlrQuarto;
	@FXML
	DatePicker DataEntrada, DataSaida;
	@FXML
	private TextArea Observacao;
	private int Codigo;
	public void setMain(Main m){
		this.Main  = m;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		 ObservableList<String> clientes = FXCollections.observableArrayList(), quartos = FXCollections.observableArrayList();
		 try {
				itens.addAll(new ClienteDao().getListar());
				itens2.addAll(new QuartoDao().getListar());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 for(int e = 0; e< itens.size(); e++){
			 clientes.add(e, itens.get(e).getNome());
		 }
		 for(int b = 0; b<itens2.size(); b++){
			 quartos.add(b, itens2.get(b).getNome());
		 }
		Metodo.setItems(Metodos);
		QtdParcelas.setItems(Parcelas);
		ClienteSelect.setItems(clientes);
		QuartoSelect.setItems(quartos);

	}

	public void Salvar() throws SQLException{
		if(Codigo == 0){
			Reserva r = new Reserva();
			r.setCodigoCliente(this.CodigoCliente);
			r.setCodigoQuarto(this.CodigoQuarto);
			r.setDataEntrada(Date.from(DataEntrada.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
			r.setDataSaida(Date.from(DataSaida.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
			r.setObservacao(Observacao.getText());
			r.setMetodoPgto(Metodo.getSelectionModel().getSelectedIndex());
			r.setQtdParcelas(QtdParcelas.getSelectionModel().getSelectedIndex());
			r.setValor(Double.parseDouble(Valor.getText()));
			r.setValorDesconto(Double.parseDouble(Desconto.getText()));
			r.setMotivoDesconto(Motivo.getText());
			ReservaDao rd = new ReservaDao();
			if(rd.checaDatas(r) == true){
				rd.setInserir(r);
			} else {
				JOptionPane.showMessageDialog(null, "Data não aprovada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			}


		}





	}

	public Boolean checa(){
		Boolean env = true;

		if(ClienteSelect.getSelectionModel().getSelectedIndex() < 0){
			// alerta
			env = false;
			return false;
		}
		if(QuartoSelect.getSelectionModel().getSelectedIndex() < 0){
			// alerta
			env = false;
			return false;
		}
		if(DataEntrada.getEditor().getText() == null){
			// alerta
			env = false;
			return false;
		}
		if(DataSaida.getEditor().getText() == null){
			// alerta
			env = false;
			return false;
		}
		if(Integer.parseInt(Valor.getText()) < 0){
			// alerta
			env = false;
			return false;
		}


		return env;
	}
	public void carrega(int Codigo){
		if(Codigo < 0){
			return;
		}
		//Reserva r =  new ReservaDao().
		Cliente.setText("João");
		Desconto.setText("5%");
		Motivo.setText("Pagamento a vista");
		Quarto.setText("Quarto 1");
		Metodo.setValue("Cartão");
		QtdParcelas.setValue("2");
		Valor.setText("235.00");
		Observacao.setText("bla blab blab blab bla bla bla bla bla bla bla");
	}



	public static int difDatas(java.util.Date dateE, java.util.Date dateS) {
        long tempo1 = dateE.getTime();
        long tempo2 = dateS.getTime();
        long difTempo = tempo2 - tempo1;
        return (int) ((difTempo + 60L * 60 * 1000) / (24L * 60 * 60 * 1000)) + 1;
    }

	public void pegaCliente(){
		int ind = ClienteSelect.getSelectionModel().getSelectedIndex();
		this.CodigoCliente = itens.get(ind).getCodigo();
	}

	public void pegaQuarto(){
		int ind = QuartoSelect.getSelectionModel().getSelectedIndex();
		this.CodigoQuarto = itens2.get(ind).getCodigo();
		this.ValorQuarto = itens2.get(ind).getPreco();
		VlrQuarto.setText(String.valueOf(this.ValorQuarto));
	}

	public void calcula(){
		java.util.Date dateE = Date.from(DataEntrada.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		java.util.Date dateS = Date.from(DataSaida.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
		this.QtdDias = this.difDatas(dateE, dateS);
		for(int i = 0; i< QtdDias; i++){
			System.out.println(dateE.getDate() + i);
		}
		Valor.setText(String.valueOf(QtdDias * ValorQuarto));
	}
}
