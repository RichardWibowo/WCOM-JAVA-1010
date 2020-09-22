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
	 * 
	 * @return the index of the first even integer in arr. return -1 if no even
	 *         integer is found.
	 * 
	 *         Example: arr = {0,5,8,1} firstEven(arr) should return 2
	 * 
	 *         arr = {4,5,8,1} firstEven(arr) should return 0
	 * 
	 *         arr = {3,5,7,1} firstEven(arr) should return -1
	 * 
	 */
	public static int firstEven(int[] arr) {
		// To be completed
		for(int i = 0;i<arr.length;i++) {                   //search the array
			if(arr[i]%2==0&&arr[i]!=0) {                   //with this condition 
				return i;								  //return if you found it								
			}
		}
		return -1;										//return if u dont find it
	}

	/**
	 * Question 2: Linear search with objects (10 marks)
	 * 
	 * @param arr   : the String array to search
	 * @param start : the target String to look for
	 * 
	 * @return the index of the first String which starts with the parameter String
	 *         start. return -1 if no String is found.
	 * 
	 *         Example: arr = {"Hello","There","Yellow","The"}, start = "Th"
	 *         findStart(arr,start) should return 1
	 * 
	 *         arr = {"Hello","There","Yellow","mere"}, start = "ere"
	 *         findStart(arr,start) should return -1
	 * 
	 *         arr = {"Hello","There","Yellow","mere"}, start = "He"
	 *         findStart(arr,start) should return 0
	 * 
	 *         * arr = {"Hello","There","Yellow","yelling"}, start = "yell"
	 *         findStart(arr,start) should return 3 (case sensitive)
	 * 
	 *         Hint: If String s = "Test" then s.startsWith("Tes") returns true.
	 * 
	 */
	public static int findStart(String[] arr, String start) {
		// To be completed
		for(int i = 0;i<arr.length;i++) {
			if(arr[i].startsWith(start)) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Question 3: Binary search (10 marks)
	 * 
	 * @param arr    : An array of Car objects sorted by maxSpeed in descending
	 *               order
	 * @param target : a target maxSpeed to search for
	 * 
	 * @return the index of the Car object in arr with the target maxSpeed. return
	 *         -1 if no Car object is found.
	 * 
	 *         This method should implement the Binary Search algorithm.
	 * 
	 *         Your solution will be inspected by your teacher.
	 * 
	 *         You will receive 0 if you do not use the Binary Search algorithm.
	 * 
	 */
	public static int binarySearch(Car[] arr, double target) {
		// To be completed
		int first = 0;						
		int last = arr.length - 1;
		while (last >= first) {
			int median = (first + last) / 2;
			if (arr[median].getMaxSpeed() == target)
				return median;
			if (arr[median].getMaxSpeed() < target)
				last = median - 1;
			else
				first = median + 1;

		}
		return -1;
	}

	/**
	 * Question 4: Max search (10 marks)
	 * 
	 * @param arr : An array of Car objects
	 * @return the Car object in arr with highest maxSpeed
	 * 
	 *         Example:
	 * 
	 *         If arr = { Car(150.2, "A3", "Audi"), Car(212.5, "i5", "BMW"),
	 *         Car(185.5, "i3", "BMW") }
	 * 
	 *         then fastestCar(arr) should return the Car object Car(212.5, "i5",
	 *         "BMW")
	 * 
	 */
	public static Car fastestCar(Car[] arr) {
		// To be completed
		Car SpeedBenchmark = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].getMaxSpeed() > SpeedBenchmark.getMaxSpeed()) {
				SpeedBenchmark = arr[i];
			}

		}
		return SpeedBenchmark;
	}

	/**
	 * Question 5: Duplicate detection (15 marks)
	 * 
	 * @param arr : An array of integers
	 * @return the sum of all unique integers in arr
	 * 
	 *         This method should return the sum of all unique integers in arr.
	 * 
	 *         Example:
	 * 
	 *         {1,1,1,2} -> 2 (1,1,2,2} -> 0 {1,2,3,4} -> 1 + 2 + 3 + 4 = 10
	 * 
	 */
	public static int sumUnique(int[] arr) {
		// To be completed
		//int add = 0;
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			boolean unique = true;
			for (int j = 0; j < arr.length; j++) {
				if (i != j && arr[i] == arr[j]) {
					unique = false;
					//add = arr[i];
				}
			}
			if(unique)
					result += arr[i];
		}

		return result;
	}
}
