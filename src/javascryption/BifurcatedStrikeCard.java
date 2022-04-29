package javascryption;

import java.util.ArrayList;

public class BifurcatedStrikeCard extends Card{

	public BifurcatedStrikeCard() {
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
	public BifurcatedStrikeCard(String newName, int newBlood, int newHealth, int newAttack) {
		super(newName, newBlood, newHealth, newAttack);
	}
	
	@Override
	public int cardAttacks(ArrayList<Card> attackerAL, ArrayList<Card> defenderAL, int positionX) {
		if (defenderAL.get(positionX) == null || attackerAL.get(positionX) == null)
			return 0;
		
		int overkillDamage = 0;
		int damage = attackerAL.get(positionX).getAttack();
		int defenderHealthLeft = 0;
		int defenderHealthRight = 0;
		
		//If card is on the far left it only attacks to the right
		if(positionX == 0) {
			if(defenderAL.get(positionX + 1) == null) {
				defenderHealthLeft = damage*-1;
			}
			else {
			defenderHealthRight = defenderAL.get(positionX + 1).getHealth() - damage;
			defenderAL.get(positionX + 1).setHealth(defenderHealthRight);
			}
		}
		
		//If card is on the far right it only attacks to the left
		else if(positionX == 3) {
			if(defenderAL.get(positionX - 1) == null) {
				defenderHealthLeft = damage*-1;
			}
			else {
			defenderHealthLeft = defenderAL.get(positionX - 1).getHealth() - damage;
			defenderAL.get(positionX - 1).setHealth(defenderHealthLeft);
			}
		}
		
		else {
			if(defenderAL.get(positionX + 1) == null) {
				defenderHealthRight = damage*-1;
			}
			if(defenderAL.get(positionX - 1) == null) {
				defenderHealthLeft = damage*-1;
			}
			else {
			defenderHealthLeft = defenderAL.get(positionX - 1).getHealth() - damage;
			defenderHealthRight = defenderAL.get(positionX + 1).getHealth() - damage;	
			defenderAL.get(positionX + 1).setHealth(defenderHealthRight);
			defenderAL.get(positionX - 1).setHealth(defenderHealthLeft);
			}
		}
		if(defenderHealthLeft < 0)
			overkillDamage += defenderHealthLeft*-1;
		if(defenderHealthRight < 0)
			overkillDamage += defenderHealthRight*-1;
		
		return overkillDamage;
		}

}
