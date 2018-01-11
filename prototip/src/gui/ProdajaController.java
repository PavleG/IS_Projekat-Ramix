package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ProdajaController implements Initializable {

//	private MainController main;
	
	@FXML
	private NovaOtpremnicaController no;
	
	
	@FXML 
	public TableView<Porudzbina> porudzbine;
	
	
	@FXML
	private Button btn_nova_otpremnica;
	
	public String getPorudzbine() {
		return porudzbine.getSelectionModel().getSelectedItem().uzmiSifra();
	}

	public void setPorudzbine(TableView<Porudzbina> porudzbine) {
		this.porudzbine = porudzbine;
	}


	@FXML 
	private TableView<Sirovina> sirovine;
	
	@FXML
	private Button detaljiOPorudzbini;
	
//	@FXML
//	private Button btn_radniNalog;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 Collection<Porudzbina> list;
		 detaljiOPorudzbini.setDisable(true);
		 btn_nova_otpremnica.setDisable(true);
		try {
			list = Files.readAllLines(new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\porudzbine.txt").toPath())
			         .stream()
			         .map(line -> {
			             String[] details = line.split(",");
			             Porudzbina cd = new Porudzbina();
			             cd.setSifra(details[0]);
			             cd.setSifraKupca(details[1]);
			             cd.setAdresa(details[2]);
			             cd.setDatum(details[3]);
			             return cd;
			         })
			         .collect(Collectors.toList());


 ObservableList<Porudzbina> details = FXCollections.observableArrayList(list);

// tableView = new TableView<>();
 TableColumn<Porudzbina, String> col1 = new TableColumn<>("Sifra");
 TableColumn<Porudzbina, String> col2 = new TableColumn<>("Sifra Kupca");
 TableColumn<Porudzbina, String> col3 = new TableColumn<>("Adresa");
 TableColumn<Porudzbina, String> col4 = new TableColumn<>("Datum");

 porudzbine.getColumns().addAll(col1, col2, col3, col4);

 col1.setCellValueFactory(data -> data.getValue().getSifra());
 col2.setCellValueFactory(data -> data.getValue().getSifraKupca());
 col3.setCellValueFactory(data -> data.getValue().getAdresa());
 col4.setCellValueFactory(data -> data.getValue().getDatum());

 porudzbine.setItems(details);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 Collection<Sirovina> list1;
			try {
				list1 = Files.readAllLines(new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\sirovine.txt").toPath())
				         .stream()
				         .map(line -> {
				             String[] details = line.split(",");
				             Sirovina cd = new Sirovina();
				             cd.setSifraSirovine(details[0]);
				             cd.setNaziv(details[1]);
				             cd.setCena(details[2]);
				             cd.setKolicina(details[3]);
				             return cd;
				         })
				         .collect(Collectors.toList());


	 ObservableList<Sirovina> details = FXCollections.observableArrayList(list1);

	// tableView = new TableView<>();
	 TableColumn<Sirovina, String> col1 = new TableColumn<>("Sifra proizvoda");
	 TableColumn<Sirovina, String> col2 = new TableColumn<>("Naziv");
	 TableColumn<Sirovina, String> col3 = new TableColumn<>("Cena");
	 TableColumn<Sirovina, String> col4 = new TableColumn<>("Kolicina");

	 sirovine.getColumns().addAll(col1, col2, col3, col4);

	 col1.setCellValueFactory(data -> data.getValue().getSifraSirovine());
	 col2.setCellValueFactory(data -> data.getValue().getNaziv());
	 col3.setCellValueFactory(data -> data.getValue().getCena());
	 col4.setCellValueFactory(data -> data.getValue().getKolicina());

	 sirovine.setItems(details);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	
	@FXML
	public void onColumnClick() {
		
		
		
		if(!porudzbine.getSelectionModel().isEmpty())
		{
			detaljiOPorudzbini.setDisable(false);
			btn_nova_otpremnica.setDisable(false);
		}
	}
	
	
	
	@FXML
	public void openDetaljiOPorudzbini(Event e1) {
		try {
		
		Porudzbina p = porudzbine.getSelectionModel().getSelectedItem();
		
		if(p == null){
			System.out.println("Morate selektovati porudzbinu!");
			return;
		}
		
		String sifra = p.uzmiSifra();
			
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Detalji_o_porudzbini.fxml"));

		Parent root = (Parent) fxmlLoader.load();
		
		DetaljiKontroler controller = fxmlLoader.getController();
		
		controller.upisiPodatke(sifra);
		Stage stage = new Stage();
		
		stage.setTitle("Detalji o porudžbini");
		
		
		
		stage.setScene(new Scene(root));
		
		
		stage.show();
		
//		DetaljiKontroler controller = fxmlLoader.getController();
//		controller.setSifra("174/17");
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Neuspelo ucitavanje novog prozora!");
	}
	}

//	
//	public void napraviRadniNalog(Event e1) {
//		try {
//		
//		Porudzbina p = porudzbine.getSelectionModel().getSelectedItem();
//		
//		if(p == null){
//			System.out.println("Morate selektovati porudzbinu!");
//			return;
//		}
//		
//		String sifra = p.uzmiSifra();
//		
//		File file = new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\radni_nalozi.txt");
//		Scanner sc = null;
//		try {
//			sc = new Scanner(file);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		int br = 0;
//		while(sc.hasNextLine()){
//			String[] details = sc.nextLine().split(",");
//			if(details[0] != ""){
//				br = Integer.parseInt(details[0]);
//			}
//		}
//		sc.close();
//		
//		
//		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Novi_radni_nalog.fxml"));
//
//		Parent root = (Parent) fxmlLoader.load();
//		
//		NoviRadniNalogController controller = fxmlLoader.getController();
//		
//		controller.upisiPodatke(sifra);
//		controller.setId(br+1);
//		Stage stage = new Stage();
//		
//		stage.setTitle("Novi_radni_nalog");
//		
//		
//		
//		stage.setScene(new Scene(root));
//		
//		
//		stage.show();
//		
////		DetaljiKontroler controller = fxmlLoader.getController();
////		controller.setSifra("174/17");
//		}
//	 catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//		System.out.println("Neuspelo ucitavanje novog prozora!");
//	}
//	}
//	
	
	
	@FXML
	public void openNovaOtpremnica(Event e1) {
		try {
		
		
			
			Porudzbina p = porudzbine.getSelectionModel().getSelectedItem();
			
			if(p == null){
				System.out.println("Morate selektovati porudzbinu!");
				return;
			}
			
			String sifra = p.uzmiSifra();
			String idKupca = p.uzmiSifraKupca();
			
			File file = new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\otpremnice.txt");
			Scanner sc = null;
			try {
				sc = new Scanner(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			int br = 0;
			while(sc.hasNextLine()){
				String[] details = sc.nextLine().split(",");
				if(details[0] != ""){
					br = Integer.parseInt(details[0]);
				}
			}
			sc.close();
	
			
			
		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("Nova_otpremnica.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		
		no = fxmlLoader.getController();
		
		no.upisiPodatke(sifra);
		no.setId(br+1);
		no.setPodaciOKupcu(idKupca);
		no.setBrPor(sifra);
		no.setProdajaController(this);
		
		Stage stage = new Stage();
		stage.setTitle("Nova otpremnica");
		
		
		
		stage.setScene(new Scene(root));
		stage.show();
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Neuspelo ucitavanje novog prozora!");
	}
		
	}

	
	public void azurirajPorudzbine(){
		
		Collection<Porudzbina> list1 = null;
		

			try {
				list1 = Files.readAllLines(new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\porudzbine.txt").toPath())
				         .stream()
				         .map(line -> {
				             String[] details = line.split(",");
				             Porudzbina cd = new Porudzbina();
				             cd.setSifra(details[0]);
				             cd.setSifraKupca(details[1]);
				             cd.setAdresa(details[2]);
				             cd.setDatum(details[3]);
				             return cd;
				         })
				         .collect(Collectors.toList());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			ObservableList<Porudzbina> details = FXCollections.observableArrayList(list1);
			
			//System.out.println("azurirajPorudzbine " + details.size());

			TableColumn<Porudzbina, String> col1 = new TableColumn<>("Sifra");
			TableColumn<Porudzbina, String> col2 = new TableColumn<>("Sifra Kupca");
			TableColumn<Porudzbina, String> col3 = new TableColumn<>("Adresa");
			TableColumn<Porudzbina, String> col4 = new TableColumn<>("Datum");

			porudzbine.getColumns().addAll(col1, col2, col3, col4);

			col1.setCellValueFactory(data -> data.getValue().getSifra());
			col2.setCellValueFactory(data -> data.getValue().getSifraKupca());
			col3.setCellValueFactory(data -> data.getValue().getAdresa());
			col4.setCellValueFactory(data -> data.getValue().getDatum());

			porudzbine.setItems(details);
		}
	
	
	public void azurirajProizvode(){
		 Collection<Sirovina> list1;
			try {
				list1 = Files.readAllLines(new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\sirovine.txt").toPath())
				         .stream()
				         .map(line -> {
				             String[] details = line.split(",");
				             Sirovina cd = new Sirovina();
				             cd.setSifraSirovine(details[0]);
				             cd.setNaziv(details[1]);
				             cd.setCena(details[2]);
				             cd.setKolicina(details[3]);
				             return cd;
				         })
				         .collect(Collectors.toList());


	 ObservableList<Sirovina> details = FXCollections.observableArrayList(list1);

	// tableView = new TableView<>();
	 TableColumn<Sirovina, String> col1 = new TableColumn<>("Sifra proizvoda");
	 TableColumn<Sirovina, String> col2 = new TableColumn<>("Naziv");
	 TableColumn<Sirovina, String> col3 = new TableColumn<>("Cena");
	 TableColumn<Sirovina, String> col4 = new TableColumn<>("Kolicina");
	 sirovine.getColumns().clear();
	 sirovine.getColumns().addAll(col1, col2, col3, col4);

	 col1.setCellValueFactory(data -> data.getValue().getSifraSirovine());
	 col2.setCellValueFactory(data -> data.getValue().getNaziv());
	 col3.setCellValueFactory(data -> data.getValue().getCena());
	 col4.setCellValueFactory(data -> data.getValue().getKolicina());

	 sirovine.setItems(details);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	
}

