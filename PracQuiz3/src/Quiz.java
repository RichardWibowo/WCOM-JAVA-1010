import java.util.ArrayList;

// You should edit only the methods body which have "To be completed" commented within them.

// You must NOT 
// 1) change any class name or its visibility.
// 2) change any method signatures (visibility, type, name or its parameters) 

// Good luck!

public class Quiz {
	
	
	
	/**
	 * Question 4: ArrayLists (5 marks)
	 * 
	 * @return an ArrayList with the integers 6,8,3,1,9
	 * 
	 */
	public static ArrayList<Integer> getArrayList() {
		//To be completed
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		list.add(0,6);
		list.add(1,8);
		list.add(2,3);
		list.add(3,1);
		list.add(4,9);
		
		return list;
	}
	
	/**
	 * Question 5: ArrayLists (5 marks)
	 * 
	 * @param list : An ArrayList of Strings
	 * @return the index of the String "This" within the arraylist
	 * 
	 * This method should also do the following:
	 * 		
	 * 		set the String in index 2 of list to "Answer",
	 * 		
	 * 		add the String "New" at index 1,
	 * 
	 * 		remove the entry in index 4
	 * 
	 * 		return the index of the String "This"
	 * 
	 */
	public static int changeArrayList(ArrayList<String> list) {
		// To be completed
		list.set(2, "Answer");
		list.add(1,"New");
		list.remove(4);
		
		return list.indexOf("This");
	}
	
	/**
	 * Question 6: ArrayList (10 marks)
	 * 
	 * @param list : ArrayList of Pizza objects
	 *            
	 * @param targetStore : the target store name
	 *           
	 * @return the total price of all Pizza objects with storeName equal
	 * to targetStore
	 * 
	 */
	public static double totalPrice(ArrayList<Pizza> list, String storeName) {
		// To be completed
		double sum = 0.0;
			for(Pizza item : list) {
				if(item.getStoreName().equals(storeName))
				sum += item.getPrice();
			}
		return sum;
	}
	
	/**
	 * Question 7: ArrayList (10 marks)
	 * 
	 * @param list : an ArrayList of integers (assume the ArrayList is not null and not empty)
	 * 
	 *            To each integer in the ArrayList add the square of the integer before it
	 * 
	 *            The first integer in the ArrayList should not change
	 * 
	 *            e.g. {1,2,3,4,5} --> {1, 2 + 1*1, 3 + 2*2, 4 + 3*3, 5 + 4*4} 
	 *            				   --> {1, 4, 7, 13, 21}
	 * 
	 *            e.g. {-6,-2,-1,5,8} --> {-6, -2 + -6*-6, -1 + -2*-2, 5 + -1*-1, 8 + 5*5} 
	 *            				   	  --> {-6, 34, 3, 6, 33}
	 *            
	 */
	public static void addPrevSquared(ArrayList<Integer> list) {
		// To be completed
		for(int i = list.size()-1; i>0; i--) {
			list.set(i, list.get(i) + list.get(i-1)*list.get(i-1));
		}
	}
}