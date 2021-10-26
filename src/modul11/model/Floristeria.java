package modul11.model;

public class Floristeria {
	private String nom;
	private Stock<Decoracio> decoracions = new Stock<>();
	private Stock<Arbre> arbres = new Stock<>();
	private Stock<Flor> flors = new Stock<>();
	private int totalNumItems; //registre del valor total de l'stock
	
	public Floristeria(String nom) {
		this.nom = nom;
	}

	//Get number of items in each stock
	public <T extends Item> int getNumItems(T t) {
		if(t instanceof Arbre)
			return arbres.count();
		if(t instanceof Flor)
			return flors.count();
		if(t instanceof Decoracio)
			return decoracions.count();
		return -1;
	}
	
	//Get total number of items in all stocks
	public int getTotalNumItems() {
		return this.totalNumItems;
	}	
	
	//Update register of total number of Items
	private void updateTotalNumItems() {
		this.totalNumItems = arbres.count() + flors.count() + decoracions.count();
	}
	
	//Add items to stoks
	public void addArbre(Arbre a) {
		this.arbres.addItem(a);
		updateTotalNumItems();
		System.out.println("Floristeria " + nom + ": arbre afegit (id: " + a.getUniqueID() 
		 + ")");
	}
	
	public void addFlor(Flor f) {
		this.flors.addItem(f);
		updateTotalNumItems();
		System.out.println("Floristeria " + nom + ": flor afegida (id: " + f.getUniqueID() 
		 + ")");
	}
	
	public void addDecoracio(Decoracio d) {
		this.decoracions.addItem(d);
		updateTotalNumItems();
		System.out.println("Floristeria " + nom + ": decoració afegida (id: " + d.getUniqueID() 
		 + ")");
	}
	
	public void removeArbre(int selection) {
		this.getArbres().removeItem(selection - 1);
		updateTotalNumItems();
	}
	public void removeFlor(int selection) {
		this.getFlors().removeItem(selection - 1);
		updateTotalNumItems();
	}
	public void removeDecoracio(int selection) {
		this.getDecoracions().removeItem(selection - 1);
		updateTotalNumItems();
	}
	
	//Setter getter nom
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	//Stock getters
	public Stock<Decoracio> getDecoracions() {
		return decoracions;
	}
	
	public Stock<Arbre> getArbres(){
		return arbres;
	}
	
	public Stock<Flor> getFlors(){
		return flors;
	}	
	
}
