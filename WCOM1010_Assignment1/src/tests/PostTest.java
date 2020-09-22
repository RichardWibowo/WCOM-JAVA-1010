package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import questions.Post;
import questions.User;

class PostTest {
	private static int score = 0;

	@Test
	void testSetPoster() {
		User u = new User("Happy","test@test.com","OkayPass",false);
		User b = new User("Jolly","good@email.com","LetMeIn",true);
		Post p = new Post();
		
		p.setPoster(u);
		
		assertTrue(p.getPoster()!=null);
		assertTrue(p.getPoster().equals(u));
		assertTrue(!p.getPoster().equals(b));
		
		p.setPoster(b);
		
		assertTrue(p.getPoster()!=null);
		assertTrue(p.getPoster().equals(b));
		assertTrue(!p.getPoster().equals(u));

		score+=2;
	}

	@Test
	void testSetMessage() {
		Post p = new Post();
		p.setMessage("12345ysdhbdfhe546uyetyjcfghnfghjr57iue4567ikdtgmfghnfgtyuje56");
		assertEquals("12345ysdhbdfhe546uyetyjcfghnfghjr57iue4567ikdtgmfg",p.getMessage());
		p.setMessage("");
		assertEquals("-",p.getMessage());
		score+=5;
	}

	@Test
	void testPost() {
		
		User u = new User("Happy","test@test.com","OkayPass",false);
		User b = new User("Jolly","good@email.com","LetMeIn",true);
		Post p = new Post(u,"");
		
		assertEquals("-",p.getMessage());
		assertTrue(p.getPoster()!=null);
		assertTrue(p.getPoster().equals(u));
		assertTrue(!p.getPoster().equals(b));
		assertTrue(p.getId()>=1000&&p.getId()<=9999);
		
		p = new Post(u,"12345ysdhbdfhe546uyetyjcfghnfghjr57iue4567ikdtgmfghnfgtyuje56");
		assertTrue(p.getId()>=1000&&p.getId()<=9999);
		assertEquals("12345ysdhbdfhe546uyetyjcfghnfghjr57iue4567ikdtgmfg",p.getMessage());

		score+=5;
	}

	@AfterAll
	public static void wrapUp() throws IOException {
		System.out.println("Score = "+score+" (out of 12)");
	}
}
