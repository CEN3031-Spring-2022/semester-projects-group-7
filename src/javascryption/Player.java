package javascryption;

import java.util.ArrayList;

public class Player {
	/*
	 * TODO: Hold information about a player's health, cards, and current hand
	 */
	private int playerHP; // the HP of the player
	private Deck playerDeck; // The player's deck of cards
	private Hand playerHand; // The player's current hand
	
	public Player() {
		// start player with 10 hp, can be adjusted in the future
		this.playerHP =  10;
		this.playerDeck = new Deck();
	}

	/**
	 * assign the player's deck that they will be drawing from
	 * @param deck
	 */
	public void setDeck(Deck deck) {
		this.playerDeck = deck;
	}

	/**
	 * return the players current hand object
	 * @return the player's current hand
	 */
	public Hand getHand() {
		return this.playerHand;
	}
}