package calcultimate.calcultimate;

import java.util.EventObject;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class CalculatorControler implements CalculatorControlerInterface{
    String accu;
    Modele m;
    public CalculatorControler() {
        accu = "";
        m = new Modele();
    }
    @Override
    public void change() {
        // convert string to double or int if its a int
        double d = Double.parseDouble(accu);
        // Convert to string
        m.push(d);
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
    private EventObject event;

    @FXML
    protected void press0() {
        accu += "1";
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
        accu += ".";
        screenText.setText(accu);
    }
    @FXML
    protected void pressplus() {
        m.add();
        accu = Double.toString(m.result());
        screenText.setText(accu);
    }
    @FXML
    protected void pressminus() {
        m.substract();
        accu = Double.toString(m.result());
        screenText.setText(accu);
    }
    @FXML
    protected void pressmult() {
        m.multiply();
        accu = Double.toString(m.result());
        screenText.setText(accu);
    }
    @FXML
    protected void pressC() {
        accu = "";
        m.clear();
        screenText.setText(accu);
    }
    @FXML
    protected void pressdivide() {
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
        if (accu.length() > 0) {
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
