//DO NOT MODIFY THIS FILE

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class QuizTest {
	private static int score = 0;
	private static String result = "";
	//core methods

	@Test @Graded(description="countEvenDigits(int)", marks=10)
	public void testCountEvenDigits() {
		assertEquals(2, Quiz.countEvenDigits(31467));
		assertEquals(0, Quiz.countEvenDigits(9));
		assertEquals(0, Quiz.countEvenDigits(0));
		assertEquals(7, Quiz.countEvenDigits(2686268));
		assertEquals(5, Quiz.countEvenDigits(218672965));
		assertEquals(6, Quiz.countEvenDigits(222444));
		assertEquals(0, Quiz.countEvenDigits(1111111111));
		score+=10;
		result+="countEvenDigits(int) passed (10 marks)\n";
	}


	@Test @Graded(description="alternateCase(String)", marks=15)
	public void testAlternateCase() {
		String s = Quiz.alternateCase("ghDfhThrh");
		assertTrue(s.equals("GhDfHtHrH")||s.equals("gHdFhThRh"));
		
		s = Quiz.alternateCase("hey2thrEe6eigHt");
		assertTrue(s.equals("HeY2ThReE6EiGhT")||s.equals("hEy2tHrEe6eIgHt"));
		
		s = Quiz.alternateCase("123TeST");
		assertTrue(s.equals("123tEsT")||s.equals("123TeSt"));
		
		s = Quiz.alternateCase("TEst123");
		assertTrue(s.equals("tEsT123")||s.equals("TeSt123"));
		
		s = Quiz.alternateCase("");
		assertTrue(s.equals(""));
		
		score+=15;
		result+="alternateCase(String) passed (15 marks)\n";
	}

	@Test @Graded(description="totalCrewSize(ArrayList<Ship>)", marks=10)
	public void testTotalCrewSize() {
		
		ArrayList<Ship> list = new ArrayList<Ship>();
		assertEquals(0, Quiz.totalCrewSize(list));
		
		list.add(new Ship(101,"s1"));
		assertEquals(101, Quiz.totalCrewSize(list));
		
		list.add(new Ship(25,"s2"));
		assertEquals(101+25, Quiz.totalCrewSize(list));
		
		list.add(new Ship(250,"s2"));
		assertEquals(101+25+250, Quiz.totalCrewSize(list));
		
		list.add(new Ship(-10,"s2"));
		assertEquals(101+25+250, Quiz.totalCrewSize(list));
		
		list.remove(1);
		assertEquals(101+250, Quiz.totalCrewSize(list));
		
		score+=10;
		result+="totalCrewSize(ArrayList<Ship>) passed (10 marks)\n";
	}
	
	@Test @Graded(description="addPrevious(ArrayList<Integer>)", marks=10)
	public void testAddPrevious() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		list.add(12);
		ans.add(12);
		Quiz.addPrevious(list);
		assertEquals(ans,list);
		
		list = new ArrayList<Integer>();
		ans = new ArrayList<Integer>();
		list.add(12);
		list.add(5);
		ans.add(12);
		ans.add(17);
		Quiz.addPrevious(list);
		assertEquals(ans,list);
		
		ans = new ArrayList<Integer>();
		list = new ArrayList<Integer>();
		Random r = new Random();
		int p = 0;
		int n = 0;
		
		for(int i = 0;i<10;i++) {
			n = r.nextInt(50);
			
			list.add(n);
			ans.add(p+n);
			
			p = n;
		}
		Quiz.addPrevious(list);
		assertEquals(ans,list);
		
		score+=10;
		result+="addPrevious(ArrayList<Integer>) passed (10 marks)\n";

	}
	
	@Test @Graded(description="shipsLargerThan(LinkedList<Ship> ships, Ship target)", marks=10)
	public void testShipsLargerThan() {
		LinkedList<Ship> list = new LinkedList<Ship>();
		Ship s = new Ship(150,"s1");
		
		assertEquals(0,Quiz.shipsLargerThan(list,s));
		
		list.add(new Ship(200,"t2"));
		list.add(new Ship(400,"t2"));
		list.add(new Ship(100,"t2"));
		list.add(new Ship(10,"t2"));
		
		assertEquals(2,Quiz.shipsLargerThan(list,s));
		
		s.setCrewSize(500);
		assertEquals(0,Quiz.shipsLargerThan(list,s));
		
		s.setCrewSize(1);
		assertEquals(4,Quiz.shipsLargerThan(list,s));
		
		s.setCrewSize(20);
		assertEquals(3,Quiz.shipsLargerThan(list,s));
		
		s.setCrewSize(10);
		assertEquals(3,Quiz.shipsLargerThan(list,s));
		
		score+=10;
		result+="shipsLargerThan(LinkedList<Ship> ships, Ship target) passed (10 marks)\n";
		
	}
	
	@Test @Graded(description="findShips(ArrayList<Ship> ls, int minSize, int maxSize) ", marks=15)
	public void testFindShips() {
		ArrayList<Ship> list = new ArrayList<Ship>();
		ArrayList<Ship> ans = new ArrayList<Ship>();
		
		assertEquals(ans,Quiz.findShips(list,1,2));
		
		list.add(new Ship(200,"t2"));
		list.add(new Ship(400,"t2"));
		list.add(new Ship(900,"t2"));
		list.add(new Ship(1000,"t2"));
		list.add(new Ship(400,"t2"));
		list.add(new Ship(500,"t2"));
		list.add(new Ship(100,"t2"));
		list.add(new Ship(10,"t2"));
		
		ans.add(new Ship(900,"t2"));
		ans.add(new Ship(1000,"t2"));
		ans.add(new Ship(500,"t2"));
		assertEquals(ans,Quiz.findShips(list,500,2000));
		
		ans = new ArrayList<Ship>();
		ans.add(new Ship(100,"t2"));
		ans.add(new Ship(10,"t2"));
		assertEquals(ans,Quiz.findShips(list,5,100));
		
		ans = new ArrayList<Ship>();
		ans.add(new Ship(200,"t2"));
		ans.add(new Ship(400,"t2"));
		ans.add(new Ship(400,"t2"));
		ans.add(new Ship(100,"t2"));
		assertEquals(ans,Quiz.findShips(list,15,440));
		
		score+=15;
		result+="findShips(ArrayList<Ship> ls, int minSize, int maxSize) passed (15 marks)\n";
		
	}
	
	@Test @Graded(description="MyLinkedList:size()", marks=10)
	public void testMyLinkedListSize() {
		MyLinkedList list = new MyLinkedList();
		assertEquals(0, list.size());
		
		
		list.add(5.5);
		list.add(6.9);
		assertEquals(2, list.size());
		
		list.add(9.8);
		list.add(1.0);
		list.add(3.6);
		assertEquals(5, list.size());
		list.remove();
		assertEquals(4, list.size());
		
		list.remove();
		list.remove();
		list.remove();
		list.remove();
		assertEquals(0, list.size());
		
		score+=10;
		result+="MyLinkedList:size() passed (10 marks)\n";
	}
	
	@Test @Graded(description="MyLinkedList:removeAtIndex(int i) ", marks=20)
	public void testRemoveAt() {
		MyLinkedList list = new MyLinkedList();

		list.add(5.5);
		list.add(2.3);
		list.add(6.9);
		assertEquals(2.3, list.removeAtIndex(1),0.01);
		assertEquals(6.9, list.get(0),0.01);
		assertEquals(5.5, list.get(1),0.01);
		
		list.add(9.8);
		list.add(1.0);
		list.add(3.6);
		assertEquals(6.9, list.removeAtIndex(3),0.01);
		assertEquals(3.6, list.get(0),0.01);
		assertEquals(1.0, list.get(1),0.01);
		assertEquals(9.8, list.get(2),0.01);
		assertEquals(5.5, list.get(3),0.01);
		
		list.remove();

		assertEquals(1.0, list.removeAtIndex(0),0.01);
		assertEquals(9.8, list.get(0),0.01);
		assertEquals(5.5, list.get(1),0.01);
		
		score+=20;
		result+="MyLinkedList:removeAtIndex(int i) passed (20 marks)\n";
	}
	
	@AfterClass
	public static void wrapUp() {
	System.out.println("Score = "+score);
		System.out.println(result);
	}
}
