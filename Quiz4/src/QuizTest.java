
/*****************************
 *                           *
 * DO NOT MODIFY THIS FILE   *
 *						 	 *
 *****************************/

/*********************************
 *                           	 *
 * IF YOU ARE USING THE DEBUGGER *
 *  							 *
 *								 *
 * Comment out all (timeout=500) *
 *								 *
 *						 	     *
 *********************************/

import static org.junit.Assert.*;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import java.io.*;
import java.util.ArrayList;

public class QuizTest {
	private static double score = 0;
	private static double total = 0;
	
	@Rule
	public ErrorCollector collector = new ErrorCollector();
	
	
	/*****************************
	 *                           *
	 *   TEST CASES ARE BELOW    *
	 *						 	 *
	 *****************************/
	// assertEqual(expected,actual,mark)

	// Question 1
	@Test
	(timeout = 500)
	public void testSumDigits() {
		double marks = 0;
		double thisTotal = total;

		marks+=assertEqual(1,Quiz.timesDigits(-40),2);
		marks+=assertEqual(1,Quiz.timesDigits(0),2);
		marks+=assertEqual(2*8*9,Quiz.timesDigits(289),2);
		marks+=assertEqual(5*2*3*9,Quiz.timesDigits(5239),2);
		marks+=assertEqual(5,Quiz.timesDigits(5),2);

		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> sumDigits(int) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 2
	@Test
	(timeout = 500)
	public void testCountDigitsLessThan() {
		double marks = 0;
		double thisTotal = total;

		marks+=assertEqual(0,Quiz.countDigitsLessThan(-40,9),1);
		marks+=assertEqual(0,Quiz.countDigitsLessThan(96,3),1);
		marks+=assertEqual(4,Quiz.countDigitsLessThan(12345,4),2);
		marks+=assertEqual(1,Quiz.countDigitsLessThan(245,3),1);
		marks+=assertEqual(3,Quiz.countDigitsLessThan(4619,6),2);
		marks+=assertEqual(6,Quiz.countDigitsLessThan(111111,2),2);
		marks+=assertEqual(5,Quiz.countDigitsLessThan(99998,9),1);

		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> countDigitsLessThan(int) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 3
	@Test
	(timeout = 500)
	public void testSumGreaterThan() {
		double marks = 0;
		double thisTotal = total;
		
		MyLinkedList list = new MyLinkedList();
		
		// You must return 0 if the list is empty
		marks+=assertEqual(0, list.sumGreaterThan(100), 2);

		list.addFirst(5.5);
		list.addFirst(3.2);
		list.addFirst(-1.6);
		list.addFirst(8.2);
		list.addFirst(-4.4);
		
		marks+=assertEqual(5.5+3.2+8.2, list.sumGreaterThan(1), 2);

		marks+=assertEqual(5.5+3.2+8.2-1.6, list.sumGreaterThan(-2), 2);
		
		list.addFirst(8.9);

		marks+=assertEqual(8.9+8.2, list.sumGreaterThan(8), 2);
		
		list.addFirst(80);
		marks+=assertEqual(80, list.sumGreaterThan(80), 2);

		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> sumGreaterThan(double) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 4
	@Test
	(timeout = 500)
	public void testRemoveFirstN() {
		double marks = 0;
		double thisTotal = total;
		
		MyLinkedList list = new MyLinkedList();
		
		list.addFirst(8.1);// 7
		list.addFirst(5.7);// 6
		list.addFirst(1.3);// 5
		list.addFirst(9.7);// 4
		list.addFirst(4.2);// 3
		list.addFirst(8.8);// 2
		list.addFirst(4.2);// 1
		list.addFirst(5.6);// 0
	
		list.removeFirstN(4);
		
		if(list.get(4)!=null) {
			// Nothing was removed
			// Forcing test fail
			assertEqual(1,-1,20);
		}else {
			
			// Check that it was added
			marks+=assertEqual(9.7, list.get(0).getData(),2);
			marks+=assertEqual(1.3, list.get(1).getData(),2);
			marks+=assertEqual(5.7, list.get(2).getData(),2);
			marks+=assertEqual(8.1, list.get(3).getData(),2);
			
			// Check if it removes at least 1
			list = new MyLinkedList();
			list.addFirst(2);// 1
			list.addFirst(3);// 0
		
			list.removeFirstN(1);
			marks+=assertEqual(2, list.get(0).getData(),1);
			
			// Check if it stops if n > size
			list = new MyLinkedList();
			list.addFirst(4);// 3
			list.addFirst(6);// 2
			list.addFirst(2);// 1
			list.addFirst(3);// 0
			
			list.removeFirstN(10);
			
			marks+=assertIsTrue(list.getHead()==null,1);
			
		}
	
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> removeFirstN(int) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 5
	@Test
	(timeout = 500)
	public void testAddSecLast() {
		double marks = 0;
		double thisTotal = total;
		
		MyLinkedList list = new MyLinkedList();
		
		list.addFirst(9.7);// 4
		list.addFirst(4.2);// 3
		list.addFirst(8.8);// 2
		list.addFirst(4.2);// 1
		list.addFirst(5.6);// 0
		list.addSecLast(2.1);
		
		if(list.get(5)==null) {
			// It was not added
			// Forcing test fail
			assertEqual(1,-1,20);
		}else {
			
			// Check that it was added
			marks+=assertEqual(5.6, list.get(0).getData(),0.5);
			marks+=assertEqual(4.2, list.get(1).getData(),0.5);
			marks+=assertEqual(8.8, list.get(2).getData(),0.5);
			marks+=assertEqual(4.2, list.get(3).getData(),0.5);
			marks+=assertEqual(2.1, list.get(4).getData(),3);
			marks+=assertEqual(9.7, list.get(5).getData(),3);
			
			// Check again
			list.addSecLast(10);
			marks+=assertEqual(2.1, list.get(4).getData(),2);
			marks+=assertEqual(10, list.get(5).getData(),2);
			marks+=assertEqual(9.7, list.get(6).getData(),2);
			
			// Check if the second last Node is the head
			list = new MyLinkedList();
			list.addFirst(2);
			list.addFirst(3);
		
			list.addSecLast(5);
			marks+=assertEqual(3, list.get(0).getData(),2);
			marks+=assertEqual(5, list.get(1).getData(),2);
			marks+=assertEqual(2, list.get(2).getData(),2);
		}
	
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> addSecLast(double) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	@AfterClass
	public static void wrapUp() throws IOException {
		score = twoDP(score);
		total = twoDP(total);
		System.out.println("Overall you scored: "+score+"/ 50.0 marks");
	}
	
	public double assertEqual(int exp, int act,double w) {
		total+=w;
		try {
			assertEquals(exp, act);
			score+=w;
			return w;
		}catch(Throwable t) {
			collector.addError(t);
			return 0;
		}
	}
	public double assertEqual(int[] exp, int[] act,double w) {
		total+=w;
		try {
			assertEquals(exp, act);
			score+=w;
			return w;
		}catch(Throwable t) {
			collector.addError(t);
			return 0;
		}
	}
	public double assertEqual(String exp, String act,double w) {
		total+=w;
		try {
			assertEquals(exp, act);
			score+=w;
			return w;
		}catch(Throwable t) {
			collector.addError(t);
			return 0;
		}
	}
	public double assertEqual(char exp, char act,double w) {
		total+=w;
		try {
			assertEquals(exp, act);
			score+=w;
			return w;
		}catch(Throwable t) {
			collector.addError(t);
			return 0;
		}
	}
	public double assertEqual(double exp, double act,double w) {
		total+=w;
		try {
			assertEquals(exp, act,0.005);
			score+=w;
			return w;
		}catch(Throwable t) {
			collector.addError(t);
			return 0;
		}
	}
	public double assertEqual(double[] exp, double[] act,double w) {
		total+=w;
		try {
			assertEquals(exp, act);
			score+=w;
			return w;
		}catch(Throwable t) {
			collector.addError(t);
			return 0;
		}
	}
	public double assertIsTrue(boolean exp,double w) {
		total+=w;
		try {
			assertTrue(exp);
			score+=w;
			return w;
		}catch(Throwable t) {
			collector.addError(t);
			return 0;
		}
	}
	public double assertIsFalse(boolean exp,double w) {
		total+=w;
		try {
			assertFalse(exp);
			score+=w;
			return w;
		}catch(Throwable t) {
			collector.addError(t);
			return 0;
		}
	}
	public double assertEqual(ArrayList<Integer> exp, ArrayList<Integer> act,double w) {
		total+=w;
		try {
			assertEquals(exp, act);
			score+=w;
			return w;
		}catch(Throwable t) {
			collector.addError(t);
			return 0;
		}
	}
	public static double twoDP(double n) {
		return Math.round(n*10)/10.0;
	}
	
}
