package pracExam3;
//DO NOT MODIFY THIS FILE

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class QuizTest {
	private static int score = 0;
	private static String result = "";
	//core methods

	@Test @Graded(description="countOddDigits(int)", marks=10)
	public void testCountOddDigits() {
		assertEquals(3, Quiz.countOddDigits(31467));
		assertEquals(1, Quiz.countOddDigits(9));
		assertEquals(0, Quiz.countOddDigits(0));
		assertEquals(0, Quiz.countOddDigits(2686268));
		assertEquals(4, Quiz.countOddDigits(218672965));
		assertEquals(6, Quiz.countOddDigits(113355));
		assertEquals(10, Quiz.countOddDigits(1111111111));
		score+=10;
		result+="countOddDigits(int) passed (10 marks)\n";
	}


	@Test @Graded(description="removeUpperCase(String)", marks=15)
	public void testRemoveUpperCase() {
		
		assertEquals("hftr",Quiz.removeUpperCase("GhDfHtHrH"));
		assertEquals("gdhhh",Quiz.removeUpperCase("gHdFhThRh"));
		assertEquals("enhenih",Quiz.removeUpperCase("HeYnThReEnEiGhT"));
		assertEquals("et",Quiz.removeUpperCase("TeSt"));
		assertEquals("",Quiz.removeUpperCase("A"));
		assertEquals("a",Quiz.removeUpperCase("a"));
		assertEquals("",Quiz.removeUpperCase(""));
		assertEquals("acne",Quiz.removeUpperCase("aBcnDe"));
		assertEquals("foijwios",Quiz.removeUpperCase("OIDJfoijwiosIDJF"));
		assertEquals("hge",Quiz.removeUpperCase("hge"));
		assertEquals("ig",Quiz.removeUpperCase("HiDEgE"));
		score+=15;
		result+="removeUpperCase(String) passed (15 marks)\n";
	}

	@Test @Graded(description="totalCarSeats(ArrayList<Car>)", marks=10)
	public void testTotalSeats() {
		
		ArrayList<Car> list = new ArrayList<Car>();
		assertEquals(0, Quiz.totalCarSeats(list));
		
		list.add(new Car(101,"s1"));
		assertEquals(101, Quiz.totalCarSeats(list));
		
		list.add(new Car(25,"s2"));
		assertEquals(101+25, Quiz.totalCarSeats(list));
		
		list.add(new Car(250,"s2"));
		assertEquals(101+25+250, Quiz.totalCarSeats(list));
		
		list.add(new Car(-10,"s2"));
		assertEquals(101+25+250, Quiz.totalCarSeats(list));
		
		list.remove(1);
		assertEquals(101+250, Quiz.totalCarSeats(list));
		
		score+=10;
		result+="totalCarSeats(ArrayList<Car>) passed (10 marks)\n";
	}
	
	@Test @Graded(description="addNext(ArrayList<Integer>)", marks=10)
	public void testAddNext() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		list.add(12);
		ans.add(12);
		Quiz.addNext(list);
		assertEquals(ans,list);
		
		list = new ArrayList<Integer>();
		ans = new ArrayList<Integer>();
		list.add(12);
		list.add(5);
		ans.add(17);
		ans.add(5);
		Quiz.addNext(list);
		assertEquals(ans,list);
		
		ans = new ArrayList<Integer>();
		list = new ArrayList<Integer>();
		Random r = new Random();
		int p = r.nextInt(20);
		int n = r.nextInt(20);
		
		int end = 5+r.nextInt(10);
		
		for(int i = 0;i<=end;i++) {
			list.add(p);
			if(i==end) {
				ans.add(p);
			}else {
				ans.add(p+n);
			}
			
			p=n;
			n = r.nextInt(20);
		}
		Quiz.addNext(list);
		assertEquals(ans,list);
		
		score+=10;
		result+="addNext(ArrayList<Integer>) passed (10 marks)\n";

	}
	
	@Test @Graded(description="carsLargerThan(LinkedList<Car> cars, Car target)", marks=10)
	public void testCarsLargerThan() {
		LinkedList<Car> list = new LinkedList<Car>();
		Car s = new Car(150,"s1");
		
		assertEquals(0,Quiz.carsLargerThan(list,s));
		
		list.add(new Car(200,"t2"));
		list.add(new Car(400,"t2"));
		list.add(new Car(100,"t2"));
		list.add(new Car(10,"t2"));
		
		assertEquals(2,Quiz.carsLargerThan(list,s));
		
		s.setNumSeats(500);
		assertEquals(0,Quiz.carsLargerThan(list,s));
		
		s.setNumSeats(1);
		assertEquals(4,Quiz.carsLargerThan(list,s));
		
		s.setNumSeats(20);
		assertEquals(3,Quiz.carsLargerThan(list,s));
		
		s.setNumSeats(10);
		assertEquals(3,Quiz.carsLargerThan(list,s));
		
		score+=10;
		result+="carsLargerThan(LinkedList<Car> cars, Car target) passed (10 marks)\n";
		
	}
	
	@Test @Graded(description="findCars(ArrayList<Car> cars, int minSize, int maxSize) ", marks=15)
	public void testFindCars() {
		ArrayList<Car> list = new ArrayList<Car>();
		ArrayList<Car> ans = new ArrayList<Car>();
		
		assertEquals(ans,Quiz.findCars(list,1,2));
		
		list.add(new Car(200,"t2"));
		list.add(new Car(400,"t2"));
		list.add(new Car(900,"t2"));
		list.add(new Car(1000,"t2"));
		list.add(new Car(400,"t2"));
		list.add(new Car(500,"t2"));
		list.add(new Car(100,"t2"));
		list.add(new Car(10,"t2"));
		
		ans.add(new Car(900,"t2"));
		ans.add(new Car(1000,"t2"));
		ans.add(new Car(500,"t2"));
		assertEquals(ans,Quiz.findCars(list,500,2000));
		
		ans = new ArrayList<Car>();
		ans.add(new Car(100,"t2"));
		ans.add(new Car(10,"t2"));
		assertEquals(ans,Quiz.findCars(list,5,100));
		
		ans = new ArrayList<Car>();
		ans.add(new Car(200,"t2"));
		ans.add(new Car(400,"t2"));
		ans.add(new Car(400,"t2"));
		ans.add(new Car(100,"t2"));
		assertEquals(ans,Quiz.findCars(list,15,440));
		
		score+=15;
		result+="findCars(ArrayList<Car> cars, int minSize, int maxSize) passed (15 marks)\n";
		
	}
	
	@Test @Graded(description="MyLinkedList:indexOf(Character)", marks=10)
	public void testMyLinkedIndexOf() {
		MyLinkedList list = new MyLinkedList();
		assertEquals(-1, list.indexOf('h'));
		
		list.add('f');
		list.add('s');
		assertEquals(0, list.indexOf('s'));
		assertEquals(1, list.indexOf('f'));
		
		list.add('n');
		list.add('o');
		list.add('h');
		assertEquals(1, list.indexOf('o'));
		assertEquals(0, list.indexOf('h'));
		assertEquals(2, list.indexOf('n'));
		assertEquals(-1, list.indexOf('m'));
		assertEquals(-1, list.indexOf('p'));
		
		list.remove();
		assertEquals(2, list.indexOf('s'));
		assertEquals(-1, list.indexOf('h'));
		assertEquals(-1, list.indexOf('q'));
		
		list.remove();
		list.remove();
		assertEquals(0, list.indexOf('s'));
		assertEquals(1, list.indexOf('f'));
		assertEquals(-1, list.indexOf('z'));
		assertEquals(-1, list.indexOf('h'));
		
		score+=10;
		result+="MyLinkedList:indexOf(Character) passed (10 marks)\n";
	}
	
	@Test @Graded(description="MyLinkedList:addAtIndex(int, Character) ", marks=20)
	public void testAddAt() {
		MyLinkedList list = new MyLinkedList();

		list.add('f');
		list.add('h');
		list.add('s');
		list.addAtIndex(1,'t');
		assertEquals('s', list.get(0));
		assertEquals('t', list.get(1));
		assertEquals('h', list.get(2));
		assertEquals('f', list.get(3));
		
		list.addAtIndex(0,'o');
		assertEquals('o', list.get(0));
		assertEquals('s', list.get(1));
		assertEquals('t', list.get(2));
		assertEquals('h', list.get(3));
		assertEquals('f', list.get(4));
		
		list.addAtIndex(4,'v');
		assertEquals('o', list.get(0));
		assertEquals('s', list.get(1));
		assertEquals('t', list.get(2));
		assertEquals('h', list.get(3));
		assertEquals('v', list.get(4));
		assertEquals('f', list.get(5));
		
		score+=20;
		result+="MyLinkedList:addAtIndex(int, Character) passed (20 marks)\n";
	}
	
	@AfterClass
	public static void wrapUp() throws IOException {
	System.out.println("Score = "+score);
		System.out.println(result);
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());
		File file = new File("report"+timeStamp+".txt");
		FileWriter writer = new FileWriter(file);
		writer.write("Score = "+score+"\n");
		writer.write(result+"\n");
		writer.flush();
		writer.close();
	}
}
