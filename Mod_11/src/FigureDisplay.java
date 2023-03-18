/*FigureDisplay.java
* Module 11 Assignment 
* Name: Brittany Kyncl
* Date: 2.22.23
* Course: CSD405
* GUI application which display various shapes via radio button selection
* Check boxes control shape fill (randomly gen. color) shape stroke (black/blue/red)
* Strok color selected via radio buttons and shapes are re-sized to scale of slider component setting.
*/
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import java.util.Random;

public class FigureDisplay extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    private Circle circle = new Circle(100);
    private Rectangle rectangle = new Rectangle(200, 100);
    private Ellipse ellipse = new Ellipse(100, 50);
    private BorderPane root;
    private final Random random = new Random();
    private Shape currentshape = circle;
    private Color strokeColor = Color.BLACK;
    private boolean fill = false;
    private boolean stroke = true;

    @Override
    public void start(Stage stage) {
        
        // Create shape radio buttons and label
        Label heading = new Label("Shape Painter");
        heading.setId("heading");
        Label lbl = new Label("Select Shape");
        RadioButton circleRadioButton = new RadioButton("Circle");
        RadioButton rectangleRadioButton = new RadioButton("Rectangle");
        RadioButton ellipseRadioButton = new RadioButton("Ellipse");

        // Create toggle group for shape radio buttons
        ToggleGroup toggleGroup1 = new ToggleGroup();
        circleRadioButton.setToggleGroup(toggleGroup1);
        rectangleRadioButton.setToggleGroup(toggleGroup1);
        ellipseRadioButton.setToggleGroup(toggleGroup1);

        // Create check box for fill color and label
        Label lbl1 = new Label("Set Shape Fill");
        CheckBox fillCheckBox = new CheckBox("Fill");

        // Set event handler for fill check box
        fillCheckBox.setOnAction(e -> {
        if (root.getCenter() != null) {
            fill = fillCheckBox.isSelected();
            setFill(currentshape, fill);
        }
        });

        // Create ckeck box for stoke and label
        Label lbl2 = new Label("Set Stroke");
        CheckBox strokeCheckBox = new CheckBox("No Stroke");

        // Create radio button sfor stroke color and label
        Label lbl3 = new Label("Set Stroke Color");
        RadioButton strokeBlack = new RadioButton("Black");
        RadioButton strokeBlue = new RadioButton("Blue");
        RadioButton strokeRed = new RadioButton("Red");

        // Create toggle group for stroke radio buttons
        ToggleGroup toggleGroup2 = new ToggleGroup();
        strokeBlack.setToggleGroup(toggleGroup2);
        strokeBlack.setUserData(Color.BLACK);
        strokeBlue.setToggleGroup(toggleGroup2);
        strokeBlue.setUserData(Color.BLUE);
        strokeRed.setToggleGroup(toggleGroup2);
        strokeRed.setUserData(Color.RED);

        // Setting the handler method for all radio buttons in togglegroup2
        toggleGroup2.selectedToggleProperty().addListener((observableValue, oldToggle, newToggle) -> {
            if (newToggle != null) {
                RadioButton radioButton = (RadioButton) newToggle;
                strokeSelection(radioButton);
                strokeCheckBox.setSelected(false);
            }
        });

        //Set event handler for no stroke check box
        strokeCheckBox.setOnAction(e -> {
            stroke = strokeCheckBox.isSelected() ? false : true;
            strokeColor = strokeCheckBox.isSelected() ? null : strokeColor;
            setStroke(currentshape, strokeColor, stroke);
            toggleGroup2.selectToggle(stroke ? strokeBlack : null);
        });

        // Create slider for sizing shape
        Slider slider = new Slider(0, 2.5, 1); // Create a slider with range 0-2.5 and initial value 1
        slider.setId("slider");
        slider.setOrientation(Orientation.HORIZONTAL);
        slider.setPadding(new Insets(10));
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit(0.25f);
        slider.setBlockIncrement(0.1f);
        //Connecting slider functionality with each shape via listener to scale shape size to observable changes in slider object
        addSliderListenerToShape(slider, circle);
        addSliderListenerToShape(slider, rectangle);
        addSliderListenerToShape(slider, ellipse);

        // Create root border pane
        root = new BorderPane();
        root.setTop(heading);
        BorderPane.setAlignment(heading,Pos.CENTER);
        root.setLeft(createVBox(lbl, circleRadioButton, rectangleRadioButton, ellipseRadioButton));// Create VBox for shape radio buttons
        root.setRight(createVBox(lbl1, fillCheckBox, lbl2, strokeCheckBox, lbl3, strokeBlack, strokeBlue, strokeRed));// Create VBox fill and stroke options
        root.setBottom(slider);

        // Set event handlers for shape radio buttons
        circleRadioButton.setOnAction(e -> {
            displayShape(circle, fill, stroke);
        });
        rectangleRadioButton.setOnAction(e -> {
            displayShape(rectangle, fill, stroke);
        });
        ellipseRadioButton.setOnAction(e -> {
            displayShape(ellipse, fill, stroke);
        });

        // Set default selection for stroke
        strokeCheckBox.setSelected(false);
        strokeBlack.setSelected(true);

        // Set default selection for shape display
        circleRadioButton.setSelected(true);
        displayShape(circle, fill, stroke);

        // Create scene
        Scene scene = new Scene(root, 740, 640);
        // Add stylesheet styling
        scene.getStylesheets().add("style.css");

        // Set stage properties
        stage.setTitle("Figure Display");
        stage.setScene(scene);
        stage.show();
    }
    //Method to set shape object scale based on slider value
    private void addSliderListenerToShape(Slider slider, Shape shape) {
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            double scaleFactor = newValue.doubleValue(); // Get the new value of the slider
            shape.setScaleX(scaleFactor);// Set scale of current shape on x-axis
            shape.setScaleY(scaleFactor);// Set scale of current shape on y-axis
        });
    }
    //Method to retrun VBox with parsed nodes
    private VBox createVBox(Node... nodes) {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(10);
        vbox.getChildren().addAll(nodes);
        return vbox;
    }
    // Method to set stroke color based on radiobutton user data
    private void strokeSelection(RadioButton radioButton) {
        Color strokeColor = (Color) radioButton.getUserData();
        this.strokeColor = strokeColor;
        stroke = true;
        setStroke(currentshape, strokeColor, stroke);
    }
    // Method display a shape with current fill and stroke settings
    private void displayShape(Shape shape, boolean fill, boolean stroke) {
        setFill(shape, fill);
        setStroke(shape, strokeColor, stroke);
        root.setCenter(shape);
        currentshape = shape;
    }
    // Method to set fill/!fill with random color to parsed shape 
    private void setFill(Shape shape, boolean fill) {
        shape.setFill(fill ? Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256)) : Color.TRANSPARENT);
    }
    //Method to set stroke/!stroke with parsed color to parsed shape 
    private void setStroke(Shape shape, Paint color, boolean stroke) {
        shape.setStroke(stroke ? color : Color.TRANSPARENT);
        shape.setStrokeType(StrokeType.OUTSIDE);
        shape.setStrokeWidth(stroke ? 3 : 0);
    }
}