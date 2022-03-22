package javascryption;

import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class AdditionalGraphics {
	/* These are all placeholder graphics
	 * They should either be modified or replaced by images
	 */
	
	public Group setCardSlotGraphics() {
		/* Idle Positions are the top line of the board, where enemy cards are
		 * "idling" until they reach the middle line to attack.
		 * 
		 * enemyPositions are the middle line of the board where enemy cards are
		 * ready to attack when the bell is rung.
		 */
		
		Rectangle enemyIdlePosition1 = new Rectangle();
		Rectangle enemyIdlePosition2 = new Rectangle();
		Rectangle enemyIdlePosition3 = new Rectangle();
		Rectangle enemyIdlePosition4 = new Rectangle();
		
		Rectangle enemyPosition1 = new Rectangle();
		Rectangle enemyPosition2 = new Rectangle();
		Rectangle enemyPosition3 = new Rectangle();
		Rectangle enemyPosition4 = new Rectangle();
		
		//Idle Position size and position //////////////////////////////////////////////////
		
		enemyIdlePosition1.setX(-225);
		enemyIdlePosition1.setWidth(100); 
		enemyIdlePosition1.setHeight(150);
		
		enemyIdlePosition2.setX(-75);
		enemyIdlePosition2.setWidth(100); 
		enemyIdlePosition2.setHeight(150);
		
		enemyIdlePosition3.setX(75);
		enemyIdlePosition3.setWidth(100); 
		enemyIdlePosition3.setHeight(150);
		
		enemyIdlePosition4.setX(225);
		enemyIdlePosition4.setWidth(100); 
		enemyIdlePosition4.setHeight(150);
		
		//Enemy Position size and position //////////////////////////////////////////////////
		
		enemyPosition1.setX(-225);
		enemyPosition1.setY(175);
		enemyPosition1.setWidth(100); 
		enemyPosition1.setHeight(150);
		
		enemyPosition2.setX(-75);
		enemyPosition2.setY(175);
		enemyPosition2.setWidth(100); 
		enemyPosition2.setHeight(150);
		
		enemyPosition3.setX(75);
		enemyPosition3.setY(175);
		enemyPosition3.setWidth(100); 
		enemyPosition3.setHeight(150);
		
		enemyPosition4.setX(225);
		enemyPosition4.setY(175);
		enemyPosition4.setWidth(100); 
		enemyPosition4.setHeight(150);
		
		//Board slots are grouped and moved to match Player card slots ////////////////////////////////////////
				
		Group enemyPositions = new Group(enemyIdlePosition1, enemyIdlePosition2, enemyIdlePosition3, enemyIdlePosition4,
										 enemyPosition1, enemyPosition2, enemyPosition3, enemyPosition4);
		
		enemyPositions.setTranslateX(-275);
		enemyPositions.setTranslateY(-200);
		
		return enemyPositions;
	}
	
	/* scaleGraphics() is of type "Rectangle" for placeholder purposes only
	 * This either be removed or modified for the final product
	 */
	
	public Rectangle scaleGraphics() {
		Rectangle tempScalePlaceholder = new Rectangle();
		
		tempScalePlaceholder.setTranslateX(350);
		tempScalePlaceholder.setTranslateY(-225);
		tempScalePlaceholder.setWidth(450); 
		tempScalePlaceholder.setHeight(250);
		
		return tempScalePlaceholder;
	}

}
