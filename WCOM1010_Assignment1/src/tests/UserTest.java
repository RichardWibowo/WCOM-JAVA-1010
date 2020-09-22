package tests;


import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import questions.User;

class UserTest {
	private static int score = 0;

	@Test
	void testSetTurbo() {
		User u = new User();

		u.setTurbo(true);
		assertTrue(u.isTurbo());

		u.setTurbo(false);
		assertTrue(!u.isTurbo());

		score+=2;
	}

	@Test
	void testSetUsername() {
		User u = new User();
		
		u.setUsername("");
		assertEquals("Discordian", u.getUsername());

		u.setUsername("happy");
		assertEquals("Happy", u.getUsername());
		
		u.setUsername("Jolly");
		assertEquals("Jolly", u.getUsername());

		score+=4;
	}

	@Test
	void testSetPassword() {
		User u = new User();
		
		u.setPassword("Weakpassword");	
		assertTrue(u.checkPassword("Weakpassword"));
		
		u.setPassword("badpassword");	
		assertTrue(u.checkPassword("badpassword!1!"));
		
		u.setPassword("");	


		score+=4;
	}

	@Test
	void testSetEmail() {
		User u = new User();
		
		u.setEmail("wrong.com");	
		assertEquals("discordian@discord.com",u.getEmail());
		
		u.setEmail("good@email.com");	
		assertEquals("good@email.com",u.getEmail());
		
		u.setEmail("CApital@MQ.edu.AU");	
		assertEquals("capital@mq.edu.au",u.getEmail());
		
		u.setEmail("");	
		assertEquals("discordian@discord.com",u.getEmail());

		score+=4;
	}

	@Test
	void testUser() {
		User u = new User("","","",true);
		
		assertTrue(u.isTurbo());
		assertEquals("Discordian", u.getUsername());
		assertTrue(u.checkPassword("!1!"));
		assertEquals("discordian@discord.com",u.getEmail());
		
		u = new User("happy","wrong.com","Weakpassword",false);
		assertTrue(!u.isTurbo());
		assertEquals("Happy", u.getUsername());
		assertEquals("discordian@discord.com",u.getEmail());
		assertTrue(u.checkPassword("Weakpassword"));
		
		u = new User("Jolly","good@email.com","badpassword",false);
		assertTrue(!u.isTurbo());
		assertEquals("Jolly", u.getUsername());
		assertEquals("good@email.com",u.getEmail());
		assertTrue(u.checkPassword("badpassword!1!"));
		
		u = new User("","CApital@MQ.edu.AU","",true);
		assertEquals("capital@mq.edu.au",u.getEmail());
		
		score+=2;
	}

	@Test
	void testEquals() {
		User u = new User("happy","wrong.com","Weakpassword",false);
		User b = new User("Jolly","good@email.com","badpassword",false);
		
		assertTrue(!u.equals(b));
		assertTrue(!b.equals(u));
		
		b = new User("happy","wrong.com","Weakpassword",false);
		
		assertTrue(u.equals(b));
		assertTrue(b.equals(u));
		
		u = new User("happy","wrong.com","Weakpassword",true);
		
		assertTrue(!u.equals(b));
		assertTrue(!b.equals(u));
		
		u = new User("happy","wrong.com","Weakpasswordz",false);
		
		assertTrue(!u.equals(b));
		assertTrue(!b.equals(u));
		
		u = new User("happy","wrong@email.com","Weakpassword",false);
		
		assertTrue(!u.equals(b));
		assertTrue(!b.equals(u));
		
		u = new User("other","wrong.com","Weakpassword",false);
		
		assertTrue(!u.equals(b));
		assertTrue(!b.equals(u));
		
		score+=2;
	}

	@Test
	void testToString() {
		User u = new User("KennyS","kennys@gamers.com","Passwordy",true);
		
		assertEquals("Username: KennyS, Email: kennys@gamers.com, turbo: true",u.toString());
		
		u = new User("Jeff","jeffy@jeff.com","zzzzz",false);
		
		assertEquals("Username: Jeff, Email: jeffy@jeff.com, turbo: false",u.toString());
		
		score+=2;
	}

	@AfterAll
	public static void wrapUp() throws IOException {
		System.out.println("Score = "+score+" (out of 20)");
	}
}
