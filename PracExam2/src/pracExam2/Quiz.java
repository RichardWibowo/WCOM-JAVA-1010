package pracExam2;

import java.util.*;

public class Quiz {

	/**
	 * Question 1: Recursion (10 marks)
	 * 
	 * THE IMPLEMENTATION FOR THIS METHOD MUST BE RECURSIVE
	 * 
	 * @param n
	 *            : int (assume n >= 0)
	 * 
	 * @return the sum of odd digits in n. return 0 if n is 0
	 * 
	 *         e.g. n = 1234 -> 4
	 * 
	 *         n = 24682 -> 0
	 * 
	 *         n = 13579 -> 25
	 * 
	 */
	public static int sumOddDigits(int n) {
		// to be completed
		if(n <=0) {
			return 0;
		}if(n%2 == 1 && n%10 != 0) {
			return n%10 + sumOddDigits(n/10);
		}return sumOddDigits(n/10);
	}

	/**
	 * Question 2: Recursion (15 marks)
	 * 
	 * THE IMPLEMENTATION FOR THIS METHOD MUST BE RECURSIVE
	 * 
	 * @param s
	 *            : String
	 * 
	 * @return String with all but upper-case characters removed
	 *
	 *         e.g. s = "hELlo" -> "EL"
	 * 
	 *         s = "HeLlO" -> "HLO"
	 * 
	 *         s = "WcOm125" -> "WO"
	 * 
	 *         s = "TwOnSiXnTeN" -> "TOSXTN"
	 * 
	 *         s = "a" -> ""
	 * 
	 *         s = "A" -> "A"
	 * 
	 *         s = "" -> ""
	 *         
	 * Hint: You can use Character.isUpperCase(c) to check if c is an
	 *       upper case character. For example, Character.isUpperCase('a') will
	 *       return false.
	 */
	public static String removeNonUpperCase(String s) {
		// to be completed
		if(s.length() == 0) {
			return s;
		}if(s.charAt(0)>='A'&&s.charAt(0)<='Z') {
			return s.charAt(0)+removeNonUpperCase(s.substring(1));
		}
		return removeNonUpperCase(s.substring(1));
	}

	/**
	 * Question 3:  (10 marks)
	 * 
	 * Calculate the number of cars with a brand name that has more than 5
	 * characters
	 * 
	 * You must iterate through the ArrayList using the Iterator/ListIterator object
	 * 
	 * @param cars
	 *            : ArrayList of Car objects
	 * 
	 * @return the number of cars with a brand name that has more than 5 characters
	 * 
	 */
	public static int numLongBrands(ArrayList<Car> cars) {
		// to be completed.
		int count = 0;
		for(Car item : cars) {
			if(item.getBrand().length()>5) {
				count ++;
			}
		}
		return count;
	}

	/**
	 * Question 4: ArrayList (10 marks)
	 * 
	 * @param list
	 *            : an ArrayList of integers (assume the ArrayList is not null and
	 *            not empty)
	 * 
	 *            Multiply the next integer in the ArrayList to the previous integer
	 * 
	 *            The last integer in the ArrayList should not change
	 * 
	 *            e.g. {1,2,3,4,5} --> {1*2,2*3,3*4,4*5,5} --> {2,6,12,20,5}
	 * 
	 *            e.g. {-6,-2,-1,5,8} --> {-6*-2,-2*-1,-1*5,5*8,8} -->
	 *            {12,2,-5,40,8}
	 * 
	 */
	public static void timesNext(ArrayList<Integer> list) {
		// to be completed.
		for(int i =0;i<list.size()-1;i++) {
			list.set(i, list.get(i)*list.get(i+1));
		}
	}

	/**
	 * Question 5: LinkedList (10 marks)
	 * 
	 * @param cars
	 *            : LinkedList of Car objects (assume not null)
	 * @param target
	 *            : Car object (assume not null)
	 * 
	 * @return number of Car objects (in cars) which are the same brand as the
	 *         target
	 * 
	 */
	public static int countSameBrand(LinkedList<Car> cars, Car target) {
		// to be completed
		int count = 0;
		for(Car item : cars) {
			if(item.getBrand().equals(target.getBrand())) {
				count ++;
			}
		}
		return count;
	}

	/**
	 * Question 6: ArrayList (15 marks)
	 * 
	 * @param cars
	 *            : ArrayList of Car objects (assume not null)
	 * @param numSeats
	 *            : the numSeats to search for (assume non-negative)
	 * @param brand
	 *            : the brand to search for
	 * 
	 * @return an ArrayList which contains Car objects (from cars), having the
	 *         same numSeats and brand as the input parameter.
	 * 
	 */
	public static ArrayList<Car> findCars(ArrayList<Car> cars, int numSeats, String brand) {
		// to be completed
		ArrayList<Car> daniel = new ArrayList<Car>();
		for(Car item : cars) {
			if(item.getBrand().equals(brand)&&item.getNumSeats()==numSeats) {
				daniel.add(item);
			}
		}
		
		return daniel;
	}

	// Please continue scrolling down to find questions 7 and 8.

}

// A custom linked list of double items
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

	public void add(Double s) {
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

	public double get(int idx) {
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
	 *            
	 * @return the last index of target in the list. return -1 if target is not
	 *         found.
	 * 
	 */
	public int lastIndexOf(Double target) {
		// to be completed
		Node c = head;
		int loc = -1, i = 0;
		while(c != null) {
			if(c.getData().equals(target)) {
				loc =i;
			}
			i++;
			c=c.getNext();
		}
		return loc;
	}

	/**
	 * QUESITON 8 (HD): LinkedLists (20 marks)
	 * 
	 * Remove the item in the middle of the list
	 * 
	 * Note that the index of the middle node = [the number of nodes]/2
	 * This is true whether the number of nodes is odd or even.
	 * 
	 * You may create a helper 
	 * method to do this
	 * 
	 * @return the item which was removed from the list. return null if the list is empty
	 * 
	 */
	public Double removeMiddleNode() {
		// to be completed
		Node c = head;
		int size =0;
		while(c != null) {
			size++;
			c=c.getNext();
		}
		
		int idx = size/2;
		
		if(head == null) {
			return null;
		}
		if(idx == 0) {
			double rem = head.getData();
			head = head.getNext();
			return rem;
			
		}
		
		Node current = head;
		for(int i = 0; i<idx - 1; i++) {
			current = current.getNext();
		}
		
		double temp = current.getNext().getData();
		current.setNext(current.getNext().getNext());
		
		return temp;

		}
	}
