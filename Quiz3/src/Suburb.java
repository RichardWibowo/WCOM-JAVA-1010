/*****************************
 * * DO NOT MODIFY THIS FILE * *
 *****************************/
public class Suburb {
	private int population;
	private String name;
	private int postCode; // e.g. Sydney is 2000

	public int getPopulation() {
		return population;
	}

	public int getPostCode() {
		return postCode;
	}

	public String getName() {
		return name;
	}

	public void setPopulation(int p) {
		population = p;
	}

	public Suburb(int p, int pc, String n) {
		population = p;
		postCode = pc;
		name = n;
	}

	public String toString() {
		return name + " " + population + " " + postCode;
	}

	public void setName(String n) {
		name = n;
	}
}
