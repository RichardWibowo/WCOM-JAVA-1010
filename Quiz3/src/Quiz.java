import java.util.ArrayList;

//Enter your name and student id below

//Name : 

//Student ID : 

// You should edit only the methods body which have "To be completed" commented within them.

// You must NOT 
// 1) change any class name or its visibility.
// 2) change any method signatures (visibility, type, name or its parameters) 

// Good luck!

public class Quiz {
	
	/**
	 * Question 1: ArrayLists (10 marks)
	 * 
	 * @return an ArrayList with the Strings "Array","Lists","Are","Very","Useful"
	 * 
	 */
	public static ArrayList<String> getArrayList() {
		//To be completed
		ArrayList<String> Daniel = new ArrayList<String>();
		Daniel.add("Array");
		Daniel.add("Lists");
		Daniel.add("Are");
		Daniel.add("Very");
		Daniel.add("Useful");
		return Daniel;
	}
	
	/**
	 * Question 2: ArrayLists (10 marks)
	 * 
	 * Set the population of the Suburb object in index 0 to 20000.
	 * 
	 * Set the company of the Suburb object in index 2 to "Ryde"
	 * 
	 */
	public static void updateSuburbs(ArrayList<Suburb> list) {
		//To be completed
		for(Suburb item : list) {
			item.setPopulation(20000);
			item.setName("Ryde");
		}
		
	}
	
	/**
	 * Question 3: ArrayList (15 marks)
	 * 
	 * @param list : an ArrayList of Suburb objects
	 *            
	 * @param target : the target Suburb name
	 *           
	 * @return the total population of all Suburb objects with Suburb name equal
	 * to target
	 * 
	 */
	public static double totalPopulation(ArrayList<Suburb> list, String target) {
		// To be completed
		int total = 0;
		for(int i = 0; i<list.size();i++) {
			if(list.get(i).getName().equals(target)) {
				total+= list.get(i).getPopulation();
			}
		}
		return total;
		
	}
	
	/**
	 * Question 4: ArrayList (15 marks)
	 * 
	 * @param list : an ArrayList of integers (assume the ArrayList is not null and not empty)
	 * 
	 *           Shift each integer in the ArrayList backwards one index.
	 * 
	 *            The integer in the first index should be shifted to the last index.
	 * 
	 *            e.g. {1,2,3,4,5} --> {2,3,4,5,1}
	 * 
	 *            e.g. {-6,-2,-1,5,8} --> {-2,-1,5,8,-6}
	 *            
	 */
	public static void shiftLeft(ArrayList<Integer> list) {
		// To be completed
		for(int i=list.size();i<0;i--) {
			int temp = list.get(i+1);
			list.set(i,temp);
			i++;
			
		}
	}
	
	/**
	 * Question 5: Recursion (15 marks)
	 * 
	 * This method should remove all Suburb objects in the parameter list
	 * which have a lower population than the parameter max (exclusive).
	 * 
	 */
	public static void clearSuburbs(ArrayList<Suburb> list, int max) {
		// To be completed 
		for(int i =0;i<list.size();i++) {
			if(list.get(i).getPopulation()<max) {
				list.remove(i);
				i--;
			}
		}
	}
}
