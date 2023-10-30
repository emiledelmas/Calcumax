package calcultimate.view;

import calcultimate.controller.CalculatorControllerInterface;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.net.URL;
import java.util.Stack;

public class CalculatorGUI implements CalculatorGuiInterface {

    private String accu;
    private CalculatorControllerInterface controller;

    private TextField screenText;
    private TextField screenText1;
    private TextField screenText2;

    private LineChart<Number,Number> lineChart;
    private XYChart.Series<Number, Number> series;
    private boolean isGraphMode = false;

    private Button buttonCalc;
    private Button buttonGraph;
    private Button buttonSign;
    public CalculatorGUI(CalculatorControllerInterface controller) {
        accu = "";
        this.controller = controller;
        initializeBlinkAnimation();
    }
    private void initializeBlinkAnimation() {
    // Show the underscore by appending it to the text
    // Hide the underscore by displaying only the content of accu
    Button buttonSwitchMode = new Button("Switch Mode");
    buttonSwitchMode.setOnAction(event -> switchMode());
    Timeline blinkAnimation = new Timeline(new KeyFrame(Duration.seconds(0.5), new EventHandler<>() {
        private boolean isBlinkOn = true;

        @Override
        public void handle(ActionEvent event) {
//            If there is a _ at the end remove it :
            if (screenText.getText().endsWith("_")) {
                screenText.setText(screenText.getText().substring(0, screenText.getText().length() - 1));
            }

            if (isBlinkOn) {
                // Show the underscore by appending it to the text
                screenText.setText(screenText.getText()+ "_");
            } else {
                screenText.setText(screenText.getText());
            }
            isBlinkOn = !isBlinkOn;
        }
    }));
        blinkAnimation.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely
        blinkAnimation.play();
    }
    private void switchMode() {
        if(isGraphMode) {
            // Passer en mode calculatrice
            lineChart.setVisible(false);
            lineChart.setMinSize(0, 0);
            lineChart.setMaxSize(0, 0);
            screenText1.setVisible(true);
            screenText1.setMinSize(615, 55);
            screenText1.setMaxSize(615, 55);
            screenText2.setVisible(true);
            screenText2.setMinSize(615, 55);
            screenText2.setMaxSize(615, 55);
            buttonCalc.setStyle("-fx-background-color: #aaa");
            buttonGraph.setStyle("-fx-background-color: #353535");
            buttonSign.setText("+/-");
        } else {
            // Passer en mode graphique
            lineChart.setVisible(true);
            lineChart.setMinSize(640, 200);
            lineChart.setMaxSize(640, 200);
//            remove the white rectangle below the graph
            lineChart.autosize();
            screenText1.setVisible(false);
            screenText1.setMinSize(0, 0);
            screenText1.setMaxSize(0, 0);
            screenText2.setVisible(false);
            screenText2.setMinSize(0, 0);
            screenText2.setMaxSize(0, 0);
            buttonGraph.setStyle("-fx-background-color: #aaa");
            buttonCalc.setStyle("-fx-background-color: #353535");
            buttonSign.setText("x");

        }
        isGraphMode = !isGraphMode;
    }
    public Scene affiche() throws IOException {

        // Création des éléments de la fenêtre
        Label labelCalcultimate = new Label("Calcultimate");
        labelCalcultimate.getStyleClass().add("welcomeText");

        lineChart = new LineChart<>(new NumberAxis(), new NumberAxis());
        series = new XYChart.Series<>();
        lineChart.getData().add(series);


        screenText2 = new TextField();
        screenText2.getStyleClass().add("screenText");
        screenText2.setDisable(true);

        screenText1 = new TextField();
        screenText1.getStyleClass().add("screenText");
        screenText1.setDisable(true);

        screenText = new TextField();
        screenText.getStyleClass().add("screenText");
        screenText.setDisable(true);

        Button buttonC = new Button("C");
        buttonC.getStyleClass().add("clear-button");
        buttonC.setId("C");
        buttonC.setOnAction(event -> pressC());

        Button buttonBackspace = new Button("←");
        buttonBackspace.setId("backspace");
        buttonBackspace.setOnAction(event -> pressBackSpace());

        buttonCalc = new Button("Calculator");
        buttonCalc.setId("CalcBtn");
        buttonCalc.getStyleClass().add("modeButton");
        buttonCalc.setStyle("-fx-background-color: #aaa");
        buttonCalc.setOnAction(event -> switchMode());


        buttonGraph = new Button("Graph");
        buttonGraph.setId("GraphBtn");
        buttonGraph.getStyleClass().add("modeButton");
        buttonGraph.setOnAction(event -> switchMode());

        HBox hboxClear = new HBox(10);
        hboxClear.getChildren().addAll(buttonC, buttonCalc, buttonGraph,buttonBackspace);

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

        buttonSign = new Button("+/-");
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


        Button buttonEnter = new Button("Enter");
        buttonEnter.setId("enterBtn");
        buttonEnter.getStyleClass().add("enterButton");
        buttonEnter.setOnAction(event -> pressEnter());

        HBox hboxRow5 = new HBox(10);
        hboxRow5.getChildren().add(buttonEnter);



        // Création du conteneur principal et ajout des éléments
        VBox container = new VBox(10);
        container.setAlignment(Pos.CENTER);
        container.setSpacing(10);
        container.setPadding(new Insets(10));
        container.setStyle("-fx-font-size: 300%;-fx-background-color: #1D1D1D");
        container.getChildren().addAll(
                labelCalcultimate,
                lineChart,
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
        Scene scene = new Scene(container, 640, 900);
        KeyboardEventHandler keyboardEventHandler = new KeyboardEventHandler(container);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, keyboardEventHandler::handleKeyEvent);


        URL cssFile = getClass().getResource("style.css");
        if (cssFile != null) {
            scene.getStylesheets().add(cssFile.toExternalForm());
        } else {
            // Handle error if css file is not found
            System.err.println("CSS file not found, check the folder 'ressources'");
        }

        return scene;
    }
    public void change(Stack<Double> memory) {
        int memorySize = memory.size();
        screenText.clear();
        if (memorySize >= 2) {
            // If the stack has two or more elements, show the two first elements in the first and second TextField
            screenText1.setText(String.valueOf(memory.get(memorySize - 1)));
            screenText2.setText(String.valueOf(memory.get(memorySize - 2)));
        } else if (memorySize == 1) {
            // If the stack has one element, show the first element in the first TextField
            screenText1.setText(String.valueOf(memory.get(0)));
            screenText2.clear(); // Clear the second TextField
        } else {
            // If the stack is empty, clear the two first TextField
            screenText1.clear();
            screenText2.clear();
        }
    }

