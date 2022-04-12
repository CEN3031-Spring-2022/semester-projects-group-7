package javascryption;

import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class HandButtons{
	
	Button CardInHand = new Button();
	Card handCard = new Card();
	CardGraphicBuilder cardGraphic = new CardGraphicBuilder();
	BoardButtons boardButtons;
	
	HandButtons(BoardButtons someBoardButtons) {
		boardButtons = someBoardButtons;
	}
	
	void addHandButton(Card card) {
		handCard = card;
		try {
			cardGraphic.setPlayerCardGraphic(card, CardInHand);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Action Listener ///////////////////////////////////////////
		
    	CardInHand.setOnAction(new EventHandler<ActionEvent>() {
    		@Override
    		public void handle(ActionEvent event) {
    			boardButtons.enableBoardButtons();
    		}
    	});	
    }
	
	Button getHandButton() {
		return CardInHand;
	}
	
	Card getHandCard() {
		return handCard;
	}
}
