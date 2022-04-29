package javascryption;
import java.util.ArrayList;

import javafx.scene.layout.HBox;

public class Hand {
	private ArrayList<HandButtons> hand;
	private HBox handHBox = new HBox(20);
	private Deck playerDeck;
	private BoardButtons boardButtons;
	
	/*
	 * Default constructor. Initializes an empty ArrayList of cards.
	 */
	public Hand() {
		this.hand = new ArrayList<HandButtons>();
		playerDeck = new Deck();
	}
	
	/*
	 * Parameterized constructor used to set a player's hand, may be useful at initialization
	 * or maybe not useful.
	 * @param newHand an ArrayList of cards that make up a hand
	 */
	public Hand(BoardButtons someBoardButtons) {
		this.hand = new ArrayList<HandButtons>();
		playerDeck = new Deck();
		boardButtons = someBoardButtons;
	}
	
	
	public void setHand(ArrayList<HandButtons> newHand) {
		this.hand = newHand;
	}
	
	/*
	 * @return an ArrayList representing the hand
	 */
	public ArrayList<HandButtons> getHand() {
		return this.hand;
	}
	
	//return buttons aligned horizontally
	public HBox getHandHBox() {
		return handHBox;
	}
		
	public void addCardToHand(Card newCard) {
        HandButtons handButtons = new HandButtons(boardButtons);
        handButtons.setCardPos(hand.size());
        handButtons.addHandButton(newCard);
        handHBox.getChildren().add(handButtons.getHandButton());
		this.hand.add(handButtons);
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
			hand.remove(cardPos);
			handHBox.getChildren().remove(cardPos);
			for(int i = cardPos; i < hand.size(); i++) {
				hand.get(i).setCardPos(i);
			}
	}
	
	/**
	 * return a Card at given position. returns nothing if there isn't one.
	 * @param cardPos position you wish to look at
	 * @return card at the position you entered
	 */
	public Card getCardByPos(int cardPos) {
		if(playerDeck.getSize() < cardPos)
			return null;
		return hand.get(cardPos).getHandCard();
	}
	
}
