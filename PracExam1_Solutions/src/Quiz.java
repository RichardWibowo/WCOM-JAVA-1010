import java.util.*;

public class Quiz {

	/**
	 * Question 1: Recursion (10 marks)
	 * 
	 * THE IMPLEMENTATION FOR THIS METHOD MUST BE RECURSIVE
	 * 
	 * @param n
	 *            :int (assume n >= 0)
	 * @return number of even digits in n. return 0 if n is 0
	 * 
	 *         e.g. n = 1234 -> 2
	 * 
	 *         n = 24682 -> 5
	 * 
	 *         n = 13579 -> 0
	 * 
	 *         HINT: n/10 gives you the number with the last digit removed
	 */
	public static int countEvenDigits(int n) {
		// to be completed
		if(n<=0)
			return 0;
		if(n%2==0)
			return 1 + countEvenDigits(n/10);
		return 0 + countEvenDigits(n/10);
	}

	/**
	 * Question 2: Recursion (15 marks)
	 * 
	 * THE IMPLEMENTATION FOR THIS METHOD MUST BE RECURSIVE
	 * 
	 * @param s
	 *            :String
	 * @return the input string but with alternating lower / upper case characters
	 * 
	 *         The order of the lower / upper case characters in the returned string
	 *         does not matter.
	 *
	 *         e.g. s = "hello" -> "hELlo" or "HeLlO"
	 * 
	 *         s = "ToDay" -> "ToDaY" or "tOdAy"
	 * 
	 *         s = "1235" -> "1235"
	 * 
	 *         s = "wcom125" -> "WcOm125" or "wCoM125"
	 * 
	 *         s = "two4six8ten" -> "TwO4SiX8TeN" or "tWo4sIx8tEn"
	 * 
	 *         s = "loNgstRingtEst" -> "lOnGsTrInGtEsT" or "LoNgStRiNgTeSt"
	 * 
	 *         s = "a" -> "a" or "A"
	 * 
	 *         s = "" -> ""
	 * 
	 */
	public static String alternateCase(String s) {
		// to be completed
		if(s.length()<=0) {
			return s;
		}
		if(s.length()%2==0) {
			return s.toUpperCase().charAt(0)+alternateCase(s.substring(1));
		}
		return s.toLowerCase().charAt(0)+alternateCase(s.substring(1));
	}

	/**
	 * Question 3: Iterators (10 marks)
	 * 
	 * Calculate the total number of crew members across all ships in an ArrayList
	 * 
	 * You must iterate through the ArrayList using the Iterator/ListIterator object
	 * 
	 * Solutions which do not involve the Iterator/ListIterator object will receive
	 * 0 marks
	 * 
	 * @param ships
	 *            : ArrayList of Ship objects
	 * @return the total number of crew members across all Ship objects in ArrayList
	 *         return 0 if ships is null or empty.
	 * 
	 */
	public static int totalCrewSize(ArrayList<Ship> ships) {
		// to be completed
		int sum = 0;
		for(Ship item:ships) {
			sum+=item.getCrewSize();
		}
		return sum;
	}

	/**
	 * Question 4: ArrayList (10 marks)
	 * 
	 * @param list
	 *            : an ArrayList of integers (assume the ArrayList is not null and
	 *            not empty)
	 * 
	 *            Add the previous integer in the ArrayList to the next integer
	 * 
	 *            The first integer in the ArrayList should not change
	 * 
	 *            e.g. {1,2,3,4,5} --> {1,2+1,3+2,4+3,5+4} --> {1,3,5,7,9}
	 * 
	 *            e.g. {-6,-2,-1,5,8} --> {-6,-2-6,-1-2,5-1,8+5} --> {-6,-8,-3,4,13}
	 * 
	 */
	public static void addPrevious(ArrayList<Integer> list) {
		// to be completed
		for(int i = list.size() - 1; i>0; i--) {
			list.set(i, list.get(i)+list.get(i-1));
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
	 * @return number of Ship objects in ships which have more crew members than target
	 *
	 */
	public static int shipsLargerThan(LinkedList<Ship> ships, Ship target) {
		// to be completed
		int count = 0;
		for(Ship item : ships) {
			if(item.getCrewSize()>target.getCrewSize())
				count++;
		}
		return count;
	}

	/**
	 * Question 6: ArrayList (15 marks)
	 * 
	 * @param ships
	 *            (assume not null)
	 * @param minSize
	 *            the smallest crewSize to include (assume non-negative)
	 * @param maxSize
	 *            the largest crewSize to include (assume non-negative)
	 * 
	 * @return an ArrayList which contains Ship objects (from ships) that have
	 *         crewSize's between the minSize and the maxSize parameters inclusive
	 * 
	 */
	public static ArrayList<Ship> findShips(ArrayList<Ship> ships, int minSize, int maxSize) {
		// to be completed
		ArrayList<Ship> ans = new ArrayList<Ship>();
		
		for(Ship item : ships) {
			if(item.getCrewSize()>=minSize && item.getCrewSize()<=maxSize)
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
	 * @return the number of items in the list, return 0 if the head is null
	 * 
	 */
	public int size() {
		// to be completed
		int count = 0;
		
		Node current = head;
		
		while(current!=null) {
			count++;
			current=current.getNext();
		}
		return count;
	}

	/**
	 * QUESITON 8 (HD): LinkedLists (20 marks)
	 * 
	 * Remove the item at the parameter index
	 * 
	 * @param idx
	 *            : the index of the item to be removed
	 * 
	 * @return the item which was removed from the list
	 */
	public Double removeAtIndex(int idx) {
		// to be completed
		if(idx == 0) {
			double rem = head.getData();
			head = head.getNext();
			return rem;
			
		}
		
		Node current = head;
		for(int i = 0; i<idx - 1; i++) {
			current = current.getNext();
		}
		
		double rem = current.getNext().getData();
		current.setNext(current.getNext().getNext());
		
		return rem;

	}
}
