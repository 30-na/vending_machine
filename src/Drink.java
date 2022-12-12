
public class Drink extends Item {
	float ounces;
	String type;

	// constructor
	public Drink(String name, float calories, String itemType, float ounces, String type) {
		super(name, calories, itemType);
		this.ounces = ounces;
		//type will be of these specifically: soda, water, other
		this.type = type;
	}

	// setter and getter
	public float getOunces() {
		return ounces;
	}

	public void setOunces(float ounces) {
		this.ounces = ounces;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// to string
	@Override
	public String toString() {
		return "Drink [ounces=" + ounces + ", type=" + type + ", name=" + name + ", calories=" + calories
				+ ", itemType=" + itemType + "]";
	}

}
