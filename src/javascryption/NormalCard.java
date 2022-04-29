package javascryption;

import java.util.ArrayList;

public class NormalCard extends Card {

	public NormalCard() {
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
	public NormalCard(String newName, int newBlood, int newHealth, int newAttack) {
		super(newName, newBlood, newHealth, newAttack);
	}
	
	@Override
	public int cardAttacks(ArrayList<Card> attackerAL, ArrayList<Card> defenderAL, int positionX) {
	if (defenderAL.get(positionX) == null || attackerAL.get(positionX) == null)
		return 0;
	
	int overkillDamage = 0;
	int damage = attackerAL.get(positionX).getAttack();
	int defenderHealth = defenderAL.get(positionX).getHealth();
	defenderHealth -= damage;
	
	defenderAL.get(positionX).setHealth(defenderHealth);
			
	if(defenderHealth < 0)
		overkillDamage = defenderHealth*-1;
	
	return overkillDamage;
	}
}
