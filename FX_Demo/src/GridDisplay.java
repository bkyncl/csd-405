
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GridDisplay {
    public static void display(String title) {

        //set variables for style presets
        String btnstyle = "-fx-color: white; -fx-border-color: blue;";
        String layoutstyle = "-fx-background-color: black;";
        String labelstyle = "-fx-color: black; -fx-text-fill: white;";
        Stage primaryStage = new Stage();
        

        //set static text label with white text, custom font set
        Label label1 = new Label("JavaFX GridPane Demo");
        label1.setStyle(labelstyle);
        label1.setFont(Font.font("Sans", FontWeight.BOLD,20));

        // Create buttons and set style
        Button btn = new Button("Submit");
        btn.setStyle(btnstyle);

        // set action to close for demo
        btn.setOnAction(e -> {
            primaryStage.close();
        });
     
        // Creating a gridpane and setting properties
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER); // center nodes in gridpane
        gridPane.setPadding(new Insets(10,10,10,10)); // Created inset border for padding
        // Hgap sets horizontal gap between nodes
        gridPane.setHgap(10);
        // Vgap set vertical gap between nodes
        gridPane.setVgap(15);

        // Adding nodes to GridPane in the form of Label and Textfield
        gridPane.add(new Label("First Name"), 0, 0);
        gridPane.add(new TextField(), 1, 0);
        gridPane.add(new Label("Last Name"), 0, 1);
        gridPane.add(new TextField(), 1, 1);
        gridPane.add(new Label("Phone Number"), 0, 2);
        gridPane.add(new TextField(), 1, 2);
        gridPane.add(new Label("Address"), 0, 3);
        gridPane.add(new TextField(), 1, 3);
        gridPane.add(btn, 1, 4);

        // Invoke static setHalignment to align elements positions within cell
        GridPane.setHalignment(btn, HPos.LEFT);
        // Loop through nodes to set label text to white and align right
        for (Node node : gridPane.getChildren()) {
            if (node instanceof Label) {
                Label label = (Label) node;
                label.setTextFill(Color.WHITE);
                GridPane.setHalignment(label, HPos.RIGHT);
            }
        }
        // Set styling for gridpane layout
        gridPane.setStyle(layoutstyle);

        // Create a VBox layout to Display Vertically label heading and gridpane
        VBox root = new VBox();
        root.getChildren().addAll(label1,gridPane);
        root.setAlignment(Pos.CENTER);
        // Set styling for root layout
        root.setStyle(layoutstyle);
        // Set the vertical spacing between children to 15px
        root.setSpacing(15);

        // Create a scene and add gridpane + Vbox (root) to it
        Scene scene = new Scene(root, 300, 350);

        // Set scene to stage
        primaryStage.setScene(scene);

        // Set the stage title
        primaryStage.setTitle(title);

        // Show stage
        primaryStage.show();
    }
}
