package javascryption;

import org.junit.jupiter.api.*;
import static org.junit.Assert.assertEquals;

public class PlayerTester {
	// TODO: check players deck to make sure it is correctly assigned
	// TODO: check players hand with at construction (shouls be empty)

	@Test
	void damagePlayer() {
		Player sut = new Player();
		int damageBefore =  sut.getPlayerHP();
		
		sut.takeDamage(5);
		
		assertEquals(damageBefore - 5, sut.getPlayerHP());
		
	}
	
	@Test
	void drawingCardFromPlayerObject() {
		Deck deck = new Deck();
		
		Card wolf = new Card("Wolf", 1, 2, 3);
		Card badger = new Card("Badger", 1, 2, 3);
		Card bee = new Card("Bee", 1, 2, 3);
		
		deck.addCard(wolf);
		deck.addCard(badger);
		deck.addCard(bee);
		
		Player sut = new Player();
		sut.setDeck(deck);
		
		Card topDeck = sut.getPlayerDeck().getCardByPosition(0);
		
		sut.drawCard();
		
		assertEquals(topDeck, sut.getHand().getCardByPos(0));
	}
	
}
