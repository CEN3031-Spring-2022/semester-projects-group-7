package tests;

import javascryption.*;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class CardJUnitTest {

	@Test
	void testDefaultConstructor() {
		Card obj = new Card();
		assert(obj.getName() == "Not Assigned");
	}
	
	@Test
	void testFileReadAndSet() {
		Card obj = new Card();
		
		obj.makeCard(1);
		assertEquals(obj.getName(), "Stoat");
		assertEquals(obj.getBlood(), 1);
		assertEquals(obj.getHealth(), 2);
		assertEquals(obj.getAttack(), 1);
	}
	
	@Test
	void testFileReadAndResetWithNewID() {
		Card obj = new Card();
		
		obj.makeCard(1);
		
		obj.makeCard(0);
		assertEquals(obj.getName(), "Squirrel");
		assertEquals(obj.getBlood(), 0);
		assertEquals(obj.getHealth(), 1);
		assertEquals(obj.getAttack(), 0);
	}

}
