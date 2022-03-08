package javascryption;

import java.util.ArrayList;

public class DeckTester {

	public static void main(String[] args) {
		Card wolf = new Card("Wolf", 1, 2, 3);
		Card raven = new Card("Raven", 3, 2, 1);
		Card stout = new Card("Stout", 5, 6, 7);
		
		Deck deck = new Deck();
		deck.addCard(wolf);
		deck.addCard(raven);
		deck.addCard(stout);
		
		System.out.println(deck.toString());
		
		System.out.println("Testing if it works with an alrady existing array list as well as dealing damage: ");
		stout.recieveAttack(wolf.getAttack());
		
		ArrayList<Card> cardList = new ArrayList<Card>();
		cardList.add(wolf);
		cardList.add(raven);
		cardList.add(stout);
		
		deck = new Deck(cardList);
		System.out.println(deck.toString());
		
		System.out.println("Testing if a deck has zero cards: ");
		deck = new Deck();
		deck.toString();
	}

}
