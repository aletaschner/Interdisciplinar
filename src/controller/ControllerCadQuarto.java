package controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import DAO.QuartoDao;
import view.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import model.Quarto;

public class ControllerCadQuarto implements Initializable{

	@FXML
	TextField Nome, Preco, Capacidade;
	@FXML
	TextArea Observacao;
	@FXML
	Region AreaFoto;
	@FXML
	Label LabelFoto;
	@FXML
	ImageView FotoCapa;
	private int Codigo;
	private Main Main;
	private File foto;

	public void setMain(Main m){
		this.Main  = m;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

	public void Salvar(ActionEvent event) throws IOException, SQLException{
		Quarto q = new Quarto();
		if(checar() == true){
			q.setNome(Nome.getText());
			q.setPreco(Double.parseDouble(Preco.getText()));
			q.setQtdCamas(Integer.parseInt(Capacidade.getText()));
			if(Codigo == 0){
			q.setFotoCapa(this.foto.getName());
			InputStream in = new FileInputStream(this.foto);
	        OutputStream out = new FileOutputStream("C:/Hostel/Assets/Quartos/"+this.foto.getName());           // Transferindo bytes de entrada para saída
	        byte[] buf = new byte[1024];
	        int len;
	        while ((len = in.read(buf)) > 0) {
	            out.write(buf, 0, len);
	        }
	        in.close();
	        out.close();
			} else {
				if(foto != null){
					q.setFotoCapa(this.foto.getName());
					InputStream in = new FileInputStream(this.foto);
			        OutputStream out = new FileOutputStream("C:/Hostel/Assets/Quartos/"+this.foto.getName());           // Transferindo bytes de entrada para saída
			        byte[] buf = new byte[1024];
			        int len;
			        while ((len = in.read(buf)) > 0) {
			            out.write(buf, 0, len);
			        }
			        in.close();
			        out.close();

				}
				q.setFotoCapa(LabelFoto.getText());
			}
			QuartoDao qd = new QuartoDao();
			if(Codigo == 0){
				qd.setInserir(q);
			} else {
				q.setCodigo(Codigo);
				qd.setAlterar(q);
			}
		}
	}

	private boolean checar() {
		Boolean check = true;

		if(Nome.getText().length() < 5){
			JOptionPane.showMessageDialog(null, "Preencha o nome do quarto", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			check = false;
			return false;
		}
		if(Preco.getText().length() < 2){
			JOptionPane.showMessageDialog(null, "Preencha o preço do quarto", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			check = false;
			return false;
		}
		if(Capacidade.getText().length() < 1){
			JOptionPane.showMessageDialog(null, "Preencha o capacidade do quarto", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			check = false;
			return false;
		}
		if(foto == null && Codigo == 0){
			JOptionPane.showMessageDialog(null, "Envie a foto de capa", "Aviso", JOptionPane.INFORMATION_MESSAGE);
			check = false;
			return false;
		}



		return check;
	}

	public void uploadArquivo(){
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.showOpenDialog(null);
		File file = fileChooser.getSelectedFile();
		if(file.exists()){
			this.foto = file;
			this.AreaFoto.setStyle("-fx-border-color: green; fx-border-style: dashed;");
			this.LabelFoto.setText(this.foto.getName());

		}
	}

	public void carrega(int Codigo) throws SQLException{
		if(Codigo == 0){
			return;
		}
		this.Codigo = Codigo;
		QuartoDao qd = new QuartoDao();
		Quarto q = qd.getDetalhe(Codigo);
		Nome.setText(q.getNome());
		Preco.setText(String.valueOf(q.getPreco()));
		Capacidade.setText(String.valueOf(q.getQtdCamas()));
		LabelFoto.setText(q.getFotoCapa());
		//System.out.println("C:/Hostel/Assets/Quartos/"+q.getFotoCapa());
		//Image i = new Image("/Hostel/Assets/Quartos/"+q.getFotoCapa());

		//FotoCapa = new ImageView(i);
	}

}
