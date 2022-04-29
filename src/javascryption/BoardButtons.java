package javascryption;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;

public class BoardButtons {
	private Button PlayerCardPosition1 = new Button();
    private Button PlayerCardPosition2 = new Button();
    private Button PlayerCardPosition3 = new Button();
    private Button PlayerCardPosition4 = new Button();
    private Group boardButtonGroup = new Group();
    
    private Board board;
    private CardGraphicBuilder cardGraphic = new CardGraphicBuilder();
    private Card activeCard;
    private Hand hand;
    private AdditionalGraphics additionalGraphics;
    
    private int cardPos;
    private int bloodBank = 0;
    
    public BoardButtons(Board aBoard) {
    	board = aBoard;
    }
	
	public void makeBoardButtons() throws FileNotFoundException {
		additionalGraphics = new AdditionalGraphics();

	    additionalGraphics.setPlayerEmptySlotGraphics(PlayerCardPosition1);
	    additionalGraphics.setPlayerEmptySlotGraphics(PlayerCardPosition2);
	    additionalGraphics.setPlayerEmptySlotGraphics(PlayerCardPosition3);
	    additionalGraphics.setPlayerEmptySlotGraphics(PlayerCardPosition4);

	    disableBoardButtons();

	    //Action listeners ///////////////////////////////////////////////////////////////////////
	        
	    PlayerCardPosition1.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {	            	
	        	sacrificeOrPlaceCard(PlayerCardPosition1, 0);
	         }
	     });
	     PlayerCardPosition2.setOnAction(new EventHandler<ActionEvent>() {
	         @Override
	         public void handle(ActionEvent event) {
		        sacrificeOrPlaceCard(PlayerCardPosition2, 1);
	         }
	     });
	     PlayerCardPosition3.setOnAction(new EventHandler<ActionEvent>() {
	         @Override
	         public void handle(ActionEvent event) {
		        sacrificeOrPlaceCard(PlayerCardPosition3, 2);
	         }
	     });
	     PlayerCardPosition4.setOnAction(new EventHandler<ActionEvent>() {
	         @Override
	         public void handle(ActionEvent event) {
		        sacrificeOrPlaceCard(PlayerCardPosition4, 3);
	         }
	     });
	        
	     //Button size/position set ////////////////////////////////////////////////////
	        
	     PlayerCardPosition1.setTranslateX(-500);
	     PlayerCardPosition1.setPrefSize(100, 150);
	        
	     PlayerCardPosition2.setTranslateX(-350);
	     PlayerCardPosition2.setPrefSize(100, 150);
	        
	     PlayerCardPosition3.setTranslateX(-200);
	     PlayerCardPosition3.setPrefSize(100, 150);
	        
	     PlayerCardPosition4.setTranslateX(-50);
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
	
	private void sacrificeOrPlaceCard(Button aButton, int aPos) {
		try {
			if (activeCard != null) {
				if(board.getPlayerCardByPos(aPos) == null && bloodBank >= activeCard.getBlood()) {
					cardGraphic.setPlayerCardGraphic(activeCard, aButton);
					board.addPlayerCardtoBoard(activeCard, aPos);
					hand.removeCardbyPosition(cardPos);
					bloodBank = bloodBank - activeCard.getBlood();
					activeCard = null;
					}
					else if(board.getPlayerCardByPos(aPos) != null && bloodBank < activeCard.getBlood()) {
						additionalGraphics.setPlayerEmptySlotGraphics(aButton);
						board.removePlayerCardFromBoard(aPos);
						bloodBank++;
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				}
	}
	
	public void guiPlayerAttacks() { //returns current health of board
		board.playerAttack();
	}
	
	public void guiOpponentAttacks() { //returns current health of board
		board.opponentAttack();
	}
	
	public int getBoardHealth() {
		return board.getBoardHealth();
	}

	
	public void updatePlayerBoard() throws FileNotFoundException {
		if (board.getPlayerCardByPos(0) == null)
			additionalGraphics.setPlayerEmptySlotGraphics(PlayerCardPosition1);
		else
			cardGraphic.setPlayerCardGraphic(board.getPlayerCardByPos(0), PlayerCardPosition1);
		
		if (board.getPlayerCardByPos(1) == null)
			additionalGraphics.setPlayerEmptySlotGraphics(PlayerCardPosition2);
		else
			cardGraphic.setPlayerCardGraphic(board.getPlayerCardByPos(1), PlayerCardPosition2);
		
		if (board.getPlayerCardByPos(2) == null)
			additionalGraphics.setPlayerEmptySlotGraphics(PlayerCardPosition3);
		else
			cardGraphic.setPlayerCardGraphic(board.getPlayerCardByPos(2), PlayerCardPosition3);
		
		if (board.getPlayerCardByPos(3) == null)
			additionalGraphics.setPlayerEmptySlotGraphics(PlayerCardPosition4);
		else
			cardGraphic.setPlayerCardGraphic(board.getPlayerCardByPos(3), PlayerCardPosition4);
	}
	
	public void moveOpponentCardsUp() {
		board.moveOpponentCardsForward();
	}
	public ArrayList<Card> getFrontRowFromBoard(){
		return board.getFrontRow();
	}
	
	public ArrayList<Card> getPlayerRow(){
		return board.getPlayerBoard();
	}
	
	public ArrayList<Card> getSecondRowFromBoard(){
		return board.getSecondRow();
	}
	
	public void setNewBoard(Board newBoard) {
		board = newBoard;
	}

}
