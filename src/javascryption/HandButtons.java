<<<<<<< HEAD
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
	int cardPos;
	
	public HandButtons(BoardButtons someBoardButtons) {
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
    			boardButtons.setCardToCopy(handCard, cardPos);
    		}
    	});	
    }
	
	public Button getHandButton() {
		return CardInHand;
	}
	
	public Card getHandCard() {
		return handCard;
	}
	
	public void setCardPos(int aCardPos) {
		cardPos = aCardPos;
	}
	
}
=======
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
	int cardPos;
	
	public HandButtons(BoardButtons someBoardButtons) {
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
    			boardButtons.setCardToCopy(handCard, cardPos);
    		}
    	});	
    }
	
	public Button getHandButton() {
		return CardInHand;
	}
	
	public Card getHandCard() {
		return handCard;
	}
	
	public void setCardPos(int aCardPos) {
		cardPos = aCardPos;
	}
	
}
>>>>>>> refs/remotes/origin/creatingWinConditions
