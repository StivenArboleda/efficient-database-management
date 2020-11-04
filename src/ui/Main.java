package ui;

import javafx.fxml.FXMLLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	private DatabaseManagementGUI databaseGUI;
	
	public Main() {
		databaseGUI = new DatabaseManagementGUI();
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmll = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
		fxmll.setController(databaseGUI);
		Parent root = fxmll.load();
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Efficent Database Management");
		//primaryStage.setResizable(false);
		primaryStage.show();
	}
}
