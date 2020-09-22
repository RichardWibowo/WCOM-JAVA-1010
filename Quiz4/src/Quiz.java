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
	 * Question 1: Recursion (10 marks)
	 * 
	 * THE IMPLEMENTATION FOR THIS METHOD MUST BE RECURSIVE
	 * 
	 * @param n : the integer to consider
	 * 
	 * @return the product of every digit in n.
	 * 		   return 1 if n is 0 or below.
	 * 
	 * Example:
	 * timesDigits(245) -> 2 * 4 * 5 = 40
	 * timesDigits(4619) -> 4 * 6 * 1 * 9 = 216
	 * timesDigits(-2) -> 0
	 * 
	 */
	public static int timesDigits(int n) {
		// To be completed
		if(n<=1) {
			return 1;
		}
		return n%10 * timesDigits(n/10); 
	}
	
	/**
	 * Question 2: Recursion (10 marks)
	 * 
	 * THE IMPLEMENTATION FOR THIS METHOD MUST BE RECURSIVE
	 * 
	 * @param n : the integer to search
	 * @param max : the largest digit to count
	 * 
	 * @return the number of digits in the integer n which are less than or equal to max.
	 * 
	 * Example:
	 * countDigitsLessThan(245,3) -> 1
	 * countDigitsLessThan(4619,6) -> 3
	 * countDigitsLessThan(111111,2) -> 0
	 * 
	 */
	public static int countDigitsLessThan(int n, int max) {
		// To be completed
		if(n<=0) {
			return  0;
		}
		if(n%10 <=max ) {
			return 1 + countDigitsLessThan(n/10,max);
		}
		return countDigitsLessThan(n/10,max);
	}
}

/*****************************
 *                           *
 *   SCROLL DOWN TO FIND     *
 *   QUESTIONS 3, 4 and 5    *
 *						 	 *
 *****************************/

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

	public void addFirst(double s) {
		Node n = new Node(s,head);
		head = n;
	}

	public void removeFirst() {
		Node c = head;
		if (c.getNext() == null) {
			head = null;
			return;
		}
		head = c.getNext();
	}

	public Node get(int idx) {
		Node c = head;
		for (int i = 0; i < idx; i++) {
			c = c.getNext();
		}
		return c;
	}

	/**
	 * QUESTION 3: LinkedLists (10 marks)
	 * 
	 * @param target : the minimum number to sum (inclusive)
	 * 
	 * @return the sum of all doubles in the list which are greater
	 * than the parameter target (inclusive).
	 * 
	 * Example:
	 * 
	 * If head - > 2.8 -> 8.6 -> 4.8 -> 1.5 -> 5.6 -> null
	 * 
	 * Then  sumGreaterThan(3) should return 8.6 + 4.8 + 5.6 = 19
	 * 		   
	 */
	public double sumGreaterThan(double target) {
		// To be completed
		Node current = head;
		double sum = 0;
			while(current != null) {
				if(current.getData()>=target) {
					sum+=current.getData();
					
				}
				current = current.getNext();
			}
		return sum;
	}
	
	/**
	 * QUESTION 4: LinkedLists (10 marks)
	 * 
	 * @param n : the number of Nodes to remove
	 * 
	 * Example:
	 * 
	 * If head - > 2.8 -> 8.6 -> 4.8 -> 1.5 -> 5.6 -> null
	 * 
	 * Then removeFirstN(3) should remove the first 3 Nodes giving:
	 * 
	 * head - > 1.5 -> 5.6 -> null
	 * 		   
	 */
	public void removeFirstN(int n) {
			int count =0;
			while (head != null&& count < n) {
				head = head.getNext();
				count++;
			}
		
	}
		

	/**
	 * QUESTION 5: LinkedLists (10 marks)
	 * 
	 * @param data : the data to add
	 *            
	 * This method should add a new Node before the last Node in the list.
	 * 
	 * The last Node in the list should be shifted forwards.
	 * 
	 * Example:
	 * 
	 * If head - > 2.8 -> 8.6 -> -1.6 -> 8.6 -> null
	 * 
	 * After calling addSecLast(3.5) the list should become:
	 * 
	 * head - > 2.8 -> 3.6 -> 8.6 -> -1.6 -> 3.5 -> 8.6 -> null
	 *  
	 */
	public void addSecLast(double target) {
		// To be completed
		 Node p = head;
         if(p == null)
             return;
         while( p.getNext().getNext() != null)
             p = p.getNext();

         p.setNext(new Node(target,p.getNext()));

     }
}
