package javascryption;

import java.util.ArrayList;

public class Player {
	/*
	 * TODO: Hold information about a player's health
	 */
	private Deck playerDeck; // The player's deck of cards
	private Hand playerHand; // The player's current hand
	
	public Player() {
		this.playerDeck = new Deck();
	}

	public void setDeck(Deck deck) {
		this.playerDeck = deck;
	}

	public Hand getHand() {
		return this.playerHand;
	}
}