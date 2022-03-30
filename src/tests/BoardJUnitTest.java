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
	void playerAttacks() {
		Board sut = new Board();
		Card weasel = new Card("Weasel", 2, 2, 2);
		Card wolf = new Card("Wolf", 3, 3, 3);	
		sut.addPlayerCardtoBoard(weasel, 0);
		sut.addOpponentCardtoBoard(wolf, 0);
	
		sut.damageOpponentCard(0, 0);
		
		assertEquals(1, wolf.getHealth());
	}
	
	@Test
	void opponentAttacks() {
		Board sut = new Board();
		Card weasel = new Card("Weasel", 2, 2, 2);
		Card wolf = new Card("Wolf", 3, 3, 3);	
		sut.addPlayerCardtoBoard(wolf, 0);
		sut.addOpponentCardtoBoard(weasel, 0);
	
		sut.damagePlayerCard(0, 0);
		
		assertEquals(1, wolf.getHealth());
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

}
