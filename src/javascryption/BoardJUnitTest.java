package javascryption;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

class BoardJUnitTest {

	@Test
	void testDefaultConstructor() {
		Board obj = new Board();
		assert(obj.board[0][0] == null);
	}
}
