package myFirstJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RevisionTest {

	@Test
	void testTimes() {
		assertEquals(6,Revision.times(0, 3));
		//assertEquals(4,Revision.times(2, 2));
		
	}

}



