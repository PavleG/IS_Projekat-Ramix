package gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sirovina {
	
	StringProperty sifraSirovine = new SimpleStringProperty();
    StringProperty naziv = new SimpleStringProperty();
    StringProperty cena = new SimpleStringProperty();
    StringProperty kolicina = new SimpleStringProperty();

    public StringProperty getSifraSirovine() {
		return this.sifraSirovine;
	}

	public String uzmiSifraSirovine() {
		return this.getSifraSirovine().get();
	}
	
	public void setSifraSirovine(String sifraSirovine) {
		this.getSifraSirovine().set(sifraSirovine);
	}

	public StringProperty getNaziv() {
		return this.naziv;
	}

	public String uzmiSifraKupca() {
		return this.getNaziv().get();
	}
	
	public void setNaziv(String naziv) {
		this.getNaziv().set(naziv);
	}

	public StringProperty getCena() {
		return this.cena;
	}
	
	public String uzmiCena() {
		return this.getCena().get();
	}

	public void setCena(String cena) {
		this.getCena().set(cena);
	}

	public StringProperty getKolicina() {
		return this.kolicina;
	}

	public String uzmiKolicina() {
		return this.getKolicina().get();
	}
	
	
	public void setKolicina(String kolicina) {
		this.getKolicina().set(kolicina);
	}
}
