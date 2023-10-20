package calcultimate.calcultimate;

import java.util.EventObject;
import java.util.List;
import java.util.Stack;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class CalculatorControler implements CalculatorControlerInterface{
    String accu;
    CalculatorModel m;

    private Timeline blinkAnimation;
    @FXML
    private Label welcomeText;

    @FXML
    private TextField screenText;
    @FXML
    private TextField screenText1;
    @FXML
    private TextField screenText2;
    public CalculatorControler() {
        accu = "";
        m = new CalculatorModel();
        initializeBlinkAnimation();
    }
    private void initializeBlinkAnimation() {
        blinkAnimation = new Timeline(
                new KeyFrame(Duration.seconds(0.5), new EventHandler<ActionEvent>() {
                    private boolean isBlinkOn = true;

                    @Override
                    public void handle(ActionEvent event) {
                        if (isBlinkOn) {
                            // Show the underscore by appending it to the text
                            screenText.setText(accu + "_");
                        } else {
                            // Hide the underscore by displaying only the content of accu
                            screenText.setText(accu);
                        }
                        isBlinkOn = !isBlinkOn;
                    }
                })
        );
        blinkAnimation.setCycleCount(Timeline.INDEFINITE); // Repeat indefinitely
        blinkAnimation.play();
    }
    public void showMemoryInScreen(){
        int memorySize = m.getMemorySize();
        if (memorySize >= 2) {
            // Si la pile a deux éléments, affichez-les dans les deux premiers TextField
            screenText.clear();
            screenText1.setText(String.valueOf(m.memoryGetter(-1)));
            screenText2.setText(String.valueOf(m.memoryGetter(-2)));
        } else if (memorySize == 1) {
            // Si la pile a un élément, affichez-le dans le premier TextField
            screenText1.clear();
            screenText1.setText(String.valueOf(m.memoryGetter(-1)));
            screenText2.clear(); // Effacez le troisième TextField
        } else {
            // Si la pile est vide, effacez tous les TextField
            screenText.clear();
            screenText1.clear();
            screenText2.clear();
        }
    }
    @Override
    public void change(String accu) {

    }

    @Override
    public void change(Stack<Double> StackData) {
    }

    public void change() {
        double d;
        //Try to convert to double
        try {
            d = Double.parseDouble(accu);
            m.push(d);
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
        // Convert to string
        accu = "";
        screenText.setText(accu);
        showMemoryInScreen();
    }

    public void change(List<Double> StackData) {

    }





    public void changeIfAccuIsNotEmpty() {
        if (accu != "") {
            change();
        }
    }

    @FXML
    protected void press0() {
        accu += "0";
        screenText.setText(accu);
    }
    @FXML
    protected void press1() {
        accu += "1";
        screenText.setText(accu);
    }
    @FXML
    protected void press2() {
        accu += "2";
        screenText.setText(accu);
    }
    @FXML
    protected void press3() {
        accu += "3";
        screenText.setText(accu);
    }
    @FXML
    protected void press4() {
        accu += "4";
        screenText.setText(accu);
    }
    @FXML
    protected void press5() {
        accu += "5";
        screenText.setText(accu);
    }
    @FXML
    protected void press6() {
        accu += "6";
        screenText.setText(accu);
    }
    @FXML
    protected void press7() {
        accu += "7";
        screenText.setText(accu);
    }
    @FXML
    protected void press8() {
        accu += "8";
        screenText.setText(accu);
    }
        @FXML
    protected void press9() {
        accu += "9";
        screenText.setText(accu);
    }
    @FXML
    protected void pressdot() {
        if (!accu.contains(".")) {
            accu += ".";
            screenText.setText(accu);
        }
    }
    @FXML
    protected void pressplus() {
        changeIfAccuIsNotEmpty();
        m.add();
        showMemoryInScreen();
        accu = "";
    }
    @FXML
    protected void pressminus() {
        changeIfAccuIsNotEmpty();
        m.substract();
        accu = "";
        showMemoryInScreen();
    }
    @FXML
    protected void pressmult() {
        changeIfAccuIsNotEmpty();
        m.multiply();
        accu = "";
        showMemoryInScreen();
    }
    @FXML
    protected void pressC() {
        m.clear();
        accu = "";
        screenText.clear();
        screenText1.clear();
        screenText2.clear();
    }
    @FXML
    protected void pressdivide() {
        changeIfAccuIsNotEmpty();
        m.divide();
        accu = "";
        showMemoryInScreen();
    }
    @FXML
    protected void pressEnter() {
        if (accu != "") {
            change();
        }
    }
    @FXML
    protected void pressBackSpace() {
        if (!accu.isEmpty()) {
            accu = accu.substring(0, accu.length() - 1);
            screenText.setText(accu);
        }
    }
    @FXML
    protected void presssign() {
        if (accu != "") {
        if (accu.contains(".")) {
            double d = Double.parseDouble(accu);
            accu = Double.toString(-d);
        } else {
            int d = Integer.parseInt(accu);
            accu = Integer.toString(-d);
        }
        screenText.setText(accu);
    }
        else {
            m.opposite();
            showMemoryInScreen();
            }

    }

}
