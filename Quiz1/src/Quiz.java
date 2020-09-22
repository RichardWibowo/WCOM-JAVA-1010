// You should edit only the methods body which have "To be completed" commented within them.

// You must NOT 
// 1) change any class name or its visibility.
// 2) change any method signatures (visibility, type, name or its parameters) 

// Good luck!
class Cat {
	private double weight; // The weight of the cat in kg
	private String name; // The name of the cat 
	
	public double getWeight() {
		return weight;
	}
	public String getName() {
		return name;
	}
	
	/**
	 * Question 1A: Setter (5 marks)
	 * 
	 * @param weight : double
	 * 
	 * Set the instance variable weight to the parameter variable weight.
	 * 
	 * Validation:
	 * 				If the weight is negative then set it to 0.01.
	 * 				If the weight is greater than 25, set it to 24.99.
	 *
	 */
	public void setWeight(double weight) {
		//To be completed
		if(weight <0) {
			weight = 0.01;
			this.weight = weight;
		}else if(weight > 25) {
			weight = 24.99;
			this.weight = weight;
		}else {
			this.weight = weight;
		}
	}
	
	/**
	 * Question 1B: Setter (5 marks)
	 * 
	 * @param name : String
	 * 
	 * Set the instance variable name to the parameter variable name.
	 * 
	 * Validation:
	 * 				If the length of the name is less than 8 characters
	 * 				add "Cute " to the beginning of the name and set it.
	 * Example:
	 * 
	 * 	if name = "Pat" you should set the Cat's name to "Cute Pat".
	 *
	 */
	public void setName(String name) {
		//To be completed
		if (name.length()<8) {
			name = "Cute " + name;
		} this.name = name;
		
	}
	
	
	/**
	 * Question 1B: Constructor (5 marks)
	 * 
	 * Set the instance variable weight to 4.81 and the name to "Mittens"
	 *
	 */
	public Cat() {
		//To be completed
		weight = 4.81;
		name = "Mittens";
	}


	/**
	 * Question 1C: Constructor (5 marks)
	 * 
	 * @param weight : double
	 * @param name : String
	 * 
	 * Set the instance variables to the parameter variables.
	 * 
	 * Note: You must use the above setters within your constructor.
	 * (You're marks will depend on whether your setters are correct)
	 * 
	 */
	public Cat(double weight, String name) {
		//To be completed
		setName(name);
		setWeight(weight);
	}
	
	/**
	 * Question 1D: Method (5 marks)
	 * 
	 * The instance variable weight is measured in kilograms (kg).
	 * 
	 * This method should return the weight of the cat in pounds (lbs).
	 * 
	 * Note that 1 kg = 2.2 lbs
	 * 
	 * @return the weight of the Cat in pounds (lbs).
	 * 
	 */
	public double getWeightPounds() {
		//To be completed
		
		return weight*2.2;
	}
	
	/**
	 * Question 1E: compareTo (5 marks)
	 * 
	 * @param other : the Cat object to compare against.
	 * 
	 * @return 1 if the calling object has a larger weight than the parameter object
	 * 
	 *        -1 if the calling object has a lower weight than the parameter object
	 * 
	 *         0 if the calling object has the same weight as the parameter object
	 */
	public int compareTo(Cat other) {
		if(weight > other.weight) {
			return 1;
		}else if(weight < other.weight) {
			return -1;
		}else {
			return 0;
		}
	}
	
	/**
	 * Question 1F: toString (5 marks)
	 * 
	 * @return a String which includes the instance parameters with the form:
	 * 		
	 * 		   "Mittens the cat weighs 22.6 kgs."
	 * 
	 * 		   (Note the above String is an example when the weight = 22.6 and name = "Mittens")
	 * 	
	 */
	public String toString() {
		//To be completed
		return name + " the cat weighs " + weight +" kgs.";
	}

	
	////////////////////////////////////////////////////////////
	///				Do not edit the below methods			 ///
	////////////////////////////////////////////////////////////
	public void xyz(double abc) {weight=abc;}
	public void abc(String abc) {name=abc;}
	////////////////////////////////////////////////////////////
	///				Do not edit the above methods		 	 ///
	////////////////////////////////////////////////////////////
}
public class Quiz {

	/**
	 * Question 2: Instantiating objects (2 marks)
	 * 
	 * Before you attempt this method you should open up and examine Dog.java.
	 * 
	 * @return a Dog object with breed "Cattle" and age 7.
	 * 
	 * This method should create a Dog object with breed "Cattle" and age 7 then return it.
	 * 
	 */
	public static Dog oldDog() {
		//To be completed
		Dog x = new Dog(7,"Cattle");
		return x;
	}

	/**
	 * Question 3: Arrays of objects (3 marks)
	 * 
	 * @param arr : An array of Dog objects
	 * @return a String containing the total age of the Dog objects in index 1 and 3.
	 * 
	 * Example:  (Note this is only describing the ages)
	 * 
	 * If the Dog ages were {10,5,8,2} the method should return:
	 * 
	 				"The total age is 7."
	 * 
	 */
	public static String totalAge(Dog[] arr) {
		//To be completed
		int A = arr[1].getAge() + arr[3].getAge();
		return "The total age is " + A + ".";
	}
	
	/**
	 * Question 4: Arrays of objects (10 marks)
	 * 
	 * @param arr : An array of Dog objects
	 * @return the average age of all the Dog objects in arr.
	 * 		   return 0 if the array arr is empty.
	 * 
	 * The method should return the average age of all Dog objects in arr.
	 * 
	 * Example: (Note this is only describing the ages)
	 * 
	 * If the Dog ages were {5,10,2,1,8} the method should return 5.2.
	 * 
	 * Note: you will have to be careful when dividing integers.
	 * 
	 */
	public static double avgAge(Dog[] arr) {
		//To be completed
		double total = 0;
		for(int i =0; i < arr.length; i++) {
			total = total + arr[i].getAge();
		}
		if (total<=0) {
			total = 0;
		}else {
			total /= arr.length;
		}
		return  total;
	}
	
}
