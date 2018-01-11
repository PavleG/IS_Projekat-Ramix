package gui;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Detalji {
	
	
	public StringProperty proizvod = new SimpleStringProperty();
	public StringProperty kolicina = new SimpleStringProperty();
	public StringProperty cena = new SimpleStringProperty();
	public StringProperty ukupnaCena = new SimpleStringProperty();
	public StringProperty ukupnaCenaSaPdv = new SimpleStringProperty();
	
	public StringProperty getUkupnaCenaSaPdv() {
		return this.ukupnaCenaSaPdv;
	}

	public String uzmiUkupnaCenaSaPdv() {
		return this.getUkupnaCenaSaPdv().get();
	}
	
	public void setUkupnaCenaSaPdv(String ukupnaCenaSaPdv) {
		this.getUkupnaCenaSaPdv().set(ukupnaCenaSaPdv);
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
	
	public StringProperty getUkupnaCena() {
		return this.ukupnaCena;
	}

	public String uzmiUkupnaCena() {
		return this.getUkupnaCena().get();
	}
	
	public void setUkupnaCena(String ukupnaCena) {
		this.getUkupnaCena().set(ukupnaCena);
	}
	
	
	public StringProperty getProizvod() {
		return this.proizvod;
	}

	public String uzmiProizvod() {
		return this.getProizvod().get();
	}
	
	public void setProizvod(String proizvod) {
		this.getProizvod().set(proizvod);
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
