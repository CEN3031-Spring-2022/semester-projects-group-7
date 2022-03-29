package javascryption;
import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> hand;
	private Deck playerDeck;
	
	/*
	 * Default constructor. Initializes an empty ArrayList of cards.
	 */
	public Hand() {
		this.hand = new ArrayList<Card>();
		playerDeck = new Deck();
	}
	
	/*
	 * Parameterized constructor used to set a player's hand, may be useful at initialization
	 * or maybe not useful.
	 * @param newHand an ArrayList of cards that make up a hand
	 */
	public void setHand(ArrayList<Card> newHand) {
		this.hand = newHand;
	}
	
	/*
	 * @return an ArrayList representing the hand
	 */
	public ArrayList<Card> getHand() {
		return this.hand;
	}
		
	public void addCardToHand(Card newCard) {
		this.hand.add(newCard);
	}
	
	
	/**
	 * Removes card from hand and returns it
	 * @param cardPos position in the hand arraylist of the card you want to use.
	 * @return card user wishes to play
	 */
	public Card placeCardByPosition(int cardPos) {
		Card cardToUse = getCardByPos(cardPos);
		this.removeCardbyPosition(cardPos);
		return cardToUse;
	}
	
	/**
	 * Input a position in the hand arraylist to remove that card
	 * @param cardPos position of card you wish to remove
	 */
	public void removeCardbyPosition(int cardPos) {
		if(playerDeck.getSize() < cardPos)
			return;
		hand.remove(cardPos);
	}
	
	/**
	 * return a Card at given position. returns nothing if there isn't one.
	 * @param cardPos position you wish to look at
	 * @return card at the position you entered
	 */
	public Card getCardByPos(int cardPos) {
		if(playerDeck.getSize() < cardPos)
			return null;
		return hand.get(cardPos);
	}
			
}
