package javascryption;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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

		//Board slots are grouped and moved to match Player card slots ////////////////////////////////////////
				
		Group enemyPositions = new Group(enemyIdlePosition1, enemyIdlePosition2, enemyIdlePosition3, enemyIdlePosition4,
										 enemyPosition1, enemyPosition2, enemyPosition3, enemyPosition4);
		
		enemyPositions.setTranslateX(-275);
		enemyPositions.setTranslateY(-200);
		
		return enemyPositions;
	}
	
	public void setPlayerEmptySlotGraphics(Button pos1, Button pos2, Button pos3, Button pos4) throws FileNotFoundException {
	    Image PlayerSlotImage = new Image(new FileInputStream("assets/PlayerCardSlotEmpty.png"));
	    ImageView playerEmptySlot1 = new ImageView(PlayerSlotImage); 
	    ImageView playerEmptySlot2 = new ImageView(PlayerSlotImage); 
	    ImageView playerEmptySlot3 = new ImageView(PlayerSlotImage); 
	    ImageView playerEmptySlot4 = new ImageView(PlayerSlotImage); 

	    
	    pos1.setGraphic(playerEmptySlot1);
	    pos2.setGraphic(playerEmptySlot2);
	    pos3.setGraphic(playerEmptySlot3);
	    pos4.setGraphic(playerEmptySlot4);
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
	
	public Slider scaleGraphics() {
		Slider HPSlider = new Slider(0, 10, 1); //have ticks at each num from 1 to 10
		HPSlider.setShowTickMarks(true);
		HPSlider.setShowTickLabels(true);
		HPSlider.setMajorTickUnit(1);
		HPSlider.setMinorTickCount(0);
		HPSlider.setBlockIncrement(1);
		HPSlider.setValue(5);

		HPSlider.setSnapToTicks(true);
		
		HPSlider.setMaxSize(500, 100);
		HPSlider.setTranslateX(325);
		HPSlider.setTranslateY(-40);
		
		HPSlider.setDisable(true); //stops user from being able to move slider
		
		return HPSlider;
	}

}
