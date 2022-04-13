package javascryption;

import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;

public class BoardButtons {
	Button PlayerCardPosition1 = new Button();
    Button PlayerCardPosition2 = new Button();
    Button PlayerCardPosition3 = new Button();
    Button PlayerCardPosition4 = new Button();
    
    Group boardButtonGroup = new Group();
    
    Board board = new Board();
    CardGraphicBuilder cardGraphic = new CardGraphicBuilder();
    Card activeCard;
    Hand hand;
    int cardPos;
	
	public void makeBoardButtons() throws FileNotFoundException {
		AdditionalGraphics additionalGraphics = new AdditionalGraphics();

	    additionalGraphics.setPlayerEmptySlotGraphics(PlayerCardPosition1, PlayerCardPosition2, 
	        											  PlayerCardPosition3, PlayerCardPosition4);
	    disableBoardButtons();

	    //Action listeners ///////////////////////////////////////////////////////////////////////
	        
	    PlayerCardPosition1.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {	            	
				try {
					cardGraphic.setPlayerCardGraphic(activeCard, PlayerCardPosition1);
		            board.addPlayerCardtoBoard(activeCard, 0);
		            hand.removeCardbyPosition(cardPos);		            
					} catch (FileNotFoundException e) {
						e.printStackTrace();
						}
	         }
	     });
	     PlayerCardPosition2.setOnAction(new EventHandler<ActionEvent>() {
	         @Override
	         public void handle(ActionEvent event) {
	        	 try {
						cardGraphic.setPlayerCardGraphic(activeCard, PlayerCardPosition2);
			            board.addPlayerCardtoBoard(activeCard, 1);
			            hand.removeCardbyPosition(cardPos);		            
						} catch (FileNotFoundException e) {
							e.printStackTrace();
							}
	         }
	     });
	     PlayerCardPosition3.setOnAction(new EventHandler<ActionEvent>() {
	         @Override
	         public void handle(ActionEvent event) {
	        	 try {
						cardGraphic.setPlayerCardGraphic(activeCard, PlayerCardPosition3);
			            board.addPlayerCardtoBoard(activeCard, 2);
			            hand.removeCardbyPosition(cardPos);		            
						} catch (FileNotFoundException e) {
							e.printStackTrace();
							}

	         }
	     });
	     PlayerCardPosition4.setOnAction(new EventHandler<ActionEvent>() {
	         @Override
	         public void handle(ActionEvent event) {
	        	 try {
						cardGraphic.setPlayerCardGraphic(activeCard, PlayerCardPosition4);
			            board.addPlayerCardtoBoard(activeCard, 3);
			            hand.removeCardbyPosition(cardPos);		            
						} catch (FileNotFoundException e) {
							e.printStackTrace();
							}

	         }
	     });
	        
	     //Button size/position set ////////////////////////////////////////////////////
	        
	     PlayerCardPosition1.setTranslateX(-500);
	     PlayerCardPosition1.setTranslateY(75);        
	     PlayerCardPosition1.setPrefSize(100, 150);
	        
	     PlayerCardPosition2.setTranslateX(-350);
	     PlayerCardPosition2.setTranslateY(75);
	     PlayerCardPosition2.setPrefSize(100, 150);
	        
	     PlayerCardPosition3.setTranslateX(-200);
	     PlayerCardPosition3.setTranslateY(75);
	     PlayerCardPosition3.setPrefSize(100, 150);
	        
	     PlayerCardPosition4.setTranslateX(-50);
	     PlayerCardPosition4.setTranslateY(75);
	     PlayerCardPosition4.setPrefSize(100, 150);
	     
	     boardButtonGroup.getChildren().add(PlayerCardPosition1);
	     boardButtonGroup.getChildren().add(PlayerCardPosition2);
	     boardButtonGroup.getChildren().add(PlayerCardPosition3);
	     boardButtonGroup.getChildren().add(PlayerCardPosition4);
	}
	
	public void disableBoardButtons() {
		PlayerCardPosition1.setDisable(true);
		PlayerCardPosition2.setDisable(true);
		PlayerCardPosition3.setDisable(true);
		PlayerCardPosition4.setDisable(true);
	}
	
	public void enableBoardButtons() {
		PlayerCardPosition1.setDisable(false);
		PlayerCardPosition2.setDisable(false);
		PlayerCardPosition3.setDisable(false);
		PlayerCardPosition4.setDisable(false);
	}
	
	public Group getBoardButtons( ) {
		return boardButtonGroup;
	}
	
	public void setHandToModify(Hand aHand) {
		hand = aHand;
	}
	
	public void setCardToCopy(Card aCard, int aPos) {
		activeCard = aCard;
		cardPos = aPos;
	}

}
