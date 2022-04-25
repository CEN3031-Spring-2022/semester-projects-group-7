package tests;

import javascryption.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SigilJUnitTest {

		@Test
		void testDefaultNormalCardConstructor() {
			Card obj = new NormalCard();
			assert(obj.getClass().toString().equals("class javascryption.NormalCard"));
		}
		@Test
		void testTouchOfDeathConstructor() {
			Card obj = new TouchOfDeathCard();
			assert(obj.getClass().toString().equals("class javascryption.TouchOfDeathCard"));
		}
		@Test
		void testDefaultConstructor() {
			Card obj = new BifurcatedStrikeCard();
			assert(obj.getClass().toString().equals("class javascryption.BifurcatedStrikeCard"));
		}
		
		@Test
		void testFileReadAndSet() {
			Card obj = new NormalCard();
			
			obj.makeCard(1);
			assertEquals(obj.getName(), "Stoat");
			assertEquals(obj.getBlood(), 1);
			assertEquals(obj.getHealth(), 2);
			assertEquals(obj.getAttack(), 1);
		}
		
		@Test
		void testFileReadAndResetWithNewID() {
			Card obj = new NormalCard();
			
			obj.makeCard(1);
			
			obj.makeCard(0);
			assertEquals(obj.getName(), "Squirrel");
			assertEquals(obj.getBlood(), 0);
			assertEquals(obj.getHealth(), 1);
			assertEquals(obj.getAttack(), 0);
		}
		
		@Test
		void TouchOfDeathKillsAll() {
			Card attacker = new TouchOfDeathCard("weasel", 2, 2, 2); //card has 2 attack
			Card defender = new NormalCard("wolf", 1, 99, 1); //card has 99 health
			int overkillDamage;
			
			ArrayList<Card> attackerAL = new ArrayList<Card>();
			ArrayList<Card> defenderAL = new ArrayList<Card>();
			attackerAL.add(attacker);
			defenderAL.add(defender);
			
			overkillDamage = attacker.cardAttacks(attackerAL, defenderAL, 0);
			
			assertEquals(0, defender.getHealth());
			assertEquals(0, overkillDamage);
		}
		
		void TouchOfDealsNormalDamageIfNoDefender() {
			Card attacker = new TouchOfDeathCard("weasel", 2, 2, 2); //card has 2 attack
			Card defender = new NormalCard("wolf", 1, 99, 1); //card has 99 health
			int overkillDamage;
			
			ArrayList<Card> attackerAL = new ArrayList<Card>();
			ArrayList<Card> defenderAL = new ArrayList<Card>();
			attackerAL.add(attacker);
			
			overkillDamage = attacker.cardAttacks(attackerAL, defenderAL, 0);
			
			assertEquals(2, overkillDamage);
		}
		
		@Test
		void BifurcatedStrikeAttacksCorrectly() {
			Card temp = new NormalCard();
			Card attacker = new BifurcatedStrikeCard("weasel", 2, 2, 2); //card has 2 attack
			Card defender1 = new NormalCard("wolf", 1, 99, 1); //card has 99 health
			Card defender2 = new NormalCard("wolf", 1, 1, 1); //card has 99 health
			int overkillDamage;
			
			ArrayList<Card> attackerAL = new ArrayList<Card>();
			ArrayList<Card> defenderAL = new ArrayList<Card>();
			attackerAL.add(temp);
			attackerAL.add(attacker);
			defenderAL.add(defender1);
			defenderAL.add(temp);
			defenderAL.add(defender2);
			
			overkillDamage = attacker.cardAttacks(attackerAL, defenderAL, 1);
			
			assertEquals(97, defender1.getHealth());
			assertEquals(-1, defender2.getHealth());
			assertEquals(1, overkillDamage);
		}

	}
