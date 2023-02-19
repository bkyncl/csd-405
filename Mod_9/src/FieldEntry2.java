/* FieldEntry2.java
* Module 9 Assignment 
* Name: Brittany Kyncl
* Date: 2.19.23
* Course: CSD405
* Example application of lambda expressions with changelistener expanded upon from FieldEntry1.java
*/

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FieldEntry2 extends Application{
    @Override
    public void start(Stage primaryStage) {
        // create text fields and buttons
        Text text1 = new Text("Enter Your Name");
        Text text2 = new Text("Enter Your Pin");
        Text text3 = new Text("Enter your Phone Number");
        
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();

        Button button = new Button("Submit");
        button.setDisable(true); // disable the button initially

        //Using a Lambda expression to implement new change listeners for each text field
        //Except this time we added the included functionality that all fields must be filled in correctly
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            boolean fieldsFilled = !textField.getText().isBlank() && !textField2.getText().isBlank() && !textField3.getText().isBlank();
            boolean fieldsNonNumeric = textField.getText().matches("^\\D+$"); 
            boolean fieldsNumeric = textField2.getText().matches("^\\d+$") && textField3.getText().matches("^\\d+$"); 
            button.setDisable(!(fieldsFilled && fieldsNumeric && fieldsNonNumeric));
        });
        
        textField2.textProperty().addListener((observable, oldValue, newValue) -> {
            boolean fieldsFilled = !textField.getText().isBlank() && !textField2.getText().isBlank() && !textField3.getText().isBlank();
            boolean fieldsNonNumeric = textField.getText().matches("^\\D+$"); 
            boolean fieldsNumeric = textField2.getText().matches("^\\d+$") && textField3.getText().matches("^\\d+$"); 
            button.setDisable(!(fieldsFilled && fieldsNumeric && fieldsNonNumeric));
        });
        
        textField3.textProperty().addListener((observable, oldValue, newValue) -> {
            boolean fieldsFilled = !textField.getText().isBlank() && !textField2.getText().isBlank() && !textField3.getText().isBlank();
            boolean fieldsNonNumeric = textField.getText().matches("^\\D+$"); 
            boolean fieldsNumeric = textField2.getText().matches("^\\d+$") && textField3.getText().matches("^\\d+$"); 
            button.setDisable(!(fieldsFilled && fieldsNumeric && fieldsNonNumeric));
        });

        /*This implemenation of ChangeListener defined as an inner class 
         only usable within the scope of the outer class*/
        ChangeListener<String> listener2 = new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                boolean fieldsFilled = !textField.getText().isBlank() && !textField2.getText().isBlank() && !textField3.getText().isBlank();
                boolean fieldsNonNumeric = textField.getText().matches("^\\D+$");
                boolean fieldsNumeric = textField2.getText().matches("^\\d+$") && textField3.getText().matches("^\\d+$");
                button.setDisable(!(fieldsFilled && fieldsNumeric && fieldsNonNumeric));
            }
        };

        /*This implemenation of ChangeListener is functionally equivalent to an inner class definition 
          but defined as an anonmyous class using a lambda expression. 
          More concise but only usable within the scope of the outer class*/
        ChangeListener<String> listener = (observable, oldValue, newValue) -> {
            boolean fieldsFilled = !textField.getText().isBlank() && !textField2.getText().isBlank() && !textField3.getText().isBlank();
            boolean fieldsNonNumeric = textField.getText().matches("^\\D+$"); 
            boolean fieldsNumeric = textField2.getText().matches("^\\d+$") && textField3.getText().matches("^\\d+$"); 
            button.setDisable(!(fieldsFilled && fieldsNumeric && fieldsNonNumeric)); 
        };

        /*Adding change listener to textfields*/ 
        textField.textProperty().addListener(listener);
        textField2.textProperty().addListener(listener);
        textField3.textProperty().addListener(listener);

        
        /*Adding InputHandler to textfields*/ 
        textField.textProperty().addListener(new InputHandler(button, textField, textField2, textField3));
        textField2.textProperty().addListener(new InputHandler(button, textField, textField2, textField3));
        textField3.textProperty().addListener(new InputHandler(button, textField, textField2, textField3));

        // add the text fields and button to a layout container
        VBox root = new VBox(5);
        root.getChildren().addAll(text1, textField, text2, textField2, text3, textField3, button);
       
        // create a scene and show the stage
        Scene scene = new Scene(root, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
/*Definine a named class 'InputHandler to implement the changelistener interface
* which overrides and defines an implementations for the changed method
* this implementation allows us to create multiple instances outside the scope of a class*/
class InputHandler implements ChangeListener<String> {

    private Button button;
    private TextField textField;
    private TextField textField2;
    private TextField textField3;

    public InputHandler(Button button, TextField textField, TextField textField2, TextField textField3) {
        this.button = button;
        this.textField = textField;
        this.textField2 = textField2;
        this.textField3 = textField3;
    }
    
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        boolean fieldsFilled = !textField.getText().isBlank() && !textField2.getText().isBlank() && !textField3.getText().isBlank();
        boolean fieldsNonNumeric = textField.getText().matches("^\\D+$"); 
        boolean fieldsNumeric = textField2.getText().matches("^\\d+$") && textField3.getText().matches("^\\d+$"); 
        button.setDisable(!(fieldsFilled && fieldsNumeric && fieldsNonNumeric)); 
    }
}

