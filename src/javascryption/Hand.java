package javascryption;
import java.util.ArrayList;

public class Hand {
	private ArrayList<Card> hand;
	
	public Hand() {
		this.hand = new ArrayList<Card>();
	}
	
	public void setHand(ArrayList<Card> newHand) {
		this.hand = newHand;
	}
	
	
	public ArrayList<Card> getHand() {
		return this.hand;
	}
	
}
