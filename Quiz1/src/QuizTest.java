
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
	public void testsetWeight() {
		double marks = 0;
		double thisTotal = total;
		
		Cat b = new Cat();
		b.setWeight(10.5);
		marks+=assertEqual(10.5, b.getWeight(), 1);
		b.setWeight(-10);
		marks+=assertEqual(0.01, b.getWeight(), 2);
		b.setWeight(80);
		marks+=assertEqual(24.99, b.getWeight(),2);
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> setWeight(int) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	@Test
	public void testSetName() {
		double marks = 0;
		double thisTotal = total;
		
		Cat b = new Cat();
		b.setName("");
		marks+=assertEqual("Cute ", b.getName(), 2);
		b.setName("Short");
		marks+=assertEqual("Cute Short", b.getName(), 2);
		b.setName("A very very loooong name");
		marks+=assertEqual("A very very loooong name", b.getName(),1);
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> setName(String) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	@Test
	public void testCat() {
		double marks = 0;
		double thisTotal = total;
		
		Cat b = new Cat();
		marks+=assertEqual(4.81, b.getWeight(), 2.5);
		marks+=assertEqual("Mittens", b.getName(), 2.5);
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> Cat() -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	@Test
	public void testCat2() {
		double marks = 0;
		double thisTotal = total;
		
		Cat b = new Cat(10,"");
		marks+=assertEqual(10, b.getWeight(),0.5);
		marks+=assertEqual("Cute ", b.getName(), 0.5);
		
		b = new Cat(-60,"Short");
		marks+=assertEqual(0.01, b.getWeight(), 1);
		marks+=assertEqual("Cute Short", b.getName(), 1);
		
		b = new Cat(2000,"A very very loooong name");
		marks+=assertEqual(24.99, b.getWeight(),1);
		marks+=assertEqual("A very very loooong name", b.getName(),1);
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> Cat(int,String) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	@Test
	public void testGetWeightPounds() {
		double marks = 0;
		double thisTotal = total;
		
		Cat b = new Cat();
		b.xyz(15);
		marks+=assertEqual(33, b.getWeightPounds(), 2);
		b.xyz(2);
		marks+=assertEqual(4.4, b.getWeightPounds(), 2);
		b.xyz(7);
		marks+=assertEqual(15.4, b.getWeightPounds(), 1);
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> getWeightPounds() -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	@Test
	public void testCompareTo() {
		double marks = 0;
		double thisTotal = total;
		
		Cat a = new Cat();
		Cat b = new Cat();
		a.xyz(10);
		b.xyz(5);
		marks+=assertEqual(1,a.compareTo(b), 2);
		marks+=assertEqual(-1,b.compareTo(a), 2);
		a.xyz(5);
		marks+=assertEqual(0,b.compareTo(a), 1);
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> compareTo(Cat) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	@Test
	public void testToString() {
		double marks = 0;
		double thisTotal = total;
		
		Cat a = new Cat();
		a.xyz(15.6);
		a.abc("Messy");
		// Make sure the String isn't null
		if(a.toString()!=null) {
			// This first test is to give you partial marks if you are missing spaces and capitals
			marks+=assertEqual("messythecatweighs15.6kgs.",a.toString().replace(" ", "").toLowerCase(), 2);
			// This second test is if you have the answer correct
			a.xyz(5.5);
			a.abc("Bruce");
			marks+=assertEqual("Bruce the cat weighs 5.5 kgs.",a.toString(), 3);
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
	public void testNewDog() {
		double marks = 0;
		double thisTotal = total;
		
		Dog p = Quiz.oldDog();
		if(p!=null) {
			marks+=assertEqual(7,p.getAge(), 1);
			marks+=assertEqual("Cattle",p.getBreed(), 1);
		}else {
			// Forcing a fail -> you have not attempted the question
			// Or your method is returning null
			marks+=assertEqual(-1,1, 2);
		}

		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> oldDog() -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 3
	@Test
	public void testTotalAge() {
		double marks = 0;
		double thisTotal = total;
		
		Dog[] arr = new Dog[4];
		arr[0] = new Dog(10,"NA");
		arr[1] = new Dog(5,"NA");
		arr[2] = new Dog(8,"NA");
		arr[3] = new Dog(11,"NA");
		
		marks+=assertEqual("The total age is 16.",Quiz.totalAge(arr), 1);
		arr[3] = new Dog(15,"NA");
		marks+=assertEqual("The total age is 20.",Quiz.totalAge(arr), 1);
		arr[2] = new Dog(0,"NA");
		marks+=assertEqual("The total age is 20.",Quiz.totalAge(arr), 1);


		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> totalAge(Dog[]) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
	}
	
	// Question 4
	@Test
	(timeout = 500) 
	public void testAvgAge() {
		double marks = 0;
		double thisTotal = total;
		
		Dog[] arr = new Dog[0];
		
		marks+=assertEqual(0,Quiz.avgAge(arr), 1);
		
		arr = new Dog[5];
		arr[0] = new Dog(58,"Cattle");
		arr[1] = new Dog(65,"Bulldog");
		arr[2] = new Dog(12,"Staffy");
		arr[3] = new Dog(89,"Bulldog");
		arr[4] = new Dog(16,"Cattle");
		
		marks+=assertEqual(48,Quiz.avgAge(arr), 2);
		arr[2] = new Dog(0,"Staffy");
		marks+=assertEqual(45.6,Quiz.avgAge(arr), 2);
		arr[3] = new Dog(6,"Cattle");
		marks+=assertEqual(29,Quiz.avgAge(arr), 2);
		arr[0] = new Dog(500,"Staffy");
		marks+=assertEqual(117.4,Quiz.avgAge(arr), 2);
		
		arr[0] = new Dog(0,"Bulldog");
		arr[1] = new Dog(0,"Bulldog");
		arr[2] = new Dog(0,"Staffy");
		arr[3] = new Dog(0,"Cattle");
		arr[4] = new Dog(0,"Staffy");
		marks+=assertEqual(0,Quiz.avgAge(arr), 1);
		
		
		thisTotal = total - thisTotal;
		
		System.out.println("Marked -> avgAge(Dog[]) -> scored: "+twoDP(marks)+"/"+twoDP(thisTotal)+" marks\n");
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
