package javascryption;

public class main {

	public static void main(String[] args) {
		Deck deck = new Deck();
		
		Card wolf = new Card("Wolf", 1, 2, 3);
		Card badger = new Card("Badger", 1, 2, 3);
		Card bee = new Card("Bee", 1, 2, 3);
		
		deck.addCard(wolf);
		deck.addCard(badger);
		deck.addCard(bee);
		
		Player sut = new Player();
		sut.setDeck(deck);
		
		sut.drawCard();
		
		System.out.println(sut.getPlayerDeck().getCardByPosition(0).toString());
	}

}
