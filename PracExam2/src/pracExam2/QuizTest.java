package pracExam2;
//DO NOT MODIFY THIS FILE

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class QuizTest {
	private static int score = 0;
	private static String result = "";
	// core methods

	@Test(timeout = 500) // for debugging remove: (timeout=500)
	@Graded(description = "sumOddDigits(int)", marks = 10)
	public void testCountOddDigits() {
		assertEquals(11, Quiz.sumOddDigits(31467));
		assertEquals(9, Quiz.sumOddDigits(9));
		assertEquals(0, Quiz.sumOddDigits(0));
		assertEquals(0, Quiz.sumOddDigits(2686268));
		assertEquals(22, Quiz.sumOddDigits(218672965));
		assertEquals(18, Quiz.sumOddDigits(113355));
		assertEquals(10, Quiz.sumOddDigits(1111111111));
		score += 10;
		result += "sumOddDigits(int) passed (10 marks)\n";
	}

	@Test(timeout = 500) // for debugging remove: (timeout=500)
	@Graded(description = "removeNonUpperCase(String)", marks = 15)
	public void testRemoveNonUpperCase() {

		assertEquals("GDHHH", Quiz.removeNonUpperCase("GhDfHtHrH"));
		assertEquals("HFTR", Quiz.removeNonUpperCase("gHdFhThRh"));
		assertEquals("HYTREEGT", Quiz.removeNonUpperCase("HeYnThReEnEiGhT"));
		assertEquals("TS", Quiz.removeNonUpperCase("TeSt"));
		assertEquals("A", Quiz.removeNonUpperCase("A"));
		assertEquals("", Quiz.removeNonUpperCase("a"));
		assertEquals("", Quiz.removeNonUpperCase(""));
		assertEquals("BD", Quiz.removeNonUpperCase("aBcnDe"));
		assertEquals("OIDJIDJF", Quiz.removeNonUpperCase("OIDJfoijw3iosIDJF"));
		assertEquals("", Quiz.removeNonUpperCase("84hg3e44"));
		assertEquals("HDEE", Quiz.removeNonUpperCase("HiDE12gE23"));

		score += 15;
		result += "removeNonUpperCase(String) passed (15 marks)\n";
	}

	@Test(timeout = 500) // for debugging remove: (timeout=500)
	@Graded(description = "numLongBrands(ArrayList<Car>)", marks = 10)
	public void testNumLongBrands() {

		ArrayList<Car> list = new ArrayList<Car>();
		assertEquals(0, Quiz.numLongBrands(list));

		list.add(new Car(101, "s1dhdfhdh"));
		assertEquals(1, Quiz.numLongBrands(list));

		list.add(new Car(25, "s2"));
		assertEquals(1, Quiz.numLongBrands(list));

		list.add(new Car(250, "sgdfghdhde2"));
		assertEquals(2, Quiz.numLongBrands(list));

		list.add(new Car(-10, "dgdfgdrgr"));
		assertEquals(3, Quiz.numLongBrands(list));

		list.remove(1);
		assertEquals(3, Quiz.numLongBrands(list));

		score += 10;
		result += "numLongBrands(ArrayList<Car>) passed (10 marks)\n";
	}

	@Test(timeout = 500) // for debugging remove: (timeout=500)
	@Graded(description = "timesNext(ArrayList<Integer>)", marks = 10)
	public void testTimesNext() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();

		list.add(12);
		ans.add(12);
		Quiz.timesNext(list);
		assertEquals(ans, list);

		list = new ArrayList<Integer>();
		ans = new ArrayList<Integer>();
		list.add(12);
		list.add(5);
		ans.add(60);
		ans.add(5);
		Quiz.timesNext(list);
		assertEquals(ans, list);

		ans = new ArrayList<Integer>();
		list = new ArrayList<Integer>();
		Random r = new Random();
		int p = r.nextInt(20);
		int n = r.nextInt(20);

		int end = 5 + r.nextInt(10);

		for (int i = 0; i <= end; i++) {
			list.add(p);
			if (i == end) {
				ans.add(p);
			} else {
				ans.add(p * n);
			}

			p = n;
			n = r.nextInt(20);
		}
		Quiz.timesNext(list);
		assertEquals(ans, list);

		score += 10;
		result += "addNext(ArrayList<Integer>) passed (10 marks)\n";

	}

	@Test(timeout = 500) // for debugging remove: (timeout=500)
	@Graded(description = "countSameBrand(LinkedList<Car> cars, Car target)", marks = 10)
	public void testCountSameBrand() {
		LinkedList<Car> list = new LinkedList<Car>();
		Car s = new Car(150, "Toyota");

		assertEquals(0, Quiz.countSameBrand(list, s));

		list.add(new Car(200, "Toyota"));
		list.add(new Car(400, "Nissan"));
		list.add(new Car(100, "Toyota"));
		list.add(new Car(10, "Mazda"));
		list.add(new Car(10, "Mazda"));
		list.add(new Car(10, "Mazda"));

		assertEquals(2, Quiz.countSameBrand(list, s));

		s.setBrand("Nope");
		assertEquals(0, Quiz.countSameBrand(list, s));

		s.setBrand("Toyotaz");
		assertEquals(0, Quiz.countSameBrand(list, s));

		s.setBrand("Nissan");
		assertEquals(1, Quiz.countSameBrand(list, s));

		s.setBrand("Mazda");
		assertEquals(3, Quiz.countSameBrand(list, s));

		score += 10;
		result += "countSameBrand(LinkedList<Car> cars, Car target) passed (10 marks)\n";

	}

	@Test(timeout = 500) // for debugging remove: (timeout=500)
	@Graded(description = "findCars(ArrayList<Car> cars, int numSeats, String brand)", marks = 15)
	public void testFindCars() {
		ArrayList<Car> list = new ArrayList<Car>();
		ArrayList<Car> ans = new ArrayList<Car>();

		assertEquals(ans, Quiz.findCars(list, 1, "Toyota"));

		list.add(new Car(200, "Toyota"));
		list.add(new Car(400, "Toyota"));
		list.add(new Car(400, "Toyota"));
		list.add(new Car(1000, "Nissan"));
		list.add(new Car(3, "Nissan"));
		list.add(new Car(8, "Mazda"));
		list.add(new Car(8, "Mazda"));
		list.add(new Car(8, "Mazda"));

		ans.add(new Car(400, "Toyota"));
		ans.add(new Car(400, "Toyota"));
		assertEquals(ans, Quiz.findCars(list, 400, "Toyota"));

		ans = new ArrayList<Car>();
		ans.add(new Car(3, "Nissan"));
		assertEquals(ans, Quiz.findCars(list, 3, "Nissan"));

		ans = new ArrayList<Car>();
		ans.add(new Car(8, "Mazda"));
		ans.add(new Car(8, "Mazda"));
		ans.add(new Car(8, "Mazda"));
		assertEquals(ans, Quiz.findCars(list, 8, "Mazda"));

		score += 15;
		result += "findCars(ArrayList<Car> cars, int numSeats, String brand) passed (15 marks)\n";

	}

	@Test(timeout = 500) // for debugging remove: (timeout=500)
	@Graded(description = "MyLinkedList:lastIndexOf(Double target)", marks = 10)
	public void testMyLinkedLastIndexOf() {
		MyLinkedList list = new MyLinkedList();
		assertEquals(-1, list.lastIndexOf(1.3));

		list.add(5.5);
		list.add(6.9);
		list.add(5.5);
		list.add(5.5);
		assertEquals(2, list.lastIndexOf(6.9));
		assertEquals(3, list.lastIndexOf(5.5));

		list.add(9.8);
		list.add(1.0);
		list.add(3.6);
		list.add(9.8);
		assertEquals(7, list.lastIndexOf(5.5));
		assertEquals(2, list.lastIndexOf(1.0));
		assertEquals(1, list.lastIndexOf(3.6));
		assertEquals(3, list.lastIndexOf(9.8));
		assertEquals(-1, list.lastIndexOf(9.2));
		assertEquals(-1, list.lastIndexOf(1.8));

		list.remove();
		assertEquals(2, list.lastIndexOf(9.8));
		assertEquals(-1, list.lastIndexOf(3.2));
		assertEquals(-1, list.lastIndexOf(5.8));
		assertEquals(6, list.lastIndexOf(5.5));

		list.remove();
		list.remove();
		assertEquals(3, list.lastIndexOf(6.9));
		assertEquals(4, list.lastIndexOf(5.5));
		assertEquals(-1, list.lastIndexOf(6.2));
		assertEquals(-1, list.lastIndexOf(4.8));
		assertEquals(-1, list.lastIndexOf(5.15));

		score += 10;
		result += "MyLinkedList:lastIndexOf(Double target) passed (10 marks)\n";
	}

	@Test(timeout = 500) // for debugging remove: (timeout=500)
	@Graded(description = "MyLinkedList:removeMiddleNode()", marks = 20)
	public void testRemoveMiddleNode() {
		MyLinkedList list = new MyLinkedList();

		list.add(5.5);
		list.add(2.3);
		list.add(6.9);
		Double res = list.removeMiddleNode();
		assertEquals(2.3, res, 0.01);
		assertEquals(6.9, list.get(0), 0.01);
		assertEquals(5.5, list.get(1), 0.01);

		list.add(1.5);
		list.add(3.7);
		list.add(7.8);
		list.add(9.5);
		list.removeMiddleNode();
		assertEquals(9.5, list.get(0), 0.01);
		assertEquals(7.8, list.get(1), 0.01);
		assertEquals(3.7, list.get(2), 0.01);
		assertEquals(6.9, list.get(3), 0.01);
		assertEquals(5.5, list.get(4), 0.01);

		list.removeMiddleNode();
		assertEquals(9.5, list.get(0), 0.01);
		assertEquals(7.8, list.get(1), 0.01);
		assertEquals(6.9, list.get(2), 0.01);
		assertEquals(5.5, list.get(3), 0.01);

		res = list.removeMiddleNode();
		assertEquals(6.9, res, 0.01);
		assertEquals(9.5, list.get(0), 0.01);
		assertEquals(7.8, list.get(1), 0.01);
		assertEquals(5.5, list.get(2), 0.01);

		list.removeMiddleNode();
		assertEquals(9.5, list.get(0), 0.01);
		assertEquals(5.5, list.get(1), 0.01);

		res = list.removeMiddleNode();
		assertEquals(5.5, res, 0.01);
		assertEquals(9.5, list.get(0), 0.01);

		list.removeMiddleNode();
		assertEquals(null, list.getHead());

		assertNull(null, list.removeMiddleNode());
		
		score += 20;
		result += "MyLinkedList:removeMiddleNode() passed (20 marks)\n";
	}

	@AfterClass
	public static void wrapUp() {
		System.out.println("Score = " + score);
		System.out.println(result);
	}
}
