package gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Porudzbina {

	StringProperty sifra = new SimpleStringProperty();
    StringProperty sifraKupca = new SimpleStringProperty();
    StringProperty adresa = new SimpleStringProperty();
    StringProperty datum = new SimpleStringProperty();

	public StringProperty getSifra() {
		return this.sifra;
	}

	public String uzmiSifra() {
		return this.getSifra().get();
	}
	
	public void setSifra(String sifra) {
		this.getSifra().set(sifra);
	}

	public StringProperty getSifraKupca() {
		return this.sifraKupca;
	}

	public String uzmiSifraKupca() {
		return this.getSifraKupca().get();
	}
	
	public void setSifraKupca(String sifraKupca) {
		this.getSifraKupca().set(sifraKupca);
	}

	public StringProperty getAdresa() {
		return this.adresa;
	}
	
	public String uzmiAdresa() {
		return this.getAdresa().get();
	}

	public void setAdresa(String adresa) {
		this.getAdresa().set(adresa);
	}

	public StringProperty getDatum() {
		return this.datum;
	}

	public String uzmiDatum() {
		return this.getDatum().get();
	}
	
	
	public void setDatum(String datum) {
		this.getDatum().set(datum);
	}
	

}
