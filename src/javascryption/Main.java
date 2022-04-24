package javascryption;
	
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.StackPane;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        primaryStage.setTitle("Javascryption");
        
        AdditionalGraphics additionalGraphics = new AdditionalGraphics();

        // REMOVE ME //
        
        Card card2 = new Card("Wolf", 2, 3, 2);
        CardGraphicBuilder cardGraphic = new CardGraphicBuilder();


        //Buttons creation ///////////////////////////////////////////////////////////////////////
        Button Deck = new Button();
        Button SquirrelDeck = new Button();
        Button Bell = new Button();
        BoardButtons boardButtons = new BoardButtons();
        boardButtons.makeBoardButtons();
  
        additionalGraphics.setAttackDeckGraphic(Deck);
        additionalGraphics.setSquirrelDeckGraphic(SquirrelDeck);
        Bell.setText("Bell");
        
        Hand hand = new Hand(boardButtons);
        boardButtons.setHandToModify(hand);
        Group boardButtonsDisplay = new Group();
        boardButtonsDisplay.getChildren().add(boardButtons.getBoardButtons());

        //Action listeners ///////////////////////////////////////////////////////////////////////
        
        Deck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            		//card2 should be replaced with a get next card from deck function
            		hand.addCardToHand(card2);
            		Deck.setDisable(true);
            		SquirrelDeck.setDisable(true);
            }
        });
        SquirrelDeck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            		Card card = new Card("Squirrel", 0, 1, 0);
            		hand.addCardToHand(card);
            		Deck.setDisable(true);
            		SquirrelDeck.setDisable(true);
            }
        });

        
        //Button size/position set ////////////////////////////////////////////////////
        
        Deck.setTranslateX(275);
        Deck.setTranslateY(275);
        Deck.setPrefSize(100, 150);
        
        SquirrelDeck.setTranslateX(425);
        SquirrelDeck.setTranslateY(275);
        SquirrelDeck.setPrefSize(100, 150);
        
        Bell.setTranslateX(350);
        Bell.setTranslateY(120);
        Bell.setPrefSize(150, 100);
        
        boardButtonsDisplay.setTranslateX(-276);
        boardButtonsDisplay.setTranslateY(68);
        
        //Window Creation ////////////////////////////////////////////////////////////
        
        StackPane root = new StackPane();
        
        ScrollPane handScroll = new ScrollPane();
        handScroll.setPrefSize(700, 175);
        handScroll.setVbarPolicy(ScrollBarPolicy.NEVER);
        handScroll.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        
        handScroll.setContent(hand.getHandHBox());
        
        ScrollPane gameLogScroll = new ScrollPane();
        gameLogScroll.setPrefSize(500, 200);
        gameLogScroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        gameLogScroll.setHbarPolicy(ScrollBarPolicy.NEVER);
        
        Group handPanel = new Group(handScroll);
        handPanel.setTranslateX(-225);
        handPanel.setTranslateY(275);
        
        Group gameLogPanel = new Group(gameLogScroll);
        gameLogPanel.setTranslateX(325);
        gameLogPanel.setTranslateY(-250);
        
        root.getChildren().add(boardButtonsDisplay);
        root.getChildren().addAll(Deck);
        root.getChildren().add(SquirrelDeck);
        root.getChildren().add(Bell);
        
        root.getChildren().add(additionalGraphics.setCardSlotGraphics());
        additionalGraphics.initializeScaleGraphics();
        root.getChildren().add(additionalGraphics.getScale());
        root.getChildren().add(handPanel);
        root.getChildren().add(gameLogPanel);

        // REMOVE ME //
        /*
        root.getChildren().add(cardGraphic.setEnemyCardGraphicPositions(card2, 0, 0));
        root.getChildren().add(cardGraphic.setEnemyCardGraphicPositions(card3, 0, 2));
        root.getChildren().add(cardGraphic.setEnemyCardGraphicPositions(card, 2, 1));
        root.getChildren().add(cardGraphic.setEnemyCardGraphicPositions(card2, 3, 2));
		*/
        
        primaryStage.setScene(new Scene(root, 1200, 750));
        primaryStage.show();
        
        Bell.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
        		Deck.setDisable(false);
        		SquirrelDeck.setDisable(false);
            	//Call battle function
        		boardButtons.guiPlayerAttacks();
        		int currentHealth = boardButtons.getBoardHealth();
        		additionalGraphics.updateScale(currentHealth);
        		//TESTING THIS
        		try {
					updateEnemyCards(root, cardGraphic, boardButtons);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        		if (currentHealth >= 10) {
        			winMessage();
        		}
        		
        		//we may want to find a way to cause a delay here.
        		//this could be confusing for the player.
        		boardButtons.guiOpponentAttacks();
        		currentHealth = boardButtons.getBoardHealth();
        		additionalGraphics.updateScale(currentHealth);
        		
        		if (currentHealth <= 0) {
        			loseMessage();
        		}
        		
        		//updates the player board here.
        		try {
					boardButtons.updatePlayerBoard();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
        		
        		boardButtons.moveOpponentCardsUp();
        		boardButtons.disableBoardButtons();
            }
        });
    }
    
    public void updateEnemyCards(StackPane root, CardGraphicBuilder cardGraphic, BoardButtons boardButtons) throws FileNotFoundException {
    	ArrayList<Card> frontRow = new ArrayList<Card>(boardButtons.getFrontRowFromBoard());
    	ArrayList<Card> secondRow = new ArrayList<Card>(boardButtons.getSecondRowFromBoard());
    	//add front row
    	for (int i = 0; i < 4; i++) {
    		if (frontRow.get(i) == null) {
    			root.getChildren().add(cardGraphic.setEnemyCardEmpty(1, i));
    		}
    		else {
    			root.getChildren().add(cardGraphic.setEnemyCardGraphicPositions(frontRow.get(i), 1, i));
    		}
    	}
    	
    	//add second row
    	for (int i = 0; i < 4; i++) {
    		if (secondRow.get(i) == null) {
    			root.getChildren().add(cardGraphic.setEnemyCardEmpty(0, i));
    		}
    		else {
    			root.getChildren().add(cardGraphic.setEnemyCardGraphicPositions(secondRow.get(i), 0, i));
    		}
    	}
    		
    }
    
    public void winMessage() {
    	JOptionPane.showMessageDialog(null, "You win!\nClick 'OK' to exit.");
    	System.exit(0);
    }
    
    public void loseMessage() {
    	JOptionPane.showMessageDialog(null, "You lose.\nClick 'OK' to exit.");
    	System.exit(0);
    }
}
