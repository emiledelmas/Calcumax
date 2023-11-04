package calcultimate.view;

import calcultimate.controller.CalculatorControllerInterface;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.Stack;

/**
 * The CalculatorGUI class represents the graphical user interface of the calculator.
 */
public class CalculatorGUI implements CalculatorGuiInterface {

    private String accu;
    private final CalculatorControllerInterface controller;
    private TextField screenText;
    private TextField screenText1;
    private TextField screenText2;

    /**
     * Constructs a new CalculatorGUI with the provided controller and initializes the blinking animation.
     *
     * @param controller The calculator controller.
     */
    public CalculatorGUI(CalculatorControllerInterface controller) {
        accu = "";
        this.controller = controller;
        initializeBlinkAnimation();
    }

    /**
     * Initializes the blinking animation for the text field to indicate active input.
     */
    private void initializeBlinkAnimation() {
        // Initialize the blinking animation timeline
        Timeline blinkAnimation = new Timeline(new KeyFrame(Duration.seconds(0.5), new EventHandler<>() {

            private boolean isBlinkOn = true; // Toggle blink state

            @Override
            public void handle(ActionEvent event) {
                // Remove the blinking cursor if it is present
                if (screenText.getText().endsWith("_")) {
                    screenText.setText(screenText.getText().substring(0, screenText.getText().length() - 1));
                }
                // if isBlinkOn is true, add the blinking cursor to the screen text, else do nothing
                if (isBlinkOn) {
                    screenText.setText(screenText.getText() + "_");
                }
                // Change the blink state to the opposite
                isBlinkOn = !isBlinkOn;
            }
        }));

        // Set infinite cycle
        blinkAnimation.setCycleCount(Timeline.INDEFINITE);

        // Start animation
        blinkAnimation.play();
    }

    /**
     * Creates and returns the JavaFX scene representing the calculator GUI.
     *
     * @return The JavaFX Scene for the calculator.
     */
    public Scene affiche() {

        // Creation of the different elements of the calculator

        // title on the top
        Label labelCalcultimate = new Label("Calcultimate");
        labelCalcultimate.getStyleClass().add("welcomeText");

        // Third screen
        screenText2 = new TextField();
        screenText2.getStyleClass().add("screenText");
        screenText2.setDisable(true);

        // Second screen
        screenText1 = new TextField();
        screenText1.getStyleClass().add("screenText");
        screenText1.setDisable(true);

        // First screen
        screenText = new TextField();
        screenText.getStyleClass().add("screenText");
        screenText.setDisable(true);

        // Creation of the different buttons

        // Clear button
        Button buttonC = new Button("C");
        buttonC.getStyleClass().add("clear-button");
        buttonC.setId("C");
        buttonC.setOnAction(event -> pressC());

        // Backspace button
        Button buttonBackspace = new Button("←");
        buttonBackspace.setId("backspace");
        buttonBackspace.setOnAction(event -> pressBackSpace());

        // HBox for the clear and backspace buttons
        HBox hboxClear = new HBox(330);
        hboxClear.getChildren().addAll(buttonC, buttonBackspace);

        // Creation of the different rows of buttons

        // Row 1
        Button button7 = new Button("7");
        button7.setId("7");
        button7.setOnAction(event -> handleNumberPress("7"));

        Button button8 = new Button("8");
        button8.setId("8");
        button8.setOnAction(event -> handleNumberPress("8"));

        Button button9 = new Button("9");
        button9.setId("9");
        button9.setOnAction(event -> handleNumberPress("9"));

        Button buttonPlus = new Button("+");
        buttonPlus.setId("plus");
        buttonPlus.setOnAction(event -> pressPlus());

        HBox hboxRow1 = new HBox(10);
        hboxRow1.getChildren().addAll(button7, button8, button9, buttonPlus);

        // Row 2
        Button button4 = new Button("4");
        button4.setId("4");
        button4.setOnAction(event -> handleNumberPress("4"));

        Button button5 = new Button("5");
        button5.setId("5");
        button5.setOnAction(event -> handleNumberPress("5"));

        Button button6 = new Button("6");
        button6.setId("6");
        button6.setOnAction(event -> handleNumberPress("6"));

        Button buttonMinus = new Button("-");
        buttonMinus.setId("minus");
        buttonMinus.setOnAction(event -> pressMinus());

        HBox hboxRow2 = new HBox(10);
        hboxRow2.getChildren().addAll(button4, button5, button6, buttonMinus);

        // Row 3
        Button button1 = new Button("1");
        button1.setId("1");
        button1.setOnAction(event -> handleNumberPress("1"));

        Button button2 = new Button("2");
        button2.setId("2");
        button2.setOnAction(event -> handleNumberPress("2"));

        Button button3 = new Button("3");
        button3.setId("3");
        button3.setOnAction(event -> handleNumberPress("3"));

        Button buttonMultiply = new Button("×");
        buttonMultiply.setId("multiply");
        buttonMultiply.setOnAction(event -> pressMult());

        HBox hboxRow3 = new HBox(10);
        hboxRow3.getChildren().addAll(button1, button2, button3, buttonMultiply);

        // Row 4
        Button buttonSign = new Button("+/-");
        buttonSign.setId("opposite");
        buttonSign.setOnAction(event -> pressSign());

        Button button0 = new Button("0");
        button0.setId("0");
        button0.setOnAction(event -> handleNumberPress("0"));

        Button buttonDot = new Button(",");
        buttonDot.setId("dot");
        buttonDot.setOnAction(event -> pressDot());

        Button buttonDivide = new Button("/");
        buttonDivide.setId("divide");
        buttonDivide.setOnAction(event -> pressDivide());

        HBox hboxRow4 = new HBox(10);
        hboxRow4.getChildren().addAll(buttonSign, button0, buttonDot, buttonDivide);

        // Row 5
        Button buttonEnter = new Button("Enter");
        buttonEnter.setId("enterBtn");
        buttonEnter.getStyleClass().add("enterButton");
        buttonEnter.setOnAction(event -> pressEnter());

        HBox hboxRow5 = new HBox(10);
        hboxRow5.getChildren().add(buttonEnter);


        // Creation of the main container
        VBox container = new VBox(10);
        container.setAlignment(Pos.CENTER);
        container.setSpacing(10);
        container.setPadding(new Insets(10));
        container.setStyle("-fx-font-size: 300%;-fx-background-color: #1D1D1D");
        // Adding the different elements to the main container
        container.getChildren().addAll(
                labelCalcultimate,
                screenText2,
                screenText1,
                screenText,
                hboxClear,
                hboxRow1,
                hboxRow2,
                hboxRow3,
                hboxRow4,
                hboxRow5
        );

        // Creation of the scene
        Scene scene = new Scene(container, 640, 800);

        // Adding the keyboard event handler to the scene
        KeyboardEventHandler keyboardEventHandler = new KeyboardEventHandler(container);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler::handleKeyEvent);

