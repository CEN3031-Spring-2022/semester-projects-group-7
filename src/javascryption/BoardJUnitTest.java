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
}
