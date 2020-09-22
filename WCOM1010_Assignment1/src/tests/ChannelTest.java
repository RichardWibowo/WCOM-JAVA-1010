package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import questions.User;
import questions.Channel;
import questions.Post;

class ChannelTest {
	private Channel c1,c2;
	private static int score = 0;

	@BeforeEach
	void initialize() throws IOException {
		c1 = new Channel("channel1.txt");
		c2 = new Channel("channel2.txt");
	}
	
	@Test
	void testCountUsers(){
		assertEquals(6, c1.countUsers());
		assertEquals(3, c2.countUsers());
		score+=3;
	}

	@Test
	void testCountPosts() {
		User u = new User("KyLy","kyletime@battlenet.com","coD4345",false);
		assertEquals(4, c1.countPosts(u));
		assertEquals(0, c2.countPosts(u));
		
		u = new User("Voldex","voldyvoo@live.com","seahorS3",true);
		assertEquals(2, c1.countPosts(u));
		assertEquals(0, c2.countPosts(u));
		
		u = new User("Ricky","ricky@mq.com","noGood",false);
		assertEquals(3, c1.countPosts(u));
		assertEquals(3, c2.countPosts(u));
		score+=5;
	}

	@Test
	void testFindUser() {
		User u = c1.findUser("KyLy");
		assertNotNull(u);
		assertEquals("KyLy",u.getUsername());
		
		u = c1.findUser("Oh123");
		assertNotNull(u);
		assertEquals("Oh123",u.getUsername());
		
		u = c1.findUser("Jimmy");
		assertNotNull(u);
		assertEquals("Jimmy",u.getUsername());
		
		u = c2.findUser("Jimmy");
		assertNull(u);
		
		u = c2.findUser("Oh123");
		assertNotNull(u);
		assertEquals("Oh123",u.getUsername());
		
		u = c1.findUser("Walter");
		assertNull(u);
		
		score+=5;
	}

	@Test
	void testRemoveUser() {
		User u = new User("KyLy","kyletime@battlenet.com","coD4345",false);
		
		c1.removeUser(u);
		
		// Check user is removed from users array
		assertNull(c1.getUser(3));
		
		// Check Posts are removed
		assertNotNull(c1.getPost(5));
		assertNull(c1.getPost(6));
		assertNull(c1.getPost(7));
		assertNull(c1.getPost(8));
		assertNull(c1.getPost(9));
		assertNotNull(c1.getPost(10));
		
		u = new User("Oh123","oh_123@hotmail.com","silLLy!",false);
		
		c1.removeUser(u);
		
		// Check user is removed from users array
		assertNull(c1.getUser(2));
		assertNotNull(c1.getUser(1));
		assertNotNull(c1.getUser(4));
		
		// Check Posts are removed
		assertNull(c1.getPost(5));
		assertNotNull(c1.getPost(4));
		assertNotNull(c1.getPost(10));
		
		c2.removeUser(u);
		
		// Check user is removed from users array
		assertNotNull(c2.getUser(0));
		assertNotNull(c2.getUser(1));
		assertNull(c2.getUser(2));
		
		// Check Posts are removed
		assertNotNull(c1.getPost(4));
		assertNull(c2.getPost(5));
		
		score+=5;
	}

	@Test
	void testSearchPosts() {
		
		Post[] results = c1.searchPosts("time");
		assertEquals(3,results.length);
		
		assertEquals("yea what time?",results[0].getMessage());
		assertEquals("cod time",results[1].getMessage());
		assertEquals("prime time video",results[2].getMessage());
		
		results = c2.searchPosts("i");
		assertEquals(2,results.length);
		
		assertEquals("you forgot to write int",results[0].getMessage());
		assertEquals("hey whats wrong with my code x = 10",results[1].getMessage());
		
		results = c2.searchPosts("zeta");
		assertEquals(0,results.length);
		
		score+=10;
	}

	@Test
	void testGetTurbo() {
		
		User[] turbos = c1.getTurbo();
		assertEquals(3,turbos.length);
		
		assertEquals("Daniel",turbos[0].getUsername());
		assertEquals("Voldex",turbos[1].getUsername());
		assertEquals("Jimmy",turbos[2].getUsername());
		
		turbos = c2.getTurbo();
		assertEquals(1,turbos.length);
		assertEquals("Daniel",turbos[0].getUsername());
		
		score+=10;
	}

	@Test
	void testgetUserWithMostPosts() throws IOException {
		c1 = new Channel("channel1.txt");
		c2 = new Channel("channel2.txt");
		assertEquals("KyLy",c1.getUserWithMostPosts().getUsername());
		assertEquals("Ricky",c2.getUserWithMostPosts().getUsername());
		score+=10;
	}

	@Test
	void testContains() {
		User a = new User("KyLy","kyletime@battlenet.com","coD4345",false);
		User b = new User("Voldex","voldyvoo@live.com","seahorS3",true);
		User c = new User("Ricky","ricky@mq.com","noGood",false);
		User d = new User("Random","teacher@mq.com","secreT",false);
		
		User[] test1 = {a,b,c};
		assertTrue(c1.contains(test1));
		assertFalse(c2.contains(test1));
		
		User[] test2 = {c};
		assertTrue(c1.contains(test2));
		assertTrue(c2.contains(test2));
		
		User[] test3 = {d};
		assertFalse(c1.contains(test3));
		assertFalse(c2.contains(test3));
		
		score+=10;
	}

	@AfterAll
	public static void wrapUp() throws IOException {
		System.out.println("Score = "+score+" (out of 58)");
	}
}
