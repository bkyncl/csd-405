import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class ScrollDisplay {
    public static void display(String title) {
        //set variables for style presets
        String layoutstyle = "-fx-background-color: black;";
        String labelstyle = "-fx-text-fill: white;";

        Stage primaryStage = new Stage();
        
        //set static text label with white text, custom font set
        Label label1 = new Label("JavaFX ScrollPane Demo");
        label1.setStyle(labelstyle);
        label1.setFont(Font.font("Sans", FontWeight.BOLD,20));

        // Create new Vbox
        VBox vbox = new VBox();
        // Add text nodes to the VBox
        label1.setAlignment(Pos.CENTER);;
        vbox.getChildren().add(label1);
        // Add list to vbox
        File file = new File("src/text.txt");
        try {
        List<String> lines = Files.readAllLines(file.toPath());
        for (String line : lines) {
            Label label = new Label(line);
            label.setStyle(labelstyle);
            vbox.getChildren().add(label);
        }
        } catch (IOException e) {
        System.err.println("Error reading file: " + e.getMessage());
        }

        // Set the vbox padding
        vbox.setPadding(new Insets(15,25,25,15));
        vbox.setStyle(layoutstyle);

        // Create scrollpane to hold vbox
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(vbox);
        scrollPane.setStyle(layoutstyle);

        // Create a Scene and add the ScrollPane to it
        Scene scene = new Scene(scrollPane, 350, 350);
        
        // Set the stage title
        primaryStage.setTitle(title);
        
        // Add the Scene to the Stage
        primaryStage.setScene(scene);
        
        // Show the Stage
        primaryStage.show();
    }
}
