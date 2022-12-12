import java.util.ArrayList;
import java.util.Queue;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 

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
				System.out.print(directory.get(i));
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
		return "Vending [directory=" + directory + ", slots=" + slots + "]";
	}




	public void DisplayItems() {
		for(int i=0; i<this.slots.size(); i++) {
			Queue slot = slots.get(i);
			System.out.print(slot.peek());
			System.out.print(slot.size());
			System.out.println();
		}
		
	}
	
	
	public void LoudSlotDrink(Queue<Item> Q, int numberOfItem, Drink item) {
		for(int i=0; i<numberOfItem; i++) {
			Q.offer(item);
		}
	}
	
	public void LoudSlotSnack(Queue<Item> Q, int numberOfItem, Snack item) {
		for(int i=0; i<numberOfItem; i++) {
			Q.offer(item);
		}
	}
	
	public void loadItem(ArrayList<String> myVending) {
		
	}
	
	public void unloadItem(int index) {}
	
	public void unloadItem(ArrayList <Integer> i) {}
	
	public ArrayList<Integer> findProduct(String target){
		ArrayList <Integer> indexList = new ArrayList <Integer>();
		return indexList;
	}
}
