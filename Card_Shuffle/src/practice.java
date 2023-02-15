import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class practice extends Application {
    // Override the start method of the Application class
  @Override
  public void start(Stage stage) {
 
    // Create a Rectangle node
    Rectangle rectangle = new Rectangle (0, 0, 100, 100);
    rectangle.setFill(Color.ORANGE);
 

    // Create a 2d line shape to be followed by the node
    Line line = new Line(40,40, 360, 360);

    // Create a PathTransition with the node and the path
    PathTransition pathTransition = new PathTransition();
    pathTransition.setDuration(Duration.millis(4000)); //Setting the duration for transition
    pathTransition.setPath(line);
    pathTransition.setNode(rectangle); 
    pathTransition.setCycleCount(Timeline.INDEFINITE);// This loops the animation
    pathTransition.setAutoReverse(true);// the boolean autoreverse allows animations to be reversed 
 
    
    
    // Start the animation
    pathTransition.play();
 
    // Create a Group node and add the node and the path to it
    Group group = new Group();
    group.getChildren().addAll(rectangle, line);
 
    // Create a Scene and add the group to it
    Scene scene = new Scene(group, 400, 400);
 
    // Set the title of the stage and show it
    stage.setTitle("JavaFX Path Transition");
    stage.setScene(scene);
    stage.show();
  }
 
  // Main method to launch the Application
  public static void main(String[] args) {
    launch(args);
  }
}