/* Animations.java
* Module 8 Assignment 
* Name: Brittany Kyncl
* Date: 2.7.23
* Course: CSD405
* Card game utilizing JavaFX to display four random card images from a card deck.
* A draw retreives 4 card png files coorespinding to the first 4 ints from a shuffled arralylist.
* Each draw pulls from a newly shuffled arraylist meaning random selection of 4 cards displayed each.
*/
import javafx.util.Duration;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

class Animations { // Animations class to add animations to card images
    private Image image;

    // Animation object constructor
    public Animations(Image image) {
        this.image = image;
    }

    // Method to add rotate animation to object
    public StackPane addRotatingImageView(int num) {
        StackPane pane = new StackPane();
        for(int i=0; i<num;i++) {
            ImageView imageView = new ImageView(image);//Creating imagview for image
            imageView.setFitHeight(180);
            imageView.setFitWidth(100);
            RotateTransition rotate = new RotateTransition();
            rotate.setAxis(Rotate.Z_AXIS); //Determine rotate on Z axis
            rotate.setByAngle(20 * (i + 1)); //Angle of rotation with i to offset if looped animation
            rotate.setDuration(Duration.seconds(3));//Animation duration 5 seconds
            rotate.setNode(imageView);//Set imageview as node
            rotate.setAutoReverse(true);//Animation will reverse
            rotate.setCycleCount(3);// animation loop
            rotate.play();
            pane.getChildren().add(imageView);// Adding animated imageview to pane for display
            }
        return pane;
    }
    // Method to add sliding animation to object
    public Pane addSlidingImageView(int num) {
        Pane pane = new Pane();
        for(int i=0; i<num;i++) {
            ImageView imageView = new ImageView(image);//Creating imageview for image
            imageView.setFitHeight(148);
            imageView.setFitWidth(100);
            Line path = new Line(0,72,420 -(i*98),72);// Seting Line for animation path with i to offset multiple animations
            PathTransition pathTransition = new PathTransition();//Creating new pathtransition
            pathTransition.setDuration(Duration.seconds(1));// Setting animation duration
            pathTransition.setNode(imageView);// Set imageview as node
            pathTransition.setPath(path);// Ading line for animation path
            pathTransition.setAutoReverse(false);// no animation reverse
            pathTransition.setCycleCount(1);// animation loop
            pathTransition.play();
            pane.getChildren().add(imageView);// Adding animated imageview to pane for display
            }
        return pane;
    }
}
