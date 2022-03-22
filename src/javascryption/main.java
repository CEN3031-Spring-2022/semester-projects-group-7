package javascryption;
	
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
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Javascryption");
                
        //Buttons creation ///////////////////////////////////////////////////////////////////////
        
        Button PlayerCardPosition1 = new Button();
        Button PlayerCardPosition2 = new Button();
        Button PlayerCardPosition3 = new Button();
        Button PlayerCardPosition4 = new Button();
        Button Deck = new Button();
        Button SquirrelDeck = new Button();
        Button Bell = new Button();
        
        PlayerCardPosition1.setText("Position 1");
        PlayerCardPosition2.setText("Position 2");
        PlayerCardPosition3.setText("Position 3");
        PlayerCardPosition4.setText("Position 4");
        Deck.setText("Deck");
        SquirrelDeck.setText("Squirrel Deck");
        Bell.setText("Bell");

        //Action listeners ///////////////////////////////////////////////////////////////////////
        
        PlayerCardPosition1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	/* Check if card in hand selected
                 * if true, check if position is empty
                 * if not empty and sacrifice threshold not met, delete card in position
                 * if threshold met, copy selected card to position and delete from hand
                 */
            	System.out.println("Position 1 clicked!");
            }
        });
        PlayerCardPosition2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Position 2 clicked!");
            }
        });
        PlayerCardPosition3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Position 3 clicked!");
            }
        });
        PlayerCardPosition4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Position 4 clicked!");
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
        Deck.setTranslateY(75);
        Deck.setPrefSize(100, 150);
        
        SquirrelDeck.setTranslateX(425);
        SquirrelDeck.setTranslateY(75);
        SquirrelDeck.setPrefSize(100, 150);
        
        Bell.setTranslateX(350);
        Bell.setTranslateY(250);
        Bell.setPrefSize(100, 100);
                
        //Window Creation ////////////////////////////////////////////////////////////
        
        StackPane root = new StackPane();
        AdditionalGraphics additionalGraphics = new AdditionalGraphics();
        
        ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(700, 175);
        scroll.setVbarPolicy(ScrollBarPolicy.NEVER);
        scroll.setHbarPolicy(ScrollBarPolicy.ALWAYS);
                
        Group scrollPanel = new Group(scroll);
        scrollPanel.setTranslateX(-225);
        scrollPanel.setTranslateY(275);
        
        root.getChildren().add(PlayerCardPosition1);
        root.getChildren().add(PlayerCardPosition2);
        root.getChildren().add(PlayerCardPosition3);
        root.getChildren().add(PlayerCardPosition4);
        root.getChildren().add(Deck);
        root.getChildren().add(SquirrelDeck);
        root.getChildren().add(Bell);
        
        root.getChildren().add(additionalGraphics.setCardSlotGraphics());
        root.getChildren().add(additionalGraphics.scaleGraphics());
        root.getChildren().add(scrollPanel);

        primaryStage.setScene(new Scene(root, 1200, 750));
        primaryStage.show();
    }
}
