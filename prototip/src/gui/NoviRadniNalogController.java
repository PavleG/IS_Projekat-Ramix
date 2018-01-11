package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
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

public class NoviRadniNalogController implements Initializable {

	@FXML
	private TableView<Detalji> table;
	
	@FXML
	private TextField datum;
	
	@FXML
	private TextField broj;
	
	@FXML
	private Button kreiraj;
	
	private static int id;
	
	private ArrayList<Detalji> list;
	
	public void setId(int br){
		id = br;
		broj.setText(Integer.toString(id));
		broj.setEditable(false);
	}
	
	@FXML
	public void openUspesnoKreiranjeRadnogNaloga(Event e1) {
		try {
		
		FileWriter writer = new FileWriter("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\radni_nalozi.txt", true);
		
		String dat = datum.getText();
		String br = broj.getText();
		
		for(Detalji d : list){
			
			writer.write(br + "," + dat + "," + d.uzmiProizvod() + "," + d.uzmiKolicina() + "\n");
		}
		writer.close();

		FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("UspesnoKreiranjeRadnogNaloga.fxml"));
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
            cd.setProizvod(details[1]);
            cd.setKolicina(details[2]);
            list.add(cd);
		}
		sc.close();




		ObservableList<Detalji> details = FXCollections.observableArrayList(list);

		TableColumn<Detalji, String> col1 = new TableColumn<>("Proizvod");
		TableColumn<Detalji, String> col2 = new TableColumn<>("Kolicina");

		table.getColumns().addAll(col1, col2);

		col1.setCellValueFactory(data -> data.getValue().getProizvod());
		col2.setCellValueFactory(data -> data.getValue().getKolicina());

		table.setItems(details);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
		Date date = new Date();
		datum.setText(dateFormat.format(date));
		datum.setEditable(false);
		
		

		

	}

}
