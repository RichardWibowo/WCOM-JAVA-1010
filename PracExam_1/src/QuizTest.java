
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
	public void testSetNetIncome() {
		double marks = 0;
		double thisTotal = total;
		
		Business b = new Business();
		b.setNetIncome(10);
		marks+=assertEqual(10, b.getNetIncome(), 1);
		b.setNetIncome(-10);
		marks+=assertEqual(0, b.getNetIncome(), 2);
		b.setNetIncome(8000);
		marks+=assertEqual(8000, b.getNetIncome(),2);
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> setNetIncome(double) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	@Test
	public void testSetName() {
		double marks = 0;
		double thisTotal = total;
		
		Business b = new Business();
		b.setName("long with no caps");
		marks+=assertEqual("Long with no caps", b.getName(), 2);
		b.setName("noCaps");
		marks+=assertEqual("NoCaps", b.getName(), 2);
		b.setName("Has Caps");
		marks+=assertEqual("Has Caps", b.getName(),1);
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> setName(String) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	@Test
	public void testBusiness() {
		double marks = 0;
		double thisTotal = total;
		
		Business b = new Business(10,"long with no caps");
		marks+=assertEqual(10, b.getNetIncome(),0.5);
		marks+=assertEqual("Long with no caps", b.getName(), 0.5);
		
		b = new Business(-60,"no Caps");
		marks+=assertIsTrue(0==b.getNetIncome() && "No Caps".equals(b.getName()), 2);
		
		b = new Business(2000,"Has Caps");
		marks+=assertEqual(2000, b.getNetIncome(),1);
		marks+=assertEqual("Has Caps", b.getName(),1);

		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> Business(double,String) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	@Test
	public void testCompareTo() {
		double marks = 0;
		double thisTotal = total;
		
		Business a = new Business();
		Business b = new Business();
		a.xyz(10);
		b.xyz(5);
		marks+=assertEqual(1,a.compareTo(b), 2);
		marks+=assertEqual(-1,b.compareTo(a), 2);
		a.xyz(5);
		marks+=assertEqual(0,b.compareTo(a), 1);
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> compareTo(Business) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	@Test
	public void testToString() {
		double marks = 0;
		double thisTotal = total;
		
		Business a = new Business();
		a.xyz(1000000);
		a.abc("Grilld");
		// Make sure the String isn't null
		if(a.toString()!=null) {
			// This first test is to give you partial marks if you are missing spaces and capitals
			marks+=assertEqual("Grilldhasanetincomeof$1000000.0.",a.toString().replace(" ", ""), 2);
			// This second test is if you have the answer correct
			a.xyz(20);
			a.abc("McDonalds");
			marks+=assertEqual("McDonalds has a net income of $20.0.",a.toString(), 3);
		}else {
			// Forcing a fail -> you have not attempted the question
			// Or your method is returning null
			marks+=assertEqual(-1,1, 5);
		}
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> toString() -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 2
	@Test
	(timeout = 500)
	public void testFindBetween() {
		double marks = 0;
		double thisTotal = total;
		
		ArrayList<Business> list = new ArrayList<Business>();
		ArrayList<Business> ans = new ArrayList<Business>();
		
		ArrayList<Business> result = Quiz.findBetween(list,1,2);
		
		if(result == null) {
			// You have not attempted the question correctly
			// Forcing test fail
			marks += assertEqual(1,-1,5);
		}else {
		
			marks+=assertEqual(0,result.size(),0.5);
			
			list.add(new Business("t2",200));
			list.add(new Business("t2",400));
			list.add(new Business("t2",900));
			list.add(new Business("t2",1000));
			list.add(new Business("t2",400));
			list.add(new Business("t2",500));
			list.add(new Business("t2",100));
			list.add(new Business("t2",10));
			
			ans.add(new Business("t2",900));
			ans.add(new Business("t2",1000));
			ans.add(new Business("t2",500));

			marks+=assertIsTrue(ans.equals(Quiz.findBetween(list,500,2000)),1.5);
			
			ans = new ArrayList<Business>();
			ans.add(new Business("t2",100));
			ans.add(new Business("t2",10));
			marks+=assertIsTrue(ans.equals(Quiz.findBetween(list,5,100)),1.5);
			
			ans = new ArrayList<Business>();
			ans.add(new Business("t2",200));
			ans.add(new Business("t2",400));
			ans.add(new Business("t2",400));
			ans.add(new Business("t2",100));
			marks+=assertIsTrue(ans.equals(Quiz.findBetween(list,15,440)),1.5);
		}

		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> findBetween() -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 3
	@Test
	(timeout = 500)
	public void testHighestIncome() {
		double marks = 0;
		double thisTotal = total;
		
		ArrayList<Business> list= new ArrayList<Business>();
		Business a = new Business();
		a.xyz(600);
		a.abc("ShopnGo");
		list.add(a);
		
		Business b = new Business();
		b.xyz(8000);
		b.abc("Code pros");
		list.add(b);

		Business c = new Business();
		c.xyz(50);
		c.abc("Oporto");
		list.add(c);
		
		Business d = new Business();
		d.xyz(786);
		d.abc("Mad Mex");
		list.add(d);
		
		Business e = new Business();
		e.xyz(10);
		e.abc("KFC");
		list.add(e);
		
		Business result = Quiz.highestIncome(list);
		
		if(result==null) {
			// You have not implemented this method correctly
			// Forcing test fail
			assertEqual(1,-1,10);
		}else {

			marks+=assertEqual(8000,result.getNetIncome(),3);
			marks+=assertEqual("Code pros",result.getName(),2);
			
			list.get(4).xyz(100000);
			
			marks+=assertEqual("KFC",Quiz.highestIncome(list).getName(),3);
			
			ArrayList<Business> brr= new ArrayList<Business>();
			
			marks+=assertIsTrue(null==Quiz.highestIncome(brr),2);
		
		}
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> highestIncome(ArrayList<Business>) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
		
	// Question 4
	@Test
	(timeout = 500)
	public void testRemoveBusiness() {
		double marks = 0;
		double thisTotal = total;
		
		ArrayList<Business> original = new ArrayList<Business>();
		ArrayList<Business> list = new ArrayList<Business>();
		ArrayList<Business> ans = new ArrayList<Business>();
		
		// Test deleting nothing
		original.add(new Business("Harrys",200));
		original.add(new Business("PiesRUS",100));
		original.add(new Business("Daniels",10));
		original.add(new Business("HungryTime",10));
		
		list.add(new Business("Harrys",200));
		list.add(new Business("PiesRUS",100));
		list.add(new Business("Daniels",10));
		list.add(new Business("HungryTime",10));

		ArrayList<Business> result = Quiz.removeBusiness(list,"Pizziaolo");
		
		if(result == null) {
			// You have not attempted the question correctly
			// Forcing test fail
			marks += assertEqual(1,-1,10);
		}else {
		
			// Check the result is empty
			marks+=assertEqual(0,result.size(),0.5);
			// Check the list has not changed
			marks+=assertIsTrue(list.equals(original),0.5);
			
			// Check removing 1 item
			ans.add(new Business("Daniels",10));
			// Check return
			marks+=assertIsTrue(ans.equals(Quiz.removeBusiness(list,"Daniels")),2);
			
			// Check the list changed by adding Daniels back and checking equal
			list.add(2,new Business("Daniels",10));
			marks+=assertIsTrue(list.equals(original),2);
			
			// Check removing two items
			original.add(2,new Business("Daniels",120));
			list.add(2,new Business("Daniels",120));
			
			ans = new ArrayList<Business>();
			ans.add(new Business("Daniels",120));
			ans.add(new Business("Daniels",10));
			
			// Check return
			marks+=assertIsTrue(ans.equals(Quiz.removeBusiness(list,"Daniels")),2);
			
			// Check the list changed by adding Daniels back and checking equal
			list.add(2,new Business("Daniels",10));
			list.add(2,new Business("Daniels",120));
			marks+=assertIsTrue(list.equals(original),3);
			
		}

		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> removeBusiness() -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
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
