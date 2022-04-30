package javascryption;


public class Player {
	/*
	 * TODO: Hold information about a player's health, cards, and current hand
	 */
	private Deck playerDeck; // The player's deck of cards
	
	public Player() {
		this.playerDeck = new Deck();
	}

	/**
	 * assign the player's deck that they will be drawing from
	 * @param deck
	 */
	public void setDeck(Deck deck) {
		this.playerDeck = deck;
	}
	
	public Deck getPlayerDeck() {
		return playerDeck;
	}
	
}