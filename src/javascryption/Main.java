package javascryption;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.Group;
import javafx.scene.Scene;

public class Main extends Application {
	
	private Stage primaryStage;
	private Scene deckScene;
	private Scene gameScene;
	private StackPane root = new StackPane();
	private Deck selectedDeck;
	private int cardPos;
	private Player player = new Player();
	private BoardReader boardReader = new BoardReader();
	private BoardButtons boardButtons;
    CardGraphicBuilder cardGraphic = new CardGraphicBuilder();

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
    	
    	this.primaryStage = primaryStage;
    	//createDeckChoiceScene();
    	
    	createPrimaryStage();
    	primaryStage.show();
    	
         
        AdditionalGraphics additionalGraphics = new AdditionalGraphics();

        //Buttons creation ///////////////////////////////////////////////////////////////////////
        Button Deck = new Button();
        Button SquirrelDeck = new Button();
        Button Bell = new Button();

        //reading board input here
		//boardReader.readInputFile("Enemy_Boards/DefaultBoard.txt");		
		
		//passing read board to boardButtons
        boardButtons = new BoardButtons(boardReader.getBoard());
        boardButtons.makeBoardButtons();
  
        additionalGraphics.setAttackDeckGraphic(Deck);
        additionalGraphics.setSquirrelDeckGraphic(SquirrelDeck);
        additionalGraphics.setBellGraphic(Bell);
        
        Hand hand = new Hand(boardButtons);
        boardButtons.setHandToModify(hand);
        Group boardButtonsDisplay = new Group();
        boardButtonsDisplay.getChildren().add(boardButtons.getBoardButtons());
        
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
        Label gameLogIntro = new Label("Welcome to JavaScryption!");
	    gameLogIntro.setFont(Font.font("Segue UI", FontWeight.BOLD, 18));
        gameLogPanel.getChildren().add(gameLogIntro);
        
        root.getChildren().add(boardButtonsDisplay);
        root.getChildren().addAll(Deck);
        root.getChildren().add(SquirrelDeck);
        root.getChildren().add(Bell);
        
        root.getChildren().add(additionalGraphics.setCardSlotGraphics());
        additionalGraphics.initializeScaleGraphics();
        root.getChildren().add(additionalGraphics.getScale());
        root.getChildren().add(handPanel);
        root.getChildren().add(gameLogPanel);

        updateEnemyCards(root, cardGraphic, boardButtons);
        
