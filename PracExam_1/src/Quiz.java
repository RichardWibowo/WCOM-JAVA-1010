import java.util.ArrayList;

// Enter your name and student id below

// Name : 

// Student ID : 

// You should edit only the methods body which have "To be completed" commented within them.

// You must NOT 
// 1) change any class name or its visibility.
// 2) change any method signatures (visibility, type, name or its parameters) 

// Good luck!

/******************************
 *                            *
 *         Question 1         *
 *						 	  *
 *****************************/
class Business {
	
	private double netIncome; // The net income of the company in dollars
	private String name; // The name of the company
	
	public double getNetIncome() {
		return netIncome;
	}
	public String getName() {
		return name;
	}
	
	/**
	 * Question 1A: Setter (5 marks)
	 * 
	 * @param netIncome : double
	 * 
	 * Set the instance variable netIncome to the parameter variable netIncome.
	 * 
	 * Validation:
	 * 				If the netIncome is negative then set it to 0.
	 *
	 */
	public void setNetIncome(double netIncome) {
		//To be completed
		if(netIncome < 0) {
			netIncome = 0;
		}this.netIncome = netIncome;
	}
	
	/**
	 * Question 1B: Setter (5 marks)
	 * 
	 * @param name : String
	 * 
	 * Set the instance variable name to the parameter variable name.
	 * 
	 * Validation:
	 * 				The first letter of the name must be a capital letter.
	 * Example:
	 * 
	 * 	if name = "grilld" the name should be set to "Grilld".
	 *
	 */
	public void setName(String name) {
		//To be completed
		this.name=name.substring(0,1).toUpperCase()+name.substring(1);
	}

	/**
	 * Question 1C: Constructor (5 marks)
	 * 
	 * @param netIncome : double
	 * @param name : String
	 * 
	 * Set the instance variables to the parameter variables.
	 * 
	 * Note: You must use the above setters within your constructor.
	 * (You're marks will depend on whether your setters are correct)
	 * 
	 */
	public Business(double netIncome, String name) {
		//To be completed
		setNetIncome(netIncome);
		setName(name);
	}
	
	/**
	 * Question 1D: compareTo (5 marks)
	 * 
	 * @param other : the Business object to compare against.
	 * 
	 * @return 1 if the calling object has a larger netIncome than the parameter object
	 * 
	 *        -1 if the calling object has a lower netIncome than the parameter object
	 * 
	 *         0 if the calling object has the same netIncome as the parameter object
	 */
	public int compareTo(Business other) {
		//To be completed
		if(this.netIncome>other.netIncome) {
			return 1;
		}else if(this.netIncome<other.netIncome) {
			return -1;
		}
		return 0; 
	}
	
	/**
	 * Question 1E: toString (5 marks)
	 * 
	 * @return a String which includes the instance parameters with the form:
	 * 		
	 * 		   "Grilld has a net income of $1000000."
	 * 
	 * 		   (If the netIncome = 1000000 and name = "Grilld")
	 * 	
	 */
	public String toString() {
		//To be completed
		return name+" has a net income of $"+ netIncome+".";
	}

	////////////////////////////////////////////////////////////
	///				Do not edit the below methods			 ///
	////////////////////////////////////////////////////////////
	public void xyz(double abc) {netIncome=abc;}
	public void abc(String abc) {name=abc;}
	public Business(){netIncome=-1;}
	public Business(String abc,int xyz) {abc(abc);xyz(xyz);}
	public boolean equals(Object oth) {
		if(oth == null || name == null) return false;
		Business b = (Business)oth;
		return name.equals(b.getName()) && netIncome == b.getNetIncome();
	}
	////////////////////////////////////////////////////////////
	///				Do not edit the above methods		 	 ///
	////////////////////////////////////////////////////////////
}

/******************************
 *                            *
 *        Questions 2-4       *
 *						 	  *
 *****************************/

public class Quiz {
	
	/**
	 * Question 2: ArrayLists (5 marks)
	 * 
	 * @param list : ArrayList of Business objects
	 * 
	 * @param min : double
	 * 
	 * @param max : double
	 * 
	 * @return an ArrayList of all Business objects in list which have a netIncome between min and max (inclusive).
	 * 
	 */
	public static ArrayList<Business> findBetween(ArrayList<Business> list, double min, double max) {
		//To be completed
		ArrayList<Business> Daniel = new ArrayList<Business>();
		for(int i = 0; i<list.size();i++) {
			if(list.get(i).getNetIncome()>=min&&list.get(i).getNetIncome()<=max) {
				Daniel.add(list.get(i));
			}
		}
		return Daniel;
	}
	
	/**
	 * Question 3: Searching Arrays of Objects (10 marks)
	 * 
	 * @param list : An ArrayList of Business objects
	 * 
	 * @return the Business object with the highest netIncome
	 * 		   return null if the array is empty.
	 * 
	 * Example:
	 * 
	 * If arr = { Business(500,"FoodnGo"), Business(1000,"EatNow"), Business(10,"GoGos") }
	 * 
	 * highestIncome(arr) should return the business object Business(1000,"EatNow").
	 * 
	 */
	public static Business highestIncome(ArrayList<Business> list) {
		// To be completed
		Business temp = null ;
		for(int i = 0; i<list.size();i++) {
			for(int j = 0; j<list.size();j++) {
				if(i!=j) {
				if(list.get(i).getNetIncome()>list.get(j).getNetIncome()) { 
					temp = list.get(i);		
					}
				}
			}
		}
		return temp;
	}
	
	/**
	 * Question 4: ArrayLists (10 marks)
	 * 
	 * @param list : ArrayList of Business objects
	 * @param target : String
	 * 
	 * This method should remove all Business objects in list whose name equals to the parameter
	 * target String.
	 * 
	 * @return an ArrayList of all Business objects which were removed from the list.
	 * 
	 * Example:
	 * 
	 * If list = { Business(500,"FoodnGo"), Business(1000,"EatNow"), Business(10,"GoGos") }
	 * 
	 * Then removeBusiness(list,"FoodnGo") should remove Business(500,"FoodnGo") from the list
	 * then return {Business(500,"FoodnGo")}.
	 * 
	 */
	public static ArrayList<Business> removeBusiness(ArrayList<Business> list, String target) {
		//To be completed
	ArrayList<Business> answer = new ArrayList<Business>();
		for(int i = 0;i<list.size();i++) {
			if(list.get(i).getName().contains(target)) {
				answer.add(list.get(i));
				list.remove(i);
				i--;
			}
		}
		return answer;
	}
	
}
