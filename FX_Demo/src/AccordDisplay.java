
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccordDisplay {
    public static void display(String title) {

        //set variables for style presets
        String btnstyle = "-fx-color: white; -fx-border-color: blue;";
        String layoutstyle = "-fx-background-color: black;";
        String labelstyle = "-fx-color: darkgrey; -fx-text-fill: Black;";

        Stage primaryStage = new Stage();
  
        //create TiltedPanes for Accordion to display
        // Create ListViews with ObservableLists of srtings as their items for display
        TitledPane pane1 = new TitledPane("Fruits" , new ListView<>(FXCollections.observableArrayList("Orange", "Banana", "Cherry")));
        TitledPane pane2 = new TitledPane("Animals"  , new ListView<>(FXCollections.observableArrayList("Duck", "Chicken", "Cow")));
        TitledPane pane3 = new TitledPane("Transport", new ListView<>(FXCollections.observableArrayList("Car", "Airplane", "Train")));

        // Create an Accordion
        Accordion accordion = new Accordion();

        // Set styling to accordion and Tilted panes
        accordion.setStyle(layoutstyle);
        pane1.setStyle(labelstyle);
        pane2.setStyle(labelstyle);
        pane3.setStyle(labelstyle);
        
        // Add the TitledPanes to the Accordion
        accordion.getPanes().addAll(pane1,pane2,pane3);
        
        // Create button and set action to close
        Button btn = new Button("Close");
        btn.setStyle(btnstyle);
        btn.setOnAction(e -> {
            primaryStage.close();
        });

        // Create a VBox layout for accordion display
        VBox toplayout = new VBox(50);
        toplayout.getChildren().addAll(accordion);
        toplayout.setAlignment(Pos.TOP_CENTER);// Position accordion top center of VBox

        // Create a separate VBox layout for close button
        VBox bottomlayout = new VBox();
        bottomlayout.getChildren().addAll(btn);
        bottomlayout.setAlignment(Pos.BOTTOM_CENTER);// Position button bottom center of VBox

        // Adding both VBox containers to root VBox
        VBox root = new VBox();
        root.getChildren().addAll(toplayout, bottomlayout);
        root.setStyle(layoutstyle);
        
        // Set the vertical spacing between children to 30px
        root.setSpacing(30);

        // Create a Scene and add the Accordion to it
        Scene scene = new Scene(root, 300,200);
        
        // Set the stage title
        primaryStage.setTitle(title);
        
        // Add the Scene to the Stage
        primaryStage.setScene(scene);
        
        // Show the Stage
        primaryStage.show();

        }
}
