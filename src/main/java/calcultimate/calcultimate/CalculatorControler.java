package calcultimate.calcultimate;

import java.util.EventObject;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class CalculatorControler implements CalculatorControlerInterface{
    String accu;

    public CalculatorControler() {
        accu = "";
    }
    @Override
    public void change(String accu) {
    }

    @Override
    public void change(List<Double> StackData) {

    }



    @FXML
    private Label welcomeText;

    @FXML
    private Label screenText;
    private EventObject event;

    @FXML
    protected void press0() {
        accu += "0";
        screenText.setText(accu);
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
