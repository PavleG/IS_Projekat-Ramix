package gui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage stage) {
		Parent root=null;
		try {
			root=FXMLLoader.load(getClass().getResource("Logovanje.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Scene scena=new Scene(root);
		stage.setTitle("Ramix informacioni sistem");
		stage.setScene(scena);
		stage.show();
		
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
