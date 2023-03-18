import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


//inherit JavaFX core functionality by extending Application
public class JavaFXDemo extends Application {

    Scene scene1, scene2, scene3;

    public static void main(String[] args) {
        Application.launch(JavaFXDemo.class,args);
    }
    //override the abstract start method in the Application class
    @Override
    public void start(Stage primaryStage) {

        //set variables for style presets
        String btnstyle = "-fx-color: white; -fx-border-color: blue;";
        String layoutstyle = "-fx-background-color: black;";

        //create buttons and assign style
        Button btn1 = new Button("Go to ScrollPane Layout");
        btn1.setStyle(btnstyle);
        btn1.setMaxWidth(Double.MAX_VALUE);
        Button btn2 = new Button("Go to Accordion Layout");
        btn2.setStyle(btnstyle);
        btn2.setMaxWidth(Double.MAX_VALUE);
        Button btn3 = new Button("Go to GridPane Layout");
        btn3.setStyle(btnstyle);
        btn3.setMaxWidth(Double.MAX_VALUE);

        //determine event handler for when button is pressed using Lambda expression
        btn1.setOnAction(e -> {//button action to display box1
            ScrollDisplay.display("JavaFX ScrollPane Example");
        });

        btn2.setOnAction(e -> {//button action to display Accordion layout example
            AccordDisplay.display("JavaFX Accordion Example");
        });

        btn3.setOnAction(e -> {//button action do stiplay alertbox
            GridDisplay.display("JavaFX GridPane Example");
        });

        //set static text label with white text, custom font set
        Label label1 = new Label("JavaFX Layout Demo");
        label1.setTextFill(Color.WHITE);
        label1.setFont(Font.font("Sans", FontWeight.BOLD,20));

        //layout 1 using vbox to arrange nodes in vertical column
        VBox layout1 = new VBox(30);
        layout1.getChildren().addAll(label1,btn1,btn2,btn3);
        layout1.setStyle(layoutstyle);
        layout1.setAlignment(Pos.CENTER);//center nodes in vbox

        // Create a Scene and add layout1 to it
        scene1 = new Scene(layout1,250,400);

        // The Ellipse graphic is displayed in a stackpane as each loop is stacked on one another
        Graphic design = new Graphic();
        List<Ellipse> ellipses = design.paint();

        // Create stack pane to display stacked design
        StackPane pane = new StackPane();
        pane.setStyle(layoutstyle);
        pane.getChildren().addAll(ellipses);
    
        //Create Hbox to hold stackpane and layout1 separately
        HBox hbox = new HBox(pane,layout1);
        hbox.setStyle(layoutstyle);
        hbox.setMinSize(600, 400);
        hbox.setAlignment(Pos.CENTER); // center nodes in flowpane
        hbox.setSpacing(40);

        //Create a new scene with flowpane
        scene3 = new Scene(hbox,600,400);
        
        //Set the stage with scene
        primaryStage.setScene(scene3);

        //set title of stage
        primaryStage.setTitle("Primary Stage");

        //Show the Stage
        primaryStage.show();
    }
}
class Graphic {
    //This method creates a looped ellipse graphic object
    public List<Ellipse> paint() {
        List<Ellipse> ellipses = new ArrayList<>();
        for (int i = 0; i < 58; i++) {
            Ellipse ei = new Ellipse(140, 70);
            ei.setStroke(Color.color(Math.random(),Math.random(),Math.random()));
            ei.setRotate(i * 90 / 16);
            ellipses.add(ei);
        }
        return ellipses;
    }
}