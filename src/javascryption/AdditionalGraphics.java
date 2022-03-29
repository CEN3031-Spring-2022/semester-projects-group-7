package javascryption;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class AdditionalGraphics {
	
	public Group setCardSlotGraphics() throws FileNotFoundException {
		/* Idle Positions are the top line of the board, where enemy cards are
		 * "idling" until they reach the middle line to attack.
		 * 
		 * enemyPositions are the middle line of the board where enemy cards are
		 * ready to attack when the bell is rung.
		 */
		
		
	    Image EnemySlot = new Image(new FileInputStream("assets/EnemyCardSlotEmpty.png"));
	    
	    ImageView enemyIdlePosition1 = new ImageView(EnemySlot); 
	    ImageView enemyIdlePosition2 = new ImageView(EnemySlot); 
	    ImageView enemyIdlePosition3 = new ImageView(EnemySlot); 
	    ImageView enemyIdlePosition4 = new ImageView(EnemySlot); 
	    
	    ImageView enemyPosition1 = new ImageView(EnemySlot); 
	    ImageView enemyPosition2 = new ImageView(EnemySlot); 
	    ImageView enemyPosition3 = new ImageView(EnemySlot); 
	    ImageView enemyPosition4 = new ImageView(EnemySlot); 
	    
	    Image PlayerSlot = new Image(new FileInputStream("assets/PlayerCardSlotEmpty.png"));

	    ImageView playerPosition1 = new ImageView(PlayerSlot); 
	    ImageView playerPosition2 = new ImageView(PlayerSlot);
	    ImageView playerPosition3 = new ImageView(PlayerSlot);
	    ImageView playerPosition4 = new ImageView(PlayerSlot);
		//Idle Positions //////////////////////////////////////////////////////////////////////////////////////
		
		enemyIdlePosition1.setX(-225);
		enemyIdlePosition2.setX(-75);
		enemyIdlePosition3.setX(75);
		enemyIdlePosition4.setX(225);
		
		//Enemy Positions ///////////////////////////////////////////////////////////////////////////////////
		
		enemyPosition1.setX(-225);
		enemyPosition1.setY(175);		
		enemyPosition2.setX(-75);
		enemyPosition2.setY(175);
		enemyPosition3.setX(75);
		enemyPosition3.setY(175);
		enemyPosition4.setX(225);
		enemyPosition4.setY(175);
		
		//Player Positions ///////////////////////////////////////////////////////////////////////////////////
		playerPosition1.setX(-225);
		playerPosition1.setY(350);		
		playerPosition2.setX(-75);
		playerPosition2.setY(350);
		playerPosition3.setX(75);
		playerPosition3.setY(350);
		playerPosition4.setX(225);
		playerPosition4.setY(350);

		//Board slots are grouped and moved to match Player card slots ////////////////////////////////////////
				
		Group enemyPositions = new Group(enemyIdlePosition1, enemyIdlePosition2, enemyIdlePosition3, enemyIdlePosition4,
										 enemyPosition1, enemyPosition2, enemyPosition3, enemyPosition4,
										 playerPosition1, playerPosition2, playerPosition3, playerPosition4);
		
		enemyPositions.setTranslateX(-275);
		enemyPositions.setTranslateY(-100);
		
		return enemyPositions;
	}
	
	public void setAttackDeckGraphic(Button aButton) throws FileNotFoundException {
	    Image attackDeckImage = new Image(new FileInputStream("assets/AttackCard.png"));
	    ImageView attackDeck = new ImageView(attackDeckImage); 
	    
	    aButton.setGraphic(attackDeck);
	}
	
	public void setSquirrelDeckGraphic(Button aButton) throws FileNotFoundException {
	    Image squirrelDeckImage = new Image(new FileInputStream("assets/SquirrelCard.png"));
	    ImageView squirrelDeck = new ImageView(squirrelDeckImage); 
	    
	    aButton.setGraphic(squirrelDeck);
	}
	
	/* scaleGraphics() is of type "Rectangle" for placeholder purposes only
	 * This either be removed or modified for the final product
	 */
	
	public Rectangle scaleGraphics() {
		Rectangle tempScalePlaceholder = new Rectangle();
		
		tempScalePlaceholder.setTranslateX(325);
		tempScalePlaceholder.setTranslateY(-40);
		tempScalePlaceholder.setWidth(500); 
		tempScalePlaceholder.setHeight(175);
		
		return tempScalePlaceholder;
	}

}
