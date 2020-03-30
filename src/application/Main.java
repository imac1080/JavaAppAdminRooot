package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {

	private Stage primaryStage;

	@Override
	public void start(Stage stage) {
		try {
			this.primaryStage = stage;
			Parent root = FXMLLoader.load(getClass().getResource("Ventana.fxml"));

			Scene scene = new Scene(root, 1300, 675);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setResizable(false);
			primaryStage.centerOnScreen();
			primaryStage.setScene(scene);

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
