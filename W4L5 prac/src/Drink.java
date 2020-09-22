
public class Drink {
	private double price;
	private String name;

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public void setPrice(double price) {
		if (price < 0)
			price = 0;
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Drink() {
		name = "NA";
		price = -1;
	}

	public Drink(double price, String name) {
		setName(name);
		setPrice(price);
	}
	
	public String toString() {
		return "name = "+name+" price = "+price;
	}
}
