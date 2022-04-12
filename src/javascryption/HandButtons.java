package javascryption;

import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class HandButtons {
	
	Button CardInHand = new Button();
	Card handCard = new Card();
	CardGraphicBuilder cardGraphic = new CardGraphicBuilder();
	
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
    			//cardGraphic.setPlayerCardGraphic(card, PlayerCardPosition2);

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
