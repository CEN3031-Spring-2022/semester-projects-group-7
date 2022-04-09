package javascryption;

import java.util.ArrayList;

public class TouchOfDeathCard extends Card {

	public TouchOfDeathCard() {
		super();
	}
	/**
	 * Constructs new card using the assigned values from the start. These can be read from a file.
	 * I called the setters here in case we desire to regulate these values more heavily later on.
	 * @param newName Name of the card.
	 * @param newHealth Amount of health.
	 * @param newAttack Amount of Attack.
	 * @param newBlood Amount of blood which it costs to put card into play.
	 */
	public TouchOfDeathCard(String newName, int newBlood, int newHealth, int newAttack) {
		super(newName, newBlood, newHealth, newAttack);
	}
	
	public TouchOfDeathCard(String newName, int newBlood, int newHealth, int newAttack, boolean newIsUnkillable) {
		super(newName, newBlood, newHealth, newAttack, newIsUnkillable);
	}
	
	@Override
	public int cardAttacks(ArrayList<Card> attackerAL, ArrayList<Card> defenderAL, int positionX) {
		if (defenderAL.get(positionX) != null) {
			defenderAL.get(positionX).setHealth(0);
			return 0;
		}
		int overkillDamage = attackerAL.get(positionX).getAttack();
		return overkillDamage;
		}
}