        //Action listeners ///////////////////////////////////////////////////////////////////////        
        Deck.setOnAction(new EventHandler<ActionEvent>() { //when player deck button is pressed
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
        
        SquirrelDeck.setOnAction(new EventHandler<ActionEvent>() { //when squirrel deck is pressed
            @Override
            public void handle(ActionEvent event) {
            		Card card = new NormalCard("Squirrel", 0, 1, 0);
            		hand.addCardToHand(card);
            		Deck.setDisable(true);
            		SquirrelDeck.setDisable(true);
            }
        });
        
        Bell.setOnAction(new EventHandler<ActionEvent>() { //when bell is pressed
            @Override
            public void handle(ActionEvent event) {
            	boardButtons.moveOpponentCardsUp();
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
        		//board.addOpponentCardtoBoard(getEnemyCardToPlace(), 1);
        		boardButtons.guiOpponentAttacks();
        		currentHealth = boardButtons.getBoardHealth();
        		additionalGraphics.updateScale(currentHealth);
        		
        		if (currentHealth <= 0) {
        			loseMessage();
        		}
        		
        		//updates the player board and enemy cards here.
        		try {
					boardButtons.updatePlayerBoard();
					updateEnemyCards(root, cardGraphic, boardButtons);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
        		boardButtons.disableBoardButtons();
            }
        });
    }
    
    public void updateEnemyCards(StackPane root, CardGraphicBuilder cardGraphic, BoardButtons boardButtons) throws FileNotFoundException {
    	ArrayList<Card> frontRow = new ArrayList<Card>(boardButtons.getFrontRowFromBoard());
    	ArrayList<Card> secondRow = new ArrayList<Card>(boardButtons.getSecondRowFromBoard());
    	//get and display back row
    	for (int i = 0; i < 4; i++) {
    		if (secondRow.get(i) == null)
    			root.getChildren().add(cardGraphic.setEnemyCardEmpty(0, i));
    		else
    			root.getChildren().add(cardGraphic.setEnemyCardGraphicPositions(secondRow.get(i), 0, i));
    	}
    	
    	//get and display front row
    	for (int i = 0; i < 4; i++) {
    		if (frontRow.get(i) == null)
    			root.getChildren().add(cardGraphic.setEnemyCardEmpty(1, i));
    		else 
    			root.getChildren().add(cardGraphic.setEnemyCardGraphicPositions(frontRow.get(i), 1, i));
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
    
    private Stage createPrimaryStage() {
    	//primaryStage =  new Stage(StageStyle.DECORATED);
    	primaryStage.setTitle("Javascryption");

    	deckScene = createDeckChoiceScene();
    	primaryStage.setScene(deckScene);
    	
    	createGameScene();

    	return primaryStage;
    }
    
    private Scene createGameScene() {
    	gameScene = new Scene(root,1200,750);
    	return gameScene;
    }
    private Scene createDeckChoiceScene() {
    	
        Button button = new Button("Submit");
        ComboBox<String> userDeckComboBox = new ComboBox<>();
        userDeckComboBox.getItems().addAll("Custom","Default");
        VBox layout = new VBox(10);
        TextField userTextField = new TextField("");
        layout.setPadding(new Insets(20,20,20,20));
        
        ComboBox<String> enemyBoardBox = new ComboBox<>();
        File listOfBoards = new File("Enemy_Boards");
        String[] enemyBoards = listOfBoards.list();
       	enemyBoardBox.setItems(FXCollections.observableArrayList(enemyBoards));
       	enemyBoardBox.setPromptText("Select your opponent");
       	
        layout.getChildren().addAll(userDeckComboBox, userTextField, enemyBoardBox, button);
        
        deckScene = new Scene(layout, 300, 250);
        userDeckComboBox.setPromptText("Select User Deck");
        
        // update text of text field
        userDeckComboBox.addEventFilter(Event.ANY, e->userTextField.setText(userDeckComboBox.getSelectionModel().getSelectedItem()));
        
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, e->selectUserDeck(userDeckComboBox.getSelectionModel().getSelectedIndex(), userTextField.getText())); 
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, e->selectOpponentDeck(enemyBoardBox.getSelectionModel().getSelectedItem()));
        // change the scene
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, e->primaryStage.setScene(gameScene));
        
        //select the board you wish to fight against:
        
    	return deckScene;
    }
    
    private void selectOpponentDeck(String path) {
    	try {
    		if (path != null)
    			boardReader.readInputFile("Enemy_Boards/"+path);
    		else
    			boardReader.readInputFile("Enemy_Boards/DefaultBoard.txt");
    		
    		updateEnemyCards(root, cardGraphic, boardButtons);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    private void selectUserDeck(int choice, String uInput) {
    	try{
    		// write deck to file if default is not chosen
    		File file;
    		String path;
    		PrintWriter pWriter;
    		selectedDeck = new Deck();
    		
    		switch(choice){
    		case 0:{
    			file = new File("./CustomPlayerDeck.txt");
    			if(!file.exists()) {
    			file.createNewFile();
    			}
    			path = "./CustomPlayerDeck.txt";
    			pWriter = new PrintWriter(path);
    			handleCustomDeckInput(pWriter,uInput);
    			pWriter.close();
    			selectedDeck.readDeckFromFile(path);
    			break;
    			}
    		default:{
    			// read default file.
    			path = "./DefaultPlayerDeck.txt";
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
