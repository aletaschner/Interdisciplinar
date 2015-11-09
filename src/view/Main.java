package view;

import controller.ControlerMain;
import view.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
	private Stage primaryStage;
	private Pane root;

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
}
