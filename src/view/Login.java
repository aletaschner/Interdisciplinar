package view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Login extends Application {//obrigatoriamente temos que extender a classe Application para que o FX entenda que essa classe se refere a tela da aplicacao
	private static Stage stage;

	@Override
	public void start(Stage primaryStage) {//metodo obrigatorio da classe Application
		try {
			Login.stage = primaryStage;
			BorderPane root = (BorderPane) FXMLLoader.load(getClass().getResource("LoginTela.fxml"));//carrega o xml
			Scene scene = new Scene(root);
			primaryStage.initStyle(StageStyle.UTILITY);
			primaryStage.initModality(Modality.APPLICATION_MODAL);
			
			//Fecha o programa inteiro caso a tela de login seja fechada
			primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent arg0) {System.exit(0);
				}
			});
			primaryStage.setResizable(false);
			primaryStage.setTitle("Login");// definiçao do titulo
			primaryStage.setScene(scene);// carrega bo stagio primario a cena 
			primaryStage.show();// exibe a tela em si
			primaryStage.toFront();
			
			
		} catch (Exception e) {
			e.printStackTrace();// possivei erros sao pegos aqui
		}
	}

	public static Stage getStage() {
		return stage;
	}

}
