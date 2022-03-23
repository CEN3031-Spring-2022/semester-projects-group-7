package javascryption;

import static org.junit.Assert.assertEquals;
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

}
