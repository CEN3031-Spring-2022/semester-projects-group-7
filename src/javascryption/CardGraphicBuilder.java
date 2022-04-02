package javascryption;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CardGraphicBuilder {
	
	public Group setEnemyCardGraphicPositions(Card aCard, int row, int column) throws FileNotFoundException {
		Group enemyCardPosition = setCardGraphic(aCard);
		
		if(row == 0) {
			enemyCardPosition.setTranslateY(-287);
		}
			else {
				enemyCardPosition.setTranslateY(-112);
			}
		
		if(column == 0) {
			enemyCardPosition.setTranslateX(-501);
			}
			else if(column == 1) {
				enemyCardPosition.setTranslateX(-350);
			}
			else if(column == 2) {
				enemyCardPosition.setTranslateX(-201);
			}
			else {
				enemyCardPosition.setTranslateX(-50);
			}	
		
		return enemyCardPosition;
	}
	
	public void setPlayerCardGraphic(Card aCard, Button aButton) throws FileNotFoundException {
		aButton.setGraphic(setCardGraphic(aCard));
	}
	
	public Group setCardGraphic(Card aCard) throws FileNotFoundException {
		Image cardImage;
		
		if(aCard.getAttack() == 0) {
	    	cardImage = new Image(new FileInputStream("assets/SquirrelCard.png"));
	    }
	    else {
	    	cardImage = new Image(new FileInputStream("assets/AttackCard.png"));
	    }
	    ImageView card = new ImageView(cardImage);
	    
	    Label cardName = new Label(aCard.getName(), card);
	    Label cardCost = new Label(String.valueOf(aCard.getBlood()));
	    Label cardAttack = new Label(String.valueOf(aCard.getAttack()));
	    Label cardHealth = new Label(String.valueOf(aCard.getHealth()));

	    cardName.setContentDisplay(ContentDisplay.BOTTOM);
	    cardName.setFont(Font.font("Segue UI", FontWeight.BOLD, 18));
	    cardName.setGraphicTextGap(-50);
	    
	    cardCost.setLayoutX(20);
	    cardCost.setLayoutY(-16);
	    cardAttack.setLayoutX(20);
	    cardAttack.setLayoutY(102);
	    cardHealth.setLayoutX(75);
	    cardHealth.setLayoutY(102);

	    Group builtCard = new Group(card, cardName, cardCost, cardAttack, cardHealth);
	    
	    return builtCard;
	}
	
}
