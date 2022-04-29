package tests;

import javascryption.*;
import org.junit.jupiter.api.*;
import static org.junit.Assert.assertEquals;

public class HandTester {
	
	@Test
	void testDefaultConstructorToSeeIfEmpty() {
		Hand obj = new Hand();
		assert(obj.getHand().isEmpty() == true);
	}
	
	@Test
	void testGetCardByPosition() {
		Hand sut = new Hand();
		Card wolf = new Card("Wolf", 1, 2, 3);

		sut.addCardToHand(wolf);
		
		assertEquals(wolf, sut.getCardByPos(0));
	}
	
	@Test
	void removeCardByPosition() {
		Hand sut = new Hand();
		Card wolf = new Card("Wolf", 1, 2, 3);
		Card badger = new Card("Badger", 0, 0, 0);
		
		sut.addCardToHand(badger);
		sut.addCardToHand(wolf);
		
		sut.removeCardbyPosition(0);
		
		assertEquals(wolf, sut.getCardByPos(0));
	}
	
}
