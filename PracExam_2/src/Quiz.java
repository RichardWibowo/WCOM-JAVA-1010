// Enter your name and student id below

// Name : 

// Student ID : 

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
	 * @param n : the integer to search (assume greater than zero)
	 * 
	 * @return the number of zeros in the number
	 * 		   return 0 if n is negative.
	 * 
	 * Examples:
	 * 
	 * countZeros(1002003) -> 4
	 * countZeros(10) -> 1
	 * countZeros(0) -> 0
	 * countZeros(-10) -> 0
	 * 
	 */
	public static int countZeros(int n) {
		// To be completed
		if(n < 1) {
			return 0;
		}if(n%10 == 0 ) {
			return 1 + countZeros(n/10);
		}return countZeros(n/10);
	}
	
	/**
	 * Question 2: Recursion (10 marks)
	 * 
	 * THE IMPLEMENTATION FOR THIS METHOD MUST BE RECURSIVE
	 * 
	 * @param s : String
	 * @return number of lower case characters in s
	 * 
	 *  EXAMPLES: 
	 *  		
	 *  	   n = "WhatT" -> 3
	 * 
	 *         n = "aBCd" -> 2
	 * 
	 *         n = "SHOUT" -> 0
	 *         
	 *         n = "shout" -> 5
	 *         
	 */
	public static int countLowerCase(String s) {
		// To be completed
		if(s.length() <= 0) {
			return 0;
		}if(s.charAt(0)>= 'a'&& s.charAt(0)<='z') {
			return 1 + countLowerCase(s.substring(1));
		}
		return countLowerCase(s.substring(1));
	}

	/**
	 * Question 3: Recursion (Difficult) (10 marks)
	 * 
	 * THE IMPLEMENTATION FOR THIS METHOD MUST BE RECURSIVE
	 * 
	 * @param n
	 *            : the integer to search through
	 *            
	 * @param target
	 *            : the target sum
	 *            
	 * @return true if any two adjacent digits in n add to the target
	 * 		   false otherwise
	 *
	 *	NOTE: adjacent digits are digits which are next to each other.
	 *
	 *		  For example if n = 4563:
	 *				
	 *			4 and 5 are adjacent (next to each other)
	 *			5 and 6 are adjacent (next to each other)
	 *			...
	 *
	 * EXAMPLES:
	 *
	 *         digitsSumTo(1234,7) -> true (since 3 + 4 = 7)
	 * 
	 *         digitsSumTo(1234,3) -> true (since 1 + 2 = 3)
	 *         
	 *         digitsSumTo(1234,10) -> false
	 *         
	 *         digitsSumTo(64521,7) -> true (since 5 + 2 = 7)
	 *         
	 *         digitsSumTo(64521,0) -> false
	 *         
	 *         digitsSumTo(0,0) -> false
	 *         
	 */
	public static Boolean digitsSumTo(int n, int target) {
		// To be completed
		if(n == 0) {
			return false;
		}if(n/10 + n/100 == target) {
			return digitsSumTo(n/10,target);
		}
		return digitsSumTo(n/1000,target);
	}
	
}
/**
 * Continue scrolling down to Questions 4 and 5.
 */

//A custom linked list of Integer objects
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

	public void addFirst(int s) {
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
	 * QUESTION 4: LinkedLists (10 marks)
	 * 
	 * @return the number of non-zero even integers in the list.
	 * 		   return 0 if the head is null.
	 * 
	 * Example:
	 * 
	 * If head - > 4 -> 5 -> 7 -> 2 -> 0 -> null
	 * 
	 * Then  countEvens() should return 2. (since 0 is not a non-zero even number)
	 * 		   
	 */
	public double countEvens() {
		// To be completed
		Node C = head;
		int count = 0;
		
			while(C != null ) {
				if(C.getData()%2 == 0) {
					count++;
						if(C.getData()==0) {
							count--;
					}
				}
				C=C.getNext();
			}
		return count;
	}

	/**
	 * QUESTION 5: LinkedLists (Difficult) (10 marks)
	 *            
	 * This method should should remove all odd integers from the list.
	 * 
	 * Example:
	 * 
	 * If head - > 4 -> 5 -> 7 -> 2 -> 0 -> null
	 * 
	 * After calling removeOdds() the list should become:
	 * 
	 * If head - > 4 -> 2 -> 0 -> null
	 * 
	 *   
	 */
	public void removeOdds() {
		// To be completed
		Node current = head;	
		
		while(current != null) {
		
			if(	current.getNext().getData()%2 == 0) {
				current = current.setNext(current.getNext());
		}
				current = current.getNext();
		}
		
		}
	}
	


