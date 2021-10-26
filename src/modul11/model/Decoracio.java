package modul11.model;

public class Decoracio extends Item {	
	
	private final Material material;
	private double preu;
	
	public Decoracio() {
		super();
		this.material = null;
	}
	
	public Decoracio(Material material) {
		super("Decoració");
		this.material = material;
	}	
	
	public double getPreu() {
		return preu;
	}



	public void setPreu(double preu) {
		this.preu = preu;
	}



	public Material getMaterial() {
		return material;
	}

	@Override
	public String toString() {
		return super.toString() + 
				"\n\t# Decoració: material " + 
				this.material.name() + ", preu " + preu;

	}

	public enum Material {
		FUSTA, PLASTIC
	}
}
