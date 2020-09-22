import w5l1.node;

// You should edit only the methods body which have "To be completed" commented within them.

// You must NOT 
// 1) change any class name or its visibility.
// 2) change any method signatures (visibility, type, name or its parameters) 

// Good luck!

public class Quiz {
	
	/**
	 * Question 1: Recursion (5 marks)
	 * 
	 * THE IMPLEMENTATION FOR THIS METHOD MUST BE RECURSIVE
	 * 
	 * @param n : the final integer to consider
	 * @return the sum of every second number from n to 0.
	 * 		   If n is negative, return 0.
	 * 
	 * Example:
	 * sumSecond(13) -> 11 + 9 + 7 + 5 + 3 + 1 = 36
	 * sumSecond(5) -> 3 + 1 = 4
	 * sumSecond(-2) -> 0
	 * 
	 */
	public static int sumSecond(int n) {
		// To be completed
		if(n<=2) {
			return 0;
		}
		return (n-2)+sumSecond(n-2); 
	}
	
	/**
	 * Question 2: Recursion (10 marks)
	 * 
	 * THE IMPLEMENTATION FOR THIS METHOD MUST BE RECURSIVE
	 * 
	 * @param n : the integer to search
	 * @return the number of digits in n which are multiples of 3
	 * 
	 * Examples:
	 * 
	 * countThree(489361) -> 3 (Since 9, 3 and 6 are multiples of 3)
	 * countThree(1245780) -> 0
	 * 
	 */
	public static int countThree(int n) {
		// To be completed
		if(n <= 0) {
			return 0;
		}
		if(n%10>0 && (n%10)%3 == 0) {
			return 1+countThree(n/10);
		}
		return countThree(n/10);
	}
	public static int countFour(int n) {
		if(n <= 0) {
			return 0;
		}
		if(n%10 == 4) {
			return 1+countFour(n/10);
		}
		return countFour(n/10);
	}
	
	public static int sumDigitSqrt(int n) {
		if(n <= 0) {
			return 0;
		}
		return (n%10)*(n%10) + sumDigitSqrt(n/10);
		
	}

	/**
	 * Question 3: Recursion (10 marks)
	 * 
	 * THE IMPLEMENTATION FOR THIS METHOD MUST BE RECURSIVE
	 * 
	 * @param arr : An of doubles sorted in ascending order
	 * @param min : the minimum double
	 * @param i : an integer which will help iterating
	 * 
	 * @return the sum of all doubles in arr which are greater than min
	 * 
	 * Example:
	 * 
	 * If arr = {1.2,2.4,6.5,3.6,7.5} and min = 3 then
	 * 
	 * sumGreater(arr,min,0) should return 6.5+3.6+7.5=17.6
	 * 
	 */
	public static double sumGreater(double[] arr, double min, int i) {
		//To be completed
		 if (arr.length <= i) 
	            return 0; 
		if(arr[i]>min) {
			return arr[i] + sumGreater(arr,min,i+1);
		}
		return sumGreater(arr,min,i+1);
	}
}

//A custom linked list of String items
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
	 * QUESTION 4: LinkedLists (5 marks)
	 * 
	 * @param max : add all numbers below the double max
	 * @return the sum of all double's in the list which are smaller than max.
	 * 		   return 0 if the list is empty.
	 * 
	 * Example:
	 * 
	 * If head - > 2.8 -> -8.6 -> -1.6 -> 1.5 -> 5.5 -> null
	 * 
	 * Then  sumLessThan(2) should return -9,
	 * 
	 * 		 sumLessThan(-2.4) should return -12.4. 
	 * 
	 * 		 sumLessThan(-2000) should return 0. 
	 * 		   
	 */
	public double sumLessThan(double max) {
		// To be completed
		Node current = head;
		int sum = 0;
		while (current != null) {
			if(current.getData() <= max ) {
			sum += current.getData();
			current = current.getNext();
			}
		}
		return sum;
	}

	/**
	 * QUESTION 5: LinkedLists (10 marks)
	 * 
	 * @param idx : the index to add the new Node at.
	 * @param d : the double to store in the new Node.
	 *            
	 * This method should add a new Node at index idx which stores
	 * the data d.
	 * 
	 * Example:
	 * 
	 * If head - > 2.8 -> -8.6 -> -1.6 -> null
	 * 
	 * Then after executing addAt(1,5.5) the list should become:
	 * 
	 * head - > 2.8 -> 5.5 -> -8.6 -> -1.6 -> null
	 * 
	 *   
	 */
	public void addAt(int idx, double data) {
			// This method should remove the node in index idx

			if (idx == 0) {
				Node n = new Node(data, head);
				head = n;
				return;
			}

			
			Node current = head;

			for (int i = 0; i < idx - 1; i++) {
				current = current.getNext();
			}

			Node n = new Node(data, current.getNext());
			current.setNext(n);
		}
	
	/**
	 * QUESTION 6: LinkedLists (10 marks)
	 * 
	 * @return The number of unique doubles in the list.
	 * 		   return 0 if the list is empty.
	 * 
	 * 
	 * Example:
	 * 
	 * If head -> 4.5 -> 5.2 -> 4.5 -> 6.4 -> 1.2 -> 1.2 -> null
	 * 
	 * then countUnique should return 2 (since 5.2 and 6.4 are unique).
	 *   
	 */
	public int countUnique() {
		// To be completed
		return -1;
	}
	public void removeFirstTwo() {
		// This method should remove the first two nodes in the list
	head = head.getNext();
		if(head!=null) {
			head = head.getNext();
		}
	}
	
	public int productAll() {
		// This method should return the product of all integers stored within the list
		Node current = head;
		int product = 1 ;
		while(current!=null) {
			product *= current.getData();
			current = current.getNext();
		}
		return product;
	}
	
	public void removeAt(int idx) {
		// This method should remove the node in index idx
		if(idx == 0) {
			head = head.getNext();
			return;
		}
		Node current = head;
		for(int i = 0; i<idx-1;i++) {
			current = current.getNext();
		}//right spot
			current.setNext(current.getNext().getNext());
		}
	
	public int countEvens() {
		// This method should return the number of even integers stored within the list
		return 0;
	}

}

