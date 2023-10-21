package calcultimate.calcultimate;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class CalculatorControler implements CalculatorControlerInterface {
    private String accu;
    private final CalculatorModel m;

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
        // Show the underscore by appending it to the text
        // Hide the underscore by displaying only the content of accu
        Timeline blinkAnimation = new Timeline(
                new KeyFrame(Duration.seconds(0.5), new EventHandler<>() {
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

    public void showMemoryInScreen() {
        int memorySize = m.getMemorySize();
        screenText.clear();
        if (memorySize >= 2) {
            // If the stack has two or more elements, show the two first elements in the first and second TextField
            screenText1.setText(String.valueOf(m.memoryGetter(-1)));
            screenText2.setText(String.valueOf(m.memoryGetter(-2)));
        } else if (memorySize == 1) {
            // If the stack has one element, show the first element in the first TextField
            screenText1.setText(String.valueOf(m.memoryGetter(-1)));
            screenText2.clear(); // Clear the second TextField
        } else {
            // If the stack is empty, clear the two first TextField
            screenText1.clear();
            screenText2.clear();
        }
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
        showMemoryInScreen();
    }

    public void changeIfAccuIsNotEmpty() {
        if (!accu.isEmpty()) {
            change();
        }
    }


    // methods called by number buttons in the GUI
    @FXML
    protected void press0() {
        accu += "0"; // Concatenate the digit to the accumulator
        screenText.setText(accu); // Show the accumulator in the screen TextField
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


    //method for operations, dot, C, Enter, BackSpace and sign
    @FXML
    protected void pressdot() {
        if (!accu.contains(".")) {
            accu += ".";
            screenText.setText(accu);
        }
    }

    @FXML
    protected void pressplus() {
        changeIfAccuIsNotEmpty(); // If the accumulator is empty, addition can't be done
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
        System.out.println("enter"+accu);
        if (!accu.isEmpty()) { //If accumulator is empty, method change() doesn't need to be called
            change();
        }
    }

    @FXML
    protected void pressBackSpace() {
        if (!accu.isEmpty()) {
            accu = accu.substring(0, accu.length() - 1); // Remove the last character of the accumulator
            screenText.setText(accu);
        }
    }


    //change the sign of the number in the screen
    @FXML
    protected void presssign() {
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
            m.opposite();
            showMemoryInScreen();
        }
    }
}
