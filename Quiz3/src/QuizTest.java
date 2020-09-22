
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
	public void testGetArrayList() {
		double marks = 0;
		double thisTotal = total;
		
		ArrayList<String> ans = Quiz.getArrayList();
		
		if(ans==null) {
			// Please attempt the question
			// Forcing test fail
			assertEqual(1,-1,10);
		}else {
			marks+=assertEqual("Array",ans.get(0),2);
			marks+=assertEqual("Lists",ans.get(1),2);
			marks+=assertEqual("Are",ans.get(2),2);
			marks+=assertEqual("Very",ans.get(3),2);
			marks+=assertEqual("Useful",ans.get(4),2);	
		}
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> getArrayList() -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 2
	@Test
	(timeout = 500)
	public void testUpdateSuburbs() {
		double marks = 0;
		double thisTotal = total;
		
		ArrayList<Suburb> list = new ArrayList<Suburb>();
		
		list.add(new Suburb(100,200,"Somewhere"));
		list.add(new Suburb(200,200,"Far away"));
		list.add(new Suburb(150,200,"Farmland"));
		list.add(new Suburb(125000,200,"Sydney"));
		list.add(new Suburb(255,200,"Glebe"));
		
		Quiz.updateSuburbs(list);

		marks+=assertEqual(20000,list.get(0).getPopulation(),5);
		marks+=assertEqual("Ryde",list.get(2).getName(),5);
		
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> updateSuburbs() -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}

	
	// Question 3
	@Test
	(timeout = 500)
	public void testTotalPopulation() {
		double marks = 0;
		double thisTotal = total;
		
		ArrayList<Suburb> list = new ArrayList<Suburb>();
		
		list.add(new Suburb(250,2051,"Ryde"));
		
		marks+=assertEqual(250, Quiz.totalPopulation(list,"Ryde"),1);
		
		list.add(new Suburb(150,2051,"Ryde"));
		marks+=assertEqual(250+150, Quiz.totalPopulation(list,"Ryde"),1);
		
		list.add(new Suburb(125,2000,"Sydney"));
		marks+=assertEqual(250+150, Quiz.totalPopulation(list,"Ryde"),1);
		marks+=assertEqual(125, Quiz.totalPopulation(list,"Sydney"),1);
		
		list.add(new Suburb(500,2000,"Sydney"));
		marks+=assertEqual(250+150, Quiz.totalPopulation(list,"Ryde"),1);
		marks+=assertEqual(125+500, Quiz.totalPopulation(list,"Sydney"),1);
		
		list.add(new Suburb(360,2051,"Ryde"));
		marks+=assertEqual(250+150+360, Quiz.totalPopulation(list,"Ryde"),1);
		marks+=assertEqual(125+500, Quiz.totalPopulation(list,"Sydney"),1);
		
		list.add(new Suburb(420,2103,"Mona Vale"));
		marks+=assertEqual(250+150+360, Quiz.totalPopulation(list,"Ryde"),0.5);
		marks+=assertEqual(125+500, Quiz.totalPopulation(list,"Sydney"),0.5);
		
		marks+=assertEqual(420, Quiz.totalPopulation(list,"Mona Vale"),1);
		marks+=assertEqual(0, Quiz.totalPopulation(list,"Epping"),0.5);
		marks+=assertEqual(0, Quiz.totalPopulation(list,"Sydneys"),0.5);
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> totalPopulation(ArrayList<Suburb>) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 5
	@Test
	(timeout = 500)
	public void testShiftLeft() {
		double marks = 0;
		double thisTotal = total;
		
		ArrayList<Integer> list = new ArrayList<Integer>();

		list.add(12); // 12,5,9,1,2 -> 5,9,1,2,12
		list.add(5);
		list.add(9);
		list.add(1);
		list.add(2);
		
		Quiz.shiftLeft(list);
		
		if(list==null||list.size()!=5) {
			// Your method has changed the length of the ArrayList
			// Forcing test fail
			assertEqual(1,-1,10);
		}
		
		marks+=assertEqual(12,list.get(4),2);
		marks+=assertEqual(5,list.get(0),2);
		marks+=assertEqual(9,list.get(1),2);
		marks+=assertEqual(1,list.get(2),2);
		marks+=assertEqual(2,list.get(3),2);
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> shiftLeft(ArrayList<Integer>) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 5
	@Test
	(timeout = 500)
	public void testClearSuburbs() {
		double marks = 0;
		double thisTotal = total;

		ArrayList<Suburb> list = new ArrayList<Suburb>();
	
		list.add(new Suburb(250,2051,"Ryde"));
		list.add(new Suburb(180,2102,"Newport"));		
		list.add(new Suburb(110,2000,"Sydney"));
		list.add(new Suburb(175,2101,"Elanora"));
		list.add(new Suburb(150,2051,"Ryde"));
		list.add(new Suburb(200,2103,"Mona Vale"));
		list.add(new Suburb(100,2101,"Ingleside"));
		list.add(new Suburb(99,2098,"Collaroy"));
		
		Quiz.clearSuburbs(list, 100);
		
		if(list.size()==8) {
			// Force fail, nothing removed
			assertEqual(1, -1, 10);
		}else {
		
			marks += assertEqual(7, list.size(), 1);
			marks += assertEqual("Ingleside", list.get(6).getName(), 1);
			
			Quiz.clearSuburbs(list, 160);
			marks += assertEqual(4, list.size(), 1);
			marks += assertEqual("Newport", list.get(1).getName(), 1);
			marks += assertEqual("Elanora", list.get(2).getName(), 1);
			marks += assertEqual("Mona Vale", list.get(3).getName(), 1);
			
			Quiz.clearSuburbs(list, 201);
			marks += assertEqual(1, list.size(), 2);
			marks += assertEqual("Ryde", list.get(0).getName(), 2);
		}

		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> clearSuburbs(ArrayList<Suburb>) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
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
	public boolean isAsc(Suburb[] a) {
		if (a == null)	
			return false;
		for (int i = 0; i < a.length - 1; i++)
			if (a[i].getPopulation() > a[i + 1].getPopulation())
				return false;
		return true;
	}
	public boolean isDesc(int[] a) {
		if (a == null)
			return false;
		for (int i = 0; i < a.length - 1; i++)
			if (a[i] < a[i + 1])
				return false;
		return true;
	}
	public static double twoDP(double n) {
		return Math.round(n*10)/10.0;
	}
	
}
