package javascryption;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Main extends Application {
	
	private Stage primaryStage;
	private Scene deckScene;
	private Scene gameScene;
	private StackPane root = new StackPane();
	private Deck selectedDeck;
	private int cardPos;
	private Player player = new Player();
	private Player enemy = new Player();
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
    	
    	this.primaryStage = primaryStage;
    	createPrimaryStage();
    	primaryStage.show();
         
        AdditionalGraphics additionalGraphics = new AdditionalGraphics();
        Card card = new Card("Squirrel", 0, 1, 0);

        // REMOVE ME //
        
        Card card2 = new Card("Wolf", 2, 3, 2);
        // CardGraphicBuilder cardGraphic = new CardGraphicBuilder();


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
            		cardPos++;
            		//card2 should be replaced with a get next card from deck function
            		if(cardPos < player.getPlayerDeck().getSize()) {
            			hand.addCardToHand(player.getPlayerDeck().getCardByPosition(cardPos));
            		}
            		else {
            			JOptionPane.showMessageDialog(null, "You are out of cards!");
            		}
            		Deck.setDisable(true);
            		SquirrelDeck.setDisable(true);
            }
        });
        SquirrelDeck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
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
        
        Bell.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
        		Deck.setDisable(false);
        		SquirrelDeck.setDisable(false);
            	//Call battle function
        		boardButtons.guiPlayerAttacks();
        		int currentHealth = boardButtons.getBoardHealth();
        		additionalGraphics.updateScale(currentHealth);
        		
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
        		boardButtons.disableBoardButtons();
            }
        });
    }
    
    public void winMessage() {
    	JOptionPane.showMessageDialog(null, "You win. Click 'OK' to exit.");
    	System.exit(0);
    }
    
    public void loseMessage() {
    	JOptionPane.showMessageDialog(null, "You lose. Click 'OK' to exit.");
    	System.exit(0);
    }
    
    // used to test functionality of combo box 
    private void printChoice(ComboBox comboBox){
    	System.out.println(comboBox.getValue());
    }
    
    /*TODO
     * validate input, write input to a file, and call read deck
     */
    private boolean writeDeckFile()
    {
    	return false;
    }
    
    private Stage createPrimaryStage() {
    	//primaryStage =  new Stage(StageStyle.DECORATED);
    	primaryStage.setTitle("Javascryption");
    	
    	createGameScene();
    	deckScene = createDeckChoiceScene();
    	
    	primaryStage.setScene(deckScene);
    	
    	return primaryStage;
    }
    
    private Scene createGameScene() {
    	gameScene = new Scene(root,1200,750);
    	return gameScene;
    }
    private Scene createDeckChoiceScene() {
    	
        Button button = new Button("Submit");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Custom","Default");
        VBox layout = new VBox(10);
        TextField textField = new TextField("");
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(comboBox, textField, button);
        
        
        deckScene = new Scene(layout, 300, 250);
        comboBox.setPromptText("Select Deck");
        // update text of text field
        comboBox.addEventFilter(Event.ANY, e->textField.setText(comboBox.getSelectionModel().getSelectedItem()));
        // handle deck selection
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, e->selectDeck(comboBox.getSelectionModel().getSelectedIndex(), textField.getText()));
        // change the scene
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, e->primaryStage.setScene(gameScene));

        
    	return deckScene;
    }

    private void selectDeck(int choice, String uInput) {
    	try{
    		// write deck to file if default is not chosen
    		File file;
    		String path;
    		PrintWriter pWriter;
    		selectedDeck = new Deck();
    		
    		switch(choice){
    		case 0:{
    			file = new File("./CustomDeck.txt");
    			if(!file.exists()) {
    			file.createNewFile();
    			}
    			path = "./CustomDeck.txt";
    			pWriter = new PrintWriter(path);
    			handleCustomDeckInput(pWriter,uInput);
    			selectedDeck.readDeckFromFile(path);
    			pWriter.close();
    			break;
    			}
    		default:{
    			// read default file.
    			path = "./DefaultDeck.txt";
    			selectedDeck.readDeckFromFile(path);
    			}
    			break;
    			
    		}
    		player.setDeck(selectedDeck);
    		
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
    
    private void handleCustomDeckInput(PrintWriter pW, String uInput) {
		String[] splitText = uInput.split(",");
		// map the card library to a deck
		Deck cardLib = new Deck();
		cardLib.readDeckFromFile("./CardLibrary.txt");
		for(Card card : cardLib.getDeck()) {
				//TODO: validate user input
			for(String str : splitText) {
				if(str.trim().toLowerCase().equals(card.getName().trim().toLowerCase())) {
					pW.print(card.getName()+",");
					pW.print(card.getBlood()+",");
					pW.print(card.getHealth()+",");
					pW.print(card.getAttack()+"\n");
				}
			}
			
		}
    }
    
}
