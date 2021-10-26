package modul11.model;

import java.util.UUID;

public class Item {

	private String uniqueID = UUID.randomUUID().toString();

	protected Item() {}
	
	public Item(String type) {
		System.out.println("Item [" + type + "] creat amb id: " + uniqueID);
	}
	
	public String getUniqueID() {
		return this.uniqueID;
	}
	
	@Override
	public String toString() {
		return "Item id: " + this.uniqueID;
	}
	
}
