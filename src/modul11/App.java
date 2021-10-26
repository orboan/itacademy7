package modul11;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import modul11.model.Arbre;
import modul11.model.Decoracio;
import modul11.model.Flor;
import modul11.model.Floristeria;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		App app = new App();

		Floristeria f = app.crearFloristeria("Natura");

		// Afegim tres decoracions
		Decoracio decoracio1 = new Decoracio(Decoracio.Material.FUSTA);
		Decoracio decoracio2 = new Decoracio(Decoracio.Material.PLASTIC);
		Decoracio decoracio3 = new Decoracio(Decoracio.Material.FUSTA);

		app.afegirDecoracio(decoracio1, f);
		app.afegirDecoracio(decoracio2, f);
		app.afegirDecoracio(decoracio3, f);

		// Afegim tres arbres
		Arbre arbre1 = new Arbre(250);// alçada en cm
		Arbre arbre2 = new Arbre(680);
		Arbre arbre3 = new Arbre(190);

		app.afegirArbre(arbre1, f);
		app.afegirArbre(arbre2, f);
		app.afegirArbre(arbre3, f);

		// Afegim tres flors
		Flor flor1 = new Flor("groc"); // Colors de les flors
		Flor flor2 = new Flor("verd");
		Flor flor3 = new Flor("rosa");

		app.afegirFlor(flor1, f);
		app.afegirFlor(flor2, f);
		app.afegirFlor(flor3, f);

		// Imprimim stoc
		app.stock(f);

		// retirem una decoració
		System.out.println("---- Retirem una decoració:");
		int selection = app.selectOption(app.buildDecoracionsMenu(f), in);
		System.out.println("\nOpció seleccionada: " + selection);
		app.removeDecoracio(selection,f);
		
		// retirem un arbre
		System.out.println("\n---- Retirem un arbre:");
		selection = app.selectOption(app.buildArbresMenu(f), in);
		System.out.println("\nOpció seleccionada: " + selection);
		app.removeArbre(selection,f);
		
		// retirem una flor
		System.out.println("\n---- Retirem una flor:");
		selection = app.selectOption(app.buildFlorsMenu(f), in);
		System.out.println("\nOpció seleccionada: " + selection);
		app.removeFlor(selection,f);
		
		//Stock després de retirar ítems
		app.stock(f);
		
		in.close();
	}

	// Nivell 2
	
	//Selecció d'ítem a eliminar de l'stock
	private int selectOption(Map<String, Integer> menu, Scanner in) {
		String menuStr = "";
		for (String s : menu.keySet())
			menuStr = s;
		System.out.println(menuStr);
		System.out.print("\nSelecciona un ítem a eliminar: ");
		int selection;
		try {
			selection = Integer.parseInt(in.nextLine());
			if (selection >= menu.get(menuStr) || selection <= 0)
				throw new IndexOutOfBoundsException("Ítem no vàlid");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return selectOption(menu, in);
		}
		return selection;
	}

	//Menús de selecció d'ítems (a eliminar)
	//Menú decoracions
	private Map<String, Integer> buildDecoracionsMenu(Floristeria f) {
		StringBuilder sb = new StringBuilder();
		int counter = 1;
		for (Decoracio d : f.getDecoracions().findAll()) {
			sb.append("\n" + counter + " - " + d.toString());
			counter++;
		}
		Map<String, Integer> map = new HashMap<>();
		map.put(sb.toString(), counter);
		return map;
	}
	//Menú arbres
	private Map<String, Integer> buildArbresMenu(Floristeria f) {
		StringBuilder sb = new StringBuilder();
		int counter = 1;
		for (Arbre a : f.getArbres().findAll()) {
			sb.append("\n" + counter + " - " + a.toString());
			counter++;
		}
		Map<String, Integer> map = new HashMap<>();
		map.put(sb.toString(), counter);
		return map;
	}
	//Menú flors
	private Map<String, Integer> buildFlorsMenu(Floristeria f) {
		StringBuilder sb = new StringBuilder();
		int counter = 1;
		for (Flor d : f.getFlors().findAll()) {
			sb.append("\n" + counter + " - " + d.toString());
			counter++;
		}
		Map<String, Integer> map = new HashMap<>();
		map.put(sb.toString(), counter);
		return map;
	}

	//Mètodes d'eliminació d'ítems
	private void removeDecoracio(int selection, Floristeria f) {
		f.removeDecoracio(selection);;
	}
	private void removeArbre(int selection, Floristeria f) {
		f.removeArbre(selection);
	}
	private void removeFlor(int selection, Floristeria f) {
		f.removeFlor(selection);
	}

	
	// Nivell 1
	private Floristeria crearFloristeria(String nom) {
		return new Floristeria(nom);
	}

	private void afegirArbre(Arbre arbre, Floristeria f) {
		f.addArbre(arbre);
	}

	private void afegirFlor(Flor flor, Floristeria f) {
		f.addFlor(flor);
	}

	private void afegirDecoracio(Decoracio decoracio, Floristeria f) {
		f.addDecoracio(decoracio);
	}

	private void stock(Floristeria f) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < f.getDecoracions().count(); i++) {
			sb.append("X");
		}
		sb.append(" Total: " + f.getNumItems(new Decoracio()));
		String stockDecoracions = sb.toString();
		sb.delete(0, sb.length());
		for (int i = 0; i < f.getFlors().count(); i++) {
			sb.append("Y");
		}
		sb.append(" Total: " + f.getNumItems(new Flor()));
		String stockFlors = sb.toString();
		sb.delete(0, sb.length());
		for (int i = 0; i < f.getArbres().count(); i++) {
			sb.append("T");
		}
		sb.append(" Total: " + f.getNumItems(new Arbre()));
		String stockArbres = sb.toString();
		sb.delete(0, sb.length());
		sb.append("\nFloristeria " + f.getNom() + " STOCK:\n").append("\tARBRES:\n").append("\t\t" + stockArbres + "\n").append("\tFLORS:\n")
				.append("\t\t" + stockFlors + "\n").append("\tDECORACIONS:\n")
				.append("\t\t" + stockDecoracions + "\n")
				.append("\tTotal ítems en estoc: " + f.getTotalNumItems() + "\n");
		System.out.println(sb.toString());
	}
}
