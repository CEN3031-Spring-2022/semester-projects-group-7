package tests;

import javascryption.*;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class BoardReaderJUnitTest {
	@Test
	void cardIsCorrectlyMadeFromLibrary() throws IOException {
		BoardReader sut = new BoardReader();
		Card originalCard = new NormalCard("Squirrel", 0, 1, 0);
		Card sampleCard = sut.makeCardFromLibrary("Squirrel");
		
		assertEquals(originalCard.toString(), sampleCard.toString());
	}
	@Test
	void boardIsCorrectlySetUp() throws IOException {
		BoardReader sut = new BoardReader();
		
		sut.readInputFile("Enemy_Boards/DefaultBoard.txt");
		Board testboard = sut.getBoard();
		
		//make sure card at 0, 1 is a squirrel
		assertEquals(testboard.getOpponentCardByPosition(0, 1).toString(), sut.makeCardFromLibrary("Squirrel").toString());
		//make sure card at 1, 4 is a river snapper
		assertEquals(testboard.getOpponentCardByPosition(1, 4).toString(), sut.makeCardFromLibrary("Snapper").toString());
		//make sure card at 3, 3 is a squirrel
		assertEquals(testboard.getOpponentCardByPosition(3, 3).toString(), sut.makeCardFromLibrary("Squirrel").toString());
		}
	
}
