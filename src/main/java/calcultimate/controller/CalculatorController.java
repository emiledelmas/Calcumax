package calcultimate.controller;

import calcultimate.model.CalculatorModelInterface;
import java.util.Stack;

public class CalculatorController implements CalculatorControllerInterface {

    private CalculatorModelInterface m;

    public CalculatorController(CalculatorModelInterface model) {
        m = model;
    }

    public void change(String accu) {
        double d;
        //Try to convert to double
        try {
            d = Double.parseDouble(accu);
            m.push(d);
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
    }

    public void add() {
        m.add();
    }

    public void minus() {
        m.subtract();
    }

    public void multiply() {
        m.multiply();
    }

    public void clear() {
        m.clear();
    }


    public void divide() {
        try {
            m.divide();
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Division by 0");
        }
    }

    //change the sign of the number in the screen
    public void opposite() {
            m.opposite();
    }

    public Stack<Double> getMemory() {
        return m.memoryGetter();
    }
}
