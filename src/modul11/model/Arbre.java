package modul11.model;

public class Arbre extends Item {
	
	
	private int alcada;
	private double preu;
	
	public Arbre() {
		super();
	}
	
	public Arbre(int alcada) {
		super("Arbre");
		this.alcada = alcada;
	}
	
	public int getAlcada() {
		return alcada;
	}
	
	public void setAlcada(int alcada) {
		this.alcada = alcada;
	}
	public double getPreu() {
		return preu;
	}
	public void setPreu(double preu) {
		this.preu = preu;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n\t# Arbre: alçada " + alcada + ", preu " + preu;
	}
	
}