        // Adding the css file to the scene
        URL cssFile = getClass().getResource("style.css");
        if (cssFile != null) {
            scene.getStylesheets().add(cssFile.toExternalForm());
        } else {
            // Handle error if css file is not found
            System.err.println("CSS file not found, check the folder 'ressources'");
        }

        // Return the scene
        return scene;
    }
    /**
     * Changes the displayed memory stack on the UI based on the provided memory stack.
     *
     * @param memory The memory stack to be displayed.
     */
    public void change(Stack<Double> memory) {
        // Get the size of the memory stack
        int memorySize = memory.size();
        // Clear the text fields
        screenText.clear();
        // if the memory stack is not empty, display the last two elements
        if (memorySize >= 2) {
            screenText1.setText(String.valueOf(memory.get(memorySize - 1)));
            screenText2.setText(String.valueOf(memory.get(memorySize - 2)));
        }
        else if (memorySize == 1) {
            screenText1.setText(String.valueOf(memory.get(0)));
            screenText2.clear();
        }
        else {
            screenText1.clear();
            screenText2.clear();
        }
    }

    /**
     * Changes the controller's input value if the accumulator is not empty.
     */
    public void changeControllerIfNotEmpty() {
        // If the accumulator is not empty, send the accumulator to the controller
        if (!accu.isEmpty()) {
            controller.change(accu);
            accu = "";
        }
    }

    /**
     * Handles number button press by appending digit to accumulator.
     *
     * @param digit The digit pressed
     */
    private void handleNumberPress(String digit) {
        // Append the digit to the accumulator
        accu += digit;
        screenText.setText(accu);
    }

    /**
     * Handles decimal point button press.
     */
    public void pressDot() {
        // Append the decimal point to the accumulator if it does not already contain one
        if (!accu.contains(".")) {
            accu += ".";
            screenText.setText(accu);
        }
    }

    /**
     * Handles plus button press.
     */
    public void pressPlus() {
        changeControllerIfNotEmpty();
        controller.add();
        accu = "";
        change(controller.getMemory());
    }

    /**
     * Handles minus button press.
     */
    public void pressMinus() {
        changeControllerIfNotEmpty();
        controller.minus();
        accu = "";
        change(controller.getMemory());
    }

    /**
     * Handles multiply button press.
     */
    public void pressMult() {
        changeControllerIfNotEmpty();
        controller.multiply();
        accu = "";
        change(controller.getMemory());
    }

    /**
     * Handles clear button press.
     */
    public void pressC() {
        // Clear the stack of the model, the accumulator and the text fields
        controller.clear();
        accu = "";
        screenText.setText("");
        screenText1.setText("");
        screenText2.setText("");
    }

    /**
     * Handles Divide button press.
     */
    public void pressDivide() {
        changeControllerIfNotEmpty();
        // Try to divide, if division by 0 is attempted, display an error message
        try {
            controller.divide();
            change(controller.getMemory());
        } catch (ArithmeticException e) {
            change(controller.getMemory());
            screenText.setText("ERR : Division by 0");
        }
        accu = "";
    }

    /**
     * Handles enter button press.
     */
    public void pressEnter() {
        changeControllerIfNotEmpty();
        change(controller.getMemory());
    }

    /**
     * Handles backspace button press.
     */
    public void pressBackSpace() {
        if (!accu.isEmpty()) {
            // Remove the last character of the accumulator
            accu = accu.substring(0, accu.length() - 1);
            screenText.setText(accu);
        }
    }

    /**
     * Handles sign change button press.
     */
    public void pressSign() {
        if (!accu.isEmpty()) {
            // if the accumulator contains a decimal point, parse it as a double, else parse it as an integer
            if (accu.contains(".")) {
                double d = Double.parseDouble(accu);
                accu = Double.toString(-d);
            } else {
                int d = Integer.parseInt(accu);
                accu = Integer.toString(-d);
            }
            // Display the new accumulator
            screenText.setText(accu);
        } else {
            // If the accumulator is empty, change the sign of the top value of the memory stack
            controller.opposite();
            change(controller.getMemory());
        }
    }
}
