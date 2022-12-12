
public class Snack extends Item {
	float weight;
	boolean containsNuts;
	
	//setter and getter
	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public boolean isContainsNuts() {
		return containsNuts;
	}

	public void setContainsNuts(boolean containsNuts) {
		this.containsNuts = containsNuts;
	}

	// constructor
	public Snack(String name, float calories, String itemType, float weight, boolean containsNuts) {
		super(name, calories, itemType);
		this.weight = weight;
		this.containsNuts = containsNuts;
	}

	@Override
	public String toString() {
		return "Snack [weight=" + weight + ", containsNuts=" + containsNuts + ", name=" + name + ", calories="
				+ calories + ", itemType=" + itemType + ", getWeight()=" + getWeight() + ", isContainsNuts()="
				+ isContainsNuts() + ", getName()=" + getName() + ", getCalories()=" + getCalories()
				+ ", getItemType()=" + getItemType() + "]";
	}
	
	//to string

}
