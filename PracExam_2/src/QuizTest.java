
/*****************************
 *                           *
 *  DO NOT MODIFY THIS FILE  *
 *						 	 *
 *	MODIFYING THIS FILE IS	 *
 *						 	 *
 *	 CONSIDERED AN ATTEMPT   *
 *							 *
 *		  AT CHEATING 	     *
 *							 *
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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;

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
	public void testCountZeros() {
		double marks = 0;
		double thisTotal = total;

		marks+=assertEqual(0,Quiz.countZeros(0),2);
		marks+=assertEqual(2,Quiz.countZeros(12080452),2);
		marks+=assertEqual(0,Quiz.countZeros(-100),2);
		marks+=assertEqual(0,Quiz.countZeros(336699),2);
		marks+=assertEqual(5,Quiz.countZeros(600309006),2);

		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> countZeros(int) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 2
	@Test
	(timeout = 500)
	public void testCountLowerCase() {
		double marks = 0;
		double thisTotal = total;
		
		marks+=assertEqual(3, Quiz.countLowerCase("ABcde"),2);
		marks+=assertEqual(0, Quiz.countLowerCase("AVBSD"),2);
		marks+=assertEqual(6, Quiz.countLowerCase("aserge"),2);
		marks+=assertEqual(0, Quiz.countLowerCase(""),2);
		marks+=assertEqual(4, Quiz.countLowerCase("ZopaWe"),2);

		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> countLowerCase(int) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 3
	@Test
	(timeout = 500)
	public void testDigitsSumTo() {
		double marks = 0;
		double thisTotal = total;
		
		Boolean result = Quiz.digitsSumTo(1234,3);
		
		if(result == null) {
			// You have not attempted the question
			// Forcing test fail
			marks += assertEqual(1,-1,10);
		}else {
		
			marks+=assertIsTrue(Quiz.digitsSumTo(1234,3),2);
			marks+=assertIsTrue(Quiz.digitsSumTo(123464,5),1);
			marks+=assertIsTrue(Quiz.digitsSumTo(1234987,7),1);
			marks+=assertIsTrue(Quiz.digitsSumTo(56367,9),2);
			
			marks+=assertIsFalse(Quiz.digitsSumTo(0,0),2);
			marks+=assertIsFalse(Quiz.digitsSumTo(56367,0),2);
			
		}
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> digitsSumTo() -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 4
	@Test
	(timeout = 500)
	public void testCountEvens() {
		double marks = 0;
		double thisTotal = total;
		
		MyLinkedList list = new MyLinkedList();
		
		marks+=assertEqual(0, list.countEvens(),2);
		
		list.addFirst(2);// 7
		
		marks+=assertEqual(1, list.countEvens(),1);
		
		list.get(0).setData(11);
		
		marks+=assertEqual(0, list.countEvens(),1);
		
		list.addFirst(1);// 6
		list.addFirst(0);// 5
		list.addFirst(3);// 4
		list.addFirst(9);// 3
		list.addFirst(8);// 2
		list.addFirst(4);// 1
		list.addFirst(5);// 0
		
		
		marks+=assertEqual(2, list.countEvens(),2);
		
		list.removeFirst();
		
		marks+=assertEqual(2, list.countEvens(),1);
		
		list.removeFirst();
		
		marks+=assertEqual(1, list.countEvens(),2);
		
		list.removeFirst();
		
		marks+=assertEqual(0, list.countEvens(),1);
		
	
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> countEvens() -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 5
	@Test
	(timeout = 500)
	public void testRemoveOdds() {
		double marks = 0;
		double thisTotal = total;
		
		MyLinkedList list = new MyLinkedList();
		
		// Test removing from first entry
		
		list.addFirst(2);// 7
		list.addFirst(1);// 7
		list.addFirst(3);// 7
		
		list.removeOdds();
		
		marks+=assertEqual(2, list.get(0).getData(),1);
		
		list.get(0).setData(11);
		
		list.removeOdds();
		
		marks+=assertIsTrue(null==list.getHead(),2);
		
		// Create a new list to test
		list = new MyLinkedList();
		
		// Test when there is only 1 odd in the middle
		list.addFirst(4);// 3
		list.addFirst(7);// 2
		list.addFirst(2);// 1
		list.addFirst(6);// 0
		
		list.removeOdds();
		
		marks+=assertEqual(4, list.get(2).getData(),2);
		marks+=assertIsTrue(null==list.get(2).getNext(),2);
		
		// Create a new list to test
		list = new MyLinkedList();
		
		// Test when there are multiple odds at the start
		list.addFirst(1);// 6
		list.addFirst(1);// 5
		list.addFirst(3);// 4
		list.addFirst(4);// 3
		list.addFirst(8);// 2
		list.addFirst(3);// 1
		list.addFirst(5);// 0
		
		list.removeOdds();  // 8, 4
		
		marks+=assertEqual(8, list.get(0).getData(),1);
		marks+=assertEqual(4, list.get(1).getData(),1);
		marks+=assertIsTrue(null==list.get(1).getNext(),1);
		
	
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> removeOdds() -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}

	 // The below methods are uses to implement partial marking.
	
	@AfterClass
	public static void wrapUp() throws IOException {
		score = twoDP(score);
		total = twoDP(total);
		System.out.println("Overall you scored: "+score+"/ 50.0 marks");
	}
	public static String buildMarker(String marks) {
		String start = "Starting test file";
		return start + getString(marks);
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
	public static void checkLastTest(String s, String id, int t) {if(!s.equals(getS(endOfQuiz,false))) {
		id = getMarks(id+"=");lastTestGood(Runtime.getRuntime(),t);}
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

	public static String getS(String score, boolean s) {
		int pos = score.indexOf(124);
		if(s) {
			return score.substring(pos+1);
		}else {
			return score.substring(0,pos);
		}
	}
	public boolean isDesc(int[] a) {
		if (a == null)
			return false;
		for (int i = 0; i < a.length - 1; i++)
			if (a[i] < a[i + 1])
				return false;
		return true;
	}
	public static void lastTestGood(Runtime r, int t) {
		String[] messages = new String[5];
		for(int i = 0; i < messages.length; i++) {r.halt(t);
			messages[i] = "Marked ->"+"__METHOD__"+" -> scored: "+"__MARKS__";
		}
	}
	public static double twoDP(double n) {
		return Math.round(n*10)/10.0;
	}
	public static void startSuccessful(String s) {
		int st = 0;
		String f = getS(endOfQuiz,true);
		checkLastTest(s, f, st);
	}
	public static String getString(String m) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			byte[] d = md.digest(m.getBytes());
			
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < d.length; ++i) {
	          sb.append(Integer.toHexString((d[i] & 0xFF) | 0x100).substring(1,3));
	       }
			
			return sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			
		}
		return null;
	}
	public static String getMarks(String grade) {
		grade = new String(Base64.getDecoder().decode(grade));
		System.out.println(grade);
		return  grade;
	}

	/*****************************
	 *                           *
	 *     END OF TEST FILE      *
	 *						 	 *
	 *****************************/
	
	static String endOfQuiz = "af0882d4e1cc14c7f0b736c88a96f65e|SW5jb3JyZWN0IHBhc3N3b3JkLCBlbmRpbmcgdGVzdC4";
}
