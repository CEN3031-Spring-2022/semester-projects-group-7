package tests;

import javascryption.*;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class BoardJUnitTest {

	@Test
	void addsPlayerCardsToCorrectPosition() {
		Board sut = new Board();
		Card weasel = new Card();
		
		sut.addPlayerCardtoBoard(weasel, 0);
		
		assertEquals(weasel, sut.getPlayerCardByPos(0));
	}
	
	@Test
	void PlayerCardsAreRemoved() {
		Board sut = new Board();
		Card weasel = new Card();
		sut.addPlayerCardtoBoard(weasel, 0);
		
		sut.removePlayerCardFromBoard(0);
		
		assertEquals(null, sut.getPlayerCardByPos(0));
	}
	
	@Test
	void addsOpponentCardsToCorrectPosition() {
		Board sut = new Board();
		Card weasel = new Card();
		Card beaver = new Card();
		Card wolf = new Card();
		
		sut.addOpponentCardtoBoard(weasel, 0);
		sut.addOpponentCardtoBoard(beaver, 3);
		sut.addOpponentCardtoBoard(wolf, 0);
		
		assertEquals(weasel, sut.getOpponentCardByPosition(0));
		assertEquals(beaver, sut.getOpponentCardByPosition(3));
		assertEquals(wolf, sut.getOpponentCardByPosition(0, 1));
	}
	
	@Test
	void OpponentCardsMoveCorrectly() {
		Board sut = new Board();
		Card weasel = new Card();
		Card beaver = new Card();
		Card wolf = new Card();
		
		sut.addOpponentCardtoSpecificLocation(wolf, 0, 3);		
		sut.addOpponentCardtoSpecificLocation(weasel, 3, 0);
		sut.addOpponentCardtoSpecificLocation(beaver, 3, 1);
		
		sut.moveOpponentCardsForward();

		assertEquals(wolf, sut.getOpponentCardByPosition(0, 2));
		assertEquals(null, sut.getOpponentCardByPosition(0, 3));
		assertEquals(null, sut.getOpponentCardByPosition(0,1));
		
		assertEquals(weasel, sut.getOpponentCardByPosition(3, 0));
		assertEquals(beaver, sut.getOpponentCardByPosition(3, 1));
	}
	
	@Test
	void OpponentCardsAreRemoved() {
		Board sut = new Board();
		Card weasel = new Card();		
		sut.addOpponentCardtoBoard(weasel, 0);
		sut.removeOpponentCardFromBoard(0);
		
		assertEquals(null, sut.getOpponentCardByPosition(0));
	}
	
	@Test
	void correctlyGrabsFrontRow() {
		Board sut = new Board();
		Card weasel = new Card();
		Card beaver = new Card();
		Card wolf = new Card();
		
		sut.addOpponentCardtoBoard(weasel, 0);
		sut.addOpponentCardtoBoard(beaver, 1);
		//intentionally not adding anything to row 2
		sut.addOpponentCardtoBoard(wolf, 3);
		
		ArrayList<Card> frontRow = new ArrayList<Card>(sut.getFrontRow());
		for (int i=0; i<4; i++) //loop to automatically check without typing it all
			assertEquals(frontRow.get(i), sut.getOpponentCardByPosition(i));
	}
	
	@Test
	void correctlyGrabsSecondRow() {
		Board sut = new Board();
		Card weasel = new Card("Weasel", 1, 1, 1);
		Card beaver = new Card();
		Card wolf = new Card();
		
		sut.addOpponentCardtoSpecificLocation(weasel, 0, 1);
		sut.addOpponentCardtoSpecificLocation(beaver, 1, 1);
		//intentionally not adding anything to row 2
		sut.addOpponentCardtoSpecificLocation(wolf, 3, 1);
		
		ArrayList<Card> secondRow = new ArrayList<Card>(sut.getSecondRow());
		for (int i=0; i<4; i++) //loop to automatically check without typing it all
			assertEquals(secondRow.get(i), sut.getOpponentCardByPosition(i, 1));
	}
	
	@Test
	void CardHealthIsRemovedCorrectly() {
		Board sut = new Board();
		Card weasel = new Card("Weasel", 2, 4, 2);
		Card wolf = new Card("Wolf", 3, 3, 3);	
		
		sut.addPlayerCardtoBoard(weasel, 0);
		sut.addOpponentCardtoBoard(wolf, 0);
		
		sut.attack(0, true); //lane 1, player (weasel) is attacking
		sut.attack(0, false); //lane 1, opponent (wolf) is attacking
		
		//wolf should have one remaining health. Has 3 health, took 2 damage.
		assertEquals(1, sut.getOpponentCardByPosition(0).getHealth());
		//weasel should have one remaining health. Has 4 health, took 3 damage.
		assertEquals(1, sut.getPlayerCardByPos(0).getHealth());
	}
	
	@Test
	void PlayerCardsAreRemovedFromGameAfterHealthIsDepleted() {
		Board sut = new Board();
		Card weasel = new Card("Weasel", 2, 1, 2); //one health
		Card wolf = new Card("Wolf", 3, 3, 3);
		
		sut.addPlayerCardtoBoard(weasel, 0);
		sut.addOpponentCardtoBoard(wolf, 0);
		
		sut.attack(0, false); //lane 1, opponent (wolf) is attacking
		
		//weasel took enough damage to deplete health. It should no longer exist.
		assertEquals(null, sut.getPlayerCardByPos(0));
	}
	
	@Test
	void OpponentCardsAreRemovedFromGameAfterHealthIsDepleted() {
		Board sut = new Board();
		Card weasel = new Card("Weasel", 2, 1, 2); //one health
		Card wolf = new Card("Wolf", 3, 3, 3);
		
		sut.addPlayerCardtoBoard(wolf, 0);
		sut.addOpponentCardtoBoard(weasel, 0);
		
		sut.attack(0, true); //lane 1, player (wolf) is attacking
		
		//weasel took enough damage to deplete health. It should no longer exist.
		assertEquals(null, sut.getOpponentCardByPosition(0));
	}
	
	@Test
	void OverkillDamageIsAppliedToSecondRow() {
		Board sut = new Board();
		Card weasel = new Card("Weasel", 2, 2, 2); //two health
		Card beaver = new Card("Beaver", 3, 3, 3); //three health
		Card wolf = new Card("Wolf", 3, 3, 3); //three attack
		sut.addPlayerCardtoBoard(wolf, 0);
		sut.addOpponentCardtoBoard(weasel, 0);
		sut.addOpponentCardtoBoard(beaver, 0); //beaver should be behind weasel

		sut.attack(0, true); //lane 1, player (wolf) is attacking. Beaver should take 2 damage
		
		//beaver should take one damage, leaving it with 2 health
		assertEquals(2, sut.getOpponentCardByPosition(0, 1).getHealth());
	}
	
	@Test
	void BoardHealthIsProperlyModifiedWhenPlayerAttacks() {
		Board sut = new Board(); //Board defaults to five health
		Card weasel = new Card("Weasel", 2, 2, 2); //two attack
		sut.addPlayerCardtoBoard(weasel, 0);
		int previousBoardHealth = sut.getBoardHealth();
		
		sut.attack(0, true);
		
		assertEquals(previousBoardHealth+2, sut.getBoardHealth());
	}
	
	@Test
	void BoardHealthIsProperlyModifiedWhenOpponentAttacks() {
		Board sut = new Board(); //Board defaults to five health
		Card weasel = new Card("Weasel", 2, 2, 2); //two attack
		sut.addOpponentCardtoBoard(weasel, 0);
		int previousBoardHealth = sut.getBoardHealth();
		
		sut.attack(0, false);
		
		assertEquals(previousBoardHealth-2, sut.getBoardHealth());
	}
	
	@Test
	void AllPlayerCardsAttackWhenPlayerAttackIsCalled() {
		Board sut = new Board(); //will be attacking empty board
		Card weasel = new Card("Weasel", 1, 1, 1); //all cards have one attack
		int previousBoardHealth = sut.getBoardHealth();
		
		for (int i=0; i<sut.getBoardSizeX(); i++)
			sut.addPlayerCardtoBoard(weasel, i);
		
		sut.playerAttack(); //board should now have +4 health, 9 total.
		
		assertEquals(previousBoardHealth+4, sut.getBoardHealth());
	}
	
	@Test
	void AllOpponentCardsAttackWhenOpponentAttackIsCalled() {
		Board sut = new Board(); //will be attacking empty board
		Card weasel = new Card("Weasel", 1, 1, 1); //all cards have one attack
		int previousBoardHealth = sut.getBoardHealth();
		
		for (int i=0; i<sut.getBoardSizeX(); i++)
			sut.addOpponentCardtoBoard(weasel, i);
		
		sut.opponentAttack(); //board should now have -4 health, 1 total.
		
		assertEquals(previousBoardHealth-4, sut.getBoardHealth());
	}
	
	@Test
	void OverkillDamageCanDefeatCardInSecondRow() {
		Board sut = new Board(); //will be attacking empty board
		Card lowHPFront = new Card("Weasel", 1, 1, 1); //card in front has
		Card lowHPBack = new Card ("Bird", 1, 1, 1); //card has one health
		Card farInTheBack = new Card("Hawk", 1, 1, 1); //this card is placed far in the third row. It shouldn't take damage.
		Card HighAtk = new Card ("Lion", 4, 4, 4); //card has 4 attack.
		int previousboardHealth = sut.getBoardHealth();
		
		sut.addPlayerCardtoBoard(HighAtk, 2); //for attacking opponent
		sut.addOpponentCardtoBoard(lowHPFront, 2); //card in front
		sut.addOpponentCardtoSpecificLocation(lowHPBack, 2, 1); //card in back
		sut.addOpponentCardtoSpecificLocation(farInTheBack, 2, 2);
		sut.playerAttack();
		
		assertEquals(null, sut.getOpponentCardByPosition(2)); //opponent card in front does not exist
		assertEquals(null, sut.getOpponentCardByPosition(2, 1)); //opponent card in back does not exist
		assertEquals(farInTheBack, sut.getOpponentCardByPosition(2, 2)); //opponent card in the back was not dealt damage.
		assertEquals(previousboardHealth, sut.getBoardHealth()); //no damage was dealt to the board
	}
	
}
