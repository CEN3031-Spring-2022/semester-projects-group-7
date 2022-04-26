package tests;

import javascryption.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class BoardReaderJUnitTest {
	@Test
	void cardIsCorrectlyMadeFromLibrary() throws IOException {
		BoardReader sut = new BoardReader();
		Card originalCard = new Card("Squirrel", 0, 1, 0);
		Card sampleCard = sut.makeCardFromLibrary("Squirrel");
		
		assertEquals(originalCard.toString(), sampleCard.toString());
	}
	@Test
	void boardIsCorrectlySetUp() throws IOException {
		BoardReader sut = new BoardReader();
		
		sut.readInputFile("DefaultBoard.txt");
		Board testboard = sut.getBoard();
		
		//make sure card at 0, 0 is a squirrel
		assertEquals(testboard.getOpponentCardByPosition(0, 0).toString(), sut.makeCardFromLibrary("Squirrel").toString());
		//make sure card at 1, 3 is a river snapper
		assertEquals(testboard.getOpponentCardByPosition(1, 3).toString(), sut.makeCardFromLibrary("River Snapper").toString());
		//make sure card at 3, 2 is a squirrel
		assertEquals(testboard.getOpponentCardByPosition(3, 2).toString(), sut.makeCardFromLibrary("Squirrel").toString());

		}
}
