package tests;

import javascryption.*;
import org.junit.jupiter.api.*;
import static org.junit.Assert.assertEquals;

public class PlayerJUnitTest {
	// TODO: check players deck to make sure it is correctly assigned
	// TODO: check players hand with at construction (should be empty)

	@Test
	void damagePlayer() {
		Player sut = new Player();
		int damageBefore =  sut.getPlayerHP();
		
		sut.takeDamage(5);
		
		assertEquals(damageBefore - 5, sut.getPlayerHP());
		
	}
	
}
