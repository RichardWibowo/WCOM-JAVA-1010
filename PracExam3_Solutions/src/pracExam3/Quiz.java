package pracExam3;

import java.util.*;

public class Quiz {

	/**
	 * Question 1: Recursion (10 marks)
	 * 
	 * THE IMPLEMENTATION FOR THIS METHOD MUST BE RECURSIVE
	 * 
	 * @param n
	 *            : int (assume n >= 0)
	 * @return number of even digits in n. return 0 if n is 0
	 * 
	 *         e.g. n = 1234 -> 2
	 * 
	 *         n = 24682 -> 0
	 * 
	 *         n = 13579 -> 5
	 * 
	 *         HINT: n/10 gives you the number with the last digit removed
	 */
	public static int countOddDigits(int n) {
		// to be completed
		if(n<=0)
			return 0;
		
		if(n%2==1)
			return 1 + countOddDigits(n/10);
		
		return countOddDigits(n/10);
		
	}

	/**
	 * Question 2: Recursion (15 marks)
	 * 
	 * THE IMPLEMENTATION FOR THIS METHOD MUST BE RECURSIVE
	 * 
	 * @param s
	 *            : String
	 * @return the string but with all upper case characters removed
	 *
	 *         e.g. s = "hELlo" -> "hlo"
	 * 
	 *         s = "HeLlO" -> "el"
	 * 
	 *         s = "WcOmONETWOFIVE" -> "cm"
	 * 
	 *         s = "TwOnSiXnTeN" -> "wnine"
	 * 
	 *         s = "a" -> "a"
	 * 
	 *         s = "A" -> ""
	 * 
	 *         s = "" -> ""
	 *         
	 *  Hint: You can use Character.isUpperCase(c) to check if c is upper case.
	 *  For example, Character.isUpperCase('A') will return true.
	 */
	public static String removeUpperCase(String s) {
		// to be completed
		if(s.length()<=0)
			return s;
		if(s.charAt(0)>='A'&&s.charAt(0)<='Z')
			return removeUpperCase(s.substring(1));
		return s.charAt(0)+removeUpperCase(s.substring(1));
	}

	/**
	 * Question 3: Iterators (10 marks)
	 * 
	 * Calculate the total number of seats contained within all cars in the
	 * ArrayList
	 * 
	 * You must iterate through the ArrayList using the Iterator/ListIterator object
	 * 
	 * Solutions which do not involve the Iterator/ListIterator object will receive
	 * 0 marks
	 * 
	 * @param cars
	 *            : ArrayList of Car objects
	 * @return the total number of seats across all cars in ArrayList. return 0 if
	 *         cars is null or empty.
	 * 
	 */
	public static int totalCarSeats(ArrayList<Car> cars) {
		// to be completed
		int sum = 0;
		for(Car item : cars) {
			sum+=item.getNumSeats();
		}
		return sum;
	}

	/**
	 * Question 4: ArrayList (10 marks)
	 * 
	 * @param list
	 *            : an ArrayList of integers
	 * 
	 *            Add the next integer in the ArrayList to the previous integer
	 * 
	 *            The last integer in the ArrayList should not change
	 * 
	 *            e.g. {1,2,3,4,5} --> {1+2,2+3,3+4,4+5,5} --> {3,5,7,9,5}
	 * 
	 *            e.g. {-6,-2,-1,5,8} --> {-6-2,-2-1,-1+5,5+8,8} --> {-6,-3,4,13,8}
	 * 
	 */
	public static void addNext(ArrayList<Integer> list) {
		// to be completed
		for(int i = 0; i < list.size()-1; i++) {
			list.set(i,list.get(i)+list.get(i+1));
		}
	}

	/**
	 * Question 5: LinkedList (10 marks)
	 * 
	 * @param cars
	 *            LinkedList of Car objects (assume not null)
	 * @param target
	 *            Car object (assume not null)
	 * 
	 * @return number of Car objects (in cars) which have more number of seats than
	 *         target
	 *
	 */
	public static int carsLargerThan(LinkedList<Car> cars, Car target) {
		// to be completed
		int count = 0;
		for(Car item : cars) {
			if(item.getNumSeats() > target.getNumSeats())
				count++;
		}
		return count;
	}

	/**
	 * Question 6: ArrayList (15 marks)
	 * 
	 * @param cars
	 *            (assume not null)
	 * @param minSize
	 *            the smallest numSeats to include (assume non-negative)
	 * @param maxSize
	 *            the largest numSeats to include (assume non-negative)
	 * 
	 * @return an ArrayList which contains Car objects (from cars), with numSeats
	 *         between the minSize and the maxSize parameters inclusive
	 * 
	 */
	public static ArrayList<Car> findCars(ArrayList<Car> cars, int minSize, int maxSize) {
		// to be completed
		ArrayList<Car> ans = new ArrayList<Car>();
		
		for(Car item : cars) {
			if(item.getNumSeats()>=minSize&&item.getNumSeats()<=maxSize)
				ans.add(item);
		}
		
		return ans;
	}

	// Please continue scrolling down to find questions 7 and 8.

}

// A custom linked list of character items
class MyLinkedList {
	private Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public MyLinkedList() {
		setHead(null);
	}

	public void add(Character s) {
		Node n = new Node(s);
		if (head != null) {
			n.setNext(head);
		}
		head = n;
	}

	public void remove() {
		Node c = head;
		if (c.getNext() == null) {
			head = null;
			return;
		}
		head = c.getNext();
	}

	public char get(int idx) {
		Node c = head;
		for (int i = 0; i < idx; i++) {
			c = c.getNext();
		}
		return c.getData();
	}

	/**
	 * QUESITON 7: LinkedLists (10 marks)
	 * 
	 * @param target
	 *            : data of node
	 * @return the index of target in the list. return -1 if target is not found.
	 * 
	 */
	public int indexOf(Character target) {
		// to be completed
		int i = 0;
		Node current = head;
		while(current!=null) {
			if(current.getData().equals(target))
				return i;
			
			i++;
			current = current.getNext();
		}
		return -1;
	}

	/**
	 * QUESITON 8 (HD): LinkedLists (20 marks)
	 * 
	 * Add the node at the input index
	 * 
	 * @param idx
	 *            : the index where the new node will be added
	 * @param data
	 *            : the data (character) to store in the new node
	 */
	public void addAtIndex(int idx, Character data) {
		// to be completed
		if(idx==0) {
			add(data);
			return;
		}
		
		Node current = head;
		
		for(int i = 0; i < idx - 1; i++) {
			current = current.getNext();
		}
		
		Node n = new Node(data,current.getNext());
		current.setNext(n);
	}
}
