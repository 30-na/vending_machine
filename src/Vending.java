import java.util.ArrayList;
import java.util.Queue;
import java.util.*;

public class Vending {
	// the string names of all the products.
	ArrayList<String> directory = new ArrayList<String>();
	// contain a QUEUE of your Items (Drinks or Snacks)
	ArrayList <Queue> slots = new ArrayList<Queue>();
	
	
	// constructor
	public Vending(ArrayList<String> myVending) {
		
		for(int i=0; i<myVending.size(); i++) {
			String line = myVending.get(i);
			
			String itemType = line.split(", ")[0];
			String name = line.split(", ")[1];
			float calories = Float.valueOf(line.split(", ")[2]);
			int slotsNumber = Integer.valueOf(line.substring(line.indexOf("[") + 1, line.indexOf("]")));
			int numberOfItem = Integer.valueOf(line.substring(0, line.indexOf("    ")).split(", ")[5]);
			
			Queue <Item> queue = new LinkedList <Item>();
			if(itemType.equals("Drink")) {
				Float ounces = Float.valueOf(line.split(", ")[3]);
				String type = line.split(", ")[4];
				
				// Polymorphism
				Drink drink = new Drink(name, calories, itemType, ounces, type);
				LoudSlotDrink(queue, numberOfItem, drink);
				this.directory.add(name);
				this.slots.add(slotsNumber, queue);
			}
			else if(itemType.equals("Snack")) {
				Float weight =  Float.valueOf(line.split(", ")[3]);
				boolean containsNuts = Boolean.valueOf(line.split(", ")[4]);
				
				// Polymorphism
				Snack snack = new Snack(name, calories, itemType, weight, containsNuts);
				LoudSlotSnack(queue, numberOfItem, snack);
				this.directory.add(name);
				this.slots.add(slotsNumber, queue);
			}
		}
	}
	
	@Override
	public String toString() {
		return "Vending [directory=" + directory + ", \nslots=" + slots;
	}

	public void displayItems() {
		for(int i=0; i<this.slots.size(); i++) {
			Queue slot = slots.get(i);
			if(slot.size() < 1) {
			System.out.println("Empty Slot");
			}else {
			System.out.print(slot.peek());
			System.out.print(slot.size());
			System.out.println();
			}
		}
		System.out.println();
	}
	
	public void loadItem(ArrayList<String> myVending) {
		for(int i=0; i<myVending.size(); i++) {
			String line = myVending.get(i);
			
			String itemType = line.split(", ")[0];
			String name = line.split(", ")[1];
			float calories = Float.valueOf(line.split(", ")[2]);
			int slotsNumber = Integer.valueOf(line.substring(line.indexOf("[") + 1, line.indexOf("]")));
			int numberOfItem = Integer.valueOf(line.substring(0, line.indexOf("    ")).split(", ")[5]);
			
			if(itemType.equals("Drink")) {
				Float ounces = Float.valueOf(line.split(", ")[3]);
				String type = line.split(", ")[4];
				
				Drink drink = new Drink(name, calories, itemType, ounces, type);
				addSlotDrink(numberOfItem, drink);
			}
			else if(itemType.equals("Snack")) {
				Float weight =  Float.valueOf(line.split(", ")[3]);
				boolean containsNuts = Boolean.valueOf(line.split(", ")[4]);
				
				Snack snack = new Snack(name, calories, itemType, weight, containsNuts);
				addSlotSnack(numberOfItem, snack);
			}
		}
	}
	
	public void unloadItem(int index) {
		if(this.slots.get(index).size() > 0) {
			String target = this.directory.get(index);
			ArrayList<Integer> indexList = findProduct(target);
			
			//find the max slot size
			int maxIndex = indexList.get(0);
			for(int i=0; i<indexList.size(); i++) {
				if(slots.get(i).size() > slots.get(maxIndex).size()) {
					maxIndex = i;
				}
			}
			
			this.slots.get(maxIndex).poll(); 
			//this.directory.add(maxIndex, this.slots.get(maxIndex).peek().getName());
		}else {
			System.out.println("Sory we are out of this item");
		}
		displayItems();
	}
	
	public void LoudSlotDrink(Queue<Item> Q, int numberOfItem, Drink item) {
		for(int i=0; i<numberOfItem; i++) {
			Q.offer(item);
		}
	}
	
	public void addSlotDrink(int numberOfItem, Drink item) {
		for(int i=0; i<numberOfItem; i++) {
			this.slots.get(i).offer(item);
		}
	}
	
	public void LoudSlotSnack(Queue<Item> Q, int numberOfItem, Snack item) {
		for(int i=0; i<numberOfItem; i++) {
			Q.offer(item);
		}
	}
	
	public void addSlotSnack(int numberOfItem, Snack item) {
		for(int i=0; i<numberOfItem; i++) {
			this.slots.get(i).offer(item);
		}
	}
	
	
	public ArrayList<Integer> findProduct(String target){
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		for(int i=0; i<this.directory.size(); i++){
			if(this.directory.get(i).equals(target)) {
				indexList.add(i);
			}
		}
		return indexList;
	}
	
	// setter and getter
	public ArrayList<String> getDirectory() {
		return directory;
	}

	public void setDirectory(ArrayList<String> directory) {
		this.directory = directory;
	}

	public ArrayList<Queue> getSlots() {
		return slots;
	}

	public void setSlots(ArrayList<Queue> slots) {
		this.slots = slots;
	}

	public void unloadItems(ArrayList <Integer> i) {
		for(int index : i) {
			unloadItem(index);
		}
	}

}
