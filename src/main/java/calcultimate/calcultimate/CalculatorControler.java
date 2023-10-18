package calcultimate.calcultimate;

import java.util.EventObject;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class CalculatorControler implements CalculatorControlerInterface{
    String accu;
    CalculatorModel m;
    public CalculatorControler() {
        accu = "";
        m = new CalculatorModel();
    }

    public void change() {
        // convert string to double or int if its a int
        double d = Double.parseDouble(accu);
        // Convert to string
        m.push(d);
        screenText1.setText(screenText2.getText());
        accu = "";
        screenText.setText(accu);

    }

    @Override
    public void change(List<Double> StackData) {

    }



    @FXML
    private Label welcomeText;

    @FXML
    private Label screenText;
    @FXML
    private Label screenText1;
    @FXML
    private Label screenText2;

    private EventObject event;

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
        accu = Double.toString(m.result());
        screenText.setText(accu);
    }
    @FXML
    protected void pressminus() {
        changeIfAccuIsNotEmpty();
        m.substract();
        accu = Double.toString(m.result());
        screenText.setText(accu);
    }
    @FXML
    protected void pressmult() {
        changeIfAccuIsNotEmpty();
        m.multiply();
        accu = Double.toString(m.result());
        screenText.setText(accu);
    }
    @FXML
    protected void pressC() {
        changeIfAccuIsNotEmpty();
        accu = "";
        m.clear();
        screenText.setText(accu);
    }
    @FXML
    protected void pressdivide() {
        changeIfAccuIsNotEmpty();
        m.divide();
        accu = Double.toString(m.result());
        screenText.setText(accu);
    }
    @FXML
    protected void pressEnter() {
        change();
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
        if (accu.contains(".")) {
            double d = Double.parseDouble(accu);
            accu = Double.toString(-d);
        }
        else{
            int d = Integer.parseInt(accu);
            accu = Integer.toString(-d);
        }
        screenText.setText(accu);
    }
}