/* FieldEntry1.java
* Module 9 Assignment 
* Name: Brittany Kyncl
* Date: 2.19.23
* Course: CSD405
* Example application of lambda expressions with changelistener
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

public class FieldEntry1 extends Application {
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

        /*Defining changle listeners for texfields using anonymous inner classes
         to implement the changelistener interface. In this way we must define
         the class and overide the changed() method explicitly */ 
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                button.setDisable(!textField.getText().matches("^\\D+$"));
            }
        });
        textField2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                button.setDisable(!textField2.getText().matches("^\\d+$"));
            }
        });
        textField3.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                button.setDisable(!textField3.getText().matches("^\\d+$"));
            }
        });

        /*Using lambda expressions to define change listeners which is a shorthand
          of the above code. The lambdas define the body of the changed()
          without needing to define the class. The scope of both are limited
          to the local context of their definition but the lambda is more concise
          and flexible*/ 
        textField.textProperty().addListener((observable, oldValue, newValue) -> button.setDisable(!textField.getText().matches("^\\D+$")));
        textField2.textProperty().addListener((observable, oldValue, newValue) -> button.setDisable(!textField2.getText().matches("^\\d+$")));
        textField3.textProperty().addListener((observable, oldValue, newValue) -> button.setDisable(!textField3.getText().matches("^\\d+$")));

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
