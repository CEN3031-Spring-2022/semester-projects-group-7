package javascryption;
import java.util.ArrayList;

public class Deck {
	private ArrayList<Card> deck; //Array List of card objects is stored here.
	
	/**
	 * Default constructor, not sure which one we'll end up using so I did both.
	 */
	public Deck() {
		this.deck = new ArrayList();
	}
	
	/**
	 * Parameterized constructor. Takes in a pre existing deck of cards
	 * @param newDeck Deck of cards to import.
	 */
	public Deck(ArrayList<Card> newDeck) {
		this.deck = new ArrayList();
		setDeck(newDeck);
	}
	
	/**
	 * Adds cards to the deck individually
	 * @param newCard any given card that you want to add.
	 */
	public void addCard(Card newCard) {
		this.deck.add(newCard);
	}
	
	/**
	 * Adds any number of cards to the deck.
	 * @param newDeck an array list of cards.
	 */
	public void setDeck(ArrayList<Card> newDeck) {
		for (Card newCard: newDeck)
			addCard(newCard);
	}
	
	/**
	 * returns the current size of the arraylist
	 * @return integer showing the size.
	 */
	public int getSize() {
		return deck.size();
	}
	

	@Override
	public String toString() {
		String output = "";
		output += "Number of cards: "+this.getSize();
		
		for (Card newCard : this.deck)
			output+= newCard.toString()+"\n";
		
		return output;
	}
	/*
	 * TODO: 
	 *   - Add function that allows you to remove a card from your deck. 
	 *       This will probably require it to go through your cards and compare them to one another.
	 *   - Add function to shuffle deck.
	 *   - Add function to search how many of an individual card there is.
	 */
	
}