    public void changeControllerIfNotEmpty(){
        if (!accu.isEmpty()) {
            controller.change(accu);
            accu = "";
        }
    }
    // Handle number button presses
    private void handleNumberPress(String digit) {
        accu += digit;
        screenText.setText(accu);
    }


    //method for operations, dot, C, Enter, BackSpace and sign
    public void pressDot() {
        if (!accu.contains(".")) {
            accu += ".";
            screenText.setText(accu);
        }
    }

    public void pressPlus() {
        changeControllerIfNotEmpty();
        controller.add();
        accu = "";
        change(controller.getMemory());
    }

    public void pressMinus() {
        changeControllerIfNotEmpty();
        controller.minus();
        accu = "";
        change(controller.getMemory());
    }

    public void pressMult() {
        changeControllerIfNotEmpty();
        controller.multiply();
        accu = "";
        change(controller.getMemory());
    }

    public void pressC() {
        controller.clear();
        accu = "";
        screenText.setText("");
        screenText1.setText("");
        screenText2.setText("");
    }


    public void pressDivide() {
        changeControllerIfNotEmpty();
        try {
            controller.divide();
            change(controller.getMemory());
        } catch (ArithmeticException e) {
            change(controller.getMemory());
            screenText.setText("ERR : Division by 0");
        }
        accu = "";
    }

    public void pressEnter() {
        if(isGraphMode) {
            double xValue = Double.parseDouble(screenText1.getText());
            double yValue = Double.parseDouble(screenText2.getText());
            series.getData().add(new XYChart.Data<>(xValue, yValue));
        }
        else {
            changeControllerIfNotEmpty();
            change(controller.getMemory());
        }
    }

    public void pressBackSpace() {
        if (!accu.isEmpty()) {
            accu = accu.substring(0, accu.length() - 1); // Remove the last character of the accumulator
            screenText.setText(accu);
        }
    }

    //change the sign of the number in the screen

    public void pressSign() {
        if (!accu.isEmpty()) {
            if (accu.contains(".")) {
                double d = Double.parseDouble(accu);
                accu = Double.toString(-d);
            } else {
                int d = Integer.parseInt(accu);
                accu = Integer.toString(-d);
            }
            screenText.setText(accu);
        } else {
            controller.opposite();
            change(controller.getMemory());
        }
    }
}