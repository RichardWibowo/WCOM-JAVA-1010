package w2l1;

public class player {
	public static int test;
	private String name;
	private int size;
	int [] eatan = new int[5];
	
	public int[] getEaten(){
		return eatan;
	}
	public void setEaten(int[] eaten){
		this.eatan= eaten;
	}
	public  void setEaten(int idx, int val){ 
		eatan[idx]= val;
	}
	// getter
	public String getName() {
		return name;
	}
	// setter
	public void setName(String name) {
		this.name = name;
	}

	// getter
	public int getSize() {
		return size;
	}

	// setter
	public void setSize(int size) {
		if (size < 1) {
			size = 1;
		} else if (size > 100) {
			size = 100;
		} else {
			size = 5;
		}
		this.size = size;
	}
	/*
	 * public void setSize(int a) { System.out.println("this is size = " + a);
	 * System.out.println("this.size = " + this.size); this.size = a;
	 * System.out.println("this.size NEW = " + this.size);}
	 */

	public player() {
		System.out.println("create obj");
		name = "test";
		size = 1;
		eatan = new int[5];
	}

	public player(String name, int size) {
		setName(name);
		setSize(size);
	}

	// instance method
	public void eat() {
		if (size < 1) {
			size++;
		} else if (size > 100) {
			size = 100;
		}
	}

	public String toString() {
		return "name = " + name + " size = " + size + "\n";
	}

	public Object booleanequals(Object obj){
		player other = (player) obj;
		return name.equals(other.name);
	}
	public int compareTo(player other){
		if(size > other.size) 
			return 1;
		if(size < other.size) 
			return -1;
		return 80;
	}
	}

