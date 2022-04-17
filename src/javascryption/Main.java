package javascryption;
	
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
 
public class Main extends Application {
	
	private Stage primaryStage;
	private Scene deckScene;
	private Scene gameScene;
	private StackPane root;
	private Deck selectedDeck;
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
    	
    	this.primaryStage = primaryStage;
    	createPrimaryStage();
    	primaryStage.show();
         
        AdditionalGraphics additionalGraphics = new AdditionalGraphics();
        CardGraphicBuilder cardGraphic = new CardGraphicBuilder();

        
        
        // REMOVE ME //
        /*
        Card card = new Card("Squirrel", 0, 1, 0);
        Card card2 = new Card("Wolf", 2, 3, 2);
        Card card3 = new Card("Stoat", 1, 2, 1);
        */
        

        //Buttons creation ///////////////////////////////////////////////////////////////////////
        
        Button PlayerCardPosition1 = new Button();
        Button PlayerCardPosition2 = new Button();
        Button PlayerCardPosition3 = new Button();
        Button PlayerCardPosition4 = new Button();
        Button Deck = new Button();
        Button SquirrelDeck = new Button();
        Button Bell = new Button();
  
        additionalGraphics.setAttackDeckGraphic(Deck);
        additionalGraphics.setSquirrelDeckGraphic(SquirrelDeck);
        additionalGraphics.setPlayerEmptySlotGraphics(PlayerCardPosition1, PlayerCardPosition2, 
        											  PlayerCardPosition3, PlayerCardPosition4);
        Bell.setText("Bell");

        //Action listeners ///////////////////////////////////////////////////////////////////////
        
        PlayerCardPosition1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//TODO Copy card in board object, Sacrifice Card
            	
            	
            	//Set button graphic when pressed
            	/*
				try {
					cardGraphic.setPlayerCardGraphic(card, PlayerCardPosition1);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
            	 */
            }
        });
        PlayerCardPosition2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
				//cardGraphic.setPlayerCardGraphic(card, PlayerCardPosition2);

            }
        });
        PlayerCardPosition3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//cardGraphic.setPlayerCardGraphic(card, PlayerCardPosition3);

            }
        });
        PlayerCardPosition4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	//cardGraphic.setPlayerCardGraphic(card, PlayerCardPosition4);

            }
        });
        Deck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Add random card from deck into hand
            	System.out.println("Deck clicked!");
            }
        });
        SquirrelDeck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Add squirrel to hand
            	System.out.println("Squirrel Deck clicked!");
            }
        });
        Bell.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Call battle function
            	System.out.println("Bell clicked!");
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
        
        Deck.setTranslateX(275);
        Deck.setTranslateY(275);
        Deck.setPrefSize(100, 150);
        
        SquirrelDeck.setTranslateX(425);
        SquirrelDeck.setTranslateY(275);
        SquirrelDeck.setPrefSize(100, 150);
        
        Bell.setTranslateX(350);
        Bell.setTranslateY(120);
        Bell.setPrefSize(150, 100);
        
        //Window Creation ////////////////////////////////////////////////////////////
                
        ScrollPane handScroll = new ScrollPane();
        handScroll.setPrefSize(700, 175);
        handScroll.setVbarPolicy(ScrollBarPolicy.NEVER);
        handScroll.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        
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
        
        root.getChildren().add(PlayerCardPosition1);
        root.getChildren().add(PlayerCardPosition2);
        root.getChildren().add(PlayerCardPosition3);
        root.getChildren().add(PlayerCardPosition4);
        root.getChildren().addAll(Deck);
        root.getChildren().add(SquirrelDeck);
        root.getChildren().add(Bell);
        
        root.getChildren().add(additionalGraphics.setCardSlotGraphics());
        root.getChildren().add(additionalGraphics.scaleGraphics());
        root.getChildren().add(handPanel);
        root.getChildren().add(gameLogPanel);

        // REMOVE ME //
        /*
        root.getChildren().add(cardGraphic.setEnemyCardGraphicPositions(card2, 0, 0));
        root.getChildren().add(cardGraphic.setEnemyCardGraphicPositions(card3, 0, 2));
        root.getChildren().add(cardGraphic.setEnemyCardGraphicPositions(card, 2, 1));
        root.getChildren().add(cardGraphic.setEnemyCardGraphicPositions(card2, 3, 2));
		*/
                
        
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
    	root = new StackPane();
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
    		Player player = new Player();
    		Deck deckToSet = new Deck();
    		
    		switch(choice){
    		case 0:{
    			/*
    			file = new File("./CustomDeck.txt");
    			if(!file.exists()) {
    			file.createNewFile();
    			}*/
    			path = "./CustomDeck.txt";
    			pWriter = new PrintWriter(path);
    			handleCustomDeckInput(pWriter,uInput);
    			deckToSet.readDeckFromFile(path);
    			pWriter.close();
    			break;
    			}
    		default:{
    			// read default file.
    			path = "./DefaultDeck.txt";
    			deckToSet.readDeckFromFile(path);
    			}
    			break;
    			
    		}
    		player.setDeck(deckToSet);
    		
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
