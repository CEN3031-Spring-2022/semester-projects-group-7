package tests;

import javascryption.*;

//import java.io.File;
import java.io.*;
import java.util.ArrayList;
import org.junit.jupiter.api.*;
import static org.junit.Assert.assertEquals;

public class DeckJUnitTest {
	
	@Test
	void addingCardstoDeck() {
		Deck sut = new Deck();
		
		Card wolf = new NormalCard("Wolf", 1, 2, 3);
		Card badger = new NormalCard("Badger", 1, 2, 3);
		Card bee = new NormalCard("Bee", 1, 2, 3);
		
		sut.addCard(wolf);
		sut.addCard(badger);
		sut.addCard(bee);		
	}
	
	@Test
	void checkingSizeOfDeck() {
		Deck sut = new Deck();
		
		Card wolf = new NormalCard("Wolf", 1, 2, 3);
		Card badger = new NormalCard("Badger", 1, 2, 3);
		Card bee = new NormalCard("Bee", 1, 2, 3);
		
		sut.addCard(wolf);
		sut.addCard(badger);
		sut.addCard(bee);
		
		assertEquals(sut.getSize(), 3);
	}
	
	@Test
	void testingParameterizedConstructor() {
		Card wolf = new NormalCard("Wolf", 1, 2, 3);

		ArrayList<Card> sampleList = new ArrayList<Card>();
		
		sampleList.add(wolf);
		sampleList.add(wolf);
		sampleList.add(wolf);
		
		Deck sut = new Deck(sampleList);
		
		assertEquals(sut.getSize(), 3);
	}
	
	@Test
	void testDeletionOfCardsByPosition() {
		//arrange
		Deck sut = new Deck();
		Card obj1 = new NormalCard("wolf", 2, 2, 2);
		Card obj2 = new NormalCard("bee", 1, 1, 1);
		sut.addCard(obj1);
		sut.addCard(obj2);

		//action - This deletes card in the first position and moves the second over.
		sut.deleteCardByPosition(0);
		
		//assert - This makes sure that both toStrings are the same.
		assertEquals(sut.getCardByPosition(0).toString(), obj2.toString());
	}
	
	@Test
	void addingCardToFrontPosition() {
		//arrange
		Deck sut = new Deck();
		Card obj1 = new NormalCard("wolf", 2, 2, 2);
		Card obj2 = new NormalCard("bee", 1, 1, 1);
		Card obj3 = new NormalCard("Cat", 0, 0, 0);
		sut.addCard(obj1);
		sut.addCard(obj2);
		
		//action - add obj3 to the front of the array.
		sut.addCardToFront(obj3);
		
		//assert
		assertEquals(sut.getCardByPosition(0).toString(), obj3.toString());
	}
	
	@Test
	void shuffleCardsKeepsAllCards() {
		Deck sut = new Deck();
		Card obj1 = new NormalCard("wolf", 2, 2, 2);
		Card obj2 = new NormalCard("bee", 1, 1, 1);
		Card obj3 = new NormalCard("Cat", 0, 0, 0);
		Card obj4 = new NormalCard("Badger", 0, 0, 0);
		Card obj5 = new NormalCard("Elephant", 0, 0, 0);
		
		sut.addCard(obj1);
		sut.addCard(obj2);
		sut.addCard(obj3);
		sut.addCard(obj4);
		sut.addCard(obj5);
		
		int beforeShuffle = sut.getSize();
		//System.out.println(sut.toString());
		sut.shuffleCards();
		//System.out.println("--------------\n"+sut.toString());
		
		assertEquals(sut.getSize(), beforeShuffle);
	}
	
	@Test
	void readingFromFile() {
		// read deck file in
		String path = "./DefaultPlayerDeck.txt";
		Deck sut = new Deck();
		sut.readDeckFromFile(path);
		// Card objects to compare to
		Card Wolf = new NormalCard("Wolf",2,3,2);
		Card Adder = new TouchOfDeathCard("Adder",2,1,1);
		Card Snapper = new NormalCard("Snapper", 2,6,1);

		Card Stoat = new NormalCard("Stoat",1,2,1);
		// Add cards to a new deck
		Deck compareDeck = new Deck();
		compareDeck.addCard(Wolf);
		compareDeck.addCard(Adder);
		compareDeck.addCard(Snapper);
		compareDeck.addCard(Stoat);
	
		assertEquals(sut.getCardByPosition(0).toString(), compareDeck.getCardByPosition(0).toString());
		assertEquals(sut.getCardByPosition(1).toString(), compareDeck.getCardByPosition(1).toString());
		assertEquals(sut.getCardByPosition(2).toString(), compareDeck.getCardByPosition(2).toString());
		assertEquals(sut.getCardByPosition(3).toString(), compareDeck.getCardByPosition(3).toString());
		//assertEquals(sut.getCardByPosition(4).toString(), compareDeck.getCardByPosition(4).toString());

		
	}
}
