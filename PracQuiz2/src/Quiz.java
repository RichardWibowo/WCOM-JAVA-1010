// You should edit only the methods body which have "To be completed" commented within them.

// You must NOT 
// 1) change any class name or its visibility.
// 2) change any method signatures (visibility, type, name or its parameters) 

// Good luck!

public class Quiz {
	
	/**
	 * Question 1: Linear search (5 marks)
	 * 
	 * @param arr : the integer array to search
	 * @param min : the minimum integer to search for
	 * 			
	 * @return the index of the first integer in arr that is larger than min.
	 * 		   return -1 if no number is found.
	 * 
	 * Example:
	 * arr = {4,5,8,1}, min = 6
	 * firstLarger(arr,min) should return 2
	 * 
	 * arr = {4,5,8,1}, min = 1
	 * firstLarger(arr,min) should return 0
	 * 
	 * arr = {4,5,8,1}, min = 9
	 * firstLarger(arr,min) should return -1
	 * 
	 */
	public static int firstLarger(int[] arr, int min) {
		// To be completed
		//int count =0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > min) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Question 2: Linear search with objects (5 marks)
	 * 
	 * @param arr : the String array to search
	 * @param target : the target String to look for
	 * 
	 * @return the index of the first String which contains the target within it.
	 * 		   return -1 if no String is found.
	 * 
	 * Example:
	 * arr = {"Hello","There","Yellow","mere"}, target = "ll"
	 * firstLarger(arr,target) should return 0
	 * 
	 * arr = {"Hello","There","Yellow","mere"}, target = "ere"
	 * firstLarger(arr,target) should return 1
	 * 
	 * arr = {"Hello","There","Yellow","mere"}, target = "me"
	 * firstLarger(arr,target) should return 3
	 * 
	 *  * arr = {"Hello","There","Yellow","mere"}, target = "hello"
	 * firstLarger(arr,target) should return -1  (case sensitive)
	 * 
	 */
	public static int findContaining(String[] arr, String target) {
		//To be completed
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].contains(target)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Question 3: Binary search (5 marks)
	 * 
	 * @param arr : An of doubles sorted in ascending order
	 * @param target : a target double to search for
	 * 
	 * @return the index of the target double in arr.
	 * 		   return -1 if the target is not found.
	 * 
	 * This method should implement the Binary Search algorithm.
	 * 
	 * Your solution will be inspected by your teacher.
	 * 
	 * You will receive 0 if you do not use the Binary Search algorithm.
	 * 
	 */
	public static int binarySearch(double[] arr, double target) {
		//To be completed
		int first = 0;
		int last = arr.length - 1;
		while (last >= first) {
			int median = (first + last) / 2;
			if (arr[median] == target)
				return median;
			if (arr[median] > target)
				last = median - 1;
			else
				first = median + 1;

		}
		return -1;
	}
	
	/**
	 * Question 4: Min search (5 marks)
	 * 
	 * @param arr : An array of Pizza objects
	 * @return the Pizza object in arr with the lowest price
	 * 
	 * Example:
	 * 
	 * If arr = { Pizza(15.2, "BBQ", "Dannis"), Pizza(12.5, "Tomato", "Dannis"), Pizza(5.5, "Cheese", "Dannis") } 
	 * 
	 * then cheapestPizza(arr) should return the Pizza object Pizza(5.5, "Cheese", "Dannis")
	 * 
	 */
	public static Pizza cheapestPizza(Pizza[] arr) {
		//To be completed
		Pizza min = arr[0];
		for(int i = 0; i<arr.length;i++) {
			if(arr[i].getPrice()<min.getPrice()) {
				min = arr[i];
			}
			
		}
		return min;
	}
	
	/**
	 * Question 5: Return in range (10 marks)
	 * 
	 * @param arr : An array of doubles
	 * @param min : the minimum value to search for
	 * @param max : the maximum value to search for
	 * 
	 * @return an array of doubles from arr which are between min and max (inclusive)
	 * 
	 * Example:
	 * If arr = {1.5,6.9,3.2,8.4,0.5}, min = 2.5 and max = 7.6
	 * Then getInRange(arr, min, max) should return {6.9, 3.2}
	 * 
	 */
	public static double[] getInRange(double[] arr, double min, double max) {
		// To be completed
		int count = 0;
		for(int i = 0; i<arr.length;i++) {
			if(arr[i]<max&&arr[i]>min) {
				count++;
			}
					
			}int k = 0;
			double[]range = new double[count];
			for(int i = 0; i<arr.length;i++) {
				if(arr[i]<max&&arr[i]>min) {
					range[k] = arr[i];k++;	
			}
			
		}
		
		return range;
	}
	
	/**
	 * Question 6: Collision detection (10 marks)
	 * 
	 * @param arr : An array of Pizza objects
	 * @return true if there are any Pizza objects in arr which have the same type 
	 * 		   and storeName but different prices.
	 * 
	 * Example:
	 * If arr = { Pizza(10, "BBQ", "Dannis"), Pizza(10, "BBQ", "Pedros"), Pizza(15, "BBQ", "Dannis") } 
	 * Then collisions(arr) should return true.
	 * 
	 * 
	 */
	public static boolean collisions(Pizza[] arr) {
		// To be completed
		for(int i = 0;i<arr.length;i++) {
			for(int j = 0;j<arr.length;j++) {
				if(arr[i].getStoreName().equals(arr[j].getStoreName())
						&&
						arr[i].getType().equals(arr[j].getType())
						&&
						arr[i].getPrice()!=(arr[j].getPrice())
						&&
						i!=j) {
					return true;
				}
					
			}
		}
		return false;
	}
	
	/**
	 * Question 7: Duplicate detection (10 marks)
	 * 
	 * @param arr : An array of integers
	 * 
	 * This method should set all duplicates in the array to 0.
	 * 
	 * Example:
	 * 
	 * {1,1,1,2} -> {0,0,0,2}
	 * (1,1,2,2} -> {0,0,0,0}
	 * {1,2,3,4} -> {1,2,3,4}
	 * 
	 */
	public static void zeroDuplicates(int[] arr) {
		// To be completed
		for(int i = 0; i < arr.length; i++) {
			boolean unique=true;
			for(int k = 0; k < arr.length; k++) {
				if(arr[i]==arr[k]&&i!=k) {
					unique=false;
					arr[k]=0;
				}
			}
			if(!unique) {
				arr[i]=0;
			}
		}
		
	}
}



