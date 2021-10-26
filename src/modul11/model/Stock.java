package modul11.model;

import java.util.ArrayList;
import java.util.List;

public class Stock<T extends Item> {

	private List<T> items = new ArrayList<>();
	
	public List<T> findAll(){
		return this.items;
	}
	
	public boolean addItem(T item) {
		return this.items.add(item);
	}
	
	public boolean removeItem(T item) {
		boolean success = this.items.remove(item);
		System.out.println("Item eliminat (id: " + item.getUniqueID() + ")");
		return success;
	}
	
	public boolean removeItem(int selection) {
		T t = this.items.get(selection);
		return removeItem(t);
	}
	
	public void clearStock() {
		this.items.clear();
	}
	
	public int count() {
		return this.items.size();
	}
}
