package javascryption;
	
import java.io.FileNotFoundException;
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
        
        StackPane root = new StackPane();
        
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
        
        primaryStage.setScene(new Scene(root, 1200, 750));
        primaryStage.show();
    }
}
