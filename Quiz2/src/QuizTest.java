
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
	public void testFirstEven() {
		double marks = 0;
		double thisTotal = total;
		
		int[] arr = {4,5,8,1};
		marks+=assertEqual(0, Quiz.firstEven(arr), 1);
		arr[0]=1;
		marks+=assertEqual(2, Quiz.firstEven(arr), 1);
		arr[0]=0;
		marks+=assertEqual(2, Quiz.firstEven(arr), 1);
		int[] brr = {11,55,405,999,53,60};
		marks+=assertEqual(5, Quiz.firstEven(brr), 1);
		brr[5]=9;
		marks+=assertEqual(-1, Quiz.firstEven(brr), 1);
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> firstEven(int[]) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}

	// Question 2
	@Test
	(timeout = 500)
	public void testFindStart() {
		double marks = 0;
		double thisTotal = total;
		String[] arr = {"Hello","There","Yellow","That","yellz"}; 
		
		marks+=assertEqual(1, Quiz.findStart(arr,"Th"), 2);
		marks+=assertEqual(2, Quiz.findStart(arr,"Yel"), 2);
		marks+=assertEqual(3, Quiz.findStart(arr,"That"), 2);
		marks+=assertEqual(4, Quiz.findStart(arr,"yel"), 2);
		marks+=assertEqual(-1, Quiz.findStart(arr,"th"), 2);

		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> findStart(String[],String) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 3
	@Test
	(timeout = 500)
	public void testBinarySearch() {
		double marks = 0;
		double thisTotal = total;
		Car[] arr = {new Car(302.99,"F11","Ferrari"),new Car(290.25,"Boxer","Porche"),new Car(120.5,"Corolla","Toyota"),
					new Car(110.1,"Camery","Toyota"),new Car(40.1,"Speedy","Bike"),new Car(10.1,"Hourse","")}; 

		marks+=assertEqual(1, Quiz.binarySearch(arr,290.25), 2);
		marks+=assertEqual(0, Quiz.binarySearch(arr,302.99), 2);
		marks+=assertEqual(4, Quiz.binarySearch(arr,40.1), 2);
		marks+=assertEqual(3, Quiz.binarySearch(arr,110.1), 2);
		marks+=assertEqual(-1, Quiz.binarySearch(arr,56.3), 2);
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> binarySearch(Car[],double) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 4
	@Test
	(timeout = 500)
	public void testFastestCar() {
		double marks = 0;
		double thisTotal = total;
		Car[] arr = new Car[4];
		
		arr[0] = new Car(120.5,"Corolla","Toyota");
		arr[1] = new Car(110.1,"Camery","Toyota");
		arr[2] = new Car(302.99,"F11","Ferrari");
		arr[3] = new Car(290.25,"Boxer","Porche");
		
		// Get the result from the fastestCar method
		Car result = Quiz.fastestCar(arr);
		// Make sure it is not null
		if(result==null) {
			// Force test fail
			marks+=assertEqual(1, -1, 10);
			// Please attempt the question
		}else {
			
			// Now check that the result is the fastest car
			marks+=assertEqual(302.99, result.getMaxSpeed(),3);
			// Check that it is the correct Car
			marks+=assertEqual("F11", result.getModel(), 2);
			
			// Check on another array
			Car[] brr = new Car[3];
			
			brr[0] = new Car(500.5,"i7","BMW");
			brr[1] = new Car(100.1,"i5","BMW");
			brr[2] = new Car(120.99,"A7","Audi");
			
			result = Quiz.fastestCar(brr);
			marks+=assertEqual(500.5, result.getMaxSpeed(), 3);
			marks+=assertEqual("i7", result.getModel(), 2);
				
		}
		thisTotal = total - thisTotal;
		System.out.println("Marked -> fastestCar(Car[]) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 5
	@Test
	(timeout = 500)
	public void testSumUnique() {
		double marks = 0;
		double thisTotal = total;

		int[] arr = {1,1,2,1,1};
		
		marks+=assertEqual(2, Quiz.sumUnique(arr), 3);
		
		arr[2]=1;
		
		marks+=assertEqual(0, Quiz.sumUnique(arr), 3);
		
		int[] b = {1,2,2,4};
		
		marks+=assertEqual(5, Quiz.sumUnique(b), 3);
		
		int[] d = {8,1,9,9,9};
		
		marks+=assertEqual(9, Quiz.sumUnique(d), 3);
		
		int[] e = {1,2,3,4,5};
		
		marks+=assertEqual(15, Quiz.sumUnique(e), 3);
		
		thisTotal = total - thisTotal;
		System.out.println("Marked -> sumUnique(int[]) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}

	@AfterClass
	public static void wrapUp() throws IOException {
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
	public static double twoDP(double n) {
		return Math.round(n*10)/10.0;
	}
	
}
