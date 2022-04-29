package javascryption;

import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class HandButtons{
	
	private Button CardInHand = new Button();
	private Card handCard = new NormalCard();
	private CardGraphicBuilder cardGraphic = new CardGraphicBuilder();
	private BoardButtons boardButtons;
	private int cardPos;

	
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
