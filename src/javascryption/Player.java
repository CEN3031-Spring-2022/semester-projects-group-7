package javascryption;


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
		playerHand = new Hand();
		this.readPlayerDeck();
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
	/**
	 * This is where the game is gonna read the input for the player deck. We can start on this in sprint 2.
	 */
	public void readPlayerDeck() {
		
	}
	
	/**
	 * Removes card from top of the deck and adds it to hand.
	 */
	public void drawCard() {
		Card newCard = playerDeck.getCardByPosition(0);
		playerHand.addCardToHand(newCard);
		playerDeck.deleteCardByPosition(0);
	}
	/**
	 * removes health from player. 
	 * @param damage how much health you want to remove from player.
	 */
	public void takeDamage(int damage) {
		setPlayerHP((getPlayerHP() - damage));
	}

	public int getPlayerHP() {
		return playerHP;
	}

	public void setPlayerHP(int playerHP) {
		this.playerHP = playerHP;
	}

	public Deck getPlayerDeck() {
		return playerDeck;
	}

	public Hand getPlayerHand() {
		return playerHand;
	}

	public void setPlayerHand(Hand playerHand) {
		this.playerHand = playerHand;
	}
	
	
	
}