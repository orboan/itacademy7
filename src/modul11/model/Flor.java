package modul11.model;

public class Flor extends Item {
		
	private String color;
	private double preu;
	
	public Flor() {
		super();
	}
	
	public Flor(String color) {
		super("Flor");
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getPreu() {
		return preu;
	}
	public void setPreu(double preu) {
		this.preu = preu;
	}
	
	@Override
	public String toString() {
		return super.toString() + 
				"\n\t# Flor: color " + color + ", preu " + preu;

	}
}
