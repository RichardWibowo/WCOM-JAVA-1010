/*****************************
 *                           *
 * DO NOT MODIFY THIS FILE   *
 *						 	 *
 *****************************/
public class Car {
	private double maxSpeed; // Speed in km/hr
	private String model;
	private String brand;
	public double getMaxSpeed() {
		return maxSpeed;
	}
	public String getModel() {
		return model;
	}
	public String getBrand() {
		return brand;
	}
	/***********************************************
	 *                           				   *
	 *    USE THIS TO ANSWER YOUR QUIZ QUESTIONS   *
	 *						 	 				   *
	 ***********************************************/
	public Car(double s, String m, String b) {
		maxSpeed=s;
		model = m;
		brand=b;
	}
}
