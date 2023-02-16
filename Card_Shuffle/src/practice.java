import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class practice extends Application {
    // Override the start method of the Application class
  @Override
  public void start(Stage stage) {

    Stage primaryStage = new Stage();
 
    BorderPane pane = new BorderPane();

    pane.setTop(getHBox());
    pane.setLeft(getVBox());
    pane.setCenter(getPane());

    Rectangle r1 = new Rectangle(25,10,60,30);
    r1.setStroke(Color.BLUE);
    r1.setFill(Color.AZURE);

    Rectangle r2 = new Rectangle(25,10,60,30);
    r2.setStroke(Color.PURPLE);
    r2.setFill(Color.PALETURQUOISE);

    Rectangle r3 = new Rectangle(25,10,60,30);
    r3.setStroke(Color.ROSYBROWN);
    r3.setFill(Color.PEACHPUFF);

    Rectangle r4 = new Rectangle(25,10,60,30);
    r4.setStroke(Color.ORANGERED);
    r4.setFill(Color.ORCHID);

    Group group = new Group();
    group.getChildren().addAll(r1,r2,r3,r4);

    for (int i=0;i<5;i++) {
      Rectangle r = new Rectangle(100,50,100,30);

      r.setRotate(i * 360 /8);
      r.setStroke(Color.color(Math.random(),Math.random(),Math.random()));
      group.getChildren().add(r);
    }


    Scene scene = new Scene(group);
    primaryStage.setTitle("Practice");
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  private HBox getHBox() {

    HBox hbox = new HBox(15);
    hbox.setPadding(new Insets(15,15,15,15));
    hbox.setStyle("-fx-background-color: gold;");
    hbox.getChildren().add(new Button("Comp. Sci"));
    hbox.getChildren().add(new Button("Chemistry"));
    ImageView imageview = new ImageView(new Image("cards/46.png"));
    hbox.getChildren().add(imageview);

    return hbox;
  }

  private VBox getVBox() {
    
    VBox vbox = new VBox(15);
    vbox.setPadding(new Insets(15,15,15,15));
    vbox.setStyle("-fx-background-color: cyan;");
    vbox.getChildren().add(new Text(80,30,"List of Classes"));
    vbox.getChildren().add(new Text("CSD-200"));
    vbox.getChildren().add(new Text("CSD-300"));
    vbox.getChildren().add(new Text("CSD-350"));
    vbox.getChildren().add(new Text("CSD-400"));
    ImageView imageview = new ImageView(new Image("cards/41.png"));
    vbox.getChildren().add(imageview);

    return vbox;
  }
  private Pane getPane() {
    
    Pane pane = new Pane();

    Text txt1 = new Text(30,30, "Programming is fun 1");
    Text txt2 = new Text(80,80, "Programming is fun 2");
    Text txt3 = new Text(10,130, "Programming is fun 3");

    txt1.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.ITALIC, 15));
    txt2.setFont(Font.font("Times New Roman", FontWeight.LIGHT, 25));
    txt3.setFill(Color.RED);

    txt3.setUnderline(true);
    txt1.setStrikethrough(true);


    pane.setPadding(new Insets(15,15,15,15));
    pane.getChildren().addAll(txt1, txt2, txt3);

    return pane;
  }
 
  // Main method to launch the Application
  public static void main(String[] args) {
    launch(args);
  }
}