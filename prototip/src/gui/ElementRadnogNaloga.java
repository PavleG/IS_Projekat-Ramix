package gui;

public class ElementRadnogNaloga {
	
	private String proizvod;
	private String kolicina;
	
	public ElementRadnogNaloga() {}
	
	public ElementRadnogNaloga(String p, String k) {
		proizvod = p;
		kolicina = k;	}
	public String getProizvod() {
		return proizvod;
	}
	public String getKolicina() {
		return kolicina;
	}
	public void setProizvod(String p) {
		proizvod = p;
	}
	public void setKolicina(String k) {
		kolicina = k;
	}
	
	
	

}
