package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class NovaOtpremnicaController implements Initializable {

	@FXML
	private TableView<Detalji> table;
	
	@FXML
	private TextField datum;
	
	@FXML
	private TextField broj;
	
	@FXML
	private TextField kupac;
	
	@FXML
	private TextField adresaKupca;
	
	@FXML
	private TextField cena;
	
	@FXML
	private TextField osnovica;
	
	@FXML
	private Button kreiraj;
	
	@FXML
	private Button btn_odustani;
	
	@FXML
	private ProdajaController pc;
	
	private static int id;
	
	private String brPor;
	
	private double ukupnaOsnovica = 0.0;
	private double ukupnaCena = 0.0;
	
	private ArrayList<Detalji> list;
	
	public void setId(int br){
		id = br;
		broj.setText(Integer.toString(id));
		broj.setEditable(false);
	}
	
	@FXML
	public void setProdajaController(ProdajaController pc){
		this.pc = pc;
	}
	
	public void setBrPor(String br){
		brPor = new String(br);
	}
	
	public void setPodaciOKupcu(String sifra){
		
		
		File file = new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\kupci.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		while(sc.hasNextLine()){
			String[] details = sc.nextLine().split(",");
			
            if(details[0].trim().compareTo(sifra) == 0){
           	 	kupac.setText(details[1]);
           	 	adresaKupca.setText(details[2]);
           	 	kupac.setEditable(false);
           	 	adresaKupca.setEditable(false);
            }
 
		}
		sc.close();

	}
	
	
	@FXML
	public void openUspesnoKreiranjeOtpremnice(Event e1) {
		try {
		
		FileWriter writer = new FileWriter("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\otpremnice.txt", true);
		String dat = datum.getText();
		String br = broj.getText();
		
		
		for(Detalji d : list){

			writer.write(br + "," + dat + "," + d.uzmiProizvod() + "," + d.uzmiKolicina() + "," + kupac.getText()+ "," + adresaKupca.getText() + "," + d.uzmiCena() + "," + d.uzmiKolicina() + "," + d.uzmiUkupnaCena() + "," + d.uzmiUkupnaCenaSaPdv() + "\n");
		}
		writer.close();
		
		
		
		ArrayList<Sirovina> promenjeneSirovine = new ArrayList<Sirovina>();
		//BRISANJE IZ SPISKA PORUDZBINA
		File inputFile = new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\porudzbine.txt");
		File tempFile = new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\tmp");
		
		BufferedReader citanje = new BufferedReader(new FileReader(inputFile));
		BufferedWriter upis = new BufferedWriter(new FileWriter(tempFile));

		String currentLine;

		while((currentLine = citanje.readLine()) != null) {
		    // trim newline when comparing with lineToRemove
		    String details[] = currentLine.split(",");
		    if(details[0].equals(brPor)) {
		    	File file = new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\detalji.txt");
				Scanner sc = null;
				try {
					sc = new Scanner(file);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				while(sc.hasNextLine()){
					String[] details1 = sc.nextLine().split(",");
					
		            if(details1[0].trim().compareTo(brPor) == 0){
		           	 	Sirovina s = new Sirovina();
		           	 	s.setSifraSirovine(details1[4]);
		           	 	s.setNaziv(details1[2]);
		           	 	s.setCena(details1[1]);
		           	 	s.setKolicina(details1[3]);
		           	 	
		           	 	promenjeneSirovine.add(s);
		            }
		 
				}
				sc.close();
		    	
		    	
		    	continue;
		    	}
		    //System.out.println(details[0]);
		    upis.write(currentLine + System.getProperty("line.separator"));
		}
		upis.close(); 
		citanje.close();
		File f = new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\porudzbine.txt");
		f.delete();
		boolean successful = tempFile.renameTo(new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\porudzbine.txt"));
		//System.out.println(successful);
		
		

//		FXMLLoader loader= new FXMLLoader(getClass().getResource("Prodaja.fxml"));
//		Parent root1 = (Parent) loader.load();
//		
//		ProdajaController controller = loader.getController();
//		
//		controller.azurirajPorudzbine();
		
		//------------------------------
		
		//AZURIRANJE STANJA PROIZVODA
		
		File inputFile1 = new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\sirovine.txt");
		File tempFile1 = new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\tmp1");
		
		BufferedReader citanje1 = new BufferedReader(new FileReader(inputFile1));
		BufferedWriter upis1 = new BufferedWriter(new FileWriter(tempFile1));

		String currentLine1;

		while((currentLine1 = citanje1.readLine()) != null) {
		    // trim newline when comparing with lineToRemove

			
		    String d[] = currentLine1.split(",");
		    
			boolean ind = false;
			
			String kolicina = "0";
			for(Sirovina s : promenjeneSirovine){
				if(s.uzmiSifraSirovine().equals(d[0])){
					//System.out.println("promena sirovina " + d[0]);
					ind = true;
					kolicina = s.uzmiKolicina();
					
					break;
				}
			}
			
		    if(ind) {
		    	int rezervisano = Integer.parseInt(kolicina);
		    	int staroStanje = Integer.parseInt(d[3]);
		    	int novoStanje = staroStanje - rezervisano;
		    	upis1.write(d[0] + "," + d[1] + "," + d[2] + "," + Integer.toString(novoStanje) + System.getProperty("line.separator"));
		    	//System.out.println(d[0] + "," + d[1] + "," + d[2] + "," + Integer.toString(novoStanje));
		    	continue;
		    }
		    //System.out.println(details[0]);
		    upis1.write(currentLine1 + System.getProperty("line.separator"));
		    //System.out.println(currentLine1);
		}
		upis1.close(); 
		citanje1.close();
		File f1 = new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\sirovine.txt");
		f1.delete();
		boolean successful1 = tempFile1.renameTo(new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\sirovine.txt"));
		//System.out.println(successful1);
		
		//------------------------------
		
		pc.azurirajPorudzbine();
		pc.azurirajProizvode();

		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("UspesnoKreiranjeOtpremnice.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("Uspesno kreiranje!");
		Stage stage1 = (Stage) kreiraj.getScene().getWindow();
	    stage1.close();
		stage.setScene(new Scene(root));
		stage.show();
		id++;
		
		
		
		}
	 catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Neuspelo ucitavanje novog prozora!");
	}
	}
	
	
	
	public void upisiPodatke(String sifra){
		list = new ArrayList<Detalji>();
		File file = new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\detalji.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		while(sc.hasNextLine()){
			String[] details = sc.nextLine().split(",");
			
            if(details[0].trim().compareTo(sifra) != 0)
           	 	continue;
            Detalji cd = new Detalji();
            cd.setProizvod(details[2]);
            cd.setKolicina(details[3]);
            cd.setCena(details[1]);
            double ukupno = Double.parseDouble(details[1])*Double.parseDouble(details[3]);
            cd.setUkupnaCena(Double.toString(ukupno));
            double ukupnoSaPdv = ukupno * 1.2;
            cd.setUkupnaCenaSaPdv(Double.toString(ukupnoSaPdv));
            //ukupnaCena += ukupnoSaPdv;
            ukupnaOsnovica += ukupno;
            list.add(cd);
		}
		sc.close();

		ukupnaCena = 1.2 * ukupnaOsnovica;
		osnovica.setText(Double.toString(ukupnaOsnovica));
		cena.setText(Double.toString(ukupnaCena));


		ObservableList<Detalji> details = FXCollections.observableArrayList(list);

		TableColumn<Detalji, String> col1 = new TableColumn<>("Proizvod");
		TableColumn<Detalji, String> col2 = new TableColumn<>("Kolicina");
		TableColumn<Detalji, String> col3 = new TableColumn<>("Cena");
		TableColumn<Detalji, String> col4 = new TableColumn<>("Ukupna Cena");
		TableColumn<Detalji, String> col5 = new TableColumn<>("Ukupna Cena Sa Pdv-om");
		
		table.getColumns().addAll(col1, col2, col3, col4, col5);

		col1.setCellValueFactory(data -> data.getValue().getProizvod());
		col2.setCellValueFactory(data -> data.getValue().getKolicina());
		col3.setCellValueFactory(data -> data.getValue().getCena());
		col4.setCellValueFactory(data -> data.getValue().getUkupnaCena());
		col5.setCellValueFactory(data -> data.getValue().getUkupnaCenaSaPdv());

		table.setItems(details);
	}
	
	
	@FXML
	public void odustani(){
		Stage stage = (Stage) btn_odustani.getScene().getWindow();
		stage.close();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
		Date date = new Date();
		datum.setText(dateFormat.format(date));
		datum.setEditable(false);
		
		

		

	}

}

