package javascryption;

import org.junit.jupiter.api.*;
import static org.junit.Assert.assertEquals;

public class HandTester {
	
	// Test default constructor. This checks if the hand ArrayList is empty, if it is, then we know
	// the ArrayList has been constructed.
	@Test
	void testDefaultConstructor() {
		Hand obj = new Hand();
		assert(obj.getHand().isEmpty() == true);
	}
	
	
	// TODO: Test add / "draw" method in bounds
	// TODO: Test add / "draw" method out of bounds
	
	// TODO: Test get(index) method
	// TODO: Test get method/ check for a return of whole hand
	
	// TODO: Test remove / "place" method
	// TODO: Test remove / "place" with empty hand
	
}
