package com.opensup.testfx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.EventObject;

public class HelloController {
    @FXML
    private Label welcomeText;
    private EventObject event;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    protected void handleButtonAction() {
    //Get text from the button where the event happened
    String text = ((Button)event.getSource()).getText();
    welcomeText.setText(text);
    }

    @FXML
    protected void handleClearAction() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void handleEqualsAction() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}