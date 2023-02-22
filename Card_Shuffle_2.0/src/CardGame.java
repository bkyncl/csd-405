/* CardGame.java
* Module 10 Assignment 
* Name: Brittany Kyncl
* Date: 2.19.23
* Course: CSD405
* Card game utilizing JavaFX to display 1-5 randomly selected cards from deck
* A draw retreives user selected number (x) of card png files coorespinding to the first x ints from a shuffled arralylist.
* Each draw pulls from a newly shuffled arraylist meaning random selection of x cards displayed each.
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

//inherit JavaFX core functionality by extending Application
public class CardGame extends Application {

    // Setting style settings
    public static String layoutstyle = "-fx-background-color: #467D72;";
    public static String labelstyle = "-fx-font-family: 'Oswald'; -fx-font-size: 25pt; -fx-font-weight: BOLD; -fx-text-fill: white;";
    public static String labelstyle2 = "-fx-font-family: 'Oswald'; -fx-font-size: 10pt; -fx-font-weight: BOLD; -fx-text-fill: white;";
    public static String buttonstyle = "-fx-font-family: 'Oswald'; -fx-background-color: lightgrey; -fx-font-weight: BOLD; -fx-font-size: 10pt; -fx-pref-width: 120px; -fx-pref-height: 20px;";

    public static void main(String[] args) {
        Application.launch(CardGame.class,args);
    }
    @Override
    public void start(Stage primaryStage) {
 
        // create new animation to spin card image
        Animations deckspin = new Animations(new Image("cards/b1fv.png"));

        //Create new drop down menu for number of cards to draw
        ComboBox<String> menuBox = new ComboBox<String>();
        menuBox.getItems().addAll("1 Card", "2 Cards", "3 Cards", "4 Cards", "5 Cards");
        //set default value of card draw
        menuBox.getSelectionModel().select(3);
        // menuBox.setValue("4 Cards");
        menuBox.setStyle(buttonstyle);

        //Create buttons and labels
        Button btn1 = new Button("Draw");
        Button btn2 = new Button("Exit");
        //set btn style
        btn1.setStyle(buttonstyle);
        btn2.setStyle(buttonstyle);
        Label lbl = new Label("Draw 1-5 Cards");
        Label lbl2= new Label("Choose # of Cards:");
        //Settin labelg font and style
        lbl.setStyle(labelstyle);
        lbl2.setStyle(labelstyle2);
        //Creating gridpane layout for buttons and menu options
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        GridPane.setConstraints(lbl2, 0, 0);
        GridPane.setConstraints(menuBox, 1, 0);
        GridPane.setConstraints(btn1, 0, 1);
        GridPane.setConstraints(btn2, 1, 1);
        gridPane.getChildren().addAll(lbl2,menuBox,btn1, btn2);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle(layoutstyle);

        //Creating borderpane to organize and assign layout
        BorderPane borderpane = new BorderPane();
        BorderPane.setAlignment(lbl, Pos.CENTER);//set alignment within pane
        borderpane.setTop(lbl); //set child to borderpane section
        borderpane.setStyle(layoutstyle); //set layoutstyle
        borderpane.setCenter(deckspin.addRotatingImageView(7)); //set child to borderpane section
        borderpane.setBottom(gridPane); //set child to borderpane section
        borderpane.setPadding(new Insets(30,30,30,30)); //add padding

        // Add borderpane to the scene
        Scene scene = new Scene(borderpane, 400, 450);

        // Setting button actions
        btn1.setOnAction(e -> {//button action to display Card draw in new window
            int play = menuBox.getSelectionModel().getSelectedIndex()+1;//retreive number of cards to play from user menu selection
            //Send number of cards to play to draw
            boolean result = Draw.display("Card Draw",play);
            if(result == true) {//on menu return animation re-starts
                borderpane.setCenter(deckspin.addRotatingImageView(7));
            }
        });
        btn2.setOnAction(e -> primaryStage.close());

        //Set stage title
        primaryStage.setTitle("Random Card Draw");

        //Set the stage with the scene
        primaryStage.setScene(scene);

        // Show stage
        primaryStage.show();
    }
}
