package io.robusta.fora.enumeration;

public enum Country {
	
	
	FRANCE("FR", "France", 22000), 
	USA("USA", "United States of America", 23000),
	RUSSIA("RU", "Russia", 15000),
	FINLAND("FL", "Finland", 28000);
	
	String iso;
	String name;
	float salaireMoyen;
	
	private Country(String iso, String name, float salaireMoyen) {
		this.iso = iso;
		this.name = name;
		this.salaireMoyen =salaireMoyen;
	}
	
	@Override
	public String toString() {
		//return this.name().substring(0, 1)+this.name().substring(1).toLowerCase();
		return this.name;
	};
	
	
	public String getIso() {
		return iso;
	}
	
	public String getName() {
		return name;
	}
	
	public float getSalaireMoyen() {
		return salaireMoyen;
	}
	
	
}
