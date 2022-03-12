package javascryption;

import org.junit.jupiter.api.*;
import static org.junit.Assert.assertEquals;

public class HandTester {
	
	@Test
	void testDefaultConstructorToSeeIfEmpty() {
		Hand obj = new Hand();
		assert(obj.getHand().isEmpty() == true);
	}
	
	@Test
	void testReturnHand() {
		Deck sampleDeck = new Deck();		
		Card wolf = new Card("Wolf", 1, 2, 3);
		Card badger = new Card("Badger", 1, 2, 3);
		Card bee = new Card("Bee", 1, 2, 3);		
		sampleDeck.addCard(wolf);
		sampleDeck.addCard(badger);
		sampleDeck.addCard(bee);		
		Hand sut = new Hand();
		
		sut.setHand(sampleDeck.getDeck());
		
		assertEquals(sampleDeck.getDeck(), sut.getHand());	
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
