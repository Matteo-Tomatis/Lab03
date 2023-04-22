package it.polito.tdp.model;

public class RichWord {
	
	private String parola;
	private boolean controllo;
	public RichWord(String parola, boolean controllo) {
		super();
		this.parola = parola;
		this.controllo = controllo;
	}
	public String getParola() {
		return parola;
	}
	public void setParola(String parola) {
		this.parola = parola;
	}
	public boolean isControllo() {
		return controllo;
	}
	public void setControllo(boolean controllo) {
		this.controllo = controllo;
	}
	
	

}
