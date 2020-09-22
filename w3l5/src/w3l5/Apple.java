package w3l5;

public class Apple {
	private double price;
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Apple(String type, double price) {
		setType(type);
		setPrice(price);
	}
	public String toString() {
		return type +  " $"+price;
	}
}
