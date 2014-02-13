package io.robusta.fora.enumeration;

public class ConstanteCountry {

	String name;
	String iso;
	public ConstanteCountry(String name, String iso) {
		super();
		this.name = name;
		this.iso = iso;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIso() {
		return iso;
	}
	public void setIso(String iso) {
		this.iso = iso;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
