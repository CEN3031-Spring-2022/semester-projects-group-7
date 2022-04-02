package tests;

import javascryption.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CardJUnitTest {

	@Test
	void testDefaultConstructor() {
		Card obj = new Card();
		assert(obj.getName() == "Not Assigned");
	}
	
	@Test
	void testFileReadAndSet() {
		Card obj = new Card();
		
		obj.makeCard(1);
		assertEquals(obj.getName(), "Stoat");
		assertEquals(obj.getBlood(), 1);
		assertEquals(obj.getHealth(), 2);
		assertEquals(obj.getAttack(), 1);
	}
	
	@Test
	void testFileReadAndResetWithNewID() {
		Card obj = new Card();
		
		obj.makeCard(1);
		
		obj.makeCard(0);
		assertEquals(obj.getName(), "Squirrel");
		assertEquals(obj.getBlood(), 0);
		assertEquals(obj.getHealth(), 1);
		assertEquals(obj.getAttack(), 0);
	}
	
	@Test
	void cardsAttackEachotherCorrectlyAndReturnOverkillDamage() {
		Card attacker = new Card("weasel", 2, 2, 2); //card has 2 attack
		Card defender = new Card("wolf", 1, 1, 1); //card has 1 health
		int overkillDamage;
		
		ArrayList<Card> attackerAL = new ArrayList<Card>();
		ArrayList<Card> defenderAL = new ArrayList<Card>();
		attackerAL.add(attacker);
		defenderAL.add(defender);
		
		overkillDamage = attacker.cardAttacks(attackerAL, defenderAL, 0);
		
		assertEquals(-1, defender.getHealth());
		assertEquals(1, overkillDamage);
	}

}
