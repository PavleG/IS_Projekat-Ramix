package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller implements Initializable{
	
	//U FORMI ZA PRIJAVLJIVANJE
	@FXML
	private Button btn_prijaviSe;
	
	@FXML
	private TextField tf_korIme;
	
	@FXML
	private Button noviRadniNalog;

	@FXML
	private TableView<String> sirovine;
	
	@FXML
	public void prijava(Event e1) {
		
		try {
			
		Stage stage1 = (Stage) btn_prijaviSe.getScene().getWindow();
		stage1.close();
		String korisnik = tf_korIme.getText();
		String forma = "Menu.fxml";
		

			
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource(forma));
		
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Ramix informacioni sistem");
		stage.setScene(new Scene(root));
		stage.show();
		
		
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Neuspelo ucitavanje novog prozora!");
	}
		
	}
	
	
	//U MENIJU
	@FXML
	public void openProizvodnja(Event e1) {
		try {
		
			
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Radni_nalozi.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Proizvodnja");
		
		
		
		stage.setScene(new Scene(root));
		stage.show();
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Neuspelo ucitavanje novog prozora!");
	}
	}

	
	//U MENIJU
	

	
	
	@FXML
	private Button btn_nabavka;
	
	@FXML
	public void openNabavka(Event e1) {
		try {
		
			
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Nabavka.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Nabavka");
		
		
		
		stage.setScene(new Scene(root));
		stage.show();
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Neuspelo ucitavanje novog prozora!");
	}
		
	}
	
	
	
	@FXML
	private Button btn_racunovodstvo;
	
	@FXML
	public void openRacunovodstvo(Event e1) {
		try {
		
			
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Raƒunovodstvo.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Računovodstvo");
		
		
		
		stage.setScene(new Scene(root));
		stage.show();
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Neuspelo ucitavanje novog prozora!");
	}
		
	}
	
	
	@FXML
	private Button btn_resursi;
	
	@FXML
	public void openResursi(Event e1) {
		try {
		
			
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Upravljanje_resursima.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Upravljanje resursima");
		
		
		
		stage.setScene(new Scene(root));
		stage.show();
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Neuspelo ucitavanje novog prozora!");
	}
		
	}
	
	
	
	@FXML
	private Button btn_magacin;
	
	@FXML
	public void openMagacin(Event e1) {
		try {
		
			
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Magacin.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Magacin");
		
		
		
		stage.setScene(new Scene(root));
		stage.show();
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Neuspelo ucitavanje novog prozora!");
	}
		
	}
	
	
	
	


	
	
	
	@FXML
	private Button btn_nova_sirovina;
	
	@FXML
	public void openNovaSirovina(Event e1) {
		try {
		
			
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Nova_sirovina.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Nova sirovina");
		
		
		
		stage.setScene(new Scene(root));
		stage.show();
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Neuspelo ucitavanje novog prozora!");
	}
		
	}
	
	
	
	@FXML
	private Button btn_novi_dobavljac;
	
	@FXML
	public void openNoviDobavljac(Event e1) {
		try {
		
			
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Novi_dobavljac.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Novi dobavljac");
		
		
		
		stage.setScene(new Scene(root));
		stage.show();
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Neuspelo ucitavanje novog prozora!");
	}
		
	}
	
	
	@FXML
	private Button btn_novi_zaposleni;
	
	@FXML
	public void openNoviZaposleni(Event e1) {
		try {
		
			
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Novi_zaposleni.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Novi zaposleni");
		
		
		
		stage.setScene(new Scene(root));
		stage.show();
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Neuspelo ucitavanje novog prozora!");
	}
		
	}
	
	
	@FXML
	private Button btn_novo_vozilo;
	
	@FXML
	public void openNovoVozilo(Event e1) {
		try {
		
			
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Novo_vozilo.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Novo vozilo");
		
		
		
		stage.setScene(new Scene(root));
		stage.show();
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Neuspelo ucitavanje novog prozora!");
	}
		
	}
	
	
	
	
	
	@FXML
	private Button btn_novi_proizvod;
	
	@FXML
	public void openNoviProizvod(Event e1) {
		try {
		
			
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Novi_proizvod.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Novi proizvod");
		
		
		
		stage.setScene(new Scene(root));
		stage.show();
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Neuspelo ucitavanje novog prozora!");
	}
		
	}
	
	
	
	@FXML
	private Button btn_porucene_sirovine;
	
	@FXML
	public void openPoruceneSirovine(Event e1) {
		try {
		
			
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Porucena_sirovina.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Nova porucena sirovina");
		
		
		
		stage.setScene(new Scene(root));
		stage.show();
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Neuspelo ucitavanje novog prozora!");
	}
		
	}

	
	
	
	@FXML
	private Button btn_novi_kupac;
	
	@FXML
	public void openNoviKupac(Event e1) {
		try {
		
			
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Novi_kupac.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Zahtev za registraciju");
		
		
		
		stage.setScene(new Scene(root));
		stage.show();
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Neuspelo ucitavanje novog prozora!");
	}
		
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	
	
	
	@FXML
	private Button btn_prodaja;
	
	@FXML
	public void openProdaja(Event e1) {
		try {
		
//		String name = "";
//		String prozor = "";
//		
//		if(true) {
//			name = "Prodaja.fxml";
//			prozor = "Prodaja";
//			}
//		else {
//			name = "Zabrana_pristupa.fxml";
//			prozor = "Greska";
//			}
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Prodaja.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Prodaja");
		stage.setResizable(false);
		
		stage.setScene(new Scene(root));
		stage.show();
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Neuspelo ucitavanje novog prozora!");
	}
	}
	
	
	
	
	

}
