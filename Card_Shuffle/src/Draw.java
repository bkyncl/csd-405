/* Draw.java
* Module 8 Assignment 
* Name: Brittany Kyncl
* Date: 2.7.23
* Course: CSD405
* Card game utilizing JavaFX to display four random card images from a card deck.
* A draw retreives 4 card png files coorespinding to the first 4 ints from a shuffled arralylist.
* Each draw pulls from a newly shuffled arraylist meaning random selection of 4 cards displayed each.
*/
import java.util.ArrayList;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Draw {// Draw class display 4 card draw animations and images

    //Create boolean for return to main menu
    static boolean answer;

    //Method to display newly created primary stage in new window
    public static boolean display(String title) {

        //final var for number of draw
        final int play = 4;

        // Creat card deck object
        CardDeck deck = new CardDeck();

        // Create the primary stage for Draw
        Stage primaryStage = new Stage();
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        Scene scene;

        // Create new buttons
        Button btn1 = new Button("Show Cards");
        Button btn2 = new Button("Back to Menu");
        Button btn3 = new Button("Draw Again");
        Button btn4 = new Button("Back to Menu");
        //Set buttons styling
        btn1.setStyle(CardGame.buttonstyle);
        btn2.setStyle(CardGame.buttonstyle);
        btn3.setStyle(CardGame.buttonstyle);
        btn4.setStyle(CardGame.buttonstyle);

        // Create horizontal layout for button first button set show/close
        HBox btnset1 = new HBox(20);
        btnset1.setAlignment(Pos.BOTTOM_CENTER);
        btnset1.getChildren().addAll(btn1,btn4);
        btnset1.setStyle(CardGame.layoutstyle);

        // Create horizontal layout for secon button set draw again/close
        HBox btnset2 = new HBox(20);
        btnset2.setAlignment(Pos.BOTTOM_CENTER);
        btnset2.getChildren().addAll(btn3,btn2);
        btnset2.setStyle(CardGame.layoutstyle);

        // Create vertical layout for 
        VBox root = new VBox(60);
        root.setAlignment(Pos.CENTER);
        // Adding child elements of buttons and card deal animation method
        root.getChildren().addAll(deck.cardDeal(CardGame.layoutstyle,play),btnset1);
        root.setStyle(CardGame.layoutstyle);

        // Create a Scene and add the ScrollPane to it
        scene = new Scene(root, 550, 350);

        // Set actions for buttons
        btn1.setOnAction(e -> {//button action to show card faces
 
            // Clear previous children elements from root
            root.getChildren().clear();
            // Adding new children elements to root
            root.getChildren().addAll(deck.pullCard(play), btnset2);

        });
        btn2.setOnAction(e -> {//button action to return to menu
            answer = true;
            primaryStage.close();
        });
        btn3.setOnAction(e -> {// button action to draw again
            // Clearing previous child emelents from root
            root.getChildren().clear();
            // Adding new child elements to root
            root.getChildren().addAll(deck.cardDeal(CardGame.layoutstyle,play), btnset1);// Adding carddeal animation and buttons
        });
        btn4.setOnAction(e -> {//button action to return to menu
            answer = true;
            primaryStage.close();
        });
        
        // Set the stage title
        primaryStage.setTitle(title);
        
        // Add the Scene to the Stage
        primaryStage.setScene(scene);
        
        // Show the Stage
        primaryStage.showAndWait();

        //return boolean value
        return answer;
    }
}
// Class for CardDeck and it's functinality
class CardDeck {
    //Creating arraylist of integer to represent card deck
    private ArrayList<Integer> cards;

    //Card Deck constructor initializing array with cards(ints) to 52
    public CardDeck() {
        this.cards = new ArrayList<>();
        for(int i=0; i < 52; i++) {
            cards.add(i+1);
        }
    }
    // Method to add card png file numbers to int array list and shuffle
    public  ArrayList<Integer> deckShuffle() {
        //Using shuffle method to shuffle card deck array
        java.util.Collections.shuffle(this.cards);
        //returing shuffled deck
        return cards;
    }
    // Method to return pane containing 4 card deal animation
    public Pane cardDeal(String layoutstyle, int num) {

        // create image of card from file location
        Image image = new Image("cards/b1fv.png");
        // create new cardslide animation parsing image and pane
        Animations cardslide = new Animations(image);
        //Create pane
        Pane pane = cardslide.addSlidingImageView(num);
        pane.setStyle(layoutstyle);// set layout style of pane
        
        return pane;
    }
    // Method to return hbox with pulled card(s) from shuffled deck array based on int i index location
    public HBox pullCard(int x) {
        // arraylist of re-shuffled numbers for deck of cards
        this.cards = deckShuffle();
        //Create hbox to display pulled cards
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        //Create new arraylist to hold returned cards
        ArrayList<ImageView> pulledCards = new ArrayList<ImageView>();
        for(int i=0; i<x;i++) {
            //getting card at parsed index
            ImageView card = new ImageView(new Image("cards/" + cards.get(i) + ".png"));
            card.setFitWidth(100);
            card.setFitHeight(148);
            pulledCards.add(card);
            
        }
        hbox.getChildren().addAll(pulledCards);
        return hbox;
    }
}
