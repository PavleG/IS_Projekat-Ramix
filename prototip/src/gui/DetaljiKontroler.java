package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import gui.ProizvodnjaKontroler;

public class DetaljiKontroler implements Initializable{

	
	//private String sifra = "";
	
	public void upisiPodatke(String sifra){
		ArrayList<Detalji> list = new ArrayList<Detalji>();
		File file = new File("C:\\Users\\Petar\\Desktop\\projekat\\Ramix GUI\\src\\detalji.txt");
		Scanner sc = null;
		String cena;
		String osnovica;
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
            list.add(cd);
		}
		sc.close();




		ObservableList<Detalji> details = FXCollections.observableArrayList(list);

		TableColumn<Detalji, String> col1 = new TableColumn<>("Proizvod");
		TableColumn<Detalji, String> col2 = new TableColumn<>("Kolicina");

		detalji.getColumns().addAll(col1, col2);

		col1.setCellValueFactory(data -> data.getValue().getProizvod());
		col2.setCellValueFactory(data -> data.getValue().getKolicina());

		detalji.setItems(details);
	}
	
	
//	private MainController main;
	
//	@FXML 
//	ProizvodnjaKontroler proizvodnjaKontroler;
	
	@FXML
	private TableView<Detalji> detalji;
	
	
//	private ProizvodnjaKontroler pk;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		

		
	}

//	public void init(MainController mainController) {
//		// TODO Auto-generated method stub
//		main = mainController;
//	}
	
	

}
