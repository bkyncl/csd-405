/* CardGame.java
* Module 8 Assignment 
* Name: Brittany Kyncl
* Date: 2.7.23
* Course: CSD405
* Card game utilizing JavaFX to display four random card images from a card deck.
* A draw retreives 4 card png files coorespinding to the first 4 ints from a shuffled arralylist.
* Each draw pulls from a newly shuffled arraylist meaning random selection of 4 cards displayed each.
*/
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

//inherit JavaFX core functionality by extending Application
public class CardGame extends Application {

    // Setting style settings
    public static String layoutstyle = "-fx-background-color: #467D72;";
    public static String labelstyle = "-fx-font-family: 'Oswald'; -fx-font-size: 25pt; -fx-font-weight: BOLD; -fx-text-fill: white;";
    public static String buttonstyle = "-fx-font-family: 'Oswald'; -fx-background-color: lightgrey; -fx-font-weight: BOLD; -fx-font-size: 10pt; -fx-pref-width: 120px; -fx-pref-height: 20px;";

    public static void main(String[] args) {
        Application.launch(CardGame.class,args);
    }
    @Override
    public void start(Stage primaryStage) {

        
        // create image of card
        Image image = new Image("cards/b1fv.png");
        // create new animation to spin card image
        Animations deckspin = new Animations(image);

        //Create buttons and labels
        Button btn = new Button("Draw");
        //set btn style
        btn.setStyle(buttonstyle);
        Label lbl = new Label("Click to Draw 4 Cards");
        //Settin labelg font and style
        lbl.setStyle(labelstyle);

        //Creating horizontal layout for button
        HBox hbox = new HBox();
        hbox.getChildren().add(btn);
        hbox.setAlignment(Pos.CENTER);
        hbox.setStyle(layoutstyle);

        //Creating borderpane to organize and assign layout
        BorderPane borderpane = new BorderPane();
        BorderPane.setAlignment(lbl, Pos.CENTER);//set alignment within pane
        borderpane.setTop(lbl); //set child to borderpane section
        borderpane.setStyle(layoutstyle); //set layoutstyle
        borderpane.setCenter(deckspin.addRotatingImageView(7)); //set child to borderpane section
        borderpane.setBottom(hbox); //set child to borderpane section
        borderpane.setPadding(new Insets(30,30,30,30)); //add padding

        // Add borderpane to the scene
        Scene scene = new Scene(borderpane, 400, 450);

        // Setting button actions
        btn.setOnAction(e -> {//button action to display Card draw in new window
            boolean result = Draw.display("Four Card Draw");
            if(result == true) {//on menu return animation re-starts
                borderpane.setCenter(deckspin.addRotatingImageView(7));
            }
        });

        //Set stage title
        primaryStage.setTitle("Random Card Draw");

        //Set the stage with the scene
        primaryStage.setScene(scene);

        // Show stage
        primaryStage.show();
    }
}
