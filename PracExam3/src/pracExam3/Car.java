package pracExam3;

class Car {
	private int numSeats;
	private String brand;
	public int getNumSeats() {
		return numSeats;
	}
	public String getBrand() {
		return brand;
	}
	public void setNumSeats(int numSeats) {
		if(numSeats<0)
			numSeats=0;
		this.numSeats=numSeats;
	}
	public void setBrand(String brand) {
		this.brand=brand;
	}
	public Car(int numSeats,String brand) {
		setNumSeats(numSeats);
		setBrand(brand);
	}
	public int compareTo(Car other) {
		if(numSeats>other.getNumSeats())
			return 1;
		if(numSeats<other.getNumSeats())
			return -1;
		return 0;
	}
	public boolean equals(Object other) {
		if (!(other instanceof Car))
			return false;
		Car s = (Car)other;
		if(s.getNumSeats()==numSeats)
			return true;
		return false;
	}
}