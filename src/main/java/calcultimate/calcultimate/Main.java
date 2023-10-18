package calcultimate.calcultimate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.EventObject;

public class Main {

    @FXML
    private Label welcomeText;
    private static CalculatorGUI GUI = new CalculatorGUI();
    private CalculatorControler Controler;
    private CalculatorModel Model;

    //    Constructor
    public Main() {
        Controler = new CalculatorControler();
        Model = new CalculatorModel();
    }

    private String accu = "";

    public static void main(String[] args) {
        GUI.affiche();
    }

    public void changeIfAccuIsNotEmpty() {
        if (accu != "") {
            double d = Controler.change(accu);
            Model.push(d);
            accu = "";
        }
    }
    @FXML
    protected void press0() {
        accu += "0";
        GUI.change(accu);
    }
    @FXML
    protected void press1() {
        accu += "1";
        GUI.change(accu);
    }
    @FXML
    protected void press2() {
        accu += "2";
        GUI.change(accu);
    }
    @FXML
    protected void press3() {
        accu += "3";
        GUI.change(accu);
    }
    @FXML
    protected void press4() {
        accu += "4";
        GUI.change(accu);
    }
    @FXML
    protected void press5() {
        accu += "5";
        GUI.change(accu);
    }
    @FXML
    protected void press6() {
        accu += "6";
        GUI.change(accu);
    }
    @FXML
    protected void press7() {
        accu += "7";
        GUI.change(accu);
    }
    @FXML
    protected void press8() {
        accu += "8";
        GUI.change(accu);
    }
    @FXML
    protected void press9() {
        accu += "9";
        GUI.change(accu);
    }
    @FXML
    protected void pressdot() {
        if (!accu.contains(".")) {
            accu += ".";
            GUI.change(accu);
        }
    }
    @FXML
    protected void pressplus() {
        changeIfAccuIsNotEmpty();
        Model.add();
        String s = Controler.change(Model.getterMemory());
        GUI.change(s);
    }
    @FXML
    protected void pressminus() {
        changeIfAccuIsNotEmpty();
        Model.substract();
        String s = Controler.change(Model.getterMemory());
        GUI.change(s);
    }
    @FXML
    protected void pressmult() {
        changeIfAccuIsNotEmpty();
        Model.multiply();
        String s = Controler.change(Model.getterMemory());
        GUI.change(s);
    }
    @FXML
    protected void pressC() {
        changeIfAccuIsNotEmpty();
        accu = "";
        Model.clear();
        GUI.change(accu);
    }
    @FXML
    protected void pressdivide() {
        changeIfAccuIsNotEmpty();
        Model.divide();
        String s = Controler.change(Model.getterMemory());
        GUI.change(s);
    }
    @FXML
    protected void pressEnter() {
        if (accu != "") {
            double d = Controler.change(accu);
            Model.push(d);
            accu = "";
            String s = Controler.change(Model.getterMemory());
            GUI.change(s);
        }
    }
    @FXML
    protected void pressBackSpace() {
        if (!accu.isEmpty()) {
            accu = accu.substring(0, accu.length() - 1);
            GUI.change(accu);
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
        GUI.change(accu);
    }

}