package javascryption;

import java.util.ArrayList;
import org.junit.jupiter.api.*;
import static org.junit.Assert.assertEquals;

public class DeckTester {
	
	@Test
	void addingCardstoDeck() {
		Deck sut = new Deck();
		
		Card wolf = new Card("Wolf", 1, 2, 3);
		Card badger = new Card("Badger", 1, 2, 3);
		Card bee = new Card("Bee", 1, 2, 3);
		
		sut.addCard(wolf);
		sut.addCard(badger);
		sut.addCard(bee);		
	}
	
	@Test
	void checkingSizeOfDeck() {
		Deck sut = new Deck();
		
		Card wolf = new Card("Wolf", 1, 2, 3);
		Card badger = new Card("Badger", 1, 2, 3);
		Card bee = new Card("Bee", 1, 2, 3);
		
		sut.addCard(wolf);
		sut.addCard(badger);
		sut.addCard(bee);
		
		assertEquals(sut.getSize(), 3);
	}
	
	@Test
	void testingParameterizedConstructor() {
		Card wolf = new Card("Wolf", 1, 2, 3);

		ArrayList<Card> sampleList = new ArrayList<Card>();
		
		sampleList.add(wolf);
		sampleList.add(wolf);
		sampleList.add(wolf);
		
		Deck sut = new Deck(sampleList);
		
		assertEquals(sut.getSize(), 3);
	}

}
