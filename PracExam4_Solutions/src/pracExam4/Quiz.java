package pracExam4;

//name: 
//student id: 

//IMPORTANT! Do NOT change any method headers

import java.util.*;

public class Quiz {

	/**
	 * Question 1: Recursion (10 marks)
	 * 
	 * THE IMPLEMENTATION FOR THIS METHOD MUST BE RECURSIVE
	 * 
	 * @param n
	 *            :int (assume n >= 0)
	 * 
	 * @return the sum of all even digits in n. return 0 if n is 0
	 * 
	 *         e.g. n = 1234 -> 6
	 * 
	 *         n = 24682 -> 22
	 * 
	 *         n = 13579 -> 0
	 * 
	 */
	public static int sumEvenDigits(int n) {
		// to be completed
		if(n<=0)
			return 0;
		if(n%2==0)
			return n%10 + sumEvenDigits(n/10);
		return sumEvenDigits(n/10);
	}

	/**
	 * Question 2: Recursion (15 marks)
	 * 
	 * THE IMPLEMENTATION FOR THIS METHOD MUST BE RECURSIVE
	 * 
	 * @param s
	 *            :String
	 * 
	 * @return the input string but with its characters alternated between lower and
	 *         upper case
	 * 
	 *
	 *         e.g. s = "hello" -> "HELLO"
	 * 
	 *         s = "ToDay" -> "tOdAy"
	 * 
	 *         s = "1235" -> "1235"
	 * 
	 *         s = "wcom125" -> "WCOM125"
	 * 
	 *         s = "two4six8ten" -> "TWO4SIX8TEN"
	 * 
	 *         s = "loNgstRingtEst" -> "LOnGSTrINGTeST"
	 * 
	 *         s = "a" -> "A"
	 * 
	 *         s = "" -> ""
	 *         
	 * Hint: You can check if a character is upper case with Character.isUpperCase(c)
	 *       For example, Character.isUpperCase('a') returns false, Character.isUpperCase('G') returns true,
	 *       and Character.isUpperCase('3') returns false
	 *       
	 * Hint: You can also convert a string to upper case with myString.toUpperCase()
	 *       For example, "Meow123".toUpperCase() returns "MEOW123". You can also use myString.toLowerCase()
	 *       for a similar behaviour.
	 * 
	 */
	public static String switchCase(String s) {
		// to be completed
		if(s.length()<=0)
			return s;
		if(s.charAt(0)>='A'&&s.charAt(0)<='Z')
			return Character.toLowerCase(s.charAt(0)) + switchCase(s.substring(1));
		return Character.toUpperCase(s.charAt(0)) + switchCase(s.substring(1));
	}

	/**
	 * Question 3: Iterators (10 marks)
	 * 
	 * Calculate the number of ships which contain HMAS at the start of their name
	 * 
	 * You must iterate through the ArrayList using the Iterator/ListIterator object
	 * 
	 * Solutions which do not involve the Iterator/ListIterator object will receive
	 * 0 marks
	 * 
	 * @param ships
	 *            : ArrayList of Ship objects
	 * 
	 * @return the total number of Ship objects in the ArrayList whose names start
	 *         with HMAS return 0 if ships is null or empty.
	 *         
	 * Hint: You can use myString.startsWith("meow") to see if the string starts with "meow"
	 * 
	 */
	public static int numHMAS(ArrayList<Ship> ships) {
		// write code here
		int count = 0;
		for(Ship item : ships) {
			if(item.getShipName().startsWith("HMAS"))
				count++;
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
	 *            Multiply the previous integer in the ArrayList to the next integer
	 * 
	 *            The first integer in the ArrayList should not change
	 * 
	 *            e.g. {1,2,3,4,5} --> {1,2*1,3*2,4*3,5*4} --> {1,2,6,12,20}
	 * 
	 *            e.g. {-6,-2,-1,5,8} --> {-6,-2*-6,-1*-2,5*-1,8*5} -->
	 *            {-6,12,2,-5,40}
	 * 
	 */
	public static void timesPrevious(ArrayList<Integer> list) {
		// to be completed
		for(int i = list.size()-1; i > 0; i--) {
			list.set(i, list.get(i) * list.get(i-1));
		}
	}

	/**
	 * Question 5: LinkedList (10 marks)
	 * 
	 * @param ships
	 *            LinkedList of Ship objects (assume not null)
	 * @param target
	 *            Ship object (assume not null)
	 * 
	 * @return number of Ship objects (in ships) which have a larger name than the
	 *         target ship
	 *
	 */
	public static int shipNamesLargerThan(LinkedList<Ship> ships, Ship target) {
		// to be completed
		int count = 0;
		for(Ship item : ships) {
			if(item.getShipName().length()>target.getShipName().length())
				count++;
		}
		return count;
	}

	/**
	 * Question 6: ArrayList (15 marks)
	 * 
	 * @param ships
	 *            : ArrayList of Ship objects (assume not null)
	 * @param minSize
	 *            : the smallest crewSize to include (assume non-negative)
	 * @param str
	 *            : a string the ship name must include
	 * 
	 * @return an ArrayList which contains Ship objects (from ships), having
	 *         crewSize greater than or equal to minSize and shipNames which contain
	 *         str
	 *         
	 * Hint: you can use myString.contains("meow") to check if myString contains "meow".
	 * 
	 */
	public static ArrayList<Ship> findShips(ArrayList<Ship> ships, int minSize, String str) {
		// to be completed
		ArrayList<Ship> ans = new ArrayList<Ship>();
		
		for(Ship item : ships) {
			
			if(item.getCrewSize()>=minSize && item.getShipName().contains(str))
				ans.add(item);
			
		}
		
		return ans;
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

	public Double get(int idx) {
		Node c = head;
		for (int i = 0; i < idx; i++) {
			c = c.getNext();
		}
		if (c == null)
			return null;
		return c.getData();
	}

	/**
	 * QUESITON 7: LinkedLists (10 marks)
	 * 
	 * @param idx
	 *            : the index to set the data at
	 * @param data
	 *            : the data to set
	 * 
	 *            Set the data of node at index idx to data parameter
	 * 
	 */
	public void set(int idx, Double data) {
		// to be completed
		Node current = head;
		for(int i = 0; i < idx; i++) {
			current = current.getNext();
		}
		current.setData(data);
	}

	/**
	 * QUESITON 8 (HD): LinkedLists (20 marks)
	 * 
	 * Remove n'th node from the end of list
	 * 
	 * You may create a helper method to do this
	 * 
	 * @param n
	 *            : node number from the end
	 * 
	 * @return data of the removed node. return null if list is empty.
	 * 
	 *         e.g. if n is 2 :
	 * 
	 *         head -> 4.5 -> 5.2 -> -8.3 -> 6.4 -> 12.7 -> 9.2 -> null becomes
	 * 
	 *         head -> 4.5 -> 5.2 -> -8.3 -> 6.4 -> 9.2 -> null
	 */
	public Double removeFromLast(int n) {
		// to be completed
		
		if(head==null)
			return null;
		
		int size = 0;
		Node current = head;
		while(current!=null) {
			size++;
			current = current.getNext();
		}
		
		if(size==0) {
			double rem = head.getData();
			head = head.getNext();
			return rem;
		}
		
		current = head;
		
		for(int i = 0; i < size - n - 1; i++) {
			current = current.getNext();
		}
		
		double rem = current.getNext().getData();
		current.setNext(current.getNext().getNext());
		return rem;
	}
}
