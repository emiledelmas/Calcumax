package calcultimate.controller;

import calcultimate.model.CalculatorModelInterface;
import java.util.Stack;
/**
 * The CalculatorController class is responsible for controlling the interactions between
 * the user interface and the calculator model. It implements the CalculatorControllerInterface
 * to define the operations that can be performed on the calculator.
 *
 * @author Emile Delmas and Guillaume Demoor
 * @version 1.0
 */
public class CalculatorController implements CalculatorControllerInterface {

    private final CalculatorModelInterface m;

    /**
     * Constructs a new CalculatorController with the given calculator model.
     *
     * @param model The CalculatorModelInterface to be associated with this controller.
     */
    public CalculatorController(CalculatorModelInterface model) {
        m = model;
    }

    /**
     * Converts the given String to a double and pushes it onto the calculator's memory stack
     * handled by the model.
     *
     * @param accu The String to be converted to a double and pushed onto the memory stack.
     */
    public void change(String accu) {
        double d;
        // Try to convert to double
        try {
            d = Double.parseDouble(accu);
            // Push the new value onto the memory stack
            m.push(d);
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
        }
    }

    /**
     * Adds the current accumulated value to the calculator's memory stack.
     */
    public void add() {
        m.add();
    }

    /**
     * Subtracts the current accumulated value from the calculator's memory.
     */
    public void minus() {
        m.subtract();
    }

    /**
     * Multiplies the current accumulated value with the value in the calculator's memory.
     */
    public void multiply() {
        m.multiply();
    }

    /**
     * Clears the calculator's memory and accumulated value.
     */
    public void clear() {
        m.clear();
    }

    /**
     * Divides the value in the calculator's memory by the current accumulated value.
     *
     * @throws ArithmeticException if division by 0 is attempted.
     */
    public void divide() throws ArithmeticException {
        try {
            m.divide();
        } catch (ArithmeticException e) {
            // throw an exception if division by 0 is attempted
            throw new ArithmeticException("Division by 0");
        }
    }

    /**
     * Changes the sign of the current accumulated value on the screen.
     */
    public void opposite() {
        m.opposite();
    }

    /**
     * Retrieves the memory stack containing previously stored values.
     *
     * @return A Stack of Double values representing the calculator's memory.
     */
    public Stack<Double> getMemory() {
        return m.memoryGetter();
    }

    /**
     * Swaps the two top values of the memory stack.
     */
    public void swap() {
        m.swap();
    }


}
