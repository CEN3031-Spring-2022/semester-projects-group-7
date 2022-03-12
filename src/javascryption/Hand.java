package javascryption;
import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> hand;
	
	/*
	 * Default constructor. Initializes an empty ArrayList of cards.
	 */
	public Hand() {
		this.hand = new ArrayList<Card>();
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
	
	
	// TODO: Implement add / "draw" method
	
	// TODO: Implement get(index)method
	
	// TODO: Implement remove / "place" method
}
