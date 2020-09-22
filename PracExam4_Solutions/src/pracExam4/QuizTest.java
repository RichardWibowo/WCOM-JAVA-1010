package pracExam4;
//DO NOT MODIFY THIS FILE

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class QuizTest {
	private static int score = 0;
	private static String result = "";
	// core methods

	@Test(timeout = 500) // for debugging remove: (timeout=500)
	@Graded(description = "sumEvenDigits(int)", marks = 10)
	public void testsumEvenDigits() {
		assertEquals(10, Quiz.sumEvenDigits(31467));
		assertEquals(6, Quiz.sumEvenDigits(6));
		assertEquals(0, Quiz.sumEvenDigits(0));
		assertEquals(38, Quiz.sumEvenDigits(2686268));
		assertEquals(24, Quiz.sumEvenDigits(218672965));
		assertEquals(4, Quiz.sumEvenDigits(1133545));
		assertEquals(4, Quiz.sumEvenDigits(12211111));
		score += 10;
		result += "sumEvenDigits(int) passed (10 marks)\n";
	}

	@Test(timeout = 500) // for debugging remove: (timeout=500)
	@Graded(description = "switchCase(String)", marks = 15)
	public void testSwitchCase() {
		String s = Quiz.switchCase("abcde");
		assertTrue(s.equals("ABCDE"));

		s = Quiz.switchCase("aUeOdGjEi");
		assertTrue(s.equals("AuEoDgJeI"));

		s = Quiz.switchCase("123TeST");
		assertTrue(s.equals("123tEst"));

		s = Quiz.switchCase("TEst123");
		assertTrue(s.equals("teST123"));

		s = Quiz.switchCase("");
		assertTrue(s.equals(""));

		score += 15;
		result += "switchCase(String) passed (15 marks)\n";
	}

	@Test(timeout = 500) // for debugging remove: (timeout=500)
	@Graded(description = "numHMAS(ArrayList<Ship> ships)", marks = 10)
	public void testNumHMAS() {

		ArrayList<Ship> list = new ArrayList<Ship>();
		assertEquals(0, Quiz.numHMAS(list));

		list.add(new Ship(101, "HMAS test"));
		assertEquals(1, Quiz.numHMAS(list));

		list.add(new Ship(25, "s2"));
		assertEquals(1, Quiz.numHMAS(list));

		list.add(new Ship(250, "HMAS hello"));
		assertEquals(2, Quiz.numHMAS(list));

		list.add(new Ship(6, "HMA ship"));
		assertEquals(2, Quiz.numHMAS(list));

		list.add(new Ship(45, "ship HMAS"));
		assertEquals(2, Quiz.numHMAS(list));

		list.add(new Ship(105, "shHMASip"));
		assertEquals(2, Quiz.numHMAS(list));

		list.add(new Ship(10, "HMASship"));
		assertEquals(3, Quiz.numHMAS(list));

		list.remove(1);
		assertEquals(3, Quiz.numHMAS(list));

		list.add(new Ship(10, "hmas ship"));
		assertEquals(3, Quiz.numHMAS(list));

		score += 10;
		result += "numHMAS(ArrayList<Ship> ships) passed (10 marks)\n";
	}

	@Test(timeout = 500) // for debugging remove: (timeout=500)
	@Graded(description = "timesPrevious(ArrayList<Integer>)", marks = 10)
	public void testTimesPrevious() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();

		list.add(12);
		ans.add(12);
		Quiz.timesPrevious(list);
		assertEquals(ans, list);

		list = new ArrayList<Integer>();
		ans = new ArrayList<Integer>();
		list.add(12);
		list.add(5);
		ans.add(12);
		ans.add(60);
		Quiz.timesPrevious(list);
		assertEquals(ans, list);

		ans = new ArrayList<Integer>();
		list = new ArrayList<Integer>();
		Random r = new Random();
		int p = 1;
		int n = 1;

		for (int i = 0; i < 10; i++) {
			n = r.nextInt(50);

			list.add(n);
			ans.add(p * n);

			p = n;
		}
		Quiz.timesPrevious(list);
		assertEquals(ans, list);

		score += 10;
		result += "timesPrevious(ArrayList<Integer>) passed (10 marks)\n";

	}

	@Test(timeout = 500) // for debugging remove: (timeout=500)
	@Graded(description = "shipNamesLargerThan(LinkedList<Ship> ships, Ship target)", marks = 10)
	public void testShipsLargerThan() {
		LinkedList<Ship> list = new LinkedList<Ship>();
		Ship s = new Ship(150, "HMAS Percy");

		assertEquals(0, Quiz.shipNamesLargerThan(list, s));

		list.add(new Ship(200, "HMAS not"));
		list.add(new Ship(400, "HMAS long enough"));
		list.add(new Ship(100, "Long ship name"));
		list.add(new Ship(10, "Short"));

		assertEquals(2, Quiz.shipNamesLargerThan(list, s));

		s.setName("HMAS");
		assertEquals(4, Quiz.shipNamesLargerThan(list, s));

		s.setName("Shorter");
		assertEquals(3, Quiz.shipNamesLargerThan(list, s));

		s.setName("Long ships");
		assertEquals(2, Quiz.shipNamesLargerThan(list, s));

		s.setName("HMAS tooooo long");
		assertEquals(0, Quiz.shipNamesLargerThan(list, s));

		score += 10;
		result += "shipsLargerThan(LinkedList<Ship> ships, Ship target) passed (10 marks)\n";

	}

	@Test(timeout = 500) // for debugging remove: (timeout=500)
	@Graded(description = "findShips(ArrayList<Ship> ships, int minSize, String str)", marks = 15)
	public void testFindShips() {
		ArrayList<Ship> list = new ArrayList<Ship>();
		ArrayList<Ship> ans = new ArrayList<Ship>();

		assertEquals(ans, Quiz.findShips(list, 100, "Jeff"));

		list.add(new Ship(200, "HMAS Jeff"));
		list.add(new Ship(400, "HMAS Jeffery"));
		list.add(new Ship(900, "HMAS Oscar"));
		list.add(new Ship(1000, "Shippercar"));
		list.add(new Ship(400, "HMAS Open"));
		list.add(new Ship(10, "Jeff"));
		list.add(new Ship(60, "Jeff HMAS"));

		ans.add(new Ship(200, "HMAS Jeff"));
		ans.add(new Ship(400, "HMAS Jeffery"));
		ans.add(new Ship(10, "Jeff"));
		ans.add(new Ship(60, "Jeff HMAS"));
		assertEquals(ans, Quiz.findShips(list, 1, "Jeff"));

		ans = new ArrayList<Ship>();
		ans.add(new Ship(400, "HMAS Jeff"));
		assertEquals(ans, Quiz.findShips(list, 302, "Jeff"));

		ans = new ArrayList<Ship>();
		ans.add(new Ship(900, "HMAS Oscar"));
		ans.add(new Ship(1000, "Shippercar"));
		assertEquals(ans, Quiz.findShips(list, 5, "car"));

		ans = new ArrayList<Ship>();
		ans.add(new Ship(200, "HMAS Jeff"));
		ans.add(new Ship(400, "HMAS Jeffery"));
		ans.add(new Ship(900, "HMAS Oscar"));
		ans.add(new Ship(400, "HMAS Open"));
		ans.add(new Ship(60, "Jeff HMAS"));
		assertEquals(ans, Quiz.findShips(list, 15, "HMAS"));

		ans = new ArrayList<Ship>();
		ans.add(new Ship(400, "HMAS Jeffery"));
		ans.add(new Ship(900, "HMAS Oscar"));
		ans.add(new Ship(400, "HMAS Open"));
		assertEquals(ans, Quiz.findShips(list, 220, "HMAS"));

		score += 15;
		result += "findShips(ArrayList<Ship> ships, int minSize, String str) passed (15 marks)\n";

	}

	@Test(timeout = 500) // for debugging remove: (timeout=500)
	@Graded(description = "MyLinkedList:set(int idx,Double data)", marks = 10)
	public void testMyLinkedListSet() {
		MyLinkedList list = new MyLinkedList();

		list.add(5.5);
		list.add(6.9);
		list.set(1, 2.3);
		assertEquals(2.3, list.get(1), 0.01);

		list.add(9.8);
		list.add(1.0);
		list.add(3.6);

		list.set(2, 1.5);
		assertEquals(1.5, list.get(2), 0.01);

		list.remove();
		list.remove();
		list.set(0, 8.8);
		assertEquals(8.8, list.get(0), 0.01);

		score += 10;
		result += "MyLinkedList:set(int idx,Double data) passed (10 marks)\n";
	}

	@Test(timeout = 500) // for debugging remove: (timeout=500)
	@Graded(description = "MyLinkedList:removeFromLast(int n)", marks = 20)
	public void testRemoveFromLast() {
		MyLinkedList list = new MyLinkedList();
		Double val = list.removeFromLast(3);
		assertNull(val);
		list.add(5.5);
		list.add(2.3);
		list.add(6.9);
		list.add(-12.5);
		list.add(7.4);
		val = list.removeFromLast(3);
		assertEquals(6.9, val, 0.01);
		assertEquals(-12.5, list.get(1), 0.01);
		assertEquals(2.3, list.get(2), 0.01);
		assertEquals(5.5, list.get(3), 0.01);

		list.add(9.8);
		list.add(1.3);
		list.add(3.6);
		val = list.removeFromLast(2);
		assertEquals(2.3, val, 0.01);
		assertEquals(-12.5, list.get(4), 0.01);
		assertEquals(5.5, list.get(5), 0.01);
		
		val = list.removeFromLast(5);
		assertEquals(1.3, val, 0.01);
		assertEquals(3.6, list.get(0), 0.01);
		assertEquals(9.8, list.get(1), 0.01);

		score += 20;
		result += "MyLinkedList:removeFromLast(int n) passed (20 marks)\n";
	}

	@AfterClass
	public static void wrapUp(){
		System.out.println("Score = " + score);
		System.out.println(result);
	}
}
