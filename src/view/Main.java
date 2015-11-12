package view;
import controller.*;
import view.Main;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
	private Stage primaryStage;
	private Pane root;
	@FXML
	private Pane PanePrincipal;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Hostel");

		initMain();
	}

	public void initMain() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("Principal.fxml"));
			root = (Pane) loader.load();

			Scene scene = new Scene(root);
			primaryStage.setResizable(false);
			//primaryStage.setMaximized(true);

			primaryStage.setScene(scene);
			ControlerMain CMain = loader.getController();
			CMain.setMain(this);

			primaryStage.show();


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void initCadCliente() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("CadCliente.fxml"));
			Pane tela = (Pane) loader.load();

			Stage Novatela = new Stage();
			Novatela.setTitle("Cadastro de Clientes");
			Novatela.initModality(Modality.APPLICATION_MODAL);
			Novatela.initStyle(StageStyle.UTILITY);
			Novatela.setResizable(false);

			Scene scene = new Scene(tela);
			Novatela.setScene(scene);

			ControllerCadCliente CCad = loader.getController();
			CCad.setMain(this);

			Novatela.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initCadQuarto() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("CadQuarto.fxml"));
			Pane tela = (Pane) loader.load();

			Stage Novatela = new Stage();
			Novatela.setTitle("Cadastro de Quarto");
			Novatela.initModality(Modality.APPLICATION_MODAL);
			Novatela.initStyle(StageStyle.UTILITY);
			Novatela.setResizable(false);

			Scene scene = new Scene(tela);
			Novatela.setScene(scene);

			ControllerCadQuarto CCad = loader.getController();
			CCad.setMain(this);

			Novatela.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initCadReserva() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("CadReserva.fxml"));
			Pane tela = (Pane) loader.load();

			Stage Novatela = new Stage();
			Novatela.setTitle("Cadastro de Reserva");
			Novatela.initModality(Modality.APPLICATION_MODAL);
			Novatela.initStyle(StageStyle.UTILITY);
			Novatela.setResizable(false);

			Scene scene = new Scene(tela);
			Novatela.setScene(scene);

			ControllerCadReserva CCad = loader.getController();
			CCad.setMain(this);

			Novatela.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initListaReservas() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("TelaListaReserva.fxml"));
			Pane tela = (Pane) loader.load();

			Stage Novatela = new Stage();
			Novatela.setTitle("Lista de Reservas");
			Novatela.initModality(Modality.APPLICATION_MODAL);
			Novatela.initStyle(StageStyle.UTILITY);
			Novatela.setResizable(false);

			Scene scene = new Scene(tela);
			Novatela.setScene(scene);

			ControllerListaReservas CCad = loader.getController();
			CCad.setMain(this);

			Novatela.showAndWait();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
